package com.yungnickyoung.minecraft.betteroceanmonuments.world.processor;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorModule;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

/**
 * Randomly replaces lime concrete with top or bottom prismarine slab.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RandomPrismarineSlabDecorationProcessor extends StructureProcessor {
    public static final RandomPrismarineSlabDecorationProcessor INSTANCE = new RandomPrismarineSlabDecorationProcessor();
    public static final Codec<RandomPrismarineSlabDecorationProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state.getBlock() == Blocks.LIME_CONCRETE) {
            Random random = structurePlacementData.getRandom(blockInfoGlobal.pos);
            BlockState blockState;
            if (random.nextFloat() < .4f) {
                blockState = Blocks.PRISMARINE_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP).setValue(SlabBlock.WATERLOGGED, true);
            } else if (random.nextFloat() < 0.8f) {
                blockState = Blocks.PRISMARINE_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM).setValue(SlabBlock.WATERLOGGED, true);
            } else {
                blockState = Blocks.AIR.defaultBlockState();
            }
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, blockState, blockInfoGlobal.nbt);
        }
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorModule.RANDOM_PRISMARINE_SLAB_DECORATION_PROCESSOR;
    }
}
