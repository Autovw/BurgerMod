package com.autovw.burgermod.datagen.providers;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.common.loot.RangedAdditionModifier;
import com.autovw.burgermod.common.loot.RangedChanceAdditionModifier;
import com.autovw.burgermod.core.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.Objects;

/**
 * Author: Autovw
 */
public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(DataGenerator gen) {
        super(gen, BurgerMod.MOD_ID);
    }

    @Override
    protected void start() {
        addRanged(BurgerMod.MOD_ID, new ResourceLocation("chests/village/village_plains_house"), ModItems.FRIES.get(), 0, 2);
        addRanged(BurgerMod.MOD_ID, new ResourceLocation("chests/village/village_snowy_house"), ModItems.HOTDOG.get(), 0, 3);
        addRanged(BurgerMod.MOD_ID, new ResourceLocation("chests/village/village_butcher"), ModItems.COOKED_CHICKEN_NUGGET.get(), 2, 5);
        addRanged(BurgerMod.MOD_ID, new ResourceLocation("chests/village/village_fisher"), ModItems.COD_BURGER.get(), 0, 1);
        addRanged(BurgerMod.MOD_ID, new ResourceLocation("chests/village/village_fisher"), ModItems.SALMON_BURGER.get(), 0, 1);
        addRanged(BurgerMod.MOD_ID, new ResourceLocation("chests/igloo_chest"), ModItems.PORK_CHEESE_BURGER.get(), 0, 1);
        addRanged(BurgerMod.MOD_ID, new ResourceLocation("chests/simple_dungeon"), ModItems.SCRAMBLED_EGG.get(), 1, 2);
        addRanged(BurgerMod.MOD_ID, new ResourceLocation("chests/woodland_mansion"), ModItems.COOKED_CHAMPIGNONS.get(), 0, 4);
        addRanged(BurgerMod.MOD_ID, new ResourceLocation("chests/woodland_mansion"), ModItems.MUTTON_CHAMPIGNON_BURGER.get(), 0, 1);

        addRangedChance(BurgerMod.MOD_ID, new ResourceLocation("chests/simple_dungeon"), ModItems.GOLDEN_BEEF_BURGER.get(), 1, 1, 0.25f);
        addRangedChance(BurgerMod.MOD_ID, new ResourceLocation("chests/desert_pyramid"), ModItems.GOLDEN_MUTTON_BURGER.get(), 1, 1, 0.1f);
        addRangedChance(BurgerMod.MOD_ID, new ResourceLocation("chests/ruined_portal"), ModItems.GOLDEN_PORK_BURGER.get(), 1, 1, 0.15f);
        addRangedChance(BurgerMod.MOD_ID, new ResourceLocation("chests/bastion_other"), ModItems.GOLDEN_SALMON_BURGER.get(), 0, 1, 0.2f);
        addRangedChance(BurgerMod.MOD_ID, new ResourceLocation("chests/bastion_hoglin_stable"), ModItems.GOLDEN_CHICKEN_BURGER.get(), 0, 1, 0.3f);
        addRangedChance(BurgerMod.MOD_ID, new ResourceLocation("chests/bastion_treasure"), ModItems.GOLDEN_PORK_BURGER.get(), 1, 1, 0.4f);
        addRangedChance(BurgerMod.MOD_ID, new ResourceLocation("chests/bastion_treasure"), ModItems.ENCHANTED_GOLDEN_BURGER.get(), 0, 1, 0.2f);
    }

    // helper method for generating a new RangedAdditionModifier
    protected void addRanged(String modId, ResourceLocation target, Item addition, int minAddition, int maxAddition) {
        String name = target.getPath() + "/" + Objects.requireNonNull(addition.getRegistryName()).getPath() + "_addition";
        add(name, new RangedAdditionModifier.Serializer().setRegistryName(modId + ":" + name), new RangedAdditionModifier(new ILootCondition[] {
                LootTableIdCondition.builder(target).build() }, addition, minAddition, maxAddition));
    }

    protected void addRangedChance(String modId, ResourceLocation target, Item addition, int minAddition, int maxAddition, float chanceAddition) {
        String name = target.getPath() + "/" + Objects.requireNonNull(addition.getRegistryName()).getPath() + "_addition";
        add(name, new RangedChanceAdditionModifier.Serializer().setRegistryName(modId + ":" + name), new RangedChanceAdditionModifier(new ILootCondition[] {
                LootTableIdCondition.builder(target).build() }, addition, minAddition, maxAddition, chanceAddition));
    }
}
