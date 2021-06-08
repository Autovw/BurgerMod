package com.autovw.burgermod.core;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

/**
 * Author: Autovw
 */

public class ModFood {
    // I moved this to make the ModItems class look cleaner.
    // nutrition = hunger, meat = isWolfFood, saturationMod = saturation

    // Used for: BEEF, PORK
    public static final Food BURGER_TIER_1 = new Food.Builder().nutrition(10).meat().saturationMod(1.0f).build();

    // Used for: MUTTON
    public static final Food BURGER_TIER_2 = new Food.Builder().nutrition(8).meat().saturationMod(1.0f).build();

    // Used for: CHICKEN
    public static final Food BURGER_TIER_3 = new Food.Builder().nutrition(8).meat().saturationMod(0.8f).build();

    // Used for: SALMON
    public static final Food BURGER_TIER_4 = new Food.Builder().nutrition(8).saturationMod(1.0f).build();

    // Used for: COD
    public static final Food BURGER_TIER_5 = new Food.Builder().nutrition(7).saturationMod(0.8f).build();

    // Used for: RAW_SCRAMBLED_EGG
    // POISON: duration (ticks), amplifier (0 = lvl 1), probability (1.0f = 100%)
    public static final Food RAW_EGG_FOOD = new Food.Builder().nutrition(1).saturationMod(0.1f).effect(() -> new EffectInstance
            (Effects.POISON, 160, 0), 1.0f).build();

    // Used for: FRIED_SCRAMBLED_EGG
    public static final Food FRIED_EGG_FOOD = new Food.Builder().nutrition(2).meat().saturationMod(0.6f).build();

    // Used for: RAW_CHAMPIGNONS
    // HUNGER: duration (ticks), amplifier (0 = lvl 1), probability (1.0f = 100%)
    public static final Food RAW_CHAMPIGNONS_FOOD = new Food.Builder().nutrition(1).saturationMod(0.1f).effect(() -> new EffectInstance
            (Effects.HUNGER, 600, 1), 1.0f).build();

    // Used for: CHEESE, COOKED_MUSHROOM
    public static final Food INGREDIENT_FOOD = new Food.Builder().nutrition(2).saturationMod(0.6f).build();

    // Used for: FRIES
    public static final Food FRIES_FOOD = new Food.Builder().nutrition(8).saturationMod(0.9f).build();

    // Used for: CHICKEN_NUGGET
    public static final Food NUGGET_FOOD = new Food.Builder().nutrition(1).saturationMod(0.6f).meat().build();
}