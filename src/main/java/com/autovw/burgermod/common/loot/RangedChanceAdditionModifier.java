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
 * @deprecated use {@link LootAdditionModifier}
 */
// TODO remove in 1.19.1
@Deprecated(since = "2.8.0", forRemoval = true)
public class RangedChanceAdditionModifier extends LootModifier {
    private final Item itemAddition;
    private final int minAddition, maxAddition;
    private final float chanceAddition;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public RangedChanceAdditionModifier(LootItemCondition[] conditionsIn, Item itemAddition, int minAddition, int maxAddition, float chanceAddition) {
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

    public static class Serializer extends GlobalLootModifierSerializer<RangedChanceAdditionModifier> {

        @Override
        public RangedChanceAdditionModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
            Item itemAddition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "item_addition")));
            int minAddition = GsonHelper.getAsInt(object, "min_addition");
            int maxAddition = GsonHelper.getAsInt(object, "max_addition");
            float chanceAddition = GsonHelper.getAsFloat(object, "chance_addition");
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
