package com.tenjava.entries.mncat77.t3.generator;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;
import com.tenjava.entries.mncat77.t3.populator.WorldGenScatter;
import com.tenjava.entries.mncat77.t3.populator.WorldGenWhirl;
import java.util.Random;
import net.minecraft.server.v1_7_R3.BlockFlowers;
import net.minecraft.server.v1_7_R3.Blocks;
import net.minecraft.server.v1_7_R3.Material;
import net.minecraft.server.v1_7_R3.World;
import net.minecraft.server.v1_7_R3.WorldGenCactus;
import net.minecraft.server.v1_7_R3.WorldGenClay;
import net.minecraft.server.v1_7_R3.WorldGenDeadBush;
import net.minecraft.server.v1_7_R3.WorldGenFlowers;
import net.minecraft.server.v1_7_R3.WorldGenHugeMushroom;
import net.minecraft.server.v1_7_R3.WorldGenLiquids;
import net.minecraft.server.v1_7_R3.WorldGenMelon;
import net.minecraft.server.v1_7_R3.WorldGenMinable;
import net.minecraft.server.v1_7_R3.WorldGenPumpkin;
import net.minecraft.server.v1_7_R3.WorldGenReed;
import net.minecraft.server.v1_7_R3.WorldGenSand;
import net.minecraft.server.v1_7_R3.WorldGenTreeAbstract;
import net.minecraft.server.v1_7_R3.WorldGenWaterLily;
import net.minecraft.server.v1_7_R3.WorldGenerator;

public class BiomeDecorator {

    public int bushC;
    public int brownmushroomC;
    public int reedC;
    public int cactusC;
    public int gravelC;
    public int sandC;
    public int clayC;
    public int mushroomC = 1;
    public boolean liquids;

    public World a;
    public Random b;
    public int c;
    public WorldGenScatter clouds;
    public WorldGenerator coal;
    public int d;
    public WorldGenerator diamond;
    public WorldGenerator clay = new WorldGenClay(4);
    public WorldGenerator sand;
    public WorldGenerator gravel;
    public WorldGenerator gold;
    public WorldGenerator dirt;
    public WorldGenerator gravel2;
    public WorldGenerator iron;
    public WorldGenerator lily;
    public WorldGenerator redstone;
    public WorldGenMelon melons;
    public WorldGenerator mushroom;
    public WorldGenerator lapis;
    public WorldGenFlowers flowers;
    public WorldGenerator brownmushroom;
    public WorldGenerator redmushroom;
    public WorldGenerator reed;
    public WorldGenScatter tnt;
    public WorldGenerator cactus;
    public int lilyC;
    public WorldGenWhirl whirl = new WorldGenWhirl();
    public boolean whirls = false;
    public int x;
    public int flowersC;
    public int grassC;

    public BiomeDecorator() {
        this.sand = new WorldGenSand(Blocks.SAND, 16);
        this.gravel = new WorldGenSand(Blocks.GRAVEL, 32);
        this.dirt = new WorldGenMinable(Blocks.DIRT, 32);
        this.gravel2 = new WorldGenMinable(Blocks.GRAVEL, 32);
        this.coal = new WorldGenMinable(Blocks.COAL_ORE, 7);
        this.iron = new WorldGenMinable(Blocks.IRON_ORE, 5);
        this.gold = new WorldGenMinable(Blocks.GOLD_ORE, 4);
        this.redstone = new WorldGenMinable(Blocks.REDSTONE_ORE, 6);
        this.diamond = new WorldGenMinable(Blocks.DIAMOND_ORE, 4);
        this.lapis = new WorldGenMinable(Blocks.LAPIS_ORE, 6);
        this.flowers = new WorldGenFlowers(Blocks.YELLOW_FLOWER);
        this.brownmushroom = new WorldGenFlowers(Blocks.BROWN_MUSHROOM);
        this.melons = new WorldGenMelon();
        this.tnt = new WorldGenScatter(Blocks.TNT, false);
        this.clouds = new WorldGenScatter(Blocks.SNOW_BLOCK, true);
        this.redmushroom = new WorldGenFlowers(Blocks.RED_MUSHROOM);
        this.mushroom = new WorldGenHugeMushroom();
        this.reed = new WorldGenReed();
        this.cactus = new WorldGenCactus();
        this.lily = new WorldGenWaterLily();
        this.flowersC = 2;
        this.grassC = 1;
        this.gravelC = 1;
        this.sandC = 3;
        this.clayC = 1;
        this.liquids = true;
    }

