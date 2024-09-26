package com.autovw.burgermod.neoforge.core.registry;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.common.core.ModItems;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/**
 * @author Autovw
 */
public final class ModItemRegistry
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BurgerMod.MOD_ID);

    /* The food properties are stored in the ModFood class to make this class look cleaner.
     * The effect properties are stored in the ModEffects class.
     */

    // Meat + Egg Burgers
    public static final DeferredItem<Item> BEEF_BURGER = register("beef_burger", ()-> ModItems.BEEF_BURGER);
    public static final DeferredItem<Item> PORK_BURGER = register("pork_burger", ()-> ModItems.PORK_BURGER);
    public static final DeferredItem<Item> MUTTON_BURGER = register("mutton_burger", ()-> ModItems.MUTTON_BURGER);
    public static final DeferredItem<Item> CHICKEN_BURGER = register("chicken_burger", ()-> ModItems.CHICKEN_BURGER);

    // Fish + Egg Burgers
    public static final DeferredItem<Item> SALMON_BURGER = register("salmon_burger", ()-> ModItems.SALMON_BURGER);
    public static final DeferredItem<Item> COD_BURGER = register("cod_burger", ()-> ModItems.COD_BURGER);

    // Meat + Cheese Burgers
    public static final DeferredItem<Item> BEEF_CHEESE_BURGER = register("beef_cheese_burger", ()-> ModItems.BEEF_CHEESE_BURGER);
    public static final DeferredItem<Item> PORK_CHEESE_BURGER = register("pork_cheese_burger", ()-> ModItems.PORK_CHEESE_BURGER);
    public static final DeferredItem<Item> MUTTON_CHEESE_BURGER = register("mutton_cheese_burger", ()-> ModItems.MUTTON_CHEESE_BURGER);
    public static final DeferredItem<Item> CHICKEN_CHEESE_BURGER = register("chicken_cheese_burger", ()-> ModItems.CHICKEN_CHEESE_BURGER);

    // Fish + Cheese Burgers
    public static final DeferredItem<Item> SALMON_CHEESE_BURGER = register("salmon_cheese_burger", ()-> ModItems.SALMON_CHEESE_BURGER);
    public static final DeferredItem<Item> COD_CHEESE_BURGER = register("cod_cheese_burger", ()-> ModItems.COD_CHEESE_BURGER);

    // Meat + Champignons Burgers
    public static final DeferredItem<Item> BEEF_CHAMPIGNON_BURGER = register("beef_champignon_burger", ()-> ModItems.BEEF_CHAMPIGNON_BURGER);
    public static final DeferredItem<Item> PORK_CHAMPIGNON_BURGER = register("pork_champignon_burger", ()-> ModItems.PORK_CHAMPIGNON_BURGER);
    public static final DeferredItem<Item> MUTTON_CHAMPIGNON_BURGER = register("mutton_champignon_burger", ()-> ModItems.MUTTON_CHAMPIGNON_BURGER);
    public static final DeferredItem<Item> CHICKEN_CHAMPIGNON_BURGER = register("chicken_champignon_burger", ()-> ModItems.CHICKEN_CHAMPIGNON_BURGER);

    // Fish + Champignons Burgers
    public static final DeferredItem<Item> SALMON_CHAMPIGNON_BURGER = register("salmon_champignon_burger", ()-> ModItems.SALMON_CHAMPIGNON_BURGER);
    public static final DeferredItem<Item> COD_CHAMPIGNON_BURGER = register("cod_champignon_burger", ()-> ModItems.COD_CHAMPIGNON_BURGER);

    // Golden Burgers
    public static final DeferredItem<Item> GOLDEN_BEEF_BURGER = register("golden_beef_burger", ()-> ModItems.GOLDEN_BEEF_BURGER);
    public static final DeferredItem<Item> GOLDEN_PORK_BURGER = register("golden_pork_burger", ()-> ModItems.GOLDEN_PORK_BURGER);
    public static final DeferredItem<Item> GOLDEN_MUTTON_BURGER = register("golden_mutton_burger", ()-> ModItems.GOLDEN_MUTTON_BURGER);
    public static final DeferredItem<Item> GOLDEN_CHICKEN_BURGER = register("golden_chicken_burger", ()-> ModItems.GOLDEN_CHICKEN_BURGER);
    public static final DeferredItem<Item> GOLDEN_SALMON_BURGER = register("golden_salmon_burger", ()-> ModItems.GOLDEN_SALMON_BURGER);
    public static final DeferredItem<Item> GOLDEN_COD_BURGER = register("golden_cod_burger", ()-> ModItems.GOLDEN_COD_BURGER);

    // Enchanted Golden Burger
    public static final DeferredItem<Item> ENCHANTED_GOLDEN_BURGER = register("enchanted_golden_burger", ()-> ModItems.ENCHANTED_GOLDEN_BURGER);

    // Eggs
    public static final DeferredItem<Item> SCRAMBLED_EGG = register("scrambled_egg", ()-> ModItems.SCRAMBLED_EGG);
    public static final DeferredItem<Item> FRIED_SCRAMBLED_EGG = register("fried_scrambled_egg", ()-> ModItems.FRIED_SCRAMBLED_EGG);

    // Champignons
    public static final DeferredItem<Item> RAW_CHAMPIGNONS = register("raw_champignons", ()-> ModItems.RAW_CHAMPIGNONS);
    public static final DeferredItem<Item> COOKED_CHAMPIGNONS = register("cooked_champignons", ()-> ModItems.COOKED_CHAMPIGNONS);

    // Others
    public static final DeferredItem<Item> CHEESE = register("cheese", ()-> ModItems.CHEESE);
    public static final DeferredItem<Item> COOKED_CHICKEN_NUGGET = register("cooked_chicken_nugget", ()-> ModItems.COOKED_CHICKEN_NUGGET);
    public static final DeferredItem<Item> FRIES = register("fries", ()-> ModItems.FRIES);
    public static final DeferredItem<Item> HOTDOG = register("hotdog", ()-> ModItems.HOTDOG);
    public static final DeferredItem<Item> SWEET_BERRY_TART = register("sweet_berry_tart", ()-> ModItems.SWEET_BERRY_TART);

    /**
     * Helper method used to register food items
     * @param name Registry name of the item
     * @param item The item supplier
     * @return The food item
     */
    private static DeferredItem<Item> register(String name, Supplier<Item> item)
    {
        return ITEMS.register(name, item);
    }
}
