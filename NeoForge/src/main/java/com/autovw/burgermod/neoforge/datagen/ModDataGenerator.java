package com.autovw.burgermod.neoforge.datagen;

import com.autovw.burgermod.neoforge.datagen.providers.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static com.autovw.burgermod.common.BurgerMod.MOD_ID;

/**
 * @author Autovw
 */
@EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
public class ModDataGenerator
{
    private ModDataGenerator()
    {
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void onGatherData(final GatherDataEvent.Client event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // server
        event.addProvider(new ModItemTagsProvider(packOutput, lookupProvider, MOD_ID));
        event.addProvider(new ModRecipeProvider.Runner(packOutput, lookupProvider));
        event.addProvider(new ModLootModifierProvider(packOutput, lookupProvider, MOD_ID));
        event.addProvider(new ModAdvancementProvider(packOutput, lookupProvider));

        // client
        event.addProvider(new ModModelProvider(packOutput, MOD_ID));
    }
}
