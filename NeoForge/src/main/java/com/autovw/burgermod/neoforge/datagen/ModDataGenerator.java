package com.autovw.burgermod.neoforge.datagen;

import com.autovw.burgermod.neoforge.datagen.providers.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static com.autovw.burgermod.common.BurgerMod.MOD_ID;

/**
 * @author Autovw
 */
@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModDataGenerator
{
    private ModDataGenerator()
    {
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void onGatherData(final GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(packOutput, lookupProvider, MOD_ID, helper);

        // server
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), MOD_ID, helper));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModLootModifierProvider(packOutput, lookupProvider, MOD_ID));
        generator.addProvider(event.includeServer(), new ModAdvancementProvider(packOutput, lookupProvider, helper));

        // client
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, MOD_ID, helper));
    }
}
