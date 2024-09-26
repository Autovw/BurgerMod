package com.autovw.burgermod.neoforge.datagen.providers;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.neoforge.core.registry.ModItemRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * @author Autovw
 */
public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output, String modId, ExistingFileHelper existingFileHelper)
    {
        super(output, modId, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        /* Burgers */
        itemModel(ModItemRegistry.BEEF_BURGER.get());
        itemModel(ModItemRegistry.PORK_BURGER.get());
        itemModel(ModItemRegistry.MUTTON_BURGER.get());
        itemModel(ModItemRegistry.CHICKEN_BURGER.get());
        itemModel(ModItemRegistry.SALMON_BURGER.get());
        itemModel(ModItemRegistry.COD_BURGER.get());

        itemModel(ModItemRegistry.BEEF_CHEESE_BURGER.get());
        itemModel(ModItemRegistry.PORK_CHEESE_BURGER.get());
        itemModel(ModItemRegistry.MUTTON_CHEESE_BURGER.get());
        itemModel(ModItemRegistry.CHICKEN_CHEESE_BURGER.get());
        itemModel(ModItemRegistry.SALMON_CHEESE_BURGER.get());
        itemModel(ModItemRegistry.COD_CHEESE_BURGER.get());

        itemModel(ModItemRegistry.BEEF_CHAMPIGNON_BURGER.get());
        itemModel(ModItemRegistry.PORK_CHAMPIGNON_BURGER.get());
        itemModel(ModItemRegistry.MUTTON_CHAMPIGNON_BURGER.get());
        itemModel(ModItemRegistry.CHICKEN_CHAMPIGNON_BURGER.get());
        itemModel(ModItemRegistry.SALMON_CHAMPIGNON_BURGER.get());
        itemModel(ModItemRegistry.COD_CHAMPIGNON_BURGER.get());

        /* Golden Burgers */
        itemModel(ModItemRegistry.GOLDEN_BEEF_BURGER.get());
        itemModel(ModItemRegistry.GOLDEN_PORK_BURGER.get());
        itemModel(ModItemRegistry.GOLDEN_MUTTON_BURGER.get());
        itemModel(ModItemRegistry.GOLDEN_CHICKEN_BURGER.get());
        itemModel(ModItemRegistry.GOLDEN_SALMON_BURGER.get());
        itemModel(ModItemRegistry.GOLDEN_COD_BURGER.get());

        /* Enchanted Golden Burger */
        itemModel(ModItemRegistry.ENCHANTED_GOLDEN_BURGER.get(), ResourceLocation.fromNamespaceAndPath(BurgerMod.MOD_ID, "item/golden_beef_burger"));

        /* Ingredients */
        itemModel(ModItemRegistry.SCRAMBLED_EGG.get());
        itemModel(ModItemRegistry.FRIED_SCRAMBLED_EGG.get());
        itemModel(ModItemRegistry.RAW_CHAMPIGNONS.get());
        itemModel(ModItemRegistry.COOKED_CHAMPIGNONS.get());
        itemModel(ModItemRegistry.CHEESE.get());

        /* Other foods */
        itemModel(ModItemRegistry.COOKED_CHICKEN_NUGGET.get());
        itemModel(ModItemRegistry.FRIES.get());
        itemModel(ModItemRegistry.HOTDOG.get());
        itemModel(ModItemRegistry.SWEET_BERRY_TART.get());
    }

    /**
     * Simple item model helper method
     *
     * @param item The item for which the model is made
     * @param texture A resource location for the item texture
     * @return The item model
     */
    public ItemModelBuilder itemModel(Item item, ResourceLocation texture)
    {
        return singleTexture(item.toString(), mcLoc("item/generated"), "layer0", texture);
    }

    private ItemModelBuilder itemModel(Item item)
    {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        return itemModel(item, ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + id.getPath()));
    }
}
