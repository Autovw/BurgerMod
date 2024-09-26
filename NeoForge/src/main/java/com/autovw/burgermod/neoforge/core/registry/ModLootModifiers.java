package com.autovw.burgermod.neoforge.core.registry;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.neoforge.common.loot.LootAdditionModifier;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * @author Autovw
 */
public final class ModLootModifiers
{
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, BurgerMod.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<LootAdditionModifier>> LOOT_ADDITION_MODIFIER = LOOT_MODIFIERS.register("loot_addition_modifier", () -> LootAdditionModifier.CODEC);
}
