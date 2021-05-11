package com.englishtown.enumpack;

/**
 * Created by nikol.marku on 2/27/2017.
 * document.querySelectorAll('a')[1].getBoundingClientRect()
 * ClientRect {top: 0, right: 0, bottom: 0, left: 0, width: 0…}
 */

public enum RectangleSide {
    TOP("top"),
    RIGHT("right"),
    BOTTOM("bottom"),
    LEFT("left");

    private final String rectSide;

    private RectangleSide(String rectSide) {
        this.rectSide = rectSide;
    }

    public String getRectSide(){
        return this.rectSide;
    }

}
