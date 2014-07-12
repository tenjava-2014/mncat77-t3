package com.tenjava.entries.mncat77.t3.biome;

import net.minecraft.server.v1_7_R3.Blocks;

public class BiomeBeach extends BiomeBase {

    public BiomeBeach(int i) {
        super(i);
        this.at.clear();
        this.topBlock = Blocks.SAND;
        this.fillerBlock = Blocks.SAND;
        this.decorator.x = -999;
        this.decorator.A = 0;
        this.decorator.C = 0;
        this.decorator.D = 0;
    }
}
