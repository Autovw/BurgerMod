package com.autovw.burgermod.forge.core.registry;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.common.core.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * @author Autovw
 */
public final class ModItemRegistry
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BurgerMod.MOD_ID);

    /* The food properties are stored in the ModFood class to make this class look cleaner.
     * The effect properties are stored in the ModEffects class.
     */

    // Meat + Egg Burgers
    public static final RegistryObject<Item> BEEF_BURGER = register("beef_burger", ()-> ModItems.BEEF_BURGER);
    public static final RegistryObject<Item> PORK_BURGER = register("pork_burger", ()-> ModItems.PORK_BURGER);
    public static final RegistryObject<Item> MUTTON_BURGER = register("mutton_burger", ()-> ModItems.MUTTON_BURGER);
    public static final RegistryObject<Item> CHICKEN_BURGER = register("chicken_burger", ()-> ModItems.CHICKEN_BURGER);

    // Fish + Egg Burgers
    public static final RegistryObject<Item> SALMON_BURGER = register("salmon_burger", ()-> ModItems.SALMON_BURGER);
    public static final RegistryObject<Item> COD_BURGER = register("cod_burger", ()-> ModItems.COD_BURGER);

    // Meat + Cheese Burgers
    public static final RegistryObject<Item> BEEF_CHEESE_BURGER = register("beef_cheese_burger", ()-> ModItems.BEEF_CHEESE_BURGER);
    public static final RegistryObject<Item> PORK_CHEESE_BURGER = register("pork_cheese_burger", ()-> ModItems.PORK_CHEESE_BURGER);
    public static final RegistryObject<Item> MUTTON_CHEESE_BURGER = register("mutton_cheese_burger", ()-> ModItems.MUTTON_CHEESE_BURGER);
    public static final RegistryObject<Item> CHICKEN_CHEESE_BURGER = register("chicken_cheese_burger", ()-> ModItems.CHICKEN_CHEESE_BURGER);

    // Fish + Cheese Burgers
    public static final RegistryObject<Item> SALMON_CHEESE_BURGER = register("salmon_cheese_burger", ()-> ModItems.SALMON_CHEESE_BURGER);
    public static final RegistryObject<Item> COD_CHEESE_BURGER = register("cod_cheese_burger", ()-> ModItems.COD_CHEESE_BURGER);

    // Meat + Champignons Burgers
    public static final RegistryObject<Item> BEEF_CHAMPIGNON_BURGER = register("beef_champignon_burger", ()-> ModItems.BEEF_CHAMPIGNON_BURGER);
    public static final RegistryObject<Item> PORK_CHAMPIGNON_BURGER = register("pork_champignon_burger", ()-> ModItems.PORK_CHAMPIGNON_BURGER);
    public static final RegistryObject<Item> MUTTON_CHAMPIGNON_BURGER = register("mutton_champignon_burger", ()-> ModItems.MUTTON_CHAMPIGNON_BURGER);
    public static final RegistryObject<Item> CHICKEN_CHAMPIGNON_BURGER = register("chicken_champignon_burger", ()-> ModItems.CHICKEN_CHAMPIGNON_BURGER);

    // Fish + Champignons Burgers
    public static final RegistryObject<Item> SALMON_CHAMPIGNON_BURGER = register("salmon_champignon_burger", ()-> ModItems.SALMON_CHAMPIGNON_BURGER);
    public static final RegistryObject<Item> COD_CHAMPIGNON_BURGER = register("cod_champignon_burger", ()-> ModItems.COD_CHAMPIGNON_BURGER);

    // Golden Burgers
    public static final RegistryObject<Item> GOLDEN_BEEF_BURGER = register("golden_beef_burger", ()-> ModItems.GOLDEN_BEEF_BURGER);
    public static final RegistryObject<Item> GOLDEN_PORK_BURGER = register("golden_pork_burger", ()-> ModItems.GOLDEN_PORK_BURGER);
    public static final RegistryObject<Item> GOLDEN_MUTTON_BURGER = register("golden_mutton_burger", ()-> ModItems.GOLDEN_MUTTON_BURGER);
    public static final RegistryObject<Item> GOLDEN_CHICKEN_BURGER = register("golden_chicken_burger", ()-> ModItems.GOLDEN_CHICKEN_BURGER);
    public static final RegistryObject<Item> GOLDEN_SALMON_BURGER = register("golden_salmon_burger", ()-> ModItems.GOLDEN_SALMON_BURGER);
    public static final RegistryObject<Item> GOLDEN_COD_BURGER = register("golden_cod_burger", ()-> ModItems.GOLDEN_COD_BURGER);

    // Enchanted Golden Burger
    public static final RegistryObject<Item> ENCHANTED_GOLDEN_BURGER = register("enchanted_golden_burger", ()-> ModItems.ENCHANTED_GOLDEN_BURGER);

    // Eggs
    public static final RegistryObject<Item> SCRAMBLED_EGG = register("scrambled_egg", ()-> ModItems.SCRAMBLED_EGG);
    public static final RegistryObject<Item> FRIED_SCRAMBLED_EGG = register("fried_scrambled_egg", ()-> ModItems.FRIED_SCRAMBLED_EGG);

    // Champignons
    public static final RegistryObject<Item> RAW_CHAMPIGNONS = register("raw_champignons", ()-> ModItems.RAW_CHAMPIGNONS);
    public static final RegistryObject<Item> COOKED_CHAMPIGNONS = register("cooked_champignons", ()-> ModItems.COOKED_CHAMPIGNONS);

    // Others
    public static final RegistryObject<Item> CHEESE = register("cheese", ()-> ModItems.CHEESE);
    public static final RegistryObject<Item> COOKED_CHICKEN_NUGGET = register("cooked_chicken_nugget", ()-> ModItems.COOKED_CHICKEN_NUGGET);
    public static final RegistryObject<Item> FRIES = register("fries", ()-> ModItems.FRIES);
    public static final RegistryObject<Item> HOTDOG = register("hotdog", ()-> ModItems.HOTDOG);
    public static final RegistryObject<Item> SWEET_BERRY_TART = register("sweet_berry_tart", ()-> ModItems.SWEET_BERRY_TART);

    /**
     * Helper method used to register food items
     * @param name Registry name of the item
     * @param item The item supplier
     * @return The food item
     */
    private static RegistryObject<Item> register(String name, Supplier<Item> item)
    {
        return ITEMS.register(name, item);
    }
}
