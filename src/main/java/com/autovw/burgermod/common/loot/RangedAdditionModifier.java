package com.autovw.burgermod.common.loot;

import com.google.gson.JsonObject;
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

import java.util.List;
import java.util.Objects;

/**
 * Author: Autovw
 */
public class RangedAdditionModifier extends LootModifier {
    private final Item itemAddition;
    private final int minAddition, maxAddition;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public RangedAdditionModifier(LootItemCondition[] conditionsIn, Item itemAddition, int minAddition, int maxAddition) {
        super(conditionsIn);
        this.itemAddition = itemAddition;
        this.minAddition = minAddition;
        this.maxAddition = maxAddition;
    }

    @NotNull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (maxAddition >= minAddition) {
            generatedLoot.add(new ItemStack(itemAddition, context.getRandom().ints(minAddition, maxAddition + 1).iterator().nextInt()));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<RangedAdditionModifier> {

        @Override
        public RangedAdditionModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
            Item itemAddition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "item_addition")));
            int minAddition = GsonHelper.getAsInt(object, "min_addition");
            int maxAddition = GsonHelper.getAsInt(object, "max_addition");
            return new RangedAdditionModifier(ailootcondition, itemAddition, minAddition, maxAddition);
        }

        @Override
        public JsonObject write(RangedAdditionModifier instance) {
            JsonObject object = makeConditions(instance.conditions);
            object.addProperty("item_addition", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(instance.itemAddition)).toString());
            object.addProperty("min_addition", instance.minAddition);
            object.addProperty("max_addition", instance.maxAddition);
            return object;
        }
    }
}