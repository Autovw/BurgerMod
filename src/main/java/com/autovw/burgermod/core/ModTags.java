package com.autovw.burgermod.core;

import com.autovw.burgermod.BurgerMod;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

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

    private static ITag.INamedTag<Item> itemTag(String tagName) {
        return ItemTags.bind(BurgerMod.MOD_ID + ":" + tagName);
    }
}
