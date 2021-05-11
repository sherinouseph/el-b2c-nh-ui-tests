package com.englishtown.helpers;

import com.englishtown.commerceclient.Environment;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestConfig;
import com.englishtown.tests.core.EfConstants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * This is responsible for the changes requested for transition period to englishlive
 * as we will be running englishtown and english live at the same time
 * Once all moved to englishlive this should be redundant.
 *
 * Helpers to map Environment urls to englishlive - and reverse helper method
 *
 * Created by nikol.marku on 07/08/2015.
 *
 */



public class UrlMapper {
    private static final Logger logger = LoggerFactory.getLogger(UrlMapper.class);



    /**
     * update start of url to to elive url url = base_url + theRest => e.g. base url is the protocol + wwww
     *
     * @param url => test URL
     * @param baseURL  => set on maven profile using spring properties
     * @return new Elive url
     *
     */
    public static String mapUrlToELive(String url, String baseURL){
        String oldUrl = null;
        if(!url.contains("://englishlive") ) {
            for (int i = 0; i < EfConstants.ELIVE_BASE_URLS.length; i++) {
                if (url.startsWith(EfConstants.ET_BASE_URLS[i])) {                // replace startUrl - protocoll + few chars like www  qa staging
                    oldUrl = url.replaceFirst(EfConstants.ET_BASE_URLS[i], EfConstants.ELIVE_BASE_URLS[i]);
                    // on pub1/2 urls are different -no englishlive
                    // || url.contains("usb-etcqqa2"  for cq6 use this
                    if (url.contains("//webus") ) {
                        logger.info("Testing publishers  replace englishlive.ef , englishtown...!");
                        oldUrl = oldUrl.replace("englishlive.ef", "englishtown");
                        logger.info("URL modified for pub tests URL : " + oldUrl);
                    }
                    //todo add if
                    logger.info(i + " - switch " + EfConstants.ET_BASE_URLS[i] + " To if -> Found ...! switchBaseStartUrl : " + oldUrl);
                    return oldUrl;
                }
            }
            if (oldUrl == null) {
                BasePage.failTest("Test failed ...! Could NOT map url to ELIve URL ...! :url :['" + url + "']");
            }
        }else {
            logger.info("NO need to map this URL : "+url);
        }
        return oldUrl;
    }

    /**
     * Brazil is still on Etown dowmain so need to map
     * the profile base url .. e.g http:// to http://www
     *
     */
    public static String mapBaseUrlToEtown(String url, String baseURL){
        logger.info("URL to convert : "+url);
        String switchedUrl = null;
        if (baseURL !=null && url != null){ //url.startsWith(baseURL)
            switchedUrl = url.replaceFirst(baseURL, mapEliveBaseUrlToEtownBaseUrl(baseURL));
            logger.info( "URL converted to :" + switchedUrl);
            return switchedUrl;
        }
        else {
            logger.info("Base url is null : ["+baseURL+"]");
        }
        return switchedUrl;
    }

    /***
     * map urls to old urls that start with www. and qa.
     * e.g  qa- is changed to qa https:// changed to https://www
     * @param baseUrl
     * @return
     */
    public static String mapEliveBaseUrlToEtownBaseUrl(String baseUrl){
        String mappedBaseUrl="";
        switch (baseUrl){
            case "https://qa-":
            case "http://qa-":
                mappedBaseUrl="http://qa";
                break;
            case "https://":
                mappedBaseUrl="http://www";
                break;
            case "http://webus1":
                mappedBaseUrl="http://webus1" ;
                break;
            case "http://webus2":
                mappedBaseUrl="http://webus2" ;
                break;
            default:
                logger.info("CAN'T Map BaseUrl : "+baseUrl+" ...! Returning ["+mappedBaseUrl+"]");
        }
        return mappedBaseUrl;
    }

    /**
     * 2017
     * If needed map the URL  [only for emailenglish, efenglishtown and egnlishtown]
     * only the start of the url is changed before the domain name
     * @param baseUrl
     * @param url
     * @return
     */
    public static String mapUrlToEtown(String baseUrl, String url){
        logger.info("Map Base Url to Etown: "+baseUrl+"; URL: "+url);
        if (baseUrl !=null && url != null) {
            if (StringUtils.contains(url, "emailenglish.net/") || StringUtils.contains(url, "efenglishtown.com/") || StringUtils.contains(url, "englishtown.com/")) {
                String tmpBaseUrl = mapEliveBaseUrlToEtownBaseUrl(baseUrl);
                url = tmpBaseUrl + url;
                logger.info("Base URL is mapped to: " + url);
            } else {
                url = baseUrl + url;
                logger.info("Base URL does not need to be mapped ....? full URL: "+url);
            }
        }else {
            BasePage.failTest("Test failed ...! Could Not map Base url or URL as it is null; baseUrl[" + baseUrl + "]; url[" + url + "]");
        }

        return url;
    }


}




