package com.autovw.burgermod.neoforge.datagen.providers;

import com.autovw.burgermod.common.datagen.ModDataGenHelper;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author Autovw
 */
public class ModAdvancementProvider extends AdvancementProvider
{
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper fileHelper)
    {
        super(output, registries, fileHelper, List.of(new ModHusbandryAdvancements()));
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
