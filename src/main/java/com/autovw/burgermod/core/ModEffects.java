package com.autovw.burgermod.core;

import com.autovw.burgermod.config.Config;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

/**
 * Author: Autovw
 */
public class ModEffects {
    /* This class stores the effects used by the ModFood class.
     * I moved this to a separate class to make the ModFood class look cleaner.
     */

    /* f_19614_ = POISON
     * f_19612_ = HUNGER
     * f_19605_ = REGENERATION
     * f_19617_ = ABSORPTION
     *
     * Effects and EffectInstance got renamed to MobEffects and MobEffectInstance, Mojang why?
     */

    // RAW FOODS
    // Stores the poison effects used by Raw Scrambled Egg. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance RAW_SCRAMBLED_EGG_EFFECTS = new MobEffectInstance(MobEffects.f_19614_,
            Config.EffectsConfig.rawEggEffectDuration.get(), Config.EffectsConfig.rawEggEffectAmplifier.get());

    // Stores the hunger effects used by Raw Champignons. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance RAW_CHAMPIGNONS_EFFECTS = new MobEffectInstance(MobEffects.f_19612_,
            Config.EffectsConfig.rawChampignonEffectDuration.get(), Config.EffectsConfig.rawChampignonEffectAmplifier.get());

    // GOLDEN BURGERS
    // Stores the regeneration effects used by Golden Burgers. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance GOLDEN_BURGER_REGENERATION = new MobEffectInstance(MobEffects.f_19605_,
            Config.EffectsConfig.goldenBurgerRegenDuration.get(), Config.EffectsConfig.goldenBurgerRegenAmplifier.get());

    // Stores the absorption effects used by Golden Burgers. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance GOLDEN_BURGER_ABSORPTION = new MobEffectInstance(MobEffects.f_19617_,
            Config.EffectsConfig.goldenBurgerAbsorptionDuration.get(), Config.EffectsConfig.goldenBurgerAbsorptionAmplifier.get());
}