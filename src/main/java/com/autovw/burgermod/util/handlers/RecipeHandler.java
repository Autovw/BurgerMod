package com.autovw.burgermod.util.handlers;

import com.autovw.burgermod.core.init.ItemInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {

    public static void init() {
        GameRegistry.addSmelting(ItemInit.SCRAMBLED_EGG, new ItemStack(ItemInit.FRIED_SCRAMBLED_EGG), 10);
    }
}