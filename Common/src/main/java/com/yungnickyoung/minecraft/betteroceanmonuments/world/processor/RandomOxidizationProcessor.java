package com.yungnickyoung.minecraft.betteroceanmonuments.world.processor;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorTypeModule;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;



/**
 * Randomizes the oxidization level of copper blocks.
 */


public class RandomOxidizationProcessor implements StructureProcessor {
    public static final RandomOxidizationProcessor INSTANCE = new RandomOxidizationProcessor();
    public static final MapCodec<RandomOxidizationProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             BlockPos templateRelativePos,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        RandomSource random = structurePlacementData.getRandom(blockInfoGlobal.pos());
        BlockState blockState;
        if (blockInfoGlobal.state().getBlock() == Blocks.COPPER_BLOCK.weathering().oxidized()) {
            if (random.nextFloat() < 0.1f) blockState = Blocks.COPPER_BLOCK.weathering().exposed().defaultBlockState();
            else if (random.nextFloat() < 0.3f) blockState = Blocks.COPPER_BLOCK.weathering().weathered().defaultBlockState();
            else blockState = Blocks.COPPER_BLOCK.weathering().oxidized().defaultBlockState();
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), blockState, blockInfoGlobal.nbt());
        } else if (blockInfoGlobal.state().getBlock() == Blocks.CUT_COPPER.weathering().oxidized()) {
            if (random.nextFloat() < 0.1f) blockState = Blocks.CUT_COPPER.weathering().exposed().defaultBlockState();
            else if (random.nextFloat() < 0.3f) blockState = Blocks.CUT_COPPER.weathering().weathered().defaultBlockState();
            else blockState = Blocks.CUT_COPPER.weathering().oxidized().defaultBlockState();
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), blockState, blockInfoGlobal.nbt());
        } else if (blockInfoGlobal.state().getBlock() == Blocks.CUT_COPPER_STAIRS.weathering().oxidized()) {
            if (random.nextFloat() < 0.1f) blockState = Blocks.CUT_COPPER_STAIRS.weathering().exposed().withPropertiesOf(blockInfoGlobal.state());
            else if (random.nextFloat() < 0.3f) blockState = Blocks.CUT_COPPER_STAIRS.weathering().weathered().withPropertiesOf(blockInfoGlobal.state());
            else blockState = Blocks.CUT_COPPER_STAIRS.weathering().oxidized().withPropertiesOf(blockInfoGlobal.state());
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), blockState, blockInfoGlobal.nbt());
        } else if (blockInfoGlobal.state().getBlock() == Blocks.CUT_COPPER_SLAB.weathering().oxidized()) {
            if (random.nextFloat() < 0.1f) blockState = Blocks.CUT_COPPER_SLAB.weathering().exposed().withPropertiesOf(blockInfoGlobal.state());
            else if (random.nextFloat() < 0.3f) blockState = Blocks.CUT_COPPER_SLAB.weathering().weathered().withPropertiesOf(blockInfoGlobal.state());
            else blockState = Blocks.CUT_COPPER_SLAB.weathering().oxidized().withPropertiesOf(blockInfoGlobal.state());
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), blockState, blockInfoGlobal.nbt());
        }
        return blockInfoGlobal;
    }

    public MapCodec<? extends StructureProcessor> codec() {
        return StructureProcessorTypeModule.RANDOM_OXIDIZATION_PROCESSOR;
    }
}
