package com.englishtown.dataprovider;
/**
 * Create URL redirect test data
 */
import com.englishtown.dataprovider.bin.UrlBean;
import com.englishtown.dataprovider.bin.UrlRedirectBean;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.EfConstants;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by nikol.marku on 04/08/2015.
 */

//TODO Review this methods and refactor ....

public class UrlDataProvider {
    private static final Logger logger = LoggerFactory.getLogger(UrlDataProvider.class);
    public static List<UrlRedirectBean> urlRedirectBeanList = new ArrayList<UrlRedirectBean>();
    public static List<UrlBean> urlBeanList;

    public static int minRedirectDesCharsNo = 50;

    // refactor these methods
    @org.testng.annotations.DataProvider(name = "eLiveAllUrlRedirect", parallel = true)
    public static Object[][] createEliveUrlRedirectTestData() {
        return getUrlRedirectBean(EfConstants.REDIRECT_ELIVE_ALL_TESTS_URL);
    }

    // refactor these methods
    @org.testng.annotations.DataProvider(name = "brELiveAllUrlRedirect", parallel = true)
    public static Object[][] createBrEliveUrlRedirectTestData() {
        return getUrlRedirectBean(EfConstants.BR_REDIRECT_ELIVE_URL);
    }

    @org.testng.annotations.DataProvider(name = "hrefLangXmlUrls", parallel = true)
    public static Object[][] createHrefLangXmlUrls() {
        return getUrlRedirectBean(EfConstants.REDIRECT_HREFLANG);
    }

    @org.testng.annotations.DataProvider(name = "siteMapXmlUrls", parallel = true)
    public static Object[][] createSiteMapXmlUrls() {
        return getUrlRedirectBean(EfConstants.REDIRECT_SITEMAP);
    }

    @org.testng.annotations.DataProvider(name = "twUrlRedirect")
    public static Object[][] createTWUrlRedirectTestData() {
        return getUrlRedirectBean(EfConstants.TW_REDIRECT__URL);
    }

    @org.testng.annotations.DataProvider(name = "eCentreAllUrlRedirect", parallel = true)
    public static Object[][] createCentreUrlRedirectTestData() {
        return getUrlRedirectBean(EfConstants.REDIRECT_ECENTRE_ALL_TESTS_URL);
    }

    /**
     * emailenglish test data
     * @return
     */
    @org.testng.annotations.DataProvider(name = "emailEnglishUrlRedirect", parallel = true)
    public static Object[][] eeUrlRedirectTestData() {
        return getUrlRedirectBean(EfConstants.REDIRECT_EMAILENGLISH_TESTS_URL);
    }

    /**
     * Chop the url if longer than 25 chars[maxRedirectDesCharsNo] so test name is not that long
     * @return des or empty str ""
     */
    public static String chopUrl(String urlKey, int minRedirectDesCharsNo){
        String des = urlKey;
        if( StringUtils.isNotBlank(urlKey) ) {
            try {
                if (urlKey.length() > minRedirectDesCharsNo) {
                    des = urlKey.substring(urlKey.length() - minRedirectDesCharsNo);
                }
            } catch (Exception e) {
                logger.error("getDescriptionFromUrl thrown exception ....! " + e.getCause());
            }
        } else logger.warn("urlKey is null or blank ...!");

        return des;
    }

    @org.testng.annotations.DataProvider(name = "efEnglishtownRedirectData", parallel = true)//, parallel = true
    public static Object[][] createEfEnglishtownUrlRedirectTestData() {
        return getUrlRedirectBean(EfConstants.REDIRECT_EMAILENGLISH_TESTS_URL);
    }

    @org.testng.annotations.DataProvider(name = "eLiveAllMobileUrlRedirect")//, parallel = true)
    public static Object[][] createAllMobileUrlRedirectTestData() {
        return getUrlRedirectBean(EfConstants.REDIRECT_ALL_MOBILE_URL);
    }

    @org.testng.annotations.DataProvider(name = "rolaAllUrlListMap")
    public static Object[][] createRolaUrlRedirectTestDataFromMap() {
        return getUrlRedirectBean(EfConstants.ROLA_URL_LIST_MAP);
    }

    @org.testng.annotations.DataProvider(name = "mxAllUrlListMap")
    public static Object[][] createMXUrlRedirectTestDataFromMap() {
        return getUrlRedirectBean(EfConstants.MX_URL_LIST_MAP);
    }

    // all main urls/lins on page nav bar
    @org.testng.annotations.DataProvider(name = "noDomainAllUrlListMap")
    public static Object[][] createRolaNoDomainUrlTestData() {
        return getUrlRedirectBean(EfConstants.ALL_LINKS_URL_LIST_MAP);
    }

