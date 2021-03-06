package com.autovw.burgermod.datagen;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.datagen.providers.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: Autovw
 */
@Mod.EventBusSubscriber(modid = BurgerMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    private ModDataGenerator() {
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator, helper);

        // server
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(generator, blockTagsProvider, helper));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));
        generator.addProvider(event.includeServer(), new ModLootModifierProvider(generator));
        generator.addProvider(event.includeServer(), new ModAdvancementProvider(generator, helper));

        // client
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, helper));
    }
}
