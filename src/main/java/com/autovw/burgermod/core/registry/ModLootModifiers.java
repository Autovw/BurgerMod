package com.autovw.burgermod.core.registry;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.common.loot.RangedAdditionModifier;
import com.autovw.burgermod.common.loot.RangedChanceAdditionModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Author: Autovw
 */
public class ModLootModifiers {
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, BurgerMod.MOD_ID);

    public static final RegistryObject<RangedAdditionModifier.Serializer> VILLAGE_PLAINS_HOUSE_FRIES_ADDITION = LOOT_MODIFIERS.register("chests/village/village_plains_house/fries_addition", RangedAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedAdditionModifier.Serializer> VILLAGE_SNOWY_HOUSE_HOTDOG_ADDITION = LOOT_MODIFIERS.register("chests/village/village_snowy_house/hotdog_addition", RangedAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedAdditionModifier.Serializer> VILLAGE_BUTCHER_COOKED_CHICKEN_NUGGET_ADDITION = LOOT_MODIFIERS.register("chests/village/village_butcher/cooked_chicken_nugget_addition", RangedAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedAdditionModifier.Serializer> VILLAGE_FISHER_COD_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/village/village_fisher/cod_burger_addition", RangedAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedAdditionModifier.Serializer> VILLAGE_FISHER_SALMON_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/village/village_fisher/salmon_burger_addition", RangedAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedAdditionModifier.Serializer> IGLOO_CHEST_PORK_CHEESE_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/igloo_chest/pork_cheese_burger_addition", RangedAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedAdditionModifier.Serializer> SIMPLE_DUNGEON_SCRAMBLED_EGG_ADDITION = LOOT_MODIFIERS.register("chests/simple_dungeon/scrambled_egg_addition", RangedAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedAdditionModifier.Serializer> WOODLAND_MANSION_COOKED_CHAMPIGNONS_ADDITION = LOOT_MODIFIERS.register("chests/woodland_mansion/cooked_champignons_addition", RangedAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedAdditionModifier.Serializer> WOODLAND_MANSION_MUTTON_CHAMPIGNON_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/woodland_mansion/mutton_champignon_burger_addition", RangedAdditionModifier.Serializer::new);

    public static final RegistryObject<RangedChanceAdditionModifier.Serializer> SIMPLE_DUNGEON_GOLDEN_BEEF_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/simple_dungeon/golden_beef_burger_addition", RangedChanceAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedChanceAdditionModifier.Serializer> DESERT_PYRAMID_GOLDEN_MUTTON_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/desert_pyramid/golden_mutton_burger_addition", RangedChanceAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedChanceAdditionModifier.Serializer> RUINED_PORTAL_GOLDEN_PORK_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/ruined_portal/golden_pork_burger_addition", RangedChanceAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedChanceAdditionModifier.Serializer> BASTION_OTHER_GOLDEN_SALMON_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/bastion_other/golden_salmon_burger_addition", RangedChanceAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedChanceAdditionModifier.Serializer> BASTION_TREASURE_GOLDEN_PORK_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/bastion_treasure/golden_pork_burger_addition", RangedChanceAdditionModifier.Serializer::new);
    public static final RegistryObject<RangedChanceAdditionModifier.Serializer> BASTION_TREASURE_ENCHANTED_GOLDEN_BURGER_ADDITION = LOOT_MODIFIERS.register("chests/bastion_treasure/enchanted_golden_burger_addition", RangedChanceAdditionModifier.Serializer::new);
}
