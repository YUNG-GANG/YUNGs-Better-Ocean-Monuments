package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.world.processor.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class StructureProcessorModule {
    public static StructureProcessorType<AirProcessor> AIR_PROCESSOR = () -> AirProcessor.CODEC;
    public static StructureProcessorType<WaterlogProcessor> WATERLOG_PROCESSOR = () -> WaterlogProcessor.CODEC;
    public static StructureProcessorType<RandomPrismarineSlabDecorationProcessor> RANDOM_PRISMARINE_SLAB_DECORATION_PROCESSOR = () -> RandomPrismarineSlabDecorationProcessor.CODEC;
    public static StructureProcessorType<RandomDarkPrismarineSlabDecorationProcessor> RANDOM_DARK_PRISMARINE_SLAB_DECORATION_PROCESSOR = () -> RandomDarkPrismarineSlabDecorationProcessor.CODEC;
    public static StructureProcessorType<BrownWoolProcessor> BROWN_WOOL_PROCESSOR = () -> BrownWoolProcessor.CODEC;
    public static StructureProcessorType<SandGravelProcessor> SAND_GRAVEL_PROCESSOR = () -> SandGravelProcessor.CODEC;
    public static StructureProcessorType<RandomOxidizationProcessor> RANDOM_OXIDIZATION_PROCESSOR = () -> RandomOxidizationProcessor.CODEC;
}
