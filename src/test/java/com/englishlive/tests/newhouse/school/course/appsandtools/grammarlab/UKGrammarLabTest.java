//package com.englishlive.tests.newhouse.school.course.appsandtools.grammarlab;
///**
// *Grammar lab test
// * Nikol May 2018
// *
// *
// */
//
//import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
//import com.englishtown.tests.core.school.course.appsandtools.grammarlab.BaseGrammarLabTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//works only in newhouse with newhouse selectors..hence commenting this until the newhouse is implemented
//public class UKGrammarLabTest extends BaseGrammarLabTest {
//    private static final Logger logger = LoggerFactory.getLogger(UKGrammarLabTest.class);
//    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
//    protected String testUrl;
//    @Value("#{applicationPropertiesList['testuser.grammarlab']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        setThreadSafeDriver();
//        testStartUrl = testUrl;
//        this.username = testUsername;  //"auto_19084832972386400_DCCAIHV924024401_xdelx@qp1.org";
//        this.password = "password";
//        // https://qa-b2c.eflabs.ioenglishlive.ef.com/en-gb/login/?ctr=gb
//        //testStartUrl = "https://qa-b2c.eflabs.io"; //TODO update this to new new house url
//        openUrl(getWebDriver(), testStartUrl);
//        schoolStudentBean = new SchoolStudentBean();
//
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//    //TODO dirty trick until login page is updated
//    /*@Override
//    public void enterUserCredentialsAndLoginToSchool(){
//        String loginSubmitButtonCss = ".form-group button";
//
//        Map<String, String> userCredentials = new LinkedHashMap<>();
//        userCredentials.put("email", username);
//        userCredentials.put("password", password);
//
//        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.id("email")), getWebDriver(), 35);
//        TestUtil.enterFormData(getWebDriver(), userCredentials);
//        WebElementHelper.click(WaitTool.findElement(getWebDriver(), By.cssSelector(loginSubmitButtonCss)) );
//    }*/
//
//}
