package com.tenjava.entries.mncat77.t3.biome;

import java.util.Random;
import net.minecraft.server.v1_7_R3.Blocks;
import net.minecraft.server.v1_7_R3.World;
import net.minecraft.server.v1_7_R3.WorldGenDesertWell;

public class BiomeDesert extends BiomeBase {

    public BiomeDesert(int id) {
        super(id);
        this.at.clear();
        this.topBlock = Blocks.SAND;
        this.fillerBlock = Blocks.SAND;
        this.decorator.x = -999;
        this.decorator.A = 2;
        this.decorator.C = 50;
        this.decorator.D = 10;
        this.at.clear();
        this.decorator.whirls = true;
    }

    @Override
    public void a(World world, Random random, int i, int j) {
        super.a(world, random, i, j);
        if(random.nextInt(1000) == 0) {
            int k = i + random.nextInt(16) + 8;
            int l = j + random.nextInt(16) + 8;
            WorldGenDesertWell worldgendesertwell = new WorldGenDesertWell();

            worldgendesertwell.a(world, random, k, world.getHighestBlockYAt(k, l) + 1, l);
        }
    }
}
