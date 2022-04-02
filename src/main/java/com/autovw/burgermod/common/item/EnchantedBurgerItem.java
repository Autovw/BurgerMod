package com.autovw.burgermod.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
