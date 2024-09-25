package com.autovw.burgermod.forge.common.loot;

import com.autovw.burgermod.forge.config.Config;
import com.autovw.burgermod.forge.core.registry.ModItems;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

/**
 * @author Autovw
 * @since 2.8.0, overhauled in 2.9.0 due to breaking changes in Forge
 */
public class LootAdditionModifier extends LootModifier
{
    public static final MapCodec<LootAdditionModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> codecStart(instance)
            .apply(instance, LootAdditionModifier::new));

    /**
     * Constructs a LootAdditionModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public LootAdditionModifier(LootItemCondition[] conditionsIn)
    {
        super(conditionsIn);
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
    {
        ResourceLocation queriedTableId = context.getQueriedLootTableId();
        RandomSource random = context.getRandom();

        // only add loot if generateChestLoot is turned on in the config
        if (Config.LootConfig.generateChestLoot.get())
        {
            // without chance
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/village/village_plains_house"))) {
                generatedLoot.add(new ItemStack(ModItems.FRIES.get(), random.nextIntBetweenInclusive(0, 2)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/village/village_snowy_house"))) {
                generatedLoot.add(new ItemStack(ModItems.HOTDOG.get(), random.nextIntBetweenInclusive(0, 3)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/village/village_butcher"))) {
                generatedLoot.add(new ItemStack(ModItems.COOKED_CHICKEN_NUGGET.get(), random.nextIntBetweenInclusive(2, 5)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/village/village_fisher"))) {
                generatedLoot.add(new ItemStack(ModItems.COD_BURGER.get(), random.nextIntBetweenInclusive(0, 1)));
                generatedLoot.add(new ItemStack(ModItems.SALMON_BURGER.get(), random.nextIntBetweenInclusive(0, 1)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/igloo_chest"))) {
                generatedLoot.add(new ItemStack(ModItems.PORK_CHEESE_BURGER.get(), random.nextIntBetweenInclusive(0, 1)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/simple_dungeon"))) {
                generatedLoot.add(new ItemStack(ModItems.SCRAMBLED_EGG.get(), random.nextIntBetweenInclusive(1, 2)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/woodland_mansion"))) {
                generatedLoot.add(new ItemStack(ModItems.COOKED_CHAMPIGNONS.get(), random.nextIntBetweenInclusive(0, 4)));
                generatedLoot.add(new ItemStack(ModItems.MUTTON_CHAMPIGNON_BURGER.get(), random.nextIntBetweenInclusive(0, 1)));
            }

            // with chance
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/simple_dungeon")) && random.nextFloat() <= 0.25f) {
                generatedLoot.add(new ItemStack(ModItems.GOLDEN_BEEF_BURGER.get(), context.getRandom().nextIntBetweenInclusive(1, 1)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/desert_pyramid")) && random.nextFloat() <= 0.1f) {
                generatedLoot.add(new ItemStack(ModItems.GOLDEN_MUTTON_BURGER.get(), context.getRandom().nextIntBetweenInclusive(1, 1)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/ruined_portal")) && random.nextFloat() <= 0.15f) {
                generatedLoot.add(new ItemStack(ModItems.GOLDEN_PORK_BURGER.get(), context.getRandom().nextIntBetweenInclusive(1, 1)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/bastion_other")) && random.nextFloat() <= 0.2f) {
                generatedLoot.add(new ItemStack(ModItems.GOLDEN_SALMON_BURGER.get(), context.getRandom().nextIntBetweenInclusive(0, 1)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/bastion_hoglin_stable")) && random.nextFloat() <= 0.3f) {
                generatedLoot.add(new ItemStack(ModItems.GOLDEN_CHICKEN_BURGER.get(), context.getRandom().nextIntBetweenInclusive(0, 1)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/bastion_treasure")) && random.nextFloat() <= 0.4f) {
                generatedLoot.add(new ItemStack(ModItems.GOLDEN_PORK_BURGER.get(), context.getRandom().nextIntBetweenInclusive(1, 1)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/bastion_treasure")) && random.nextFloat() <= 0.2f) {
                generatedLoot.add(new ItemStack(ModItems.ENCHANTED_GOLDEN_BURGER.get(), context.getRandom().nextIntBetweenInclusive(0, 1)));
            }
            if (queriedTableId.equals(ResourceLocation.withDefaultNamespace("chests/ancient_city")) && random.nextFloat() <= 0.25f) {
                generatedLoot.add(new ItemStack(ModItems.ENCHANTED_GOLDEN_BURGER.get(), context.getRandom().nextIntBetweenInclusive(0, 1)));
            }
        }

        return generatedLoot;
    }

    @Override
    public MapCodec<LootAdditionModifier> codec()
    {
        return CODEC;
    }
}
