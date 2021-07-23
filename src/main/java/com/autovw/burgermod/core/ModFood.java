package com.autovw.burgermod.core;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

/**
 * Author: Autovw
 */
public class ModFood {
    /* I moved this to make the ModItems class look cleaner.
     * nutrition = hunger, meat = isWolfFood, saturationMod = saturation
     *
     * Effects are stored in the ModEffects class.
     */

    /* m_38760_ = nutrition
     * m_38758_ = saturationMod
     * m_38757_ = meat
     * m_38765_ = alwaysEat
     * m_38767_ = build
     */

    // Used for: BEEF, PORK
    public static final FoodProperties BURGER_TIER_1 = new FoodProperties.Builder().m_38760_(10).m_38757_().m_38758_(1.0f).m_38767_();
    // Used for: MUTTON
    public static final FoodProperties BURGER_TIER_2 = new FoodProperties.Builder().m_38760_(8).m_38757_().m_38758_(1.0f).m_38767_();
    // Used for: CHICKEN
    public static final FoodProperties BURGER_TIER_3 = new FoodProperties.Builder().m_38760_(8).m_38757_().m_38758_(0.8f).m_38767_();
    // Used for: SALMON
    public static final FoodProperties BURGER_TIER_4 = new FoodProperties.Builder().m_38760_(8).m_38758_(1.0f).m_38767_();
    // Used for: COD
    public static final FoodProperties BURGER_TIER_5 = new FoodProperties.Builder().m_38760_(7).m_38758_(0.8f).m_38767_();

    // Used for: RAW_SCRAMBLED_EGG
    // POISON: duration (ticks), amplifier (0 = lvl 1), probability (1.0f = 100%)
    public static final FoodProperties RAW_EGG_FOOD = new FoodProperties.Builder().m_38760_(1).m_38758_(0.1f).effect(() -> new MobEffectInstance
            (ModEffects.RAW_SCRAMBLED_EGG_EFFECTS), 1.0F).m_38767_();
    // Used for: FRIED_SCRAMBLED_EGG
    public static final FoodProperties FRIED_EGG_FOOD = new FoodProperties.Builder().m_38760_(2).m_38757_().m_38758_(0.6f).m_38767_();

    // Used for: RAW_CHAMPIGNONS
    // HUNGER: duration (ticks), amplifier (0 = lvl 1), probability (1.0f = 100%)
    public static final FoodProperties RAW_CHAMPIGNONS_FOOD = new FoodProperties.Builder().m_38760_(1).m_38758_(0.1f).effect(() -> new MobEffectInstance
            (ModEffects.RAW_CHAMPIGNONS_EFFECTS), 1.0f).m_38767_();
    // Used for: CHEESE, COOKED_MUSHROOM
    public static final FoodProperties INGREDIENT_FOOD = new FoodProperties.Builder().m_38760_(2).m_38758_(0.6f).m_38767_();

    // Used for: FRIES
    public static final FoodProperties FRIES_FOOD = new FoodProperties.Builder().m_38760_(8).m_38758_(0.9f).m_38767_();
    // Used for: CHICKEN_NUGGET
    public static final FoodProperties NUGGET_FOOD = new FoodProperties.Builder().m_38760_(1).m_38758_(0.6f).m_38757_().m_38767_();

    // Used for: GOLDEN_BEEF, GOLDEN_PORK
    public static final FoodProperties GOLDEN_BURGER_TIER_1 = new FoodProperties.Builder().m_38760_(10).m_38758_(1.4f).effect(() -> new MobEffectInstance
            (ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f).effect(() -> new MobEffectInstance
            (ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).m_38765_().m_38767_();
    // Used for: GOLDEN_MUTTON, GOLDEN_SALMON
    public static final FoodProperties GOLDEN_BURGER_TIER_2 = new FoodProperties.Builder().m_38760_(8).m_38758_(1.4f).effect(() -> new MobEffectInstance
            (ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f).effect(() -> new MobEffectInstance
            (ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).m_38765_().m_38767_();
    // Used for: GOLDEN_CHICKEN
    public static final FoodProperties GOLDEN_BURGER_TIER_3 = new FoodProperties.Builder().m_38760_(8).m_38758_(1.2f).effect(() -> new MobEffectInstance
            (ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f).effect(() -> new MobEffectInstance
            (ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).m_38765_().m_38767_();
    // Used for: GOLDEN_COD
    public static final FoodProperties GOLDEN_BURGER_TIER_4 = new FoodProperties.Builder().m_38760_(7).m_38758_(1.2f).effect( () -> new MobEffectInstance
            (ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f).effect(() -> new MobEffectInstance
            (ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).m_38765_().m_38767_();
}