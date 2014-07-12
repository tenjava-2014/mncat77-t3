package com.tenjava.entries.mncat77.t3.biome;

import java.util.Random;
import net.minecraft.server.v1_7_R3.Blocks;
import net.minecraft.server.v1_7_R3.World;
import net.minecraft.server.v1_7_R3.WorldGenPackedIce1;
import net.minecraft.server.v1_7_R3.WorldGenPackedIce2;
import net.minecraft.server.v1_7_R3.WorldGenTaiga2;
import net.minecraft.server.v1_7_R3.WorldGenTreeAbstract;

public class BiomeIce extends BiomeBase {

    private final WorldGenPackedIce2 aD = new WorldGenPackedIce2();
    private final WorldGenPackedIce1 aE = new WorldGenPackedIce1(4);

    public BiomeIce(int id) {
        super(id);
        this.topBlock = Blocks.SNOW_BLOCK;
        this.creatures.clear();
    }

    @Override
    public void a(World world, Random random, int i, int j) {
        int k;
        int l;
        int i1;

        for(k = 0; k < 3; ++k) {
            l = i + random.nextInt(16) + 8;
            i1 = j + random.nextInt(16) + 8;
            this.aD.a(world, random, l, world.getHighestBlockYAt(l, i1), i1);
        }

        for(k = 0; k < 2; ++k) {
            l = i + random.nextInt(16) + 8;
            i1 = j + random.nextInt(16) + 8;
            this.aE.a(world, random, l, world.getHighestBlockYAt(l, i1), i1);
        }

        super.a(world, random, i, j);
    }

    @Override
    public WorldGenTreeAbstract getTreeGen(Random random) {
        return new WorldGenTaiga2(false);
    }

}
