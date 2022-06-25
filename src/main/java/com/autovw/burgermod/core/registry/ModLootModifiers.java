package com.autovw.burgermod.core.registry;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.common.loot.LootAdditionModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Author: Autovw
 */
public class ModLootModifiers {
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, BurgerMod.MOD_ID);

    public static final RegistryObject<LootAdditionModifier.Serializer> VILLAGE_PLAINS_HOUSE_FRIES_ADDITION = LOOT_MODIFIERS.register("chests/village/village_plains_house/fries_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> VILLAGE_SNOWY_HOUSE_HOTDOG_ADDITION = LOOT_MODIFIERS.register("chests/village/village_snowy_house/hotdog_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> VILLAGE_BUTCHER_COOKED_CHICKEN_NUGGET_ADDITION = LOOT_MODIFIERS.register("chests/village/village_butcher/cooked_chicken_nugget_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> VILLAGE_FISHER_COD_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/village/village_fisher/cod_burger_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> VILLAGE_FISHER_SALMON_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/village/village_fisher/salmon_burger_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> IGLOO_CHEST_PORK_CHEESE_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/igloo_chest/pork_cheese_burger_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> SIMPLE_DUNGEON_SCRAMBLED_EGG_ADDITION = LOOT_MODIFIERS.register("chests/simple_dungeon/scrambled_egg_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> WOODLAND_MANSION_COOKED_CHAMPIGNONS_ADDITION = LOOT_MODIFIERS.register("chests/woodland_mansion/cooked_champignons_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> WOODLAND_MANSION_MUTTON_CHAMPIGNON_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/woodland_mansion/mutton_champignon_burger_addition", LootAdditionModifier.Serializer::new);

    public static final RegistryObject<LootAdditionModifier.Serializer> SIMPLE_DUNGEON_GOLDEN_BEEF_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/simple_dungeon/golden_beef_burger_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> DESERT_PYRAMID_GOLDEN_MUTTON_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/desert_pyramid/golden_mutton_burger_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> RUINED_PORTAL_GOLDEN_PORK_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/ruined_portal/golden_pork_burger_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> BASTION_OTHER_GOLDEN_SALMON_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/bastion_other/golden_salmon_burger_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> BASTION_HOGLIN_STABLE_GOLDEN_CHICKEN_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/bastion_hoglin_stable/golden_chicken_burger_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> BASTION_TREASURE_GOLDEN_PORK_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/bastion_treasure/golden_pork_burger_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> BASTION_TREASURE_ENCHANTED_GOLDEN_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/bastion_treasure/enchanted_golden_burger_addition", LootAdditionModifier.Serializer::new);
    public static final RegistryObject<LootAdditionModifier.Serializer> ANCIENT_CITY_ENCHANTED_GOLDEN_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/ancient_city/enchanted_golden_burger_addition", LootAdditionModifier.Serializer::new);
}
