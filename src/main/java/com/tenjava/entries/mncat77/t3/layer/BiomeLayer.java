package com.tenjava.entries.mncat77.t3.layer;

public abstract class BiomeLayer {

    protected BiomeLayer parent;

    protected long baseSeed;

    /**
     * Init all the layers to create the final biome providing layers
     *
     * @param seed The base seed for the layers
     * @return The layers providing the final biomes
     */
    public static BiomeLayer[] initBiomeLayers(long seed) {
        return new BiomeLayer[0];
    }

    /**
     * Generates values (usually biome ids) for a specified rectangle in the
     * world
     *
     * @param realX The X-Offset of the rectangle in Blocks
     * @param realZ The Z-Offset of the rectangle in Blocks
     * @param width The width of the rectangle
     * @param length The length of the rectangle
     * @return int[] with the values for the rectangle (usually biome ids)
     */
    public abstract int[] getValues(int realX, int realZ, int width, int length);

    /**
     * Generates a pseudo-random number for the layers
     *
     * @param max The maximum value the number should be (not inclusive)
     * @param realX The X-Offset for the random number in Blocks (I don't want
     * to init chunkseeds all the time)
     * @param realZ The Z-Offset for the random number in Blocks (I don't want
     * to init chunkseeds all the time)
     * @return A pseudo-random number generated with the baseSeed and the
     * parameters
     */
    protected int nextInt(int max, int realX, int realZ) {
        long chunkSeed = this.baseSeed;
        chunkSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += realX;
        chunkSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += realZ;
        chunkSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += realX;
        chunkSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += realZ;

        int rand = (int)((chunkSeed >> 24) % (long)max);

        if(rand < 0) {
            rand += max;
        }
        return rand;
    }

}
