package com.autovw.burgermod.neoforge.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

/**
 * @author Autovw
 */
public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId)
    {
        super(output, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries)
    {
    }
}
