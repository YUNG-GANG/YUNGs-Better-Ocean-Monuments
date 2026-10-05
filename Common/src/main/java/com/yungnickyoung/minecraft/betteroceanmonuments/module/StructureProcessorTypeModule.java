package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import com.yungnickyoung.minecraft.betteroceanmonuments.world.processor.*;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;

@AutoRegister(BetterOceanMonumentsCommon.MOD_ID)
public class StructureProcessorTypeModule {
    @AutoRegister("air_processor")
    public static MapCodec<AirProcessor> AIR_PROCESSOR = AirProcessor.CODEC;

    @AutoRegister("waterlog_processor")
    public static MapCodec<WaterlogProcessor> WATERLOG_PROCESSOR = WaterlogProcessor.CODEC;

    @AutoRegister("random_prismarine_slab_decoration_processor")
    public static MapCodec<RandomPrismarineSlabDecorationProcessor> RANDOM_PRISMARINE_SLAB_DECORATION_PROCESSOR = RandomPrismarineSlabDecorationProcessor.CODEC;

    @AutoRegister("random_dark_prismarine_slab_decoration_processor")
    public static MapCodec<RandomDarkPrismarineSlabDecorationProcessor> RANDOM_DARK_PRISMARINE_SLAB_DECORATION_PROCESSOR = RandomDarkPrismarineSlabDecorationProcessor.CODEC;

    @AutoRegister("structure_void_processor")
    public static MapCodec<StructureVoidProcessor> STRUCTURE_VOID_PROCESSOR = StructureVoidProcessor.CODEC;

    @AutoRegister("sand_gravel_processor")
    public static MapCodec<SandGravelProcessor> SAND_GRAVEL_PROCESSOR = SandGravelProcessor.CODEC;

    @AutoRegister("random_oxidization_processor")
    public static MapCodec<RandomOxidizationProcessor> RANDOM_OXIDIZATION_PROCESSOR = RandomOxidizationProcessor.CODEC;

    @AutoRegister("seagrass_processor")
    public static MapCodec<SeagrassProcessor> SEAGRASS_PROCESSOR = SeagrassProcessor.CODEC;

    @AutoRegister("random_sponge_processor")
    public static MapCodec<RandomSpongeProcessor> SPONGE_PROCESSOR = RandomSpongeProcessor.CODEC;

    @AutoRegister("leg_processor")
    public static MapCodec<LegProcessor> LEG_PROCESSOR = LegProcessor.CODEC;
}
