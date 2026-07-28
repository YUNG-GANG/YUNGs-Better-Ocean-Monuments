package com.yungnickyoung.minecraft.betteroceanmonuments.world.processor;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.yungsapi.world.structure.processor.ISafeWorldModifier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;



/**
 * Randomly replaces orange stained glass with sponge.
 */


public class RandomSpongeProcessor implements StructureProcessor, ISafeWorldModifier {
    public static final RandomSpongeProcessor INSTANCE = new RandomSpongeProcessor();
    public static final MapCodec<RandomSpongeProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             BlockPos blockPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state().is(Blocks.STAINED_GLASS.pick(DyeColor.ORANGE))) {
            if (structurePlacementData.getRandom(blockInfoGlobal.pos()).nextFloat() < 0.75f) {
                return new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), Blocks.WET_SPONGE.defaultBlockState(), null);
            } else {
                return new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), Blocks.WATER.defaultBlockState(), null);
            }
        }

        return blockInfoGlobal;
    }

    @Override
    public MapCodec<? extends StructureProcessor> codec() {
        return CODEC;
    }
}