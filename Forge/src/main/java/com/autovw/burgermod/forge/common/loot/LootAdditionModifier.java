package com.autovw.burgermod.forge.common.loot;

import com.autovw.burgermod.common.common.loot.LootModifierHelper;
import com.autovw.burgermod.forge.config.Config;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

/**
 * @author Autovw
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

        // only add loot if generateChestLoot is turned on in the config
        if (Config.LootConfig.generateChestLoot.get())
        {
            LootModifierHelper.modifiedGeneratedLoot(generatedLoot, context, queriedTableId);
        }

        return generatedLoot;
    }

    @Override
    public MapCodec<LootAdditionModifier> codec()
    {
        return CODEC;
    }
}