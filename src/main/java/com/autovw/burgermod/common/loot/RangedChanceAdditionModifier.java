package com.autovw.burgermod.common.loot;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;

/**
 * Author: Autovw
 */
public class RangedChanceAdditionModifier extends LootModifier {
    private final Item itemAddition;
    private final int minAddition, maxAddition;
    private final float chanceAddition;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public RangedChanceAdditionModifier(ILootCondition[] conditionsIn, Item itemAddition, int minAddition, int maxAddition, float chanceAddition) {
        super(conditionsIn);
        this.itemAddition = itemAddition;
        this.minAddition = minAddition;
        this.maxAddition = maxAddition;
        this.chanceAddition = chanceAddition;
    }

    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (maxAddition >= minAddition && context.getRandom().nextFloat() <= chanceAddition) {
            generatedLoot.add(new ItemStack(itemAddition, context.getRandom().ints(minAddition, maxAddition + 1).iterator().nextInt()));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<RangedChanceAdditionModifier> {

        @Override
        public RangedChanceAdditionModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {
            Item itemAddition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getAsString(object, "item_addition")));
            int minAddition = JSONUtils.getAsInt(object, "min_addition");
            int maxAddition = JSONUtils.getAsInt(object, "max_addition");
            float chanceAddition = JSONUtils.getAsFloat(object, "chance_addition");
            return new RangedChanceAdditionModifier(ailootcondition, itemAddition, minAddition, maxAddition, chanceAddition);
        }

        @Override
        public JsonObject write(RangedChanceAdditionModifier instance) {
            JsonObject object = makeConditions(instance.conditions);
            object.addProperty("item_addition", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(instance.itemAddition)).toString());
            object.addProperty("min_addition", instance.minAddition);
            object.addProperty("max_addition", instance.maxAddition);
            object.addProperty("chance_addition", instance.chanceAddition);
            return object;
        }
    }
}
