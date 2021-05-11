//package com.englishlive.tests.cq.component;
///**
// * Created by nikol.marku on 31/05/2016.
// *
// *  TC-121:Launch Tech Check Component , check content
// *
// */
//import com.englishlive.tests.cq.component.core.BaseTechCheckComponentTest;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//// this does not depend on us so sto testing this
//// component not owrking on chrome .. not fixed ..https://jira-bos.englishtown.com/browse/SAND-3255
//public class TechCheckComponentTest extends BaseTechCheckComponentTest {
//    private static final Logger logger = LoggerFactory.getLogger(TechCheckComponentTest.class);
//    @Value("#{applicationPropertiesList['cq.component.techcheck.fr']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    public void setupOpenUrlAndClickLaunchBtn(){
//        this.openUrl(getWebDriver(), this.testUrl, -1 ) ;
//        click(getWebDriver(), By.cssSelector(launchTechCheckBtnCss));
//        sleep(3000);
//    }
//
//}
