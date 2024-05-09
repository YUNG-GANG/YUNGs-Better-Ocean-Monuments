package com.yungnickyoung.minecraft.betteroceanmonuments.services;

import com.yungnickyoung.minecraft.betteroceanmonuments.module.*;

public class NeoForgeModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        IModulesLoader.super.loadModules(); // Load common modules
        ConfigModuleNeoForge.init();
    }
}