    // all all urls so far
    @org.testng.annotations.DataProvider(name = "rolaAllUrlList")
    public static Object[][] createRolaAllUrlBenTestData() {
        int count = 0;
        String curWebKey    = null;
        String curWebValue  = null;
        int commentLength = 25;
        Object[][] urlsBeanObj = new Object[EfConstants.allRolaUrlsList.length][1];
        UrlBean urlBean;

        for( int i=0; i< EfConstants.allRolaUrlsList.length; i++) {
            String des = +i+"_url_"+EfConstants.allRolaUrlsList[i]; //.substring(curWebValue.length() - commentLength)+" ...";
            urlBean = new UrlBean( i, EfConstants.allRolaUrlsList[i], des);
            urlBean.print();
            urlsBeanObj[i][0] = urlBean;
        }
        return urlsBeanObj;
    }

    @org.testng.annotations.DataProvider(name = "tryusPinkBtn", parallel = true)
    public static Object[][] createtryusPinkBtnUrls() {
        return new Object[][]{
                {"" ,  "englishlive.ef.com/fr-fr/lp/oe/reservation-cours-particulier/"},
               // {"" ,  "englishlive.ef.com/it-it/offerta-inglese/"},
                {"" ,  "englishlive.ef.com/de-de/buy/default/member/"},
                {"" ,  "englishlive.ef.com/en-gb/buy/default/member/"},
               // {"" ,  "englishlive.ef.com/es-us/planes-y-precios/"},
               // {"" ,  "englishlive.ef.com/en-us/study-plans-and-prices/"},
                {"" ,  "englishlive.ef.com/en-wws/prices/?ctr=fi"},
                {"" ,  "englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=om"},
                {"" ,  "englishlive.ef.com/fr-wws/formations-et-tarifs/?ctr=pf"},
                {"" ,  "englishlive.ef.com/de-wws/angebote-und-preise/?ctr=at"},
                {"" ,  "englishlive.ef.com/es-wws/oe-free-consultation/?ctr=cr"},
                {"" ,  "englishlive.ef.com/tr-tr/buy/default/member/"},
               // {"" ,  "englishlive.ef.com/ru-ru/%D0%B2%D0%B0%D1%80%D0%B8%D0%B0%D0%BD%D1%82%D1%8B-%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC-%D0%B8-%D1%86%D0%B5%D0%BD%D1%8B/"},
                {"" ,  "englishlive.ef.com/es-es/planes-y-precios/"},
                {"" ,  "englishlive.ef.com/en-wws/prices/?ctr=sa"},
                {"" ,  "englishlive.ef.com/en-wws/prices/?ctr=se"},
                {"" ,  "englishlive.ef.com/zh-tw/oe/free-consultation/"},
                {"" ,  "englishlive.ef.com/th-th/study-plans-and-prices/"},
                {"" ,  "englishlive.ef.com/id-id/study-plans-and-prices/"},
                {"" ,  "englishlive.ef.com/ko-kr/study-plans-and-prices/"},
                {"" ,  "englishlive.ef.com/es-co/oe-free-consultation/"},
                {"" ,  "englishlive.ef.com/ja-jp/study-plans-and-prices/"},
                {"" ,  "englishlive.ef.com/ar-sa/study-plans-and-prices/?ctr=sa"},
                {"" ,  "englishlive.ef.com/es-wws/oe-free-consultation/?ctr=ar"},
                {"" ,  "englishlive.ef.com/es-mx/oe-free-consultation/?ctr=pe"},
                {"" ,  "englishlive.ef.com/es-mx/oe-free-consultation/?ctr=ve"},
                {"" ,  "englishlive.ef.com/es-mx/oe-free-consultation/?ctr=cl"},
                //{"" ,  ".englishtown.com.br/lp/os/sep15_ls55/"}
        };
    }
//    public static Object[][] createAllPinkTopRightBtn() {
//        Object[][] urlsBeanObj = new Object[EfConstants.allPinkTopRightBtn.length][1];
//        UrlBean urlBean;
//        for( int i=0; i< EfConstants.allPinkTopRightBtn.length; i++) {
//            String des = +i+"_url_"+EfConstants.allPinkTopRightBtn[i];
//            urlBean = new UrlBean( i, EfConstants.allPinkTopRightBtn[i], des);
//            urlBean.print();
//            urlsBeanObj[i][0] = urlBean;
//        }
//        return urlsBeanObj;
//    }

    @org.testng.annotations.DataProvider(name = "getAllPageUrls")
    public static Object[][] getAllPageValidUrls(WebDriver driver) {
        logger.info("UrlDataProvider ... getAllPageUrls ...!");
        Set<String> urlSet = new HashSet();
        //TODO webdriver is null in here so need to fix this
        urlSet = TestUtil.getAllUrls(driver, null, null); // BasePage.webDriver

        return new Object[][] {
                new Object[]{urlSet}
        };
    }

