package com.autovw.burgermod.common.common.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

/**
 * @author Autovw
 */
public class ChestLootAddition
{
    public static final Codec<ChestLootAddition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Identifier.CODEC.fieldOf("target").forGetter(ChestLootAddition::getTarget),
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(ChestLootAddition::getItem),
            Codec.INT.fieldOf("min").forGetter(ChestLootAddition::getMin),
            Codec.INT.fieldOf("max").forGetter(ChestLootAddition::getMax),
            Codec.FLOAT.optionalFieldOf("chance", 1.0f).forGetter(ChestLootAddition::getChance)
    ).apply(instance, ChestLootAddition::new));

    private final Identifier target;
    private final Item item;
    private final int min;
    private final int max;
    private final float chance;

    public ChestLootAddition(Identifier target, Item item, int min, int max, float chance)
    {
        this.target = target;
        this.item = item;
        this.min = min;
        this.max = max;
        this.chance = chance;
    }

    public ChestLootAddition(Identifier target, Item item, int min, int max)
    {
        this(target, item, min, max, 1.0f);
    }

    public Identifier getTarget()
    {
        return this.target;
    }

    public Item getItem()
    {
        return this.item;
    }

    public int getMin()
    {
        return this.min;
    }

    public int getMax()
    {
        return this.max;
    }

    public float getChance()
    {
        return this.chance;
    }
}
