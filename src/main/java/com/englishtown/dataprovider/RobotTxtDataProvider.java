package com.englishtown.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * Created by nikol.marku on 12/11/2015.
 */
public class RobotTxtDataProvider {

    @DataProvider(name = "robotTxtAllUrl")
    public static Object[][] robotTxtAllUrl() {
        return new Object[][] {
                {"de",   ".englishtown.de/robots.txt" },
                {"br",   ".englishtown.com.br/robots.txt"},
               //24 apr 2018 removed as failed and CE are changing  {"ec",   "englishcenters.ef.com/robots.txt" },
                {"com",  "englishlive.ef.com/robots.txt" },
        };
    }


}
