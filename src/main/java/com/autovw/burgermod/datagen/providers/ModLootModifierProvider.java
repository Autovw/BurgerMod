package com.autovw.burgermod.datagen.providers;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.common.loot.LootAdditionModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

/**
 * @author Autovw
 */
public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(PackOutput output) {
        super(output, BurgerMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("loot_addition_modifier", new LootAdditionModifier(new LootItemCondition[] {}));
    }
}