    public void a(World world, Random random, BiomeBase biomebase, int i, int j) {
        if(this.a != null) {
            throw new RuntimeException("Already decorating!!");
        }
        else {
            this.a = world;
            this.b = random;
            this.c = i;
            this.d = j;
            this.a(biomebase);
            this.a = null;
            this.b = null;
        }
    }

    public void a(BiomeBase biomebase) {
        this.generateOres();

        int i;
        int j;
        int x;

        for(i = 0; i < this.sandC; ++i) {
            j = this.c + this.b.nextInt(16) + 8;
            x = this.d + this.b.nextInt(16) + 8;
            this.sand.a(this.a, this.b, j, this.a.i(j, x), x);
        }

        for(i = 0; i < this.clayC; ++i) {
            j = this.c + this.b.nextInt(16) + 8;
            x = this.d + this.b.nextInt(16) + 8;
            this.clay.a(this.a, this.b, j, this.a.i(j, x), x);
        }

        for(i = 0; i < this.gravelC; ++i) {
            j = this.c + this.b.nextInt(16) + 8;
            x = this.d + this.b.nextInt(16) + 8;
            this.gravel.a(this.a, this.b, j, this.a.i(j, x), x);
        }

        i = this.x;
        if(this.b.nextInt(10) == 0) {
            ++i;
        }

        int z;
        int y;

        x = this.c + this.b.nextInt(16) + 8;
        z = this.d + this.b.nextInt(16) + 8;
        y = this.a.getHighestBlockYAt(x, z);
        WorldGenTreeAbstract worldgentreeabstract = biomebase.getTreeGen(this.b);

        worldgentreeabstract.a(1.0D, 1.0D, 1.0D);
        if(worldgentreeabstract.a(this.a, this.b, x, y, z)) {
            worldgentreeabstract.b(this.a, this.b, x, y, z);
        }

        for(j = 0; j < this.mushroomC; ++j) {
            x = this.c + this.b.nextInt(16) + 8;
            z = this.d + this.b.nextInt(16) + 8;
            this.mushroom.a(this.a, this.b, x, this.a.getHighestBlockYAt(x, z), z);
        }

        for(j = 0; j < this.flowersC; ++j) {
            x = this.c + this.b.nextInt(16) + 8;
            z = this.d + this.b.nextInt(16) + 8;
            y = this.b.nextInt(this.a.getHighestBlockYAt(x, z) + 32);
            String s = biomebase.getFlowerName(this.b, x, y, z);
            BlockFlowers blockflowers = BlockFlowers.e(s);

            if(blockflowers.getMaterial() != Material.AIR) {
                this.flowers.a(blockflowers, BlockFlowers.f(s));
                this.flowers.a(this.a, this.b, x, y, z);
            }
        }

        for(j = 0; j < this.grassC; ++j) {
            x = this.c + this.b.nextInt(16) + 8;
            z = this.d + this.b.nextInt(16) + 8;
            y = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(x, z) * 2, 1));
            WorldGenerator worldgenerator = biomebase.createGrassGen(this.b);

