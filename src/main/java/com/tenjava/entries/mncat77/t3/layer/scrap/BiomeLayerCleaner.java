package com.tenjava.entries.mncat77.t3.layer.scrap;

public class BiomeLayerCleaner extends BiomeLayer {

    public BiomeLayerCleaner(long seed, BiomeLayer parent) {
        super(seed, parent);
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int[] parentValues = this.parent.getValues(realX, realZ, width, length);
        int[] values = new int[width * length];

        for(int z = 0; z < length; ++z) {
            for(int x = 0; x < width; ++x) {
                this.initChunkSeed(x + realX, z + realZ);
                values[x + z * width] = parentValues[x + z * width] > 0 ? this.nextInt(299999) + 2 : 0;
            }
        }

        return values;
    }
}
