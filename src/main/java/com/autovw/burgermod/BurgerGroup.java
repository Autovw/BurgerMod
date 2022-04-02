package com.autovw.burgermod;

import com.autovw.burgermod.core.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.Objects;

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
        items.sort((s1, s2) -> {
            String item1 = Objects.requireNonNull(s1.getItem().getRegistryName()).getNamespace();
            String item2 = Objects.requireNonNull(s2.getItem().getRegistryName()).getNamespace();

            if (item1.equals(BurgerMod.MOD_ID) == item2.equals(BurgerMod.MOD_ID)) return 0;

            return item1.equals(BurgerMod.MOD_ID) ? -1 : 1;
        });
    }
}
