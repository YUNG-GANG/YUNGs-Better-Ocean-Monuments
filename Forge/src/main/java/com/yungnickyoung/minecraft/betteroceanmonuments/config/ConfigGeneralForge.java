package com.yungnickyoung.minecraft.betteroceanmonuments.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigGeneralForge {

    public ConfigGeneralForge(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER
                .comment(
                        """
                                ##########################################################################################################
                                # General settings.
                                ##########################################################################################################""")
                .push("General");

        BUILDER.pop();
    }
}

