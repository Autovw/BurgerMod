package com.autovw.burgermod;

import com.autovw.burgermod.proxy.IProxy;
import com.autovw.burgermod.util.handlers.RecipeHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = com.autovw.burgermod.BurgerMod.MODID, name = com.autovw.burgermod.BurgerMod.NAME, version = com.autovw.burgermod.BurgerMod.VERSION)
public class BurgerMod
{
    public static final String MODID = "burgermod";
    public static final String NAME = "Burger Mod";
    public static final String VERSION = "1.5.0";

    private static Logger logger;

    @Mod.Instance
    public static BurgerMod instance;

    public static final String CLIENT = "com.autovw.burgermod.proxy.ClientProxy";
    public static final String SERVER = "com.autovw.burgermod.proxy.ServerProxy";
    @SidedProxy(clientSide = BurgerMod.CLIENT, serverSide = BurgerMod.SERVER)
    public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        RecipeHandler.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
