package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import com.yungnickyoung.minecraft.betteroceanmonuments.services.Services;
import com.yungnickyoung.minecraft.betteroceanmonuments.world.processor.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class StructureProcessorTypeModule {
    public static StructureProcessorType<AirProcessor> AIR_PROCESSOR = () -> AirProcessor.CODEC;
    public static StructureProcessorType<WaterlogProcessor> WATERLOG_PROCESSOR = () -> WaterlogProcessor.CODEC;
    public static StructureProcessorType<RandomPrismarineSlabDecorationProcessor> RANDOM_PRISMARINE_SLAB_DECORATION_PROCESSOR = () -> RandomPrismarineSlabDecorationProcessor.CODEC;
    public static StructureProcessorType<RandomDarkPrismarineSlabDecorationProcessor> RANDOM_DARK_PRISMARINE_SLAB_DECORATION_PROCESSOR = () -> RandomDarkPrismarineSlabDecorationProcessor.CODEC;
    public static StructureProcessorType<StructureVoidProcessor> STRUCTURE_VOID_PROCESSOR = () -> StructureVoidProcessor.CODEC;
    public static StructureProcessorType<SandGravelProcessor> SAND_GRAVEL_PROCESSOR = () -> SandGravelProcessor.CODEC;
    public static StructureProcessorType<RandomOxidizationProcessor> RANDOM_OXIDIZATION_PROCESSOR = () -> RandomOxidizationProcessor.CODEC;
    public static StructureProcessorType<SeagrassProcessor> SEAGRASS_PROCESSOR = () -> SeagrassProcessor.CODEC;
    public static StructureProcessorType<RandomSpongeProcessor> SPONGE_PROCESSOR = () -> RandomSpongeProcessor.CODEC;
    public static StructureProcessorType<LegProcessor> LEG_PROCESSOR = () -> LegProcessor.CODEC;

    public static void init() {
        register("air_processor", AIR_PROCESSOR);
        register("waterlog_processor", WATERLOG_PROCESSOR);
        register("random_prismarine_slab_decoration_processor", RANDOM_PRISMARINE_SLAB_DECORATION_PROCESSOR);
        register("random_dark_prismarine_slab_decoration_processor", RANDOM_DARK_PRISMARINE_SLAB_DECORATION_PROCESSOR);
        register("structure_void_processor", STRUCTURE_VOID_PROCESSOR);
        register("sand_gravel_processor", SAND_GRAVEL_PROCESSOR);
        register("random_oxidization_processor", RANDOM_OXIDIZATION_PROCESSOR);
        register("seagrass_processor", SEAGRASS_PROCESSOR);
        register("random_sponge_processor", SPONGE_PROCESSOR);
        register("leg_processor", LEG_PROCESSOR);
    }

    private static void register(String name, StructureProcessorType<?> processorType) {
        Services.REGISTRY.registerStructureProcessorType(new ResourceLocation(BetterOceanMonumentsCommon.MOD_ID, name), processorType);
    }
}
