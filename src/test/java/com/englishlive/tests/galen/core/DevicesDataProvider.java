package com.englishlive.tests.galen.core;

/**
 * Created by nikolmarku on 10/28/2016.
 *
 * Note: Tablet could be portrait or landscapte
 */
import org.openqa.selenium.Dimension;
import org.testng.annotations.DataProvider;
import static java.util.Arrays.asList;


public class DevicesDataProvider {

    @DataProvider(name = "devices") //, parallel = true)
    public Object [][] devices(){
        return new Object[][] {
                {new TestDevice("mobile",  new Dimension(480,  640), asList("mobile"))},
                {new TestDevice("tablet",  new Dimension(768, 1024), asList("tablet"))},
                {new TestDevice("desktop", new Dimension(1366, 768), asList("desktop"))},
                //{new TestDevice("FullHD_desktop", new Dimension(1920, 1080), asList("FullHD_desktop"))},
        };
    }
    @DataProvider(name = "devicesImageTest")
    public Object [][] devicesImageTest(){
        return new Object[][] {
                {new TestDevice("desktop", new Dimension(1466, 1068), asList("desktop"))},
                //{new TestDevice("FullHD_desktop", new Dimension(1920, 1080), asList("FullHD"))},
        };
    }

    @DataProvider(name = "devicesDesktopMobile")
    public Object [][] devicesDesktopMobile(){
        return new Object[][] {
                {new TestDevice("desktop", new Dimension(1466, 1068), asList("desktop"))},
                {new TestDevice("mobile",  new Dimension(480,  640), asList("mobile"))},
        };
    }

    @DataProvider(name = "devicesMobileTablet")
    public Object [][] devicesMobileTablet(){
        return new Object[][] {
                {new TestDevice("mobile",  new Dimension(480,  640), asList("mobile"))},
                {new TestDevice("tablet",  new Dimension(768, 1024), asList("tablet"))},

        };
    }

}

