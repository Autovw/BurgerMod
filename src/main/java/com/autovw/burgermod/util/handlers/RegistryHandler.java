package com.autovw.burgermod.util.handlers;

import com.autovw.burgermod.core.init.ItemInit;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Author: Autovw
 */
public class RegistryHandler {

    public static void init() {
        for (Item item : ItemInit.ITEMS) {
            registerItem(item);
        }
    }

    private static void registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
    }
}
