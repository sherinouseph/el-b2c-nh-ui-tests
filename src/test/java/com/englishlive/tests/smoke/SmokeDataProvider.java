package com.englishlive.tests.smoke;

import com.englishtown.dataprovider.bin.SmokeTestBean;
import com.englishtown.dataprovider.bin.SmokeTestBeanNew;
import com.englishtown.tests.core.SmokeBaseTest;

/**
* user for generating data to be feed to the testcases
*  e.g @Test(dataProvider = "create", dataProviderClass = SmokeDataProvider.class)
*/
public class SmokeDataProvider {
    /**
     * Replace etcqpub3 with etcqpub4 to run on pub 4 server
     * @return
     */
    @org.testng.annotations.DataProvider(name = "Pub3TestUrls", parallel = true)
    public static Object[][] createPubTestUrls() {
        return new Object[][] { // was usb-etcqpub3.englishtown.com
                { "de",     "http://10.162.82.101:4503/content/englishtown/de/de.html"},
                { "de_member",     "http://10.162.82.101:4503/content/englishtown/de/de/buy/default/member.html"},
                { "de_pp",  "http://10.162.82.101:4503/content/englishtown/de/de/angebote-und-preise.html"},
                { "de_os",  "http://10.162.82.101:4503/content/englishtown/de/de/lp/os/automation-test-01-stwt.html"},
                { "fr",     "http://10.162.82.101:4503/content/englishtown/fr/fr.html"},
                { "fr_pp",  "http://10.162.82.101:4503/content/englishtown/fr/fr/formations-et-tarifs.html"},
                { "jp",     "http://10.162.82.101:4503/content/englishtown/jp/ja.html"},
                { "jp_pp",  "http://10.162.82.101:4503/content/englishtown/jp/ja/study-plans-and-prices.html"},
                { "mx",     "http://10.162.82.101:4503/content/englishtown/mx/es.html"},
                { "sa",     "http://10.162.82.101:4503/content/englishtown/sa/ar.html"},
//                { "sa_pp",  "http://10.162.82.101:4503/content/englishtown/sa/ar/study-plans-and-prices.html"},
                { "tw",     "http://10.162.82.101:4503/content/englishtown/tw/zh.html"},
      //          { "tw_pp",  "http://10.162.82.101:4503/content/englishtown/tw/zh/study-plans-and-prices.html"},
                { "br",     "http://10.162.82.101:4503/content/englishtown/br/pt.html"},
               // { "br",     "http://10.162.82.101:4503/content/englishtown/br/pt/planos-e-precos-dos-cursos-de-ingles.html"},
                { "ag",     "http://10.162.82.101:4503/content/englishtown/wws/en.html?ctr=ag"},
                { "at",     "http://10.162.82.101:4503/content/englishtown/wws/de.html"},
                { "be",     "http://10.162.82.101:4503/content/englishtown/wws/fr.html"},
                { "ec",     "http://10.162.82.101:4503/content/efec/es/es.html"},
                { "ec_ft",  "http://10.162.82.101:4503/content/efec/es/es/lp/ft/centers-fb-ma.html"},
                { "be_ce",  "http://10.162.82.101:4503/content/efec/es/es/lp/ce/financiacion.html"},
        };
    }





    //This method will provide data to any test method that declares that its Data Provider
    @org.testng.annotations.DataProvider(name = "testUrls")
    public static Object[][] createHomePageUrls() {
        return new Object[][] {
               // { "br", ".englishtown.com.br/"},
                { "ru","englishlive.ef.com/ru-ru/" },
                { "de","englishlive.ef.com/de-de/" },
                { "fr","englishlive.ef.com/fr-fr/" },
                //                { "it",".englishtown.it/" },
                { "ja","englishlive.ef.com/ja-jp/" },
            //                { "gb",".englishtown.com/en-gb/" }
            //                { "mx", ".englishtown.com/es-mx/"}
        };
    }
    @org.testng.annotations.DataProvider(name = "testUrlsPub")
    public static Object[][] createHomePageUrlsPub() {
        return new Object[][] {
                { "br",".englishtown.com/pt-br/"},
                { "de",".englishtown.com/de-de/" },
                { "fr",".englishtown.com/fr-fr/" },
//                { "it",".englishtown.com/it-it/" },
                { "ja",".englishtown.com/ja-jp/" },
//                { "gb",".englishtown.com/en-gb/" }
//                { "mx", ".englishtown.com/es-mx/"}
        };
    }

