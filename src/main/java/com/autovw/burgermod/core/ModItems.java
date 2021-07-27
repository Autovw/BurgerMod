package com.autovw.burgermod.core;

import com.autovw.burgermod.BurgerMod;
import net.minecraft.world.item.Item;
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
    public static final RegistryObject<Item> BEEF_BURGER = ITEMS.register("beef_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_1)));
    public static final RegistryObject<Item> PORK_BURGER = ITEMS.register("pork_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_1)));
    public static final RegistryObject<Item> MUTTON_BURGER = ITEMS.register("mutton_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_2)));
    public static final RegistryObject<Item> CHICKEN_BURGER = ITEMS.register("chicken_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_3)));

    // Fish + Egg Burgers
    public static final RegistryObject<Item> SALMON_BURGER = ITEMS.register("salmon_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_4)));
    public static final RegistryObject<Item> COD_BURGER = ITEMS.register("cod_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_5)));

    // Meat + Cheese Burgers
    public static final RegistryObject<Item> BEEF_CHEESE_BURGER = ITEMS.register("beef_cheese_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_1)));
    public static final RegistryObject<Item> PORK_CHEESE_BURGER = ITEMS.register("pork_cheese_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_1)));
    public static final RegistryObject<Item> MUTTON_CHEESE_BURGER = ITEMS.register("mutton_cheese_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_2)));
    public static final RegistryObject<Item> CHICKEN_CHEESE_BURGER = ITEMS.register("chicken_cheese_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_3)));

    // Fish + Cheese Burgers
    public static final RegistryObject<Item> SALMON_CHEESE_BURGER = ITEMS.register("salmon_cheese_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_4)));
    public static final RegistryObject<Item> COD_CHEESE_BURGER = ITEMS.register("cod_cheese_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_5)));

    // Meat + Champignons Burgers
    public static final RegistryObject<Item> BEEF_CHAMPIGNON_BURGER = ITEMS.register("beef_champignon_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_1)));
    public static final RegistryObject<Item> PORK_CHAMPIGNON_BURGER = ITEMS.register("pork_champignon_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_1)));
    public static final RegistryObject<Item> MUTTON_CHAMPIGNON_BURGER = ITEMS.register("mutton_champignon_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_2)));
    public static final RegistryObject<Item> CHICKEN_CHAMPIGNON_BURGER = ITEMS.register("chicken_champignon_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_3)));

    // Fish + Champignons Burgers
    public static final RegistryObject<Item> SALMON_CHAMPIGNON_BURGER = ITEMS.register("salmon_champignon_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_4)));
    public static final RegistryObject<Item> COD_CHAMPIGNON_BURGER = ITEMS.register("cod_champignon_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.BURGER_TIER_5)));

    // Golden Burgers
    public static final RegistryObject<Item> GOLDEN_BEEF_BURGER = ITEMS.register("golden_beef_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.GOLDEN_BURGER_TIER_1)));
    public static final RegistryObject<Item> GOLDEN_PORK_BURGER = ITEMS.register("golden_pork_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.GOLDEN_BURGER_TIER_1)));
    public static final RegistryObject<Item> GOLDEN_MUTTON_BURGER = ITEMS.register("golden_mutton_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.GOLDEN_BURGER_TIER_2)));
    public static final RegistryObject<Item> GOLDEN_CHICKEN_BURGER = ITEMS.register("golden_chicken_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.GOLDEN_BURGER_TIER_3)));
    public static final RegistryObject<Item> GOLDEN_SALMON_BURGER = ITEMS.register("golden_salmon_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.GOLDEN_BURGER_TIER_2)));
    public static final RegistryObject<Item> GOLDEN_COD_BURGER = ITEMS.register("golden_cod_burger",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.GOLDEN_BURGER_TIER_4)));

    // Eggs
    public static final RegistryObject<Item> SCRAMBLED_EGG = ITEMS.register("scrambled_egg",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.RAW_EGG_FOOD)));
    public static final RegistryObject<Item> FRIED_SCRAMBLED_EGG = ITEMS.register("fried_scrambled_egg",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.FRIED_EGG_FOOD)));

    // Champignons
    public static final RegistryObject<Item> RAW_CHAMPIGNONS = ITEMS.register("raw_champignons",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.RAW_CHAMPIGNONS_FOOD)));
    public static final RegistryObject<Item> COOKED_CHAMPIGNONS = ITEMS.register("cooked_champignons",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.INGREDIENT_FOOD)));

    // Others
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.INGREDIENT_FOOD)));
    public static final RegistryObject<Item> COOKED_CHICKEN_NUGGET = ITEMS.register("cooked_chicken_nugget",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.NUGGET_FOOD)));
    public static final RegistryObject<Item> FRIES = ITEMS.register("fries",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.FRIES_FOOD)));
    public static final RegistryObject<Item> HOTDOG = ITEMS.register("hotdog",
            () -> new Item(new Item.Properties().tab(BurgerMod.TAB_BURGERMOD).food(ModFood.HOTDOG_FOOD)));
}