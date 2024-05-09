package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsNeoForge;
import com.yungnickyoung.minecraft.betteroceanmonuments.config.BOMConfigForge;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.LevelEvent;

public class ConfigModuleNeoForge {
    public static void init() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BOMConfigForge.SPEC, "betteroceanmonuments-neoforge-1_20_4.toml");
        NeoForge.EVENT_BUS.addListener(ConfigModuleNeoForge::onWorldLoad);
        BetterOceanMonumentsNeoForge.loadingContextEventBus.addListener(ConfigModuleNeoForge::onConfigChange);
    }

    private static void onWorldLoad(LevelEvent.Load event) {
        bakeConfig();
    }

    private static void onConfigChange(ModConfigEvent event) {
        if (event.getConfig().getSpec() == BOMConfigForge.SPEC) {
            bakeConfig();
        }
    }

    private static void bakeConfig() {
        BetterOceanMonumentsCommon.CONFIG.general.disableVanillaMonuments = BOMConfigForge.general.disableVanillaMonuments.get();
    }
}
