package com.tenjava.entries.mncat77.t3;

import com.tenjava.entries.mncat77.t3.generator.HardcoreWorldGenerator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new HardcoreWorldGenerator(1337);
    }
}
