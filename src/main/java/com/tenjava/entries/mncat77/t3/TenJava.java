package com.tenjava.entries.mncat77.t3;

import com.tenjava.entries.mncat77.t3.generator.FakeChunkGenerator;
import com.tenjava.entries.mncat77.t3.generator.HardcoreChunkGenerator;
import java.lang.reflect.Field;
import net.minecraft.server.v1_7_R3.ChunkProviderServer;
import net.minecraft.server.v1_7_R3.MinecraftServer;
import net.minecraft.server.v1_7_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    private int taskId;

    @Override
    public void onEnable() {
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

            @Override
            public void run() {
                try {
                    WorldServer w = MinecraftServer.getServer().getWorldServer(0);
                    Field f = ChunkProviderServer.class.getDeclaredField("f");
                    f.setAccessible(true);
                    HardcoreChunkGenerator gen = new HardcoreChunkGenerator(w);
                    w.generator = gen;
                    w.chunkProviderServer.chunkProvider = gen;
                    System.out.println("Replaced!");
                    Bukkit.getScheduler().cancelTask(taskId);
                }
                catch(Exception e) {
                }
            }
        }, 0L, 1L);
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new FakeChunkGenerator();
    }
}
