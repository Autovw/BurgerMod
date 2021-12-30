package com.autovw.burgermod.core;

import com.autovw.burgermod.BurgerMod;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

/**
 * Author: Autovw
 */
public class ModTags {
    public static final ITag.INamedTag<Item> BEEF_BURGERS = itemTag("beef_burgers");
    public static final ITag.INamedTag<Item> BURGERS = itemTag("burgers");
    public static final ITag.INamedTag<Item> CHAMPIGNON_BURGERS = itemTag("champignon_burgers");
    public static final ITag.INamedTag<Item> CHEESE_BURGERS = itemTag("cheese_burgers");
    public static final ITag.INamedTag<Item> CHICKEN_BURGERS = itemTag("chicken_burgers");
    public static final ITag.INamedTag<Item> COD_BURGERS = itemTag("cod_burgers");
    public static final ITag.INamedTag<Item> EGG_BURGERS = itemTag("egg_burgers");
    public static final ITag.INamedTag<Item> GOLDEN_BURGERS = itemTag("golden_burgers");
    public static final ITag.INamedTag<Item> MUTTON_BURGERS = itemTag("mutton_burgers");
    public static final ITag.INamedTag<Item> PORK_BURGERS = itemTag("pork_burgers");
    public static final ITag.INamedTag<Item> SALMON_BURGERS = itemTag("salmon_burgers");

    public static final Tags.IOptionalNamedTag<Item> FORGE_NUGGETS_CHICKEN = forgeItemTag("nuggets/chicken");
    public static final Tags.IOptionalNamedTag<Item> FORGE_CHEESE = forgeItemTag("cheese");
    public static final Tags.IOptionalNamedTag<Item> FORGE_FRIED_EGG = forgeItemTag("fried_egg");
    public static final Tags.IOptionalNamedTag<Item> FORGE_COOKED_MUSHROOM = forgeItemTag("cooked_mushroom");
    public static final Tags.IOptionalNamedTag<Item> FORGE_BREAD = forgeItemTag("bread");

    private static ITag.INamedTag<Item> itemTag(String tagName) {
        return ItemTags.bind(BurgerMod.MOD_ID + ":" + tagName);
    }

    private static Tags.IOptionalNamedTag<Item> forgeItemTag(String tagLoc) {
        return ItemTags.createOptional(new ResourceLocation("forge", tagLoc));
    }
}
