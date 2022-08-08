package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import com.yungnickyoung.minecraft.betteroceanmonuments.world.structure.OceanMonumentStructure;
import com.yungnickyoung.minecraft.yungsapi.api.YungJigsawConfig;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import net.minecraft.world.level.levelgen.feature.StructureFeature;

@AutoRegister(BetterOceanMonumentsCommon.MOD_ID)
public class StructureFeatureModule {
    @AutoRegister("ocean_monument")
    public static StructureFeature<YungJigsawConfig> OCEAN_MONUMENT = new OceanMonumentStructure();
}
