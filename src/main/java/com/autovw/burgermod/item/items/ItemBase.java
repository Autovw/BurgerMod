package com.autovw.burgermod.item.items;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

/**
 * Author: Autovw
 */
public class ItemBase extends ItemFood {

    public ItemBase(String name, int hunger, float saturation, boolean isWolfFood) {
        super(hunger, saturation, isWolfFood);
        setUnlocalizedName(name);
        setTextureName(BurgerMod.MODID + ":" + name);
        setCreativeTab(CreativeTabs.tabFood);

        ItemInit.ITEMS.add(this);
    }

    /**
     * Add poison effect to food item
     *
     * @param duration The effect duration in seconds
     * @param amplifier The effect amplifier (level)
     * @param probability The probability of the effect applying
     * @return The poison effect
     */
    public ItemBase addPoisonEffect(int duration, int amplifier, float probability) {
        setPotionEffect(Potion.poison.id, duration, amplifier, probability);
        return this;
    }
}
