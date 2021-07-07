package com.autovw.burgermod.core;

import com.autovw.burgermod.config.Config;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

/**
 * Author: Autovw
 */
public class ModEffects {
    /* This class stores the effects used by the ModFood class.
     * I moved this to a separate class to make the ModFood class look cleaner.
     */

    // RAW FOODS
    // Stores the poison effects used by Raw Scrambled Egg. The duration and amplifier are stored in the Config.
    public static final EffectInstance RAW_SCRAMBLED_EGG_EFFECTS = new EffectInstance(Effects.POISON,
            Config.EffectsConfig.rawEggEffectDuration.get(), Config.EffectsConfig.rawEggEffectAmplifier.get());

    // Stores the hunger effects used by Raw Champignons. The duration and amplifier are stored in the Config.
    public static final EffectInstance RAW_CHAMPIGNONS_EFFECTS = new EffectInstance(Effects.HUNGER,
            Config.EffectsConfig.rawChampignonEffectDuration.get(), Config.EffectsConfig.rawChampignonEffectAmplifier.get());

    // GOLDEN BURGERS
    // Stores the regeneration effects used by Golden Burgers. The duration and amplifier are stored in the Config.
    public static final EffectInstance GOLDEN_BURGER_REGENERATION = new EffectInstance(Effects.REGENERATION,
            Config.EffectsConfig.goldenBurgerRegenDuration.get(), Config.EffectsConfig.goldenBurgerRegenAmplifier.get());

    // Stores the absorption effects used by Golden Burgers. The duration and amplifier are stored in the Config.
    public static final EffectInstance GOLDEN_BURGER_ABSORPTION = new EffectInstance(Effects.ABSORPTION,
            Config.EffectsConfig.goldenBurgerAbsorptionDuration.get(), Config.EffectsConfig.goldenBurgerAbsorptionAmplifier.get());
}