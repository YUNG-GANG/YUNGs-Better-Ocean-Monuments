package com.yungnickyoung.minecraft.betteroceanmonuments.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigGeneralForge {
    public final ForgeConfigSpec.ConfigValue<Boolean> disableVanillaMonuments;

    public ConfigGeneralForge(final ForgeConfigSpec.Builder BUILDER) {
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

