package com.autovw.burgermod;

import com.autovw.burgermod.core.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
    public static final ItemGroup TAB_BURGERMOD = new BurgerMod.BurgerModItemGroup("burgermod_group");

    public BurgerMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        ModItems.ITEMS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    //Creative Inventory tab
    public static class BurgerModItemGroup extends ItemGroup {

        public BurgerModItemGroup(String name) {
            super(name);
        }

        @Override
        public ItemStack makeIcon() {
            return ModItems.BEEF_BURGER.get().getDefaultInstance();
        }
    }
}
