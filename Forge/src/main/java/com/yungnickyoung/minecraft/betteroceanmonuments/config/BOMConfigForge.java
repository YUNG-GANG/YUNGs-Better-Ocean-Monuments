package com.yungnickyoung.minecraft.betteroceanmonuments.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BOMConfigForge {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ConfigGeneralForge general;

    static {
        BUILDER.push("YUNG's Better Ocean Monuments");

        general = new ConfigGeneralForge(BUILDER);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}