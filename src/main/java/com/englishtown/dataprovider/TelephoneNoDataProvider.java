package com.englishtown.dataprovider;

import com.englishtown.dataprovider.bin.CountryBean;
import org.testng.annotations.DataProvider;

/**
 * Data provider for Tel No
 *
 *
 */
public class TelephoneNoDataProvider {

    //Valid : 2221000000 , 5517093000 , 9999989999    Invalid : 2220000000 , 5524629500 , 9999990000
    @DataProvider(name = "MxTelNoPositiveTest")
    public static Object[][] createMxValidTestData() {
        return new Object[][] {
                { "valid_1", "2221000000" },
                { "valid_2", "5517093000" },
                { "valid_3", "9999989999" }
        };
    }
    @DataProvider(name = "MxTelNoNegativeTest")
    public static Object[][] createMxInvalidTestData() {
        return new Object[][] {
                { "invalid_1", "2220000000" },
                { "invalid_2", "5524629500" },
                { "invalid_3", "9999990000" },
                { "invalid_short_4", "099990000" },          // short and start with zero
                { "invalid_long_5", "999999000034234234" }  // long
        };
    }

    //Valid : 2221000000 , 5517093000 , 9999989999    Invalid : 2220000000 , 5524629500 , 9999990000
    @DataProvider(name = "MxTelNoAllTestData")
    public static Object[][] createMxPhoneTestData() {
        return new Object[][] {
                { "valid_1", "2221000000"   },
                { "valid_3", "9999989999"   },
                { "invalid_1", "2220000000" },
                { "invalid_2", "5524629500" },
                { "invalid_3", "9999990000" },
                { "valid_2", "5517093000"   },
                { "invalid_short_4", "099990000" },          // short and start with zero
                { "invalid_long_5", "999999000034234234" }  // long
        };
    }

    @DataProvider(name = "saTopCountrieBean")//, parallel = true)
    public static Object[][] saTopCountrieBean() {
        return new Object[][]{
                {new CountryBean("Saudi Arabia", "sa", "ar", "", "/ar-sa/", false, "+966-5", "+966", "7878-7878")},
                {new CountryBean("Bahrain",      "bh", "ar", "", "/ar-sa/", false, "+973-3", "+973", "4444-4119")},
                {new CountryBean("Oman",         "om", "ar", "", "/ar-sa/", false, "+968-9", "+968-2", "0800-44-41719")},
        };
    }

    // costa rica
    @DataProvider(name = "CrMobTelNoTestData")
    public static Object[][] createCostaRicaMobilPhoneNoTestData() {
        return new Object[][] {
                { "valid_1",   "88888888"  },  //  movil +506-8888-8888
                { "invalid_1", "99999999"  }
        };
    }
    @DataProvider(name = "CrHomeTelNoTestData")
    public static Object[][] createCostaRicaHomePhoneNoTestData() {
        return new Object[][] {
                { "valid_1",   "22222222"  },  //  home  +506-2222-2222
                { "invalid_1", "77777777"  }
        };
    }

}
