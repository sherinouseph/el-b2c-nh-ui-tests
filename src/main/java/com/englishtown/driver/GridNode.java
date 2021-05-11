package com.englishtown.driver;
/**
 * Nikol 2018
 *
 * List of grid nodes and application name
 * applicationName="gblcm211_win10_chrome
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GridNode {
    // node          | application name browser capability
    WIN10_GBLCM_211("gblcm211_win10_chrome"),
    WIN10_GBLCM_211_FF("gblcm211_win10_firefox"),
    WIN10_GBLCM_209("gblcm209_win10_chrome"),
    WIN7_GBLCM("gblcm_win7_chrome"),
    WIN7_GBLCM_FF("gblcm_win7_firefox");

    private final String appName;

    private GridNode(String appName) {
        this.appName = appName;
    }

    public String getAppName(){
        return this.appName;
    }

    private static final Logger logger = LoggerFactory.getLogger(GridNode.class);

}
