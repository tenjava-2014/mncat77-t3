package com.tenjava.entries.mncat77.t3.populator;

import java.util.Random;
import net.minecraft.server.v1_7_R3.Block;
import net.minecraft.server.v1_7_R3.Blocks;
import net.minecraft.server.v1_7_R3.IInventory;
import net.minecraft.server.v1_7_R3.Items;
import net.minecraft.server.v1_7_R3.StructurePieceTreasure;
import net.minecraft.server.v1_7_R3.TileEntityChest;
import net.minecraft.server.v1_7_R3.World;
import net.minecraft.server.v1_7_R3.WorldGenerator;

public class WorldGenScatter extends WorldGenerator {

    private static final StructurePieceTreasure[] a = new StructurePieceTreasure[]{new StructurePieceTreasure(Items.PUMPKIN_PIE, 0, 1, 1, 7), new StructurePieceTreasure(Items.DIAMOND, 0, 1, 2, 6), new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10), new StructurePieceTreasure(Items.BREAD, 0, 1, 3, 13), new StructurePieceTreasure(Items.GOLDEN_APPLE, 0, 1, 1, 1)};

    private final Block b;
    private final boolean c;

    public WorldGenScatter(Block b, boolean c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean a(World world, Random random, int i, int j, int k) {
        for(int l = 0; l < 64; ++l) {
            int i1 = i + random.nextInt(8) - random.nextInt(8);
            int j1 = j + random.nextInt(4) - random.nextInt(4);
            int k1 = k + random.nextInt(8) - random.nextInt(8);

            if(b.canPlace(world, i1, j1, k1) && (((!c) && (world.getType(i1, j1, k1) == Blocks.GRASS)) || (c && (j1 > world.getHighestBlockYAt(i1, k1))))) {
                if(random.nextInt(64) == 0) {
                    world.setTypeAndData(i1, j1, k1, Blocks.TRAPPED_CHEST, 0, 2);
                    StructurePieceTreasure[] astructurepiecetreasure = StructurePieceTreasure.a(a);
                    TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i1, j1, k1);

                    if(tileentitychest != null) {
                        StructurePieceTreasure.a(random, astructurepiecetreasure, (IInventory)tileentitychest, 8);
                    }
                }
                world.setTypeAndData(i1, j1, k1, b, 0, 2);
            }
        }

        return true;
    }
}
