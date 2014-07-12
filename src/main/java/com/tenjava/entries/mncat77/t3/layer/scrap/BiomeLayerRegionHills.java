package com.tenjava.entries.mncat77.t3.layer.scrap;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;

public class BiomeLayerRegionHills extends BiomeLayer {

    private final BiomeLayer parent2;

    public BiomeLayerRegionHills(long seed, BiomeLayer parent1, BiomeLayer parent2) {
        super(seed, parent1);
        this.parent2 = parent2;
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int[] parent1Values = this.parent.getValues(realX - 1, realZ - 1, width + 2, length + 2);
        int[] parent2Values = this.parent2.getValues(realX - 1, realZ - 1, width + 2, length + 2);
        int[] values = new int[width * length];

        for(int z = 0; z < length; ++z) {
            for(int x = 0; x < width; ++x) {
                this.initChunkSeed(x + realX, z + realZ);
                int parent1Value1 = parent1Values[x + 1 + (z + 1) * (width + 2)];
                int parent2Value1 = parent2Values[x + 1 + (z + 1) * (width + 2)];
                boolean flag = (parent2Value1 - 2) % 29 == 0;

                if(parent1Value1 != 0 && parent2Value1 >= 2 && (parent2Value1 - 2) % 29 == 1 && parent1Value1 < 128) {
                    if(BiomeBase.getBiome(parent1Value1 + 128) != null) {
                        values[x + z * width] = parent1Value1 + 128;
                    }
                    else {
                        values[x + z * width] = parent1Value1;
                    }
                }
                else if(this.nextInt(3) != 0 && !flag) {
                    values[x + z * width] = parent1Value1;
                }
                else {
                    int cache1 = parent1Value1;
                    int cache2;

                    if(parent1Value1 == BiomeBase.DESERT.id) {
                        cache1 = BiomeBase.DESERT_HILLS.id;
                    }
                    else if(parent1Value1 == BiomeBase.FOREST.id) {
                        cache1 = BiomeBase.FOREST_HILLS.id;
                    }
                    else if(parent1Value1 == BiomeBase.BIRCH_FOREST.id) {
                        cache1 = BiomeBase.BIRCH_FOREST_HILLS.id;
                    }
                    else if(parent1Value1 == BiomeBase.ROOFED_FOREST.id) {
                        cache1 = BiomeBase.PLAINS.id;
                    }
                    else if(parent1Value1 == BiomeBase.TAIGA.id) {
                        cache1 = BiomeBase.TAIGA_HILLS.id;
                    }
                    else if(parent1Value1 == BiomeBase.MEGA_TAIGA.id) {
                        cache1 = BiomeBase.MEGA_TAIGA_HILLS.id;
                    }
                    else if(parent1Value1 == BiomeBase.COLD_TAIGA.id) {
                        cache1 = BiomeBase.COLD_TAIGA_HILLS.id;
                    }
                    else if(parent1Value1 == BiomeBase.PLAINS.id) {
                        if(this.nextInt(3) == 0) {
                            cache1 = BiomeBase.FOREST_HILLS.id;
                        }
                        else {
                            cache1 = BiomeBase.FOREST.id;
                        }
                    }
                    else if(parent1Value1 == BiomeBase.ICE_PLAINS.id) {
                        cache1 = BiomeBase.ICE_MOUNTAINS.id;
                    }
                    else if(parent1Value1 == BiomeBase.JUNGLE.id) {
                        cache1 = BiomeBase.JUNGLE_HILLS.id;
                    }
                    else if(parent1Value1 == BiomeBase.OCEAN.id) {
                        cache1 = BiomeBase.DEEP_OCEAN.id;
                    }
                    else if(parent1Value1 == BiomeBase.EXTREME_HILLS.id) {
                        cache1 = BiomeBase.EXTREME_HILLS_PLUS.id;
                    }
                    else if(parent1Value1 == BiomeBase.SAVANNA.id) {
                        cache1 = BiomeBase.SAVANNA_PLATEAU.id;
                    }
                    else if(biomeEquals(parent1Value1, BiomeBase.MESA_PLATEAU_F.id)) {
                        cache1 = BiomeBase.MESA.id;
                    }
                    else if(parent1Value1 == BiomeBase.DEEP_OCEAN.id && this.nextInt(3) == 0) {
                        cache2 = this.nextInt(2);
                        if(cache2 == 0) {
                            cache1 = BiomeBase.PLAINS.id;
                        }
                        else {
                            cache1 = BiomeBase.FOREST.id;
                        }
                    }

                    if(flag && cache1 != parent1Value1) {
                        if(BiomeBase.getBiome(cache1 + 128) != null) {
                            cache1 += 128;
                        }
                        else {
                            cache1 = parent1Value1;
                        }
                    }

                    if(cache1 == parent1Value1) {
                        values[x + z * width] = parent1Value1;
                    }
                    else {
                        cache2 = parent1Values[x + 1 + (z + 1 - 1) * (width + 2)];
                        int parent1Value2 = parent1Values[x + 1 + 1 + (z + 1) * (width + 2)];
                        int parent1Value3 = parent1Values[x + 1 - 1 + (z + 1) * (width + 2)];
                        int parent1Value4 = parent1Values[x + 1 + (z + 1 + 1) * (width + 2)];
                        //And another one of these field names...
                        int surroundingTilesEqualBiomeCount = 0;

                        if(biomeEquals(cache2, parent1Value1)) {
                            ++surroundingTilesEqualBiomeCount;
                        }

                        if(biomeEquals(parent1Value2, parent1Value1)) {
                            ++surroundingTilesEqualBiomeCount;
                        }

                        if(biomeEquals(parent1Value3, parent1Value1)) {
                            ++surroundingTilesEqualBiomeCount;
                        }

                        if(biomeEquals(parent1Value4, parent1Value1)) {
                            ++surroundingTilesEqualBiomeCount;
                        }

                        if(surroundingTilesEqualBiomeCount >= 3) {
                            values[x + z * width] = cache1;
                        }
                        else {
                            values[x + z * width] = parent1Value1;
                        }
                    }
                }
            }
        }

        return values;
    }
}
