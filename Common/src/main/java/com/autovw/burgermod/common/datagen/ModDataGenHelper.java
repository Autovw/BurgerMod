package com.autovw.burgermod.common.datagen;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.common.core.ModItems;
import com.autovw.burgermod.common.core.util.ModTags;
import net.minecraft.advancements.*;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Autovw
 */
public class ModDataGenHelper
{
    public static void advancements(BootstrapContext<Advancement> output)
    {
        Advancement.Builder.advancement()
                .parent(Identifier.withDefaultNamespace("husbandry/root"))
                .display(ModItems.FRIES, Component.translatable("advancements.burgermod.husbandry.obtain_fries.title"), Component.translatable("advancements.burgermod.husbandry.obtain_fries.description"), AdvancementType.TASK, true, true, false)
                .addCriterion("fries", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FRIES))
                .save(output, Identifier.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/obtain_fries").toString());

        AdvancementHolder craftBurger = Advancement.Builder.advancement()
                .parent(Identifier.withDefaultNamespace("husbandry/plant_seed"))
                .display(ModItems.BEEF_BURGER, Component.translatable("advancements.burgermod.husbandry.craft_burger.title"), Component.translatable("advancements.burgermod.husbandry.craft_burger.description"), AdvancementType.TASK, true, true, false)
                .addCriterion("burgers", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(output.lookup(Registries.ITEM), ModTags.BURGERS)))
                .save(output, Identifier.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/craft_burger").toString());

        AdvancementHolder goldenBurger = Advancement.Builder.advancement()
                .parent(craftBurger)
                .display(ModItems.GOLDEN_BEEF_BURGER, Component.translatable("advancements.burgermod.husbandry.craft_golden_burger.title"), Component.translatable("advancements.burgermod.husbandry.craft_golden_burger.description"), AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(100))
                .addCriterion("golden_burgers", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(output.lookup(Registries.ITEM), ModTags.GOLDEN_BURGERS)))
                .save(output, Identifier.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/craft_golden_burger").toString());

        Advancement.Builder.advancement()
                .parent(goldenBurger)
                .display(ModItems.ENCHANTED_GOLDEN_BURGER, Component.translatable("advancements.burgermod.husbandry.obtain_enchanted_golden_burger.title"), Component.translatable("advancements.burgermod.husbandry.obtain_enchanted_golden_burger.description"), AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(100))
                .addCriterion("enchanted_golden_burger", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(output.lookup(Registries.ITEM), ModItems.ENCHANTED_GOLDEN_BURGER)))
                .save(output, Identifier.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/obtain_enchanted_golden_burger").toString());
    }

