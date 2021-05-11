package com.englishlive.tests.login;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;


public class MemberPageShortPasswordNegativeTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(MemberPageShortPasswordNegativeTest.class);

    protected String testUrl;
    WebElement submitWe;


    @BeforeClass
    public void setup() {
        logger.info("Test starts");
    }

    @Test(priority = 0, dataProvider = "passwordpages")
    protected void checkPassShorterThan8CharsValidationMsg(String homePageUrl, Map formDataMap, String msg) {
        try {
            setThreadSafeDriver();
            CookieHandler.deleteCookies(getWebDriver());
            testUrl = getBASEURL() + homePageUrl;
            logger.info("Test Url : " + testUrl);
            openUrl(getWebDriver(), testUrl, -1);
            TestUtil.enterFormData(getWebDriver(), formDataMap);
            enterPassword();
            /*if (formDataMap != EfConstants.passwordform) {
                submitWe = findElement(By.cssSelector(".bs3 .btn"));
            } else {*/
                submitWe = findElement(By.cssSelector(".btn.btn-primary"));
            //}
            click(submitWe);
            checkValidationMessage(msg);
        }finally {
            destroyDriver();
        }
    }

//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }


    public void checkValidationMessage(String Msg)    {
        WebElement errorMessageWe = findElement(By.cssSelector(".tooltip-inner"));
        String validationmsg = errorMessageWe.getText();
        AssertHelper.assertStringContains(validationmsg, Msg,"Validation message is wrong");
        logger.info("Validation message shown " + validationmsg);
    }
    public void enterPassword()    {
        findElement(By.name("password")).clear();
        clickAtWindow(getWebDriver(), 20, 30);
        findElement(By.name("password")).sendKeys("pass");
    }

    @org.testng.annotations.DataProvider(name = "passwordpages")
    public static Object[][] getPasswordformFields() {
        return new Object[][]{
                {"englishlive.ef.com/en-gb/buy/default/member/?ctr=gb",EfConstants.deMembersFormMap, "Please enter at least 8 characters"},
                //{"englishlive.ef.com/es-mx/welcome/",EfConstants.passwordform, "valida"}
        };
    }



}