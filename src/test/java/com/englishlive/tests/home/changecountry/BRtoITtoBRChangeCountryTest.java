//package com.englishlive.tests.home.changecountry;
//
///**
// * Created by nikol.marku on 8/26/2016.
// * Open URL1
// * change country
// * verify
// * change country back to test start
// * verify
// *
// */
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.common.NewHomePage;
//import com.englishtown.tests.core.BaseTestHelper;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.Matchers.containsString;
//////BR team changed the site so they check this
//
//public class BRtoITtoBRChangeCountryTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(BRtoITtoBRChangeCountryTest.class);
//    @Value("#{applicationPropertiesList['home.page.br']}")
//    private String startTestUrl;
//    @Value("#{applicationPropertiesList['home.page.it']}")
//    private String changeCountryUrl;
//
//    public String currentCountry; // this is the 2 letter code for the country
//    public String expectedCountry; // once you change country you should be on this country
//    protected String changeCountryCss        = ".change-country";             // old site
//    protected String changeCountryNewSiteCss = ".flag-icon.dynamic-country";  //change country flag
//
//
//    @BeforeClass
//    protected void setup() {
//        setThreadSafeDriver();
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        currentCountry = "br";
//        expectedCountry = "it";
//        openUrl(getWebDriver(),startTestUrl, WaitTool.MED_WAIT_4_ELEMENT);
//        clickAtWindow(getWebDriver(), 5, 5);
//    }
//
//    @Test
//    void change_Country(){
//        changeCountry(false, "Itália");
//        NewHomePage newHomePage = new NewHomePage(getWebDriver());
//        newHomePage.simpleTest();
//        assertIsUrlContaining("it-it");
//    }
//
//    @Test
//    void change_Country_back(){
//        changeCountry(true, "Brasil");
//        sleep(3000);
//        AssertHelper.assertThat("URL is not the expected one ... BR site !", getWebDriver().getCurrentUrl(), containsString("com/pt-br/"));
//    }
//
//    @AfterClass
//    protected void tearDownAfterClass(){
//        destroyDriver();
//    }
//
//    /**
//     *
//     * @param isNewSite
//     * @param countryLinkText  e.g Italia
//     */
//    protected void changeCountry(boolean isNewSite, String countryLinkText){
//        if(isNewSite){   // new site
//            click(getWebDriver(), By.cssSelector(changeCountryNewSiteCss));
//            WebElement changeCtrTo =  findElement(By.linkText(countryLinkText));
//            scrollToWeAndClick(getWebDriver(),changeCtrTo,0,300);
//        }else {          // old site
//            click(getWebDriver(), By.cssSelector(changeCountryCss));
//            WebElement changeCtrTo =  findElement(By.linkText(countryLinkText));
//            click(changeCtrTo);
//        }
//
//    }
//
//
//
//
//}
