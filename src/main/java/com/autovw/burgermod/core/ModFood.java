package com.autovw.burgermod.core;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;

/**
 * Author: Autovw
 */
public class ModFood {
    /* I moved this to make the ModItems class look cleaner.
     * nutrition = hunger, meat = isWolfFood, saturationMod = saturation
     *
     * Effects are stored in the ModEffects class.
     */

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
            (ModEffects.RAW_SCRAMBLED_EGG_EFFECTS), 1.0F).build();
    // Used for: FRIED_SCRAMBLED_EGG
    public static final Food FRIED_EGG_FOOD = new Food.Builder().nutrition(2).meat().saturationMod(0.6f).build();

    // Used for: RAW_CHAMPIGNONS
    // HUNGER: duration (ticks), amplifier (0 = lvl 1), probability (1.0f = 100%)
    public static final Food RAW_CHAMPIGNONS_FOOD = new Food.Builder().nutrition(1).saturationMod(0.1f).effect(() -> new EffectInstance
            (ModEffects.RAW_CHAMPIGNONS_EFFECTS), 1.0f).build();
    // Used for: CHEESE, COOKED_MUSHROOM
    public static final Food INGREDIENT_FOOD = new Food.Builder().nutrition(2).saturationMod(0.6f).build();

    // Used for: FRIES
    public static final Food FRIES_FOOD = new Food.Builder().nutrition(8).saturationMod(0.9f).build();
    // Used for: SWEET_BERRY_TART
    public static final Food BERRY_TART_FOOD = new Food.Builder().nutrition(7).saturationMod(0.5f).build();
    // Used for: HOTDOG
    public static final Food HOTDOG_FOOD = new Food.Builder().nutrition(6).saturationMod(0.7f).meat().build();
    // Used for: CHICKEN_NUGGET
    public static final Food NUGGET_FOOD = new Food.Builder().nutrition(1).saturationMod(0.6f).meat().build();

    // Used for: GOLDEN_BEEF, GOLDEN_PORK
    public static final Food GOLDEN_BURGER_TIER_1 = new Food.Builder().nutrition(10).saturationMod(1.4f).effect(() -> new EffectInstance
            (ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f).effect(() -> new EffectInstance
            (ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).alwaysEat().build();
    // Used for: GOLDEN_MUTTON, GOLDEN_SALMON
    public static final Food GOLDEN_BURGER_TIER_2 = new Food.Builder().nutrition(8).saturationMod(1.4f).effect(() -> new EffectInstance
            (ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f).effect(() -> new EffectInstance
            (ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).alwaysEat().build();
    // Used for: GOLDEN_CHICKEN
    public static final Food GOLDEN_BURGER_TIER_3 = new Food.Builder().nutrition(8).saturationMod(1.2f).effect(() -> new EffectInstance
            (ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f).effect(() -> new EffectInstance
            (ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).alwaysEat().build();
    // Used for: GOLDEN_COD
    public static final Food GOLDEN_BURGER_TIER_4 = new Food.Builder().nutrition(7).saturationMod(1.2f).effect( () -> new EffectInstance
            (ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f).effect(() -> new EffectInstance
            (ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).alwaysEat().build();

    // Used for: ENCHANTED_GOLDEN_BURGER
    public static final Food ENCHANTED_GOLDEN_BURGER = new Food.Builder().nutrition(8).saturationMod(1.6f).effect(() -> new EffectInstance
            (ModEffects.ENCHANTED_GOLDEN_BURGER_REGENERATION), 1.0f).effect(() -> new EffectInstance
            (ModEffects.ENCHANTED_GOLDEN_BURGER_DAMAGE_RESISTANCE), 1.0f).effect(() -> new EffectInstance
            (ModEffects.ENCHANTED_GOLDEN_BURGER_FIRE_RESISTANCE), 1.0f).effect(() -> new EffectInstance
            (ModEffects.ENCHANTED_GOLDEN_BURGER_ABSORPTION), 1.0f).alwaysEat().build();
}
