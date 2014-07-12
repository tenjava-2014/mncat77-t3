package com.tenjava.entries.mncat77.t3.biome;

import org.bukkit.block.Biome;

public class BiomeOcean extends BiomeBase {

    public BiomeOcean(int id) {
        super(id);
        this.topBlockId = 3;
        this.bukkitBiome = Biome.OCEAN;
    }

}
