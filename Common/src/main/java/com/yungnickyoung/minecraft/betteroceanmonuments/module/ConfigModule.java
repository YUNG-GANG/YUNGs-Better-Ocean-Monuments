package com.yungnickyoung.minecraft.betteroceanmonuments.module;

public class ConfigModule {
    public General general = new General();

    public static class General {
        public int startMinY = 11;
        public int startMaxY = 21;
        public boolean disableVanillaMonuments = true;
    }
}
