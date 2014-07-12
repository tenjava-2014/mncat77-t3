package com.tenjava.entries.mncat77.t3.layer;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;

public class BiomeLayerRiverMix extends BiomeLayer {

    private final BiomeLayer layerBiome;
    private final BiomeLayer layerRiver;

    public BiomeLayerRiverMix(long i, BiomeLayer genlayer, BiomeLayer genlayer1) {
        super(i);
        this.layerBiome = genlayer;
        this.layerRiver = genlayer1;
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int[] parentBiomeValues = this.layerBiome.getValues(realX, realZ, width, length);
        int[] parentRiverValues = this.layerRiver.getValues(realX, realZ, width, length);
        int[] values = new int[width * length];

        for(int index = 0; index < width * length; ++index) {
            if(parentBiomeValues[index] != BiomeBase.OCEAN.id && parentBiomeValues[index] != BiomeBase.DEEP_OCEAN.id) {
                if(parentRiverValues[index] == BiomeBase.RIVER.id) {
                    if(parentBiomeValues[index] == BiomeBase.ICE_PLAINS.id) {
                        values[index] = BiomeBase.FROZEN_RIVER.id;
                    }
                    else if(parentBiomeValues[index] != BiomeBase.MUSHROOM_ISLAND.id && parentBiomeValues[index] != BiomeBase.MUSHROOM_SHORE.id) {
                        values[index] = parentRiverValues[index] & 255;
                    }
                    else {
                        values[index] = BiomeBase.MUSHROOM_SHORE.id;
                    }
                }
                else {
                    values[index] = parentBiomeValues[index];
                }
            }
            else {
                values[index] = parentBiomeValues[index];
            }
        }

        return values;
    }
}
