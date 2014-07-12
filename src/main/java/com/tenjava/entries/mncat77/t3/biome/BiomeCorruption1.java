package com.tenjava.entries.mncat77.t3.biome;

import net.minecraft.server.v1_7_R3.Blocks;

public class BiomeCorruption1 extends BiomeBase {

    public BiomeCorruption1(int id) {
        super(id);
        this.decorator.x = -100;
        this.decorator.y = -100;
        this.decorator.z = -100;
        this.decorator.B = 1;
        this.decorator.H = 1;
        this.topBlock = Blocks.MYCEL;
        this.as.clear();
        this.at.clear();
        this.au.clear();
    }

}
