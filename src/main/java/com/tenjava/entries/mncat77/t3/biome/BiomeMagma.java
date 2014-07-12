package com.tenjava.entries.mncat77.t3.biome;

import net.minecraft.server.v1_7_R3.Blocks;

public class BiomeMagma extends BiomeBase {

    public BiomeMagma(int id) {
        super(id);
        this.topBlock = Blocks.NETHERRACK;
        this.fillerBlock = Blocks.NETHERRACK;
    }

}
