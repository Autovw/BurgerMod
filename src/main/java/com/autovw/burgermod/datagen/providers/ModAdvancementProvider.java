package com.autovw.burgermod.datagen.providers;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.registry.ModItems;
import com.autovw.burgermod.core.util.ModTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

/**
 * Author: Autovw
 */
public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, fileHelperIn);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {
        Advancement craft_burger = Advancement.Builder.advancement()
                .parent(new ResourceLocation("husbandry/plant_seed"))
                .display(ModItems.BEEF_BURGER.get(), Component.translatable("advancements.burgermod.husbandry.craft_burger.title"), Component.translatable("advancements.burgermod.husbandry.craft_burger.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("burgers", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate(ModTags.BURGERS, null, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, null, NbtPredicate.ANY)))
                .save(consumer, new ResourceLocation(BurgerMod.MOD_ID, "husbandry/craft_burger"), fileHelper);

        Advancement.Builder.advancement()
                .parent(craft_burger)
                .display(ModItems.GOLDEN_BEEF_BURGER.get(), Component.translatable("advancements.burgermod.husbandry.craft_golden_burger.title"), Component.translatable("advancements.burgermod.husbandry.craft_golden_burger.description"), null, FrameType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(100))
                .addCriterion("golden_burgers", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate(ModTags.GOLDEN_BURGERS, null, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, null, NbtPredicate.ANY)))
                .save(consumer, new ResourceLocation(BurgerMod.MOD_ID, "husbandry/craft_golden_burger"), fileHelper);
    }
}
