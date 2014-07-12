package com.tenjava.entries.mncat77.t3.biome;

import net.minecraft.server.v1_7_R3.Blocks;

public class BiomeStoneBeach extends BiomeBase {

    public BiomeStoneBeach(int i) {
        super(i);
        this.at.clear();
        this.ai = Blocks.STONE;
        this.ak = Blocks.STONE;
        this.ar.x = -999;
        this.ar.A = 0;
        this.ar.C = 0;
        this.ar.D = 0;
    }
}
