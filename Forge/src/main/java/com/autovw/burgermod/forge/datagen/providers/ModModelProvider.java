package com.autovw.burgermod.forge.datagen.providers;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.forge.core.registry.ModItemRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author Autovw
 */
public class ModModelProvider extends ModelProvider
{
    private final PackOutput.PathProvider blockStatePathProvider;
    private final PackOutput.PathProvider itemInfoPathProvider;
    private final PackOutput.PathProvider modelPathProvider;
    protected final String modId;

    public ModModelProvider(PackOutput packOutput, String modId)
    {
        super(packOutput);
        this.blockStatePathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "blockstates");
        this.itemInfoPathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "items");
        this.modelPathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models");
        this.modId = modId;
    }

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

    @Override
    public CompletableFuture<?> run(CachedOutput output)
    {
        ItemInfoCollector itemCollector = new ItemInfoCollector(this::getKnownItems);
        BlockStateGeneratorCollector blockStateCollector = new BlockStateGeneratorCollector(this::getKnownBlocks);
        SimpleModelCollector simpleModelCollector = new SimpleModelCollector();
        this.registerModels(new BlockModelGenerators(blockStateCollector, itemCollector, simpleModelCollector), new ItemModelGenerators(itemCollector, simpleModelCollector));
        blockStateCollector.validate();
        itemCollector.finalizeAndValidate();
        return CompletableFuture.allOf(
                blockStateCollector.save(output, this.blockStatePathProvider),
                simpleModelCollector.save(output, this.modelPathProvider),
                itemCollector.save(output, this.itemInfoPathProvider)
        );
    }

    @Override
    protected Stream<Block> getKnownBlocks()
    {
        return BuiltInRegistries.BLOCK.stream()
                .filter((block) -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter((key) -> key.getNamespace().equals(this.modId))
                        .isPresent());
    }

    @Override
    protected Stream<Item> getKnownItems()
    {
        return BuiltInRegistries.ITEM.stream()
                .filter((item) -> Optional.of(BuiltInRegistries.ITEM.getKey(item))
                        .filter((key) -> key.getNamespace().equals(this.modId))
                        .isPresent());
    }
}
