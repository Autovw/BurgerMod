package com.autovw.burgermod.common.core.util;

import com.autovw.burgermod.common.BurgerMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * @author Autovw
 */
public final class ModTags
{
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

    // "official" common tags
    public static final TagKey<Item> COMMON_INGOTS_GOLD = commonItemTag("ingots/gold");
    public static final TagKey<Item> COMMON_EGGS = commonItemTag("eggs");
    public static final TagKey<Item> COMMON_FOODS = commonItemTag("foods");
    public static final TagKey<Item> COMMON_FOODS_BREAD = commonItemTag("foods/bread");
    public static final TagKey<Item> COMMON_FOODS_GOLDEN = commonItemTag("foods/golden");
    public static final TagKey<Item> COMMON_FOODS_FOOD_POISONING = commonItemTag("foods/food_poisoning");
    // "unofficial" common tags
    public static final TagKey<Item> COMMON_NUGGETS_CHICKEN = commonItemTag("nuggets/chicken");
    public static final TagKey<Item> COMMON_FOODS_CHEESE = commonItemTag("foods/cheese");
    public static final TagKey<Item> COMMON_FOODS_FRIED_EGG = commonItemTag("foods/fried_egg");
    public static final TagKey<Item> COMMON_FOODS_COOKED_MUSHROOM = commonItemTag("foods/cooked_mushroom");

    // Forge tags (unofficial)
    @Deprecated
    public static final TagKey<Item> FORGE_INGOTS_GOLD = forgeItemTag("ingots/gold");
    @Deprecated
    public static final TagKey<Item> FORGE_EGGS = forgeItemTag("eggs");
    @Deprecated
    public static final TagKey<Item> FORGE_NUGGETS_CHICKEN = forgeItemTag("nuggets/chicken");
    @Deprecated
    public static final TagKey<Item> FORGE_CHEESE = forgeItemTag("cheese");
    @Deprecated
    public static final TagKey<Item> FORGE_FRIED_EGG = forgeItemTag("fried_egg");
    @Deprecated
    public static final TagKey<Item> FORGE_COOKED_MUSHROOM = forgeItemTag("cooked_mushroom");
    @Deprecated
    public static final TagKey<Item> FORGE_BREAD = forgeItemTag("bread");

    private static TagKey<Item> itemTag(String tagName)
    {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BurgerMod.MOD_ID, tagName));
    }

    private static TagKey<Item> commonItemTag(String tagLoc)
    {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", tagLoc));
    }

    @Deprecated
    private static TagKey<Item> forgeItemTag(String tagLoc)
    {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", tagLoc));
    }
}
