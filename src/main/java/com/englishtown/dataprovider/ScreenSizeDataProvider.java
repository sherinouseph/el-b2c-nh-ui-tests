package com.englishtown.dataprovider;

import org.openqa.selenium.Dimension;

/**
 * Created by nikol.marku on 1/13/2017.
 */
public class ScreenSizeDataProvider {

    @org.testng.annotations.DataProvider(name = "screenSizeDataProvider")
    public static Object[][] getWindowDimensions() {
        return new Object[][]{
                { new Dimension(320,   480) },
                { new Dimension(600,   800) },
                { new Dimension(800,   600) },
                { new Dimension(1226, 1166) },
                { new Dimension(1366, 1166) },
                { new Dimension(1245, 1166) },
                { new Dimension(1226, 1166) },
                { new Dimension(1920, 1080) }, // "Full_HD_1920x1080",
                { new Dimension(1920, 1080) }, // "Full_HD_1080x1920",
                { new Dimension(3840, 2160) }, // "Ultra_HD_3840x2160",
        };
    }
}
