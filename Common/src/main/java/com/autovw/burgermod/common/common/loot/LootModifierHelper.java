package com.autovw.burgermod.common.common.loot;

import com.autovw.burgermod.common.core.ModItems;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;

/**
 * @author Autovw
 */
public final class LootModifierHelper
{
    public static void modifiedGeneratedLoot(ObjectArrayList<ItemStack> generatedLoot, LootContext context, ResourceLocation lootTableId)
    {
        RandomSource random = context.getRandom();

        // without chance
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/village/village_plains_house"))) {
            generatedLoot.add(new ItemStack(ModItems.FRIES, random.nextIntBetweenInclusive(0, 2)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/village/village_snowy_house"))) {
            generatedLoot.add(new ItemStack(ModItems.HOTDOG, random.nextIntBetweenInclusive(0, 3)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/village/village_butcher"))) {
            generatedLoot.add(new ItemStack(ModItems.COOKED_CHICKEN_NUGGET, random.nextIntBetweenInclusive(2, 5)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/village/village_fisher"))) {
            generatedLoot.add(new ItemStack(ModItems.COD_BURGER, random.nextIntBetweenInclusive(0, 1)));
            generatedLoot.add(new ItemStack(ModItems.SALMON_BURGER, random.nextIntBetweenInclusive(0, 1)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/igloo_chest"))) {
            generatedLoot.add(new ItemStack(ModItems.PORK_CHEESE_BURGER, random.nextIntBetweenInclusive(0, 1)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/simple_dungeon"))) {
            generatedLoot.add(new ItemStack(ModItems.SCRAMBLED_EGG, random.nextIntBetweenInclusive(1, 2)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/woodland_mansion"))) {
            generatedLoot.add(new ItemStack(ModItems.COOKED_CHAMPIGNONS, random.nextIntBetweenInclusive(0, 4)));
            generatedLoot.add(new ItemStack(ModItems.MUTTON_CHAMPIGNON_BURGER, random.nextIntBetweenInclusive(0, 1)));
        }

        // with chance
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/simple_dungeon")) && random.nextFloat() <= 0.25f) {
            generatedLoot.add(new ItemStack(ModItems.GOLDEN_BEEF_BURGER, context.getRandom().nextIntBetweenInclusive(1, 1)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/desert_pyramid")) && random.nextFloat() <= 0.1f) {
            generatedLoot.add(new ItemStack(ModItems.GOLDEN_MUTTON_BURGER, context.getRandom().nextIntBetweenInclusive(1, 1)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/ruined_portal")) && random.nextFloat() <= 0.15f) {
            generatedLoot.add(new ItemStack(ModItems.GOLDEN_PORK_BURGER, context.getRandom().nextIntBetweenInclusive(1, 1)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/bastion_other")) && random.nextFloat() <= 0.2f) {
            generatedLoot.add(new ItemStack(ModItems.GOLDEN_SALMON_BURGER, context.getRandom().nextIntBetweenInclusive(0, 1)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/bastion_hoglin_stable")) && random.nextFloat() <= 0.3f) {
            generatedLoot.add(new ItemStack(ModItems.GOLDEN_CHICKEN_BURGER, context.getRandom().nextIntBetweenInclusive(0, 1)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/bastion_treasure")) && random.nextFloat() <= 0.4f) {
            generatedLoot.add(new ItemStack(ModItems.GOLDEN_PORK_BURGER, context.getRandom().nextIntBetweenInclusive(1, 1)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/bastion_treasure")) && random.nextFloat() <= 0.2f) {
            generatedLoot.add(new ItemStack(ModItems.ENCHANTED_GOLDEN_BURGER, context.getRandom().nextIntBetweenInclusive(0, 1)));
        }
        if (lootTableId.equals(ResourceLocation.withDefaultNamespace("chests/ancient_city")) && random.nextFloat() <= 0.25f) {
            generatedLoot.add(new ItemStack(ModItems.ENCHANTED_GOLDEN_BURGER, context.getRandom().nextIntBetweenInclusive(0, 1)));
        }
    }
}
