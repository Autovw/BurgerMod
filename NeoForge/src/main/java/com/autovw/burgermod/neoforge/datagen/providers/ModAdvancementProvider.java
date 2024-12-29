package com.autovw.burgermod.neoforge.datagen.providers;

import com.autovw.burgermod.common.datagen.ModDataGenHelper;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author Autovw
 */
public class ModAdvancementProvider extends AdvancementProvider
{
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, List.of(new ModHusbandryAdvancements()));
    }

    public static class ModHusbandryAdvancements implements AdvancementSubProvider
    {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer)
        {
            ModDataGenHelper.advancements(registries, consumer);
        }
    }
}
