package com.englishtown.dataprovider;

/**
 * Created by nikol.marku on 2017.
 */

import com.englishtown.dataprovider.bin.MaintenanceUrlBean;



public class MaintenanceDataProvider {

    @org.testng.annotations.DataProvider(name = "getMaintenaceUrls")//, parallel = true)
    public static Object[][] getMaintenaceUrlsBeans() {
        return new Object[][]{
                //new Object[]{new MaintenanceUrlBean("englishlive.ef.com/pt-br/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/pt-br/planos-e-precos-dos-cursos-de-ingles/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/pt-br/lp/ee/ee_apr16-b/", "lp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/en-gb/resources/english-tools/earning-calculator/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/en-gb/lp/os/learn-english-online-ef/",   "lp")},
                //new Object[]{new MaintenanceUrlBean("englishlive.ef.com/es-mx/como-aprender-ingles/?ctr=mx",     "sp")},
                //new Object[]{new MaintenanceUrlBean("englishlive.ef.com/es-mx/lp/oe/promo-upgrade-g/?ctr=mx",    "lp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/de-de/angebote-und-preise/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/de-de/lp/ee/learn-english/", "lp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/fr-fr/formations-et-tarifs/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/fr-fr/lp/oe/privateteacher/", "lp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/es-es/planes-y-precios/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/es-es/lp/os/learn-english-online-01/", "lp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/it-it/imparare-l-inglese/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/it-it/lp/ot/efset-test-livello-inglese/", "lp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/ja-jp/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/ja-jp/buy/default/member/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/en-us/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/en-us/free-consultation/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/zh-tw/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/zh-tw/lp/oe/biggest_online_2016_01_11/", "lp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/ko-kr/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/tr-tr/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/fr-wws/?ctr=pf", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/de-wws/?ctr=at", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/en-wws/study-plans-and-prices/?ctr=de", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/en-wws/lp/oe/automation-test-01-general-english-v1111/?ctr=lc", "lp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/fr-wws/formations-et-tarifs/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishlive.ef.com/de-wws/lp/ee/learn-english/?ctr=at", "sp")},
                new Object[]{new MaintenanceUrlBean("englishcenters.ef.com/academia-ingles-barcelona/", "sp")},
                new Object[]{new MaintenanceUrlBean("englishcenters.ef.com/lp/ft/academiasingles14d/", "lp")},
                new Object[]{new MaintenanceUrlBean("emailenglish.net/es-mx/lp/ee/email_english/?ctr=mx", "lp")},
                new Object[]{new MaintenanceUrlBean("emailenglish.net/es-mx/?ctr=mx", "sp")},
                //new Object[]{new MaintenanceUrlBean("englishlive.ef.com/", "sp")},
                new Object[]{new MaintenanceUrlBean("efenglishtown.com/fr-fr/lp/oe/home/ ", "lp")},
                new Object[]{new MaintenanceUrlBean("efenglishtown.com/fr-fr/", "sp")},
                //new Object[]{new MaintenanceUrlBean("englishlive.ef.com/es-mx/in-maintenance-sp/?ctr=mx", "sp")},
        };
    }


}
