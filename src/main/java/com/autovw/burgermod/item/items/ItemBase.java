package com.autovw.burgermod.item.items;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.init.ItemInit;
import com.autovw.burgermod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemBase extends ItemFood implements IHasModel {

    public ItemBase(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        BurgerMod.proxy.registerModel(this, 0);
    }
}