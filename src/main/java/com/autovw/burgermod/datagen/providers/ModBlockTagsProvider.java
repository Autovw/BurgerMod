package com.autovw.burgermod.datagen.providers;

import com.autovw.burgermod.BurgerMod;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

/**
 * Author: Autovw
 */
public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, BurgerMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {}
}
