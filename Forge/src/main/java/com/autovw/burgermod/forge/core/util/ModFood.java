package com.autovw.burgermod.forge.core.util;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

/**
 * @author Autovw
 */
public class ModFood
{
    /* I moved this to make the ModItems class look cleaner.
     * nutrition = hunger, meat = isWolfFood (moved to a tag 1.20.5+), saturationModifier = saturation
     *
     * Effects are stored in the ModEffects class.
     */

    // Used for: BEEF, PORK
    public static final FoodProperties BURGER_TIER_1 = new FoodProperties.Builder().nutrition(10).saturationModifier(1.0f).build();
    // Used for: MUTTON
    public static final FoodProperties BURGER_TIER_2 = new FoodProperties.Builder().nutrition(8).saturationModifier(1.0f).build();
    // Used for: CHICKEN
    public static final FoodProperties BURGER_TIER_3 = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build();
    // Used for: SALMON
    public static final FoodProperties BURGER_TIER_4 = new FoodProperties.Builder().nutrition(8).saturationModifier(1.0f).build();
    // Used for: COD
    public static final FoodProperties BURGER_TIER_5 = new FoodProperties.Builder().nutrition(7).saturationModifier(0.8f).build();

    // Used for: RAW_SCRAMBLED_EGG
    // POISON: duration (ticks), amplifier (0 = lvl 1), probability (1.0f = 100%)
    public static final FoodProperties RAW_EGG_FOOD = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f)
            .effect(new MobEffectInstance(ModEffects.RAW_SCRAMBLED_EGG_EFFECTS), 1.0F).build();
    // Used for: FRIED_SCRAMBLED_EGG
    public static final FoodProperties FRIED_EGG_FOOD = new FoodProperties.Builder().nutrition(2).saturationModifier(0.6f).build();

    // Used for: RAW_CHAMPIGNONS
    // HUNGER: duration (ticks), amplifier (0 = lvl 1), probability (1.0f = 100%)
    public static final FoodProperties RAW_CHAMPIGNONS_FOOD = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f)
            .effect(new MobEffectInstance(ModEffects.RAW_CHAMPIGNONS_EFFECTS), 1.0f).build();
    // Used for: CHEESE, COOKED_MUSHROOM
    public static final FoodProperties INGREDIENT_FOOD = new FoodProperties.Builder().nutrition(2).saturationModifier(0.6f).build();

    // Used for: FRIES
    public static final FoodProperties FRIES_FOOD = new FoodProperties.Builder().nutrition(8).saturationModifier(0.9f).build();
    // Used for: SWEET_BERRY_TART
    public static final FoodProperties BERRY_TART_FOOD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.5f).build();
    // Used for: HOTDOG
    public static final FoodProperties HOTDOG_FOOD = new FoodProperties.Builder().nutrition(6).saturationModifier(0.7f).build();
    // Used for: CHICKEN_NUGGET
    public static final FoodProperties NUGGET_FOOD = new FoodProperties.Builder().nutrition(1).saturationModifier(0.6f).build();

    // Used for: GOLDEN_BEEF, GOLDEN_PORK
    public static final FoodProperties GOLDEN_BURGER_TIER_1 = new FoodProperties.Builder().nutrition(10).saturationModifier(1.4f)
            .effect(new MobEffectInstance(ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f)
            .effect(new MobEffectInstance(ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).alwaysEdible().build();
    // Used for: GOLDEN_MUTTON, GOLDEN_SALMON
    public static final FoodProperties GOLDEN_BURGER_TIER_2 = new FoodProperties.Builder().nutrition(8).saturationModifier(1.4f)
            .effect(new MobEffectInstance(ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f)
            .effect(new MobEffectInstance(ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).alwaysEdible().build();
    // Used for: GOLDEN_CHICKEN
    public static final FoodProperties GOLDEN_BURGER_TIER_3 = new FoodProperties.Builder().nutrition(8).saturationModifier(1.2f)
            .effect(new MobEffectInstance(ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f)
            .effect(new MobEffectInstance(ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).alwaysEdible().build();
    // Used for: GOLDEN_COD
    public static final FoodProperties GOLDEN_BURGER_TIER_4 = new FoodProperties.Builder().nutrition(7).saturationModifier(1.2f)
            .effect(new MobEffectInstance(ModEffects.GOLDEN_BURGER_REGENERATION), 1.0f)
            .effect(new MobEffectInstance(ModEffects.GOLDEN_BURGER_ABSORPTION), 1.0f).alwaysEdible().build();

    // Used for: ENCHANTED_GOLDEN_BURGER
    public static final FoodProperties ENCHANTED_GOLDEN_BURGER = new FoodProperties.Builder().nutrition(8).saturationModifier(1.6f)
            .effect(new MobEffectInstance(ModEffects.ENCHANTED_GOLDEN_BURGER_REGENERATION), 1.0f)
            .effect(new MobEffectInstance(ModEffects.ENCHANTED_GOLDEN_BURGER_DAMAGE_RESISTANCE), 1.0f)
            .effect(new MobEffectInstance(ModEffects.ENCHANTED_GOLDEN_BURGER_FIRE_RESISTANCE), 1.0f)
            .effect(new MobEffectInstance(ModEffects.ENCHANTED_GOLDEN_BURGER_ABSORPTION), 1.0f).alwaysEdible().build();
}
