package com.autovw.burgermod.common.core;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.common.core.util.ModConsumables;
import com.autovw.burgermod.common.core.util.ModFood;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.Consumable;

/**
 * @author Autovw
 */
public final class ModItems
{
    // Meat + Egg Burgers
    public static final Item BEEF_BURGER = food("beef_burger", ModFood.BURGER_TIER_1);
    public static final Item PORK_BURGER = food("pork_burger", ModFood.BURGER_TIER_1);
    public static final Item MUTTON_BURGER = food("mutton_burger", ModFood.BURGER_TIER_2);
    public static final Item CHICKEN_BURGER = food("chicken_burger", ModFood.BURGER_TIER_3);

    // Fish + Egg Burgers
    public static final Item SALMON_BURGER = food("salmon_burger", ModFood.BURGER_TIER_4);
    public static final Item COD_BURGER = food("cod_burger", ModFood.BURGER_TIER_5);

    // Meat + Cheese Burgers
    public static final Item BEEF_CHEESE_BURGER = food("beef_cheese_burger", ModFood.BURGER_TIER_1);
    public static final Item PORK_CHEESE_BURGER = food("pork_cheese_burger", ModFood.BURGER_TIER_1);
    public static final Item MUTTON_CHEESE_BURGER = food("mutton_cheese_burger", ModFood.BURGER_TIER_2);
    public static final Item CHICKEN_CHEESE_BURGER = food("chicken_cheese_burger", ModFood.BURGER_TIER_3);

    // Fish + Cheese Burgers
    public static final Item SALMON_CHEESE_BURGER = food("salmon_cheese_burger", ModFood.BURGER_TIER_4);
    public static final Item COD_CHEESE_BURGER = food("cod_cheese_burger", ModFood.BURGER_TIER_5);

    // Meat + Champignons Burgers
    public static final Item BEEF_CHAMPIGNON_BURGER = food("beef_champignon_burger", ModFood.BURGER_TIER_1);
    public static final Item PORK_CHAMPIGNON_BURGER = food("pork_champignon_burger", ModFood.BURGER_TIER_1);
    public static final Item MUTTON_CHAMPIGNON_BURGER = food("mutton_champignon_burger", ModFood.BURGER_TIER_2);
    public static final Item CHICKEN_CHAMPIGNON_BURGER = food("chicken_champignon_burger", ModFood.BURGER_TIER_3);

    // Fish + Champignons Burgers
    public static final Item SALMON_CHAMPIGNON_BURGER = food("salmon_champignon_burger", ModFood.BURGER_TIER_4);
    public static final Item COD_CHAMPIGNON_BURGER = food("cod_champignon_burger", ModFood.BURGER_TIER_5);

    // Golden Burgers
    public static final Item GOLDEN_BEEF_BURGER = food("golden_beef_burger", ModFood.GOLDEN_BURGER_TIER_1, ModConsumables.GOLDEN_BURGER, Rarity.RARE);
    public static final Item GOLDEN_PORK_BURGER = food("golden_pork_burger", ModFood.GOLDEN_BURGER_TIER_1, ModConsumables.GOLDEN_BURGER, Rarity.RARE);
    public static final Item GOLDEN_MUTTON_BURGER = food("golden_mutton_burger", ModFood.GOLDEN_BURGER_TIER_2, ModConsumables.GOLDEN_BURGER, Rarity.RARE);
    public static final Item GOLDEN_CHICKEN_BURGER = food("golden_chicken_burger", ModFood.GOLDEN_BURGER_TIER_3, ModConsumables.GOLDEN_BURGER, Rarity.RARE);
    public static final Item GOLDEN_SALMON_BURGER = food("golden_salmon_burger", ModFood.GOLDEN_BURGER_TIER_2, ModConsumables.GOLDEN_BURGER, Rarity.RARE);
    public static final Item GOLDEN_COD_BURGER = food("golden_cod_burger", ModFood.GOLDEN_BURGER_TIER_4, ModConsumables.GOLDEN_BURGER, Rarity.RARE);

    // Enchanted Golden Burger
    public static final Item ENCHANTED_GOLDEN_BURGER = enchantedBurger("enchanted_golden_burger", ModFood.ENCHANTED_GOLDEN_BURGER);

    // Eggs
    public static final Item SCRAMBLED_EGG = food("scrambled_egg", ModFood.RAW_EGG_FOOD, ModConsumables.RAW_SCRAMBLED_EGG);
    public static final Item FRIED_SCRAMBLED_EGG = food("fried_scrambled_egg", ModFood.FRIED_EGG_FOOD);

    // Champignons
    public static final Item RAW_CHAMPIGNONS = food("raw_champignons", ModFood.RAW_CHAMPIGNONS_FOOD, ModConsumables.RAW_CHAMPIGNONS);
    public static final Item COOKED_CHAMPIGNONS = food("cooked_champignons", ModFood.INGREDIENT_FOOD);

    // Others
    public static final Item CHEESE = food("cheese", ModFood.INGREDIENT_FOOD);
    public static final Item COOKED_CHICKEN_NUGGET = food("cooked_chicken_nugget", ModFood.NUGGET_FOOD);
    public static final Item FRIES = food("fries", ModFood.FRIES_FOOD);
    public static final Item HOTDOG = food("hotdog", ModFood.HOTDOG_FOOD);
    public static final Item SWEET_BERRY_TART = food("sweet_berry_tart", ModFood.BERRY_TART_FOOD);

    private static Item food(String id, FoodProperties food)
    {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BurgerMod.MOD_ID, id));
        return new Item(new Item.Properties().food(food).setId(key));
    }

    private static Item food(String id, FoodProperties food, Consumable consumable)
    {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BurgerMod.MOD_ID, id));
        return new Item(new Item.Properties().food(food, consumable).setId(key));
    }

    private static Item food(String id, FoodProperties food, Consumable consumable, Rarity rarity)
    {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BurgerMod.MOD_ID, id));
        return new Item(new Item.Properties().food(food, consumable).rarity(rarity).setId(key));
    }

    private static Item enchantedBurger(String id, FoodProperties food)
    {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BurgerMod.MOD_ID, id));
        return new Item(new Item.Properties().food(food, ModConsumables.ENCHANTED_GOLDEN_BURGER).rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true).setId(key));
    }
}
