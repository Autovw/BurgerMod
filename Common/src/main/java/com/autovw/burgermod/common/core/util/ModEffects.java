package com.autovw.burgermod.common.core.util;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

/**
 * @author Autovw
 */
public class ModEffects
{
    /* This class stores the effects used by the ModFood class.
     * I moved this to a separate class to make the ModFood class look cleaner.
     */

    // RAW FOODS
    // Stores the poison effects used by Raw Scrambled Egg. p_328066_ = duration, p_330997_ = amplifier
    public static final MobEffectInstance RAW_SCRAMBLED_EGG_EFFECTS = new MobEffectInstance(MobEffects.POISON, 200, 0);

    // Stores the hunger effects used by Raw Champignons.
    public static final MobEffectInstance RAW_CHAMPIGNONS_EFFECTS = new MobEffectInstance(MobEffects.HUNGER, 600, 1);

    // GOLDEN BURGERS
    // Stores the regeneration effects used by Golden Burgers.
    public static final MobEffectInstance GOLDEN_BURGER_REGENERATION = new MobEffectInstance(MobEffects.REGENERATION, 100, 1);

    // Stores the absorption effects used by Golden Burgers.
    public static final MobEffectInstance GOLDEN_BURGER_ABSORPTION = new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0);

    // ENCHANTED GOLDEN BURGER
    // Stores the regeneration effects used by Enchanted Golden Burgers.
    public static final MobEffectInstance ENCHANTED_GOLDEN_BURGER_REGENERATION = new MobEffectInstance(MobEffects.REGENERATION, 400, 1);
    // Stores the damage resistance effects used by Enchanted Golden Burgers.
    public static final MobEffectInstance ENCHANTED_GOLDEN_BURGER_DAMAGE_RESISTANCE = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5000, 0);
    // Stores the fire resistance effects used by Enchanted Golden Burgers.
    public static final MobEffectInstance ENCHANTED_GOLDEN_BURGER_FIRE_RESISTANCE = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 5000, 0);
    // Stores the absorption effects used by Enchanted Golden Burgers.
    public static final MobEffectInstance ENCHANTED_GOLDEN_BURGER_ABSORPTION = new MobEffectInstance(MobEffects.ABSORPTION, 1600, 3);
}
