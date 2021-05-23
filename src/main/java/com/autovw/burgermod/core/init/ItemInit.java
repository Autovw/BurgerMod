package com.autovw.burgermod.core.init;

import com.autovw.burgermod.item.items.ItemBase;
import com.autovw.burgermod.item.items.ItemRaw;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    // Egg Meat Burgers
    public static final Item BEEF_BURGER = new ItemBase("beef_burger", 10, 1.0f, true);
    public static final Item PORK_BURGER = new ItemBase("pork_burger", 10, 1.0f, true);
    public static final Item MUTTON_BURGER = new ItemBase("mutton_burger", 8, 1.0f, true);

    // Cheese Meat Burgers
    public static final Item BEEF_CHEESE_BURGER = new ItemBase("beef_cheese_burger", 10, 1.0f, true);
    public static final Item PORK_CHEESE_BURGER = new ItemBase("pork_cheese_burger", 10, 1.0f, true);
    public static final Item MUTTON_CHEESE_BURGER = new ItemBase("mutton_cheese_burger", 8, 1.0f, true);

    // Eggs
    public static final Item SCRAMBLED_EGG = new ItemRaw("scrambled_egg", 1, 0.1f, false).addPoisonEffect();
    public static final Item FRIED_SCRAMBLED_EGG = new ItemBase("fried_scrambled_egg", 2, 0.6f, true);

    // Others
    public static final Item COOKED_CHICKEN_NUGGET = new ItemBase("cooked_chicken_nugget", 1, 0.6f, true);
    public static final Item CHEESE = new ItemBase("cheese", 2, 0.6f, false);
}
