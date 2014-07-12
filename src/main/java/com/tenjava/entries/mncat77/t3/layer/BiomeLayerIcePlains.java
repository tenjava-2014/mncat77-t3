package com.tenjava.entries.mncat77.t3.layer;

public class BiomeLayerIcePlains extends BiomeLayer {

    public BiomeLayerIcePlains(long seed, BiomeLayer parent) {
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
                int parentValue1 = parentValues[x + 1 + (z) * (width + 2)];
                int parentValue2 = parentValues[x + 2 + (z + 1) * (width + 2)];
                int parentValue3 = parentValues[x + (z + 1) * (width + 2)];
                int parentValue4 = parentValues[x + 1 + (z + 2) * (width + 2)];
                int parentValue5 = parentValues[x + 1 + (z + 1) * parentRectWidth];

                values[x + z * width] = parentValue5;
                this.initChunkSeed(x + realX, z + realZ);
                if(parentValue5 == 0 && parentValue1 == 0 && parentValue2 == 0 && parentValue3 == 0 && parentValue4 == 0 && this.nextInt(2) == 0) {
                    values[x + z * width] = 1;
                }
            }
        }

        return values;
    }
}
