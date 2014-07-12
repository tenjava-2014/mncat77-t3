package com.tenjava.entries.mncat77.t3.biome;

import java.util.Random;
import net.minecraft.server.v1_7_R3.WorldGenTaiga2;
import net.minecraft.server.v1_7_R3.WorldGenTreeAbstract;

public class BiomeExtremeHills extends BiomeBase {

    private final WorldGenTaiga2 aD;

    public BiomeExtremeHills(int id) {
        super(id);
        this.aD = new WorldGenTaiga2(false);
    }

    @Override
    public WorldGenTreeAbstract getTreeGen(Random random) {
        return random.nextInt(3) > 0 ? this.aD : super.getTreeGen(random);
    }

}
