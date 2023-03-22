package com.yungnickyoung.minecraft.betteroceanmonuments.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name="betteroceanmonuments-fabric-1_19_4")
public class BOMConfigFabric implements ConfigData {
    @ConfigEntry.Category("Better Ocean Monuments")
    @ConfigEntry.Gui.TransitiveObject
    public ConfigGeneralFabric general = new ConfigGeneralFabric();
}
