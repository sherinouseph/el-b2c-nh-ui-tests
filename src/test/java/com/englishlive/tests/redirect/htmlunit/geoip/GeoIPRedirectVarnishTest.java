package com.englishlive.tests.redirect.htmlunit.geoip;
/**
 * Setup header and check you are redirected to the correct country based on X-IPCountryCode
 * https://jira-bos.englishtown.com/browse/SAND-3203
 *
 * NOTE : This test is very dirty
 * Header is faked
 * there are exceptions
 * WE get the exception and validate to have the correct url
 */

import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverTest;
import com.englishtown.dataprovider.bin.UrlHostContryRedirectBean;
import com.englishtown.dataprovider.factory.GeoIPRedirectDataProvider;
import com.englishtown.helpers.AssertHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.containsString;


public class GeoIPRedirectVarnishTest extends BaseHtmlUnitDriverTest {
    private static final Logger logger = LoggerFactory.getLogger(GeoIPRedirectVarnishTest.class);
    @Value("#{applicationPropertiesList['lb.qa']}")
    protected String lbIP_QA ;
    @Value("#{applicationPropertiesList['lb.live']}")
    protected String lbIP_LIVE ;


    String hostStartStr = "www.";
    String currentTestIpUrl = null;

    protected UrlHostContryRedirectBean urlBean;

    @Factory(dataProviderClass=GeoIPRedirectDataProvider.class, dataProvider="GeoIpHostRedirectUrls")
    public GeoIPRedirectVarnishTest(UrlHostContryRedirectBean urlBean){
        this.urlBean = urlBean;
        this.urlBean.print();
    }

    @BeforeClass
    public void setup(){
        logger.warn("This test run on QA and Live only");
        setupHeaderValueAndUrlContains(urlBean.getMarket(),urlBean.getExpectedUrl().split("/")[1]);
        setupQaHostStartAndCurrentTestIpUrl();
        String host = hostStartStr+"englishlive.com";
        htmlUnitDriver = createHtmlUnitDriverWithHeaders(getHtmlUnitDriver(),"Host:"+urlBean.getHost(), "X-IPCountryCode:"+urlBean.getMarket() );
    }

    @Test
    public void openUrlCheckRedirection(){
        logger.info("Open URL :"+currentTestIpUrl);
        String exceptionUrl = "NOTSET" ;

        try {
            getHtmlUnitDriver().get(currentTestIpUrl);
            Thread.sleep(2000);
        }catch (Exception e){
            logger.error("\nError:--------------\n"+e.getCause()+"\n Market/Country [ "+urlBean.getMarket()+" ]");                                                               //com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException: Too much redirect for http://qa-englishlive.ef.com/fr-fr/
            try{
                exceptionUrl = e.getCause().toString().split("https")[1].trim();
                logger.info("\nException Url is   [\t"+exceptionUrl+" ] \nUrl should contain [.. "+urlBean.getExpectedUrl()+" ]\n\n");
            }catch (IndexOutOfBoundsException ie){
                logger.error("Cant get URL ... from exception ...!"+ie.getMessage());
            }
        }

        AssertHelper.assertThat(" Failed ...!; URL does not contain : "+urlBean.getExpectedUrl(), exceptionUrl , containsString(urlBean.getExpectedUrl()));
        logger.info(" Test passed ; Test BeanID ["+urlBean.getId());
    }


    //************************************************************************************************
    protected void setupQaHostStartAndCurrentTestIpUrl(){
        if(getENVIRONMENT().contains("qa")){
            hostStartStr = "qa-";
            currentTestIpUrl = lbIP_QA+urlBean.getUrl();
        } else {
            currentTestIpUrl = lbIP_LIVE + urlBean.getUrl();
        }
    }
    protected void setupHeaderValueAndUrlContains(String market, String urlContains){
        HEADER_VALUE = market;
        URL_CONTAINS = urlContains;
    }

}




//    @Test(dependsOnGroups = "")
//    public void checkRedirection(){
//        //boolean urlContains = BasePage.waitForUrlContains(getHtmlUnitDriver(), URL_CONTAINS, 3);
//        // logger.info("Current URL :" + getHtmlUnitDriver().getCurrentUrl());
//        AssertHelper.assertThat(" Failed ...!; URL does not contain : "+URL_CONTAINS, exceptionUrl , containsString(URL_CONTAINS));
//    }



