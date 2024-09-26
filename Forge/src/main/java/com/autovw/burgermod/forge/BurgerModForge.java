package com.autovw.burgermod.forge;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.forge.config.Config;
import com.autovw.burgermod.forge.core.registry.ModItemRegistry;
import com.autovw.burgermod.forge.core.registry.ModLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/**
 * @author Autovw
 */
@Mod(BurgerMod.MOD_ID)
public class BurgerModForge
{
    private static final Logger LOGGER = LogUtils.getLogger();

    public BurgerModForge(FMLJavaModLoadingContext context)
    {
        BurgerMod.init(ForgePlatformHelper.getInstance());

        // Registers the common config for Burger Mod
        context.registerConfig(ModConfig.Type.COMMON, Config.commonConfig);

        IEventBus bus = context.getModEventBus();
        bus.addListener(this::commonSetup);

        ModItemRegistry.ITEMS.register(bus);
        ModLootModifiers.LOOT_MODIFIERS.register(bus);
        BurgerCreativeTab.TABS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }
}
