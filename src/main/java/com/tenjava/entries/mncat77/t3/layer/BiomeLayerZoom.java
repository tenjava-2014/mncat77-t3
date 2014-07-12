package com.tenjava.entries.mncat77.t3.layer;

public class BiomeLayerZoom extends BiomeLayer {

    public BiomeLayerZoom(long seed, BiomeLayer parent) {
        super(seed, parent);
    }

    @Override
    public int[] getValues(int realX, int realZ, int width, int length) {
        int parentRectX = realX >> 1;
        int parentRectZ = realZ >> 1;
        int parentRectWidth = (width >> 1) + 2;
        int parentRectLenth = (length >> 1) + 2;
        int[] parentValues = this.parent.getValues(parentRectX, parentRectZ, parentRectWidth, parentRectLenth);
        int rectWidth = parentRectWidth - 1 << 1;
        int rectLength = parentRectLenth - 1 << 1;
        int[] values = new int[rectWidth * rectLength];

        int index;

        for(int z = 0; z < parentRectLenth - 1; ++z) {
            index = (z << 1) * rectWidth;
            int x = 0;
            int j3 = parentValues[x + z * parentRectWidth];

            for(int parentValue = parentValues[x + 0 + (z + 1) * parentRectWidth]; x < parentRectWidth - 1; ++x) {
                this.a((long)(x + parentRectX << 1), (long)(z + parentRectZ << 1));
                int l3 = parentValues[x + 1 + (z + 0) * parentRectWidth];
                int i4 = parentValues[x + 1 + (z + 1) * parentRectWidth];

                values[index] = j3;
                values[index++ + rectWidth] = this.a(new int[]{j3, parentValue});
                values[index] = this.a(new int[]{j3, l3});
                values[index++ + rectWidth] = this.b(j3, l3, parentValue, i4);
                j3 = l3;
                parentValue = i4;
            }
        }

        int[] finalValues = new int[width * length];

        for(index = 0; index < length; ++index) {
            System.arraycopy(values, (index + (realZ & 1)) * rectWidth + (realX & 1), finalValues, index * width, width);
        }

        return finalValues;
    }

    public static BiomeLayer zoom(long seed, BiomeLayer layer, int times) {

        for(int i = 0; i < times; ++i) {
            layer = new BiomeLayerZoom(seed + (long)i, layer);
        }

        return layer;
    }

}
