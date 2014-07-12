package com.tenjava.entries.mncat77.t3.layer;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;
import net.minecraft.server.v1_7_R3.EnumTemperature;

public class BiomeLayerDesert extends BiomeLayer {

    public BiomeLayerDesert(long seed, BiomeLayer parent) {
        super(seed, parent);
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int[] parentValues = this.parent.getValues(realX - 1, realZ - 1, width + 2, length + 2);
        int[] values = new int[width * length];

        for(int z = 0; z < length; ++z) {
            for(int x = 0; x < width; ++x) {
                this.initChunkSeed(x + realX, z + realZ);
                int parentValue1 = parentValues[x + 1 + (z + 1) * (width + 2)];

                if(!this.a(parentValues, values, x, z, width, parentValue1, BiomeBase.EXTREME_HILLS.id, BiomeBase.SMALL_MOUNTAINS.id) && !this.b(parentValues, values, x, z, width, parentValue1, BiomeBase.MESA_PLATEAU_F.id, BiomeBase.MESA.id) && !this.b(parentValues, values, x, z, width, parentValue1, BiomeBase.MESA_PLATEAU.id, BiomeBase.MESA.id) && !this.b(parentValues, values, x, z, width, parentValue1, BiomeBase.MEGA_TAIGA.id, BiomeBase.TAIGA.id)) {
                    int parentValue2;
                    int parentValue3;
                    int parentValue4;
                    int parentValue5;

                    if(parentValue1 == BiomeBase.DESERT.id) {
                        parentValue2 = parentValues[x + 1 + (z + 1 - 1) * (width + 2)];
                        parentValue3 = parentValues[x + 1 + 1 + (z + 1) * (width + 2)];
                        parentValue4 = parentValues[x + 1 - 1 + (z + 1) * (width + 2)];
                        parentValue5 = parentValues[x + 1 + (z + 1 + 1) * (width + 2)];
                        if(parentValue2 != BiomeBase.ICE_PLAINS.id && parentValue3 != BiomeBase.ICE_PLAINS.id && parentValue4 != BiomeBase.ICE_PLAINS.id && parentValue5 != BiomeBase.ICE_PLAINS.id) {
                            values[x + z * width] = parentValue1;
                        }
                        else {
                            values[x + z * width] = BiomeBase.EXTREME_HILLS_PLUS.id;
                        }
                    }
                    else if(parentValue1 == BiomeBase.SWAMPLAND.id) {
                        parentValue2 = parentValues[x + 1 + (z + 1 - 1) * (width + 2)];
                        parentValue3 = parentValues[x + 1 + 1 + (z + 1) * (width + 2)];
                        parentValue4 = parentValues[x + 1 - 1 + (z + 1) * (width + 2)];
                        parentValue5 = parentValues[x + 1 + (z + 1 + 1) * (width + 2)];
                        if(parentValue2 != BiomeBase.DESERT.id && parentValue3 != BiomeBase.DESERT.id && parentValue4 != BiomeBase.DESERT.id && parentValue5 != BiomeBase.DESERT.id && parentValue2 != BiomeBase.COLD_TAIGA.id && parentValue3 != BiomeBase.COLD_TAIGA.id && parentValue4 != BiomeBase.COLD_TAIGA.id && parentValue5 != BiomeBase.COLD_TAIGA.id && parentValue2 != BiomeBase.ICE_PLAINS.id && parentValue3 != BiomeBase.ICE_PLAINS.id && parentValue4 != BiomeBase.ICE_PLAINS.id && parentValue5 != BiomeBase.ICE_PLAINS.id) {
                            if(parentValue2 != BiomeBase.JUNGLE.id && parentValue5 != BiomeBase.JUNGLE.id && parentValue3 != BiomeBase.JUNGLE.id && parentValue4 != BiomeBase.JUNGLE.id) {
                                values[x + z * width] = parentValue1;
                            }
                            else {
                                values[x + z * width] = BiomeBase.JUNGLE_EDGE.id;
                            }
                        }
                        else {
                            values[x + z * width] = BiomeBase.PLAINS.id;
                        }
                    }
                    else {
                        values[x + z * width] = parentValue1;
                    }
                }
            }
        }

        return values;
    }

    private boolean a(int[] aint, int[] aint1, int i, int j, int k, int l, int i1, int j1) {
        if(!biomeEquals(l, i1)) {
            return false;
        }
        else {
            int k1 = aint[i + 1 + (j + 1 - 1) * (k + 2)];
            int l1 = aint[i + 1 + 1 + (j + 1) * (k + 2)];
            int i2 = aint[i + 1 - 1 + (j + 1) * (k + 2)];
            int j2 = aint[i + 1 + (j + 1 + 1) * (k + 2)];

            if(this.biomeTemperatureEquals(k1, i1) && this.biomeTemperatureEquals(l1, i1) && this.biomeTemperatureEquals(i2, i1) && this.biomeTemperatureEquals(j2, i1)) {
                aint1[i + j * k] = l;
            }
            else {
                aint1[i + j * k] = j1;
            }

            return true;
        }
    }

    private boolean b(int[] aint, int[] aint1, int i, int j, int k, int l, int i1, int j1) {
        if(l != i1) {
            return false;
        }
        else {
            int k1 = aint[i + 1 + (j + 1 - 1) * (k + 2)];
            int l1 = aint[i + 1 + 1 + (j + 1) * (k + 2)];
            int i2 = aint[i + 1 - 1 + (j + 1) * (k + 2)];
            int j2 = aint[i + 1 + (j + 1 + 1) * (k + 2)];

            if(biomeEquals(k1, i1) && biomeEquals(l1, i1) && biomeEquals(i2, i1) && biomeEquals(j2, i1)) {
                aint1[i + j * k] = l;
            }
            else {
                aint1[i + j * k] = j1;
            }

            return true;
        }
    }

    private boolean biomeTemperatureEquals(int i, int j) {
        if(biomeEquals(i, j)) {
            return true;
        }
        else if(BiomeBase.getBiome(i) != null && BiomeBase.getBiome(j) != null) {
            EnumTemperature enumtemperature = BiomeBase.getBiome(i).m();
            EnumTemperature enumtemperature1 = BiomeBase.getBiome(j).m();

            return enumtemperature == enumtemperature1 || enumtemperature == EnumTemperature.MEDIUM || enumtemperature1 == EnumTemperature.MEDIUM;
        }
        else {
            return false;
        }
    }
}
