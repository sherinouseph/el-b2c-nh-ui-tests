package com.englishtown.driver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *  List of supported browsers type
 *  {android|chrome|firefox|htmlunit|internet explorer|iPhone|iPad|opera|safari}.
 *
 */

public enum MyBrowserType {

    FIREFOX("firefox"),
    EXPLORER10("internet explorer"),
    EXPLORER11("IE"),
    EDGE("Edge"),
    CHROME("chrome"),
    CHROME_HEADLESS("chromeheadless"),
    ANDROID("android"),
    BROWSERSTACK_ANDROID_GALAXY_S8("Samsung Galaxy S8"),
    BROWSERSTACK_ANDROID_NEXUS9("Google Nexus 9"),
    BROWSERSTACK_IOS_IPHONE7("iPhone 7"),
    BROWSERSTACK_IOS_IPHONE7PLUS("iPhone 7 Plus"),
    BROWSERSTACK_IOS_IPADPRO("iPad Pro"),  // no real device yet nov 17 on browser stack
    BROWSERSTACK_SAFARI("bsSafari"),
    BROWSERSTACK_IE11("bsIe11"),
    BROWSERSTACK_EDGE("bsEdge"),
    IPHONE("iPhone"),
    IPAD("iPad"),
    IPAD_PRO("iPad Pro not used"),
    OPERA("opera"),
    HTMLUNIT("htmlunit"),
    JBROWSER("jbrowser"),
    SAFARI("safari"),
    SAFARIPREVIEW("Safari Technology Preview"),
    CHROME_SIMULATOR_IPAD("chromeSimulatorIpad"),
    CHROME_SIMULATOR_NEXUS("chromeSimulatorNexus"),  //10
    CHROME_SIMULATOR_other("other"),
    PHANTOMJS("phantomjs"),
    CHROME_EMULATOR_GALAXY_S5("galaxys5"),
    CHROME_EMULATOR_IPHONE6("iphone6");


    String browser;

    private static final Logger logger = LoggerFactory.getLogger(MyBrowserType.class);

    MyBrowserType(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }


    /**
     * Get browser type from string
     * @param strBrowserType
     * @return
     */
    public static MyBrowserType getMyBrowserTypeFromString(String strBrowserType){
        MyBrowserType type = MyBrowserType.CHROME;

        if(null != strBrowserType) {

            switch (strBrowserType) {
                case "firefox":
                    type = MyBrowserType.FIREFOX;
                    break;
                case "chrome":
                    type = MyBrowserType.CHROME;
                    break;
                case "chromeheadless":
                    type = MyBrowserType.CHROME_HEADLESS;
                    break;
                case "ie10":                        //"internet explorer10":
                    type = MyBrowserType.EXPLORER10;
                    break;
                case "IE":                        //"internet explorer11":
                    type = MyBrowserType.EXPLORER11;
                    break;
                case "Edge":                        //"edge":
                    type = MyBrowserType.EDGE;
                    break;
                case "safari":                        //"safari":
                    type = MyBrowserType.SAFARI;
                    break;
                case "bsSafari":
                    type = MyBrowserType.BROWSERSTACK_SAFARI;
                    break;
                case "bsIe11":
                    type = MyBrowserType.BROWSERSTACK_IE11;
                    break;
                case "bsEdge":
                    type = MyBrowserType.BROWSERSTACK_EDGE;
                    break;
                case "jbrowser":
                    type = MyBrowserType.JBROWSER;
                    break;
                case "htmlunit":
                    type = MyBrowserType.HTMLUNIT;
                    break;
                case "phantomjs":
                    type = MyBrowserType.PHANTOMJS;
                    break;
                case "samsungGalaxyS8":
                    type = MyBrowserType.BROWSERSTACK_ANDROID_GALAXY_S8;
                    break;
                    // same
                case "sgs8":
                    type = MyBrowserType.BROWSERSTACK_ANDROID_GALAXY_S8;
                    break;
                case "googleNexus9":
                    type = MyBrowserType.BROWSERSTACK_ANDROID_NEXUS9;
                    break;
                case "iPhone7":
                    type = MyBrowserType.BROWSERSTACK_IOS_IPHONE7;
                    break;
                case "iPhone7Plus":
                    type = MyBrowserType.BROWSERSTACK_IOS_IPHONE7PLUS;
                    break;
                case "iPadPro":
                    type = MyBrowserType.BROWSERSTACK_IOS_IPADPRO;
                    break;

                default:
                    logger.warn(strBrowserType + " Is not on the browser list ... so getting Chrome browser ...!");                //return MyBrowserType.CHROME;
            }
        } else {
            logger.error("Browser not set from D args is null .. so get chrome ...!");
        }
        return type;
    }


}
