package com.yungnickyoung.minecraft.betteroceanmonuments;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(BetterOceanMonumentsCommon.MOD_ID)
public class BetterOceanMonumentsNeoForge {
    public static IEventBus loadingContextEventBus;

    public BetterOceanMonumentsNeoForge(IEventBus eventBus) {
        BetterOceanMonumentsNeoForge.loadingContextEventBus = eventBus;

        BetterOceanMonumentsCommon.init();
    }
}