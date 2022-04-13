package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import com.yungnickyoung.minecraft.betteroceanmonuments.world.structure.OceanMonumentStructure;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class StructureFeatureModuleFabric {
    public static void init() {
        StructureFeatureModule.OCEAN_MONUMENT = register("ocean_monument", new OceanMonumentStructure());
    }

    private static <FC extends FeatureConfiguration> StructureFeature<FC> register(String name, StructureFeature<FC> structureFeature) {
        return Registry.register(Registry.STRUCTURE_FEATURE, new ResourceLocation(BetterOceanMonumentsCommon.MOD_ID, name), structureFeature);
    }
}
