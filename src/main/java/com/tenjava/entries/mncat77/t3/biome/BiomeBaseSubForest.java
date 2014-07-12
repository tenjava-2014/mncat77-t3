package com.tenjava.entries.mncat77.t3.biome;

import java.util.Random;
import net.minecraft.server.v1_7_R3.WorldGenTreeAbstract;

class BiomeBaseSubForest extends BiomeBaseSub {

    final BiomeForest aC;

    BiomeBaseSubForest(BiomeForest biomeforest, int i, BiomeBase biomebase) {
        super(i, biomebase);
        this.aC = biomeforest;
    }

    @Override
    public WorldGenTreeAbstract a(Random random) {
        return random.nextBoolean() ? BiomeForest.aC : BiomeForest.aD;
    }
}
