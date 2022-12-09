package com.autovw.burgermod.datagen.providers;

import com.autovw.burgermod.BurgerMod;
import com.autovw.burgermod.core.registry.ModItems;
import com.autovw.burgermod.core.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

/**
 * @author Autovw
 */
public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        /* Burgers */
        eggBurgerRecipe(consumer, ModItems.BEEF_BURGER.get(), Items.COOKED_BEEF);
        eggBurgerRecipe(consumer, ModItems.PORK_BURGER.get(), Items.COOKED_PORKCHOP);
        eggBurgerRecipe(consumer, ModItems.MUTTON_BURGER.get(), Items.COOKED_MUTTON);
        eggBurgerRecipe(consumer, ModItems.CHICKEN_BURGER.get(), Items.COOKED_CHICKEN);
        eggBurgerRecipe(consumer, ModItems.SALMON_BURGER.get(), Items.COOKED_SALMON);
        eggBurgerRecipe(consumer, ModItems.COD_BURGER.get(), Items.COOKED_COD);

        cheeseBurgerRecipe(consumer, ModItems.BEEF_CHEESE_BURGER.get(), Items.COOKED_BEEF);
        cheeseBurgerRecipe(consumer, ModItems.PORK_CHEESE_BURGER.get(), Items.COOKED_PORKCHOP);
        cheeseBurgerRecipe(consumer, ModItems.MUTTON_CHEESE_BURGER.get(), Items.COOKED_MUTTON);
        cheeseBurgerRecipe(consumer, ModItems.CHICKEN_CHEESE_BURGER.get(), Items.COOKED_CHICKEN);
        cheeseBurgerRecipe(consumer, ModItems.SALMON_CHEESE_BURGER.get(), Items.COOKED_SALMON);
        cheeseBurgerRecipe(consumer, ModItems.COD_CHEESE_BURGER.get(), Items.COOKED_COD);

        champignonBurgerRecipe(consumer, ModItems.BEEF_CHAMPIGNON_BURGER.get(), Items.COOKED_BEEF);
        champignonBurgerRecipe(consumer, ModItems.PORK_CHAMPIGNON_BURGER.get(), Items.COOKED_PORKCHOP);
        champignonBurgerRecipe(consumer, ModItems.MUTTON_CHAMPIGNON_BURGER.get(), Items.COOKED_MUTTON);
        champignonBurgerRecipe(consumer, ModItems.CHICKEN_CHAMPIGNON_BURGER.get(), Items.COOKED_CHICKEN);
        champignonBurgerRecipe(consumer, ModItems.SALMON_CHAMPIGNON_BURGER.get(), Items.COOKED_SALMON);
        champignonBurgerRecipe(consumer, ModItems.COD_CHAMPIGNON_BURGER.get(), Items.COOKED_COD);

        /* Golden Burgers */
        goldenBurgerRecipe(consumer, ModItems.GOLDEN_BEEF_BURGER.get(), ModTags.BEEF_BURGERS);
        goldenBurgerRecipe(consumer, ModItems.GOLDEN_PORK_BURGER.get(), ModTags.PORK_BURGERS);
        goldenBurgerRecipe(consumer, ModItems.GOLDEN_MUTTON_BURGER.get(), ModTags.MUTTON_BURGERS);
        goldenBurgerRecipe(consumer, ModItems.GOLDEN_CHICKEN_BURGER.get(), ModTags.CHICKEN_BURGERS);
        goldenBurgerRecipe(consumer, ModItems.GOLDEN_SALMON_BURGER.get(), ModTags.SALMON_BURGERS);
        goldenBurgerRecipe(consumer, ModItems.GOLDEN_COD_BURGER.get(), ModTags.COD_BURGERS);

        /* Ingredients */
        scrambledEggRecipe(consumer, ModItems.SCRAMBLED_EGG.get());
        cookingRecipe(consumer, ModItems.FRIED_SCRAMBLED_EGG.get(), ModItems.SCRAMBLED_EGG.get());
        cheeseRecipe(consumer, ModItems.CHEESE.get());
        rawChampignonRecipe(consumer, ModItems.RAW_CHAMPIGNONS.get());
        cookingRecipe(consumer, ModItems.COOKED_CHAMPIGNONS.get(), ModItems.RAW_CHAMPIGNONS.get());

        /* Other foods */
        chickenNuggetRecipe(consumer);
        friesRecipe(consumer);
        hotdogRecipe(consumer);
        sweetBerryTartRecipe(consumer);
    }

    /**
     * Base recipe for burgers
     *
     * @param recipeConsumer Recipe consumer
     * @param result The recipe result item
     * @param resultAmount The result amount the recipe should return
     * @param mainIngredient The main ingredient (e.g. minecraft:steak for a beef burger)
     * @param extraIngredient Extra ingredient, a tag by default (e.g. forge:cheese for a cheese burger)
     */
    public static void baseBurgerRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, int resultAmount, ItemLike mainIngredient, TagKey<Item> extraIngredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result, resultAmount)
                .define('B', ModTags.FORGE_BREAD)
                .define('#', mainIngredient)
                .define('*', extraIngredient)
                .pattern(" B")
                .pattern("*#")
                .pattern(" B")
                .unlockedBy("has_bread", has(ModTags.FORGE_BREAD))
                .unlockedBy("has_" + mainIngredient.toString(), has(mainIngredient))
                .unlockedBy("has_" + extraIngredient.toString(), has(extraIngredient))
                .save(recipeConsumer);
    }

    /**
     * Base recipe for burgers
     *
     * @param recipeConsumer Recipe consumer
     * @param result The recipe result item
     * @param resultAmount The result amount the recipe should return
     * @param mainIngredient The main ingredient. If you want to return an item instead of a tag you should use the above method.
     * @param extraIngredient Extra ingredient, a tag by default (e.g. forge:cheese for a cheese burger)
     */
    public static void baseBurgerRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, int resultAmount, TagKey<Item> mainIngredient, TagKey<Item> extraIngredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result, resultAmount)
                .define('B', ModTags.FORGE_BREAD)
                .define('#', mainIngredient)
                .define('*', extraIngredient)
                .pattern(" B")
                .pattern("*#")
                .pattern(" B")
                .unlockedBy("has_bread", has(ModTags.FORGE_BREAD))
                .unlockedBy("has_" + mainIngredient.toString(), has(mainIngredient))
                .unlockedBy("has_" + extraIngredient.toString(), has(extraIngredient))
                .save(recipeConsumer);
    }

    public static void eggBurgerRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, ItemLike ingredient) {
        baseBurgerRecipe(recipeConsumer, result, 2, ingredient, ModTags.FORGE_FRIED_EGG);
    }

    public static void eggBurgerRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, TagKey<Item> ingredient) {
        baseBurgerRecipe(recipeConsumer, result, 2, ingredient, ModTags.FORGE_FRIED_EGG);
    }

    public static void cheeseBurgerRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, ItemLike ingredient) {
        baseBurgerRecipe(recipeConsumer, result, 2, ingredient, ModTags.FORGE_CHEESE);
    }

    public static void cheeseBurgerRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, TagKey<Item> ingredient) {
        baseBurgerRecipe(recipeConsumer, result, 2, ingredient, ModTags.FORGE_CHEESE);
    }

    public static void champignonBurgerRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, ItemLike ingredient) {
        baseBurgerRecipe(recipeConsumer, result, 2, ingredient, ModTags.FORGE_COOKED_MUSHROOM);
    }

    public static void champignonBurgerRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, TagKey<Item> ingredient) {
        baseBurgerRecipe(recipeConsumer, result, 2, ingredient, ModTags.FORGE_COOKED_MUSHROOM);
    }

    /**
     * Recipe for Golden Burgers
     *
     * @param recipeConsumer Recipe consumer
     * @param result The golden burger
     * @param ingredient Crafting ingredient
     */
    public static void goldenBurgerRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, TagKey<Item> ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result)
                .define('G', Tags.Items.INGOTS_GOLD)
                .define('#', ingredient)
                .pattern("GGG")
                .pattern("G#G")
                .pattern("GGG")
                .unlockedBy("has_gold", has(Tags.Items.INGOTS_GOLD))
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(recipeConsumer);
    }

    /**
     * Base recipe for cooking food(s). Includes recipes for: furnace, campfire and smoker.
     *
     * @param recipeConsumer Recipe consumer
     * @param result Result item
     * @param ingredient Ingredient item
     * @param experience Experience given upon obtaining the result item
     * @param modId Provide your modId so the data generator knows where to dump your recipes
     */
    public static void baseFoodCookingRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, ItemLike ingredient, float experience, String modId) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200)
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(recipeConsumer, new ResourceLocation(modId, result + "_from_smelting"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600)
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(recipeConsumer, new ResourceLocation(modId, result + "_from_campfire"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100)
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(recipeConsumer, new ResourceLocation(modId, result + "_from_smoker"));
    }

    private static void cookingRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, ItemLike ingredient) {
        baseFoodCookingRecipe(recipeConsumer, result, ingredient, 0.25F, BurgerMod.MOD_ID);
    }

    private static void scrambledEggRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(Tags.Items.EGGS)
                .unlockedBy("has_eggs", has(Tags.Items.EGGS))
                .save(recipeConsumer);
    }

    private static void cheeseRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result) {
        internalCheeseRecipe(recipeConsumer, result, Items.MILK_BUCKET, Items.SUGAR);
    }

    private static void internalCheeseRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, ItemLike ingredient1, ItemLike ingredient2) {
        for (int amount = 1; amount <= 8; amount++) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, amount)
                    .requires(ingredient1)
                    .requires(ingredient2, amount)
                    .unlockedBy("has_" + ingredient1.toString(), has(ingredient1)).unlockedBy("has_" + ingredient2.toString(), has(ingredient2))
                    .save(recipeConsumer, new ResourceLocation(BurgerMod.MOD_ID, result.toString() + "_" + amount));
        }
    }

    private static void rawChampignonRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(Items.BROWN_MUSHROOM, 2)
                .unlockedBy("has_brown_mushroom", has(Items.BROWN_MUSHROOM))
                .save(recipeConsumer);
    }

    private static void chickenNuggetRecipe(Consumer<FinishedRecipe> recipeConsumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COOKED_CHICKEN_NUGGET.get(), 6)
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy("has_cooked_chicken", has(Items.COOKED_CHICKEN))
                .save(recipeConsumer);
    }

    private static void friesRecipe(Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.FRIES.get(), 2)
                .define('P', Items.BAKED_POTATO)
                .pattern("PPP")
                .unlockedBy("has_baked_potato", has(Items.BAKED_POTATO))
                .save(recipeConsumer);
    }

    private static void hotdogRecipe(Consumer<FinishedRecipe> recipeConsumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOTDOG.get(), 4)
                .requires(Items.COOKED_BEEF)
                .requires(Items.COOKED_PORKCHOP)
                .requires(Items.BREAD)
                .requires(ModTags.FORGE_NUGGETS_CHICKEN)
                .unlockedBy("has_cooked_beef", has(Items.COOKED_BEEF))
                .unlockedBy("has_cooked_porkchop", has(Items.COOKED_PORKCHOP))
                .unlockedBy("has_bread", has(Items.BREAD))
                .unlockedBy("has_cooked_chicken_nugget", has(ModTags.FORGE_NUGGETS_CHICKEN))
                .save(recipeConsumer);
    }

    private static void sweetBerryTartRecipe(Consumer<FinishedRecipe> recipeConsumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SWEET_BERRY_TART.get())
                .requires(Items.SWEET_BERRIES, 3)
                .requires(Items.WHEAT)
                .requires(Items.SUGAR)
                .unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES))
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(recipeConsumer);
    }
}
