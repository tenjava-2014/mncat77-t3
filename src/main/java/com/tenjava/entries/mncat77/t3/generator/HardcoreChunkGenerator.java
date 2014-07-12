package com.tenjava.entries.mncat77.t3.generator;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;
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
import net.minecraft.server.v1_7_R3.GenLayer;
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
    private final WorldGenBase genCanyon = new WorldGenCanyon();
    private final WorldGenBase genCaves = new WorldGenCaves();
    private final WorldGenLargeFeature genLargeFeature = new WorldGenLargeFeature();
    private final WorldGenMineshaft genMineshaft = new WorldGenMineshaft();
    private final WorldGenStronghold genStronghold = new WorldGenStronghold();
    private final WorldGenVillage genVillage = new WorldGenVillage();
    private final boolean generateFeatures;
    private final GenLayer layer;
    private final GenLayer layer2;
    private double[] noise1602;
    private double[] noise16o1;
    private double[] noise16o3;
    private double[] noise8o;
    private final NoiseGeneratorOctaves noiseGen161;
    private final NoiseGeneratorOctaves noiseGen162;
    private final NoiseGeneratorOctaves noiseGen163;
    private final NoiseGeneratorOctaves noiseGen81;
    private final NoiseGenerator3 noiseGen_4;
    private final Random rand;
    private final World world;

    public HardcoreChunkGenerator(World world) {
        this.world = world;
        GenLayer[] layers = GenLayer.a(world.getSeed(), world.getWorldData().getType());
        this.layer = layers[1];
        this.layer2 = layers[0];
        this.generateFeatures = true;
        this.rand = new Random(this.world.getSeed());
        this.noiseGen161 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen162 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen81 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen_4 = new NoiseGenerator3(this.rand, 4);
        this.noiseGen163 = new NoiseGeneratorOctaves(this.rand, 16);
        this.doubles825 = new double[825];
        this.distanceFactorMatrix5x5 = new float[25];

        for(int x = -2; x <= 2; ++x) {
            for(int z = -2; z <= 2; ++z) {
                float distanceFactor = 10.0F / MathHelper.c((float)(x * x + z * z) + 0.2F);

                this.distanceFactorMatrix5x5[x + 2 + (z + 2) * 5] = distanceFactor;
            }
        }
    }

    public void baseTerrain(int chunkX, int chunkZ, Block[] ablock) {
        this.biomes = this.layer2.a(chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
        this.getDensities(chunkX * 4, 0, chunkZ * 4);
        this.biomes = this.layer.a(chunkX * 16, chunkZ * 16, 16, 16);
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
                                    ablock[j3 += short1] = Blocks.STONE;
                                }
                                else if(yOuter * 8 + yInner < waterLevel) {
                                    int i = (zOuter * 4 + zInner) * 16 + xInner + xOuter * 4;
                                    ablock[j3 += short1] = Blocks.STATIONARY_LAVA;
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

    //Give the blocks their appropriate materials
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
    public Chunk getChunkAt(int chunkX, int chunkZ) {
        return this.getOrCreateChunk(chunkX, chunkZ);
    }

    @Override
    public void getChunkAt(IChunkProvider ichunkprovider, int chunkX, int chunkZ) {
        BlockFalling.instaFall = true;
        int realX = chunkX * 16;
        int realZ = chunkZ * 16;
        BiomeBase biomebase = BiomeBase.byId[layer.a(realX + 16, realZ + 16, 1, 1)[0]];

        this.rand.setSeed(this.world.getSeed());
        long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        long j1 = this.rand.nextLong() / 2L * 2L + 1L;

        this.rand.setSeed((long)chunkX * i1 + (long)chunkZ * j1 ^ this.world.getSeed());
        boolean flag = false;

        //Populate
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
        if(!flag && this.rand.nextInt(8) == 0) {
            x = realX + this.rand.nextInt(16) + 8;
            z = this.rand.nextInt(this.rand.nextInt(248) + 8);
            tempvar = realZ + this.rand.nextInt(16) + 8;
            if(z < 63 || this.rand.nextInt(10) == 0) {
                (new WorldGenLakes(Blocks.STATIONARY_LAVA)).a(this.world, this.rand, x, z, tempvar);
            }
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

    //Calculates Densities with the smaller biome layer (1/4th of actual biomes for efficiency)
    private void getDensities(int chunkQuarterX, int chunkQuarterYAkaZero, int chunkQuarterZ) {
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

                        if(height1 > 0.0F) {
                            height1 = 1.0F + height1 * 2.0F;
                            height2 = 1.0F + height2 * 4.0F;
                        }
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
    }

    @Override
    public int getLoadedChunks() {
        return 0;
    }

    @Override
    public List getMobsFor(EnumCreatureType enumcreaturetype, int x, int y, int z) {
        BiomeBase biomebase = BiomeBase.byId[layer.a(x, z, 1, 1)[0]];

        return enumcreaturetype == EnumCreatureType.MONSTER && this.genLargeFeature.a(x, y, z) ? this.genLargeFeature.b() : biomebase.getMobs(enumcreaturetype);
    }

    @Override
    public String getName() {
        return "HardcoreChunkGenerator";
    }

    //Start here...
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
    public boolean isChunkLoaded(int chunkX, int chunkZ) {
        return true;
    }

    @Override
    public void recreateStructures(int chunkX, int chunkZ) {
        if(this.generateFeatures) {
            this.genMineshaft.a(this, this.world, chunkX, chunkZ, (Block[])null);
            this.genVillage.a(this, this.world, chunkX, chunkZ, (Block[])null);
            this.genStronghold.a(this, this.world, chunkX, chunkZ, (Block[])null);
            this.genLargeFeature.a(this, this.world, chunkX, chunkZ, (Block[])null);
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
