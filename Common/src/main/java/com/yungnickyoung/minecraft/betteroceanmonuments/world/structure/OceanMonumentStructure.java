package com.yungnickyoung.minecraft.betteroceanmonuments.world.structure;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import com.yungnickyoung.minecraft.yungsapi.api.YungJigsawConfig;
import com.yungnickyoung.minecraft.yungsapi.api.YungJigsawManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;

import java.util.Optional;

public class OceanMonumentStructure extends StructureFeature<YungJigsawConfig> {
    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    public OceanMonumentStructure() {
        super(YungJigsawConfig.CODEC, context -> {
            // Random
            WorldgenRandom worldgenRandom = new WorldgenRandom(new LegacyRandomSource(0L));
            worldgenRandom.setLargeFeatureSeed(context.seed(), context.chunkPos().x, context.chunkPos().z);

            // Determine start pos
            int minY = BetterOceanMonumentsCommon.CONFIG.general.startMinY;
            int maxY = BetterOceanMonumentsCommon.CONFIG.general.startMaxY;
            int y = Mth.randomBetweenInclusive(worldgenRandom, minY, maxY);
            BlockPos startPos = new BlockPos(context.chunkPos().getMiddleBlockX(), y, context.chunkPos().getMiddleBlockZ());

            // Only generate if location is valid
            if (!checkLocation(context)) {
                return Optional.empty();
            }

            return YungJigsawManager.assembleJigsawStructure(
                    context,
                    PoolElementStructurePiece::new,
                    startPos,
                    false,
                    false,
                    80);
        });
    }

    private static boolean checkLocation(PieceGeneratorSupplier.Context<YungJigsawConfig> context) {
        int x = context.chunkPos().getBlockX(9);
        int z = context.chunkPos().getBlockZ(9);

        for (Holder<Biome> holder : context.biomeSource().getBiomesWithin(x, context.chunkGenerator().getSeaLevel(), z, 29, context.chunkGenerator().climateSampler())) {
            if (!holder.is(BiomeTags.IS_OCEAN) &&!holder.is(BiomeTags.IS_RIVER)) {
                return false;
            }
        }

        return context.validBiomeOnTop(Heightmap.Types.OCEAN_FLOOR_WG);
    }
}
