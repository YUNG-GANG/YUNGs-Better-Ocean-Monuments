package com.yungnickyoung.minecraft.betteroceanmonuments.world.processor;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorTypeModule;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Randomizes the oxidization level of copper blocks.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RandomOxidizationProcessor extends StructureProcessor {
    public static final RandomOxidizationProcessor INSTANCE = new RandomOxidizationProcessor();
    public static final MapCodec<RandomOxidizationProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        RandomSource random = structurePlacementData.getRandom(blockInfoGlobal.pos());
        BlockState blockState;
        if (blockInfoGlobal.state().getBlock() == Blocks.OXIDIZED_COPPER) {
            if (random.nextFloat() < 0.1f) blockState = Blocks.EXPOSED_COPPER.defaultBlockState();
            else if (random.nextFloat() < 0.3f) blockState = Blocks.WEATHERED_COPPER.defaultBlockState();
            else blockState = Blocks.OXIDIZED_COPPER.defaultBlockState();
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), blockState, blockInfoGlobal.nbt());
        } else if (blockInfoGlobal.state().getBlock() == Blocks.OXIDIZED_CUT_COPPER) {
            if (random.nextFloat() < 0.1f) blockState = Blocks.EXPOSED_CUT_COPPER.defaultBlockState();
            else if (random.nextFloat() < 0.3f) blockState = Blocks.WEATHERED_CUT_COPPER.defaultBlockState();
            else blockState = Blocks.OXIDIZED_CUT_COPPER.defaultBlockState();
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), blockState, blockInfoGlobal.nbt());
        } else if (blockInfoGlobal.state().getBlock() == Blocks.OXIDIZED_CUT_COPPER_STAIRS) {
            if (random.nextFloat() < 0.1f) blockState = Blocks.EXPOSED_CUT_COPPER_STAIRS.withPropertiesOf(blockInfoGlobal.state());
            else if (random.nextFloat() < 0.3f) blockState = Blocks.WEATHERED_CUT_COPPER_STAIRS.withPropertiesOf(blockInfoGlobal.state());
            else blockState = Blocks.OXIDIZED_CUT_COPPER_STAIRS.withPropertiesOf(blockInfoGlobal.state());
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), blockState, blockInfoGlobal.nbt());
        } else if (blockInfoGlobal.state().getBlock() == Blocks.OXIDIZED_CUT_COPPER_SLAB) {
            if (random.nextFloat() < 0.1f) blockState = Blocks.EXPOSED_CUT_COPPER_SLAB.withPropertiesOf(blockInfoGlobal.state());
            else if (random.nextFloat() < 0.3f) blockState = Blocks.WEATHERED_CUT_COPPER_SLAB.withPropertiesOf(blockInfoGlobal.state());
            else blockState = Blocks.OXIDIZED_CUT_COPPER_SLAB.withPropertiesOf(blockInfoGlobal.state());
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), blockState, blockInfoGlobal.nbt());
        }
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorTypeModule.RANDOM_OXIDIZATION_PROCESSOR;
    }
}