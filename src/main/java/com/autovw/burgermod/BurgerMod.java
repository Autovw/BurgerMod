package com.autovw.burgermod;

import com.autovw.burgermod.config.Config;
import com.autovw.burgermod.core.registry.ModItems;
import com.autovw.burgermod.core.registry.ModLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/**
 * @author Autovw
 */
@Mod(BurgerMod.MOD_ID)
public class BurgerMod {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "burgermod";

    public BurgerMod() {
        // Registers the common config for Burger Mod
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.commonConfig);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);

        ModItems.ITEMS.register(bus);
        ModLootModifiers.LOOT_MODIFIERS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}
