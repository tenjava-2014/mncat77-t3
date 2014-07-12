package com.tenjava.entries.mncat77.t3.populator;

import java.util.Random;
import net.minecraft.server.v1_7_R3.Blocks;
import net.minecraft.server.v1_7_R3.IInventory;
import net.minecraft.server.v1_7_R3.Items;
import net.minecraft.server.v1_7_R3.StructurePieceTreasure;
import net.minecraft.server.v1_7_R3.TileEntityChest;
import net.minecraft.server.v1_7_R3.World;
import net.minecraft.server.v1_7_R3.WorldGenerator;

public class WorldGenWhirl extends WorldGenerator {

    //Goodies that can be in the chests
    private static final StructurePieceTreasure[] a = new StructurePieceTreasure[]{new StructurePieceTreasure(Items.MELON, 0, 2, 5, 10), new StructurePieceTreasure(Items.APPLE, 0, 2, 5, 10), new StructurePieceTreasure(Items.PUMPKIN_PIE, 0, 1, 1, 1)};

    @Override
    public boolean a(World world, Random random, int i, int j, int k) {
        int i1 = i + random.nextInt(8) - random.nextInt(8);
        int j1 = j;
        int k1 = k + random.nextInt(8) - random.nextInt(8);

        if((world.getType(i1, j1, k1) == Blocks.SAND) && (world.getType(i1, j1 + 1, k1) == Blocks.AIR)) {
            int r = 30 + random.nextInt(12);
            if((r % 2) != 0) {
                r = r + 1;
            }
            for(int h = 0; h <= (r / 2); h++) {
                int r1 = r - 2 * h;
                for(int i2 = i1 - r1; i2 <= i1 + r1; i2++) {
                    int dX = i1 - i2;
                    for(int k2 = k1 - r1; k2 <= k1 + r1; k2++) {
                        int dZ = k1 - k2;
                        int dist = dX * dX + dZ * dZ;
                        if(dist < r1 - 6) {
                            world.setTypeAndData(i2, j1 - h, k2, Blocks.AIR, 0, 2);
                        }
                        else if((dist <= r1) && (world.getType(i2, j1 - h, k2) != Blocks.AIR)) {
                            world.setTypeAndData(i2, j1 - h, k2, Blocks.SAND, 0, 2);
                        }
                    }
                }
            }
            world.setTypeAndData(i1, j1 - r / 2 + 3, k1, Blocks.CHEST, 0, 2);
            TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i1, j1 - r / 2 + 3, k1);

            if(tileentitychest != null) {
                StructurePieceTreasure.a(random, a, (IInventory)tileentitychest, 4);
            }
        }
        return true;
    }

}
