package com.yungnickyoung.minecraft.betteroceanmonuments.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigGeneralForge {
    public final ModConfigSpec.ConfigValue<Boolean> disableVanillaMonuments;

    public ConfigGeneralForge(final ModConfigSpec.Builder BUILDER) {
        BUILDER
                .comment(
                        """
                                ##########################################################################################################
                                # General settings.
                                ##########################################################################################################""")
                .push("General");

        disableVanillaMonuments = BUILDER
                .comment(
                        """
                        Whether or not vanilla ocean monuments should be disabled.
                        Default: true""".indent(1))
                .worldRestart()
                .define("Disable Vanilla Ocean Monuments", true);

        BUILDER.pop();
    }
}

