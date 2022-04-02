package com.autovw.burgermod.core;

import com.autovw.burgermod.BurgerMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * Author: Autovw
 */
public class ModTags {
    public static final TagKey<Item> BEEF_BURGERS = itemTag("beef_burgers");
    public static final TagKey<Item> BURGERS = itemTag("burgers");
    public static final TagKey<Item> CHAMPIGNON_BURGERS = itemTag("champignon_burgers");
    public static final TagKey<Item> CHEESE_BURGERS = itemTag("cheese_burgers");
    public static final TagKey<Item> CHICKEN_BURGERS = itemTag("chicken_burgers");
    public static final TagKey<Item> COD_BURGERS = itemTag("cod_burgers");
    public static final TagKey<Item> EGG_BURGERS = itemTag("egg_burgers");
    public static final TagKey<Item> GOLDEN_BURGERS = itemTag("golden_burgers");
    public static final TagKey<Item> MUTTON_BURGERS = itemTag("mutton_burgers");
    public static final TagKey<Item> PORK_BURGERS = itemTag("pork_burgers");
    public static final TagKey<Item> SALMON_BURGERS = itemTag("salmon_burgers");

    public static final TagKey<Item> FORGE_NUGGETS_CHICKEN = forgeItemTag("nuggets/chicken");
    public static final TagKey<Item> FORGE_CHEESE = forgeItemTag("cheese");
    public static final TagKey<Item> FORGE_FRIED_EGG = forgeItemTag("fried_egg");
    public static final TagKey<Item> FORGE_COOKED_MUSHROOM = forgeItemTag("cooked_mushroom");
    public static final TagKey<Item> FORGE_BREAD = forgeItemTag("bread");

    private static TagKey<Item> itemTag(String tagName) {
        return ItemTags.create(new ResourceLocation(BurgerMod.MOD_ID, tagName));
    }

    private static TagKey<Item> forgeItemTag(String tagLoc) {
        return ItemTags.create(new ResourceLocation("forge", tagLoc));
    }
}