            worldgenerator.a(this.a, this.b, x, y, z);
        }

        for(j = 0; j < this.bushC; ++j) {
            x = this.c + this.b.nextInt(16) + 8;
            z = this.d + this.b.nextInt(16) + 8;
            y = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(x, z) * 2, 1));
            (new WorldGenDeadBush(Blocks.DEAD_BUSH)).a(this.a, this.b, x, y, z);
        }

        if(whirls && this.b.nextInt(20) == 0) {
            x = this.c + this.b.nextInt(16) + 8;
            z = this.d + this.b.nextInt(16) + 8;
            y = this.a.getHighestBlockYAt(x, z);
            whirl.a(this.a, this.b, x, y, z);
        }

        for(j = 0; j < this.lilyC; ++j) {
            x = this.c + this.b.nextInt(16) + 8;
            z = this.d + this.b.nextInt(16) + 8;

            for(y = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(x, z) * 2, 1)); y > 0 && this.a.isEmpty(x, y - 1, z); --y) {
                ;
            }

            this.lily.a(this.a, this.b, x, y, z);
        }

        for(j = 0; j < this.brownmushroomC; ++j) {
            if(this.b.nextInt(4) == 0) {
                x = this.c + this.b.nextInt(16) + 8;
                z = this.d + this.b.nextInt(16) + 8;
                y = this.a.getHighestBlockYAt(x, z);
                this.brownmushroom.a(this.a, this.b, x, y, z);
            }

            if(this.b.nextInt(8) == 0) {
                x = this.c + this.b.nextInt(16) + 8;
                z = this.d + this.b.nextInt(16) + 8;
                y = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(x, z) * 2, 1));
                this.redmushroom.a(this.a, this.b, x, y, z);
            }
        }

        if(this.b.nextInt(4) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            x = this.d + this.b.nextInt(16) + 8;
            z = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(j, x) * 2, 1));
            this.brownmushroom.a(this.a, this.b, j, z, x);
        }

        if(this.b.nextInt(8) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            x = this.d + this.b.nextInt(16) + 8;
            z = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(j, x) * 2, 1));
            this.redmushroom.a(this.a, this.b, j, z, x);
        }

        for(j = 0; j < this.reedC; ++j) {
            x = this.c + this.b.nextInt(16) + 8;
            z = this.d + this.b.nextInt(16) + 8;
            y = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(x, z) * 2, 1));
            this.reed.a(this.a, this.b, x, y, z);
        }

        if(this.b.nextInt(32) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            x = this.d + this.b.nextInt(16) + 8;
            z = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(j, x) * 2, 1));
            (new WorldGenPumpkin()).a(this.a, this.b, j, z, x);
        }

        if(this.b.nextInt(24) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            x = this.d + this.b.nextInt(16) + 8;
            z = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(j, x) * 2, 1));
            melons.a(this.a, this.b, j, z, x);
        }

        if(this.b.nextInt(24) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            x = this.d + this.b.nextInt(16) + 8;
            z = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(j, x) * 2, 1));
            tnt.a(this.a, this.b, j, z, x);
        }

        if(this.b.nextInt(64) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            x = this.d + this.b.nextInt(16) + 8;
            z = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(j, x) * 2, 1));
            clouds.a(this.a, this.b, j, z, x);
        }

        for(j = 0; j < this.cactusC; ++j) {
            x = this.c + this.b.nextInt(16) + 8;
            z = this.d + this.b.nextInt(16) + 8;
            y = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(x, z) * 2, 1));
            this.cactus.a(this.a, this.b, x, y, z);
        }

        if(this.liquids) {
            for(j = 0; j < 20; ++j) {
                x = this.c + this.b.nextInt(16) + 8;
                z = this.b.nextInt(this.b.nextInt(248) + 8);
                y = this.d + this.b.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.WATER)).a(this.a, this.b, x, z, y);
            }

            for(j = 0; j < 50; ++j) {
                x = this.c + this.b.nextInt(16) + 8;
                z = this.b.nextInt(this.b.nextInt(this.b.nextInt(240) + 8) + 8);
                y = this.d + this.b.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.LAVA)).a(this.a, this.b, x, z, y);
            }
        }
    }

    public void a(int i, WorldGenerator worldgenerator, int j, int k) {
        for(int l = 0; l < i; ++l) {
            int i1 = this.c + this.b.nextInt(16);
            int j1 = this.b.nextInt(k - j) + j;
            int k1 = this.d + this.b.nextInt(16);

            worldgenerator.a(this.a, this.b, i1, j1, k1);
        }
    }

    public void generateOres() {
        this.a(20, this.dirt, 0, 256);
        this.a(10, this.gravel2, 0, 256);
        this.a(10, this.coal, 0, 128);
        this.a(10, this.iron, 0, 64);
        this.a(2, this.gold, 0, 32);
        this.a(8, this.redstone, 0, 16);
        this.a(1, this.diamond, 0, 16);
        this.b(1, this.lapis, 16, 16);
    }

    public void b(int i, WorldGenerator worldgenerator, int j, int k) {
        for(int l = 0; l < i; ++l) {
            int i1 = this.c + this.b.nextInt(16);
            int j1 = this.b.nextInt(k) + this.b.nextInt(k) + (j - k);
            int k1 = this.d + this.b.nextInt(16);

            worldgenerator.a(this.a, this.b, i1, j1, k1);
        }
    }
}
