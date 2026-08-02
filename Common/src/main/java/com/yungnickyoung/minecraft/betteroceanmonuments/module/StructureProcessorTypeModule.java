package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import com.yungnickyoung.minecraft.betteroceanmonuments.world.processor.*;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

@AutoRegister(BetterOceanMonumentsCommon.MOD_ID)
public class StructureProcessorTypeModule {
    @AutoRegister("air_processor")
    public static MapCodec<? extends StructureProcessor> AIR_PROCESSOR = AirProcessor.CODEC;

    @AutoRegister("waterlog_processor")
    public static MapCodec<? extends StructureProcessor> WATERLOG_PROCESSOR = WaterlogProcessor.CODEC;

    @AutoRegister("random_prismarine_slab_decoration_processor")
    public static MapCodec<? extends StructureProcessor> RANDOM_PRISMARINE_SLAB_DECORATION_PROCESSOR = RandomPrismarineSlabDecorationProcessor.CODEC;

    @AutoRegister("random_dark_prismarine_slab_decoration_processor")
    public static MapCodec<? extends StructureProcessor> RANDOM_DARK_PRISMARINE_SLAB_DECORATION_PROCESSOR = RandomDarkPrismarineSlabDecorationProcessor.CODEC;

    @AutoRegister("structure_void_processor")
    public static MapCodec<? extends StructureProcessor> STRUCTURE_VOID_PROCESSOR = StructureVoidProcessor.CODEC;

    @AutoRegister("sand_gravel_processor")
    public static MapCodec<? extends StructureProcessor> SAND_GRAVEL_PROCESSOR = SandGravelProcessor.CODEC;

    @AutoRegister("random_oxidization_processor")
    public static MapCodec<? extends StructureProcessor> RANDOM_OXIDIZATION_PROCESSOR = RandomOxidizationProcessor.CODEC;

    @AutoRegister("seagrass_processor")
    public static MapCodec<? extends StructureProcessor> SEAGRASS_PROCESSOR = SeagrassProcessor.CODEC;

    @AutoRegister("random_sponge_processor")
    public static MapCodec<? extends StructureProcessor> SPONGE_PROCESSOR = RandomSpongeProcessor.CODEC;

    @AutoRegister("leg_processor")
    public static MapCodec<? extends StructureProcessor> LEG_PROCESSOR = LegProcessor.CODEC;
}
