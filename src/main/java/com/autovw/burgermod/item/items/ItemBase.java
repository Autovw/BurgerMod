package com.autovw.burgermod.item.items;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.FMLLog;

/**
 * Author: Autovw
 */
public class ItemBase extends ItemFood {

    public ItemBase(String name, int hunger, float saturation, boolean isWolfFood) {
        super(hunger, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(BurgerMod.MODID + ":" + name);
        setCreativeTab(CreativeTabs.FOOD);

        ItemInit.ITEMS.add(this);
    }

    /**
     * Add poison effect to food item
     *
     * @param duration The effect duration in ticks
     * @param amplifier The effect amplifier (level)
     * @param probability The probability of the effect applying
     * @return The poison effect
     */
    public ItemBase addPoisonEffect(int duration, int amplifier, float probability) {
        final Potion potion = Potion.getPotionFromResourceLocation("poison");
        if (potion == null) {
            FMLLog.bigWarning("Could not set poison effect.");
            return this;
        }
        setPotionEffect(new PotionEffect(potion, duration, amplifier), probability);
        return this;
    }
}
