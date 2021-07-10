package com.autovw.burgermod;

import com.autovw.burgermod.config.Config;
import com.autovw.burgermod.core.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Author: Autovw
 */
@Mod(BurgerMod.MOD_ID)
public class BurgerMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "burgermod";
    public static final ItemGroup TAB_BURGERMOD = new BurgerGroup("burgermod_group");

    public BurgerMod() {
        // Used to register the common config.
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.commonConfig);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        // Used to register the ModItems class and everything inside of it.
        ModItems.ITEMS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }
}
