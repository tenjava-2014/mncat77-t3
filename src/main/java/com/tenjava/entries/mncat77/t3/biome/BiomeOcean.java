package com.tenjava.entries.mncat77.t3.biome;

import net.minecraft.server.v1_7_R3.EnumTemperature;
import org.bukkit.block.Biome;

public class BiomeOcean extends BiomeBase {

    public BiomeOcean(int id) {
        super(id);
        this.at.clear();
        this.bukkitBiome = Biome.OCEAN;
    }

    @Override
    public EnumTemperature m() {
        return EnumTemperature.OCEAN;
    }

}
