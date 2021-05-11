package com.englishtown.pages.deepblue;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.ForgottenPassPage;
import com.englishtown.pages.core.MyBasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by nikol.marku on 12/29/2016.
 */
public class PaymentPlanPage extends MyBasePage {
    public static final Logger logger = LoggerFactory.getLogger(PaymentPlanPage.class);


    /**
     * Main components
     */
    @FindBy(id = "dijit_form_NumberTextBox_0")
    public WebElement orderIdTxt;

    @FindBy(id = "dijit_form_Button_0_label")
    public WebElement searchBtn;


    @FindBy(css = ".dijitButtonContents[id^='dijit_form_ToggleButton_']")
    public WebElement expandBtn;

    @FindBy(css = ".grid_3.col-quantity input[id^='dijit_form_NumberTextBox']")
    public List<WebElement> glQuantityWeList;


    @FindBy(css = ".dijitInputInner[id*='dijit_form_NumberTextBox_']")
    public List<WebElement> phasePriceTxList; // price is the second element

    @FindBy(id = "dijit_form_Button_1_label")
    public WebElement submitChangesBtn;

    // add feature arrow to expand
    @FindBy(css = "[id*='widget_dijit_form_FilteringSelect'] .dijitArrowButtonInner")
    public WebElement openFeatureListWe;

    @FindBy(css = "[id*='dijit_form_FilteringSelect']")
    public List<WebElement> featureWeList;  // is the second one

    //
    @FindBy(css = ".add-btn .dijitButtonText")
    public WebElement addFeatureBtn;



    public PaymentPlanPage(WebDriver webDriver){
        super(webDriver);
    }
    public PaymentPlanPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public PaymentPlanPage(WebDriver webDriver, int timeOutSec) {
        super(webDriver, timeOutSec);
    }
    public PaymentPlanPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(searchBtn);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(searchBtn);
    }

    public void enterOrderId(WebDriver driver, String id){
        WebElementHelper.clearAndsendKeys(driver, orderIdTxt, id, false);
    }

    public void clickSearch(){
        click(searchBtn);
    }

    public void clickExpand(){
        click(expandBtn);
    }

    public void clickAddFeature(){
        click(addFeatureBtn);
    }

    // one expanded list
//    public void selectFeature(WebDriver driver, String featureName, By byCss){
//        List<WebElement> options = driver.getElemets(By.xpath("//span[contains(@class, 'k-input')]"));
//        for(WebElement option : options) {
//            if (option.getText().equals("Texas")) {
//                option.click();
//            }
//        }
//    }

    public void addFeature(WebDriver driver, String featureTxt){
        WebElementHelper.clearAndsendKeys(driver, featureWeList.get(1), featureTxt, false);
        click(featureWeList.get(1));
    }

    public void updatePhasePrice(WebDriver driver, int phasePriceId, String price){
        WebElementHelper.clearAndsendKeys(driver, phasePriceTxList.get(phasePriceId), price, false);
    }
//.add-btn .dijitButtonText
//    public void updateQuantity(WebDriver driver, String quantity, int weId){
//        WebElementHelper.clearAndsendKeys(driver, glQuantityWeList.get(weId), quantity, false);
//
//    }

    public void submitChanges(WebDriver driver){
        click(submitChangesBtn);
        sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertMessage= alert.getText();

        AssertHelper.myAssertThat(null, "popup alert message not the expected one ...!", alertMessage,
                containsIgnoringCase("payment plan updated successfully"), false);
        logger.info("OK alert should be closed ...!"+alertMessage);
        sleep(300);
        alert.accept();
        sleep(3000);
    }
}
