package com.autovw.burgermod.neoforge.datagen.providers;

import com.autovw.burgermod.common.datagen.ModDataGenHelper;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.registries.SingleRegistryBootstrap;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.data.worldgen.BootstrapContext;

import java.util.List;

/**
 * @author Autovw
 */
public class ModAdvancementProvider extends AdvancementProvider
{
    public ModAdvancementProvider(List<AdvancementSubProvider.Factory> subProviders)
    {
        super(subProviders);
    }

    public static SingleRegistryBootstrap<Advancement> create()
    {
        return new AdvancementProvider(List.of(ModHusbandryAdvancements::new));
    }

    public static class ModHusbandryAdvancements extends AdvancementSubProvider
    {
        public ModHusbandryAdvancements(BootstrapContext<Advancement> output)
        {
            super(output);
        }

        @Override
        public void generate()
        {
            ModDataGenHelper.advancements(this.output);
        }
    }
}
