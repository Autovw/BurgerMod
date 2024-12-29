package com.autovw.burgermod.common.core.util;

import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

/**
 * @author Autovw
 */
public final class ModConsumables
{
    public static final Consumable RAW_SCRAMBLED_EGG = Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(ModEffects.RAW_SCRAMBLED_EGG_EFFECTS, 1.0f)).build();
    public static final Consumable RAW_CHAMPIGNONS = Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(ModEffects.RAW_CHAMPIGNONS_EFFECTS, 1.0f)).build();
    public static final Consumable GOLDEN_BURGER = Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(ModEffects.GOLDEN_BURGER_REGENERATION, ModEffects.GOLDEN_BURGER_ABSORPTION))).build();
    public static final Consumable ENCHANTED_GOLDEN_BURGER = Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(ModEffects.ENCHANTED_GOLDEN_BURGER_REGENERATION, ModEffects.ENCHANTED_GOLDEN_BURGER_DAMAGE_RESISTANCE, ModEffects.ENCHANTED_GOLDEN_BURGER_FIRE_RESISTANCE, ModEffects.ENCHANTED_GOLDEN_BURGER_ABSORPTION))).build();
}
