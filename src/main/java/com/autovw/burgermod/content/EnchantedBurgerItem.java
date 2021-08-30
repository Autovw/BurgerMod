package com.autovw.burgermod.content;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Author: Autovw
 */
public class EnchantedBurgerItem extends Item {
    public EnchantedBurgerItem(Properties builder) {
        super(builder);
    }

    // isFoil adds enchantment glint to an item
    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}