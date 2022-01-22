package com.autovw.burgermod.util.handlers;

import com.autovw.burgermod.core.init.ItemInit;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Author: Autovw
 */
public class RecipeHandler {

    public static void init() {
        /* Crafting recipes */
        addBurgerRecipe(ItemInit.BEEF_BURGER, new ItemStack(Items.cooked_beef), ItemInit.FRIED_SCRAMBLED_EGG);
        addBurgerRecipe(ItemInit.PORK_BURGER, new ItemStack(Items.cooked_porkchop), ItemInit.FRIED_SCRAMBLED_EGG);
        addBurgerRecipe(ItemInit.MUTTON_BURGER, new ItemStack(Items.cooked_mutton), ItemInit.FRIED_SCRAMBLED_EGG);
        addBurgerRecipe(ItemInit.CHICKEN_BURGER, new ItemStack(Items.cooked_chicken), ItemInit.FRIED_SCRAMBLED_EGG);
        addBurgerRecipe(ItemInit.SALMON_BURGER, new ItemStack(Items.cooked_fish, 1, 1), ItemInit.FRIED_SCRAMBLED_EGG);
        addBurgerRecipe(ItemInit.COD_BURGER, new ItemStack(Items.cooked_fish), ItemInit.FRIED_SCRAMBLED_EGG);

        addBurgerRecipe(ItemInit.BEEF_CHEESE_BURGER, new ItemStack(Items.cooked_beef), ItemInit.CHEESE);
        addBurgerRecipe(ItemInit.PORK_CHEESE_BURGER, new ItemStack(Items.cooked_porkchop), ItemInit.CHEESE);
        addBurgerRecipe(ItemInit.MUTTON_CHEESE_BURGER, new ItemStack(Items.cooked_mutton), ItemInit.CHEESE);
        addBurgerRecipe(ItemInit.CHICKEN_CHEESE_BURGER, new ItemStack(Items.cooked_chicken), ItemInit.CHEESE);
        addBurgerRecipe(ItemInit.SALMON_CHEESE_BURGER, new ItemStack(Items.cooked_fish, 1, 1), ItemInit.CHEESE);
        addBurgerRecipe(ItemInit.COD_CHEESE_BURGER, new ItemStack(Items.cooked_fish), ItemInit.CHEESE);

        GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.SCRAMBLED_EGG, 1), Items.egg);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.CHEESE, 1), Items.milk_bucket, Items.sugar);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.COOKED_CHICKEN_NUGGET, 6), Items.cooked_chicken);

        GameRegistry.addRecipe(new ItemStack(ItemInit.FRIES, 2), "PPP", 'P', Items.baked_potato);

        /* Smelting recipes */
        GameRegistry.addSmelting(ItemInit.SCRAMBLED_EGG, new ItemStack(ItemInit.FRIED_SCRAMBLED_EGG), 10);
    }

    private static void addBurgerRecipe(Item item, ItemStack ingredient1, Item ingredient2) {
        GameRegistry.addRecipe(new ItemStack(item, 2), " B", "EC", " B", 'B', Items.bread, 'C', ingredient1, 'E', ingredient2);
    }
}
