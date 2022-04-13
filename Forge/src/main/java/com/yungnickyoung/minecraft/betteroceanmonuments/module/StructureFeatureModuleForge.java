package com.yungnickyoung.minecraft.betteroceanmonuments.module;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import com.yungnickyoung.minecraft.betteroceanmonuments.world.structure.OceanMonumentStructure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

public class StructureFeatureModuleForge {
    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(StructureFeature.class, StructureFeatureModuleForge::registerStructures);
    }

    private static void registerStructures(RegistryEvent.Register<StructureFeature<?>> event) {
        IForgeRegistry<StructureFeature<?>> registry = event.getRegistry();
        StructureFeatureModule.OCEAN_MONUMENT = register(registry, "ocean_monument", new OceanMonumentStructure());
    }

    private static <FC extends FeatureConfiguration> StructureFeature<FC> register(IForgeRegistry<StructureFeature<?>> registry, String name, StructureFeature<FC> structureFeature) {
        structureFeature.setRegistryName(new ResourceLocation(BetterOceanMonumentsCommon.MOD_ID, name));
        registry.register(structureFeature);
        return structureFeature;
    }
}
