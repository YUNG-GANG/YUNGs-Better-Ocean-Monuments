package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class StructureProcessorModuleFabric {
    public static void init() {
        register("air_processor", StructureProcessorModule.AIR_PROCESSOR);
        register("waterlog_processor", StructureProcessorModule.WATERLOG_PROCESSOR);
        register("random_prismarine_slab_decoration_processor", StructureProcessorModule.RANDOM_PRISMARINE_SLAB_DECORATION_PROCESSOR);
        register("random_dark_prismarine_slab_decoration_processor", StructureProcessorModule.RANDOM_DARK_PRISMARINE_SLAB_DECORATION_PROCESSOR);
        register("structure_void_processor", StructureProcessorModule.STRUCTURE_VOID_PROCESSOR);
        register("sand_gravel_processor", StructureProcessorModule.SAND_GRAVEL_PROCESSOR);
        register("random_oxidization_processor", StructureProcessorModule.RANDOM_OXIDIZATION_PROCESSOR);
        register("seagrass_processor", StructureProcessorModule.SEAGRASS_PROCESSOR);
    }

    private static <P extends StructureProcessor> StructureProcessorType<P> register(String name, StructureProcessorType<P> processorType) {
        return  Registry.register(Registry.STRUCTURE_PROCESSOR, new ResourceLocation(BetterOceanMonumentsCommon.MOD_ID, name), processorType);
    }
}
