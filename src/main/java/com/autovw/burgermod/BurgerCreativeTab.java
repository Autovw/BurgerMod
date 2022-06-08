package com.autovw.burgermod;

import com.autovw.burgermod.core.registry.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

/**
 * Author: Autovw
 */
public class BurgerCreativeTab extends CreativeModeTab {

    // Creative inventory tab
    public BurgerCreativeTab(String name) {
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
            String item1 = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(s1.getItem())).getNamespace();
            String item2 = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(s2.getItem())).getNamespace();

            if (item1.equals(BurgerMod.MOD_ID) == item2.equals(BurgerMod.MOD_ID)) return 0;

            return item1.equals(BurgerMod.MOD_ID) ? -1 : 1;
        });
    }
}
