package com.tenjava.entries.mncat77.t3.biome;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.v1_7_R3.Block;
import net.minecraft.server.v1_7_R3.EnumTemperature;
import net.minecraft.server.v1_7_R3.World;
import net.minecraft.server.v1_7_R3.WorldGenTreeAbstract;

public class BiomeBaseSub extends BiomeBase {

    protected BiomeBase aD;

    public BiomeBaseSub(int i, BiomeBase biomebase) {
        super(i);
        this.aD = biomebase;
        this.a(biomebase.ag, true);
        this.af = biomebase.af + " M";
        this.topBlock = biomebase.topBlock;
        this.fillerBlock = biomebase.fillerBlock;
        this.al = biomebase.al;
        this.am = biomebase.am;
        this.an = biomebase.an;
        this.temperature = biomebase.temperature;
        this.humidity = biomebase.humidity;
        this.aq = biomebase.aq;
        this.aw = biomebase.aw;
        this.ax = biomebase.ax;
        this.at = new ArrayList(biomebase.at);
        this.as = new ArrayList(biomebase.as);
        this.av = new ArrayList(biomebase.av);
        this.au = new ArrayList(biomebase.au);
        this.temperature = biomebase.temperature;
        this.humidity = biomebase.humidity;
        this.am = biomebase.am + 0.1F;
        this.an = biomebase.an + 0.2F;
    }

    @Override
    public void a(World world, Random random, int i, int j) {
        this.aD.decorator.a(world, random, this, i, j);
    }

    public void a(World world, Random random, Block[] ablock, byte[] abyte, int i, int j, double d0) {
        this.aD.a(world, random, ablock, abyte, i, j, d0);
    }

    @Override
    public float g() {
        return this.aD.g();
    }

    public WorldGenTreeAbstract a(Random random) {
        return this.aD.getTreeGen(random);
    }

    @Override
    public Class l() {
        return this.aD.l();
    }

    @Override
    public boolean a(BiomeBase biomebase) {
        return this.aD.a(biomebase);
    }

    @Override
    public EnumTemperature m() {
        return this.aD.m();
    }
}
