package com.autovw.burgermod.forge.datagen.providers;

import com.autovw.burgermod.common.datagen.ModDataGenHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;

import java.util.concurrent.CompletableFuture;

/**
 * @author Autovw
 */
public class ModRecipeProvider extends RecipeProvider
{
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output)
    {
        ModDataGenHelper.recipes(output);
    }
}
