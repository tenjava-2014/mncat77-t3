package com.tenjava.entries.mncat77.t3.layer;

public class BiomeLayerIslands extends BiomeLayer {

    public BiomeLayerIslands(long seed) {
        super(seed);
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int[] values = new int[width * length];

        for(int z = 0; z < length; z++) {
            int a = realX + z;
            for(int x = 0; x < width; x++) {
                this.initChunkSeed(a, realZ + x);
                values[x + z * width] = this.nextInt(10) == 0 ? 1 : 0;
            }
        }

        if(realX > -width && realX <= 0 && realZ > -length && realZ <= 0) {
            values[-realX + -realZ * width] = 1;
        }

        return values;
    }

}
