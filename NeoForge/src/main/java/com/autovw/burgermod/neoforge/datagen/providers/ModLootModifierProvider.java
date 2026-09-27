package com.autovw.burgermod.neoforge.datagen.providers;

import com.autovw.burgermod.common.common.loot.LootModifierHelper;
import com.autovw.burgermod.neoforge.common.loot.LootAdditionModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author Autovw
 */
public class ModLootModifierProvider extends GlobalLootModifierProvider
{
    public ModLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modId)
    {
        super(output, registries, modId);
    }

    @Override
    protected void start()
    {
        add("loot_addition_modifier", new LootAdditionModifier(
                Optional.empty(),
                LootModifierHelper.DEFAULT_CHEST_LOOT_ADDITIONS,
                IGlobalLootModifier.DEFAULT_PRIORITY
        ));
    }
}
