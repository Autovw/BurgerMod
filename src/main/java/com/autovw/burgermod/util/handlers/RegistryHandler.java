package com.autovw.burgermod.util.handlers;

import com.autovw.burgermod.core.init.ItemInit;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Author: Autovw
 */
public class RegistryHandler {

    public static void init() {
        registerItem(ItemInit.BEEF_BURGER);
        registerItem(ItemInit.PORK_BURGER);
        registerItem(ItemInit.CHICKEN_BURGER);

        registerItem(ItemInit.BEEF_CHEESE_BURGER);
        registerItem(ItemInit.PORK_CHEESE_BURGER);
        registerItem(ItemInit.CHICKEN_CHEESE_BURGER);

        registerItem(ItemInit.SALMON_BURGER);
        registerItem(ItemInit.COD_BURGER);

        registerItem(ItemInit.SALMON_CHEESE_BURGER);
        registerItem(ItemInit.COD_CHEESE_BURGER);

        registerItem(ItemInit.SCRAMBLED_EGG);
        registerItem(ItemInit.FRIED_SCRAMBLED_EGG);

        registerItem(ItemInit.CHEESE);
        registerItem(ItemInit.COOKED_CHICKEN_NUGGET);
        registerItem(ItemInit.FRIES);
    }

    private static void registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
    }
}
