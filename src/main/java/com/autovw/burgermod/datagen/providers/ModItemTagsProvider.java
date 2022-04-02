package com.autovw.burgermod.datagen.providers;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.ModItems;
import com.autovw.burgermod.core.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

/**
 * Author: Autovw
 */
public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, BurgerMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        /* Tags added by the mod */
        tag(ModTags.BEEF_BURGERS)
                .add(ModItems.BEEF_BURGER.get())
                .add(ModItems.BEEF_CHEESE_BURGER.get())
                .add(ModItems.BEEF_CHAMPIGNON_BURGER.get());

        tag(ModTags.PORK_BURGERS)
                .add(ModItems.PORK_BURGER.get())
                .add(ModItems.PORK_CHEESE_BURGER.get())
                .add(ModItems.PORK_CHAMPIGNON_BURGER.get());

        tag(ModTags.MUTTON_BURGERS)
                .add(ModItems.MUTTON_BURGER.get())
                .add(ModItems.MUTTON_CHEESE_BURGER.get())
                .add(ModItems.MUTTON_CHAMPIGNON_BURGER.get());

        tag(ModTags.CHICKEN_BURGERS)
                .add(ModItems.CHICKEN_BURGER.get())
                .add(ModItems.CHICKEN_CHEESE_BURGER.get())
                .add(ModItems.CHICKEN_CHAMPIGNON_BURGER.get());

        tag(ModTags.SALMON_BURGERS)
                .add(ModItems.SALMON_BURGER.get())
                .add(ModItems.SALMON_CHEESE_BURGER.get())
                .add(ModItems.SALMON_CHAMPIGNON_BURGER.get());

        tag(ModTags.COD_BURGERS)
                .add(ModItems.COD_BURGER.get())
                .add(ModItems.COD_CHEESE_BURGER.get())
                .add(ModItems.COD_CHAMPIGNON_BURGER.get());

        tag(ModTags.CHEESE_BURGERS)
                .add(ModItems.BEEF_CHEESE_BURGER.get())
                .add(ModItems.PORK_CHEESE_BURGER.get())
                .add(ModItems.MUTTON_CHEESE_BURGER.get())
                .add(ModItems.CHICKEN_CHEESE_BURGER.get())
                .add(ModItems.SALMON_CHEESE_BURGER.get())
                .add(ModItems.COD_CHEESE_BURGER.get());

        tag(ModTags.CHAMPIGNON_BURGERS)
                .add(ModItems.BEEF_CHAMPIGNON_BURGER.get())
                .add(ModItems.PORK_CHAMPIGNON_BURGER.get())
                .add(ModItems.MUTTON_CHAMPIGNON_BURGER.get())
                .add(ModItems.CHICKEN_CHAMPIGNON_BURGER.get())
                .add(ModItems.SALMON_CHAMPIGNON_BURGER.get())
                .add(ModItems.COD_CHAMPIGNON_BURGER.get());

        tag(ModTags.EGG_BURGERS)
                .add(ModItems.BEEF_BURGER.get())
                .add(ModItems.PORK_BURGER.get())
                .add(ModItems.MUTTON_BURGER.get())
                .add(ModItems.CHICKEN_BURGER.get())
                .add(ModItems.SALMON_BURGER.get())
                .add(ModItems.COD_BURGER.get());

        tag(ModTags.GOLDEN_BURGERS)
                .add(ModItems.GOLDEN_BEEF_BURGER.get())
                .add(ModItems.GOLDEN_PORK_BURGER.get())
                .add(ModItems.GOLDEN_MUTTON_BURGER.get())
                .add(ModItems.GOLDEN_CHICKEN_BURGER.get())
                .add(ModItems.GOLDEN_SALMON_BURGER.get())
                .add(ModItems.GOLDEN_COD_BURGER.get());

        tag(ModTags.BURGERS)
                .addTag(ModTags.CHAMPIGNON_BURGERS)
                .addTag(ModTags.CHEESE_BURGERS)
                .addTag(ModTags.EGG_BURGERS);

        /* Forge tags */
        tag(Tags.Items.NUGGETS)
                .addTag(ModTags.FORGE_NUGGETS_CHICKEN);

        tag(ModTags.FORGE_NUGGETS_CHICKEN)
                .add(ModItems.COOKED_CHICKEN_NUGGET.get());

        tag(ModTags.FORGE_CHEESE)
                .add(ModItems.CHEESE.get());

        tag(ModTags.FORGE_FRIED_EGG)
                .add(ModItems.FRIED_SCRAMBLED_EGG.get());

        tag(ModTags.FORGE_COOKED_MUSHROOM)
                .add(ModItems.COOKED_CHAMPIGNONS.get());

        tag(ModTags.FORGE_BREAD)
                .add(Items.BREAD);

        /* Minecraft tags */
        tag(ItemTags.PIGLIN_LOVED)
                .addTag(ModTags.GOLDEN_BURGERS)
                .add(ModItems.ENCHANTED_GOLDEN_BURGER.get());
    }
}
