package com.tenjava.entries.mncat77.t3.biome;

import net.minecraft.server.v1_7_R3.BiomeMeta;
import net.minecraft.server.v1_7_R3.EntityHorse;

public class BiomePlains1 extends BiomeBase {

    public BiomePlains1(int id) {
        super(id);
        this.a(0.8F, 0.4F);
        this.a(e);
        this.at.add(new BiomeMeta(EntityHorse.class, 5, 2, 6));
        this.decorator.x = -999;
        this.decorator.y = 4;
        this.decorator.z = 10;
    }

}