    //todo update this after all release to only 5 top test data
    @org.testng.annotations.DataProvider(name = "rolaPartnerTestData")
    public static Object[][] createRolaAllParnerDataTest() {
        return new Object[][] {
                {"0",  "Root"},
             /*   {"1",  "memb"},
                {"2",  "goco"},
                {"3",  "gorol"},
                {"4",  "mkge"},
                {"5",  "None"},
                {"6",  "gous"},
                {"7",  "2sna"},
                {"8",  "gope"},
                {"9",  "gocl"},
                {"10", "gove"},
                {"11", "corp"},
                {"12", "goes"},
                {"13", "gdmx"},
                {"14", "af10"},
                {"15", "mslt"},
                {"16", "gdco"},*/
                {"17", "gomx"},
               /* {"18", "mxte"},
                {"19", "myef"},
                {"20", "efcl"},
                {"21", "e1ef"},
                {"22", "em05"},
                {"23", "eaps"},*/
        };
    }


    /**
     * Get a list of UrlRedirectBean from map
     * @return
     */
    public static List<UrlRedirectBean> getUrlRedirectBeanList(Map urlMap) {
        Iterator it  = urlMap.entrySet().iterator();
        int count = 0;
        String curWebKey    = null;
        String curWebValue  = null;
        int redirectDesCharsNo = 19;

        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            curWebKey = pairs.getKey().toString();
            curWebValue = pairs.getValue().toString();
            String des = +count+"_from_..."+curWebKey.substring(curWebKey.length()-redirectDesCharsNo)+" _rediectTo_..."
                    +curWebValue.substring(curWebValue.length()-redirectDesCharsNo);
            //logger.info("id :"+count+" url :"+curWebKey+" expUrl :"+curWebValue+" des :" +des);
            urlRedirectBeanList.add(new UrlRedirectBean( count, curWebKey, curWebValue , des) ) ;
            count++;
        }   logger.info("*************************************************************************** ");
        //for (UrlRedirectBean url : urlRedirectBeanList) {      url.print();       }

        return urlRedirectBeanList;
    }

    public static List<UrlBean> getUrlBeanList(Map urlMap) {
        Iterator it  = urlMap.entrySet().iterator();
        urlBeanList = new ArrayList<UrlBean>();
        int count = 0;
        String curWebKey    = null;
        String curWebValue  = null;
        int redirectDesCharsNo = 10;

        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            curWebKey = pairs.getKey().toString();
            curWebValue = pairs.getValue().toString();
            String des ="id_"+count+curWebValue.substring(curWebValue.length()- getRedirectDesCharsNo(curWebValue, redirectDesCharsNo));
            //logger.info("id :"+count+" url :"+curWebKey+" expUrl :"+curWebValue+" des :" +des);
            urlBeanList.add(new UrlBean(count, curWebValue , des) ) ;
            count++;
        }
        //for (UrlBean url : urlBeanList) {  url.print();        }

        return urlBeanList;
    }

    /**
     * get Object URL Bean With description
     */
    public static Object[][] getUrlRedirectBean(Map urlMap) {
        Iterator it = urlMap.entrySet().iterator();
        int count = 0;
        String curWebKey = null;
        String curWebValue = null;

        Object[][] urlsBean = new Object[urlMap.size()][1];

        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            curWebKey = pairs.getKey().toString();
            curWebValue = pairs.getValue().toString();
            // create description for test name
            String currWebKeyDes = chopUrl(curWebKey, minRedirectDesCharsNo);
            String currWebValueDes = chopUrl(curWebValue, minRedirectDesCharsNo);
            String des = +count + "_from_ " + currWebKeyDes + " _rediectTo_ " + currWebValueDes;
            //logger.info("id :"+count+" url :"+curWebKey+" expUrl :"+curWebValue+" des :" +des);
            urlsBean[count][0] = new UrlRedirectBean(count, curWebKey, curWebValue, des);
            count++;
        }
        return urlsBean;
    }
    public static Object[][] getUrlHostRedirectBean(Map urlMap) {
        Iterator it = urlMap.entrySet().iterator();
        int count = 0;
        String curWebKey = null;
        String curWebValue = null;

        Object[][] urlsBean = new Object[urlMap.size()][1];

        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            curWebKey = pairs.getKey().toString();
            curWebValue = pairs.getValue().toString();
            // create description for test name
            String currWebKeyDes = chopUrl(curWebKey, minRedirectDesCharsNo);
            String currWebValueDes = chopUrl(curWebValue, minRedirectDesCharsNo);
            String des = +count + "_from_ " + currWebKeyDes + " _rediectTo_ " + currWebValueDes;
            //logger.info("id :"+count+" url :"+curWebKey+" expUrl :"+curWebValue+" des :" +des);
            urlsBean[count][0] = new UrlRedirectBean(count, curWebKey, curWebValue, des);
            count++;
        }
        return urlsBean;
    }

    private static int getRedirectDesCharsNo(String content, int redirectDesCharsNo){
        if(content.length() <= redirectDesCharsNo){
            redirectDesCharsNo = content.length();
        }
        return redirectDesCharsNo;
    }

}
