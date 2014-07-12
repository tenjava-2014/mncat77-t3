package com.tenjava.entries.mncat77.t3.layer.scrap;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;

public class BiomeLayerPlains extends BiomeLayer {

    public BiomeLayerPlains(long seed, BiomeLayer parent) {
        super(seed, parent);
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int[] parentValues = this.parent.getValues(realX - 1, realZ - 1, width + 2, length + 2);
        int[] values = new int[width * length];

        for(int z = 0; z < length; ++z) {
            for(int x = 0; x < width; ++x) {
                this.initChunkSeed(x + realX, z + realZ);
                int parentValue = parentValues[x + 1 + (z + 1) * (width + 2)];

                if(this.nextInt(57) == 0) {
                    if(parentValue == BiomeBase.PLAINS.id) {
                        values[x + z * width] = BiomeBase.PLAINS.id + 128;
                    }
                    else {
                        values[x + z * width] = parentValue;
                    }
                }
                else {
                    values[x + z * width] = parentValue;
                }
            }
        }

        return values;
    }
}
