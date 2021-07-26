package com.autovw.burgermod;

import com.autovw.burgermod.core.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * Author: Autovw
 */
public class BurgerGroup extends CreativeModeTab {

    // Creative inventory tab
    public BurgerGroup(String name) {
        super(name);
    }

    @Override
    public ItemStack makeIcon() {
        return ModItems.BEEF_BURGER.get().getDefaultInstance();
    }
}