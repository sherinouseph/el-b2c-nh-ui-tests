package com.englishtown.dataprovider;

import com.englishtown.dataprovider.bin.UrlRedirectBean;
import com.englishtown.tests.core.EfConstants;

import com.englishtown.util.db.core.DbManager;
import com.englishtown.util.db.core.MyDbConnect;
import com.englishtown.util.db.testdbbean.TestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by nikol.marku on 11/11/2015.
 */
public class UrlMonitoringDataProvider {
    private static final Logger logger = LoggerFactory.getLogger(UrlMonitoringDataProvider.class);

    /**
     * Note: before calling to this a connection to DB has to be established
     *
     *
     */
    @DataProvider(name = "monitorUrlsBeam")
    public static Object[][] createUrlMonitTestDataBean() {
        logger.info("Get URL List for DB ...!");
        List<TestBean> testBeans = DbManager.getTestBeans(DbManager.SELECT_TESTS_SQL);

        Object[][] urlBeansObjArray = new Object[testBeans.size()][1];

        int count = 0;

        for (TestBean testBean : testBeans) {
            urlBeansObjArray[count][0] = testBean;
            count++;
        }

        return urlBeansObjArray;
    }


    @DataProvider(name = "monitorUrls")
    public static Object[][] createUrlMonitoringData() {
        return new Object[][] {
                // urlID see DB test table    :  url                                                       // test data                /*{38 , "http://englishlive.ef.com/it-it/" },              {44 , "http://englishlive.ef.com/fr-fr/" },                {51 , "http://englishlive.ef.com/de-de/" }*/
                {   5, "http://englishlive.ef.com/en-wws/lp/oe/automation-test-01-general-english-v1111/?ctr=fi" } ,
                {   6, "http://englishlive.ef.com/fr-wws/lp/oe/automation-test-01-lp-private-teacher/?ctr=pf" } ,
                {   7, "http://englishlive.ef.com/en-wws/lp/oe/automation-test-01-general-english-v1111/?ctr=lc" } ,
                {   8, "https://englishlive.ef.com/ar-wws/buy/default/member/?ctr=sa&offerid=9502" } ,
                {   9, "https://englishlive.ef.com/fr-wws/buy/default/member/?ctr=be&offerid=2006" } ,
                {  10, "https://englishlive.ef.com/de-wws/buy/default/member/?ctr=at&offerid=2006" } ,
                {  11, "https://englishlive.ef.com/en-wws/buy/default/member/?ctr=in&offerid=2006" } ,
                {  12, "https://englishlive.ef.com/es-us/buy/default/member/" } ,
                {  13, "https://englishlive.ef.com/en-us/buy/default/member/" } ,
                {  14, "http://englishlive.ef.com/en-us/" } ,
                {  15, "https://englishlive.ef.com/zh-tw/buy/default/member/" } ,
                {  16, "http://englishlive.ef.com/zh-tw/" } ,
                {  17, "http://englishlive.ef.com/tr-tr/lp/os/general-english-v1/" } ,
                {  18, "https://englishlive.ef.com/tr-tr/buy/default/member/" } ,
                {  19, "http://englishlive.ef.com/tr-tr/" } ,
                {  20, "https://englishlive.ef.com/th-th/buy/default/member/" } ,
                {  21, "http://englishlive.ef.com/th-th/" } ,
                {  22, "https://englishlive.ef.com/en-se/buy/default/member/" } ,
                {  23, "http://englishlive.ef.com/ar-sa/lp/os/toefl-0111/" } ,
                {  24, "https://englishlive.ef.com/ar-sa/buy/default/member/" } ,
                {  25, "http://englishlive.ef.com/ar-sa/" } ,
                {  26, "https://englishlive.ef.com/ru-ru/buy/default/member/" } ,
                {  27, "http://englishlive.ef.com/ru-ru/" } ,
                {  28, "http://englishlive.ef.com/es-pe/" } ,
                {  29, "http://englishlive.ef.com/es-mx/lp/os/lplearnenglishonline/" } ,
                {  30, "https://englishlive.ef.com/es-mx/buy/default/member/" } ,
                {  31, "http://englishlive.ef.com/es-mx/" } ,
                {  32, "https://englishlive.ef.com/ko-kr/buy/default/member/" } ,
                {  33, "http://englishlive.ef.com/ko-kr/" } ,
                {  34, "https://englishlive.ef.com/ja-jp/buy/default/member/" } ,
                {  35, "http://englishlive.ef.com/ja-jp/" } ,
                {  36, "http://englishlive.ef.com/it-it/lp/os/business-1/" } ,
                {  37, "https://englishlive.ef.com/it-it/buy/default/member/" } ,
                {  38, "http://englishlive.ef.com/it-it/" } ,
                {  39, "http://englishlive.ef.com/id-id/" } ,
                {  40, "http://englishlive.ef.com/en-gb/lp/os/automation-test-learn-english-online-02/" } ,
                {  41, "https://englishlive.ef.com/en-gb/buy/default/member/" } ,
                {  42, "http://englishlive.ef.com/en-gb/" } ,
                {  43, "https://englishlive.ef.com/fr-fr/buy/default/member/" } ,
                {  44, "http://englishlive.ef.com/fr-fr/" } ,
                {  45, "http://englishlive.ef.com/es-es/lp/os/learn-english-online-01/" } ,
                {  46, "https://englishlive.ef.com/es-es/buy/default/member/" } ,
                {  47, "http://englishlive.ef.com/es-es/" } ,
                {  48, "http://englishlive.ef.com/de-de/lp/os/automation-test-01-stwt/" } ,
                {  49, "http://englishlive.ef.com/de-de/lp/os/01-stwt1/" } ,
                {  50, "https://englishlive.ef.com/de-de/buy/default/member/" } ,
                {  51, "http://englishlive.ef.com/de-de/" } ,
                {  52, "http://englishlive.ef.com/es-co/lp/oe/promo-upgrade-g/" } ,
                {  53, "http://englishlive.ef.com/es-co/" } ,
                {  54, "http://www.englishtown.com.br/lp/ee/ee_abr14/" } ,
                {  55, "https://www.englishtown.com.br/buy/default/member/" } ,
                {  56, "http://www.englishtown.com.br/" } ,
                {  57, "http://englishlive.ef.com/es-ar" } ,
                {  58, "http://englishlive.ef.com/ar-wws/lp/ee/10001/?ctr=om" }
        };
    }


}
