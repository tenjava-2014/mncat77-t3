package com.tenjava.entries.mncat77.t3.layer.scrap;

public class BiomeLayerZoomVoronoi extends BiomeLayer {

    public BiomeLayerZoomVoronoi(long seed, BiomeLayer parent) {
        super(seed, parent);
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        realX -= 2;
        realZ -= 2;
        int parentRectX = realX >> 2;
        int parentRectZ = realZ >> 2;
        int parentRectWidth = (width >> 2) + 2;
        int parentRectLength = (length >> 2) + 2;
        int[] parentValues = this.parent.getValues(parentRectX, parentRectZ, parentRectWidth, parentRectLength);
        int i2 = parentRectWidth - 1 << 2;
        int j2 = parentRectLength - 1 << 2;
        int[] values = new int[i2 * j2];

        //First x then index
        int cache;

        for(int z = 0; z < parentRectLength - 1; ++z) {
            cache = 0;
            int i3 = parentValues[cache + z * parentRectWidth];

            for(int parentValue1 = parentValues[cache + (z + 1) * parentRectWidth]; cache < parentRectWidth - 1; ++cache) {

                this.initChunkSeed(cache + parentRectX << 2, z + parentRectZ << 2);
                double d1 = ((double)this.nextInt(1024) / 1024.0D - 0.5D) * 3.6D;
                double d2 = ((double)this.nextInt(1024) / 1024.0D - 0.5D) * 3.6D;

                this.initChunkSeed(cache + parentRectX + 1 << 2, z + parentRectZ << 2);
                double d3 = ((double)this.nextInt(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
                double d4 = ((double)this.nextInt(1024) / 1024.0D - 0.5D) * 3.6D;

                this.initChunkSeed(cache + parentRectX << 2, z + parentRectZ + 1 << 2);
                double d5 = ((double)this.nextInt(1024) / 1024.0D - 0.5D) * 3.6D;
                double d6 = ((double)this.nextInt(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;

                this.initChunkSeed(cache + parentRectX + 1 << 2, z + parentRectZ + 1 << 2);
                double d7 = ((double)this.nextInt(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
                double d8 = ((double)this.nextInt(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
                int k3 = parentValues[cache + 1 + (z + 0) * parentRectWidth] & 255;
                int l3 = parentValues[cache + 1 + (z + 1) * parentRectWidth] & 255;

                for(int i4 = 0; i4 < 4; ++i4) {
                    int j4 = ((z << 2) + i4) * i2 + (cache << 2);

                    for(int k4 = 0; k4 < 4; ++k4) {
                        double d9 = ((double)i4 - d2) * ((double)i4 - d2) + ((double)k4 - d1) * ((double)k4 - d1);
                        double d10 = ((double)i4 - d4) * ((double)i4 - d4) + ((double)k4 - d3) * ((double)k4 - d3);
                        double d11 = ((double)i4 - d6) * ((double)i4 - d6) + ((double)k4 - d5) * ((double)k4 - d5);
                        double d12 = ((double)i4 - d8) * ((double)i4 - d8) + ((double)k4 - d7) * ((double)k4 - d7);

                        if(d9 < d10 && d9 < d11 && d9 < d12) {
                            values[j4++] = i3;
                        }
                        else if(d10 < d9 && d10 < d11 && d10 < d12) {
                            values[j4++] = k3;
                        }
                        else if(d11 < d9 && d11 < d10 && d11 < d12) {
                            values[j4++] = parentValue1;
                        }
                        else {
                            values[j4++] = l3;
                        }
                    }
                }

                i3 = k3;
                parentValue1 = l3;
            }
        }

        int[] finalValues = new int[width * length];

        for(cache = 0; cache < length; ++cache) {
            System.arraycopy(values, (cache + (realZ & 3)) * i2 + (realX & 3), finalValues, cache * width, width);
        }

        return finalValues;
    }
}
