package com.autovw.burgermod.common.datagen;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.common.core.ModItems;
import com.autovw.burgermod.common.core.util.ModTags;
import net.minecraft.advancements.*;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Autovw
 */
public class ModDataGenHelper
{
    public static void advancements(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer)
    {
        Advancement.Builder.advancement()
                .parent(Identifier.withDefaultNamespace("husbandry/root"))
                .display(ModItems.FRIES, Component.translatable("advancements.burgermod.husbandry.obtain_fries.title"), Component.translatable("advancements.burgermod.husbandry.obtain_fries.description"), null, AdvancementType.TASK, true, true, false)
                .addCriterion("fries", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FRIES))
                .save(consumer, Identifier.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/obtain_fries").toString());

        AdvancementHolder craftBurger = Advancement.Builder.advancement()
                .parent(Identifier.withDefaultNamespace("husbandry/plant_seed"))
                .display(ModItems.BEEF_BURGER, Component.translatable("advancements.burgermod.husbandry.craft_burger.title"), Component.translatable("advancements.burgermod.husbandry.craft_burger.description"), null, AdvancementType.TASK, true, true, false)
                .addCriterion("burgers", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM), ModTags.BURGERS)))
                .save(consumer, Identifier.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/craft_burger").toString());

        AdvancementHolder goldenBurger = Advancement.Builder.advancement()
                .parent(craftBurger)
                .display(ModItems.GOLDEN_BEEF_BURGER, Component.translatable("advancements.burgermod.husbandry.craft_golden_burger.title"), Component.translatable("advancements.burgermod.husbandry.craft_golden_burger.description"), null, AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(100))
                .addCriterion("golden_burgers", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM), ModTags.GOLDEN_BURGERS)))
                .save(consumer, Identifier.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/craft_golden_burger").toString());

        Advancement.Builder.advancement()
                .parent(goldenBurger)
                .display(ModItems.ENCHANTED_GOLDEN_BURGER, Component.translatable("advancements.burgermod.husbandry.obtain_enchanted_golden_burger.title"), Component.translatable("advancements.burgermod.husbandry.obtain_enchanted_golden_burger.description"), null, AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(100))
                .addCriterion("enchanted_golden_burger", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM), ModItems.ENCHANTED_GOLDEN_BURGER)))
                .save(consumer, Identifier.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/obtain_enchanted_golden_burger").toString());
    }

    public static void recipes(HolderLookup.Provider registries, RecipeOutput output)
    {
        HolderLookup.RegistryLookup<Item> registryLookup = registries.lookupOrThrow(Registries.ITEM);

        // Burgers
        eggBurgerRecipe(output, registryLookup, ModItems.BEEF_BURGER, Items.COOKED_BEEF);
        eggBurgerRecipe(output, registryLookup, ModItems.PORK_BURGER, Items.COOKED_PORKCHOP);
        eggBurgerRecipe(output, registryLookup, ModItems.MUTTON_BURGER, Items.COOKED_MUTTON);
        eggBurgerRecipe(output, registryLookup, ModItems.CHICKEN_BURGER, Items.COOKED_CHICKEN);
        eggBurgerRecipe(output, registryLookup, ModItems.SALMON_BURGER, Items.COOKED_SALMON);
        eggBurgerRecipe(output, registryLookup, ModItems.COD_BURGER, Items.COOKED_COD);

        cheeseBurgerRecipe(output, registryLookup, ModItems.BEEF_CHEESE_BURGER, Items.COOKED_BEEF);
        cheeseBurgerRecipe(output, registryLookup, ModItems.PORK_CHEESE_BURGER, Items.COOKED_PORKCHOP);
        cheeseBurgerRecipe(output, registryLookup, ModItems.MUTTON_CHEESE_BURGER, Items.COOKED_MUTTON);
        cheeseBurgerRecipe(output, registryLookup, ModItems.CHICKEN_CHEESE_BURGER, Items.COOKED_CHICKEN);
        cheeseBurgerRecipe(output, registryLookup, ModItems.SALMON_CHEESE_BURGER, Items.COOKED_SALMON);
        cheeseBurgerRecipe(output, registryLookup, ModItems.COD_CHEESE_BURGER, Items.COOKED_COD);

        champignonBurgerRecipe(output, registryLookup, ModItems.BEEF_CHAMPIGNON_BURGER, Items.COOKED_BEEF);
        champignonBurgerRecipe(output, registryLookup, ModItems.PORK_CHAMPIGNON_BURGER, Items.COOKED_PORKCHOP);
        champignonBurgerRecipe(output, registryLookup, ModItems.MUTTON_CHAMPIGNON_BURGER, Items.COOKED_MUTTON);
        champignonBurgerRecipe(output, registryLookup, ModItems.CHICKEN_CHAMPIGNON_BURGER, Items.COOKED_CHICKEN);
        champignonBurgerRecipe(output, registryLookup, ModItems.SALMON_CHAMPIGNON_BURGER, Items.COOKED_SALMON);
        champignonBurgerRecipe(output, registryLookup, ModItems.COD_CHAMPIGNON_BURGER, Items.COOKED_COD);

        // Golden Burgers
        goldenBurgerRecipe(output, registryLookup, ModItems.GOLDEN_BEEF_BURGER, ModTags.BEEF_BURGERS);
        goldenBurgerRecipe(output, registryLookup, ModItems.GOLDEN_PORK_BURGER, ModTags.PORK_BURGERS);
        goldenBurgerRecipe(output, registryLookup, ModItems.GOLDEN_MUTTON_BURGER, ModTags.MUTTON_BURGERS);
        goldenBurgerRecipe(output, registryLookup, ModItems.GOLDEN_CHICKEN_BURGER, ModTags.CHICKEN_BURGERS);
        goldenBurgerRecipe(output, registryLookup, ModItems.GOLDEN_SALMON_BURGER, ModTags.SALMON_BURGERS);
        goldenBurgerRecipe(output, registryLookup, ModItems.GOLDEN_COD_BURGER, ModTags.COD_BURGERS);

        // Ingredients
        scrambledEggRecipe(output, registryLookup, ModItems.SCRAMBLED_EGG);
        cookingRecipe(output, registryLookup, ModItems.FRIED_SCRAMBLED_EGG, ModItems.SCRAMBLED_EGG);
        cheeseRecipe(output, registryLookup, ModItems.CHEESE);
        rawChampignonRecipe(output, registryLookup, ModItems.RAW_CHAMPIGNONS);
        cookingRecipe(output, registryLookup, ModItems.COOKED_CHAMPIGNONS, ModItems.RAW_CHAMPIGNONS);

        // Other foods
        chickenNuggetRecipe(output, registryLookup);
        friesRecipe(output, registryLookup);
        hotdogRecipe(output, registryLookup);
        sweetBerryTartRecipe(output, registryLookup);
    }

    /**
     * Base recipe for burgers
     *
     * @param output Recipe consumer
     * @param result The recipe result item
     * @param resultAmount The result amount the recipe should return
     * @param mainIngredient The main ingredient (e.g. minecraft:steak for a beef burger)
     * @param extraIngredient Extra ingredient, a tag by default (e.g. forge:cheese for a cheese burger)
     */
    public static void baseBurgerRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result, int resultAmount, ItemLike mainIngredient, TagKey<Item> extraIngredient)
    {
        TagKey<Item> breadTag = ModTags.COMMON_FOODS_BREAD;
        ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.FOOD, result, resultAmount)
                .define('B', breadTag)
                .define('#', mainIngredient)
                .define('*', extraIngredient)
                .pattern(" B")
                .pattern("*#")
                .pattern(" B")
                .unlockedBy("has_bread", has(registryLookup, breadTag))
                .unlockedBy("has_main_ingredient", has(registryLookup, mainIngredient))
                .unlockedBy("has_extra_ingredient", has(registryLookup, extraIngredient))
                .save(output);
    }

    /**
     * Base recipe for burgers
     *
     * @param output Recipe consumer
     * @param result The recipe result item
     * @param resultAmount The result amount the recipe should return
     * @param mainIngredient The main ingredient. If you want to return an item instead of a tag you should use the above method.
     * @param extraIngredient Extra ingredient, a tag by default (e.g. forge:cheese for a cheese burger)
     */
    public static void baseBurgerRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result, int resultAmount, TagKey<Item> mainIngredient, TagKey<Item> extraIngredient)
    {
        TagKey<Item> breadTag = ModTags.COMMON_FOODS_BREAD;
        ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.FOOD, result, resultAmount)
                .define('B', breadTag)
                .define('#', mainIngredient)
                .define('*', extraIngredient)
                .pattern(" B")
                .pattern("*#")
                .pattern(" B")
                .unlockedBy("has_bread", has(registryLookup, breadTag))
                .unlockedBy("has_main_ingredient", has(registryLookup, mainIngredient))
                .unlockedBy("has_extra_ingredient", has(registryLookup, extraIngredient))
                .save(output);
    }

    public static void eggBurgerRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result, ItemLike ingredient)
    {
        TagKey<Item> friedEggTag = ModTags.COMMON_FOODS_FRIED_EGG;
        baseBurgerRecipe(output, registryLookup, result, 2, ingredient, friedEggTag);
    }

    public static void cheeseBurgerRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result, ItemLike ingredient)
    {
        TagKey<Item> cheeseTag = ModTags.COMMON_FOODS_CHEESE;
        baseBurgerRecipe(output, registryLookup, result, 2, ingredient, cheeseTag);
    }

    public static void champignonBurgerRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result, ItemLike ingredient)
    {
        TagKey<Item> cookedMushroomTag = ModTags.COMMON_FOODS_COOKED_MUSHROOM;
        baseBurgerRecipe(output, registryLookup, result, 2, ingredient, cookedMushroomTag);
    }

    /**
     * Recipe for Golden Burgers
     *
     * @param output Recipe consumer
     * @param result The golden burger
     * @param ingredient Crafting ingredient
     */
    public static void goldenBurgerRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result, TagKey<Item> ingredient)
    {
        TagKey<Item> goldIngotTag = ModTags.COMMON_INGOTS_GOLD;
        ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.FOOD, result)
                .define('G', goldIngotTag)
                .define('#', ingredient)
                .pattern("GGG")
                .pattern("G#G")
                .pattern("GGG")
                .unlockedBy("has_gold", has(registryLookup, goldIngotTag))
                .unlockedBy("has_burger", has(registryLookup, ingredient))
                .save(output);
    }

    /**
     * Base recipe for cooking food(s). Includes recipes for: furnace, campfire and smoker.
     *
     * @param output Recipe consumer
     * @param result Result item
     * @param ingredient Ingredient item
     * @param experience Experience given upon obtaining the result item
     */
    public static void baseFoodCookingRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result, ItemLike ingredient, float experience)
    {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200)
                .unlockedBy("has_" + ingredient.toString(), has(registryLookup, ingredient))
                .save(output, Identifier.parse(result + "_from_smelting").toString());

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600)
                .unlockedBy("has_" + ingredient.toString(), has(registryLookup, ingredient))
                .save(output, Identifier.parse(result + "_from_campfire").toString());

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100)
                .unlockedBy("has_" + ingredient.toString(), has(registryLookup, ingredient))
                .save(output, Identifier.parse(result + "_from_smoker").toString());
    }

    private static void cookingRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result, ItemLike ingredient)
    {
        baseFoodCookingRecipe(output, registryLookup, result, ingredient, 0.25F);
    }

    private static void scrambledEggRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result)
    {
        TagKey<Item> eggsTag = ModTags.COMMON_EGGS;
        ShapelessRecipeBuilder.shapeless(registryLookup, RecipeCategory.FOOD, result)
                .requires(eggsTag)
                .unlockedBy("has_eggs", has(registryLookup, eggsTag))
                .save(output);
    }

    private static void cheeseRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result)
    {
        internalCheeseRecipe(output, registryLookup, result, Items.MILK_BUCKET, Items.SUGAR);
    }

    private static void internalCheeseRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result, ItemLike ingredient1, ItemLike ingredient2)
    {
        for (int amount = 1; amount <= 8; amount++)
        {
            ShapelessRecipeBuilder.shapeless(registryLookup, RecipeCategory.FOOD, result, amount)
                    .requires(ingredient1)
                    .requires(ingredient2, amount)
                    .unlockedBy("has_" + ingredient1.toString(), has(registryLookup, ingredient1)).unlockedBy("has_" + ingredient2.toString(), has(registryLookup, ingredient2))
                    .save(output, Identifier.parse(result.toString() + "_" + amount).toString());
        }
    }

    private static void rawChampignonRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup, ItemLike result)
    {
        ShapelessRecipeBuilder.shapeless(registryLookup, RecipeCategory.FOOD, result)
                .requires(Items.BROWN_MUSHROOM, 2)
                .unlockedBy("has_brown_mushroom", has(registryLookup, Items.BROWN_MUSHROOM))
                .save(output);
    }

    private static void chickenNuggetRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup)
    {
        ShapelessRecipeBuilder.shapeless(registryLookup, RecipeCategory.FOOD, ModItems.COOKED_CHICKEN_NUGGET, 6)
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy("has_cooked_chicken", has(registryLookup, Items.COOKED_CHICKEN))
                .save(output);
    }

    private static void friesRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup)
    {
        ShapedRecipeBuilder.shaped(registryLookup, RecipeCategory.FOOD, ModItems.FRIES, 2)
                .define('P', Items.BAKED_POTATO)
                .pattern("PPP")
                .unlockedBy("has_baked_potato", has(registryLookup, Items.BAKED_POTATO))
                .save(output);
    }

    private static void hotdogRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup)
    {
        TagKey<Item> breadTag = ModTags.COMMON_FOODS_BREAD;
        TagKey<Item> chickenNuggetsTag = ModTags.COMMON_NUGGETS_CHICKEN;
        ShapelessRecipeBuilder.shapeless(registryLookup, RecipeCategory.FOOD, ModItems.HOTDOG, 4)
                .requires(Items.COOKED_BEEF)
                .requires(Items.COOKED_PORKCHOP)
                .requires(breadTag)
                .requires(chickenNuggetsTag)
                .unlockedBy("has_cooked_beef", has(registryLookup, Items.COOKED_BEEF))
                .unlockedBy("has_cooked_porkchop", has(registryLookup, Items.COOKED_PORKCHOP))
                .unlockedBy("has_bread", has(registryLookup, breadTag))
                .unlockedBy("has_cooked_chicken_nugget", has(registryLookup, chickenNuggetsTag))
                .save(output);
    }

    private static void sweetBerryTartRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> registryLookup)
    {
        ShapelessRecipeBuilder.shapeless(registryLookup, RecipeCategory.FOOD, ModItems.SWEET_BERRY_TART)
                .requires(Items.SWEET_BERRIES, 3)
                .requires(Items.WHEAT)
                .requires(Items.SUGAR)
                .unlockedBy("has_sweet_berries", has(registryLookup, Items.SWEET_BERRIES))
                .unlockedBy("has_wheat", has(registryLookup, Items.WHEAT))
                .unlockedBy("has_sugar", has(registryLookup, Items.SUGAR))
                .save(output);
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderLookup.RegistryLookup<Item> registryLookup, ItemLike item)
    {
        return inventoryTrigger(ItemPredicate.Builder.item().of(registryLookup, item));
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderLookup.RegistryLookup<Item> registryLookup, TagKey<Item> itemTag)
    {
        return inventoryTrigger(ItemPredicate.Builder.item().of(registryLookup, itemTag));
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate.Builder... builder)
    {
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(
                Arrays.stream(builder).map(ItemPredicate.Builder::build).toArray(ItemPredicate[]::new))
        ));
    }
}
