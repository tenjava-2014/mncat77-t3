package com.tenjava.entries.mncat77.t3.biome;

import java.util.Random;
import net.minecraft.server.v1_7_R3.Block;
import net.minecraft.server.v1_7_R3.Blocks;
import net.minecraft.server.v1_7_R3.World;

public class BiomeSavannaSub extends BiomeBaseSub {

    public BiomeSavannaSub(int i, BiomeBase biomebase) {
        super(i, biomebase);
        this.decorator.x = 2;
        this.decorator.flowersC = 2;
        this.decorator.grassC = 5;
    }

    @Override
    public void a(World world, Random random, Block[] ablock, byte[] abyte, int i, int j, double d0) {
        this.topBlock = Blocks.GRASS;
        this.aj = 0;
        this.fillerBlock = Blocks.DIRT;
        if(d0 > 1.75D) {
            this.topBlock = Blocks.STONE;
            this.fillerBlock = Blocks.STONE;
        }
        else if(d0 > -0.5D) {
            this.topBlock = Blocks.DIRT;
            this.aj = 1;
        }

        this.b(world, random, ablock, abyte, i, j, d0);
    }

    @Override
    public void a(World world, Random random, int i, int j) {
        this.decorator.a(world, random, this, i, j);
    }
}
