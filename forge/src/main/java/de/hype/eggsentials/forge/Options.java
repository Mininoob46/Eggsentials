package de.hype.eggsentials.forge;

import net.minecraft.client.Minecraft;

public class Options implements de.hype.eggsentials.client.common.mclibraries.Options {
    public void setFov(int value) {
        Minecraft.getMinecraft().gameSettings.fovSetting=value;
    }
    public void setGamma(double value) {
        Minecraft.getMinecraft().gameSettings.gammaSetting= (float) value;
    }
}

