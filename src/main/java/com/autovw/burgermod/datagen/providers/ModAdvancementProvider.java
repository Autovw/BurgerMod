package com.autovw.burgermod.datagen.providers;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.registry.ModItems;
import com.autovw.burgermod.core.util.ModTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author Autovw
 */
public class ModAdvancementProvider extends ForgeAdvancementProvider {
    public ModAdvancementProvider(PackOutput pack, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(pack, registries, existingFileHelper, List.of(new ModHusbandryAdvancements()));
    }

    public static class ModHusbandryAdvancements implements AdvancementGenerator {

        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper fileHelper) {
            AdvancementHolder craftBurger = Advancement.Builder.advancement()
                    .parent(new ResourceLocation("husbandry/plant_seed"))
                    .display(ModItems.BEEF_BURGER.get(), Component.translatable("advancements.burgermod.husbandry.craft_burger.title"), Component.translatable("advancements.burgermod.husbandry.craft_burger.description"), null, AdvancementType.TASK, true, true, false)
                    .addCriterion("burgers", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate(Optional.of(ModTags.BURGERS), null, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, null, null, null, Optional.empty())))
                    .save(consumer, new ResourceLocation(BurgerMod.MOD_ID, "husbandry/craft_burger"));

            Advancement.Builder.advancement()
                    .parent(craftBurger)
                    .display(ModItems.GOLDEN_BEEF_BURGER.get(), Component.translatable("advancements.burgermod.husbandry.craft_golden_burger.title"), Component.translatable("advancements.burgermod.husbandry.craft_golden_burger.description"), null, AdvancementType.CHALLENGE, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(100))
                    .addCriterion("golden_burgers", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate(Optional.of(ModTags.GOLDEN_BURGERS), null, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, null, null, null, Optional.empty())))
                    .save(consumer, new ResourceLocation(BurgerMod.MOD_ID, "husbandry/craft_golden_burger"));
        }
    }
}
