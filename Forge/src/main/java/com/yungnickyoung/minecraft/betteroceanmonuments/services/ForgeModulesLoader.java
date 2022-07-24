package com.yungnickyoung.minecraft.betteroceanmonuments.services;

import com.yungnickyoung.minecraft.betteroceanmonuments.module.*;

public class ForgeModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        ConfigModuleForge.init();
        StructureProcessorModuleForge.init();
        StructureFeatureModuleForge.init();
    }
}
