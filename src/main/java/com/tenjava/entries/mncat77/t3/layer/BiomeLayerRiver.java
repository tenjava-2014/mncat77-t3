package com.tenjava.entries.mncat77.t3.layer;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;

public class BiomeLayerRiver extends BiomeLayer {

    public BiomeLayerRiver(long seed, BiomeLayer parent) {
        super(seed, parent);
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int i1 = realX - 1;
        int j1 = realZ - 1;
        int k1 = width + 2;
        int l1 = length + 2;
        int[] parentValues = this.parent.getValues(i1, j1, k1, l1);
        int[] values = new int[width * length];

        for(int z = 0; z < length; ++z) {
            for(int x = 0; x < width; ++x) {
                int parentValue1 = this.c(parentValues[x + (z + 1) * k1]);
                int parentValue2 = this.c(parentValues[x + 2 + (z + 1) * k1]);
                int parentValue3 = this.c(parentValues[x + 1 + z * k1]);
                int parentValue4 = this.c(parentValues[x + 1 + (z + 2) * k1]);
                int parentValue5 = this.c(parentValues[x + 1 + (z + 1) * k1]);

                if(parentValue5 == parentValue1 && parentValue5 == parentValue3 && parentValue5 == parentValue2 && parentValue5 == parentValue4) {
                    values[x + z * width] = -1;
                }
                else {
                    values[x + z * width] = BiomeBase.RIVER.id;
                }
            }
        }

        return values;
    }

    private int c(int i) {
        return i >= 2 ? 2 + (i & 1) : i;
    }
}
