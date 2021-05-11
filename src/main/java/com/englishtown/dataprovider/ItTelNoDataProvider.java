package com.englishtown.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * Data provider for Tel No IT
 * User: nikol.marku
 * Date: 01/09/14
 *
 */
public class ItTelNoDataProvider {


    @DataProvider(name = "itTelNoPositiveTestCases")
    public static Object[][] createDataPositive() {         //createDataPositive (Method m) System.out.println("Method calling meDataprovider possitive test itTelNo : "+m.getName());
        return new Object[][] {
                { "IT", "01234567" },
                { "IT", "090123456789" },
                { "IT", "05555556" },
                { "IT", "045000000077" },
                { "IT", "32987654" },
                { "IT", "33012345" },
                { "IT", "341230456789" },
                { "IT", "397654321000" },
                { "IT", "329999999911" },
                { "IT", "344444444999" }
        };
    }

    @DataProvider(name = "itTelNoNegativeTestCasesShowAlertPopup")
    public static Object[][] createTelephoneNoShowAlerts() {
        return new Object[][] {
                { "min 7 no0",          "0123456"} ,
                { "8 RepetitiveNo",     "3255555555"} ,
                { "min 7 num3",         "3298765"} ,
                //TODO open when norman fix       https://jira-bos.englishtown.com/browse/SAND-1866
                //{ "9 RepetitiveNo3",    "329999999991"}
        };
    }

    @DataProvider(name = "itTelNoNegativeTestCasesChopEntry")
    public static Object[][] createTelephoneNoChopEntry() {
        return new Object[][] {
                { "mixLettersAndNo",    "qweqw3334234erterte" },   //Nothing
                { "specialChars",       "+!£%£$£-()%$^%" },        //Nothing
                { "8 spaces",           "        " } ,            //Nothing
                { "max 13 no0",         "0901234567890" },  // remove 0
                { "max 13 no3",         "3412304567890" } , // remove 0

        };
    }
}
