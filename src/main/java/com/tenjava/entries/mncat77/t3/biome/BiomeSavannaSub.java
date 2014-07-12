package com.tenjava.entries.mncat77.t3.biome;

import java.util.Random;
import net.minecraft.server.v1_7_R3.Block;
import net.minecraft.server.v1_7_R3.Blocks;
import net.minecraft.server.v1_7_R3.World;

public class BiomeSavannaSub extends BiomeBaseSub {

    public BiomeSavannaSub(int i, BiomeBase biomebase) {
        super(i, biomebase);
        this.ar.x = 2;
        this.ar.y = 2;
        this.ar.z = 5;
    }

    @Override
    public void a(World world, Random random, Block[] ablock, byte[] abyte, int i, int j, double d0) {
        this.ai = Blocks.GRASS;
        this.aj = 0;
        this.ak = Blocks.DIRT;
        if(d0 > 1.75D) {
            this.ai = Blocks.STONE;
            this.ak = Blocks.STONE;
        }
        else if(d0 > -0.5D) {
            this.ai = Blocks.DIRT;
            this.aj = 1;
        }

        this.b(world, random, ablock, abyte, i, j, d0);
    }

    @Override
    public void a(World world, Random random, int i, int j) {
        this.ar.a(world, random, this, i, j);
    }
}
