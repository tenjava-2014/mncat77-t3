package com.tenjava.entries.mncat77.t3.layer.scrap;

public class BiomeLayerAddToIslands extends BiomeLayer {

    public BiomeLayerAddToIslands(long seed, BiomeLayer parent) {
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
                int parentValue1 = parentValues[x + z * parentRectWidth];
                int parentValue2 = parentValues[x + 2 + z * parentRectWidth];
                int parentValue3 = parentValues[x + (z + 2) * parentRectWidth];
                int parentValue4 = parentValues[x + 2 + (z + 2) * parentRectWidth];
                int parentValue5 = parentValues[x + 1 + (z + 1) * parentRectWidth];

                this.initChunkSeed(x + realX, z + realZ);
                if(parentValue5 == 0 && (parentValue1 != 0 || parentValue2 != 0 || parentValue3 != 0 || parentValue4 != 0)) {
                    int randMax = 1;
                    int value = 1;

                    if(parentValue1 != 0 && this.nextInt(randMax++) == 0) {
                        value = parentValue1;
                    }

                    if(parentValue2 != 0 && this.nextInt(randMax++) == 0) {
                        value = parentValue2;
                    }

                    if(parentValue3 != 0 && this.nextInt(randMax++) == 0) {
                        value = parentValue3;
                    }

                    if(parentValue4 != 0 && this.nextInt(randMax++) == 0) {
                        value = parentValue4;
                    }

                    if(this.nextInt(3) == 0) {
                        values[x + z * width] = value;
                    }
                    else if(value == 4) {
                        values[x + z * width] = 4;
                    }
                    else {
                        values[x + z * width] = 0;
                    }
                }
                else if(parentValue5 > 0 && (parentValue1 == 0 || parentValue2 == 0 || parentValue3 == 0 || parentValue4 == 0)) {
                    if(this.nextInt(5) == 0) {
                        if(parentValue5 == 4) {
                            values[x + z * width] = 4;
                        }
                        else {
                            values[x + z * width] = 0;
                        }
                    }
                    else {
                        values[x + z * width] = parentValue5;
                    }
                }
                else {
                    values[x + z * width] = parentValue5;
                }
            }
        }

        return values;

    }

}
