package com.yungnickyoung.minecraft.betteroceanmonuments.world.processor;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.betteroceanmonuments.module.StructureProcessorTypeModule;
import com.yungnickyoung.minecraft.yungsapi.world.structure.processor.ISafeWorldModifier;
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
 * Randomly replaces orange stained glass with sponge.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RandomSpongeProcessor extends StructureProcessor implements ISafeWorldModifier {
    public static final RandomSpongeProcessor INSTANCE = new RandomSpongeProcessor();
    public static final Codec<RandomSpongeProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state.is(Blocks.ORANGE_STAINED_GLASS)) {
            if (structurePlacementData.getRandom(blockInfoGlobal.pos).nextFloat() < 0.75f) {
                return new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, Blocks.WET_SPONGE.defaultBlockState(), null);
            } else {
                return new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, Blocks.WATER.defaultBlockState(), null);
            }
        }

        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorTypeModule.SPONGE_PROCESSOR;
    }
}