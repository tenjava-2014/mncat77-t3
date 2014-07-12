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

        for(int parentZ = 0; parentZ < parentRectLenth - 1; ++parentZ) {
            index = (parentZ << 1) * rectWidth;
            int parentX = 0;
            int parentValueSelf = parentValues[parentX + parentZ * parentRectWidth];

            for(int parentValueLower = parentValues[parentX + (parentZ + 1) * parentRectWidth]; parentX < parentRectWidth - 1; ++parentX) {
                int x = parentX + parentRectX << 1;
                int z = parentZ + parentRectZ << 1;
                int parentValueRight = parentValues[parentX + 1 + parentZ * parentRectWidth];
                int parentValueLowerRight = parentValues[parentX + 1 + (parentZ + 1) * parentRectWidth];

                values[index] = parentValueSelf;
                values[index++ + rectWidth] = this.choose(parentValueSelf, parentValueLower);
                values[index] = this.choose(parentValueSelf, parentValueRight);
                values[index++ + rectWidth] = this.chooseZoom(parentValueSelf, parentValueRight, parentValueLower, parentValueLowerRight);
                parentValueSelf = parentValueRight;
                parentValueLower = parentValueLowerRight;
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
