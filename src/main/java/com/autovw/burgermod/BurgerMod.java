package com.autovw.burgermod;

import com.autovw.burgermod.proxy.IProxy;
import com.autovw.burgermod.util.handlers.RecipeHandler;
import com.autovw.burgermod.util.handlers.RegistryHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * Author: Autovw
 */
@Mod(modid = com.autovw.burgermod.BurgerMod.MODID, name = com.autovw.burgermod.BurgerMod.NAME, version = com.autovw.burgermod.BurgerMod.VERSION)
public class BurgerMod {
    public static final String MODID = "burgermod";
    public static final String NAME = "Burger Mod";
    public static final String VERSION = "@MODVERSION@";

    private static Logger logger;

    @Mod.Instance(NAME)
    public static BurgerMod instance;

    public static final String CLIENT = "com.autovw.burgermod.proxy.ClientProxy";
    public static final String SERVER = "com.autovw.burgermod.proxy.ServerProxy";

    @SidedProxy(clientSide = BurgerMod.CLIENT, serverSide = BurgerMod.SERVER)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("Current {} version found: v{}, check CurseForge for possible updates before reporting issues!", NAME, VERSION);
        RegistryHandler.init();
        RecipeHandler.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Check the {} Wiki for information about the mod: https://github.com/Autovw/BurgerMod/wiki", NAME);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("{} has successfully loaded!", NAME);
    }
}
