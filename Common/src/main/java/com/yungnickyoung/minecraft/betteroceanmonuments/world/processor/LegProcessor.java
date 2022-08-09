package com.yungnickyoung.minecraft.betteroceanmonuments.world.processor;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorModule;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Replaces blue stained-glass with dynamically generated legs below the monument.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LegProcessor extends StructureProcessor {
    public static final LegProcessor INSTANCE = new LegProcessor();
    public static final Codec<LegProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state.getBlock() == Blocks.BLUE_STAINED_GLASS) {
            if (levelReader instanceof WorldGenRegion worldGenRegion && !worldGenRegion.getCenter().equals(new ChunkPos(blockInfoGlobal.pos))) {
                return blockInfoGlobal;
            }

            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, Blocks.PRISMARINE_BRICKS.defaultBlockState(), blockInfoGlobal.nbt);
            BlockPos.MutableBlockPos mutable = blockInfoGlobal.pos.mutable().move(Direction.DOWN);
            BlockState currBlockState = levelReader.getBlockState(mutable);

            while (mutable.getY() > levelReader.getMinBuildHeight()
                    && mutable.getY() < levelReader.getMaxBuildHeight()
                    && (currBlockState.isAir() || !levelReader.getFluidState(mutable).isEmpty())) {
                levelReader.getChunk(mutable).setBlockState(mutable, Blocks.PRISMARINE_BRICKS.defaultBlockState(), false);
                mutable.move(Direction.DOWN);
                currBlockState = levelReader.getBlockState(mutable);
            }
        }
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorModule.LEG_PROCESSOR;
    }
}
