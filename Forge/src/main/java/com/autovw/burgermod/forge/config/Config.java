package com.autovw.burgermod.forge.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author Autovw
 */
public class Config
{
    public static final ForgeConfigSpec commonConfig;
    public static final Config.Common COMMON;

    static
    {
        final Pair<Common, ForgeConfigSpec> commonConfigPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonConfig = commonConfigPair.getRight();
        COMMON = commonConfigPair.getLeft();
    }
    // Everything above this line is needed to register the main config.

    public static class Common
    {
        public final LootConfig lootConfig;

        public Common(ForgeConfigSpec.Builder builder)
        {
            builder.translation("config.burgermod.common").push("common");
            {
                this.lootConfig = new LootConfig(builder);
            }
            builder.pop();
        }
    }
    // Stuff above this line is needed to register the common config.

    /**
     * Config with options related to the loot modifiers of this mod
     */
    public static class LootConfig
    {
        public static ForgeConfigSpec.BooleanValue generateChestLoot;

        public LootConfig(ForgeConfigSpec.Builder builder)
        {
            builder
                    .comment("Loot related config options")
                    .translation("config.burgermod.common.loot")
                    .push("loot_config");
            {
                generateChestLoot = builder
                        .comment("If true, items from this mod are added to vanilla loot tables. True by default.")
                        .translation("config.burgermod.common.loot.generate_chest_loot")
                        .define("generateChestLoot", true);
            }
            builder.pop();
        }
    }
}
