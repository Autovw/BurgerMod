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

    // ENCHANTED GOLDEN BURGER
    // Stores the regeneration effects used by Enchanted Golden Burgers. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance ENCHANTED_GOLDEN_BURGER_REGENERATION = new MobEffectInstance(MobEffects.REGENERATION,
            Config.EffectsConfig.enchantedGoldenBurgerRegenDuration.get(), Config.EffectsConfig.enchantedGoldenBurgerRegenAmplifier.get());
    // Stores the damage resistance effects used by Enchanted Golden Burgers. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance ENCHANTED_GOLDEN_BURGER_DAMAGE_RESISTANCE = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,
            Config.EffectsConfig.enchantedGoldenBurgerDamageResistDuration.get(), Config.EffectsConfig.enchantedGoldenBurgerDamageResistAmplifier.get());
    // Stores the fire resistance effects used by Enchanted Golden Burgers. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance ENCHANTED_GOLDEN_BURGER_FIRE_RESISTANCE = new MobEffectInstance(MobEffects.FIRE_RESISTANCE,
            Config.EffectsConfig.enchantedGoldenBurgerFireResistDuration.get(), Config.EffectsConfig.enchantedGoldenBurgerFireResistAmplifier.get());
    // Stores the absorption effects used by Enchanted Golden Burgers. The duration and amplifier are stored in the Config.
    public static final MobEffectInstance ENCHANTED_GOLDEN_BURGER_ABSORPTION = new MobEffectInstance(MobEffects.ABSORPTION,
            Config.EffectsConfig.enchantedGoldenBurgerAbsorptionDuration.get(), Config.EffectsConfig.enchantedGoldenBurgerAbsorptionAmplifier.get());
}
