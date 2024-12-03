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
    public static final ChestLootAddition[] DEFAULT_CHEST_LOOT_ADDITIONS = new ChestLootAddition[] {
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/village/village_plains_house"), ModItems.FRIES, 0, 2),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/village/village_snowy_house"), ModItems.HOTDOG, 0, 3),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/village/village_butcher"), ModItems.COOKED_CHICKEN_NUGGET, 2, 5),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/village/village_fisher"), ModItems.COD_BURGER, 0, 1),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/village/village_fisher"), ModItems.SALMON_BURGER, 0, 1),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/igloo_chest"), ModItems.PORK_CHEESE_BURGER, 0, 1),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/simple_dungeon"), ModItems.SCRAMBLED_EGG, 1, 2),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/woodland_mansion"), ModItems.COOKED_CHAMPIGNONS, 0, 4),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/woodland_mansion"), ModItems.MUTTON_CHAMPIGNON_BURGER, 0, 1),

            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/trial_chambers/supply"), ModItems.FRIES, 1, 3, 0.3f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/trial_chambers/supply"), ModItems.CHEESE, 1, 4, 0.3f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/trial_chambers/supply"), ModItems.SALMON_CHEESE_BURGER, 1, 1, 0.15f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/trial_chambers/intersection_barrel"), ModItems.FRIES, 1, 5, 0.4f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/trial_chambers/intersection_barrel"), ModItems.GOLDEN_COD_BURGER, 1, 1, 0.2f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/trial_chambers/reward_ominous"), ModItems.GOLDEN_COD_BURGER, 1, 1, 0.15f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/trial_chambers/reward_ominous"), ModItems.ENCHANTED_GOLDEN_BURGER, 1, 1, 0.1f),

            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/simple_dungeon"), ModItems.GOLDEN_BEEF_BURGER, 1, 1, 0.25f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/desert_pyramid"), ModItems.GOLDEN_MUTTON_BURGER, 1, 1, 0.1f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/ruined_portal"), ModItems.GOLDEN_PORK_BURGER, 1, 1, 0.15f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/bastion_other"), ModItems.GOLDEN_SALMON_BURGER, 1, 1, 0.1f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/bastion_hoglin_stable"), ModItems.GOLDEN_CHICKEN_BURGER, 1, 1, 0.15f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/bastion_treasure"), ModItems.GOLDEN_PORK_BURGER, 1, 1, 0.4f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/bastion_treasure"), ModItems.ENCHANTED_GOLDEN_BURGER, 1, 1, 0.1f),
            new ChestLootAddition(ResourceLocation.withDefaultNamespace("chests/ancient_city"), ModItems.ENCHANTED_GOLDEN_BURGER, 1, 1, 0.125f)
    };

    public static void modifiedGeneratedLoot(ObjectArrayList<ItemStack> generatedLoot, LootContext context, ChestLootAddition[] lootAdditions, ResourceLocation lootTableId)
    {
        RandomSource random = context.getRandom();

        if (lootAdditions.length < 1)
            return;

        if (!lootTableId.getPath().startsWith("chests"))
            return; // skip non-chest loot tables

        for (ChestLootAddition lootAddition : lootAdditions)
        {
            if (lootTableId.equals(lootAddition.getTarget()) && random.nextFloat() <= lootAddition.getChance())
            {
                generatedLoot.add(new ItemStack(lootAddition.getItem(), random.nextIntBetweenInclusive(lootAddition.getMin(), lootAddition.getMax())));
            }
        }
    }
}
