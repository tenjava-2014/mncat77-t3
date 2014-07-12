package com.tenjava.entries.mncat77.t3.layer;

public class BiomeLayerIslands extends BiomeLayer {

    public BiomeLayerIslands(long seed) {
        super(seed);
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int[] values = new int[width * length];

        for(int x = 0; x < length; x++) {
            int a = realX + x;
            for(int z = 0; z < width; z++) {
                values[z + x * width] = this.nextInt(10, a, realZ + z) == 0 ? 1 : 0;
            }
        }

        if(realX > -width && realX <= 0 && realZ > -length && realZ <= 0) {
            values[-realX + -realZ * width] = 1;
        }

        return values;
    }

}
