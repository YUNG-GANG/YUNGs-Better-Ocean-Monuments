package com.yungnickyoung.minecraft.betteroceanmonuments.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigGeneralFabric {
    @ConfigEntry.Gui.Tooltip
    public int startMinY = 11;

    @ConfigEntry.Gui.Tooltip
    public int startMaxY = 21;

    @ConfigEntry.Gui.Tooltip
    public boolean disableVanillaMonuments = true;
}
