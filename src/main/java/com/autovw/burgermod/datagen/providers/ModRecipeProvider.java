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

/**
 * @author Autovw
 */
public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        /* Burgers */
        eggBurgerRecipe(output, ModItems.BEEF_BURGER.get(), Items.COOKED_BEEF);
        eggBurgerRecipe(output, ModItems.PORK_BURGER.get(), Items.COOKED_PORKCHOP);
        eggBurgerRecipe(output, ModItems.MUTTON_BURGER.get(), Items.COOKED_MUTTON);
        eggBurgerRecipe(output, ModItems.CHICKEN_BURGER.get(), Items.COOKED_CHICKEN);
        eggBurgerRecipe(output, ModItems.SALMON_BURGER.get(), Items.COOKED_SALMON);
        eggBurgerRecipe(output, ModItems.COD_BURGER.get(), Items.COOKED_COD);

        cheeseBurgerRecipe(output, ModItems.BEEF_CHEESE_BURGER.get(), Items.COOKED_BEEF);
        cheeseBurgerRecipe(output, ModItems.PORK_CHEESE_BURGER.get(), Items.COOKED_PORKCHOP);
        cheeseBurgerRecipe(output, ModItems.MUTTON_CHEESE_BURGER.get(), Items.COOKED_MUTTON);
        cheeseBurgerRecipe(output, ModItems.CHICKEN_CHEESE_BURGER.get(), Items.COOKED_CHICKEN);
        cheeseBurgerRecipe(output, ModItems.SALMON_CHEESE_BURGER.get(), Items.COOKED_SALMON);
        cheeseBurgerRecipe(output, ModItems.COD_CHEESE_BURGER.get(), Items.COOKED_COD);

        champignonBurgerRecipe(output, ModItems.BEEF_CHAMPIGNON_BURGER.get(), Items.COOKED_BEEF);
        champignonBurgerRecipe(output, ModItems.PORK_CHAMPIGNON_BURGER.get(), Items.COOKED_PORKCHOP);
        champignonBurgerRecipe(output, ModItems.MUTTON_CHAMPIGNON_BURGER.get(), Items.COOKED_MUTTON);
        champignonBurgerRecipe(output, ModItems.CHICKEN_CHAMPIGNON_BURGER.get(), Items.COOKED_CHICKEN);
        champignonBurgerRecipe(output, ModItems.SALMON_CHAMPIGNON_BURGER.get(), Items.COOKED_SALMON);
        champignonBurgerRecipe(output, ModItems.COD_CHAMPIGNON_BURGER.get(), Items.COOKED_COD);

        /* Golden Burgers */
        goldenBurgerRecipe(output, ModItems.GOLDEN_BEEF_BURGER.get(), ModTags.BEEF_BURGERS);
        goldenBurgerRecipe(output, ModItems.GOLDEN_PORK_BURGER.get(), ModTags.PORK_BURGERS);
        goldenBurgerRecipe(output, ModItems.GOLDEN_MUTTON_BURGER.get(), ModTags.MUTTON_BURGERS);
        goldenBurgerRecipe(output, ModItems.GOLDEN_CHICKEN_BURGER.get(), ModTags.CHICKEN_BURGERS);
        goldenBurgerRecipe(output, ModItems.GOLDEN_SALMON_BURGER.get(), ModTags.SALMON_BURGERS);
        goldenBurgerRecipe(output, ModItems.GOLDEN_COD_BURGER.get(), ModTags.COD_BURGERS);

        /* Ingredients */
        scrambledEggRecipe(output, ModItems.SCRAMBLED_EGG.get());
        cookingRecipe(output, ModItems.FRIED_SCRAMBLED_EGG.get(), ModItems.SCRAMBLED_EGG.get());
        cheeseRecipe(output, ModItems.CHEESE.get());
        rawChampignonRecipe(output, ModItems.RAW_CHAMPIGNONS.get());
        cookingRecipe(output, ModItems.COOKED_CHAMPIGNONS.get(), ModItems.RAW_CHAMPIGNONS.get());

        /* Other foods */
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
    public static void baseBurgerRecipe(RecipeOutput output, ItemLike result, int resultAmount, ItemLike mainIngredient, TagKey<Item> extraIngredient) {
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
    public static void baseBurgerRecipe(RecipeOutput output, ItemLike result, int resultAmount, TagKey<Item> mainIngredient, TagKey<Item> extraIngredient) {
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
                .save(output);
    }

    public static void eggBurgerRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        baseBurgerRecipe(output, result, 2, ingredient, ModTags.FORGE_FRIED_EGG);
    }

    public static void eggBurgerRecipe(RecipeOutput output, ItemLike result, TagKey<Item> ingredient) {
        baseBurgerRecipe(output, result, 2, ingredient, ModTags.FORGE_FRIED_EGG);
    }

    public static void cheeseBurgerRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        baseBurgerRecipe(output, result, 2, ingredient, ModTags.FORGE_CHEESE);
    }

    public static void cheeseBurgerRecipe(RecipeOutput output, ItemLike result, TagKey<Item> ingredient) {
        baseBurgerRecipe(output, result, 2, ingredient, ModTags.FORGE_CHEESE);
    }

    public static void champignonBurgerRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        baseBurgerRecipe(output, result, 2, ingredient, ModTags.FORGE_COOKED_MUSHROOM);
    }

    public static void champignonBurgerRecipe(RecipeOutput output, ItemLike result, TagKey<Item> ingredient) {
        baseBurgerRecipe(output, result, 2, ingredient, ModTags.FORGE_COOKED_MUSHROOM);
    }

    /**
     * Recipe for Golden Burgers
     *
     * @param output Recipe consumer
     * @param result The golden burger
     * @param ingredient Crafting ingredient
     */
    public static void goldenBurgerRecipe(RecipeOutput output, ItemLike result, TagKey<Item> ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result)
                .define('G', Tags.Items.INGOTS_GOLD)
                .define('#', ingredient)
                .pattern("GGG")
                .pattern("G#G")
                .pattern("GGG")
                .unlockedBy("has_gold", has(Tags.Items.INGOTS_GOLD))
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(output);
    }

    /**
     * Base recipe for cooking food(s). Includes recipes for: furnace, campfire and smoker.
     *
     * @param output Recipe consumer
     * @param result Result item
     * @param ingredient Ingredient item
     * @param experience Experience given upon obtaining the result item
     * @param modId Provide your modId so the data generator knows where to dump your recipes
     */
    public static void baseFoodCookingRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient, float experience, String modId) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200)
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(output, new ResourceLocation(modId, result + "_from_smelting"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600)
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(output, new ResourceLocation(modId, result + "_from_campfire"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100)
                .unlockedBy("has_" + ingredient.toString(), has(ingredient))
                .save(output, new ResourceLocation(modId, result + "_from_smoker"));
    }

    private static void cookingRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient) {
        baseFoodCookingRecipe(output, result, ingredient, 0.25F, BurgerMod.MOD_ID);
    }

    private static void scrambledEggRecipe(RecipeOutput output, ItemLike result) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(Tags.Items.EGGS)
                .unlockedBy("has_eggs", has(Tags.Items.EGGS))
                .save(output);
    }

    private static void cheeseRecipe(RecipeOutput output, ItemLike result) {
        internalCheeseRecipe(output, result, Items.MILK_BUCKET, Items.SUGAR);
    }

    private static void internalCheeseRecipe(RecipeOutput output, ItemLike result, ItemLike ingredient1, ItemLike ingredient2) {
        for (int amount = 1; amount <= 8; amount++) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, amount)
                    .requires(ingredient1)
                    .requires(ingredient2, amount)
                    .unlockedBy("has_" + ingredient1.toString(), has(ingredient1)).unlockedBy("has_" + ingredient2.toString(), has(ingredient2))
                    .save(output, new ResourceLocation(BurgerMod.MOD_ID, result.toString() + "_" + amount));
        }
    }

    private static void rawChampignonRecipe(RecipeOutput output, ItemLike result) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(Items.BROWN_MUSHROOM, 2)
                .unlockedBy("has_brown_mushroom", has(Items.BROWN_MUSHROOM))
                .save(output);
    }

    private static void chickenNuggetRecipe(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COOKED_CHICKEN_NUGGET.get(), 6)
                .requires(Items.COOKED_CHICKEN)
                .unlockedBy("has_cooked_chicken", has(Items.COOKED_CHICKEN))
                .save(output);
    }

    private static void friesRecipe(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.FRIES.get(), 2)
                .define('P', Items.BAKED_POTATO)
                .pattern("PPP")
                .unlockedBy("has_baked_potato", has(Items.BAKED_POTATO))
                .save(output);
    }

    private static void hotdogRecipe(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOTDOG.get(), 4)
                .requires(Items.COOKED_BEEF)
                .requires(Items.COOKED_PORKCHOP)
                .requires(Items.BREAD)
                .requires(ModTags.FORGE_NUGGETS_CHICKEN)
                .unlockedBy("has_cooked_beef", has(Items.COOKED_BEEF))
                .unlockedBy("has_cooked_porkchop", has(Items.COOKED_PORKCHOP))
                .unlockedBy("has_bread", has(Items.BREAD))
                .unlockedBy("has_cooked_chicken_nugget", has(ModTags.FORGE_NUGGETS_CHICKEN))
                .save(output);
    }

    private static void sweetBerryTartRecipe(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SWEET_BERRY_TART.get())
                .requires(Items.SWEET_BERRIES, 3)
                .requires(Items.WHEAT)
                .requires(Items.SUGAR)
                .unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES))
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(output);
    }
}
