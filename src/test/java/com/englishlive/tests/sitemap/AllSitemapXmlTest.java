package com.englishlive.tests.sitemap;
/**
 *
 *
 */
import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverConfig;
import com.englishtown.dataprovider.SiteMapDataProvider;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebClientResponseHelper;
import com.englishtown.helpers.bean.MyHttpResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;


public class AllSitemapXmlTest extends BaseHtmlUnitDriverConfig {
    private static final Logger logger = LoggerFactory.getLogger(AllSitemapXmlTest.class);
    @Value("#{applicationPropertiesList['sitemap.fr.fr.url']}")
    private String testUrl;
    protected String NOT_DEFINED = "SITEMAP-NOT-DEFINED-YET";


    @BeforeClass
    private void setup() {
        htmlUnitTestUrl = testUrl;
        setBrowserName("webclient");
    }

    @Test (dataProvider = "siteMapXmlUrlall", dataProviderClass = SiteMapDataProvider.class,  threadPoolSize = 10, invocationCount = 1, timeOut = 35000  )
    public void openUrl_CheckResponseCode200AndDoesNotContainNotDefined(String country, String url) {
        int expectedResponseCode = 200;
        url = getBASE_URL()+url;
        logger.info("Test Response for URL ["+url+"] ; is :"+expectedResponseCode);

        webClientResponseHelper =new WebClientResponseHelper();
        MyHttpResponse responseObj = webClientResponseHelper.geMyHttpResponse(url);  //WebClientResponseHelper.geMyHttpResponse(url);
        webClientResponseHelper = null;

        logger.info("testResponseCode is ["+responseObj.getResposneCode()+"]");
        AssertHelper.assertThat("Response Code is not ["+expectedResponseCode+"] ...!", responseObj.getResposneCode(), is(expectedResponseCode));
        // check ContentDoes Not Contain NotDefined
        if(StringUtils.contains(responseObj.getResponseContent(), NOT_DEFINED)) {
            String printResponse = null;
            try{
                printResponse = responseObj.getResponseContent().trim().substring(0, 100);
            } catch (Exception e){logger.error("Could not get the substring ...! "+e.getMessage());}
            logger.info("substring 100 chars : > Response is : \n" + printResponse);
        }
        AssertHelper.assertThat("Response Content contains ["+NOT_DEFINED+"] ...! URL : "+url, responseObj.getResponseContent(), not(containsString(NOT_DEFINED)));
    }


}