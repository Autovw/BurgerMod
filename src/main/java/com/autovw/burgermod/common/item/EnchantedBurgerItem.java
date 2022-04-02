package com.autovw.burgermod.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * Author: Autovw
 */
public class EnchantedBurgerItem extends Item {
    public EnchantedBurgerItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
