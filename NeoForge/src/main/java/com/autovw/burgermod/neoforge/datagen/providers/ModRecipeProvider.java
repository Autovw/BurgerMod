package com.autovw.burgermod.neoforge.datagen.providers;

import com.autovw.burgermod.common.datagen.ModDataGenHelper;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import org.jspecify.annotations.NonNull;

import java.util.Set;

/**
 * @author Autovw
 */
public class ModRecipeProvider extends RecipeProvider
{
    private final HolderGetter<Item> items;

    public ModRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput)
    {
        super(recipeOutput, advancementOutput);
        this.items = recipeOutput.lookup(Registries.ITEM);
    }

    @Override
    protected void buildRecipes()
    {
        ModDataGenHelper.recipes(this.items, this.output);
    }

    public static MultiRegistryBootstrap create()
    {
        return new MultiRegistryBootstrap()
        {
            @Override
            public @NonNull Set<ResourceKey<? extends Registry<?>>> requestedRegistries()
            {
                return Set.of(Registries.RECIPE, Registries.ADVANCEMENT);
            }

            @Override
            public void run(MultiRegistryBootstrap.BootstrapGetter bootstrap)
            {
                new ModRecipeProvider(bootstrap.get(Registries.RECIPE), bootstrap.get(Registries.ADVANCEMENT)).buildRecipes();
            }
        };
    }
}
