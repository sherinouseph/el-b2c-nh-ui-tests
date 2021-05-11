package com.englishtown.tests.core.responsivecore;

/**
 * Created by nikol.marku on 01/06/2015.
 */
public class ResponsiveDesignDataProvider {
    @org.testng.annotations.DataProvider(name = "getWindowDimensions")
    public static Object[][] getWindowDimensions() {
        return new Object[][]{
                {"Mobile320x480",ResponsiveDesignConfig.getAllDimensions().get(0)},
                //{"Mobile480x320",ResponsiveDesignConfig.getAllDimensions().get(1)},
                //{"SmallTablet600x800",ResponsiveDesignConfig.getAllDimensions().get(2)},
               //{"Tablet800x600",ResponsiveDesignConfig.getAllDimensions().get(3)},
                {"Table768x1024",ResponsiveDesignConfig.getAllDimensions().get(4)},
                {"Tablet1024x768",ResponsiveDesignConfig.getAllDimensions().get(5)}
                //{"Desktop Full HD",ResponsiveDesignConfig.getAllDimensions().get(6)}
        };
    }

}
