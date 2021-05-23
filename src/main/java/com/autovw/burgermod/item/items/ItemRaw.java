package com.autovw.burgermod.item.items;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.init.ItemInit;
import com.autovw.burgermod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.FMLLog;

public class ItemRaw extends ItemFood implements IHasModel {

    public ItemRaw(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);

        ItemInit.ITEMS.add(this);
    }

    public ItemRaw addPoisonEffect() {
        final Potion potion = Potion.getPotionFromResourceLocation("poison");
        if (potion == null) {
            FMLLog.bigWarning("Could not set potion effect.");
            return this;
        }
        setPotionEffect(new PotionEffect(potion, 160, 0), 1.0f);
        return this;
    }

    @Override
    public void registerModels() {
        BurgerMod.proxy.registerModel(this, 0);
    }
}