package com.autovw.burgermod.neoforge.client;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

/**
 * @author Autovw
 */
public class ClientHandler
{
    public static void onClientSetup()
    {
        // Only registers the config screen if configured is not present
        if (!ModList.get().isLoaded("configured"))
        {
            ModContainer container = ModLoadingContext.get().getActiveContainer();
            container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }
    }
}
