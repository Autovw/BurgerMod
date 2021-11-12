package com.autovw.burgermod.core;

import com.autovw.burgermod.BurgerMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Author: Autovw
 */
public class ModItems {
    // DeferredRegister is the correct way to register stuff.
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BurgerMod.MOD_ID);

    /* The food properties are stored in the ModFood class to make this class look cleaner.
     * The effect properties are stored in the ModEffects class.
     */

    // Meat + Egg Burgers
    public static final RegistryObject<Item> BEEF_BURGER = register("beef_burger", ModFood.BURGER_TIER_1);
    public static final RegistryObject<Item> PORK_BURGER = register("pork_burger", ModFood.BURGER_TIER_1);
    public static final RegistryObject<Item> MUTTON_BURGER = register("mutton_burger", ModFood.BURGER_TIER_2);
    public static final RegistryObject<Item> CHICKEN_BURGER = register("chicken_burger", ModFood.BURGER_TIER_3);

    // Fish + Egg Burgers
    public static final RegistryObject<Item> SALMON_BURGER = register("salmon_burger", ModFood.BURGER_TIER_4);
    public static final RegistryObject<Item> COD_BURGER = register("cod_burger", ModFood.BURGER_TIER_5);

    // Meat + Cheese Burgers
    public static final RegistryObject<Item> BEEF_CHEESE_BURGER = register("beef_cheese_burger", ModFood.BURGER_TIER_1);
    public static final RegistryObject<Item> PORK_CHEESE_BURGER = register("pork_cheese_burger", ModFood.BURGER_TIER_1);
    public static final RegistryObject<Item> MUTTON_CHEESE_BURGER = register("mutton_cheese_burger", ModFood.BURGER_TIER_2);
    public static final RegistryObject<Item> CHICKEN_CHEESE_BURGER = register("chicken_cheese_burger", ModFood.BURGER_TIER_3);

    // Fish + Cheese Burgers
    public static final RegistryObject<Item> SALMON_CHEESE_BURGER = register("salmon_cheese_burger", ModFood.BURGER_TIER_4);
    public static final RegistryObject<Item> COD_CHEESE_BURGER = register("cod_cheese_burger", ModFood.BURGER_TIER_5);

    // Meat + Champignons Burgers
    public static final RegistryObject<Item> BEEF_CHAMPIGNON_BURGER = register("beef_champignon_burger", ModFood.BURGER_TIER_1);
    public static final RegistryObject<Item> PORK_CHAMPIGNON_BURGER = register("pork_champignon_burger", ModFood.BURGER_TIER_1);
    public static final RegistryObject<Item> MUTTON_CHAMPIGNON_BURGER = register("mutton_champignon_burger", ModFood.BURGER_TIER_2);
    public static final RegistryObject<Item> CHICKEN_CHAMPIGNON_BURGER = register("chicken_champignon_burger", ModFood.BURGER_TIER_3);

    // Fish + Champignons Burgers
    public static final RegistryObject<Item> SALMON_CHAMPIGNON_BURGER = register("salmon_champignon_burger", ModFood.BURGER_TIER_4);
    public static final RegistryObject<Item> COD_CHAMPIGNON_BURGER = register("cod_champignon_burger", ModFood.BURGER_TIER_5);

    // Golden Burgers
    public static final RegistryObject<Item> GOLDEN_BEEF_BURGER = register("golden_beef_burger", ModFood.GOLDEN_BURGER_TIER_1, Rarity.RARE);
    public static final RegistryObject<Item> GOLDEN_PORK_BURGER = register("golden_pork_burger", ModFood.GOLDEN_BURGER_TIER_1, Rarity.RARE);
    public static final RegistryObject<Item> GOLDEN_MUTTON_BURGER = register("golden_mutton_burger", ModFood.GOLDEN_BURGER_TIER_2, Rarity.RARE);
    public static final RegistryObject<Item> GOLDEN_CHICKEN_BURGER = register("golden_chicken_burger", ModFood.GOLDEN_BURGER_TIER_3, Rarity.RARE);
    public static final RegistryObject<Item> GOLDEN_SALMON_BURGER = register("golden_salmon_burger", ModFood.GOLDEN_BURGER_TIER_2, Rarity.RARE);
    public static final RegistryObject<Item> GOLDEN_COD_BURGER = register("golden_cod_burger", ModFood.GOLDEN_BURGER_TIER_4, Rarity.RARE);

    // Eggs
    public static final RegistryObject<Item> SCRAMBLED_EGG = register("scrambled_egg", ModFood.RAW_EGG_FOOD);
    public static final RegistryObject<Item> FRIED_SCRAMBLED_EGG = register("fried_scrambled_egg", ModFood.FRIED_EGG_FOOD);

    // Champignons
    public static final RegistryObject<Item> RAW_CHAMPIGNONS = register("raw_champignons", ModFood.RAW_CHAMPIGNONS_FOOD);
    public static final RegistryObject<Item> COOKED_CHAMPIGNONS = register("cooked_champignons", ModFood.INGREDIENT_FOOD);

    // Others
    public static final RegistryObject<Item> CHEESE = register("cheese", ModFood.INGREDIENT_FOOD);
    public static final RegistryObject<Item> COOKED_CHICKEN_NUGGET = register("cooked_chicken_nugget", ModFood.NUGGET_FOOD);
    public static final RegistryObject<Item> FRIES = register("fries", ModFood.FRIES_FOOD);
    public static final RegistryObject<Item> HOTDOG = register("hotdog", ModFood.HOTDOG_FOOD);
    public static final RegistryObject<Item> SWEET_BERRY_TART = register("sweet_berry_tart", ModFood.BERRY_TART_FOOD);

    /**
     * Helper method used to register food items
     *
     * @param name Registry name of the item
     * @param food The food properties
     * @return The food item
     */
    private static RegistryObject<Item> register(String name, FoodProperties food) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(food)));
    }

    /**
     * Helper method used to register food items with a custom rarity
     *
     * @param name Registry name of the item
     * @param food The food properties
     * @param rarity The custom rarity
     * @return The food item
     */
    private static RegistryObject<Item> register(String name, FoodProperties food, Rarity rarity) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(food).rarity(rarity)));
    }
}
