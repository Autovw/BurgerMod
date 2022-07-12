package com.autovw.burgermod.core.registry;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.common.loot.LootAdditionModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Author: Autovw
 */
public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, BurgerMod.MOD_ID);

    public static final RegistryObject<Codec<LootAdditionModifier>> LOOT_ADDITION_MODIFIER = LOOT_MODIFIERS.register("loot_addition_modifier", () -> LootAdditionModifier.CODEC);
}
