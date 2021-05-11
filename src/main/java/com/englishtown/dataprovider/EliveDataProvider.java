package com.englishtown.dataprovider;
/**
 * Provides all the urls in a page
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.common.BaseCheckPageContainsText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nikol.marku on 27/10/2015.
 */
public class EliveDataProvider {
    private static final Logger logger = LoggerFactory.getLogger(EliveDataProvider.class);

    @org.testng.annotations.DataProvider(name = "getAllPageValidUrls")
    public static Object[][] getAllPageValidUrls() {
        logger.info("UrlDataProvider ... getAllPageUrls ...!");
        Set<String> urlSet = new HashSet();
        Object[][] urlsObj = null;
        urlSet = TestUtil.getAllUrls(BaseCheckPageContainsText.getMyWebDriver(), null, null);
        if(!urlSet.isEmpty()) {
            urlsObj = new Object[urlSet.size()][1];
            int count = 0;
            for (String url : urlSet) {
                urlsObj[count][0] = url;
                count++;
            }
        } else {
            BasePage.failTest(" Could not get any URLs from the webpage ...!");
        }
        return urlsObj;
    }

}
