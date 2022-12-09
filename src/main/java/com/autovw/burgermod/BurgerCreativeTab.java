package com.autovw.burgermod;

import com.autovw.burgermod.core.registry.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Autovw
 */
@Mod.EventBusSubscriber(modid = BurgerMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BurgerCreativeTab {
    private BurgerCreativeTab() {
    }

    @SubscribeEvent
    public static void onRegisterCreativeModeTabEvent(final CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(BurgerMod.MOD_ID, ".tab"), builder -> {
            builder.title(Component.translatable("itemGroup." + BurgerMod.MOD_ID + ".tab"))
                    .icon(() -> ModItems.BEEF_BURGER.get().getDefaultInstance())
                    .displayItems((flagSet, entries, flag) -> {
                        ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(entries::accept);
                    });
        });
    }
}
