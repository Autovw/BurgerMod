package com.autovw.burgermod.core.registry;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.common.loot.LootAdditionModifier;
import com.mojang.serialization.MapCodec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Autovw
 */
public final class ModLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, BurgerMod.MOD_ID);

    public static final RegistryObject<MapCodec<LootAdditionModifier>> LOOT_ADDITION_MODIFIER = LOOT_MODIFIERS.register("loot_addition_modifier", () -> LootAdditionModifier.CODEC);
}
