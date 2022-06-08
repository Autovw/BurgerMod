package com.autovw.burgermod.datagen.providers;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * Author: Autovw
 */
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BurgerMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        /* Burgers */
        itemModel(ModItems.BEEF_BURGER.get());
        itemModel(ModItems.PORK_BURGER.get());
        itemModel(ModItems.MUTTON_BURGER.get());
        itemModel(ModItems.CHICKEN_BURGER.get());
        itemModel(ModItems.SALMON_BURGER.get());
        itemModel(ModItems.COD_BURGER.get());

        itemModel(ModItems.BEEF_CHEESE_BURGER.get());
        itemModel(ModItems.PORK_CHEESE_BURGER.get());
        itemModel(ModItems.MUTTON_CHEESE_BURGER.get());
        itemModel(ModItems.CHICKEN_CHEESE_BURGER.get());
        itemModel(ModItems.SALMON_CHEESE_BURGER.get());
        itemModel(ModItems.COD_CHEESE_BURGER.get());

        itemModel(ModItems.BEEF_CHAMPIGNON_BURGER.get());
        itemModel(ModItems.PORK_CHAMPIGNON_BURGER.get());
        itemModel(ModItems.MUTTON_CHAMPIGNON_BURGER.get());
        itemModel(ModItems.CHICKEN_CHAMPIGNON_BURGER.get());
        itemModel(ModItems.SALMON_CHAMPIGNON_BURGER.get());
        itemModel(ModItems.COD_CHAMPIGNON_BURGER.get());

        /* Golden Burgers */
        itemModel(ModItems.GOLDEN_BEEF_BURGER.get());
        itemModel(ModItems.GOLDEN_PORK_BURGER.get());
        itemModel(ModItems.GOLDEN_MUTTON_BURGER.get());
        itemModel(ModItems.GOLDEN_CHICKEN_BURGER.get());
        itemModel(ModItems.GOLDEN_SALMON_BURGER.get());
        itemModel(ModItems.GOLDEN_COD_BURGER.get());

        /* Enchanted Golden Burger */
        itemModel(ModItems.ENCHANTED_GOLDEN_BURGER.get(), new ResourceLocation(BurgerMod.MOD_ID, "items/golden_beef_burger"));

        /* Ingredients */
        itemModel(ModItems.SCRAMBLED_EGG.get());
        itemModel(ModItems.FRIED_SCRAMBLED_EGG.get());
        itemModel(ModItems.RAW_CHAMPIGNONS.get());
        itemModel(ModItems.COOKED_CHAMPIGNONS.get());
        itemModel(ModItems.CHEESE.get());

        /* Other foods */
        itemModel(ModItems.COOKED_CHICKEN_NUGGET.get());
        itemModel(ModItems.FRIES.get());
        itemModel(ModItems.HOTDOG.get());
        itemModel(ModItems.SWEET_BERRY_TART.get());
    }

    /**
     * Simple item model helper method
     *
     * @param item The item for which the model is made
     * @param texture A resource location for the item texture
     * @return The item model
     */
    public ItemModelBuilder itemModel(Item item, ResourceLocation texture) {
        return singleTexture(item.toString(), mcLoc("item/generated"), "layer0", texture);
    }

    private ItemModelBuilder itemModel(Item item) {
        return itemModel(item, new ResourceLocation(BurgerMod.MOD_ID, "items/" + item.toString()));
    }
}
