package com.autovw.burgermod.common.datagen;

import com.autovw.burgermod.common.BurgerMod;
import com.autovw.burgermod.common.core.ModItems;
import com.autovw.burgermod.common.core.util.ModTags;
import com.autovw.burgermod.common.platform.IPlatformHelper;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
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
        AdvancementHolder craftBurger = Advancement.Builder.advancement()
                .parent(ResourceLocation.withDefaultNamespace("husbandry/plant_seed"))
                .display(ModItems.BEEF_BURGER, Component.translatable("advancements.burgermod.husbandry.craft_burger.title"), Component.translatable("advancements.burgermod.husbandry.craft_burger.description"), null, AdvancementType.TASK, true, true, false)
                .addCriterion("burgers", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ModTags.BURGERS)))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/craft_burger").toString());

        AdvancementHolder goldenBurger = Advancement.Builder.advancement()
                .parent(craftBurger)
                .display(ModItems.GOLDEN_BEEF_BURGER, Component.translatable("advancements.burgermod.husbandry.craft_golden_burger.title"), Component.translatable("advancements.burgermod.husbandry.craft_golden_burger.description"), null, AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(100))
                .addCriterion("golden_burgers", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ModTags.GOLDEN_BURGERS)))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/craft_golden_burger").toString());

        Advancement.Builder.advancement()
                .parent(goldenBurger)
                .display(ModItems.ENCHANTED_GOLDEN_BURGER, Component.translatable("advancements.burgermod.husbandry.obtain_enchanted_golden_burger.title"), Component.translatable("advancements.burgermod.husbandry.obtain_enchanted_golden_burger.description"), null, AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(100))
                .addCriterion("enchanted_golden_burger", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ModItems.ENCHANTED_GOLDEN_BURGER)))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(BurgerMod.MOD_ID, "husbandry/obtain_enchanted_golden_burger").toString());
    }

    public static void recipes(RecipeOutput output)
    {
        // Burgers
        eggBurgerRecipe(output, ModItems.BEEF_BURGER, Items.COOKED_BEEF);
        eggBurgerRecipe(output, ModItems.PORK_BURGER, Items.COOKED_PORKCHOP);
        eggBurgerRecipe(output, ModItems.MUTTON_BURGER, Items.COOKED_MUTTON);
        eggBurgerRecipe(output, ModItems.CHICKEN_BURGER, Items.COOKED_CHICKEN);
        eggBurgerRecipe(output, ModItems.SALMON_BURGER, Items.COOKED_SALMON);
        eggBurgerRecipe(output, ModItems.COD_BURGER, Items.COOKED_COD);

        cheeseBurgerRecipe(output, ModItems.BEEF_CHEESE_BURGER, Items.COOKED_BEEF);
        cheeseBurgerRecipe(output, ModItems.PORK_CHEESE_BURGER, Items.COOKED_PORKCHOP);
        cheeseBurgerRecipe(output, ModItems.MUTTON_CHEESE_BURGER, Items.COOKED_MUTTON);
        cheeseBurgerRecipe(output, ModItems.CHICKEN_CHEESE_BURGER, Items.COOKED_CHICKEN);
        cheeseBurgerRecipe(output, ModItems.SALMON_CHEESE_BURGER, Items.COOKED_SALMON);
        cheeseBurgerRecipe(output, ModItems.COD_CHEESE_BURGER, Items.COOKED_COD);

        champignonBurgerRecipe(output, ModItems.BEEF_CHAMPIGNON_BURGER, Items.COOKED_BEEF);
        champignonBurgerRecipe(output, ModItems.PORK_CHAMPIGNON_BURGER, Items.COOKED_PORKCHOP);
        champignonBurgerRecipe(output, ModItems.MUTTON_CHAMPIGNON_BURGER, Items.COOKED_MUTTON);
        champignonBurgerRecipe(output, ModItems.CHICKEN_CHAMPIGNON_BURGER, Items.COOKED_CHICKEN);
        champignonBurgerRecipe(output, ModItems.SALMON_CHAMPIGNON_BURGER, Items.COOKED_SALMON);
        champignonBurgerRecipe(output, ModItems.COD_CHAMPIGNON_BURGER, Items.COOKED_COD);

        // Golden Burgers
        goldenBurgerRecipe(output, ModItems.GOLDEN_BEEF_BURGER, ModTags.BEEF_BURGERS);
        goldenBurgerRecipe(output, ModItems.GOLDEN_PORK_BURGER, ModTags.PORK_BURGERS);
        goldenBurgerRecipe(output, ModItems.GOLDEN_MUTTON_BURGER, ModTags.MUTTON_BURGERS);
        goldenBurgerRecipe(output, ModItems.GOLDEN_CHICKEN_BURGER, ModTags.CHICKEN_BURGERS);
        goldenBurgerRecipe(output, ModItems.GOLDEN_SALMON_BURGER, ModTags.SALMON_BURGERS);
        goldenBurgerRecipe(output, ModItems.GOLDEN_COD_BURGER, ModTags.COD_BURGERS);

        // Ingredients
        scrambledEggRecipe(output, ModItems.SCRAMBLED_EGG);
        cookingRecipe(output, ModItems.FRIED_SCRAMBLED_EGG, ModItems.SCRAMBLED_EGG);
        cheeseRecipe(output, ModItems.CHEESE);
        rawChampignonRecipe(output, ModItems.RAW_CHAMPIGNONS);
        cookingRecipe(output, ModItems.COOKED_CHAMPIGNONS, ModItems.RAW_CHAMPIGNONS);

        // Other foods
        chickenNuggetRecipe(output);
        friesRecipe(output);
        hotdogRecipe(output);
        sweetBerryTartRecipe(output);
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
    public static void baseBurgerRecipe(RecipeOutput output, ItemLike result, int resultAmount, ItemLike mainIngredient, TagKey<Item> extraIngredient)
    {
        TagKey<Item> breadTag = getTag(ModTags.FORGE_BREAD, ModTags.COMMON_FOODS_BREAD);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result, resultAmount)
                .define('B', breadTag)
                .define('#', mainIngredient)
                .define('*', extraIngredient)
                .pattern(" B")
                .pattern("*#")
                .pattern(" B")
                .unlockedBy("has_bread", has(breadTag))
                .unlockedBy("has_main_ingredient", has(mainIngredient))
                .unlockedBy("has_extra_ingredient", has(extraIngredient))
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
    public static void baseBurgerRecipe(RecipeOutput output, ItemLike result, int resultAmount, TagKey<Item> mainIngredient, TagKey<Item> extraIngredient)
    {
        TagKey<Item> breadTag = getTag(ModTags.FORGE_BREAD, ModTags.COMMON_FOODS_BREAD);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result, resultAmount)
                .define('B', breadTag)
                .define('#', mainIngredient)
                .define('*', extraIngredient)
                .pattern(" B")
                .pattern("*#")
                .pattern(" B")
                .unlockedBy("has_bread", has(breadTag))
                .unlockedBy("has_main_ingredient", has(mainIngredient))
                .unlockedBy("has_extra_ingredient", has(extraIngredient))
                .save(output);
    }

    public static void eggBurgerRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient)
    {
        TagKey<Item> friedEggTag = getTag(ModTags.FORGE_FRIED_EGG, ModTags.COMMON_FOODS_FRIED_EGG);
        baseBurgerRecipe(output, result, 2, ingredient, friedEggTag);
    }

    public static void cheeseBurgerRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient)
    {
        TagKey<Item> cheeseTag = getTag(ModTags.FORGE_CHEESE, ModTags.COMMON_FOODS_CHEESE);
        baseBurgerRecipe(output, result, 2, ingredient, cheeseTag);
    }

    public static void champignonBurgerRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient)
    {
        TagKey<Item> cookedMushroomTag = getTag(ModTags.FORGE_COOKED_MUSHROOM, ModTags.COMMON_FOODS_COOKED_MUSHROOM);
        baseBurgerRecipe(output, result, 2, ingredient, cookedMushroomTag);
    }

    /**
     * Recipe for Golden Burgers
     *
     * @param output Recipe consumer
     * @param result The golden burger
     * @param ingredient Crafting ingredient
     */
    public static void goldenBurgerRecipe(RecipeOutput output, ItemLike result, TagKey<Item> ingredient)
    {
        TagKey<Item> goldIngotTag = getTag(ModTags.FORGE_INGOTS_GOLD, ModTags.COMMON_INGOTS_GOLD);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result)
                .define('G', goldIngotTag)
                .define('#', ingredient)
                .pattern("GGG")
                .pattern("G#G")
                .pattern("GGG")
                .unlockedBy("has_gold", has(goldIngotTag))
                .unlockedBy("has_burger", has(ingredient))
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
    public static void baseFoodCookingRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient, float experience)
    {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200)
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(output, ResourceLocation.parse(result + "_from_smelting"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600)
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(output, ResourceLocation.parse(result + "_from_campfire"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100)
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(output, ResourceLocation.parse(result + "_from_smoker"));
    }

    private static void cookingRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient)
    {
        baseFoodCookingRecipe(output, result, ingredient, 0.25F);
    }

    private static void scrambledEggRecipe(RecipeOutput output, ItemLike result)
    {
        TagKey<Item> eggsTag = getTag(ModTags.FORGE_EGGS, ModTags.COMMON_EGGS);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(eggsTag)
                .unlockedBy("has_eggs", has(eggsTag))
                .save(output);
    }

    private static void cheeseRecipe(RecipeOutput output, ItemLike result)
    {
        internalCheeseRecipe(output, result, Items.MILK_BUCKET, Items.SUGAR);
    }

    private static void internalCheeseRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient1, ItemLike ingredient2)
    {
        for (int amount = 1; amount <= 8; amount++)
        {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, amount)
                    .requires(ingredient1)
                    .requires(ingredient2, amount)
                    .unlockedBy("has_" + ingredient1.toString(), has(ingredient1)).unlockedBy("has_" + ingredient2.toString(), has(ingredient2))
                    .save(output, ResourceLocation.parse(result.toString() + "_" + amount));
        }
    }

    private static void rawChampignonRecipe(RecipeOutput output, ItemLike result)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(Items.BROWN_MUSHROOM, 2)
                .unlockedBy("has_brown_mushroom", has(Items.BROWN_MUSHROOM))
                .save(output);
    }

    private static void chickenNuggetRecipe(RecipeOutput output)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COOKED_CHICKEN_NUGGET, 6)
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy("has_cooked_chicken", has(Items.COOKED_CHICKEN))
                .save(output);
    }

    private static void friesRecipe(RecipeOutput output)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.FRIES, 2)
                .define('P', Items.BAKED_POTATO)
                .pattern("PPP")
                .unlockedBy("has_baked_potato", has(Items.BAKED_POTATO))
                .save(output);
    }

    private static void hotdogRecipe(RecipeOutput output)
    {
        TagKey<Item> breadTag = getTag(ModTags.FORGE_BREAD, ModTags.COMMON_FOODS_BREAD);
        TagKey<Item> chickenNuggetsTag = getTag(ModTags.FORGE_NUGGETS_CHICKEN, ModTags.COMMON_NUGGETS_CHICKEN);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOTDOG, 4)
                .requires(Items.COOKED_BEEF)
                .requires(Items.COOKED_PORKCHOP)
                .requires(breadTag)
                .requires(chickenNuggetsTag)
                .unlockedBy("has_cooked_beef", has(Items.COOKED_BEEF))
                .unlockedBy("has_cooked_porkchop", has(Items.COOKED_PORKCHOP))
                .unlockedBy("has_bread", has(breadTag))
                .unlockedBy("has_cooked_chicken_nugget", has(chickenNuggetsTag))
                .save(output);
    }

    private static void sweetBerryTartRecipe(RecipeOutput output)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SWEET_BERRY_TART)
                .requires(Items.SWEET_BERRIES, 3)
                .requires(Items.WHEAT)
                .requires(Items.SUGAR)
                .unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES))
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(output);
    }

    private static TagKey<Item> getTag(TagKey<Item> forgeTag, TagKey<Item> commonTag)
    {
        boolean isForge = BurgerMod.getPlatformHelper().getPlatform().equals(IPlatformHelper.Platform.FORGE);
        return isForge ? forgeTag : commonTag;
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike item)
    {
        return inventoryTrigger(net.minecraft.advancements.critereon.ItemPredicate.Builder.item().of(item));
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> itemTag)
    {
        return inventoryTrigger(net.minecraft.advancements.critereon.ItemPredicate.Builder.item().of(itemTag));
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate.Builder... builder)
    {
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(
                Arrays.stream(builder).map(ItemPredicate.Builder::build).toArray(ItemPredicate[]::new))
        ));
    }
}
