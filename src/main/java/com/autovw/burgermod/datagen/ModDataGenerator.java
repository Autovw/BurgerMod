package com.autovw.burgermod.datagen;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.datagen.providers.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

/**
 * Author: Autovw
 */
@Mod.EventBusSubscriber(modid = BurgerMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    private ModDataGenerator() {}

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator, helper);

        if (event.includeServer()) {
            generator.addProvider(blockTagsProvider);
            generator.addProvider(new ModItemTagsProvider(generator, blockTagsProvider, helper));
            generator.addProvider(new ModRecipeProvider(generator));
            generator.addProvider(new ModLootModifierProvider(generator));
        }

        if (event.includeClient()) {
            generator.addProvider(new ModItemModelProvider(generator, helper));
        }
    }
}