    public static void recipes(HolderGetter<Item> items, RecipeOutput output)
    {
        // Burgers
        eggBurgerRecipe(items, output, ModItems.BEEF_BURGER, Items.COOKED_BEEF);
        eggBurgerRecipe(items, output, ModItems.PORK_BURGER, Items.COOKED_PORKCHOP);
        eggBurgerRecipe(items, output, ModItems.MUTTON_BURGER, Items.COOKED_MUTTON);
        eggBurgerRecipe(items, output, ModItems.CHICKEN_BURGER, Items.COOKED_CHICKEN);
        eggBurgerRecipe(items, output, ModItems.SALMON_BURGER, Items.COOKED_SALMON);
        eggBurgerRecipe(items, output, ModItems.COD_BURGER, Items.COOKED_COD);

        cheeseBurgerRecipe(items, output, ModItems.BEEF_CHEESE_BURGER, Items.COOKED_BEEF);
        cheeseBurgerRecipe(items, output, ModItems.PORK_CHEESE_BURGER, Items.COOKED_PORKCHOP);
        cheeseBurgerRecipe(items, output, ModItems.MUTTON_CHEESE_BURGER, Items.COOKED_MUTTON);
        cheeseBurgerRecipe(items, output, ModItems.CHICKEN_CHEESE_BURGER, Items.COOKED_CHICKEN);
        cheeseBurgerRecipe(items, output, ModItems.SALMON_CHEESE_BURGER, Items.COOKED_SALMON);
        cheeseBurgerRecipe(items, output, ModItems.COD_CHEESE_BURGER, Items.COOKED_COD);

        champignonBurgerRecipe(items, output, ModItems.BEEF_CHAMPIGNON_BURGER, Items.COOKED_BEEF);
        champignonBurgerRecipe(items, output, ModItems.PORK_CHAMPIGNON_BURGER, Items.COOKED_PORKCHOP);
        champignonBurgerRecipe(items, output, ModItems.MUTTON_CHAMPIGNON_BURGER, Items.COOKED_MUTTON);
        champignonBurgerRecipe(items, output, ModItems.CHICKEN_CHAMPIGNON_BURGER, Items.COOKED_CHICKEN);
        champignonBurgerRecipe(items, output, ModItems.SALMON_CHAMPIGNON_BURGER, Items.COOKED_SALMON);
        champignonBurgerRecipe(items, output, ModItems.COD_CHAMPIGNON_BURGER, Items.COOKED_COD);

        // Golden Burgers
        goldenBurgerRecipe(items, output, ModItems.GOLDEN_BEEF_BURGER, ModTags.BEEF_BURGERS);
        goldenBurgerRecipe(items, output, ModItems.GOLDEN_PORK_BURGER, ModTags.PORK_BURGERS);
        goldenBurgerRecipe(items, output, ModItems.GOLDEN_MUTTON_BURGER, ModTags.MUTTON_BURGERS);
        goldenBurgerRecipe(items, output, ModItems.GOLDEN_CHICKEN_BURGER, ModTags.CHICKEN_BURGERS);
        goldenBurgerRecipe(items, output, ModItems.GOLDEN_SALMON_BURGER, ModTags.SALMON_BURGERS);
        goldenBurgerRecipe(items, output, ModItems.GOLDEN_COD_BURGER, ModTags.COD_BURGERS);

        // Ingredients
        scrambledEggRecipe(items, output, ModItems.SCRAMBLED_EGG);
        cookingRecipe(items, output, ModItems.FRIED_SCRAMBLED_EGG, ModItems.SCRAMBLED_EGG);
        cheeseRecipe(items, output, ModItems.CHEESE);
        rawChampignonRecipe(items, output, ModItems.RAW_CHAMPIGNONS);
        cookingRecipe(items, output, ModItems.COOKED_CHAMPIGNONS, ModItems.RAW_CHAMPIGNONS);

        // Other foods
        chickenNuggetRecipe(items, output);
        friesRecipe(items, output);
        hotdogRecipe(items, output);
        sweetBerryTartRecipe(items, output);
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
    public static void baseBurgerRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result, int resultAmount, ItemLike mainIngredient, TagKey<Item> extraIngredient)
    {
        TagKey<Item> breadTag = ModTags.COMMON_FOODS_BREAD;
        ShapedRecipeBuilder.shaped(items, RecipeCategory.FOOD, result, resultAmount)
                .define('B', breadTag)
                .define('#', mainIngredient)
                .define('*', extraIngredient)
                .pattern(" B")
                .pattern("*#")
                .pattern(" B")
                .unlockedBy("has_bread", has(items, breadTag))
                .unlockedBy("has_main_ingredient", has(items, mainIngredient))
                .unlockedBy("has_extra_ingredient", has(items, extraIngredient))
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
    public static void baseBurgerRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result, int resultAmount, TagKey<Item> mainIngredient, TagKey<Item> extraIngredient)
    {
        TagKey<Item> breadTag = ModTags.COMMON_FOODS_BREAD;
        ShapedRecipeBuilder.shaped(items, RecipeCategory.FOOD, result, resultAmount)
                .define('B', breadTag)
                .define('#', mainIngredient)
                .define('*', extraIngredient)
                .pattern(" B")
                .pattern("*#")
                .pattern(" B")
                .unlockedBy("has_bread", has(items, breadTag))
                .unlockedBy("has_main_ingredient", has(items, mainIngredient))
                .unlockedBy("has_extra_ingredient", has(items, extraIngredient))
                .save(output);
    }

