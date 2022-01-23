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
        addBurgerRecipe(ItemInit.BEEF_BURGER, new ItemStack(Items.COOKED_BEEF), ItemInit.FRIED_SCRAMBLED_EGG);
        addBurgerRecipe(ItemInit.PORK_BURGER, new ItemStack(Items.COOKED_PORKCHOP), ItemInit.FRIED_SCRAMBLED_EGG);
        addBurgerRecipe(ItemInit.MUTTON_BURGER, new ItemStack(Items.COOKED_MUTTON), ItemInit.FRIED_SCRAMBLED_EGG);
        addBurgerRecipe(ItemInit.CHICKEN_BURGER, new ItemStack(Items.COOKED_CHICKEN), ItemInit.FRIED_SCRAMBLED_EGG);
        addBurgerRecipe(ItemInit.SALMON_BURGER, new ItemStack(Items.COOKED_FISH, 1, 1), ItemInit.FRIED_SCRAMBLED_EGG);
        addBurgerRecipe(ItemInit.COD_BURGER, new ItemStack(Items.COOKED_FISH), ItemInit.FRIED_SCRAMBLED_EGG);

        addBurgerRecipe(ItemInit.BEEF_CHEESE_BURGER, new ItemStack(Items.COOKED_BEEF), ItemInit.CHEESE);
        addBurgerRecipe(ItemInit.PORK_CHEESE_BURGER, new ItemStack(Items.COOKED_PORKCHOP), ItemInit.CHEESE);
        addBurgerRecipe(ItemInit.MUTTON_CHEESE_BURGER, new ItemStack(Items.COOKED_MUTTON), ItemInit.CHEESE);
        addBurgerRecipe(ItemInit.CHICKEN_CHEESE_BURGER, new ItemStack(Items.COOKED_CHICKEN), ItemInit.CHEESE);
        addBurgerRecipe(ItemInit.SALMON_CHEESE_BURGER, new ItemStack(Items.COOKED_FISH, 1, 1), ItemInit.CHEESE);
        addBurgerRecipe(ItemInit.COD_CHEESE_BURGER, new ItemStack(Items.COOKED_FISH), ItemInit.CHEESE);

        GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.SCRAMBLED_EGG, 1), Items.EGG);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.CHEESE, 1), Items.MILK_BUCKET, Items.SUGAR);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.COOKED_CHICKEN_NUGGET, 6), Items.COOKED_CHICKEN);

        GameRegistry.addRecipe(new ItemStack(ItemInit.FRIES, 2), "PPP", 'P', Items.BAKED_POTATO);

        /* Smelting recipes */
        GameRegistry.addSmelting(ItemInit.SCRAMBLED_EGG, new ItemStack(ItemInit.FRIED_SCRAMBLED_EGG), 10);
    }

    private static void addBurgerRecipe(Item item, ItemStack ingredient1, Item ingredient2) {
        GameRegistry.addRecipe(new ItemStack(item, 2), " B", "EC", " B", 'B', Items.BREAD, 'C', ingredient1, 'E', ingredient2);
    }
}
