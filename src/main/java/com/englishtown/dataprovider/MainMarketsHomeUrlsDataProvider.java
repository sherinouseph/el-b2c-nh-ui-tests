package com.englishtown.dataprovider;
/**
 * Create homepage URLs for main markets
 */
import com.englishtown.dataprovider.bin.CountryPhoneUrlBean;
import com.englishtown.dataprovider.bin.GullUrlBean;
import com.englishtown.dataprovider.bin.PhoneUrlBean;
import com.englishtown.dataprovider.bin.UrlBeanWithCountry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainMarketsHomeUrlsDataProvider {
    private static final Logger logger = LoggerFactory.getLogger(MainMarketsHomeUrlsDataProvider.class);


    @org.testng.annotations.DataProvider(name = "mainMarketHomePages")//, parallel = true)
    public static Object[][] getMainMarketHomePage() {
        return new Object[][]{
                {false ,     "englishlive.ef.com/fr-fr/"},
                {false,     "englishlive.ef.com/de-de/"},
                {false,     "englishlive.ef.com/en-gb/"},
                {false,     "englishlive.ef.com/es-mx/"},
                {false,     "englishlive.ef.com/en-us/"},
                {false ,     "englishlive.ef.com/tr-tr/"},
                {false ,     "englishlive.ef.com/zh-tw/"},
                {false ,     "englishlive.ef.com/th-th/"},//true
                {false ,     "englishlive.ef.com/id-id/"},
                {false ,     "englishlive.ef.com/ko-kr/"},//true
                {true ,     "englishlive.ef.com/ja-jp/"},
                {true ,     "englishlive.ef.com/pt-br/"}
                //{false,     "englishlive.ef.com/ar-sa/"}, login btn is using secondary
                //{false,     "englishlive.ef.com/it-it/"}, css diff
        };
    }
    // handle 3 types of login pages
    @org.testng.annotations.DataProvider(name = "mainMarketHomePagesLogin")//, parallel = true)
    public static Object[][] getMainMarketHomePageLogin() {
        return new Object[][]{
                // Str old new latest login page
                {"latest" ,  "englishlive.ef.com/fr-fr/"},
                {"latest",   "englishlive.ef.com/de-de/"},
                {"latest",   "englishlive.ef.com/it-it/"},
                {"latest" ,  "englishlive.ef.com/id-id/"},
                {"latest",   "englishlive.ef.com/en-gb/"},
                {"latest" ,  "englishlive.ef.com/tr-tr/"},
                {"latest",   "englishlive.ef.com/es-mx/"},
                {"latest" ,  "englishlive.ef.com/th-th/"},
                {"latest" ,  "englishlive.ef.com/ko-kr/"},
                {"latest" ,     "englishlive.ef.com/ja-jp/"},
                {"latest",   "englishlive.ef.com/ar-sa/"},
                {"old" ,     "englishlive.ef.com/pt-br/"},
        };
    }


    @org.testng.annotations.DataProvider(name = "mainMarketResetPassUrls")//, parallel = true)
    public static Object[][] getMainMarketResetPassUrls() {
        return new Object[][]{
                {"fr" ,     "englishlive.ef.com/fr-fr/reset-password/"},
                {"it" ,     "englishlive.ef.com/it-it/reset-password/"},
                {"id" ,     "englishlive.ef.com/id-id/reset-password/"},
                {"de" ,     "englishlive.ef.com/de-de/reset-password/"},
                {"gb" ,     "englishlive.ef.com/en-gb/reset-password/"},
                {"mx" ,     "englishlive.ef.com/es-mx/reset-password/"},
                {"us" ,     "englishlive.ef.com/en-us/reset-password/"},
                {"tr" ,     "englishlive.ef.com/tr-tr/reset-password/"},
                {"tw" ,     "englishlive.ef.com/zh-tw/reset-password/"},
                {"th" ,     "englishlive.ef.com/th-th/reset-password/"},
                {"id" ,     "englishlive.ef.com/id-id/reset-password/"},
                {"kr" ,     "englishlive.ef.com/ko-kr/reset-password/"},
                {"ja" ,     "englishlive.ef.com/ja-jp/reset-password/"},
                {"sa" ,     "englishlive.ef.com/ar-sa/reset-password/"},
                {"br" ,     "englishlive.ef.com/pt-br/reset-password/"}
        };
    }


    /**
     * Homepage urls with state object page.name
     * @return
     */
    @org.testng.annotations.DataProvider(name = "mainMarketHomePagesAndPageNames")//, parallel = true)
    public static Object[][] getMainMarketHomePageWithPageTitle() {
        return new Object[][]{
                {"SalesPages:Home",    "englishlive.ef.com/fr-fr/"},
                {"SalesPages:Home",     "englishlive.ef.com/it-it/"},
                {"SalesPages:Home" ,    "englishlive.ef.com/id-id/"},
                {"SalesPages:Home",     "englishlive.ef.com/de-de/"},
                {"SalesPages:Home",     "englishlive.ef.com/en-gb/"},
                {"SalesPages:Home",     "englishlive.ef.com/es-mx/"},
                {"SalesPages:Home",     "englishlive.ef.com/en-us/"},
                {"SalesPages:Home" ,    "englishlive.ef.com/tr-tr/"},
                //{"SalesPages:Home" ,    "englishlive.ef.com/es-es/"},
                {"SalesPages:Home" ,    "englishlive.ef.com/zh-tw/"},
                {"SalesPages:Home" ,    "englishlive.ef.com/th-th/"},
                {"SalesPages:Home" ,    "englishlive.ef.com/id-id/"},
                {"SalesPages:Home" ,    "englishlive.ef.com/ko-kr/"},
                {"SalesPages:Home" ,    "englishlive.ef.com/ja-jp/"},
                {"SalesPages:Home",     "englishlive.ef.com/ar-sa/"},
                //{"SalesPages:site2018" ,    "englishlive.ef.com/pt-br/"},
                //{"SalesPages:Home",     "englishlive.ef.com/en-wws/?ctr=gb"},
               // {"SalesPages:Home",     "englishlive.ef.com/ar-wws/?ctr=sa"}

        };
    }

    @org.testng.annotations.DataProvider(name = "mainMarketHomePagesAndCtr")//, parallel = true)
    public static Object[][] getMainMarketHomePageWithCtr() {
        return new Object[][]{
                {"fr",    "englishlive.ef.com/fr-fr/?ctr=fr"},
                {"it",     "englishlive.ef.com/it-it/"},
                {"id" ,    "englishlive.ef.com/id-id/"},
                {"de",     "englishlive.ef.com/de-de/?ctr=de"},
                {"gb",     "englishlive.ef.com/en-gb/?ctr=gb"},
                {"mx",     "englishlive.ef.com/es-mx/?ctr=mx"},
                {"us",     "englishlive.ef.com/en-us/"},
                {"tr" ,    "englishlive.ef.com/tr-tr/"},
                {"tw" ,    "englishlive.ef.com/zh-tw/"},
                {"th" ,    "englishlive.ef.com/th-th/"},
                {"kr" ,    "englishlive.ef.com/ko-kr/"},
                {"jp" ,    "englishlive.ef.com/ja-jp/"},
                {"br" ,    "englishlive.ef.com/pt-br/"},
                //{"gb",     "englishlive.ef.com/en-wws/?ctr=gb"},
                {"sa",     "englishlive.ef.com/ar-sa/?ctr=sa"},
               // {"zh",     "englishlive.ef.com/fr-wws/?ctr=zh"},
                {"ae",     "englishlive.ef.com/ar-sa/?ctr=ae"},
                {"eg",     "englishlive.ef.com/ar-sa/?ctr=eg"},
                // failed QA on 23/04 18 removed as not important {"co",     ".emailenglish.net/es-co/lp/ee/email_english/"},   // goes 2 es-mx
                //failed QA on 23/04 18 removed as not important {"co",     ".efenglishtown.com/es-co/lp/oe/home/"}
        };
    }
    // this is not used see above
    @org.testng.annotations.DataProvider(name = "getUrlBeanWithCountry", parallel = true)
    public static Object[][] getUrlBeanWithCountry() {
        return new Object[][]{
                new Object[]{new UrlBeanWithCountry("fr", "englishlive.ef.com/fr-fr/")},
                new Object[]{new UrlBeanWithCountry("it", "englishlive.ef.com/it-it/")},
                new Object[]{new UrlBeanWithCountry("id", "englishlive.ef.com/id-id/")},
                new Object[]{new UrlBeanWithCountry("de", "englishlive.ef.com/de-de/")},
                new Object[]{new UrlBeanWithCountry("gb", "englishlive.ef.com/en-gb/")},
                new Object[]{new UrlBeanWithCountry("mx", "englishlive.ef.com/es-mx/?ctr=mx")},
                new Object[]{new UrlBeanWithCountry("us", "englishlive.ef.com/en-us/")},
                new Object[]{new UrlBeanWithCountry("tr", "englishlive.ef.com/tr-tr/")},
                //new Object[]{new UrlBeanWithCountry("es", "englishlive.ef.com/es-es/")},
                new Object[]{new UrlBeanWithCountry("tw", "englishlive.ef.com/zh-tw/")},
                new Object[]{new UrlBeanWithCountry("th", "englishlive.ef.com/th-th/")},
                new Object[]{new UrlBeanWithCountry("id", "englishlive.ef.com/id-id/")},
                new Object[]{new UrlBeanWithCountry("kr", "englishlive.ef.com/ko-kr/")},
                new Object[]{new UrlBeanWithCountry("jp", "englishlive.ef.com/ja-jp/")},
                new Object[]{new UrlBeanWithCountry("gb", "englishlive.ef.com/ar-sa/")}, // as it is wws site
                new Object[]{new UrlBeanWithCountry("br", "englishlive.ef.com/pt-br/")}
        };
    }

    @org.testng.annotations.DataProvider(name = "mainMarketHomePagesAndPhoneNo")//, parallel = true)
    public static Object[][] getMainMarketHomePageWithPhoneNo() {
        return new Object[][]{
                //ar-sa
                //new Object[] {new PhoneUrlBean(".text-number", "00441138591123",       "englishlive.ef.com/ar-sa/?ctr=sa")},

                new Object[] {new CountryPhoneUrlBean(".call span",   "09.74.48.00.40",       "englishlive.ef.com/fr-fr/")},//css selector".text-number",
                new Object[] {new CountryPhoneUrlBean(".call span",   "02-94756336",          "englishlive.ef.com/it-it/")},                //{"" ,    "englishlive.ef.com/id-id/")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "+49 211 36874204",     "englishlive.ef.com/de-de/")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "+44 20 3322 9565",     "englishlive.ef.com/en-gb/")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "800-236-1000",      "englishlive.ef.com/es-mx/?ctr=mx")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "0800-44-41719",        "englishlive.ef.com/es-mx/?ctr=ar")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "1-888-258-7088",       "englishlive.ef.com/en-us/")},
               // new Object[] {new CountryPhoneUrlBean(".call span", "+90 216 900 16 43" ,   "englishlive.ef.com/tr-tr/")},
                //new Object[] {new CountryPhoneUrlBean(".call span", "+34 944 580 468" ,     "englishlive.ef.com/es-es/")},
               // new Object[] {new CountryPhoneUrlBean(".text-number", "03 (6892) 0001",       "englishlive.ef.com/ja-jp/")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "السعودية: 8008140285", "englishlive.ef.com/ar-sa/")},   //السعودية:   8008140286
               // new Object[] {new CountryPhoneUrlBean(".text-number", "0800 600 5858",        "englishlive.ef.com/pt-br/")},
                //new Object[] {new CountryPhoneUrlBean(".text-number", "+44 20 3322 9565",     "englishlive.ef.com/en-wws/?ctr=gb")},
                //new Object[] {new CountryPhoneUrlBean(".text-number", "09.74.48.00.40",       "englishlive.ef.com/fr-wws/?ctr=zh")},
                //new Object[] {new CountryPhoneUrlBean(".call span",   "+49 211 36874204",     "englishlive.ef.com/de-wws/?ctr=zh")}
                /*{"" ,    "englishlive.ef.com/zh-tw/")},
        new Object[] {new CountryPhoneUrlBean("" ,    "englishlive.ef.com/th-th/")},
        new Object[] {new CountryPhoneUrlBean("" ,    "englishlive.ef.com/ko-kr/")},*/
        };
    }

    @org.testng.annotations.DataProvider(name = "mainMarketMaintenacePages")//, parallel = true)
    public static Object[][] getMainMarketMaintenancePages() {
        return new Object[][]{
                //ar-sa
                //new Object[] {new PhoneUrlBean(".text-number", "00441138591123",       "englishlive.ef.com/ar-sa/?ctr=sa")},
                //
                new Object[] {new CountryPhoneUrlBean(".text-number", "09.74.48.00.40",       "englishlive.ef.com/fr-fr/in-maintenance-sp")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "02-94756336",          "englishlive.ef.com/it-it/in-maintenance-sp")},                //{"" ,    "englishlive.ef.com/id-id/")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "+49 211 36874204",     "englishlive.ef.com/de-de/in-maintenance-sp")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "+44(0) 20 3322 9565",  "englishlive.ef.com/en-gb/in-maintenance-sp")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "01-800-236-1000",      "englishlive.ef.com/es-mx/in-maintenance-sp/?ctr=mx")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "0800-44-41719",        "englishlive.ef.com/es-mx/in-maintenance-sp/?ctr=ar")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "1-888-258-7088",       "englishlive.ef.com/en-us/in-maintenance-sp")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "+90 216 900 16 43" ,   "englishlive.ef.com/tr-tr/in-maintenance-sp")},
               // new Object[] {new CountryPhoneUrlBean(".text-number", "+34 944 580 468" ,     "englishlive.ef.com/es-es/in-maintenance-sp")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "03 (6892) 0001",       "englishlive.ef.com/ja-jp/in-maintenance-sp")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "السعودية: 8008140286", "englishlive.ef.com/ar-sa/in-maintenance-sp")},   //السعودية:   8008140286
                new Object[] {new CountryPhoneUrlBean(".text-number", "0800 600 5858",        "englishlive.ef.com/pt-br/in-maintenance-sp")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "0800 600 5858",        "englishlive.ef.com/id-id/in-maintenance-sp")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "0800 600 5858",        "englishlive.ef.com/zh-tw/in-maintenance-lp/")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "+44(0) 20 3322 9565",  "englishlive.ef.com/en-wws/in-maintenance-sp/?ctr=gb")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "09.74.48.00.40",       "englishlive.ef.com/fr-wws/in-maintenance-sp/?ctr=zh")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "+49 211 36874204",     "englishlive.ef.com/de-wws/in-maintenance-sp/?ctr=zh")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "09.74.48.00.40",       "englishlive.ef.com/fr-fr/in-maintenance-lp")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "02-94756336",          "englishlive.ef.com/it-it/in-maintenance-lp")},                //{"" ,    "englishlive.ef.com/id-id/")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "+49 211 36874204",     "englishlive.ef.com/de-de/in-maintenance-lp")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "+44(0) 20 3322 9565",  "englishlive.ef.com/en-gb/in-maintenance-lp")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "01-800-236-1000",      "englishlive.ef.com/es-mx/in-maintenance-lp/?ctr=mx")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "0800-44-41719",        "englishlive.ef.com/es-mx/in-maintenance-lp/?ctr=ar")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "1-888-258-7088",       "englishlive.ef.com/en-us/in-maintenance-lp/")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "+90 216 900 16 43" ,   "englishlive.ef.com/tr-tr/in-maintenance-lp/")},
               // new Object[] {new CountryPhoneUrlBean(".text-number", "+34 944 580 468" ,     "englishlive.ef.com/es-es/in-maintenance-lp/")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "03 (6892) 0001",       "englishlive.ef.com/ja-jp/in-maintenance-lp/")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "السعودية: 8008140286", "englishlive.ef.com/ar-sa/in-maintenance-lp/")},   //السعودية:   8008140286
                new Object[] {new CountryPhoneUrlBean(".text-number", "0800 600 5858",        "englishlive.ef.com/pt-br/in-maintenance-lp/")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "0800 600 5858",        "englishlive.ef.com/id-id/in-maintenance-lp/")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "0800 600 5858",        "englishlive.ef.com/zh-tw/in-maintenance-lp/")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "+44(0) 20 3322 9565",  "englishlive.ef.com/en-wws/in-maintenance-lp/?ctr=gb")},
                new Object[] {new CountryPhoneUrlBean(".text-number", "09.74.48.00.40",       "englishlive.ef.com/fr-wws/in-maintenance-lp/?ctr=zh")},
                new Object[] {new CountryPhoneUrlBean(".call span",   "+49 211 36874204",     "englishlive.ef.com/de-wws/in-maintenance-lp/?ctr=zh")},
                //
                new Object[] {new CountryPhoneUrlBean("",   "",     "englishlive.ef.com/school/")},
                new Object[] {new CountryPhoneUrlBean("",   "",     "emailenglish.net/es-mx/?ctr=mx")},   //www.
                new Object[] {new CountryPhoneUrlBean("",   "",     "englishtown.com.br/lp/oe/upsell_pdf_shopping/")},
                new Object[] {new CountryPhoneUrlBean("",   "",     "englishtown.com.br/")},
                new Object[] {new CountryPhoneUrlBean("",   "",     "efenglishtown.com/es-mx/lp/oe/home/")}
                /*{"" ,    "englishlive.ef.com/zh-tw/")},
        new Object[] {new CountryPhoneUrlBean("" ,    "englishlive.ef.com/th-th/")},
        new Object[] {new CountryPhoneUrlBean("" ,    "englishlive.ef.com/ko-kr/")},*/
        };
    }

    @org.testng.annotations.DataProvider(name = "ArSaPhoneUrl", parallel = true)
    public static Object[][] getArSaPhoneUrl() {
        return new Object[][]{
                //ar-sa
                new Object[]{new PhoneUrlBean(".phone-icon-and-number span", "السعودية: 8008140285", "بريطانيا: 00441138591123", "englishlive.ef.com/ar-sa/?ctr=sa")},
                new Object[]{new PhoneUrlBean(".phone-icon-and-number span", "بريطانيا: 00441138591123", "", "englishlive.ef.com/ar-sa/?ctr=om")},
                new Object[]{new PhoneUrlBean(".phone-icon-and-number span", "بريطانيا: 00441138591123", "", "englishlive.ef.com/ar-sa/?ctr=eg")}
        };
    }

    /**
     * Gulf: Bahrain, UAE, Kuwait, Oman, Qatar, Saudi Arabia - Blue CTA on P&P page should take you to FREE CONSULTATION
     Non-gulf: EG SD YE IQ JO LB SY DZ MA LY TN - Blue CTA on P&P should CALL
     */
    @org.testng.annotations.DataProvider(name = "ArSaUrlsGulfNoGalf")//, parallel = true)
    public static Object[][] getArSaUrlsGulfNoGalfl() {
        return new Object[][]{
                //Bahrain, UAE, Kuwait, Oman, Qatar, Saudi Arabia
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=sa", true)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=om", true)},
                //new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=qa", true)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=bh", true)},
                //new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=kw", true)},
                // EG SD YE IQ JO LB SY DZ MA LY TN
              /*  new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=sd", false)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=ye", false)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=iq", false)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=jo", false)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=lb", false)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=sy", false)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=dz", false)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=ma", false)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=ly", false)},*/
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=eg", false)},
                new Object[]{new GullUrlBean("englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=tn", false)},
        };
    }


}