    @org.testng.annotations.DataProvider(name = "createHomePageUrlsAll")
    public static Object[][] createHomePageUrlsAll() {
        return new Object[][] {
                { "br", "englishlive.ef.com/pt-br/"},
                { "de", "englishlive.ef.com/de-de/" },
                { "fr", "englishlive.ef.com/fr-fr/" },
                { "it", "englishlive.ef.com/it-it/" },
                { "jp", "englishlive.ef.com/ja-jp/" },
                { "gb", "englishlive.ef.com/en-gb/" },
                { "mx", "englishlive.ef.com/es-mx/"},
                { "sa", "englishlive.ef.com/ar-sa/?ctr=sa"}
 //              { "ag", "englishlive.ef.com/en-wws/?ctr=ag"},
 //              { "be", "englishlive.ef.com/fr-wws/?ctr=be"},
 //              { "at", "englishlive.ef.com/de-wws/?ctr=at"},

        };
    }

    @org.testng.annotations.DataProvider(name = "testUrlsAll")
    public static Object[][] createLoginPageUrlsAll() {
        return new Object[][] {
                { "br", ".englishtown.com.br/login"},
                { "de",".englishtown.de/login" },
                { "fr",".englishtown.fr/login" },
                { "it",".englishtown.it/login" },
                { "jp",".englishtown.co.jp/login" },
                { "sa",".englishtown.com/en-sa/login" },
                { "gb",".englishtown.com/en-gb/login" },
                { "in",".englishtown.com/en-in/login" },
                { "ca",".englishtown.com/en-ca/login" },
                { "es",".englishtown.es/login" },
                { "mx", ".englishtown.com/es-mx/login"}
        };
    }

    /**
     * Create objects   int id, String country, String url, String selector
     */
    private static String tryUsMiddleBtn   =".column0 .btn.btn-primary";
    protected static String tryUsMidleBtnNewDesign = SmokeBaseTest.checkContentCss;
    private static String tryUsMiddleBtnBr =".active .column0 .btn.btn-primary";
    protected static String midleBtnRu= ".percent90 .column0 a";

    @org.testng.annotations.DataProvider(name = "smokeTestBeanTryClickMiddle")
    public static Object[][] createSmokeTestBeanTryClickMiddle() {
        return new Object[][] {
                //{ new SmokeTestBean( 0, "br", "englishlive.ef.com/pt-br/",    tryUsMiddleBtnBr)},
                //{ new SmokeTestBean( 4, "ru","englishlive.ef.com/ru-ru/",   midleBtnRu)  },
                { new SmokeTestBean( 1, "de","englishlive.ef.com/de-de/",   SmokeBaseTest.checkContentCss)  },
                { new SmokeTestBean( 2, "fr","englishlive.ef.com/fr-fr/",   tryUsMiddleBtn)  },
                { new SmokeTestBean( 3, "gb","englishlive.ef.com/en-gb/",   SmokeBaseTest.checkContentCss)  },
                { new SmokeTestBean( 3, "it","englishlive.ef.com/it-it/",   SmokeBaseTest.checkContentCss)  },
                //{ new SmokeTestBean( 4, "mx", ".englishtown.com/es-mx/",    SmokeBaseTest.checkContentCss)  }
        };
    }

