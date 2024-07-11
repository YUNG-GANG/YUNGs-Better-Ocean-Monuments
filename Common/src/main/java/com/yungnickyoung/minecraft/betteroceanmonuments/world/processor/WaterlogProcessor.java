package com.yungnickyoung.minecraft.betteroceanmonuments.world.processor;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorTypeModule;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Waterlogs all waterloggable blocks.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WaterlogProcessor extends StructureProcessor {
    public static final WaterlogProcessor INSTANCE = new WaterlogProcessor();
    public static final MapCodec<WaterlogProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        // Schedule fluid ticks for water blocks along chunk boundaries
        if (blockInfoGlobal.state().liquid() && blockInfoGlobal.pos().getY() < levelReader.getSeaLevel()) {
            if (levelReader instanceof WorldGenRegion worldGenRegion && worldGenRegion.getCenter().equals(new ChunkPos(blockInfoGlobal.pos()))) {
                if (blockInfoGlobal.pos().getX() % 16 == 0 || blockInfoGlobal.pos().getX() % 16 == 15 || blockInfoGlobal.pos().getZ() % 16 == 0 || blockInfoGlobal.pos().getZ() % 16 == 15) {
                    levelReader.getChunk(blockInfoGlobal.pos()).markPosForPostprocessing(blockInfoGlobal.pos());
                }
            }
        }

        // Waterlog blocks
        if (blockInfoGlobal.state().hasProperty(BlockStateProperties.WATERLOGGED) && blockInfoGlobal.pos().getY() < levelReader.getSeaLevel()) {
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(
                    blockInfoGlobal.pos(),
                    blockInfoGlobal.state().setValue(BlockStateProperties.WATERLOGGED, true),
                    blockInfoGlobal.nbt());
        }
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorTypeModule.WATERLOG_PROCESSOR;
    }
}
