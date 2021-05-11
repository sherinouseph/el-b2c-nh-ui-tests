//package com.englishlive.tests.redirect.https;
//
///**
// * https://jira-bos.englishtown.com/browse/SAND-3786
// *
// */
//
//import com.englishlive.tests.redirect.https.core.BaseHttpsRedirectTest;
//import com.englishtown.dataprovider.HttpsRedirectDataProvider;
//import com.englishtown.dataprovider.bin.TestResponseBean;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.UrlMapper;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
//
//// broken when moved to aws   DEC and not fixed so test removed
//// TODO need to map qa urls for www and non www domains
//public class MXOpenEngCourserDomainTest extends BaseHttpsRedirectTest {
//    private static final Logger logger = LoggerFactory.getLogger(MXOpenEngCourserDomainTest.class);
//
//
//
//    @Test(dataProvider = "httpsMxNewDomainRedirect", dataProviderClass = HttpsRedirectDataProvider.class)
//    void checkMxNewDomainsRedirect(TestResponseBean testResponseBean){
//        checkUrlResponseIs_301_and_Https(testResponseBean);
//    }
//
//    @Test(dataProvider = "mxNewDomain", dataProviderClass = HttpsRedirectDataProvider.class)//, threadPoolSize = 3, invocationCount = 1, timeOut = 55000)
//    public void checkPageTileStateObject(String pageName, String url){
//        try {
//            createLocalThreadDriver(MyBrowserType.CHROME, 20);
//            if("qa".contains(getENVIRONMENT())) {
//                if(StringUtils.contains(url, "www.")) {
//                       url = url.replace("www", "");
//                }
//                url = UrlMapper.mapEliveBaseUrlToEtownBaseUrl(getBASE_URL()) + url;
//            } else { // live url
//                url = getBASE_URL() + url;
//            }
//            openUrl(getLocalThreadDriver(), url);
//            sleep(1000);
//            String stateObjValue = getStateObjectKeyValue(getLocalThreadDriver(), STATEOBJECT_PAGENAME_KEY, true);
//            AssertHelper.assertThat("Page name is not the expected one ....!", stateObjValue, equalToIgnoringWhiteSpace(pageName));
//        }finally{
//            destroyLocalThreadDriver();
//        }
//    }
//
//}
//
//
