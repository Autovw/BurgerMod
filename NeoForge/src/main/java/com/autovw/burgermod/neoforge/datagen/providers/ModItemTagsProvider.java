package com.autovw.burgermod.neoforge.datagen.providers;

import com.autovw.burgermod.common.core.util.ModTags;
import com.autovw.burgermod.neoforge.core.registry.ModItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

/**
 * @author Autovw
 */
public class ModItemTagsProvider extends ItemTagsProvider
{
    public ModItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(packOutput, lookupProvider, blockTagsProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries)
    {
        tag(ModTags.BEEF_BURGERS)
                .add(ModItemRegistry.BEEF_BURGER.get())
                .add(ModItemRegistry.BEEF_CHEESE_BURGER.get())
                .add(ModItemRegistry.BEEF_CHAMPIGNON_BURGER.get());

        tag(ModTags.PORK_BURGERS)
                .add(ModItemRegistry.PORK_BURGER.get())
                .add(ModItemRegistry.PORK_CHEESE_BURGER.get())
                .add(ModItemRegistry.PORK_CHAMPIGNON_BURGER.get());

        tag(ModTags.MUTTON_BURGERS)
                .add(ModItemRegistry.MUTTON_BURGER.get())
                .add(ModItemRegistry.MUTTON_CHEESE_BURGER.get())
                .add(ModItemRegistry.MUTTON_CHAMPIGNON_BURGER.get());

        tag(ModTags.CHICKEN_BURGERS)
                .add(ModItemRegistry.CHICKEN_BURGER.get())
                .add(ModItemRegistry.CHICKEN_CHEESE_BURGER.get())
                .add(ModItemRegistry.CHICKEN_CHAMPIGNON_BURGER.get());

        tag(ModTags.SALMON_BURGERS)
                .add(ModItemRegistry.SALMON_BURGER.get())
                .add(ModItemRegistry.SALMON_CHEESE_BURGER.get())
                .add(ModItemRegistry.SALMON_CHAMPIGNON_BURGER.get());

        tag(ModTags.COD_BURGERS)
                .add(ModItemRegistry.COD_BURGER.get())
                .add(ModItemRegistry.COD_CHEESE_BURGER.get())
                .add(ModItemRegistry.COD_CHAMPIGNON_BURGER.get());

        tag(ModTags.CHEESE_BURGERS)
                .add(ModItemRegistry.BEEF_CHEESE_BURGER.get())
                .add(ModItemRegistry.PORK_CHEESE_BURGER.get())
                .add(ModItemRegistry.MUTTON_CHEESE_BURGER.get())
                .add(ModItemRegistry.CHICKEN_CHEESE_BURGER.get())
                .add(ModItemRegistry.SALMON_CHEESE_BURGER.get())
                .add(ModItemRegistry.COD_CHEESE_BURGER.get());

        tag(ModTags.CHAMPIGNON_BURGERS)
                .add(ModItemRegistry.BEEF_CHAMPIGNON_BURGER.get())
                .add(ModItemRegistry.PORK_CHAMPIGNON_BURGER.get())
                .add(ModItemRegistry.MUTTON_CHAMPIGNON_BURGER.get())
                .add(ModItemRegistry.CHICKEN_CHAMPIGNON_BURGER.get())
                .add(ModItemRegistry.SALMON_CHAMPIGNON_BURGER.get())
                .add(ModItemRegistry.COD_CHAMPIGNON_BURGER.get());

        tag(ModTags.EGG_BURGERS)
                .add(ModItemRegistry.BEEF_BURGER.get())
                .add(ModItemRegistry.PORK_BURGER.get())
                .add(ModItemRegistry.MUTTON_BURGER.get())
                .add(ModItemRegistry.CHICKEN_BURGER.get())
                .add(ModItemRegistry.SALMON_BURGER.get())
                .add(ModItemRegistry.COD_BURGER.get());

        tag(ModTags.GOLDEN_BURGERS)
                .add(ModItemRegistry.GOLDEN_BEEF_BURGER.get())
                .add(ModItemRegistry.GOLDEN_PORK_BURGER.get())
                .add(ModItemRegistry.GOLDEN_MUTTON_BURGER.get())
                .add(ModItemRegistry.GOLDEN_CHICKEN_BURGER.get())
                .add(ModItemRegistry.GOLDEN_SALMON_BURGER.get())
                .add(ModItemRegistry.GOLDEN_COD_BURGER.get());

        tag(ModTags.BURGERS)
                .addTag(ModTags.CHAMPIGNON_BURGERS)
                .addTag(ModTags.CHEESE_BURGERS)
                .addTag(ModTags.EGG_BURGERS);

        /* Common tags */
        tag(Tags.Items.NUGGETS)
                .addTag(ModTags.COMMON_NUGGETS_CHICKEN);

        tag(ModTags.COMMON_NUGGETS_CHICKEN)
                .add(ModItemRegistry.COOKED_CHICKEN_NUGGET.get());

        tag(ModTags.COMMON_FOODS_CHEESE)
                .add(ModItemRegistry.CHEESE.get());

        tag(ModTags.COMMON_FOODS_FRIED_EGG)
                .add(ModItemRegistry.FRIED_SCRAMBLED_EGG.get());

        tag(ModTags.COMMON_FOODS_COOKED_MUSHROOM)
                .add(ModItemRegistry.COOKED_CHAMPIGNONS.get());

        tag(Tags.Items.FOODS_GOLDEN)
                .addTag(ModTags.GOLDEN_BURGERS)
                .add(ModItemRegistry.ENCHANTED_GOLDEN_BURGER.get());

        tag(ModTags.COMMON_FOODS_PIE)
                .add(ModItemRegistry.SWEET_BERRY_TART.get());

        tag(Tags.Items.FOODS_FOOD_POISONING)
                .add(ModItemRegistry.SCRAMBLED_EGG.get());

        tag(Tags.Items.FOODS)
                .addTag(ModTags.COMMON_NUGGETS_CHICKEN)
                .addTag(ModTags.COMMON_FOODS_CHEESE)
                .addTag(ModTags.COMMON_FOODS_FRIED_EGG)
                .addTag(ModTags.COMMON_FOODS_COOKED_MUSHROOM)
                .addTag(ModTags.BURGERS)
                .add(ModItemRegistry.RAW_CHAMPIGNONS.get())
                .add(ModItemRegistry.FRIES.get())
                .add(ModItemRegistry.HOTDOG.get())
                .add(ModItemRegistry.SWEET_BERRY_TART.get());

        /* Minecraft tags */
        tag(ItemTags.PIGLIN_LOVED)
                .addTag(ModTags.GOLDEN_BURGERS)
                .add(ModItemRegistry.ENCHANTED_GOLDEN_BURGER.get());

        tag(ItemTags.MEAT)
                .add(ModItemRegistry.COOKED_CHICKEN_NUGGET.get());

        tag(ItemTags.WOLF_FOOD)
                .addTag(ModTags.BEEF_BURGERS)
                .addTag(ModTags.PORK_BURGERS)
                .addTag(ModTags.MUTTON_BURGERS)
                .addTag(ModTags.CHICKEN_BURGERS)
                .add(ModItemRegistry.FRIED_SCRAMBLED_EGG.get())
                .add(ModItemRegistry.HOTDOG.get());
    }
}
