package com.tenjava.entries.mncat77.t3.layer;

public abstract class BiomeLayer {

    protected BiomeLayer parent;

    protected long baseSeed;
    private long chunkSeed;

    /**
     * Init all the layers to create the final biome providing layers
     *
     * @param seed The base seed for the layers
     * @return The layers providing the final biomes
     */
    public static BiomeLayer[] initBiomeLayers(long seed) {
        BiomeLayer layerIsland = new BiomeLayerIslands(seed);
        BiomeLayer layerZoomFuzzy = new BiomeLayerZoomFuzzy(seed + 1, layerIsland);
        BiomeLayer layerIslands = new BiomeLayerAddToIslands(seed - 1, layerZoomFuzzy);
        BiomeLayer layerZoom = new BiomeLayerZoom(seed + 2, layerIslands);

        layerIslands = new BiomeLayerAddToIslands(seed - 2, layerZoom);
        layerIslands = new BiomeLayerAddToIslands(seed + 3, layerIslands);
        layerIslands = new BiomeLayerAddToIslands(seed - 3, layerIslands);
        BiomeLayer layerIcePlains = new BiomeLayerIcePlains(seed + 4, layerIslands);
        BiomeLayer layerTopSoil = new BiomeLayerTopSoil(seed - 4, layerIcePlains);
        layerIslands = new BiomeLayerAddToIslands(seed + 5, layerTopSoil);

        return new BiomeLayer[]{null};
    }

    /**
     * Create a fresh BiomeLayer(only used by first layer)
     *
     * @param seed Seed for the BiomeLayer
     */
    protected BiomeLayer(long seed) {
        this.baseSeed = seed;
    }

    /**
     * Creates a BiomeLayer with a parent
     *
     * @param seed Seed for the BiomeLayer
     * @param parent Parent for the BiomeLayer
     */
    protected BiomeLayer(long seed, BiomeLayer parent) {
        this.baseSeed = seed;
        this.parent = parent;
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
     * Inits Chunk seed for specified position
     *
     * @param realX The X-Offset
     * @param realZ The Z-Offset
     */
    protected void initChunkSeed(int realX, int realZ) {
        chunkSeed = this.baseSeed;
        chunkSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += realX;
        chunkSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += realZ;
        chunkSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += realX;
        chunkSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        chunkSeed += realZ;
    }

    /**
     * Generates a pseudo-random number for the layers
     *
     * @param max The maximum value the number should be (not inclusive)
     * @return A pseudo-random number generated with the baseSeed and the
     * parameters
     */
    protected int nextInt(int max) {
        int rand = (int)((this.chunkSeed >> 24) % (long)max);

        if(rand < 0) {
            rand += max;
        }
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += this.baseSeed;
        return rand;
    }

    protected int choose(int... choices) {
        return choices[this.choose(choices.length)];
    }

    protected int chooseZoom(int choice1, int choice2, int choice3, int choice4) {
        return choice2 == choice3 && choice3 == choice4 ? choice2 : (choice1 == choice2 && choice1 == choice3 ? choice1 : (choice1 == choice2 && choice1 == choice4 ? choice1 : (choice1 == choice3 && choice1 == choice4 ? choice1 : (choice1 == choice2 && choice3 != choice4 ? choice1 : (choice1 == choice3 && choice2 != choice4 ? choice1 : (choice1 == choice4 && choice2 != choice3 ? choice1 : (choice2 == choice3 && choice1 != choice4 ? choice2 : (choice2 == choice4 && choice1 != choice3 ? choice2 : (choice3 == choice4 && choice1 != choice2 ? choice3 : this.choose(new int[]{choice1, choice2, choice3, choice4}))))))))));
    }

}
