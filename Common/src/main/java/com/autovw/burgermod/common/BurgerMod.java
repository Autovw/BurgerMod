package com.autovw.burgermod.common;

import com.autovw.burgermod.common.platform.IPlatformHelper;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

/**
 * @author Autovw
 */
public class BurgerMod
{
    public static final String MOD_ID = "burgermod";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static IPlatformHelper platformHelper;

    private BurgerMod()
    {
    }

    public static void init(IPlatformHelper platformHelper)
    {
        LOGGER.info("Initializing platform helper for Burger Mod!");
        BurgerMod.platformHelper = platformHelper;
    }

    /**
     * @return Instance of platform helper, based on used mod loader
     */
    public static IPlatformHelper getPlatformHelper()
    {
        return BurgerMod.platformHelper;
    }
}
