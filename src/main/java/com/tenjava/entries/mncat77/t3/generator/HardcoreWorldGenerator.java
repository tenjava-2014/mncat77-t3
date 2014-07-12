package com.tenjava.entries.mncat77.t3.generator;

import com.tenjava.entries.mncat77.t3.layer.BiomeLayer;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class HardcoreWorldGenerator extends ChunkGenerator {

    private final List<BlockPopulator> populators = new ArrayList<BlockPopulator>();

    private final long seed;

    private static final int waterLevel = 63;

    private final BiomeLayer[] layers;

    private final SimplexOctaveGenerator noise;

    public HardcoreWorldGenerator(long seed) {
        this.seed = seed;
        //TODO: init pops
        layers = BiomeLayer.initBiomeLayers();
        this.noise = new SimplexOctaveGenerator(this.seed, 8);
        this.noise.setScale(1.0D / 256.0D);
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return this.populators;
    }

    //Util methods, not created by me nor during contest
    public static void setBlock(int x, int y, int z, byte[][] chunk, byte b) {
        if(chunk[y >> 4] == null) {
            chunk[y >> 4] = new byte[16 * 16 * 16];
        }
        if(!(y <= 256 && y >= 0 && x <= 16 && x >= 0 && z <= 16 && z >= 0)) {
            return;
        }
        try {
            chunk[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = b;
        }
        catch(Exception e) {
        }
    }

    public static byte getBlock(int x, int y, int z, byte[][] chunk) {
        if(chunk[y >> 4] == null) {
            return 0;
        }
        if(!(y <= 256 && y >= 0 && x <= 16 && x >= 0 && z <= 16 && z >= 0)) {
            return 0;
        }
        try {
            return chunk[y >> 4][((y & 0xF) << 8) | (z << 4) | x];
        }
        catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
