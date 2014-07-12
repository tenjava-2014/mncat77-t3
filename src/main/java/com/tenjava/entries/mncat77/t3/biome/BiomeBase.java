package com.tenjava.entries.mncat77.t3.biome;

import org.bukkit.block.Biome;

public abstract class BiomeBase {

    /*All the biomes as constants
     */
    public static final BiomeBase OCEAN = new BiomeOcean(0);

    /*An internal id for the biome
     */
    public final int id;

    /*The id of the material the top block will have, e.g. for plains grass.
     */
    public int topBlockId = 2;
    /*The id of the material that will be filling in the space between the top block and stone, e.g. for plains dirt
     */
    public int fillerBlockId = 3;

    /*The corresponding Bukkit biome
     */
    protected Biome bukkitBiome;

    /*All the BiomeBases accessible with their id as array index
     */
    public static final BiomeBase[] byId = new BiomeBase[]{OCEAN};

    public BiomeBase(int id) {
        this.id = id;
    }

    /**
     * Get the corresponding Bukkit biome
     *
     * @return The corresponding Bukkit biome
     */
    public Biome getBukkitBiome() {
        return this.bukkitBiome;
    }

}