    @org.testng.annotations.DataProvider(name = "301Urls", parallel = true)
    public static Object[][] create301Urls() {
        return new Object[][] {
            {"tryUs", "englishlive.ef.com/ru-ru/%D0%B2%D0%B0%D1%80%D0%B8%D0%B0%D0%BD%D1%82%D1%8B-%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC-%D0%B8-%D1%86%D0%B5%D0%BD%D1%8B/"},
            { "", "englishlive.ef.com/es-mx/oe-free-consultation/" },
            { "", "englishlive.ef.com/fr-fr/apprendre-l-anglais-en-ligne/cours-d-anglais/" },
            { "", "englishlive.ef.com/es-mx/checkout-redirect/" },
            { "", "englishlive.ef.com/fr-fr/freeconsultation/" },
            { "", "englishlive.ef.com/de-de/englisch-lernen-online/englischkurs/" },
            { "", "englishlive.ef.com/es-us/affiliate-program/" },
            { "", "englishlive.ef.com/es-pe/checkout-redirect/" },
            { "", "englishlive.ef.com/es-co/checkout-redirect/" },
            { "", "englishlive.ef.com/es-ve/checkout-redirect/" },
            { "", "englishlive.ef.com/es-cl/checkout-redirect/" },
            { "", "englishlive.ef.com/es-wws/checkout-redirect/" },
            { "", "englishlive.ef.com/es-us/checkout-redirect/" },
            { "", "englishlive.ef.com/fr-fr/apprendre-l-anglais-en-ligne/cours-d-anglais/" },
            { "", "englishlive.ef.com/ar-sa/checkout-redirect/" },
            { "", "englishlive.ef.com/en-gb/learn-english-online/learn-english-app/" },
            { "", "englishlive.ef.com/es-mx/planes-y-precios/" },
            { "", "englishlive.ef.com/de-de/englisch-lernen-online/englisch-lernen-app/" },
            { "", "englishlive.ef.com/de-wws/englisch-lernen-online/englischkurs/" },
            { "", "englishlive.ef.com/es-pe/planes-y-precios/" },
            { "", "englishlive.ef.com/es-co/planes-y-precios/" },
            { "", "englishlive.ef.com/es-ve/planes-y-precios/" },
            { "", "englishlive.ef.com/es-cl/planes-y-precios/" },
            { "", "englishlive.ef.com/es-wws/planes-y-precios/" },
            { "", "englishlive.ef.com/fr-wws/apprendre-l-anglais-en-ligne/lessons-and-levels/" },
            { "", "englishlive.ef.com/fr-fr/apprendre-l-anglais-en-ligne/lessons-and-levels/" },
            { "", "englishlive.ef.com/ar-wws/checkout-redirect/" },
            { "", "englishlive.ef.com/en-gb/checkout-redirect/" },
            { "", "englishlive.ef.com/en-wws/checkout-redirect/" },
            { "", "englishlive.ef.com/fr-fr/old-study-plans-and-prices/" },
            { "", "englishlive.ef.com/en-wws/study-plans-and-prices/" },
            { "", "englishlive.ef.com/it-it/lezioni-di-inglese/pronuncia-inglese/" }
        };
    }
    @org.testng.annotations.DataProvider(name = "smokeTestBeannew")//, parallel = true)
    public static Object[][] createSmokeTestBean() {
        return new Object[][] {
                { new SmokeTestBeanNew( "de", "englishlive.ef.com/de-de/","a[href$='und-preise/']","a[href$='einloggen/']",".caption h1","Englisch",false )  },
                { new SmokeTestBeanNew( "gb", "englishlive.ef.com/en-gb/","a[href$='and-prices/']","a[href$='login/']",".caption h1","lessons online",false )  },
                { new SmokeTestBeanNew( "fr", "englishlive.ef.com/fr-fr/","a[href$='formations-et-tarifs/']","a[href$='connexion/']",".caption h1","Apprenez l'anglais" ,false)  },
                { new SmokeTestBeanNew( "it", "englishlive.ef.com/it-it/","a[href$='free-consultation/']","a[href$='login/']",".caption h1","insegnanti live",false )  },
                //{ new SmokeTestBeanNew( "mx", "englishlive.ef.com/es-mx/","a[href$='free-consultation/']","a[href$='ingresar-escuela/']",".caption h1","Cursos de",true )  },
                // running 2 sitest { new SmokeTestBeanNew( "br", "englishlive.ef.com/pt-br/","a[href$='cursos-de-ingles/']","svg .icon-profile",".caption h1","Alunos e professores",true )  },
        };
    }


}
