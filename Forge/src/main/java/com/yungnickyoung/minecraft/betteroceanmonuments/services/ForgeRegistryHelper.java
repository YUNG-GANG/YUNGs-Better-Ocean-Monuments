package com.yungnickyoung.minecraft.betteroceanmonuments.services;

import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorTypeModuleForge;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class ForgeRegistryHelper implements IRegistryHelper {
    @Override
    public void registerStructureProcessorType(ResourceLocation resourceLocation, StructureProcessorType<? extends StructureProcessor> structureProcessorType) {
        StructureProcessorTypeModuleForge.STRUCTURE_PROCESSOR_TYPES.put(resourceLocation, structureProcessorType);
    }
}
