//package com.englishlive.tests.provider.data;
///**
// * Created by nikol.marku on 26/01/2016.
// */
//import com.englishlive.tests.basetest.htmlunit.BaseCheckHrefLenAltenate;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//public class HrefLenProvider {
//    private static final Logger logger = LoggerFactory.getLogger(HrefLenProvider.class);
//
//    //hreflen test
//    @org.testng.annotations.DataProvider(name = "getAllHrefLenUrls", parallel = true)
//    public static Object[][] getHrefLenUrls() {
//        logger.info("UrlDataProvider ... getAllHrefLenUrls ...!");
//        Set<String> urlSet = new HashSet();
//        Object[][] urlsObj = null;
//        urlSet = TestUtil.getAllUrls(BaseCheckHrefLenAltenate.getMyWebDriver(), By.cssSelector("link[rel=\"alternate\"]"), null);
//        if(!urlSet.isEmpty()) {
//            urlsObj = new Object[urlSet.size()][1];
//            int count = 0;
//            for (String url : urlSet) {
//                urlsObj[count][0] = url;
//                count++;
//            }
//        } else {
//            BasePage.failTest(" Could not get any URLs Len link[rel=alternate]  from the webpage ...!");
//        }
//        return urlsObj; // new Object[][] { new Object[]{urlSet}     };
//    }
//
//}
