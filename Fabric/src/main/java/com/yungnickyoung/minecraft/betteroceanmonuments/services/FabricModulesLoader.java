package com.yungnickyoung.minecraft.betteroceanmonuments.services;

import com.yungnickyoung.minecraft.betteroceanmonuments.module.*;

public class FabricModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        IModulesLoader.super.loadModules(); // Load common modules
        ConfigModuleFabric.init();
    }
}
