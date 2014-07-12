package com.tenjava.entries.mncat77.t3.biome;

import net.minecraft.server.v1_7_R3.Blocks;

public class BiomeStoneBeach extends BiomeBase {

    public BiomeStoneBeach(int i) {
        super(i);
        this.at.clear();
        this.topBlock = Blocks.STONE;
        this.fillerBlock = Blocks.STONE;
        this.decorator.x = -999;
        this.decorator.A = 0;
        this.decorator.C = 0;
        this.decorator.D = 0;
    }
}