    public static void eggBurgerRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result, ItemLike ingredient)
    {
        TagKey<Item> friedEggTag = ModTags.COMMON_FOODS_FRIED_EGG;
        baseBurgerRecipe(items, output, result, 2, ingredient, friedEggTag);
    }

    public static void cheeseBurgerRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result, ItemLike ingredient)
    {
        TagKey<Item> cheeseTag = ModTags.COMMON_FOODS_CHEESE;
        baseBurgerRecipe(items, output, result, 2, ingredient, cheeseTag);
    }

    public static void champignonBurgerRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result, ItemLike ingredient)
    {
        TagKey<Item> cookedMushroomTag = ModTags.COMMON_FOODS_COOKED_MUSHROOM;
        baseBurgerRecipe(items, output, result, 2, ingredient, cookedMushroomTag);
    }

    /**
     * Recipe for Golden Burgers
     *
     * @param output Recipe consumer
     * @param result The golden burger
     * @param ingredient Crafting ingredient
     */
    public static void goldenBurgerRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result, TagKey<Item> ingredient)
    {
        TagKey<Item> goldIngotTag = ModTags.COMMON_INGOTS_GOLD;
        ShapedRecipeBuilder.shaped(items, RecipeCategory.FOOD, result)
                .define('G', goldIngotTag)
                .define('#', ingredient)
                .pattern("GGG")
                .pattern("G#G")
                .pattern("GGG")
                .unlockedBy("has_gold", has(items, goldIngotTag))
                .unlockedBy("has_burger", has(items, ingredient))
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
    public static void baseFoodCookingRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result, ItemLike ingredient, float experience)
    {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, CookingBookCategory.FOOD, result, experience, 200)
                .unlockedBy("has_" + ingredient.toString(), has(items, ingredient))
                .save(output, Identifier.parse(result + "_from_smelting").toString());

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600)
                .unlockedBy("has_" + ingredient.toString(), has(items, ingredient))
                .save(output, Identifier.parse(result + "_from_campfire").toString());

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100)
                .unlockedBy("has_" + ingredient.toString(), has(items, ingredient))
                .save(output, Identifier.parse(result + "_from_smoker").toString());
    }

    private static void cookingRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result, ItemLike ingredient)
    {
        baseFoodCookingRecipe(items, output, result, ingredient, 0.25F);
    }

    private static void scrambledEggRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result)
    {
        TagKey<Item> eggsTag = ModTags.COMMON_EGGS;
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, result)
                .requires(eggsTag)
                .unlockedBy("has_eggs", has(items, eggsTag))
                .save(output);
    }

    private static void cheeseRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result)
    {
        internalCheeseRecipe(items, output, result, Items.MILK_BUCKET, Items.SUGAR);
    }

    private static void internalCheeseRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result, ItemLike ingredient1, ItemLike ingredient2)
    {
        for (int amount = 1; amount <= 8; amount++)
        {
            ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, result, amount)
                    .requires(ingredient1)
                    .requires(ingredient2, amount)
                    .unlockedBy("has_" + ingredient1.toString(), has(items, ingredient1)).unlockedBy("has_" + ingredient2.toString(), has(items, ingredient2))
                    .save(output, Identifier.parse(result.toString() + "_" + amount).toString());
        }
    }

    private static void rawChampignonRecipe(HolderGetter<Item> items, RecipeOutput output, ItemLike result)
    {
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, result)
                .requires(Items.BROWN_MUSHROOM, 2)
                .unlockedBy("has_brown_mushroom", has(items, Items.BROWN_MUSHROOM))
                .save(output);
    }

    private static void chickenNuggetRecipe(HolderGetter<Item> items, RecipeOutput output)
    {
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.COOKED_CHICKEN_NUGGET, 6)
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy("has_cooked_chicken", has(items, Items.COOKED_CHICKEN))
                .save(output);
    }

    private static void friesRecipe(HolderGetter<Item> items, RecipeOutput output)
    {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.FOOD, ModItems.FRIES, 2)
                .define('P', Items.BAKED_POTATO)
                .pattern("PPP")
                .unlockedBy("has_baked_potato", has(items, Items.BAKED_POTATO))
                .save(output);
    }

    private static void hotdogRecipe(HolderGetter<Item> items, RecipeOutput output)
    {
        TagKey<Item> breadTag = ModTags.COMMON_FOODS_BREAD;
        TagKey<Item> chickenNuggetsTag = ModTags.COMMON_NUGGETS_CHICKEN;
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.HOTDOG, 4)
                .requires(Items.COOKED_BEEF)
                .requires(Items.COOKED_PORKCHOP)
                .requires(breadTag)
                .requires(chickenNuggetsTag)
                .unlockedBy("has_cooked_beef", has(items, Items.COOKED_BEEF))
                .unlockedBy("has_cooked_porkchop", has(items, Items.COOKED_PORKCHOP))
                .unlockedBy("has_bread", has(items, breadTag))
                .unlockedBy("has_cooked_chicken_nugget", has(items, chickenNuggetsTag))
                .save(output);
    }

    private static void sweetBerryTartRecipe(HolderGetter<Item> items, RecipeOutput output)
    {
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.SWEET_BERRY_TART)
                .requires(Items.SWEET_BERRIES, 3)
                .requires(Items.WHEAT)
                .requires(Items.SUGAR)
                .unlockedBy("has_sweet_berries", has(items, Items.SWEET_BERRIES))
                .unlockedBy("has_wheat", has(items, Items.WHEAT))
                .unlockedBy("has_sugar", has(items, Items.SUGAR))
                .save(output);
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderGetter<Item> items, ItemLike item)
    {
        return inventoryTrigger(ItemPredicate.Builder.item().of(items, item));
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderGetter<Item> items, TagKey<Item> itemTag)
    {
        return inventoryTrigger(ItemPredicate.Builder.item().of(items, itemTag));
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate.Builder... builder)
    {
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(
                Arrays.stream(builder).map(ItemPredicate.Builder::build).toArray(ItemPredicate[]::new))
        ));
    }
}
