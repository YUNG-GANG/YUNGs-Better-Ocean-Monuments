package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class TagModuleForge {
    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(TagModuleForge::commonSetup);
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            TagModule.HAS_BETTER_OCEAN_MONUMENT = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(BetterOceanMonumentsCommon.MOD_ID, "has_better_ocean_monument"));
        });
    }
}
