package com.autovw.burgermod.neoforge.datagen.providers;

import com.autovw.burgermod.common.datagen.ModDataGenHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

/**
 * @author Autovw
 */
public class ModRecipeProvider extends RecipeProvider
{
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput recipeOutput)
    {
        super(registries, recipeOutput);
    }

    @Override
    protected void buildRecipes()
    {
        ModDataGenHelper.recipes(this.registries, this.output);
    }

    public static class Runner extends RecipeProvider.Runner
    {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
        {
            super(output, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput recipeOutput)
        {
            return new ModRecipeProvider(lookupProvider, recipeOutput);
        }

        @Override
        public String getName()
        {
            return "Burger Mod Recipe Provider";
        }
    }
}
