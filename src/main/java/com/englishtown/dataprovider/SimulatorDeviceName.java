package com.englishtown.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * Created by nikol.marku on 13/05/2016.
 */
public class SimulatorDeviceName {

    @DataProvider(name = "deviceName")
    public Object[][] deviceNames(){
        return new Object[][] {
                {"android", "Samsung Galaxy S4"},
                {"ios", "Apple iPhone 6"}
        };
    }
}
