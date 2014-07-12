package com.tenjava.entries.mncat77.t3.layer.scrap;

public class BiomeLayerZoomFuzzy extends BiomeLayerZoom {

    public BiomeLayerZoomFuzzy(long seed, BiomeLayer parent) {
        super(seed, parent);
    }

    //Completely random now
    @Override
    protected int chooseZoom(int choice1, int choice2, int choice3, int choice4) {
        return this.choose(choice1, choice2, choice3, choice4);
    }

}
