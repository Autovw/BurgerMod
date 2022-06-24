package com.autovw.burgermod;

import com.autovw.burgermod.common.loot.RangedAdditionModifier;
import com.autovw.burgermod.common.loot.RangedChanceAdditionModifier;
import com.autovw.burgermod.config.Config;
import com.autovw.burgermod.core.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Author: Autovw
 */
@Mod(BurgerMod.MOD_ID)
public class BurgerMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "burgermod";
    public static final ItemGroup TAB_BURGERMOD = new BurgerGroup(MOD_ID + ".tab");

    public BurgerMod() {
        // Used to register the common config.
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.commonConfig);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        bus.addGenericListener(GlobalLootModifierSerializer.class, this::modifierSerializers);

        // Used to register the ModItems class and everything inside of it.
        ModItems.ITEMS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    /**
     * Registry for loot modifier serializers
     */
    private void modifierSerializers(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
                new RangedAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/village/village_plains_house/fries_addition")),
                new RangedAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/village/village_snowy_house/hotdog_addition")),
                new RangedAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/village/village_butcher/cooked_chicken_nugget_addition")),
                new RangedAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/village/village_fisher/cod_burger_addition")),
                new RangedAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/village/village_fisher/salmon_burger_addition")),
                new RangedAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/igloo_chest/pork_cheese_burger_addition")),
                new RangedAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/simple_dungeon/scrambled_egg_addition")),
                new RangedAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/woodland_mansion/cooked_champignons_addition")),
                new RangedAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/woodland_mansion/mutton_champignon_burger_addition")),
                new RangedChanceAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/simple_dungeon/golden_beef_burger_addition")),
                new RangedChanceAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/desert_pyramid/golden_mutton_burger_addition")),
                new RangedChanceAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/ruined_portal/golden_pork_burger_addition")),
                new RangedChanceAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/bastion_other/golden_salmon_burger_addition")),
                new RangedChanceAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/bastion_hoglin_stable/golden_chicken_burger_addition")),
                new RangedChanceAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/bastion_treasure/golden_pork_burger_addition")),
                new RangedChanceAdditionModifier.Serializer().setRegistryName(new ResourceLocation(MOD_ID, "chests/bastion_treasure/enchanted_golden_burger_addition")));
    }
}
