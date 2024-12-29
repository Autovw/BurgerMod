package com.autovw.burgermod.neoforge.datagen.providers;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.neoforge.core.registry.ModItemRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.Collections;

/**
 * @author Autovw
 */
public class ModModelProvider extends ModelProvider
{
    public ModModelProvider(PackOutput output, String modId)
    {
        super(output, modId);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels)
    {
        /* Burgers */
        itemModel(itemModels, ModItemRegistry.BEEF_BURGER.get());
        itemModel(itemModels, ModItemRegistry.PORK_BURGER.get());
        itemModel(itemModels, ModItemRegistry.MUTTON_BURGER.get());
        itemModel(itemModels, ModItemRegistry.CHICKEN_BURGER.get());
        itemModel(itemModels, ModItemRegistry.SALMON_BURGER.get());
        itemModel(itemModels, ModItemRegistry.COD_BURGER.get());

        itemModel(itemModels, ModItemRegistry.BEEF_CHEESE_BURGER.get());
        itemModel(itemModels, ModItemRegistry.PORK_CHEESE_BURGER.get());
        itemModel(itemModels, ModItemRegistry.MUTTON_CHEESE_BURGER.get());
        itemModel(itemModels, ModItemRegistry.CHICKEN_CHEESE_BURGER.get());
        itemModel(itemModels, ModItemRegistry.SALMON_CHEESE_BURGER.get());
        itemModel(itemModels, ModItemRegistry.COD_CHEESE_BURGER.get());

        itemModel(itemModels, ModItemRegistry.BEEF_CHAMPIGNON_BURGER.get());
        itemModel(itemModels, ModItemRegistry.PORK_CHAMPIGNON_BURGER.get());
        itemModel(itemModels, ModItemRegistry.MUTTON_CHAMPIGNON_BURGER.get());
        itemModel(itemModels, ModItemRegistry.CHICKEN_CHAMPIGNON_BURGER.get());
        itemModel(itemModels, ModItemRegistry.SALMON_CHAMPIGNON_BURGER.get());
        itemModel(itemModels, ModItemRegistry.COD_CHAMPIGNON_BURGER.get());

        /* Golden Burgers */
        itemModel(itemModels, ModItemRegistry.GOLDEN_BEEF_BURGER.get());
        itemModel(itemModels, ModItemRegistry.GOLDEN_PORK_BURGER.get());
        itemModel(itemModels, ModItemRegistry.GOLDEN_MUTTON_BURGER.get());
        itemModel(itemModels, ModItemRegistry.GOLDEN_CHICKEN_BURGER.get());
        itemModel(itemModels, ModItemRegistry.GOLDEN_SALMON_BURGER.get());
        itemModel(itemModels, ModItemRegistry.GOLDEN_COD_BURGER.get());

        /* Enchanted Golden Burger */
        enchantedGoldenBurgerModel(itemModels, ModItemRegistry.ENCHANTED_GOLDEN_BURGER.get());

        /* Ingredients */
        itemModel(itemModels, ModItemRegistry.SCRAMBLED_EGG.get());
        itemModel(itemModels, ModItemRegistry.FRIED_SCRAMBLED_EGG.get());
        itemModel(itemModels, ModItemRegistry.RAW_CHAMPIGNONS.get());
        itemModel(itemModels, ModItemRegistry.COOKED_CHAMPIGNONS.get());
        itemModel(itemModels, ModItemRegistry.CHEESE.get());

        /* Other foods */
        itemModel(itemModels, ModItemRegistry.COOKED_CHICKEN_NUGGET.get());
        itemModel(itemModels, ModItemRegistry.FRIES.get());
        itemModel(itemModels, ModItemRegistry.HOTDOG.get());
        itemModel(itemModels, ModItemRegistry.SWEET_BERRY_TART.get());
    }

    public void itemModel(ItemModelGenerators itemModels, Item item, ResourceLocation texture, ModelTemplate template)
    {
        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.LAYER0, texture);
        itemModels.itemModelOutput.accept(item, new BlockModelWrapper.Unbaked(template.create(item, textureMapping, itemModels.modelOutput), Collections.emptyList()));
    }

    public void itemModel(ItemModelGenerators itemModels, Item item)
    {
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        ResourceLocation textureLoc = ResourceLocation.fromNamespaceAndPath(itemId.getNamespace(), "item/" + itemId.getPath());
        this.itemModel(itemModels, item, textureLoc, ModelTemplates.FLAT_ITEM);
    }

    private void enchantedGoldenBurgerModel(ItemModelGenerators itemModels, Item item)
    {
        ResourceLocation textureLoc = ResourceLocation.fromNamespaceAndPath(BurgerMod.MOD_ID, "item/golden_beef_burger");
        this.itemModel(itemModels, item, textureLoc, ModelTemplates.FLAT_ITEM);
    }
}
