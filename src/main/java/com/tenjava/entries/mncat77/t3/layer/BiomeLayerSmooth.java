package com.tenjava.entries.mncat77.t3.layer;

public class BiomeLayerSmooth extends BiomeLayer {

    public BiomeLayerSmooth(long seed, BiomeLayer parent) {
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

        for(int i2 = 0; i2 < length; ++i2) {
            for(int j2 = 0; j2 < width; ++j2) {
                int parentValue1 = parentValues[j2 + (i2 + 1) * parentRectWidth];
                int parentValue2 = parentValues[j2 + 2 + (i2 + 1) * parentRectWidth];
                int parentValue3 = parentValues[j2 + 1 + (i2) * parentRectWidth];
                int parentValue4 = parentValues[j2 + 1 + (i2 + 2) * parentRectWidth];
                int parentValue5 = parentValues[j2 + 1 + (i2 + 1) * parentRectWidth];

                if(parentValue1 == parentValue2 && parentValue3 == parentValue4) {
                    this.initChunkSeed(j2 + realX, i2 + realZ);
                    if(this.nextInt(2) == 0) {
                        parentValue5 = parentValue1;
                    }
                    else {
                        parentValue5 = parentValue3;
                    }
                }
                else {
                    if(parentValue1 == parentValue2) {
                        parentValue5 = parentValue1;
                    }

                    if(parentValue3 == parentValue4) {
                        parentValue5 = parentValue3;
                    }
                }

                values[j2 + i2 * width] = parentValue5;
            }
        }

        return values;
    }
}
