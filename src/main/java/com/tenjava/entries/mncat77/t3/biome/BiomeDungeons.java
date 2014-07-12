package com.tenjava.entries.mncat77.t3.biome;

import net.minecraft.server.v1_7_R3.Blocks;

public class BiomeDungeons extends BiomeBase {

    public BiomeDungeons(int id) {
        super(id);
        this.topBlock = Blocks.BEDROCK;
        this.fillerBlock = Blocks.BEDROCK;
    }

}
