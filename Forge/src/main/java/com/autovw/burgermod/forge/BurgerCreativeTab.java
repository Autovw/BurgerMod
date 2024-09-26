package com.autovw.burgermod.forge;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.forge.core.registry.ModItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Autovw
 */
@Mod.EventBusSubscriber(modid = BurgerMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class BurgerCreativeTab
{
    private BurgerCreativeTab()
    {
    }

    static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BurgerMod.MOD_ID);
    static final RegistryObject<CreativeModeTab> TAB = TABS.register("tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + BurgerMod.MOD_ID + ".tab"))
            .icon(() -> ModItemRegistry.BEEF_BURGER.get().getDefaultInstance())
            .build());

    @SubscribeEvent
    public static void onRegisterCreativeModeTabEvent(final BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTab() != BurgerCreativeTab.TAB.get())
            return;

        ModItemRegistry.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(event::accept);
    }
}
