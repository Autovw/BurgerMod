package com.autovw.burgermod.neoforge.common.loot;

import com.autovw.burgermod.common.common.loot.ChestLootAddition;
import com.autovw.burgermod.common.common.loot.LootModifierHelper;
import com.autovw.burgermod.neoforge.config.Config;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.List;
import java.util.Optional;

/**
 * @author Autovw
 */
public class LootAdditionModifier extends LootModifier
{
    public static final MapCodec<LootAdditionModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> codecStart(instance)
            .and(
                    ChestLootAddition.CODEC.listOf().xmap(list -> list.toArray(ChestLootAddition[]::new), List::of).fieldOf("additions").forGetter(la -> la.lootAdditions)
            )
            .apply(instance, (conditions, priority, additions) -> new LootAdditionModifier(conditions, additions, priority)));

    private final ChestLootAddition[] lootAdditions;

    public LootAdditionModifier(Optional<Holder<LootItemCondition>> condition, ChestLootAddition[] additions, int priority)
    {
        super(condition, priority);
        this.lootAdditions = additions;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
    {
        Identifier queriedTableId = context.getQueriedLootTableId();

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
