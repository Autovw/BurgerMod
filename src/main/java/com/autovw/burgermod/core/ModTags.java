package com.autovw.burgermod.core;

import com.autovw.burgermod.BurgerMod;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;

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

    private static Tag.Named<Item> itemTag(String tagName) {
        return ItemTags.bind(BurgerMod.MOD_ID + ":" + tagName);
    }
}
