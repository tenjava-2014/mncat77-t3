package com.tenjava.entries.mncat77.t3.layer.scrap;

import com.tenjava.entries.mncat77.t3.biome.BiomeBase;

public class BiomeLayerDeepOcean extends BiomeLayer {

    public BiomeLayerDeepOcean(long seed, BiomeLayer parent) {
        super(seed, parent);
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int parentRectX = realX - 1;
        int parentRectZ = realZ - 1;
        int parentRectWidth = width + 2;
        int parentRectLength = length + 2;
        int[] parentValues = this.parent.getValues(parentRectX, parentRectZ, parentRectWidth, parentRectLength);
        int[] values = new int[width * length];

        for(int z = 0; z < length; ++z) {
            for(int x = 0; x < width; ++x) {
                int parentValue1 = parentValues[x + 1 + z * (width + 2)];
                int parentValue2 = parentValues[x + 2 + (z + 1) * (width + 2)];
                int parentValue3 = parentValues[x + (z + 1) * (width + 2)];
                int parentValue4 = parentValues[x + 1 + (z + 2) * (width + 2)];
                int parentValue5 = parentValues[x + 1 + (z + 1) * parentRectWidth];
                //What kind of variable name is this?
                int surroundingOceanTileCount = 0;

                if(parentValue1 == 0) {
                    ++surroundingOceanTileCount;
                }

                if(parentValue2 == 0) {
                    ++surroundingOceanTileCount;
                }

                if(parentValue3 == 0) {
                    ++surroundingOceanTileCount;
                }

                if(parentValue4 == 0) {
                    ++surroundingOceanTileCount;
                }

                if(parentValue5 == 0 && surroundingOceanTileCount > 3) {
                    values[x + z * width] = BiomeBase.DEEP_OCEAN.id;
                }
                else {
                    values[x + z * width] = parentValue5;
                }
            }
        }

        return values;
    }
}
