package com.englishtown.tests.core;
/**
* Smoke test for Home pages  :  DE, FR, IT, JA, GB , BR Mx
* pub1 and pub2
*/
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.HomePage;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.core.Is.is;


public abstract class SmokeBaseTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(SmokeBaseTest.class);

    @Value("#{applicationPropertiesList['pub.base.url']}")
    protected String publisher;
    protected WebElement currentWebElement;
    protected String login = ".login-link";
    protected String firstNameId ="first_name";
    protected String tryUsBtn = ".nav.pull-right a";                 // test button on the right
    protected String tryUsMidleBtn =".column0 .btn.btn-primary";     //testbuton on caurousel
    public static String checkContentCss =".stage h1";
    protected String midleBtnBr =".button-tvad a"; //".content .btn-primary"; // this is used for BR only was ".active .column0 .btn.btn-primary";
    protected String midleBtnRu= ".percent90 .column0 a";
    protected String videoBtn =  ".btn.btn-transparent";
    protected String pageUrl;

    protected static String popupSelector = ".section .modal-body"; //"modal-body"; //".modal-dialog";
    public static boolean isPopupShown = true;

   public SmokeBaseTest(String pageUrl){
        this.pageUrl=pageUrl;
   }

    //TODO REFACTOR THIS ... AND REVIEW
    public void openHomePageCheckMainComponent(String country, String pageUrl, String elementToWaitFor) throws Exception{
        logger.info("openHomePage() for country : "+country);
        String tempPublisher = publisher;

        this.pageUrl = tempPublisher+pageUrl;
        System.out.println("openHomePage() for country and page: " + country+" : "+this.pageUrl);
        try {
            try {
                setThreadSafeDriver();
                getWebDriver().get(this.pageUrl);
                sleep(3000);
            } catch (Exception e) {
                BasePage.failTest(e, " Exception loading page URL : " + this.pageUrl);
            }

            if (!country.matches("ar|ag|be|at|sa")) {
                myAssertThat(getWebDriver(), "verifyUrl '" + getWebDriver().getCurrentUrl() + "' Contains '" + country + "' FAILED ",
                        verifyUrlContains(country, WaitTool.DEFAULT_WAIT_4_ELEMENT), true);
            }
            if (country.equals("br") || country.equals("mx") || country.equals("it")) {
                waitForElementAndclickAtXY(elementToWaitFor, 1, 1);
            }

            if (country.equals("br")) {
                commonHomepageTest(this.midleBtnBr, WaitTool.DEFAULT_WAIT_4_ELEMENT);
            } else {
                if (country.equals("gb") || country.equals("de")|| country.equals("fr") ) {
                    commonHomepageTest(checkContentCss, WaitTool.DEFAULT_WAIT_4_ELEMENT);
                } else {
                    if (country.equals("sa") || country.equals("mx")) {
                    } else
                        commonHomepageTest(this.tryUsMidleBtn, WaitTool.DEFAULT_WAIT_4_ELEMENT);

                }
            }

            if ("mx".equals(country) || "gb".equals(country)) {
                login = "a[href$=\"ingresar-escuela/\"]";
            } else {
                login = ".login-link";
            }
            if (!"de".equals(country) && !"sa".equals(country) && !"fr".equals(country)) {
                commonHomepageTest(this.login, 5);
            }
            if (!country.equals("mx") && !country.equals("sa") && !country.equals("de") && !country.equals("fr")) {
                commonHomepageTest(this.tryUsBtn, 3);
            }

            //CookieHandler.safeDeleteCookies(getWebDriver(), 3);
        }finally {
            destroyDriver();
        }

    }



    // test login form
    public void openLoginPage(String country, String pageUrl, String elementToWaitFor) throws Exception{
        this.pageUrl = publisher+pageUrl;
        logger.info("openLoginPage() for country and page: " + country + " : " + this.pageUrl);
        try{
            getWebDriver().get(this.pageUrl);
            sleep(3000);
        }catch (Exception e){
            logger.error("Exception loading pageUrl :" + this.pageUrl + " Exception : " + e.getCause());
            BasePage.failTest(" Exception loading page URL : "+this.pageUrl);    //fail(" Exception loading page URL : "+this.pageUrl+"  \n Exception : "+e.getCause());
        }

        //assertThat("verifyUrl '" + getWebDriver().getCurrentUrl() + "' Contains '" + country + "' FAILED ", verifyUrlContains(country, 10));
        myAssertThat(getWebDriver(), "verifyUrl '" + getWebDriver().getCurrentUrl() + "' Contains '" + country + "' FAILED ",
                verifyUrlContains(country, WaitTool.SHORT_WAIT_4_ELEMENT), true);
        if(country.equals("br") || country.equals("mx")){
            waitForElementAndclickAtXY(elementToWaitFor, 1, 1);
        }

        myAssertThat(getWebDriver(), "verifyUrl '" + getWebDriver().getCurrentUrl() + "' Contains '" + "login" + "' FAILED ",
                verifyUrlContains(country, WaitTool.WAIT_5s), true);

        if (country != "jp") {
                waitForElementCondition(ExpectedConditions.visibilityOf(getWebDriver().findElement(
                                                                       By.id(elementToWaitFor))), getWebDriver(), 7);
        }
        //
        CookieHandler.safeDeleteCookies(getWebDriver(), 3);
    }


   public void openHomePageClickBtnCheckUrlChanged(String country, String pageUrl, String clickElement)
                throws Exception{
       logger.info("openHomePage() for country : "+country);
       String tempPublisher = publisher;
       boolean isNewSite2016 = false; // new selectors for new site ...

       this.pageUrl = tempPublisher+pageUrl;
       System.out.println("openHomePage() for country and page: " + country + " : " + this.pageUrl);

       try {
           getWebDriver().get(this.pageUrl);
           sleep(3000);
       }catch (Exception e){
           logger.error("Exception loading pageUrl :" + this.pageUrl + " Exception : " + e.getCause());
           BasePage.failTest(e, " Exception loading page URL : "+this.pageUrl);            //fail(" Exception loading page URL : "+this.pageUrl+"  \n Exception : "+e.getCause());
       }

       if(country.equals("br") && clickElement.equals(this.midleBtnBr)){
           logger.info(" is br - middle button click test ...");
           currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(this.midleBtnBr) );
           if(currWebElement == null){
               currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(this.tryUsMidleBtn) );
           }
           if(currWebElement == null){
               BasePage.failTest(" CurrWebElement is null ...!", true);   // fail(" currWebElement is null ...!");
           }
           myAssertThat(getWebDriver(), " is displayed Failed ...!", currWebElement.isDisplayed(), true);
           myAssertThat(getWebDriver(), " is isEnabled Failed ...!", currWebElement.isEnabled(), true);
       } else {
           currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(clickElement) );
           if(currWebElement == null){
               BasePage.failTest(" currWebElement is null ...!", true);    //fail(" currWebElement is null ...!");
           }
           myAssertThat(getWebDriver(), " is displayed Failed ...!", currWebElement.isDisplayed(),true);
           currWebElement.click();
           sleep(500);
           if(country.equals("fr") ){
               logger.info("Dont check URL changed. FR market shows video pop up when click try middle ...");
           }else {
               TestUtil.assertUrlChanged(getWebDriver(), this.pageUrl, WaitTool.DEFAULT_WAIT_4_ELEMENT);
           }
       }
       //
       CookieHandler.safeDeleteCookies(getWebDriver(), 3);
   }

   protected HomePage createPage() {
       return new HomePage(getWebDriver(), this.pageUrl);
   }
   protected HomePage createPage(String pageUrl) {
       this.pageUrl = pageUrl;
       return createPage();
   }

    public void commonHomepageTest(String element, int waitTime){
        try {
            myAssertThat(getWebDriver(), "FAILED element [" + element + "] is NOT Visible ...!. Wait Time :" +
                    waitTime + "s", WaitTool.isElementVisible(getWebDriver(), By.cssSelector(element),
                    waitTime, WaitTool.DEFAULT_POLL_SLEEP), is(true), true);
        }catch (Exception e){                                                                                           //logger.error(" AssertThat failed for isElementVisible(" + element + " ERROR " + e.getMessage().toString());
            BasePage.failTest(e, "commonHomepageTest Exception ", true);                                                //fail("commonHomepageTest Exception "+e.getMessage().toString());
        }
    }

}
