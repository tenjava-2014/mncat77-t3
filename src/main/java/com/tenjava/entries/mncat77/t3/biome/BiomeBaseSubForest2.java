package com.tenjava.entries.mncat77.t3.biome;

import java.util.Random;
import net.minecraft.server.v1_7_R3.World;

class BiomeBaseSubForest2 extends BiomeBaseSub {

    final BiomeForest aC;

    BiomeBaseSubForest2(BiomeForest biomeforest, int i, BiomeBase biomebase) {
        super(i, biomebase);
        this.aC = biomeforest;
    }

    @Override
    public void a(World world, Random random, int i, int j) {
        this.aD.a(world, random, i, j);
    }
}
