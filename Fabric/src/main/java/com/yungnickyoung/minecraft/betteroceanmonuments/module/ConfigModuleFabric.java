package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.config.BOMConfigFabric;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraft.world.InteractionResult;

public class ConfigModuleFabric {
    public static final String CUSTOM_CONFIG_PATH = "betteroceanmonuments";
    public static final String VERSION_PATH = "fabric-1_18_2";

    public static void init() {
        AutoConfig.register(BOMConfigFabric.class, Toml4jConfigSerializer::new);
        AutoConfig.getConfigHolder(BOMConfigFabric.class).registerSaveListener(ConfigModuleFabric::bakeConfig);
        AutoConfig.getConfigHolder(BOMConfigFabric.class).registerLoadListener(ConfigModuleFabric::bakeConfig);
        bakeConfig(AutoConfig.getConfigHolder(BOMConfigFabric.class).get());
    }

    private static InteractionResult bakeConfig(ConfigHolder<BOMConfigFabric> configHolder, BOMConfigFabric configFabric) {
        bakeConfig(configFabric);
        return InteractionResult.SUCCESS;
    }

    private static void bakeConfig(BOMConfigFabric configFabric) {
    }
}
