package com.autovw.burgermod.neoforge.common.loot;

import com.autovw.burgermod.common.common.loot.ChestLootAddition;
import com.autovw.burgermod.common.common.loot.LootModifierHelper;
import com.autovw.burgermod.neoforge.config.Config;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.List;

/**
 * @author Autovw
 */
public class LootAdditionModifier extends LootModifier
{
    public static final MapCodec<LootAdditionModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> codecStart(instance)
            .and(
                    ChestLootAddition.CODEC.listOf().xmap(list -> list.toArray(ChestLootAddition[]::new), List::of).fieldOf("additions").forGetter(la -> la.lootAdditions)
            )
            .apply(instance, LootAdditionModifier::new));

    private final ChestLootAddition[] lootAdditions;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public LootAdditionModifier(LootItemCondition[] conditionsIn, ChestLootAddition[] additions)
    {
        super(conditionsIn);
        this.lootAdditions = additions;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
    {
        ResourceLocation queriedTableId = context.getQueriedLootTableId();

        // only add loot if generateChestLoot is turned on in the config
        if (Config.LootConfig.generateChestLoot.get())
        {
            LootModifierHelper.modifiedGeneratedLoot(generatedLoot, context, this.lootAdditions, queriedTableId);
        }

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec()
    {
        return CODEC;
    }
}
