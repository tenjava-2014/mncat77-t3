package com.tenjava.entries.mncat77.t3.layer;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;

public class BiomeLayerBiome extends BiomeLayer {

    private BiomeBase[] dryBiomes;
    private BiomeBase[] wetBiomes;
    private BiomeBase[] neutralBiomes;
    private BiomeBase[] coldBiomes;

    public BiomeLayerBiome(long seed, BiomeLayer parent) {
        super(seed, parent);
        this.dryBiomes = new BiomeBase[]{BiomeBase.DESERT, BiomeBase.DESERT, BiomeBase.DESERT, BiomeBase.SAVANNA, BiomeBase.SAVANNA, BiomeBase.PLAINS};
        this.wetBiomes = new BiomeBase[]{BiomeBase.FOREST, BiomeBase.ROOFED_FOREST, BiomeBase.EXTREME_HILLS, BiomeBase.PLAINS, BiomeBase.BIRCH_FOREST, BiomeBase.SWAMPLAND};
        this.neutralBiomes = new BiomeBase[]{BiomeBase.FOREST, BiomeBase.EXTREME_HILLS, BiomeBase.TAIGA, BiomeBase.PLAINS};
        this.coldBiomes = new BiomeBase[]{BiomeBase.ICE_PLAINS, BiomeBase.ICE_PLAINS, BiomeBase.ICE_PLAINS, BiomeBase.COLD_TAIGA};
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int[] parentValues = this.parent.getValues(realX, realZ, width, length);
        int[] values = new int[width * length];

        for(int z = 0; z < length; ++z) {
            for(int x = 0; x < width; ++x) {
                this.initChunkSeed(x + realX, z + realZ);
                int parentValue = parentValues[x + z * width];
                int l1 = (parentValue & 3840) >> 8;

                parentValue &= -3841;
                if(this.isBiomeOcean(parentValue)) {
                    values[x + z * width] = parentValue;
                }
                else if(parentValue == 1) {
                    if(l1 > 0) {
                        if(this.nextInt(3) == 0) {
                            values[x + z * width] = BiomeBase.MESA_PLATEAU.id;
                        }
                        else {
                            values[x + z * width] = BiomeBase.MESA_PLATEAU_F.id;
                        }
                    }
                    else {
                        values[x + z * width] = this.dryBiomes[this.nextInt(this.dryBiomes.length)].id;
                    }
                }
                else if(parentValue == 2) {
                    if(l1 > 0) {
                        values[x + z * width] = BiomeBase.JUNGLE.id;
                    }
                    else {
                        values[x + z * width] = this.wetBiomes[this.nextInt(this.wetBiomes.length)].id;
                    }
                }
                else if(parentValue == 3) {
                    if(l1 > 0) {
                        values[x + z * width] = BiomeBase.MEGA_TAIGA.id;
                    }
                    else {
                        values[x + z * width] = this.neutralBiomes[this.nextInt(this.neutralBiomes.length)].id;
                    }
                }
                else if(parentValue == 4) {
                    values[x + z * width] = this.coldBiomes[this.nextInt(this.coldBiomes.length)].id;
                }
                else {
                    //No mushroom islands
                    values[x + z * width] = BiomeBase.OCEAN.id;
                }
            }
        }

        return values;
    }
}
