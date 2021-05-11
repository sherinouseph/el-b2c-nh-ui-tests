package com.englishlive.tests.home.changecountry;

/**
 * Created by nikol.marku on 8/26/2016.
 * Open URL1
 * change country
 * verify
 * change country back to test start
 * verify
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.NewHomePage;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;


public class DEtoITtoDEChangeCountryTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(DEtoITtoDEChangeCountryTest.class);
    @Value("#{applicationPropertiesList['home.page.de']}")
    private String startTestUrl;
    @Value("#{applicationPropertiesList['home.page.it']}")
    private String changeCountryUrl;

    public String currentCountry; // this is the 2 letter code for the country
    public String expectedCountry; // once you change country you should be on this country
    protected String changeCountryCss        = ".change-country";             // old site
    protected String changeCountryNewSiteCss = ".flag-icon.dynamic-country";  //change country flag


    @BeforeClass
    protected void setup() {
        setThreadSafeDriver();
        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
        currentCountry = "de";  // ? init from url
        expectedCountry = "it";
        openUrl(getWebDriver(),startTestUrl, WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @Test
    void change_Country(){
        changeCountry(true, "Italia");
        NewHomePage newHomePage = new NewHomePage(getWebDriver());
        newHomePage.simpleTest();
        assertIsUrlContaining("it-it");
    }

    @Test
    void change_Country_back(){
        changeCountry(true, "Deutschland");
        sleep(3000);
        AssertHelper.assertThat("URL is not the expected one ... DE site !", getWebDriver().getCurrentUrl(), containsString("de-de"));
    }

    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }

    /**
     *
     * @param isNewSite
     * @param changeCountryToLinkText  e.g Italia
     */
    protected void changeCountry(boolean isNewSite, String changeCountryToLinkText){
        if(isNewSite){   // new site
            click(getWebDriver(), By.cssSelector(changeCountryNewSiteCss));
            WebElement changeCtrTo =  findElement(By.linkText(changeCountryToLinkText));
            scrollToWeAndClick(getWebDriver(),changeCtrTo,0,300);
        }else {          // old site
            click(getWebDriver(), By.cssSelector(changeCountryCss));
            WebElement changeCtrTo =  findElement(By.linkText(changeCountryToLinkText));
            click(changeCtrTo);
        }

    }




}
