package com.yungnickyoung.minecraft.betteroceanmonuments.world.processor;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorTypeModule;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;



/**
 * Replaces certain placeholder blocks with block that currently exists in the world.
 * Ultimately has the same function as structure void, but makes it easy to visualize
 * how the structure blends into terrain when building.
 */


public class StructureVoidProcessor implements StructureProcessor {
    public static final StructureVoidProcessor INSTANCE = new StructureVoidProcessor();
    public static final MapCodec<StructureVoidProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             BlockPos templateRelativePos,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state().is(Blocks.PURPUR_SLAB) || blockInfoGlobal.state().is(Blocks.WOOL.brown())) {
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), levelReader.getBlockState(blockInfoGlobal.pos()), blockInfoGlobal.nbt());
        }
        return blockInfoGlobal;
    }

    public MapCodec<? extends StructureProcessor> codec() {
        return StructureProcessorTypeModule.STRUCTURE_VOID_PROCESSOR;
    }
}