package com.autovw.burgermod.proxy;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Author: Autovw
 */
public class ClientProxy implements IProxy {

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void registerModel(Item item, int metadata) {

    }

    @Override
    public void registerModels() {
        for (Item item: ItemInit.ITEMS) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(BurgerMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
        }
    }
}
