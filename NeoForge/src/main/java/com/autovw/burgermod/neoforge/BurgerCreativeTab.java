package com.autovw.burgermod.neoforge;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.neoforge.core.registry.ModItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * @author Autovw
 */
@EventBusSubscriber(modid = BurgerMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class BurgerCreativeTab
{
    private BurgerCreativeTab()
    {
    }

    static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BurgerMod.MOD_ID);
    static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = TABS.register("tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + BurgerMod.MOD_ID + ".tab"))
            .icon(ModItemRegistry.BEEF_BURGER.get()::getDefaultInstance)
            .build());

    @SubscribeEvent
    public static void onBuildCreativeModeTabContentsEvent(final BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTab() != BurgerCreativeTab.TAB.get())
            return;

        ModItemRegistry.ITEMS.getEntries().stream().map(DeferredHolder::get).forEach(event::accept);
    }
}
