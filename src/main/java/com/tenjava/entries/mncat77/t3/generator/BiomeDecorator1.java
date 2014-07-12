package com.tenjava.entries.mncat77.t3.generator;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;
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
import net.minecraft.server.v1_7_R3.WorldGenLiquids;
import net.minecraft.server.v1_7_R3.WorldGenMelon;
import net.minecraft.server.v1_7_R3.WorldGenMinable;
import net.minecraft.server.v1_7_R3.WorldGenPumpkin;
import net.minecraft.server.v1_7_R3.WorldGenReed;
import net.minecraft.server.v1_7_R3.WorldGenSand;
import net.minecraft.server.v1_7_R3.WorldGenTreeAbstract;
import net.minecraft.server.v1_7_R3.WorldGenWaterLily;
import net.minecraft.server.v1_7_R3.WorldGenerator;

public class BiomeDecorator1 {

    protected World a;
    protected Random b;
    protected int c;
    protected int d;
    public WorldGenerator clay;
    protected WorldGenerator sand;
    protected WorldGenerator gravel;
    protected WorldGenerator dirt;
    protected WorldGenerator gravelpatch;
    public WorldGenerator coal;
    public WorldGenerator iron;
    public WorldGenerator gold;
    //protected WorldGenerator redstone;
    public WorldGenerator diamond;
    //protected WorldGenerator o;
    protected WorldGenFlowers yellowflowers;
    protected WorldGenerator brownmush;
    protected WorldGenerator redmush;
    //protected WorldGenerator hugemush;
    protected WorldGenerator reed;
    protected WorldGenerator cactus;
    protected WorldGenerator waterlily;
    public int orem;
    public int w;
    public int x;
    public int y;
    public int z;
    public int deadbushCount;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean lakes;
    public boolean whirls;
    public WorldGenWhirl whirl = new WorldGenWhirl();

    public BiomeDecorator1() {
        this.orem = 1;
        this.whirls = false;
        this.clay = new WorldGenClay(4);
        this.sand = new WorldGenSand(Blocks.SAND, 7);
        this.gravel = new WorldGenSand(Blocks.GRAVEL, 6);
        this.dirt = new WorldGenMinable(Blocks.DIRT, 16);
        this.gravelpatch = new WorldGenMinable(Blocks.GRAVEL, 28);

        this.coal = new WorldGenMinable(Blocks.COAL_ORE, 12);
        this.iron = new WorldGenMinable(Blocks.IRON_ORE, 7);
        this.gold = new WorldGenMinable(Blocks.GOLD_ORE, 5);
        //this.redstone = new WorldGenMinable(Blocks.REDSTONE_ORE, 7);
        this.diamond = new WorldGenMinable(Blocks.DIAMOND_ORE, 3);
        //this.o = new WorldGenMinable(Blocks.LAPIS_ORE, 6);

        this.yellowflowers = new WorldGenFlowers(Blocks.YELLOW_FLOWER);
        this.brownmush = new WorldGenFlowers(Blocks.BROWN_MUSHROOM);
        this.redmush = new WorldGenFlowers(Blocks.RED_MUSHROOM);
        //this.hugemush = new WorldGenHugeMushroom();
        this.reed = new WorldGenReed();
        this.cactus = new WorldGenCactus();
        this.waterlily = new WorldGenWaterLily();
        this.y = 2;
        this.z = 1;
        this.E = 1;
        this.F = 3;
        this.G = 1;
        this.lakes = true;
    }

    public void a(World world, Random random, BiomeBase biomebase, int i, int j) {
        this.a = world;
        this.b = random;
        this.c = i;
        this.d = j;
        this.a(biomebase);
        this.a = null;
        this.b = null;
    }

    protected void a(BiomeBase biomebase) {
        if(biomebase == BiomeBase.DUNGEONS) {
            return;
        }
        this.a();

        int i;
        int j;
        int k;
        int l;
        int i1;

        for(i = 0; i < this.F; ++i) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            this.sand.a(this.a, this.b, j, this.a.i(j, k), k);
        }

