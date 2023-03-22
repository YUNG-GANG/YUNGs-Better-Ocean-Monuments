package com.yungnickyoung.minecraft.betteroceanmonuments.mixin;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import com.yungnickyoung.minecraft.betteroceanmonuments.mixin.accessor.WorldGenRegionAccessor;
import com.yungnickyoung.minecraft.betteroceanmonuments.util.MixinUtil;
import net.minecraft.core.Registry;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.UnderwaterMagmaFeature;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(UnderwaterMagmaFeature.class)
public class NoMagmaInStructuresMixin {
    @Inject(
            method = "place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void betteroceanmonuments_noMagmaInStructures(FeaturePlaceContext<DeltaFeatureConfiguration> context, CallbackInfoReturnable<Boolean> cir) {
        if (!(context.level() instanceof WorldGenRegion)) {
            return;
        }

        SectionPos sectionPos = SectionPos.of(context.origin());
        if (context.level().getChunk(sectionPos.x(), sectionPos.z(), ChunkStatus.STRUCTURE_REFERENCES, false) == null) {
            BetterOceanMonumentsCommon.LOGGER.warn("Detected a mod with a broken magma configuredfeature that is trying to place blocks outside the 3x3 safe chunk area for features. Find the broken mod and report to them to fix the placement of their magma feature.");
            return;
        }

        Registry<Structure> configuredStructureFeatureRegistry = context.level().registryAccess().registryOrThrow(Registries.STRUCTURE);
        StructureManager structureManager = ((WorldGenRegionAccessor) context.level()).getStructureManager();
        Structure monumentStructure = configuredStructureFeatureRegistry.get(new ResourceLocation(BetterOceanMonumentsCommon.MOD_ID, "ocean_monument"));
        if (monumentStructure == null) {
            return;
        }

        if (MixinUtil.getStructureAt(structureManager, context.origin(), monumentStructure).isValid()) {
            cir.setReturnValue(false);
        }
    }
}
