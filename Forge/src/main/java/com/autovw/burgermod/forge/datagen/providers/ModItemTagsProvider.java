package com.autovw.burgermod.forge.datagen.providers;

import com.autovw.burgermod.forge.core.registry.ModItemRegistry;
import com.autovw.burgermod.common.core.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * @author Autovw
 */
public class ModItemTagsProvider extends ItemTagsProvider
{
    public ModItemTagsProvider(PackOutput pack, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagLookup<Block>> blockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(pack, registries, blockTagsProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries)
    {
        /* Tags added by the mod */
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
                .addTag(ModTags.FORGE_NUGGETS_CHICKEN) // added for backwards compatibility
                .add(ModItemRegistry.COOKED_CHICKEN_NUGGET.get());

        tag(ModTags.COMMON_FOODS_CHEESE)
                .addTag(ModTags.FORGE_CHEESE) // added for backwards compatibility
                .add(ModItemRegistry.CHEESE.get());

        tag(ModTags.COMMON_FOODS_FRIED_EGG)
                .addTag(ModTags.FORGE_FRIED_EGG) // added for backwards compatibility
                .add(ModItemRegistry.FRIED_SCRAMBLED_EGG.get());

        tag(ModTags.COMMON_FOODS_COOKED_MUSHROOM)
                .addTag(ModTags.FORGE_COOKED_MUSHROOM) // added for backwards compatibility
                .add(ModItemRegistry.COOKED_CHAMPIGNONS.get());

        tag(ModTags.COMMON_FOODS_BREAD)
                .addTag(ModTags.FORGE_BREAD); // added for backwards compatibility

        tag(Tags.Items.FOODS_GOLDEN)
                .addTag(ModTags.GOLDEN_BURGERS)
                .add(ModItemRegistry.ENCHANTED_GOLDEN_BURGER.get());

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

        tag(ModTags.COMMON_EGGS)
                .addTag(ModTags.FORGE_EGGS) // added for backwards compatibility
                .add(Items.EGG);

        /* Forge tags */
        tag(Tags.Items.NUGGETS)
                .addTag(ModTags.FORGE_NUGGETS_CHICKEN);

        tag(ModTags.FORGE_NUGGETS_CHICKEN)
                .add(ModItemRegistry.COOKED_CHICKEN_NUGGET.get());

        tag(ModTags.FORGE_CHEESE)
                .add(ModItemRegistry.CHEESE.get());

        tag(ModTags.FORGE_FRIED_EGG)
                .add(ModItemRegistry.FRIED_SCRAMBLED_EGG.get());

        tag(ModTags.FORGE_COOKED_MUSHROOM)
                .add(ModItemRegistry.COOKED_CHAMPIGNONS.get());

        tag(ModTags.FORGE_BREAD)
                .add(Items.BREAD);

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
