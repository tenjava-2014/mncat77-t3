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

    private int[] getValuesCoolWarm(int realX, int realZ, int width, int length) {
        int parentRectX = realX - 1;
        int parentRectZ = realZ - 1;
        int parentRectWidth = 1 + width + 1;
        int parentRectLength = 1 + length + 1;
        int[] parentValues = this.parent.getValues(parentRectX, parentRectZ, parentRectWidth, parentRectLength);
        int[] values = new int[width * length];

        for(int z = 0; z < length; ++z) {
            for(int x = 0; x < width; ++x) {
                this.initChunkSeed(x + realX, z + realZ);
                int k2 = parentValues[x + 1 + (z + 1) * parentRectWidth];

                if(k2 == 1) {
                    int parentValue1 = parentValues[x + 1 + (z + 1 - 1) * parentRectWidth];
                    int parentValue2 = parentValues[x + 1 + 1 + (z + 1) * parentRectWidth];
                    int parentValue3 = parentValues[x + 1 - 1 + (z + 1) * parentRectWidth];
                    int parentValue4 = parentValues[x + 1 + (z + 1 + 1) * parentRectWidth];
                    boolean flag = parentValue1 == 3 || parentValue2 == 3 || parentValue3 == 3 || parentValue4 == 3;
                    boolean flag1 = parentValue1 == 4 || parentValue2 == 4 || parentValue3 == 4 || parentValue4 == 4;

                    if(flag || flag1) {
                        k2 = 2;
                    }
                }

                values[x + z * width] = k2;
            }
        }

        return values;
    }

    private int[] getValuesHeatIce(int realX, int realZ, int width, int length) {
        int parentRectX = realX - 1;
        int parentRectZ = realZ - 1;
        int parentRectWidth = 1 + width + 1;
        int parentRectLength = 1 + length + 1;
        int[] parentValues = this.parent.getValues(parentRectX, parentRectZ, parentRectWidth, parentRectLength);
        int[] values = new int[width * length];

        for(int z = 0; z < length; ++z) {
            for(int x = 0; x < width; ++x) {
                int parentValue1 = parentValues[x + 1 + (z + 1) * parentRectWidth];

                if(parentValue1 == 4) {
                    int parentValue2 = parentValues[x + 1 + (z + 1 - 1) * parentRectWidth];
                    int parentValue3 = parentValues[x + 1 + 1 + (z + 1) * parentRectWidth];
                    int parentValue4 = parentValues[x + 1 - 1 + (z + 1) * parentRectWidth];
                    int parentValue5 = parentValues[x + 1 + (z + 1 + 1) * parentRectWidth];
                    boolean flag = parentValue2 == 2 || parentValue3 == 2 || parentValue4 == 2 || parentValue5 == 2;
                    boolean flag1 = parentValue2 == 1 || parentValue3 == 1 || parentValue4 == 1 || parentValue5 == 1;

                    if(flag1 || flag) {
                        parentValue1 = 3;
                    }
                }

                values[x + z * width] = parentValue1;
            }
        }

        return values;
    }

    private int[] getValuesPufferfish(int realX, int realZ, int width, int length) {
        int[] parentValues = this.parent.getValues(realX, realZ, width, length);
        int[] values = new int[width * length];

        for(int z = 0; z < length; ++z) {
            for(int x = 0; x < width; ++x) {
                this.initChunkSeed(x + realX, z + realZ);
                int parentValue = parentValues[x + z * width];

                if(parentValue != 0 && this.nextInt(13) == 0) {
                    parentValue |= 1 + this.nextInt(15) << 8 & 3840;
                }

                values[x + z * width] = parentValue;
            }
        }

        return values;
    }
}
