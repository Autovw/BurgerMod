package com.autovw.burgermod.datagen.providers;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.common.loot.LootAdditionModifier;
import com.autovw.burgermod.core.registry.ModItems;
import com.autovw.burgermod.core.registry.ModLootModifiers;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Author: Autovw
 */
public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(DataGenerator gen) {
        super(gen, BurgerMod.MOD_ID);
    }

    @Override
    protected void start() {
        addModifier(ModLootModifiers.VILLAGE_PLAINS_HOUSE_FRIES_ADDITION.get(), new ResourceLocation("chests/village/village_plains_house"), ModItems.FRIES.get(), 0, 2);
        addModifier(ModLootModifiers.VILLAGE_SNOWY_HOUSE_HOTDOG_ADDITION.get(), new ResourceLocation("chests/village/village_snowy_house"), ModItems.HOTDOG.get(), 0, 3);
        addModifier(ModLootModifiers.VILLAGE_BUTCHER_COOKED_CHICKEN_NUGGET_ADDITION.get(), new ResourceLocation("chests/village/village_butcher"), ModItems.COOKED_CHICKEN_NUGGET.get(), 2, 5);
        addModifier(ModLootModifiers.VILLAGE_FISHER_COD_BURGER_ADDITION.get(), new ResourceLocation("chests/village/village_fisher"), ModItems.COD_BURGER.get(), 0, 1);
        addModifier(ModLootModifiers.VILLAGE_FISHER_SALMON_BURGER_ADDITION.get(), new ResourceLocation("chests/village/village_fisher"), ModItems.SALMON_BURGER.get(), 0, 1);
        addModifier(ModLootModifiers.IGLOO_CHEST_PORK_CHEESE_BURGER_ADDITION.get(), new ResourceLocation("chests/igloo_chest"), ModItems.PORK_CHEESE_BURGER.get(), 0, 1);
        addModifier(ModLootModifiers.SIMPLE_DUNGEON_SCRAMBLED_EGG_ADDITION.get(), new ResourceLocation("chests/simple_dungeon"), ModItems.SCRAMBLED_EGG.get(), 1, 2);
        addModifier(ModLootModifiers.WOODLAND_MANSION_COOKED_CHAMPIGNONS_ADDITION.get(), new ResourceLocation("chests/woodland_mansion"), ModItems.COOKED_CHAMPIGNONS.get(), 0, 4);
        addModifier(ModLootModifiers.WOODLAND_MANSION_MUTTON_CHAMPIGNON_BURGER_ADDITION.get(), new ResourceLocation("chests/woodland_mansion"), ModItems.MUTTON_CHAMPIGNON_BURGER.get(), 0, 1);

        addModifier(ModLootModifiers.SIMPLE_DUNGEON_GOLDEN_BEEF_BURGER_ADDITION.get(), new ResourceLocation("chests/simple_dungeon"), ModItems.GOLDEN_BEEF_BURGER.get(), 1, 1, 0.25f);
        addModifier(ModLootModifiers.DESERT_PYRAMID_GOLDEN_MUTTON_BURGER_ADDITION.get(), new ResourceLocation("chests/desert_pyramid"), ModItems.GOLDEN_MUTTON_BURGER.get(), 1, 1, 0.1f);
        addModifier(ModLootModifiers.RUINED_PORTAL_GOLDEN_PORK_BURGER_ADDITION.get(), new ResourceLocation("chests/ruined_portal"), ModItems.GOLDEN_PORK_BURGER.get(), 1, 1, 0.15f);
        addModifier(ModLootModifiers.BASTION_OTHER_GOLDEN_SALMON_BURGER_ADDITION.get(), new ResourceLocation("chests/bastion_other"), ModItems.GOLDEN_SALMON_BURGER.get(), 0, 1, 0.2f);
        addModifier(ModLootModifiers.BASTION_HOGLIN_STABLE_GOLDEN_CHICKEN_BURGER_ADDITION.get(), new ResourceLocation("chests/bastion_hoglin_stable"), ModItems.GOLDEN_CHICKEN_BURGER.get(), 0, 1, 0.3f);
        addModifier(ModLootModifiers.BASTION_TREASURE_GOLDEN_PORK_BURGER_ADDITION.get(), new ResourceLocation("chests/bastion_treasure"), ModItems.GOLDEN_PORK_BURGER.get(), 1, 1, 0.4f);
        addModifier(ModLootModifiers.BASTION_TREASURE_ENCHANTED_GOLDEN_BURGER_ADDITION.get(), new ResourceLocation("chests/bastion_treasure"), ModItems.ENCHANTED_GOLDEN_BURGER.get(), 0, 1, 0.2f);
        addModifier(ModLootModifiers.ANCIENT_CITY_ENCHANTED_GOLDEN_BURGER_ADDITION.get(), new ResourceLocation("chests/ancient_city"), ModItems.ENCHANTED_GOLDEN_BURGER.get(), 0, 1, 0.25f);
    }

    public void addModifier(LootAdditionModifier.Serializer serializer, ResourceLocation target, Item addition, int minAddition, int maxAddition) {
        addModifier(serializer, target, addition, minAddition, maxAddition, 1.0f);
    }

    public void addModifier(LootAdditionModifier.Serializer serializer, ResourceLocation target, Item addition, int minAddition, int maxAddition, float chanceAddition) {
        ResourceLocation lootLoc = ForgeRegistries.LOOT_MODIFIER_SERIALIZERS.get().getKey(serializer);
        add(lootLoc.getPath(), serializer, new LootAdditionModifier(new LootItemCondition[] {
                LootTableIdCondition.builder(target).build() }, addition, minAddition, maxAddition, chanceAddition));
    }
}
