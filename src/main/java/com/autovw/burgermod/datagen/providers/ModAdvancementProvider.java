package com.autovw.burgermod.datagen.providers;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.ModItems;
import com.autovw.burgermod.core.ModTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.*;
import net.minecraft.data.AdvancementProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
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
                .display(ModItems.BEEF_BURGER.get(), new TranslationTextComponent("advancements.burgermod.husbandry.craft_burger.title"), new TranslationTextComponent("advancements.burgermod.husbandry.craft_burger.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("burgers", InventoryChangeTrigger.Instance.hasItems(new ItemPredicate(ModTags.BURGERS, null, MinMaxBounds.IntBound.ANY, MinMaxBounds.IntBound.ANY, EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, null, NBTPredicate.ANY)))
                .save(consumer, new ResourceLocation(BurgerMod.MOD_ID, "husbandry/craft_burger"), fileHelper);

        Advancement.Builder.advancement()
                .parent(craft_burger)
                .display(ModItems.GOLDEN_BEEF_BURGER.get(), new TranslationTextComponent("advancements.burgermod.husbandry.craft_golden_burger.title"), new TranslationTextComponent("advancements.burgermod.husbandry.craft_golden_burger.description"), null, FrameType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(100))
                .addCriterion("golden_burgers", InventoryChangeTrigger.Instance.hasItems(new ItemPredicate(ModTags.GOLDEN_BURGERS, null, MinMaxBounds.IntBound.ANY, MinMaxBounds.IntBound.ANY, EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, null, NBTPredicate.ANY)))
                .save(consumer, new ResourceLocation(BurgerMod.MOD_ID, "husbandry/craft_golden_burger"), fileHelper);
    }
}
