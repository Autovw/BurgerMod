package com.autovw.burgermod.neoforge.config;

import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * @author Autovw
 */
public class Config
{
    private static final ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
    public static final Config.Common COMMON = new Common(COMMON_BUILDER);
    public static final ModConfigSpec COMMON_SPEC = COMMON_BUILDER.build();

    public static class Common
    {
        public final LootConfig lootConfig;

        public Common(ModConfigSpec.Builder builder)
        {
            builder.push("common");
            {
                this.lootConfig = new LootConfig(builder);
            }
            builder.pop();
        }
    }

    /**
     * Config with options related to the loot modifiers of this mod
     */
    public static class LootConfig
    {
        public static ModConfigSpec.BooleanValue generateChestLoot;

        public LootConfig(ModConfigSpec.Builder builder)
        {
            builder.comment("Loot related config options").push("loot_config");
            {
                generateChestLoot = builder.comment("If true, items from this mod are added to vanilla loot tables. True by default.").define("generateChestLoot", true);
            }
            builder.pop();
        }
    }
}
