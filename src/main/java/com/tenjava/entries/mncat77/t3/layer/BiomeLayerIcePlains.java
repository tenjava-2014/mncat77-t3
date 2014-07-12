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

        for(int x = 0; x < length; ++x) {
            for(int z = 0; z < width; ++z) {
                int parentValue1 = parentValues[z + 1 + (x) * (width + 2)];
                int parentValue2 = parentValues[z + 2 + (x + 1) * (width + 2)];
                int parentValue3 = parentValues[z + (x + 1) * (width + 2)];
                int parentValue4 = parentValues[z + 1 + (x + 2) * (width + 2)];
                int parentValue5 = parentValues[z + 1 + (x + 1) * parentRectWidth];

                values[z + x * width] = parentValue5;
                this.initChunkSeed(z + realX, x + realZ);
                if(parentValue5 == 0 && parentValue1 == 0 && parentValue2 == 0 && parentValue3 == 0 && parentValue4 == 0 && this.nextInt(2) == 0) {
                    values[z + x * width] = 1;
                }
            }
        }

        return values;
    }
}
