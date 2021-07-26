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

    // RAW FOODS
    // Stores the poison effects used by Raw Scrambled Egg. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance RAW_SCRAMBLED_EGG_EFFECTS = new MobEffectInstance(MobEffects.POISON,
            Config.EffectsConfig.rawEggEffectDuration.get(), Config.EffectsConfig.rawEggEffectAmplifier.get());

    // Stores the hunger effects used by Raw Champignons. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance RAW_CHAMPIGNONS_EFFECTS = new MobEffectInstance(MobEffects.HUNGER,
            Config.EffectsConfig.rawChampignonEffectDuration.get(), Config.EffectsConfig.rawChampignonEffectAmplifier.get());

    // GOLDEN BURGERS
    // Stores the regeneration effects used by Golden Burgers. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance GOLDEN_BURGER_REGENERATION = new MobEffectInstance(MobEffects.REGENERATION,
            Config.EffectsConfig.goldenBurgerRegenDuration.get(), Config.EffectsConfig.goldenBurgerRegenAmplifier.get());

    // Stores the absorption effects used by Golden Burgers. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance GOLDEN_BURGER_ABSORPTION = new MobEffectInstance(MobEffects.ABSORPTION,
            Config.EffectsConfig.goldenBurgerAbsorptionDuration.get(), Config.EffectsConfig.goldenBurgerAbsorptionAmplifier.get());
}