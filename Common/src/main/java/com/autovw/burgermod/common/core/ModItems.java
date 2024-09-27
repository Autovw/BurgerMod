package com.autovw.burgermod.common.core;

import com.autovw.burgermod.common.core.util.ModFood;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

/**
 * @author Autovw
 */
public final class ModItems
{
    // Meat + Egg Burgers
    public static final Item BEEF_BURGER = food(ModFood.BURGER_TIER_1);
    public static final Item PORK_BURGER = food(ModFood.BURGER_TIER_1);
    public static final Item MUTTON_BURGER = food(ModFood.BURGER_TIER_2);
    public static final Item CHICKEN_BURGER = food(ModFood.BURGER_TIER_3);

    // Fish + Egg Burgers
    public static final Item SALMON_BURGER = food(ModFood.BURGER_TIER_4);
    public static final Item COD_BURGER = food(ModFood.BURGER_TIER_5);

    // Meat + Cheese Burgers
    public static final Item BEEF_CHEESE_BURGER = food(ModFood.BURGER_TIER_1);
    public static final Item PORK_CHEESE_BURGER = food(ModFood.BURGER_TIER_1);
    public static final Item MUTTON_CHEESE_BURGER = food(ModFood.BURGER_TIER_2);
    public static final Item CHICKEN_CHEESE_BURGER = food(ModFood.BURGER_TIER_3);

    // Fish + Cheese Burgers
    public static final Item SALMON_CHEESE_BURGER = food(ModFood.BURGER_TIER_4);
    public static final Item COD_CHEESE_BURGER = food(ModFood.BURGER_TIER_5);

    // Meat + Champignons Burgers
    public static final Item BEEF_CHAMPIGNON_BURGER = food(ModFood.BURGER_TIER_1);
    public static final Item PORK_CHAMPIGNON_BURGER = food(ModFood.BURGER_TIER_1);
    public static final Item MUTTON_CHAMPIGNON_BURGER = food(ModFood.BURGER_TIER_2);
    public static final Item CHICKEN_CHAMPIGNON_BURGER = food(ModFood.BURGER_TIER_3);

    // Fish + Champignons Burgers
    public static final Item SALMON_CHAMPIGNON_BURGER = food(ModFood.BURGER_TIER_4);
    public static final Item COD_CHAMPIGNON_BURGER = food(ModFood.BURGER_TIER_5);

    // Golden Burgers
    public static final Item GOLDEN_BEEF_BURGER = food(ModFood.GOLDEN_BURGER_TIER_1, Rarity.RARE);
    public static final Item GOLDEN_PORK_BURGER = food(ModFood.GOLDEN_BURGER_TIER_1, Rarity.RARE);
    public static final Item GOLDEN_MUTTON_BURGER = food(ModFood.GOLDEN_BURGER_TIER_2, Rarity.RARE);
    public static final Item GOLDEN_CHICKEN_BURGER = food(ModFood.GOLDEN_BURGER_TIER_3, Rarity.RARE);
    public static final Item GOLDEN_SALMON_BURGER = food(ModFood.GOLDEN_BURGER_TIER_2, Rarity.RARE);
    public static final Item GOLDEN_COD_BURGER = food(ModFood.GOLDEN_BURGER_TIER_4, Rarity.RARE);

    // Enchanted Golden Burger
    public static final Item ENCHANTED_GOLDEN_BURGER = enchantedBurger(ModFood.ENCHANTED_GOLDEN_BURGER);

    // Eggs
    public static final Item SCRAMBLED_EGG = food(ModFood.RAW_EGG_FOOD);
    public static final Item FRIED_SCRAMBLED_EGG = food(ModFood.FRIED_EGG_FOOD);

    // Champignons
    public static final Item RAW_CHAMPIGNONS = food(ModFood.RAW_CHAMPIGNONS_FOOD);
    public static final Item COOKED_CHAMPIGNONS = food(ModFood.INGREDIENT_FOOD);

    // Others
    public static final Item CHEESE = food(ModFood.INGREDIENT_FOOD);
    public static final Item COOKED_CHICKEN_NUGGET = food(ModFood.NUGGET_FOOD);
    public static final Item FRIES = food(ModFood.FRIES_FOOD);
    public static final Item HOTDOG = food(ModFood.HOTDOG_FOOD);
    public static final Item SWEET_BERRY_TART = food(ModFood.BERRY_TART_FOOD);

    private static Item food(FoodProperties food)
    {
        return new Item(new Item.Properties().food(food));
    }

    private static Item food(FoodProperties food, Rarity rarity)
    {
        return new Item(new Item.Properties().food(food).rarity(rarity));
    }

    private static Item enchantedBurger(FoodProperties food)
    {
        return new Item(new Item.Properties().food(food).rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    }
}
