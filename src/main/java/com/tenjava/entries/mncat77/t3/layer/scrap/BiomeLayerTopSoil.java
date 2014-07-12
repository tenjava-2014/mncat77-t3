package com.tenjava.entries.mncat77.t3.layer.scrap;

public class BiomeLayerTopSoil extends BiomeLayer {

    public BiomeLayerTopSoil(long seed, BiomeLayer parent) {
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
                int k2 = parentValues[x + 1 + (z + 1) * parentRectWidth];

                this.initChunkSeed(x + realX, z + realZ);
                if(k2 == 0) {
                    values[x + z * width] = 0;
                }
                else {
                    int rand = this.nextInt(6);
                    int value;

                    if(rand == 0) {
                        value = 4;
                    }
                    else if(rand <= 1) {
                        value = 3;
                    }
                    else {
                        value = 1;
                    }

                    values[x + z * width] = value;
                }
            }
        }

        return values;
    }
}