        for(i = 0; i < this.G; ++i) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            this.clay.a(this.a, this.b, j, this.a.i(j, k), k);
        }

        for(i = 0; i < this.E; ++i) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            this.gravel.a(this.a, this.b, j, this.a.i(j, k), k);
        }

        i = this.x;
        if(this.b.nextInt(10) == 0) {
            ++i;
        }

        if(whirls && this.b.nextInt(20) == 0) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.a.getHighestBlockYAt(k, l);
            whirl.a(this.a, this.b, k, i1, l);
        }

        for(j = 0; j < i; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.a.getHighestBlockYAt(k, l);
            WorldGenTreeAbstract worldgentreeabstract = biomebase.getTreeGen(this.b);

            worldgentreeabstract.a(1.0D, 1.0D, 1.0D);
            if(worldgentreeabstract.a(this.a, this.b, k, i1, l)) {
                worldgentreeabstract.b(this.a, this.b, k, i1, l);
            }
        }

        /*for(j = 0; j < this.H; ++j) {
         k = this.c + this.b.nextInt(16) + 8;
         l = this.d + this.b.nextInt(16) + 8;
         this.hugemush.a(this.a, this.b, k, this.a.getHighestBlockYAt(k, l), l);
         }*/
        for(j = 0; j < this.y; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(this.a.getHighestBlockYAt(k, l) + 32);
            String s = biomebase.getFlowerName(this.b, k, i1, l);
            BlockFlowers blockflowers = BlockFlowers.e(s);

            if(blockflowers.getMaterial() != Material.AIR) {
                this.yellowflowers.a(blockflowers, BlockFlowers.f(s));
                this.yellowflowers.a(this.a, this.b, k, i1, l);
            }
        }

        if(this.b.nextInt(32) == 0) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(k, l) * 2, 1));
            (new WorldGenMelon()).a(this.a, this.b, k, i1, l);
        }

        for(j = 0; j < this.z; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(k, l) * 2, 1));
            WorldGenerator worldgenerator = biomebase.createGrassGen(this.b);

            worldgenerator.a(this.a, this.b, k, i1, l);
        }

        for(j = 0; j < this.deadbushCount; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(k, l) * 2, 1));
            (new WorldGenDeadBush(Blocks.DEAD_BUSH)).a(this.a, this.b, k, i1, l);
        }

        for(j = 0; j < this.w; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;

            for(i1 = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(k, l) * 2, 1)); i1 > 0 && this.a.isEmpty(k, i1 - 1, l); --i1) {
                ;
            }

            this.waterlily.a(this.a, this.b, k, i1, l);
        }

        for(j = 0; j < this.B; ++j) {
            if(this.b.nextInt(4) == 0) {
                k = this.c + this.b.nextInt(16) + 8;
                l = this.d + this.b.nextInt(16) + 8;
                i1 = this.a.getHighestBlockYAt(k, l);
                this.brownmush.a(this.a, this.b, k, i1, l);
            }

            if(this.b.nextInt(8) == 0) {
                k = this.c + this.b.nextInt(16) + 8;
                l = this.d + this.b.nextInt(16) + 8;
                i1 = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(k, l) * 2, 1));
                this.redmush.a(this.a, this.b, k, i1, l);
            }
        }

        if(this.b.nextInt(4) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            l = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(j, k) * 2, 1));
            this.brownmush.a(this.a, this.b, j, l, k);
        }

        if(this.b.nextInt(8) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            l = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(j, k) * 2, 1));
            this.redmush.a(this.a, this.b, j, l, k);
        }

        for(j = 0; j < this.C; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(k, l) * 2, 1));
            this.reed.a(this.a, this.b, k, i1, l);
        }

        for(j = 0; j < 10; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(k, l) * 2, 1));
            this.reed.a(this.a, this.b, k, i1, l);
        }

        if(this.b.nextInt(48) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            l = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(j, k) * 2, 1));
            (new WorldGenPumpkin()).a(this.a, this.b, j, l, k);
        }

        for(j = 0; j < this.D; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(Math.max(this.a.getHighestBlockYAt(k, l) * 2, 1));
            this.cactus.a(this.a, this.b, k, i1, l);
        }

        if(this.lakes) {
            for(j = 0; j < 30; ++j) {
                k = this.c + this.b.nextInt(16) + 8;
                l = this.b.nextInt(this.b.nextInt(248) + 8);
                i1 = this.d + this.b.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.WATER)).a(this.a, this.b, k, l, i1);
            }

            for(j = 0; j < 25; ++j) {
                k = this.c + this.b.nextInt(16) + 8;
                l = this.b.nextInt(this.b.nextInt(this.b.nextInt(240) + 8) + 8);
                i1 = this.d + this.b.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.LAVA)).a(this.a, this.b, k, l, i1);
            }
        }
    }

    protected void a(int i, WorldGenerator worldgenerator, int j, int k) {
        for(int l = 0; l < i; ++l) {
            int i1 = this.c + this.b.nextInt(16);
            int j1 = this.b.nextInt(k - j) + j;
            int k1 = this.d + this.b.nextInt(16);

            worldgenerator.a(this.a, this.b, i1, j1, k1);
        }
    }

    protected void b(int i, WorldGenerator worldgenerator, int j, int k) {
        for(int l = 0; l < i; ++l) {
            int i1 = this.c + this.b.nextInt(16);
            int j1 = this.b.nextInt(k) + this.b.nextInt(k) + (j - k);
            int k1 = this.d + this.b.nextInt(16);

            worldgenerator.a(this.a, this.b, i1, j1, k1);
        }
    }

    protected void a() {

        this.a(20, this.dirt, 0, 256);
        this.a(10, this.gravelpatch, 0, 256);
        this.a(20, this.coal, 0, 128 * orem);
        this.a(20, this.iron, 0, 64 * orem);
        this.a(2, this.gold, 0, 32 * orem);
        //this.a(8, this.redstone, 0, 16);
        this.a(1, this.diamond, 0, 16 * orem);
        //this.b(1, this.o, 16, 16);

    }
}
