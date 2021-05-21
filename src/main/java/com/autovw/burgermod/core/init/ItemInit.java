package com.autovw.burgermod.core.init;

import com.autovw.burgermod.BurgerMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BurgerMod.MOD_ID);

    // Burgers
    public static final RegistryObject<Item> BURGER = ITEMS.register("burger",
            () -> new Item(new Item.Properties().food(new Food.Builder().hunger(10).meat().saturation(1.0f).build())));

    public static final RegistryObject<Item> BEEF_BURGER = ITEMS.register("beef_burger",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)
                    .food(new Food.Builder().hunger(10).meat().saturation(1.0f).build())));

    public static final RegistryObject<Item> PORK_BURGER = ITEMS.register("pork_burger",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)
                    .food(new Food.Builder().hunger(10).meat().saturation(1.0f).build())));

    // Eggs
    public static final RegistryObject<Item> SCRAMBLED_EGG = ITEMS.register("scrambled_egg",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)
                    .food(new Food.Builder().hunger(1).saturation(0.1f).effect(() -> new EffectInstance
                            (Effects.POISON, 160, 0), 1.0f).build())));

    public static final RegistryObject<Item> FRIED_SCRAMBLED_EGG = ITEMS.register("fried_scrambled_egg",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)
                    .food(new Food.Builder().hunger(2).saturation(0.6f).build())));

    // Others
    public static final RegistryObject<Item> COOKED_CHICKEN_NUGGET = ITEMS.register("cooked_chicken_nugget",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)
                    .food(new Food.Builder().hunger(1).saturation(0.6f).meat().build())));
}
