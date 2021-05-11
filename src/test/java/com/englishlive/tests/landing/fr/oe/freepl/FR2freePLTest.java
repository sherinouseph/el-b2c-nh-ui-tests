//package com.englishlive.tests.landing.fr.oe.freepl;
///**
// *
// *  https://englishlive.ef.com/fr-fr/lp/oe/ef-home-anglais-cours-d-essai/
// *
// */submit btn keep changing.hence commented this test
//
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.landingpages.BaseOETest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class FR2freePLTest extends BaseOETest { //FRfreePLTest {
//    private static final Logger logger = LoggerFactory.getLogger(FR2freePLTest.class);
//    @Value("#{applicationPropertiesList['fr.freepl2']}")
//    private String testUrl;
//    public String btn=".variables .column0 .bs3 .btn";
//
//
//    @BeforeClass
//    public void setupOpenUrl() {
//        setThreadSafeDriver();
//        setTestStartUrl(testUrl);
//        isUseCssEnterFormData = true;
//        urlContainsThankyou = "welcome";
//        submitBtn = "#-rsrc--content--englishtown--fr--fr--lp--oe--ef-home-anglais-cours-d-essai--jcr__content--main-parsys--illustrator_864076216--form-panel--form-button";//"#-rsrc--content--englishtown--fr--fr--lp--oe--ef-home-anglais-cours-d-essai--jcr__content--main-parsys--ct_container_1559359279--content-parsys--illustrator--form-panel--form-button";
//        formLeadTypeValue = "oe";
//        formDataMap = EfConstants.FR_FREE_PL_CSS;//not a crm page hence use the form with TC checkbox
//        openUrl(getWebDriver(), getTestStartUrl());
//        //List<WebElement> buttonlist = getWebDriver().findElements(By.cssSelector(btn));
//        //buttonlist.get(0).click();
//
//      //  getWebDriver().findElement(By.cssSelector(btn)).click();
//       // click(getWebDriver(), By.cssSelector(".bs3 .btn"));
//
//    }
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//}
