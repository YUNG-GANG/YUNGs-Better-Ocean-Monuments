package com.yungnickyoung.minecraft.betteroceanmonuments.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class BOMConfigForge {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ConfigGeneralForge general;

    static {
        BUILDER.push("YUNG's Better Ocean Monuments");

        general = new ConfigGeneralForge(BUILDER);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}