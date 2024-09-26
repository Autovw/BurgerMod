package com.autovw.burgermod.neoforge;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.neoforge.config.Config;
import com.autovw.burgermod.neoforge.core.registry.ModItemRegistry;
import com.autovw.burgermod.neoforge.core.registry.ModLootModifiers;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

/**
 * @author Autovw
 */
@Mod(BurgerMod.MOD_ID)
public class BurgerModNeoForge
{
    private static final Logger LOGGER = LogUtils.getLogger();

    public BurgerModNeoForge(IEventBus bus, ModContainer container)
    {
        BurgerMod.init(NeoForgePlatformHelper.getInstance());

        container.registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);

        bus.addListener(this::commonSetup);

        ModItemRegistry.ITEMS.register(bus);
        ModLootModifiers.LOOT_MODIFIERS.register(bus);
        BurgerCreativeTab.TABS.register(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }
}
