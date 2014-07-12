package com.tenjava.entries.mncat77.t3.layer.scrap;

//Just a copy so I have access
import net.minecraft.server.v1_7_R3.EnumGenLayerSpecial;

class GenLayerJumpTable {

    static final int[] a = new int[EnumGenLayerSpecial.values().length];

    static {
        try {
            a[EnumGenLayerSpecial.COOL_WARM.ordinal()] = 1;
        }
        catch(NoSuchFieldError nosuchfielderror) {
            ;
        }

        try {
            a[EnumGenLayerSpecial.HEAT_ICE.ordinal()] = 2;
        }
        catch(NoSuchFieldError nosuchfielderror1) {
            ;
        }

        try {
            a[EnumGenLayerSpecial.PUFFERFISH.ordinal()] = 3;
        }
        catch(NoSuchFieldError nosuchfielderror2) {
            ;
        }
    }
}
