package com.autovw.burgermod.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Author: Autovw
 */
public class Config {
    public static final ForgeConfigSpec commonConfig;
    public static final Config.Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonConfigPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonConfig = commonConfigPair.getRight();
        COMMON = commonConfigPair.getLeft();
    }
    // Everything above this line is needed to register the main config.

    public static class Common {
        public final EffectsConfig effectsConfig;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("common");
            {
                this.effectsConfig = new EffectsConfig(builder);
            }
            builder.pop();
        }
    }
    // Stuff above this line is needed to register the common config.

    /**
     * This is the EffectsConfig.
     * This config stores effects properties which are utilized in the ModEffects class.
     */
    public static class EffectsConfig {
        public static ForgeConfigSpec.ConfigValue<Integer> rawEggEffectDuration;
        public static ForgeConfigSpec.ConfigValue<Integer> rawEggEffectAmplifier;
        public static ForgeConfigSpec.ConfigValue<Integer> rawChampignonEffectDuration;
        public static ForgeConfigSpec.ConfigValue<Integer> rawChampignonEffectAmplifier;
        public static ForgeConfigSpec.ConfigValue<Integer> goldenBurgerRegenDuration;
        public static ForgeConfigSpec.ConfigValue<Integer> goldenBurgerRegenAmplifier;
        public static ForgeConfigSpec.ConfigValue<Integer> goldenBurgerAbsorptionDuration;
        public static ForgeConfigSpec.ConfigValue<Integer> goldenBurgerAbsorptionAmplifier;
        /* Delayed until the next major update!
        public static ForgeConfigSpec.ConfigValue<Integer> enchantedGoldenBurgerRegenDuration;
        public static ForgeConfigSpec.ConfigValue<Integer> enchantedGoldenBurgerRegenAmplifier;
        public static ForgeConfigSpec.ConfigValue<Integer> enchantedGoldenBurgerDamageResistDuration;
        public static ForgeConfigSpec.ConfigValue<Integer> enchantedGoldenBurgerDamageResistAmplifier;
        public static ForgeConfigSpec.ConfigValue<Integer> enchantedGoldenBurgerFireResistDuration;
        public static ForgeConfigSpec.ConfigValue<Integer> enchantedGoldenBurgerFireResistAmplifier;
        public static ForgeConfigSpec.ConfigValue<Integer> enchantedGoldenBurgerAbsorptionDuration;
        public static ForgeConfigSpec.ConfigValue<Integer> enchantedGoldenBurgerAbsorptionAmplifier;
         */

        public EffectsConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Properties related to Burger Mod effects").push("effects_config");
            {
                rawEggEffectDuration = builder.comment("Adjust the effect duration in ticks here. 20 ticks = 1 second, 200 ticks = 10 seconds etc.").define("rawEggEffectDuration", 200);
                rawEggEffectAmplifier = builder.comment("Adjust the effect level here. 0 = level 1, 1 = level 2 etc.").define("rawEggEffectAmplifier", 0);
                rawChampignonEffectDuration = builder.comment("Adjust the effect duration in ticks here. 20 ticks = 1 second, 200 ticks = 10 seconds etc.").define("rawChampignonEffectDuration", 600);
                rawChampignonEffectAmplifier = builder.comment("Adjust the effect level here. 0 = level 1, 1 = level 2 etc.").define("rawChampignonEffectAmplifier", 1);
                
                builder.comment("Properties related to Golden Burger effects").push("golden_burger_effects");
                {
                    goldenBurgerRegenDuration = builder.comment("Adjust the regeneration effect duration in ticks here. 20 ticks = 1 second, 200 ticks = 10 seconds etc.").define("goldenBurgerRegenDuration", 100);
                    goldenBurgerRegenAmplifier = builder.comment("Adjust the regeneration effect level here. 0 = level 1, 1 = level 2 etc.").define("goldenBurgerRegenAmplifier", 1);
                    goldenBurgerAbsorptionDuration = builder.comment("Adjust the absorption effect duration in ticks here. 20 ticks = 1 second, 200 ticks = 10 seconds etc.").define("goldenBurgerAbsorptionDuration", 1200);
                    goldenBurgerAbsorptionAmplifier = builder.comment("Adjust the absorption effect level here. 0 = level 1, 1 = level 2 etc.").define("goldenBurgerAbsorptionAmplifier", 0);
                }
                builder.pop();

                /* Delayed until the next major update!
                builder.comment("Properties related to Enchanted Golden Burger effects").push("enchanted_golden_burger_effects");
                {
                    enchantedGoldenBurgerRegenDuration = builder.comment("Adjust the regeneration effect duration in ticks here. 20 ticks = 1 second, 200 ticks = 10 seconds etc.").define("enchantedGoldenBurgerRegenDuration", 400);
                    enchantedGoldenBurgerRegenAmplifier = builder.comment("Adjust the regeneration effect level here. 0 = level 1, 1 = level 2 etc.").define("enchantedGoldenBurgerRegenAmplifier", 1);
                    enchantedGoldenBurgerDamageResistDuration = builder.comment("Adjust the damage resistance effect duration in ticks here. 20 ticks = 1 second, 200 ticks = 10 seconds etc.").define("enchantedGoldenBurgerDamageResistDuration", 5000);
                    enchantedGoldenBurgerDamageResistAmplifier = builder.comment("Adjust the damage resistance effect level here. 0 = level 1, 1 = level 2 etc.").define("enchantedGoldenBurgerDamageResistAmplifier", 0);
                    enchantedGoldenBurgerFireResistDuration = builder.comment("Adjust the fire resistance effect duration in ticks here. 20 ticks = 1 second, 200 ticks = 10 seconds etc.").define("enchantedGoldenBurgerFireResistDuration", 5000);
                    enchantedGoldenBurgerFireResistAmplifier = builder.comment("Adjust the fire resistance effect level here. 0 = level 1, 1 = level 2 etc.").define("enchantedGoldenBurgerFireResistAmplifier", 0);
                    enchantedGoldenBurgerAbsorptionDuration = builder.comment("Adjust the absorption effect duration in ticks here. 20 ticks = 1 second, 200 ticks = 10 seconds etc.").define("enchantedGoldenBurgerAbsorptionDuration", 1600);
                    enchantedGoldenBurgerAbsorptionAmplifier = builder.comment("Adjust the absorption effect level here. 0 = level 1, 1 = level 2 etc.").define("enchantedGoldenBurgerAbsorptionAmplifier", 3);
                }
                builder.pop();
                 */
            }
            builder.pop();
        }
    }
}
