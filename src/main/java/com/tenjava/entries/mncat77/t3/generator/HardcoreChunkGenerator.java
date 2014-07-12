/*package com.tenjava.entries.mncat77.t3.generator;

 import com.tenjava.entries.mncat77.t3.biome.BiomeBase;
 import com.tenjava.entries.mncat77.t3.layer.BiomeLayer;
 import com.tenjava.entries.mncat77.t3.populator.WorldGenDungeons;
 import java.util.List;
 import java.util.Random;
 import net.minecraft.server.v1_7_R3.Block;
 import net.minecraft.server.v1_7_R3.BlockFalling;
 import net.minecraft.server.v1_7_R3.Blocks;
 import net.minecraft.server.v1_7_R3.Chunk;
 import net.minecraft.server.v1_7_R3.ChunkPosition;
 import net.minecraft.server.v1_7_R3.EnumCreatureType;
 import net.minecraft.server.v1_7_R3.IChunkProvider;
 import net.minecraft.server.v1_7_R3.IProgressUpdate;
 import net.minecraft.server.v1_7_R3.MathHelper;
 import net.minecraft.server.v1_7_R3.NoiseGenerator3;
 import net.minecraft.server.v1_7_R3.NoiseGeneratorOctaves;
 import net.minecraft.server.v1_7_R3.World;
 import net.minecraft.server.v1_7_R3.WorldGenBase;
 import net.minecraft.server.v1_7_R3.WorldGenCanyon;
 import net.minecraft.server.v1_7_R3.WorldGenCaves;
 import net.minecraft.server.v1_7_R3.WorldGenLakes;
 import net.minecraft.server.v1_7_R3.WorldGenLargeFeature;
 import net.minecraft.server.v1_7_R3.WorldGenMineshaft;
 import net.minecraft.server.v1_7_R3.WorldGenStronghold;
 import net.minecraft.server.v1_7_R3.WorldGenVillage;
 import net.minecraft.server.v1_7_R3.WorldType;
 import org.bukkit.craftbukkit.v1_7_R3.generator.InternalChunkGenerator;

 public class HardcoreChunkGenerator extends InternalChunkGenerator {

 private Random i;
 private NoiseGeneratorOctaves j;
 private NoiseGeneratorOctaves k;
 private NoiseGeneratorOctaves l;
 private NoiseGenerator3 m;
 public NoiseGeneratorOctaves a;
 public NoiseGeneratorOctaves b;
 public NoiseGeneratorOctaves c;
 private World n;
 private final boolean o;
 private WorldType p;
 private final double[] q;
 private final float[] r;
 private double[] s = new double[256];
 private WorldGenBase t = new WorldGenCaves();
 private WorldGenStronghold u = new WorldGenStronghold();
 private WorldGenVillage v = new WorldGenVillage();
 private WorldGenMineshaft w = new WorldGenMineshaft();
 private WorldGenLargeFeature x = new WorldGenLargeFeature();
 private WorldGenBase y = new WorldGenCanyon();
 private int[] z;
 double[] d;
 double[] e;
 double[] f;
 double[] g;
 int[][] h = new int[32][32];
 BiomeLayer layer;
 BiomeLayer layer2;

 public HardcoreChunkGenerator(World world) {
 this.n = world;
 this.o = true;
 this.p = world.getWorldData().getType();
 this.i = new Random(world.getSeed());
 this.j = new NoiseGeneratorOctaves(this.i, 16);
 this.k = new NoiseGeneratorOctaves(this.i, 16);
 this.l = new NoiseGeneratorOctaves(this.i, 8);
 this.m = new NoiseGenerator3(this.i, 4);
 this.a = new NoiseGeneratorOctaves(this.i, 10);
 this.b = new NoiseGeneratorOctaves(this.i, 16);
 this.c = new NoiseGeneratorOctaves(this.i, 8);
 this.q = new double[825];
 this.r = new float[25];
 BiomeLayer[] layers = BiomeLayer.initBiomeLayers(world.getSeed());
 layer = layers[0];
 layer2 = layers[1];

 for(int j = -2; j <= 2; ++j) {
 for(int k = -2; k <= 2; ++k) {
 float f = 10.0F / MathHelper.c((float)(j * j + k * k) + 0.2F);

 this.r[j + 2 + (k + 2) * 5] = f;
 }
 }
 }

 public void a(int i, int j, Block[] ablock) {
 byte b0 = 63;

 this.z = layer2.getValues(i * 4 - 2, j * 4 - 2, 10, 10);
 this.a(i * 4, 0, j * 4);

 for(int k = 0; k < 4; ++k) {
 int l = k * 5;
 int i1 = (k + 1) * 5;

 for(int j1 = 0; j1 < 4; ++j1) {
 int k1 = (l + j1) * 33;
 int l1 = (l + j1 + 1) * 33;
 int i2 = (i1 + j1) * 33;
 int j2 = (i1 + j1 + 1) * 33;

 for(int k2 = 0; k2 < 32; ++k2) {
 double d0 = 0.125D;
 double d1 = this.q[k1 + k2];
 double d2 = this.q[l1 + k2];
 double d3 = this.q[i2 + k2];
 double d4 = this.q[j2 + k2];
 double d5 = (this.q[k1 + k2 + 1] - d1) * d0;
 double d6 = (this.q[l1 + k2 + 1] - d2) * d0;
 double d7 = (this.q[i2 + k2 + 1] - d3) * d0;
 double d8 = (this.q[j2 + k2 + 1] - d4) * d0;

 for(int l2 = 0; l2 < 8; ++l2) {
 double d9 = 0.25D;
 double d10 = d1;
 double d11 = d2;
 double d12 = (d3 - d1) * d9;
 double d13 = (d4 - d2) * d9;

 for(int i3 = 0; i3 < 4; ++i3) {
 int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
 short short1 = 256;

 j3 -= short1;
 double d14 = 0.25D;
 double d15 = (d11 - d10) * d14;
 double d16 = d10 - d15;

 for(int k3 = 0; k3 < 4; ++k3) {
 if((d16 += d15) > 0.0D) {
 ablock[j3 += short1] = Blocks.STONE;
 }
 else if(k2 * 8 + l2 < b0) {
 ablock[j3 += short1] = Blocks.STATIONARY_WATER;
 }
 else {
 ablock[j3 += short1] = null;
 }
 }

 d10 += d12;
 d11 += d13;
 }

 d1 += d5;
 d2 += d6;
 d3 += d7;
 d4 += d8;
 }
 }
 }
 }
 }

 public void a(int i, int j, Block[] ablock, byte[] abyte, int[] abiomebase) {
 double d0 = 0.03125D;

 this.s = this.m.a(this.s, (double)(i * 16), (double)(j * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

 for(int k = 0; k < 16; ++k) {
 for(int l = 0; l < 16; ++l) {
 BiomeBase biomebase = BiomeBase.byId[abiomebase[l + k * 16]];

 biomebase.a(this.n, this.i, ablock, abyte, i * 16 + k, j * 16 + l, this.s[l + k * 16]);
 }
 }
 }

 @Override
 public Chunk getChunkAt(int i, int j) {
 return this.getOrCreateChunk(i, j);
 }

 @Override
 public Chunk getOrCreateChunk(int i, int j) {
 this.i.setSeed((long)i * 341873128712L + (long)j * 132897987541L);
 Block[] ablock = new Block[65536];
 byte[] abyte = new byte[65536];

 this.a(i, j, ablock);
 this.z = layer.getValues(i * 16, j * 16, 16, 16);
 this.a(i, j, ablock, abyte, this.z);
 this.t.a(this, this.n, i, j, ablock);
 this.y.a(this, this.n, i, j, ablock);
 if(this.o) {
 this.w.a(this, this.n, i, j, ablock);
 this.v.a(this, this.n, i, j, ablock);
 this.u.a(this, this.n, i, j, ablock);
 this.x.a(this, this.n, i, j, ablock);
 }

 Chunk chunk = new Chunk(this.n, ablock, abyte, i, j);
 byte[] abyte1 = chunk.m();

 for(int k = 0; k < abyte1.length; ++k) {
 abyte1[k] = (byte)this.z[k];
 }

 chunk.initLighting();
 return chunk;
 }

 private void a(int i, int j, int k) {
 double d0 = 684.412D;
 double d1 = 684.412D;
 double d2 = 512.0D;
 double d3 = 512.0D;

 this.g = this.b.a(this.g, i, k, 5, 5, 200.0D, 200.0D, 0.5D);
 this.d = this.l.a(this.d, i, j, k, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
 this.e = this.j.a(this.e, i, j, k, 5, 33, 5, 684.412D, 684.412D, 684.412D);
 this.f = this.k.a(this.f, i, j, k, 5, 33, 5, 684.412D, 684.412D, 684.412D);
 boolean flag = false;
 boolean flag1 = false;
 int l = 0;
 int i1 = 0;
 double d4 = 8.5D;

 for(int j1 = 0; j1 < 5; ++j1) {
 for(int k1 = 0; k1 < 5; ++k1) {
 float f = 0.0F;
 float f1 = 0.0F;
 float f2 = 0.0F;
 byte b0 = 2;
 BiomeBase biomebase = BiomeBase.byId[this.z[j1 + 2 + (k1 + 2) * 10]];

 for(int l1 = -b0; l1 <= b0; ++l1) {
 for(int i2 = -b0; i2 <= b0; ++i2) {
 BiomeBase biomebase1 = BiomeBase.byId[this.z[j1 + l1 + 2 + (k1 + i2 + 2) * 10]];
 float f3 = biomebase1.am;
 float f4 = biomebase1.an;

 if(this.p == WorldType.AMPLIFIED && f3 > 0.0F) {
 f3 = 1.0F + f3 * 2.0F;
 f4 = 1.0F + f4 * 4.0F;
 }

 float f5 = this.r[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);

 if(biomebase1.am > biomebase.am) {
 f5 /= 2.0F;
 }

 f += f4 * f5;
 f1 += f3 * f5;
 f2 += f5;
 }
 }

 f /= f2;
 f1 /= f2;
 f = f * 0.9F + 0.1F;
 f1 = (f1 * 4.0F - 1.0F) / 8.0F;
 double d5 = this.g[i1] / 8000.0D;

 if(d5 < 0.0D) {
 d5 = -d5 * 0.3D;
 }

 d5 = d5 * 3.0D - 2.0D;
 if(d5 < 0.0D) {
 d5 /= 2.0D;
 if(d5 < -1.0D) {
 d5 = -1.0D;
 }

 d5 /= 1.4D;
 d5 /= 2.0D;
 }
 else {
 if(d5 > 1.0D) {
 d5 = 1.0D;
 }

 d5 /= 8.0D;
 }

 ++i1;
 double d6 = (double)f1;
 double d7 = (double)f;

 d6 += d5 * 0.2D;
 d6 = d6 * 8.5D / 8.0D;
 double d8 = 8.5D + d6 * 4.0D;

 for(int j2 = 0; j2 < 33; ++j2) {
 double d9 = ((double)j2 - d8) * 12.0D * 128.0D / 256.0D / d7;

 if(d9 < 0.0D) {
 d9 *= 4.0D;
 }

 double d10 = this.e[l] / 512.0D;
 double d11 = this.f[l] / 512.0D;
 double d12 = (this.d[l] / 10.0D + 1.0D) / 2.0D;
 double d13 = MathHelper.b(d10, d11, d12) - d9;

 if(j2 > 29) {
 double d14 = (double)((float)(j2 - 29) / 3.0F);

 d13 = d13 * (1.0D - d14) + -10.0D * d14;
 }

 this.q[l] = d13;
 ++l;
 }
 }
 }
 }

 @Override
 public boolean isChunkLoaded(int i, int j) {
 return true;
 }

 @Override
 public void getChunkAt(IChunkProvider ichunkprovider, int i, int j) {
 BlockFalling.instaFall = true;
 int k = i * 16;
 int l = j * 16;
 BiomeBase biomebase = BiomeBase.byId[layer.getValues(k + 16, l + 16, 1, 1)[0]];

 this.i.setSeed(this.n.getSeed());
 long i1 = this.i.nextLong() / 2L * 2L + 1L;
 long j1 = this.i.nextLong() / 2L * 2L + 1L;

 this.i.setSeed((long)i * i1 + (long)j * j1 ^ this.n.getSeed());
 boolean flag = false;

 if(this.o) {
 this.w.a(this.n, this.i, i, j);
 flag = this.v.a(this.n, this.i, i, j);
 this.u.a(this.n, this.i, i, j);
 this.x.a(this.n, this.i, i, j);
 }

 int k1;
 int l1;
 int i2;

 if(biomebase != BiomeBase.DESERT && biomebase != BiomeBase.DESERT_HILLS && !flag && this.i.nextInt(4) == 0) {
 k1 = k + this.i.nextInt(16) + 8;
 l1 = this.i.nextInt(256);
 i2 = l + this.i.nextInt(16) + 8;
 (new WorldGenLakes(Blocks.STATIONARY_WATER)).a(this.n, this.i, k1, l1, i2);
 }

 if(!flag && this.i.nextInt(8) == 0) {
 k1 = k + this.i.nextInt(16) + 8;
 l1 = this.i.nextInt(this.i.nextInt(248) + 8);
 i2 = l + this.i.nextInt(16) + 8;
 if(l1 < 63 || this.i.nextInt(10) == 0) {
 (new WorldGenLakes(Blocks.STATIONARY_LAVA)).a(this.n, this.i, k1, l1, i2);
 }
 }

 for(k1 = 0; k1 < 8; ++k1) {
 l1 = k + this.i.nextInt(16) + 8;
 i2 = this.i.nextInt(256);
 int j2 = l + this.i.nextInt(16) + 8;

 (new WorldGenDungeons()).a(this.n, this.i, l1, i2, j2);
 }

 biomebase.a(this.n, this.i, k, l);
 //SpawnerCreature.a(this.n, biomebase, k + 8, l + 8, 16, 16, this.i);
 //TODO!!
 k += 8;
 l += 8;

 for(k1 = 0; k1 < 16; ++k1) {
 for(l1 = 0; l1 < 16; ++l1) {
 i2 = this.n.h(k + k1, l + l1);
 if(this.n.r(k1 + k, i2 - 1, l1 + l)) {
 this.n.setTypeAndData(k1 + k, i2 - 1, l1 + l, Blocks.ICE, 0, 2);
 }

 if(this.n.e(k1 + k, i2, l1 + l, true)) {
 this.n.setTypeAndData(k1 + k, i2, l1 + l, Blocks.SNOW, 0, 2);
 }
 }
 }

 BlockFalling.instaFall = false;
 }

 public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
 return true;
 }

 public void c() {
 }

 public boolean unloadChunks() {
 return false;
 }

 public boolean canSave() {
 return true;
 }

 public String getName() {
 return "RandomLevelSource";
 }

 @Override
 public List getMobsFor(EnumCreatureType enumcreaturetype, int i, int j, int k) {
 BiomeBase biomebase = BiomeBase.byId[layer.getValues(i, k, 1, 1)[0]];

 return enumcreaturetype == EnumCreatureType.MONSTER && this.x.a(i, j, k) ? this.x.b() : biomebase.getMobs(enumcreaturetype);
 }

 @Override
 public ChunkPosition findNearestMapFeature(World world, String s, int i, int j, int k) {
 return "Stronghold".equals(s) && this.u != null ? this.u.getNearestGeneratedFeature(world, i, j, k) : null;
 }

 public int getLoadedChunks() {
 return 0;
 }

 public void recreateStructures(int i, int j) {
 if(this.o) {
 this.w.a(this, this.n, i, j, (Block[])null);
 this.v.a(this, this.n, i, j, (Block[])null);
 this.u.a(this, this.n, i, j, (Block[])null);
 this.x.a(this, this.n, i, j, (Block[])null);
 }
 }
 }
 *//*package com.tenjava.entries.mncat77.t3.generator;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;
import com.tenjava.entries.mncat77.t3.layer.BiomeLayer;
import com.tenjava.entries.mncat77.t3.populator.WorldGenDungeons;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import net.minecraft.server.v1_7_R3.BiomeMeta;
import net.minecraft.server.v1_7_R3.Block;
import net.minecraft.server.v1_7_R3.BlockFalling;
import net.minecraft.server.v1_7_R3.Blocks;
import net.minecraft.server.v1_7_R3.Chunk;
import net.minecraft.server.v1_7_R3.ChunkPosition;
import net.minecraft.server.v1_7_R3.EntityInsentient;
import net.minecraft.server.v1_7_R3.EnumCreatureType;
import net.minecraft.server.v1_7_R3.GroupDataEntity;
import net.minecraft.server.v1_7_R3.IBlockAccess;
import net.minecraft.server.v1_7_R3.IChunkProvider;
import net.minecraft.server.v1_7_R3.IProgressUpdate;
import net.minecraft.server.v1_7_R3.Material;
import net.minecraft.server.v1_7_R3.MathHelper;
import net.minecraft.server.v1_7_R3.NoiseGenerator3;
import net.minecraft.server.v1_7_R3.NoiseGeneratorOctaves;
import net.minecraft.server.v1_7_R3.WeightedRandom;
import net.minecraft.server.v1_7_R3.World;
import net.minecraft.server.v1_7_R3.WorldGenBase;
import net.minecraft.server.v1_7_R3.WorldGenCanyon;
import net.minecraft.server.v1_7_R3.WorldGenCaves;
import net.minecraft.server.v1_7_R3.WorldGenLakes;
import net.minecraft.server.v1_7_R3.WorldGenLargeFeature;
import net.minecraft.server.v1_7_R3.WorldGenMineshaft;
import net.minecraft.server.v1_7_R3.WorldGenStronghold;
import net.minecraft.server.v1_7_R3.WorldGenVillage;
import net.minecraft.server.v1_7_R3.WorldType;
import org.bukkit.craftbukkit.v1_7_R3.generator.InternalChunkGenerator;

public class HardcoreChunkGenerator extends InternalChunkGenerator {

    private static final byte waterLevel = 63;

    public static boolean canSpawnMob(EnumCreatureType enumcreaturetype, World world, int i, int j, int k) {
        if(enumcreaturetype.c() == Material.WATER) {
            return world.getType(i, j, k).getMaterial().isLiquid() && world.getType(i, j - 1, k).getMaterial().isLiquid() && !world.getType(i, j + 1, k).r();
        }
        else if(!World.a((IBlockAccess)world, i, j - 1, k)) {
            return false;
        }
        else {
            Block block = world.getType(i, j - 1, k);

            return block != Blocks.BEDROCK && !world.getType(i, j, k).r() && !world.getType(i, j, k).getMaterial().isLiquid() && !world.getType(i, j + 1, k).r();
        }
    }

    public static void spawnMobs(World world, BiomeBase biomebase, int i, int j, int k, int l, Random random) {
        List list = biomebase.getMobs(EnumCreatureType.CREATURE);

        if(!list.isEmpty()) {
            while(random.nextFloat() < biomebase.g()) {
                BiomeMeta biomemeta = (BiomeMeta)WeightedRandom.a(world.random, (Collection)list);
                GroupDataEntity groupdataentity = null;
                int i1 = biomemeta.c + random.nextInt(1 + biomemeta.d - biomemeta.c);
                int j1 = i + random.nextInt(k);
                int k1 = j + random.nextInt(l);
                int l1 = j1;
                int i2 = k1;

                for(int j2 = 0; j2 < i1; ++j2) {
                    boolean flag = false;

                    for(int k2 = 0; !flag && k2 < 4; ++k2) {
                        int l2 = world.i(j1, k1);

                        if(canSpawnMob(EnumCreatureType.CREATURE, world, j1, l2, k1)) {
                            float f = (float)j1 + 0.5F;
                            float f1 = (float)l2;
                            float f2 = (float)k1 + 0.5F;

                            EntityInsentient entityinsentient;

                            try {
                                entityinsentient = (EntityInsentient)biomemeta.b.getConstructor(new Class[]{World.class}).newInstance(new Object[]{world});
                            }
                            catch(Exception exception) {
                                exception.printStackTrace();
                                continue;
                            }

                            entityinsentient.setPositionRotation((double)f, (double)f1, (double)f2, random.nextFloat() * 360.0F, 0.0F);
                            world.addEntity(entityinsentient);
                            groupdataentity = entityinsentient.a(groupdataentity);
                            flag = true;
                        }

                        j1 += random.nextInt(5) - random.nextInt(5);

                        for(k1 += random.nextInt(5) - random.nextInt(5); j1 < i || j1 >= i + k || k1 < j || k1 >= j + k; k1 = i2 + random.nextInt(5) - random.nextInt(5)) {
                            j1 = l1 + random.nextInt(5) - random.nextInt(5);
                        }
                    }
                }
            }
        }
    }
    private int[] biomes;
    private final float[] distanceFactorMatrix5x5;
    private double[] doubles256 = new double[256];
    private final double[] doubles825;
    private WorldGenBase genCanyon = new WorldGenCanyon();
    private WorldGenBase genCaves = new WorldGenCaves();
    private WorldGenLargeFeature genLargeFeature = new WorldGenLargeFeature();
    private WorldGenMineshaft genMineshaft = new WorldGenMineshaft();
    private WorldGenStronghold genStronghold = new WorldGenStronghold();
    private WorldGenVillage genVillage = new WorldGenVillage();
    private final boolean generateFeatures;
    int[][] h = new int[32][32];
    private final BiomeLayer layer;
    private final BiomeLayer layer2;
    double[] noise16o2;
    double[] noise16o1;
    double[] noise16o3;
    double[] noise8o;
    public NoiseGeneratorOctaves noiseGen10;
    private NoiseGeneratorOctaves noiseGen161;
    private NoiseGeneratorOctaves noiseGen162;
    public NoiseGeneratorOctaves noiseGen163;
    private NoiseGeneratorOctaves noiseGen81;
    private NoiseGenerator3 noiseGen_4;
    public NoiseGeneratorOctaves noisegen82;
    private Random rand;
    private long seed;
    private World world;
    private WorldType worldType;

    public HardcoreChunkGenerator1(World world) {
        this.world = world;
        this.generateFeatures = true;
        this.seed = world.getSeed();
        this.worldType = world.getWorldData().getType();
        this.rand = new Random(seed);
        this.noiseGen161 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen162 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen81 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen_4 = new NoiseGenerator3(this.rand, 4);
        this.noiseGen10 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen163 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noisegen82 = new NoiseGeneratorOctaves(this.rand, 8);
        this.doubles825 = new double[825];
        this.distanceFactorMatrix5x5 = new float[25];

        for(int z = -2; z <= 2; ++z) {
            for(int x = -2; x <= 2; ++x) {
                float distanceFactor = 10.0F / MathHelper.c((float)(z * z + x * x) + 0.2F);

                this.distanceFactorMatrix5x5[z + 2 + (x + 2) * 5] = distanceFactor;
            }
        }

        BiomeLayer[] layers = BiomeLayer.initBiomeLayers(seed);
        this.layer = layers[0];
        this.layer2 = layers[1];
    }

    public void baseTerrain(int chunkX, int chunkZ, Block[] blocks) {
        this.biomes = this.layer2.getValues(chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
        this.getDensities(chunkX * 4, 0, chunkZ * 4);
        this.biomes = this.layer.getValues(chunkX * 16, chunkZ * 16, 16, 16);
        for(int xOuter = 0; xOuter < 4; ++xOuter) {
            int l = xOuter * 5;
            int i1 = (xOuter + 1) * 5;

            for(int zOuter = 0; zOuter < 4; ++zOuter) {
                int k1 = (l + zOuter) * 33;
                int l1 = (l + zOuter + 1) * 33;
                int i2 = (i1 + zOuter) * 33;
                int j2 = (i1 + zOuter + 1) * 33;

                for(int yOuter = 0; yOuter < 32; ++yOuter) {
                    double d0 = 0.125D;
                    double d1 = this.doubles825[k1 + yOuter];
                    double d2 = this.doubles825[l1 + yOuter];
                    double d3 = this.doubles825[i2 + yOuter];
                    double d4 = this.doubles825[j2 + yOuter];
                    double d5 = (this.doubles825[k1 + yOuter + 1] - d1) * d0;
                    double d6 = (this.doubles825[l1 + yOuter + 1] - d2) * d0;
                    double d7 = (this.doubles825[i2 + yOuter + 1] - d3) * d0;
                    double d8 = (this.doubles825[j2 + yOuter + 1] - d4) * d0;

                    for(int yInner = 0; yInner < 8; ++yInner) {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for(int xInner = 0; xInner < 4; ++xInner) {
                            int j3 = xInner + xOuter * 4 << 12 | zOuter * 4 << 8 | yOuter * 8 + yInner;
                            short short1 = 256;

                            j3 -= short1;
                            double d14 = 0.25D;
                            double d15 = (d11 - d10) * d14;
                            double d16 = d10 - d15;

                            for(int zInner = 0; zInner < 4; ++zInner) {
                                if((d16 += d15) > 0.0D) {
                                    blocks[j3 += short1] = Blocks.STONE;
                                }
                                else if(yOuter * 8 + yInner < waterLevel) {
                                    int i = (zOuter * 4 + zInner) * 16 + xInner + xOuter * 4;
                                    blocks[j3 += short1] = Blocks.STATIONARY_WATER;
                                }
                                else {
                                    blocks[j3 += short1] = null;
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void biomeMaterials(int chunkX, int chunkZ, Block[] ablock, byte[] abyte, int[] biomes) {
        double one16th = 1.0D / 16.0D;

        int realX = chunkX * 16;
        int realZ = chunkZ * 16;

        this.doubles256 = this.noiseGen_4.a(this.doubles256, (double)realX, (double)realZ, 16, 16, one16th, one16th, 1.0D);

        for(int x = 0; x < 16; ++x) {
            for(int z = 0; z < 16; ++z) {
                BiomeBase biomebase = BiomeBase.byId[biomes[z + x * 16]];

                biomebase.a(this.world, this.rand, ablock, abyte, realX + x, realZ + z, this.doubles256[z + x * 16]);
            }
        }
    }

    @Override
    public void c() {
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public ChunkPosition findNearestMapFeature(World world, String s, int i, int j, int k) {
        return "Stronghold".equals(s) && this.genStronghold != null ? this.genStronghold.getNearestGeneratedFeature(world, i, j, k) : null;
    }

    @Override
    public Chunk getChunkAt(int i, int j) {
        return this.getOrCreateChunk(i, j);
    }

    @Override
    public void getChunkAt(IChunkProvider ichunkprovider, int chunkX, int chunkZ) {
        BlockFalling.instaFall = true;
        int realX = chunkX * 16;
        int realZ = chunkZ * 16;
        BiomeBase biomebase = BiomeBase.byId[layer.getValues(realX + 16, realZ + 16, 1, 1)[0]];

        this.rand.setSeed(this.world.getSeed());
        long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        long j1 = this.rand.nextLong() / 2L * 2L + 1L;

        this.rand.setSeed((long)chunkX * i1 + (long)chunkZ * j1 ^ this.world.getSeed());
        boolean flag = false;

        if(this.generateFeatures) {
            this.genMineshaft.a(this.world, this.rand, chunkX, chunkZ);
            flag = this.genVillage.a(this.world, this.rand, chunkX, chunkZ);
            this.genStronghold.a(this.world, this.rand, chunkX, chunkZ);
            this.genLargeFeature.a(this.world, this.rand, chunkX, chunkZ);
        }

        int x;
        int z;
        //Various uses
        int tempvar;

        if(biomebase != BiomeBase.DESERT && biomebase != BiomeBase.DESERT_HILLS && !flag && this.rand.nextInt(4) == 0) {
            x = realX + this.rand.nextInt(16) + 8;
            z = this.rand.nextInt(256);
            tempvar = realZ + this.rand.nextInt(16) + 8;
            (new WorldGenLakes(Blocks.STATIONARY_WATER)).a(this.world, this.rand, x, z, tempvar);
        }
        x = realX + this.rand.nextInt(16) + 8;
        z = this.rand.nextInt(this.rand.nextInt(248) + 8);
        tempvar = realZ + this.rand.nextInt(16) + 8;
        if(z < 63 || this.rand.nextInt(10) == 0) {
            (new WorldGenLakes(Blocks.STATIONARY_LAVA)).a(this.world, this.rand, x, z, tempvar);
        }

        for(x = 0; x < 8; ++x) {
            z = realX + this.rand.nextInt(16) + 8;
            tempvar = this.rand.nextInt(256);
            int j2 = realZ + this.rand.nextInt(16) + 8;

            (new WorldGenDungeons()).a(this.world, this.rand, z, tempvar, j2);
        }

        biomebase.a(this.world, this.rand, realX, realZ);

        //Spawn Mobs
        spawnMobs(this.world, biomebase, realX + 8, realZ + 8, 16, 16, this.rand);
        realX += 8;
        realZ += 8;

        //Freeze / Snow
        for(x = 0; x < 16; x++) {
            for(z = 0; z < 16; z++) {
                tempvar = this.world.h(realX + x, realZ + z);
                if(this.world.r(x + realX, tempvar - 1, z + realZ)) {
                    this.world.setTypeAndData(x + realX, tempvar - 1, z + realZ, Blocks.ICE, 0, 2);
                }

                if(this.world.e(x + realX, tempvar, z + realZ, true)) {
                    this.world.setTypeAndData(x + realX, tempvar, z + realZ, Blocks.SNOW, 0, 2);
                }
            }
        }

        BlockFalling.instaFall = false;
    }

    private void getDensities(int chunkQuarterX, int chunkQuarterYAkaZero, int chunkQuarterZ) {
        this.noise16o3 = this.noiseGen163.a(this.noise16o3, chunkQuarterX, chunkQuarterZ, 5, 5, 200.0D, 200.0D, 0.5D);
        this.noise8o = this.noiseGen81.a(this.noise8o, chunkQuarterX, chunkQuarterYAkaZero, chunkQuarterZ, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
        this.noise16o1 = this.noiseGen161.a(this.noise16o1, chunkQuarterX, chunkQuarterYAkaZero, chunkQuarterZ, 5, 33, 5, 684.412D, 684.412D, 684.412D);
        this.noise16o2 = this.noiseGen162.a(this.noise16o2, chunkQuarterX, chunkQuarterYAkaZero, chunkQuarterZ, 5, 33, 5, 684.412D, 684.412D, 684.412D);
        int noiseIndex = 0;
        int noise3Index = 0;
        for(int x1 = 0; x1 < 5; ++x1) {
            for(int z1 = 0; z1 < 5; ++z1) {
                float factoredHeight2 = 0.0F;
                float factoredHeight1 = 0.0F;
                float factoredHeightSum = 0.0F;
                BiomeBase b1 = BiomeBase.byId[this.biomes[x1 + 2 + (z1 + 2) * 10]];
                for(int x2 = -2; x2 <= 2; ++x2) {
                    for(int z2 = -2; z2 <= 2; ++z2) {
                        BiomeBase b2 = BiomeBase.byId[this.biomes[x1 + x2 + 2 + (z1 + z2 + 2) * 10]];

                        float height1 = b2.am;
                        float height2 = b2.an;

                        float factoredHeight = this.distanceFactorMatrix5x5[x2 + 2 + (z2 + 2) * 5] / (height1 + 2.0F);

                        if(b2.am > b1.am) {
                            factoredHeight /= 2.0F;
                        }

                        factoredHeight2 += height2 * factoredHeight;
                        factoredHeight1 += height1 * factoredHeight;
                        factoredHeightSum += factoredHeight;
                    }
                }

                factoredHeight2 /= factoredHeightSum;
                factoredHeight1 /= factoredHeightSum;
                factoredHeight2 = factoredHeight2 * 0.9F + 0.1F;
                factoredHeight1 = (factoredHeight1 * 4.0F - 1.0F) / 8.0F;

                double noise3 = this.noise16o3[noise3Index] / 8000.0D;

                if(noise3 < 0.0D) {
                    noise3 = -noise3 * 0.3D;
                }

                noise3 = noise3 * 3.0D - 2.0D;
                if(noise3 < 0.0D) {
                    noise3 /= 2.0D;
                    if(noise3 < -1.0D) {
                        noise3 = -1.0D;
                    }

                    noise3 /= 1.4D;
                    noise3 /= 2.0D;
                }
                else {
                    if(noise3 > 1.0D) {
                        noise3 = 1.0D;
                    }

                    noise3 /= 8.0D;
                }

                noise3Index++;
                double d6 = (double)factoredHeight1;
                double d7 = (double)factoredHeight2;

                d6 += noise3 * 0.2D;
                d6 = d6 * 8.5D / 8.0D;
                double d8 = 8.5D + d6 * 4.0D;

                for(int y1 = 0; y1 < 33; ++y1) {
                    double d9 = ((double)y1 - d8) * 12.0D * 128.0D / 256.0D / d7;

                    if(d9 < 0.0D) {
                        d9 *= 4.0D;
                    }

                    double noise1 = this.noise16o1[noiseIndex] / 512.0D;
                    double noise2 = this.noise16o2[noiseIndex] / 512.0D;
                    double noise4 = (this.noise8o[noiseIndex] / 10.0D + 1.0D) / 2.0D;
                    double density = MathHelper.b(noise1, noise2, noise4) - d9;

                    if(y1 > 29) {
                        double d14 = (double)((float)(y1 - 29) / 3.0F);

                        density = density * (1.0D - d14) + -10.0D * d14;
                    }

                    this.doubles825[noiseIndex] = density;
                    noiseIndex++;
                }
            }
        }
    }


    /*private void getDensities(int chunkQuarterX, int chunkQuarterYAkaZero, int chunkQuarterZ) {
     this.noise16o3 = this.noiseGen163.a(this.noise16o3, chunkQuarterX, chunkQuarterZ, 5, 5, 200.0D, 200.0D, 0.5D);
     this.noise8o = this.noiseGen81.a(this.noise8o, chunkQuarterX, chunkQuarterYAkaZero, chunkQuarterZ, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
     this.noise16o1 = this.noiseGen161.a(this.noise16o1, chunkQuarterX, chunkQuarterYAkaZero, chunkQuarterZ, 5, 33, 5, 684.412D, 684.412D, 684.412D);
     this.noise1602 = this.noiseGen162.a(this.noise1602, chunkQuarterX, chunkQuarterYAkaZero, chunkQuarterZ, 5, 33, 5, 684.412D, 684.412D, 684.412D);
     int noiseIndex = 0;
     int noise3Index = 0;
     for(int x1 = 0; x1 < 5; ++x1) {
     for(int z1 = 0; z1 < 5; ++z1) {
     float factoredHeight2 = 0.0F;
     float factoredHeight1 = 0.0F;
     float factoredHeightSum = 0.0F;
     BiomeBase b1 = BiomeBase.byId[this.biomes[x1 + 2 + (z1 + 2) * 10]];
     for(int x2 = -2; x2 <= 2; ++x2) {
     for(int z2 = -2; z2 <= 2; ++z2) {
     BiomeBase b2 = BiomeBase.byId[this.biomes[x1 + x2 + 2 + (z1 + z2 + 2) * 10]];

     float height1 = b2.am;
     float height2 = b2.an;

     float factoredHeight = this.distanceFactorMatrix5x5[x2 + 2 + (z2 + 2) * 5] / (height1 + 2.0F);

     if(b2.am > b1.am) {
     factoredHeight /= 2.0F;
     }

     factoredHeight2 += height2 * factoredHeight;
     factoredHeight1 += height1 * factoredHeight;
     factoredHeightSum += factoredHeight;
     }
     }

     factoredHeight2 /= factoredHeightSum;
     factoredHeight1 /= factoredHeightSum;
     factoredHeight2 = factoredHeight2 * 0.9F + 0.1F;
     factoredHeight1 = (factoredHeight1 * 4.0F - 1.0F) / 8.0F;

     double noise3 = this.noise16o3[noise3Index] / 8000.0D;

     if(noise3 < 0.0D) {
     noise3 = -noise3 * 0.3D;
     }

     noise3 = noise3 * 3.0D - 2.0D;
     if(noise3 < 0.0D) {
     noise3 /= 2.0D;
     if(noise3 < -1.0D) {
     noise3 = -1.0D;
     }

     noise3 /= 1.4D;
     noise3 /= 2.0D;
     }
     else {
     if(noise3 > 1.0D) {
     noise3 = 1.0D;
     }

     noise3 /= 8.0D;
     }

     noise3Index++;
     double d6 = (double)factoredHeight1;
     double d7 = (double)factoredHeight2;

     d6 += noise3 * 0.2D;
     d6 = d6 * 8.5D / 8.0D;
     double d8 = 8.5D + d6 * 4.0D;

     for(int y1 = 0; y1 < 33; ++y1) {
     double d9 = ((double)y1 - d8) * 12.0D * 128.0D / 256.0D / d7;

     if(d9 < 0.0D) {
     d9 *= 4.0D;
     }

     double noise1 = this.noise16o1[noiseIndex] / 512.0D;
     double noise2 = this.noise1602[noiseIndex] / 512.0D;
     double noise4 = (this.noise8o[noiseIndex] / 10.0D + 1.0D) / 2.0D;
     double density = MathHelper.b(noise1, noise2, noise4) - d9;

     if(y1 > 29) {
     double d14 = (double)((float)(y1 - 29) / 3.0F);

     density = density * (1.0D - d14) + -10.0D * d14;
     }

     this.doubles825[noiseIndex] = density;
     noiseIndex++;
     }
     }
     }
     }*//*
    @Override
    public int getLoadedChunks() {
        return 0;
    }

    @Override
    public List getMobsFor(EnumCreatureType enumcreaturetype, int x, int y, int z) {
        BiomeBase biomebase = BiomeBase.byId[layer.getValues(x, z, 1, 1)[0]];

        return enumcreaturetype == EnumCreatureType.MONSTER && this.genLargeFeature.a(x, y, z) ? this.genLargeFeature.b() : biomebase.getMobs(enumcreaturetype);
    }

    @Override
    public String getName() {
        return "HardcoreChunkGenerator";
    }

    @Override
    public Chunk getOrCreateChunk(int chunkX, int chunkZ) {
        this.rand.setSeed((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);
        //65536 = 16 * 16 * 256
        Block[] blocks = new Block[65536];
        byte[] types = new byte[65536];

        this.baseTerrain(chunkX, chunkZ, blocks);

        this.biomeMaterials(chunkX, chunkZ, blocks, types, this.biomes);

        //Populate
        this.genCaves.a(this, this.world, chunkX, chunkZ, blocks);
        this.genCanyon.a(this, this.world, chunkX, chunkZ, blocks);
        if(this.generateFeatures) {
            this.genMineshaft.a(this, this.world, chunkX, chunkZ, blocks);
            this.genVillage.a(this, this.world, chunkX, chunkZ, blocks);
            this.genStronghold.a(this, this.world, chunkX, chunkZ, blocks);
            this.genLargeFeature.a(this, this.world, chunkX, chunkZ, blocks);
        }

        Chunk chunk = new Chunk(this.world, blocks, types, chunkX, chunkZ);
        byte[] cBiomes = chunk.m();

        chunk.initLighting();
        return chunk;
    }

    @Override
    public boolean isChunkLoaded(int i, int j) {
        return true;
    }

    @Override
    public void recreateStructures(int i, int j) {
        if(this.generateFeatures) {
            this.genMineshaft.a(this, this.world, i, j, (Block[])null);
            this.genVillage.a(this, this.world, i, j, (Block[])null);
            this.genStronghold.a(this, this.world, i, j, (Block[])null);
            this.genLargeFeature.a(this, this.world, i, j, (Block[])null);
        }
    }

    @Override
    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
        return true;
    }

    @Override
    public boolean unloadChunks() {
        return false;
    }

}
*/
