//package com.englishlive.tests.maintenace;
//
//import com.englishlive.tests.checkout.newcheckout.de.CcDECheckoutWithPhoneTest;
//import com.englishtown.dataprovider.MaintenanceDataProvider;
//import com.englishtown.dataprovider.UrlDataProvider;
//import com.englishtown.dataprovider.bin.MaintenanceUrlBean;
//import com.englishtown.dataprovider.bin.UrlRedirectBean;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.driver.local.DriverManager;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.apache.commons.lang.StringUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
///**
// * Created by nikol.marku on 22-Jun-17.
// */
//public class BaseMaintenancePagesTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(BaseMaintenancePagesTest.class);
//
//    protected Map formDataMap;
//    protected String submitFormCss  = "button[class='btn btn-primary']";
//    protected String loginBtnCss    = ".btn.btn-primary.pull-right"; //"-rsrc--content--englishtown--br--pt--in-maintenance-sp--jcr__content--headerPar--columnscontrol--column1--button";
//    protected String thankyouMsgCss = ".the.message";
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        //failTest("Temporary test only ");
//    }
//
//    @Test(dataProvider = "getMaintenaceUrls", dataProviderClass = MaintenanceDataProvider.class)       //, threadPoolSize = 7, invocationCount = 1, timeOut = 120000 )
//    public void opentUrlCheckLoginSubmitFormCheckMsg(MaintenanceUrlBean maintenanceUrlBean) throws Exception{
//        String url; //= getBASEURL()+maintenanceUrlBean.getUrl();
//        try {
//            url = getBASEURL()+maintenanceUrlBean.getUrl();
//            if(StringUtils.contains(url, "es-mx")){
//                logger.info("use mx map ...!");
//                formDataMap = EfConstants.mxOEFormMapWithPhone;
//            }else if(StringUtils.contains(url, "pt-br")) {
//                logger.info("use br map ...!");
//                formDataMap = EfConstants.MAINTENANCE_BR;
//            }else {
//                logger.info("use gb map ...!");
//                formDataMap = EfConstants.MAINTENANCE_GB;
//            }
//
//            DriverManager.createDriver(MyBrowserType.CHROME, 15);
//            setWebDriver(DriverManager.getDriver());
//            if(getBASEURL().contains("//qa")) {
//                if (StringUtils.contains(maintenanceUrlBean.getUrl(), "emailenglish.net") ){//|| StringUtils.contains(maintenanceUrlBean.getUrl(), "emailenglish.net")) {
//                    //map replace qa- with qa.
//                    String tmpUrl = maintenanceUrlBean.getUrl();
//                    tmpUrl = tmpUrl.replace("qa-", "qa.");
//                    url= tmpUrl;
//                }
//            }
//            openUrl(DriverManager.getDriver(), url ); //"https://qa-"+                    //WebElement fnWe =  DriverManager.getDriver().findElement(By.name("first_name"));           //DriverManager.getDriver().switchTo().frame(findElement(By.name(formDataMap.get(0).toString())));
//            sleep(1000);
//            waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")),DriverManager.getDriver(), 7);
//            //iframe
//            if(!StringUtils.contains(maintenanceUrlBean.getUrl(), "es-mx")) {
//                DriverManager.getDriver().switchTo().frame(0);
//            }
//
//            TestUtil.enterFormData(DriverManager.getDriver(), formDataMap);
//
//            // sales pages should have login button
//            if(StringUtils.equals("sp",maintenanceUrlBean.getPageType())) {
//                logger.info("Checking login btn ...!");
//                AssertHelper.assertWebElementDisplayed(DriverManager.getDriver(), By.cssSelector(loginBtnCss));
//            }
//            // submit
//            WebElement submitWe = WaitTool.findElement(DriverManager.getDriver(), By.name("email") );
//            submitWe.submit();
//            sleep(1000);
//            WaitTool.waitForElementVisible(DriverManager.getDriver(), By.cssSelector(thankyouMsgCss), 10) ;
//            sleep(5000);
//        }catch (Exception e){
//            logger.error("Exception : "+e.getMessage());
//            throw new Exception(e);
//        }
//        finally {
//            DriverManager.destroyLocalDriver();
//        }
//    }
//
//
//
//}
