package com.yungnickyoung.minecraft.betteroceanmonuments;

import net.fabricmc.api.ModInitializer;

public class BetterOceanMonumentsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BetterOceanMonumentsCommon.init();
    }
}
