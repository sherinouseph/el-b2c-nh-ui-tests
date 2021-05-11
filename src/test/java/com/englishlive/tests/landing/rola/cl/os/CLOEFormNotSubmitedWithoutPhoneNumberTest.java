package com.englishlive.tests.landing.rola.cl.os;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.core.StringEndsWith.endsWith;

public class CLOEFormNotSubmitedWithoutPhoneNumberTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(CLOEFormNotSubmitedWithoutPhoneNumberTest.class);

    private String urlEndsWith = "/es-mx/" ;


    @Value("#{applicationPropertiesList['cl.os.sur.url']}")
    private String url ;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + url);
        formDataMap = EfConstants.clOEFormNoPhoneMap;
        openUrl(getWebDriver(), url);
        sleep(1000);
        //WaitTool.waitForElementVisible(getWebDriver(), By.className("popup-offer-and-form-content"), 15);
        clickAtWindow(getWebDriver(), 5, 5);
    }

    @Test
    void enterFormDataNoPhoneAndNoPhoneTypeSelected(){
        enterFormData(formDataMap);
    }

    @Test(dependsOnMethods = { "enterFormDataNoPhoneAndNoPhoneTypeSelected" })
    void submitForm(){
        click(WaitTool.findElements(getWebDriver(), By.cssSelector(".formset .btn.btn-primary")).get(0));
        //WebElementHelper.safeFindAndClick(getWebDriver(), By.id("osformsubmit"));
        sleep(3000);
    }

    @Test(dependsOnMethods = { "submitForm" })
    void checkFormNotSubmited(){
        BaseTest.waitForUrlContains(getWebDriver(), "make test to wait for submission to happen ....!", 5);
        AssertHelper.assertWebElementDisplayed(findElement(By.cssSelector(".tooltip-inner")));
        String currentUrl = TestUtil.getCurrentUrl(getWebDriver());
        AssertHelper.assertThat("Url "+currentUrl+" Does not ends with ["+urlEndsWith+"] ...!",currentUrl,  endsWith(urlEndsWith) );
    }


    @AfterClass
    protected void setupAfterClass(){
        destroyDriver();
    }


}
