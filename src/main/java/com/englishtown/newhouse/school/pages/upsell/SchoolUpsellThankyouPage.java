package com.englishtown.newhouse.school.pages.upsell;
/**
 * Nikol Feb 2018
 *
 * Upsell thankyou page
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.newhouse.school.pages.upsell.module.UpsellOrderLineModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.containsString;


public class SchoolUpsellThankyouPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(SchoolUpsellThankyouPage.class);
    public static final String pageUrl = "/buy/upsell/thankyou/";

    protected UpsellOrderLineModule upsellOrderLineModule;

    protected final String tyDescriptionTxtCss = "description"; // class

    /**
     * Page components
     */
    @FindBy(className = tyDescriptionTxtCss)
    public WebElement thankyouForYourPaymentTxWe;  // Thank you, your payment ....Confirmation has been sent to auto_upsell_buy@qp1.org

    @FindBy(className = "print")
    public WebElement printWe;    // print link and icon

    @FindBy(css = ".total .price")
    public WebElement totalPriceWe;   // £109.00

    @FindBy(className = "btn-primary")
    public WebElement bookLessonNowWe;

    @FindBy(css = ".buttons a")   //continue to studying  ... not anymore .. karim
    public WebElement continueStudyingBtnWe;


    //
    //-------------------------------------------------------------------------------------
    public SchoolUpsellThankyouPage(WebDriver webDriver) {
        super(webDriver);
        initializeModules();
    }

    public SchoolUpsellThankyouPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
        initializeModules();
    }

    public SchoolUpsellThankyouPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public SchoolUpsellThankyouPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void initializeModules() {
        upsellOrderLineModule = new UpsellOrderLineModule(getWebDriver());
    }
    //-------------------------------------------------------------------------------------
    /**
     * Helper Methods 
     *
     ********************************/
    /***
     * @param index
     *
     */
    public void checkOrderLineDisplayed(int index) {
        upsellOrderLineModule.checkMainOrderLineElementsDisplayed(index);
    }

    //-------------------------
    public void clickBookYourLesson() {
        click(bookLessonNowWe);
    }

    public void clickContinueStudying() {
        click(continueStudyingBtnWe);
    }

    public void clickPrint() {
        click(printWe);
    }

    public String getTotalPrice() {
        return TestUtil.getWebElementText(totalPriceWe);
    }

    public double getTotalPriceDouble() {
        String price = TestUtil.getWebElementText(totalPriceWe);
        return TestUtil.getNumberOutOfString(price);
    }


    public void checkSummaryOrderLines(int lineInex) {
        upsellOrderLineModule.checkMainOrderLineElementsDisplayed(lineInex);
    }

    public int getTotalOrderLines() {
        return upsellOrderLineModule.getTotalNumberOfOffers();
    }

    public void assertTyMessageContainsUsername(String username){
        WaitTool.waitForTextPresent(getWebDriver(),
                By.className(tyDescriptionTxtCss), username, 30, false);
        AssertHelper.assertThat("Payment completed message does not contains expected username ...!",
                TestUtil.getWebElementText(thankyouForYourPaymentTxWe), containsString(username));
    }

    //-------------------------------------------------------------------------------------
    /**
     * Base Methods for all POMs 
     *
     */
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(bookLessonNowWe);
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(bookLessonNowWe);

        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed(thankyouForYourPaymentTxWe, printWe, totalPriceWe, bookLessonNowWe);//, continueStudyingBtnWe );
        upsellOrderLineModule.simpleTest();
        //orderLineModule.checkAllPageComponentsDisplayed();
        return true;
    }

    @Override
    public String getPageUrl() {
        return pageUrl;
    }


}