//    @Test
//    public void mapUrlTest(){
//        String url [] = {"http://.englishtown.com.br/.englishtown", "http://qa-.englishtown.com.br/.englishtown",
//                    "http://staging-.englishtown.com.br/.englishtown", "http://uat-.englishtown.com.br/.englishtown"};            //,"http://qa-.englishtown.com.br","http://staging-.englishtown.com.br","http://uat-.englishtown.com.br"};
//        for(int i=0; i <EfConstants.ELIVE_BASE_URLS.length; i++) {
//            for(int t=0; t<url.length; t++) {
//                mapBaseUrlToEtown(url[t], EfConstants.ELIVE_BASE_URLS[0]);
//            }
//        }
//    }

///////////////////////////////////////

/**
 *
 * @param baseUrl  the base url is mapped
 * @return
 *
public static String mapBaseUrlToELive(String baseUrl){
String switchBaseUrl = null;
for(int i=0; i < EfConstants.ELIVE_BASE_URLS.length; i++){
if(baseUrl.startsWith(EfConstants.ET_BASE_URLS[i])){                // replace startUrl - protocoll + few chars like www  qa staging
switchBaseUrl =  EfConstants.ELIVE_BASE_URLS[i];
logger.info(i + " - switch " +baseUrl+ " To -> " + switchBaseUrl);
return switchBaseUrl;
}
}
if(switchBaseUrl == null){
BasePage.failTest("Test failed ...! Could Not map url to ELIve base URL ...! :url :['"+baseUrl+"']");
}
return switchBaseUrl;
}*/

/**
 case "http://qa-":
 mappedUrl="http://qa";
 break;
 case "https://qa-":
 mappedUrl="https://qa";
 break;
 case "http://":
 mappedUrl="http://www";
 break;
 case "https://":
 mappedUrl="http://www";
 break;
 case "http://webus1":
 mappedUrl="http://webus1" ;
 break;
 case "http://webus2":
 mappedUrl="http://webus2" ;
 break;
 case "http://webus2.":
 mappedUrl=;
 break;
 case "http://webus1.":
 mappedUrl=;
 break;
 case "http://uat":
 mappedUrl="http://uat";
 break;
 case "http://stg-":
 mappedUrl="http://staging";
 break;

 */
//        String switchUrlsWithConent = ".englishtown.com.br";
//        if(url.contains(switchUrlsWithConent) ) {
//            for (int i = 0; i < EfConstants.ET_BASE_URLS.length; i++) {
//                if (url.startsWith(EfConstants.ELIVE_BASE_URLS[i])) {
//                    switchBaseUrl = url.replaceFirst(EfConstants.ELIVE_BASE_URLS[i], EfConstants.ET_BASE_URLS[i] );
//                    logger.info(i + " >- URL converted to :" + switchBaseUrl);
//                    return switchBaseUrl;
//                }//else{   logger.info(" URL does not start with know protocols set on profiles");               }
//            }
//            if (switchBaseUrl == null) {
//                BasePage.failTest("Test failed ...! Could NOT map url to ELIve URL ...! :url :['" + url + "']");
//            }







//                // now replace .englishtown to englishlive except UAT
//                if(url.startsWith("http://uat") ){ // no need to be changed dirty setup
//                }else {
//                    switchBaseUrl = switchBaseUrl.replace(".englishtown", "englishlive");
//                }

/**
 * need to change url for all test until all site is running on englishlive
 * if url is a live url then base.url.site = http://
 * if url is a qa url then base.url.site = qa-
 * if url is a staging url then base.url.site = stg-
 *
 *    baseStartUrl = BASE_URL from profile spring ...BaseTestConfig
 *
 */
//    public static String mapBaseUrlETowntoELive(String baseStartUrl) {
//        String switchBaseStartUrl = null ;
//        if(StringUtils.isBlank(baseStartUrl)){
//            BasePage.failTest("Test failed ...! Urls is blank or null : URL :['"+baseStartUrl+"']");
//        }
//        for(int i=0; i < EfConstants.ELIVE_BASE_URLS.length; i++){
//            if(baseStartUrl.startsWith( EfConstants.ET_BASE_URLS[i])){
//                switchBaseStartUrl = EfConstants.ELIVE_BASE_URLS[i];
//                logger.info(i+" - switch "+EfConstants.ET_BASE_URLS[i]+" To if -> Found ...! switchBaseStartUrl : "+switchBaseStartUrl);
//                return switchBaseStartUrl;
//            }
//        }
//        logger.info("mapETtoELive NO match found :> switchBaseStartUrl = "+switchBaseStartUrl);
//        if(switchBaseStartUrl == null){
//            BasePage.failTest("Test failed ...! NO match found  for :['"+baseStartUrl+"']");
//        }
//
//        return switchBaseStartUrl;
//    }
//
//        @Test
//        public void mapUrlTest(){
//            String url [] = {"http://www.englishtown.com/.englishtown","http://qa.englishtown.com","http://staging.englishtown.de","http://uat.englishtown.co.uk"};
//
//            for(int i=0; i <url.length; i++) {
//                mapUrlToELive(url[i],EfConstants.ET_BASE_URLS[i]);
//            }
////            for(int i=0; i < EfConstants.ET_BASE_URLS.length; i++) {
////                mapBaseUrlETowntoELive(EfConstants.ET_BASE_URLS[i]);
////            }
//        }