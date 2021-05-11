//package com.englishlive.tests.home.all;
//
///**
// * https://jira-bos.englishtown.com/browse/SAND-3838
// * Open homepage and check phone number is equal to the expected one
// *
// */
//
//import com.englishtown.dataprovider.MainMarketsHomeUrlsDataProvider;
//import com.englishtown.dataprovider.bin.CountryPhoneUrlBean;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.driver.local.DriverManager;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.core.BaseTest;
//import com.englishtown.tests.core.SimpleBaseTest;
//import org.apache.commons.lang.StringUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
//
//
//public class OpenMainMarketPagesCheckMaintenaceTest extends SimpleBaseTest {
//    private static final Logger logger = LoggerFactory.getLogger(OpenMainMarketPagesCheckMaintenaceTest.class);
//
//    protected String phoneNumber = "notInit";
//    protected String loginBtnCss    = ".btn.btn-primary.pull-right";
//
//
//    @Test(dataProvider = "mainMarketMaintenacePages", dataProviderClass = MainMarketsHomeUrlsDataProvider.class)    //, threadPoolSize = 3, invocationCount = 1, timeOut = 55000)
//    public void openMaintenacePages(CountryPhoneUrlBean countryPhoneUrlBean){
//        try {
//            DriverManager.createDriver(MyBrowserType.CHROME, 15);
//
//            countryPhoneUrlBean.print();                                                                                     //createLocalThreadDriver(MyBrowserType.EXPLORER11, 15);
//            //String url;        if(StringUtils.contains(countryPhoneUrlBean.getUrl(), "ctr=")){            url = getBASE_URL() + countryPhoneUrlBean.getUrl().replace("?","in-maintenance-sp/?");        } else            url = getBASE_URL() + countryPhoneUrlBean.getUrl()+"in-maintenance-sp";
//            openUrl(DriverManager.getDriver(), getBASE_URL() + countryPhoneUrlBean.getUrl());
//            sleep(4000);
//            /*if (StringUtils.contains(countryPhoneUrlBean.getUrl(), "-sp")) {
//                if(StringUtils.contains(countryPhoneUrlBean.getUrl(), "ko-kr"))
//                logger.info("Checking login btn ...!");
//                AssertHelper.assertWebElementDisplayed(DriverManager.getDriver(), By.cssSelector(loginBtnCss));
//            } else {
//                logger.info("No login btn LP page ...!!");
//                AssertHelper.assertWebElementNotDisplayed(DriverManager.getDriver(), By.cssSelector(loginBtnCss));
//            }*/
//
//        /*}catch (Exception e){
//            logger.error("Exception : "+e.getMessage());
//            //throw new Exception(e);*/
//        }
//        finally {
//            DriverManager.destroyLocalDriver();
//        }
//    }
//
//
//}