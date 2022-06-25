package com.autovw.burgermod.common.loot;

import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Author: Autovw
 * @since 2.8.0
 */
public class LootAdditionModifier extends LootModifier {
    private final Item itemAddition;
    private final int minAddition, maxAddition;
    private final float chanceAddition;

    /**
     * Constructs a LootAdditionModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     * @param itemAddition the item added to the pool
     * @param minAddition the minimum amount to generate
     * @param maxAddition the maximum amount to generate
     * @param chanceAddition the chance of the item generating
     */
    public LootAdditionModifier(LootItemCondition[] conditionsIn, Item itemAddition, int minAddition, int maxAddition, float chanceAddition) {
        super(conditionsIn);
        this.itemAddition = itemAddition;
        this.minAddition = minAddition;
        this.maxAddition = maxAddition;
        this.chanceAddition = chanceAddition;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (maxAddition >= minAddition && context.getRandom().nextFloat() <= chanceAddition) {
            generatedLoot.add(new ItemStack(itemAddition, context.getRandom().nextIntBetweenInclusive(minAddition, maxAddition)));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<LootAdditionModifier> {

        @Override
        public LootAdditionModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
            JsonObject additionObject = GsonHelper.getAsJsonObject(object, "addition");
            Item itemAddition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(additionObject, "item")));
            int minAddition = GsonHelper.getAsInt(additionObject, "min");
            int maxAddition = GsonHelper.getAsInt(additionObject, "max");
            float chanceAddition = GsonHelper.getAsFloat(additionObject, "chance");
            return new LootAdditionModifier(ailootcondition, itemAddition, minAddition, maxAddition, chanceAddition);
        }

        @Override
        public JsonObject write(LootAdditionModifier instance) {
            JsonObject object = makeConditions(instance.conditions);
            JsonObject additionObject = new JsonObject();
            object.add("addition", additionObject);
            additionObject.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(instance.itemAddition)).toString());
            additionObject.addProperty("min", instance.minAddition);
            additionObject.addProperty("max", instance.maxAddition);
            additionObject.addProperty("chance", instance.chanceAddition);
            return object;
        }
    }
}
