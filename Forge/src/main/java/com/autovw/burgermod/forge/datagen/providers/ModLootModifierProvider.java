package com.autovw.burgermod.forge.datagen.providers;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.common.common.loot.LootModifierHelper;
import com.autovw.burgermod.forge.common.loot.LootAdditionModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

/**
 * @author Autovw
 */
public class ModLootModifierProvider extends GlobalLootModifierProvider
{
    public ModLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, BurgerMod.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider provider)
    {
        add("loot_addition_modifier", new LootAdditionModifier(
                new LootItemCondition[] {},
                LootModifierHelper.DEFAULT_CHEST_LOOT_ADDITIONS
        ));
    }
}
