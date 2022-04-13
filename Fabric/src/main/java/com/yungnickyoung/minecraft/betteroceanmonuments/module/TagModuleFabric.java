package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

public class TagModuleFabric {
    public static void init() {
        TagModule.HAS_BETTER_OCEAN_MONUMENT = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(BetterOceanMonumentsCommon.MOD_ID, "has_better_ocean_monument"));
    }
}
