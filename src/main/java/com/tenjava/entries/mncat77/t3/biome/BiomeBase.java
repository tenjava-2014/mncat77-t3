package com.tenjava.entries.mncat77.t3.biome;

import org.bukkit.block.Biome;

public abstract class BiomeBase {

    //All the biomes as constants
    public static final BiomeBase OCEAN = (new BiomeOcean(0)).b(112).a("Ocean").a(c);
    public static final BiomeBase PLAINS = (new BiomePlains(1)).b(9286496).a("Plains");
    public static final BiomeBase DESERT = (new BiomeDesert(2)).b(16421912).a("Desert").b().a(2.0F, 0.0F).a(e);
    public static final BiomeBase EXTREME_HILLS = (new BiomeBigHills(3, false)).b(6316128).a("Extreme Hills").a(i).a(0.2F, 0.3F);
    public static final BiomeBase FOREST = (new BiomeForest(4, 0)).b(353825).a("Forest");
    public static final BiomeBase TAIGA = (new BiomeTaiga(5, 0)).b(747097).a("Taiga").a(5159473).a(0.25F, 0.8F).a(f);
    public static final BiomeBase SWAMPLAND = (new BiomeSwamp(6)).b(522674).a("Swampland").a(9154376).a(m).a(0.8F, 0.9F);
    public static final BiomeBase RIVER = (new BiomeRiver(7)).b(255).a("River").a(b);
    public static final BiomeBase HELL = (new BiomeHell(8)).b(16711680).a("Hell").b().a(2.0F, 0.0F);
    public static final BiomeBase SKY = (new BiomeTheEnd(9)).b(8421631).a("Sky").b();
    public static final BiomeBase FROZEN_OCEAN = (new BiomeOcean(10)).b(9474208).a("FrozenOcean").c().a(c).a(0.0F, 0.5F);
    public static final BiomeBase FROZEN_RIVER = (new BiomeRiver(11)).b(10526975).a("FrozenRiver").c().a(b).a(0.0F, 0.5F);
    public static final BiomeBase ICE_PLAINS = (new BiomeIcePlains(12, false)).b(16777215).a("Ice Plains").c().a(0.0F, 0.5F).a(e);
    public static final BiomeBase ICE_MOUNTAINS = (new BiomeIcePlains(13, false)).b(10526880).a("Ice Mountains").c().a(g).a(0.0F, 0.5F);
    public static final BiomeBase MUSHROOM_ISLAND = (new BiomeMushrooms(14)).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).a(l);
    public static final BiomeBase MUSHROOM_SHORE = (new BiomeMushrooms(15)).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).a(j);
    public static final BiomeBase BEACH = (new BiomeBeach(16)).b(16440917).a("Beach").a(0.8F, 0.4F).a(j);
    public static final BiomeBase DESERT_HILLS = (new BiomeDesert(17)).b(13786898).a("DesertHills").b().a(2.0F, 0.0F).a(g);
    public static final BiomeBase FOREST_HILLS = (new BiomeForest(18, 0)).b(2250012).a("ForestHills").a(g);
    public static final BiomeBase TAIGA_HILLS = (new BiomeTaiga(19, 0)).b(1456435).a("TaigaHills").a(5159473).a(0.25F, 0.8F).a(g);
    public static final BiomeBase SMALL_MOUNTAINS = (new BiomeBigHills(20, true)).b(7501978).a("Extreme Hills Edge").a(i.a()).a(0.2F, 0.3F);
    public static final BiomeBase JUNGLE = (new BiomeJungle(21, false)).b(5470985).a("Jungle").a(5470985).a(0.95F, 0.9F);
    public static final BiomeBase JUNGLE_HILLS = (new BiomeJungle(22, false)).b(2900485).a("JungleHills").a(5470985).a(0.95F, 0.9F).a(g);
    public static final BiomeBase JUNGLE_EDGE = (new BiomeJungle(23, true)).b(6458135).a("JungleEdge").a(5470985).a(0.95F, 0.8F);
    public static final BiomeBase DEEP_OCEAN = (new BiomeOcean(24)).b(48).a("Deep Ocean").a(d);
    public static final BiomeBase STONE_BEACH = (new BiomeStoneBeach(25)).b(10658436).a("Stone Beach").a(0.2F, 0.3F).a(k);
    public static final BiomeBase COLD_BEACH = (new BiomeBeach(26)).b(16445632).a("Cold Beach").a(0.05F, 0.3F).a(j).c();
    public static final BiomeBase BIRCH_FOREST = (new BiomeForest(27, 2)).a("Birch Forest").b(3175492);
    public static final BiomeBase BIRCH_FOREST_HILLS = (new BiomeForest(28, 2)).a("Birch Forest Hills").b(2055986).a(g);
    public static final BiomeBase ROOFED_FOREST = (new BiomeForest(29, 3)).b(4215066).a("Roofed Forest");
    public static final BiomeBase COLD_TAIGA = (new BiomeTaiga(30, 0)).b(3233098).a("Cold Taiga").a(5159473).c().a(-0.5F, 0.4F).a(f).c(16777215);
    public static final BiomeBase COLD_TAIGA_HILLS = (new BiomeTaiga(31, 0)).b(2375478).a("Cold Taiga Hills").a(5159473).c().a(-0.5F, 0.4F).a(g).c(16777215);
    public static final BiomeBase MEGA_TAIGA = (new BiomeTaiga(32, 1)).b(5858897).a("Mega Taiga").a(5159473).a(0.3F, 0.8F).a(f);
    public static final BiomeBase MEGA_TAIGA_HILLS = (new BiomeTaiga(33, 1)).b(4542270).a("Mega Taiga Hills").a(5159473).a(0.3F, 0.8F).a(g);
    public static final BiomeBase EXTREME_HILLS_PLUS = (new BiomeBigHills(34, true)).b(5271632).a("Extreme Hills+").a(i).a(0.2F, 0.3F);
    public static final BiomeBase SAVANNA = (new BiomeSavanna(35)).b(12431967).a("Savanna").a(1.2F, 0.0F).b().a(e);
    public static final BiomeBase SAVANNA_PLATEAU = (new BiomeSavanna(36)).b(10984804).a("Savanna Plateau").a(1.0F, 0.0F).b().a(h);
    public static final BiomeBase MESA = (new BiomeMesa(37, false, false)).b(14238997).a("Mesa");
    public static final BiomeBase MESA_PLATEAU_F = (new BiomeMesa(38, false, true)).b(11573093).a("Mesa Plateau F").a(h);
    public static final BiomeBase MESA_PLATEAU = (new BiomeMesa(39, false, false)).b(13274213).a("Mesa Plateau").a(h);
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
    public static final BiomeBase[] byId = new BiomeBase[]{/*OCEAN*/};

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
