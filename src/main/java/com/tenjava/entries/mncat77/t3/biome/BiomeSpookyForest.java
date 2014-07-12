package com.tenjava.entries.mncat77.t3.biome;

import java.util.Random;
import net.minecraft.server.v1_7_R3.Block;
import net.minecraft.server.v1_7_R3.Blocks;
import net.minecraft.server.v1_7_R3.World;
import net.minecraft.server.v1_7_R3.WorldGenGrass;
import net.minecraft.server.v1_7_R3.WorldGenMegaTree;
import net.minecraft.server.v1_7_R3.WorldGenMinable;
import net.minecraft.server.v1_7_R3.WorldGenTaiga1;
import net.minecraft.server.v1_7_R3.WorldGenTaiga2;
import net.minecraft.server.v1_7_R3.WorldGenTaigaStructure;
import net.minecraft.server.v1_7_R3.WorldGenTreeAbstract;
import net.minecraft.server.v1_7_R3.WorldGenerator;

public class BiomeSpookyForest extends BiomeBase {

    private static final WorldGenTaiga1 taiga1 = new WorldGenTaiga1();
    private static final WorldGenTaiga2 taiga2 = new WorldGenTaiga2(false);
    private static final WorldGenMegaTree megatree1 = new WorldGenMegaTree(false, false);
    private static final WorldGenMegaTree megatree2 = new WorldGenMegaTree(false, true);
    private static final WorldGenTaigaStructure ruinsV = new WorldGenTaigaStructure(Blocks.MOSSY_COBBLESTONE, 0);

    public BiomeSpookyForest(int id) {
        super(id);
        this.decorator.x = 10;
        this.decorator.z = 1;
        this.decorator.B = 1;
        this.decorator.orem = 2;
        this.decorator.coal = new WorldGenMinable(Blocks.COAL_ORE, 24);
        this.decorator.iron = new WorldGenMinable(Blocks.IRON_ORE, 14);
        this.decorator.gold = new WorldGenMinable(Blocks.GOLD_ORE, 10);
        this.decorator.diamond = new WorldGenMinable(Blocks.DIAMOND_ORE, 6);

    }

    @Override
    public WorldGenTreeAbstract getTreeGen(Random random) {
        return random.nextInt(3) == 0 ? (random.nextInt(13) != 0 ? megatree1 : megatree2) : (random.nextInt(3) == 0 ? taiga1 : taiga2);
    }

    @Override
    public void a(World world, Random random, int i, int j) {
        int k;
        int l;
        int i1;
        int j1;

        k = random.nextInt(3);

        for(l = 0; l < k; ++l) {
            i1 = i + random.nextInt(16) + 8;
            j1 = j + random.nextInt(16) + 8;
            int k1 = world.getHighestBlockYAt(i1, j1);

            ruinsV.a(world, random, i1, k1, j1);
        }

        ae.a(3);

        for(k = 0; k < 7; ++k) {
            l = i + random.nextInt(16) + 8;
            i1 = j + random.nextInt(16) + 8;
            j1 = random.nextInt(world.getHighestBlockYAt(l, i1) + 32);
            ae.a(world, random, l, j1, i1);
        }

        super.a(world, random, i, j);
    }

    @Override
    public void a(World world, Random random, Block[] ablock, byte[] abyte, int i, int j, double d0) {
        this.topBlock = Blocks.GRASS;
        this.aj = 0;
        this.fillerBlock = Blocks.DIRT;
        if(d0 > 1.75D) {
            this.topBlock = Blocks.DIRT;
            this.aj = 1;
        }
        else if(d0 > -0.95D) {
            this.topBlock = Blocks.DIRT;
            this.aj = 2;
        }

        this.b(world, random, ablock, abyte, i, j, d0);
    }

    @Override
    public WorldGenerator createGrassGen(Random random) {
        return random.nextInt(5) > 0 ? new WorldGenGrass(Blocks.LONG_GRASS, 2) : new WorldGenGrass(Blocks.LONG_GRASS, 1);
    }

}
