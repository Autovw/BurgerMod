package com.autovw.burgermod.util.handlers;

import com.autovw.burgermod.core.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Author: Autovw
 */
public class RegistryHandler {

    public static void init() {
        for (Item item : ItemInit.ITEMS) {
            GameRegistry.register(item);
        }
    }
}
