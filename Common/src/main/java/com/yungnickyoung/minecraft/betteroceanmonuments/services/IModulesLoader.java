package com.yungnickyoung.minecraft.betteroceanmonuments.services;

import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorTypeModule;

public interface IModulesLoader {
    default void loadModules() {
        StructureProcessorTypeModule.init();
    }
}
