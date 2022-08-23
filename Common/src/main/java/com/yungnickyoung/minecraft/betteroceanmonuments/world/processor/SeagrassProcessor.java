package com.yungnickyoung.minecraft.betteroceanmonuments.world.processor;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorTypeModule;
import com.yungnickyoung.minecraft.yungsapi.world.processor.ISafeWorldModifier;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Replaces various slab placeholder blocks with seagrass.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SeagrassProcessor extends StructureProcessor implements ISafeWorldModifier {
    public static final SeagrassProcessor INSTANCE = new SeagrassProcessor();
    public static final Codec<SeagrassProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state.is(Blocks.RED_SANDSTONE_SLAB)) {
            return new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, Blocks.TALL_SEAGRASS.defaultBlockState().setValue(TallSeagrassBlock.HALF, DoubleBlockHalf.LOWER), null);
        }
        if (blockInfoGlobal.state.is(Blocks.END_STONE_BRICK_SLAB)) {
            return new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, Blocks.TALL_SEAGRASS.defaultBlockState().setValue(TallSeagrassBlock.HALF, DoubleBlockHalf.UPPER), null);
        }
        if (blockInfoGlobal.state.is(Blocks.BRICK_SLAB)) {
            return new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, Blocks.SEAGRASS.defaultBlockState(), null);
        }

        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorTypeModule.SEAGRASS_PROCESSOR;
    }
}