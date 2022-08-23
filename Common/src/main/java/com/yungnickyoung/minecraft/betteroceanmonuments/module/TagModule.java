package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;

public class TagModule {
    public static final ResourceKey<Structure> BETTER_OCEAN_MONUMENT = ResourceKey.create(Registry.STRUCTURE_REGISTRY,
            new ResourceLocation(BetterOceanMonumentsCommon.MOD_ID, "ocean_monument"));
}
