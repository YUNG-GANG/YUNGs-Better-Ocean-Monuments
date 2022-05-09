package com.yungnickyoung.minecraft.betteroceanmonuments.world.processor;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorModule;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Replaces brown wool with block that currently exists in the world.
 * Ultimately has the same function as structure void, but makes it easy to visualize
 * how the structure blends into terrain when building.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BrownWoolProcessor extends StructureProcessor {
    public static final BrownWoolProcessor INSTANCE = new BrownWoolProcessor();
    public static final Codec<BrownWoolProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state.getBlock() == Blocks.BROWN_WOOL) {
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, levelReader.getBlockState(blockInfoGlobal.pos), blockInfoGlobal.nbt);
        }
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorModule.BROWN_WOOL_PROCESSOR;
    }
}