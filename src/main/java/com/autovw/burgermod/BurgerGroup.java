package com.autovw.burgermod;

import com.autovw.burgermod.core.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Author: Autovw
 */
public class BurgerGroup extends ItemGroup {

    // Creative inventory tab
    public BurgerGroup(String name) {
        super(name);
    }

    @Override
    public ItemStack makeIcon() {
        return ModItems.BEEF_BURGER.get().getDefaultInstance();
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        super.fillItemList(items);
    }
}
