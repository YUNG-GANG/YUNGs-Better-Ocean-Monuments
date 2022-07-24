package com.yungnickyoung.minecraft.betteroceanmonuments.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigGeneralForge {
    public final ForgeConfigSpec.ConfigValue<Integer> startMinY;
    public final ForgeConfigSpec.ConfigValue<Integer> startMaxY;
    public final ForgeConfigSpec.ConfigValue<Boolean> disableVanillaMonuments;

    public ConfigGeneralForge(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER
                .comment(
                        """
                                ##########################################################################################################
                                # General settings.
                                ##########################################################################################################""")
                .push("General");

        startMinY = BUILDER
                .comment(
                        """
                        The minimum y-value at which the ocean monument can spawn.
                        Default: 11""".indent(1))
                .worldRestart()
                .define("Min Start Y", 11);

        startMaxY = BUILDER
                .comment(
                        """
                        The maximum y-value at which the ocean monument can spawn.
                        Default: 21""".indent(1))
                .worldRestart()
                .define("Max Start Y", 21);

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

