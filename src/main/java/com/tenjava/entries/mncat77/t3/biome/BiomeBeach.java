package com.tenjava.entries.mncat77.t3.biome;

import net.minecraft.server.v1_7_R3.Blocks;

public class BiomeBeach extends BiomeBase {

    public BiomeBeach(int i) {
        super(i);
        this.at.clear();
        this.ai = Blocks.SAND;
        this.ak = Blocks.SAND;
        this.ar.x = -999;
        this.ar.A = 0;
        this.ar.C = 0;
        this.ar.D = 0;
    }
}
