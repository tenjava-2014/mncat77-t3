package com.tenjava.entries.mncat77.t3.generator;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class FakeChunkGenerator extends ChunkGenerator {

    @Override
    public byte[][] generateBlockSections(World world, Random random, int chunkX, int chunkZ, BiomeGrid biomes) {
        byte[][] chunk = new byte[16][];
        for(int x = 0; x < 16; x++) {
            for(int z = 0; z < 16; z++) {
                for(int y = 0; y < 80; y++) {
                    setBlock(x, y, z, chunk, (byte)57);
                }
            }
        }
        return chunk;
    }

    @Override
    public Location getFixedSpawnLocation(World world, Random random) {
        return new Location(world, 2000, 80, 2000);
    }

    //Util method, not written by me nor during the timeframe
    public static void setBlock(int x, int y, int z, byte[][] chunk, byte b) {
        //if the Block section the block is in hasn't been used yet, allocate it
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
            // do nothing
        }
    }

}
