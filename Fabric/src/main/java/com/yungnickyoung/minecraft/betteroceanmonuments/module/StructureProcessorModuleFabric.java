package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class StructureProcessorModuleFabric {
    public static void init() {
    }

    private static <P extends StructureProcessor> StructureProcessorType<P> register(String name, StructureProcessorType<P> processorType) {
        return  Registry.register(Registry.STRUCTURE_PROCESSOR, new ResourceLocation(BetterOceanMonumentsCommon.MOD_ID, name), processorType);
    }
}
