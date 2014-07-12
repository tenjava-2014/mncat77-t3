package com.tenjava.entries.mncat77.t3.layer;

//I don't like this one
import net.minecraft.server.v1_7_R3.EnumGenLayerSpecial;

public class BiomeLayerSpecial extends BiomeLayer {

    private final EnumGenLayerSpecial c;

    public BiomeLayerSpecial(long seed, BiomeLayer parent, EnumGenLayerSpecial enumgenlayerspecial) {
        super(seed, parent);
        this.c = enumgenlayerspecial;
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        switch(GenLayerJumpTable.a[this.c.ordinal()]) {
            case 1:
            default:
                return this.getValuesCoolWarm(realX, realZ, width, length);

            case 2:
                return this.getValuesHeatIce(realX, realZ, width, length);

            case 3:
                return this.getValuesPufferfish(realX, realZ, width, length);
        }
    }

    private int[] getValuesCoolWarm(int i, int j, int k, int l) {
        int i1 = i - 1;
        int j1 = j - 1;
        int k1 = 1 + k + 1;
        int l1 = 1 + l + 1;
        int[] aint = this.parent.getValues(i1, j1, k1, l1);
        int[] aint1 = new int[k * l];

        for(int i2 = 0; i2 < l; ++i2) {
            for(int j2 = 0; j2 < k; ++j2) {
                this.initChunkSeed(j2 + i, i2 + j);
                int k2 = aint[j2 + 1 + (i2 + 1) * k1];

                if(k2 == 1) {
                    int l2 = aint[j2 + 1 + (i2 + 1 - 1) * k1];
                    int i3 = aint[j2 + 1 + 1 + (i2 + 1) * k1];
                    int j3 = aint[j2 + 1 - 1 + (i2 + 1) * k1];
                    int k3 = aint[j2 + 1 + (i2 + 1 + 1) * k1];
                    boolean flag = l2 == 3 || i3 == 3 || j3 == 3 || k3 == 3;
                    boolean flag1 = l2 == 4 || i3 == 4 || j3 == 4 || k3 == 4;

                    if(flag || flag1) {
                        k2 = 2;
                    }
                }

                aint1[j2 + i2 * k] = k2;
            }
        }

        return aint1;
    }

    private int[] getValuesHeatIce(int i, int j, int k, int l) {
        int i1 = i - 1;
        int j1 = j - 1;
        int k1 = 1 + k + 1;
        int l1 = 1 + l + 1;
        int[] aint = this.parent.getValues(i1, j1, k1, l1);
        int[] aint1 = new int[k * l];

        for(int i2 = 0; i2 < l; ++i2) {
            for(int j2 = 0; j2 < k; ++j2) {
                int k2 = aint[j2 + 1 + (i2 + 1) * k1];

                if(k2 == 4) {
                    int l2 = aint[j2 + 1 + (i2 + 1 - 1) * k1];
                    int i3 = aint[j2 + 1 + 1 + (i2 + 1) * k1];
                    int j3 = aint[j2 + 1 - 1 + (i2 + 1) * k1];
                    int k3 = aint[j2 + 1 + (i2 + 1 + 1) * k1];
                    boolean flag = l2 == 2 || i3 == 2 || j3 == 2 || k3 == 2;
                    boolean flag1 = l2 == 1 || i3 == 1 || j3 == 1 || k3 == 1;

                    if(flag1 || flag) {
                        k2 = 3;
                    }
                }

                aint1[j2 + i2 * k] = k2;
            }
        }

        return aint1;
    }

    private int[] getValuesPufferfish(int i, int j, int k, int l) {
        int[] aint = this.parent.getValues(i, j, k, l);
        int[] aint1 = new int[k * l];

        for(int i1 = 0; i1 < l; ++i1) {
            for(int j1 = 0; j1 < k; ++j1) {
                this.initChunkSeed(j1 + i, i1 + j);
                int k1 = aint[j1 + i1 * k];

                if(k1 != 0 && this.nextInt(13) == 0) {
                    k1 |= 1 + this.nextInt(15) << 8 & 3840;
                }

                aint1[j1 + i1 * k] = k1;
            }
        }

        return aint1;
    }
}
