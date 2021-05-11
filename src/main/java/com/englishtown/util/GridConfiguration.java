package com.englishtown.util;
/**
 *
 */

public enum GridConfiguration {
    LOCAL_NM_PC     ("text"),
    TEAM_CITY_GRID  ("text"),
    NIKOL_OLD_PC    ("text"),
    DEV_PC          ("text"),
    OTHER           ("text");

    String grid;

    GridConfiguration(String grid){
        this.grid = grid;
    }

    String getType(){
        return grid;
    }


}
