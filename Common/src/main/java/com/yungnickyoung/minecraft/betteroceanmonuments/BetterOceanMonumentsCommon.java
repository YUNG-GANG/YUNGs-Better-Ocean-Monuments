package com.yungnickyoung.minecraft.betteroceanmonuments;

import com.yungnickyoung.minecraft.betteroceanmonuments.module.ConfigModule;
import com.yungnickyoung.minecraft.betteroceanmonuments.services.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BetterOceanMonumentsCommon {
    public static final String MOD_ID = "betteroceanmonuments";
    public static final String MOD_NAME = "YUNG's Better Ocean Monuments";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ConfigModule CONFIG = new ConfigModule();

    public static void init() {
        Services.MODULES.loadModules();
    }
}
