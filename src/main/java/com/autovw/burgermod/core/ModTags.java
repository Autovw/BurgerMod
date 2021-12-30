package com.autovw.burgermod.core;

import com.autovw.burgermod.BurgerMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

/**
 * Author: Autovw
 */
public class ModTags {
    public static final Tag.Named<Item> BEEF_BURGERS = itemTag("beef_burgers");
    public static final Tag.Named<Item> BURGERS = itemTag("burgers");
    public static final Tag.Named<Item> CHAMPIGNON_BURGERS = itemTag("champignon_burgers");
    public static final Tag.Named<Item> CHEESE_BURGERS = itemTag("cheese_burgers");
    public static final Tag.Named<Item> CHICKEN_BURGERS = itemTag("chicken_burgers");
    public static final Tag.Named<Item> COD_BURGERS = itemTag("cod_burgers");
    public static final Tag.Named<Item> EGG_BURGERS = itemTag("egg_burgers");
    public static final Tag.Named<Item> GOLDEN_BURGERS = itemTag("golden_burgers");
    public static final Tag.Named<Item> MUTTON_BURGERS = itemTag("mutton_burgers");
    public static final Tag.Named<Item> PORK_BURGERS = itemTag("pork_burgers");
    public static final Tag.Named<Item> SALMON_BURGERS = itemTag("salmon_burgers");

    public static final Tags.IOptionalNamedTag<Item> FORGE_NUGGETS_CHICKEN = forgeItemTag("nuggets/chicken");
    public static final Tags.IOptionalNamedTag<Item> FORGE_CHEESE = forgeItemTag("cheese");
    public static final Tags.IOptionalNamedTag<Item> FORGE_FRIED_EGG = forgeItemTag("fried_egg");
    public static final Tags.IOptionalNamedTag<Item> FORGE_COOKED_MUSHROOM = forgeItemTag("cooked_mushroom");
    public static final Tags.IOptionalNamedTag<Item> FORGE_BREAD = forgeItemTag("bread");

    private static Tag.Named<Item> itemTag(String tagName) {
        return ItemTags.bind(BurgerMod.MOD_ID + ":" + tagName);
    }

    private static Tags.IOptionalNamedTag<Item> forgeItemTag(String tagLoc) {
        return ItemTags.createOptional(new ResourceLocation("forge", tagLoc));
    }
}
