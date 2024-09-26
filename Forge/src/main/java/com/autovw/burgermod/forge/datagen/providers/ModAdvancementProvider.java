package com.autovw.burgermod.forge.datagen.providers;

import com.autovw.burgermod.common.datagen.ModDataGenHelper;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author Autovw
 */
public class ModAdvancementProvider extends ForgeAdvancementProvider
{
    public ModAdvancementProvider(PackOutput pack, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper)
    {
        super(pack, registries, existingFileHelper, List.of(new ModHusbandryAdvancements()));
    }

    public static class ModHusbandryAdvancements implements AdvancementGenerator
    {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper fileHelper)
        {
            ModDataGenHelper.advancements(registries, consumer);
        }
    }
}
