package com.yungnickyoung.minecraft.betteroceanmonuments.services;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public interface IRegistryHelper {
    void registerStructureProcessorType(ResourceLocation resourceLocation, StructureProcessorType<? extends StructureProcessor> structureProcessorType);
}
