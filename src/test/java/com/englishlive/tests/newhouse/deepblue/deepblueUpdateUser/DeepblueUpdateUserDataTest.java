//package com.englishlive.tests.deepblue;
//
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.MyWebDriverAction;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.pages.deepblue.PaymentPlanPage;
//import com.englishtown.tests.core.BaseTestHelper;
//import org.apache.commons.lang.StringUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
///**
// * Created by nikol.marku on 08-Aug-17.
// * helper to update order price and school features for a list of users
// * Run only on damand
// */
//public class DeepblueUpdateUserDataTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(DeepblueUpdateUserDataTest.class);
//
//    protected PaymentPlanPage planPage;
//    protected String noOfGLs = "20";
//    protected String phasePrice = "49";
//    protected String featureStr = "24 ";
//    protected String featureDurationValue = "30";
//    protected String ENV = "qa";
//    protected String DEEPBLUE_URL = "https://"+ENV+"deepblue2.englishtown.com/commerce.internal/paymentplan";
//
//
//
//    @BeforeClass
//    public void setupLoginToDeepblue(){
//        setThreadSafeDriver();
//        testStartUrl = DEEPBLUE_URL; //"https://deepblue2.englishtown.com/commerce.internal/paymentplan";
//        this.openUrl(getWebDriver(),testStartUrl , -1 ) ;
//        logger.info("test");
//        WaitTool.waitForElementVisibleAndClickable(By.id("cred_userid_inputtext"), getWebDriver(), 25);
//        WebElement useridWe = findElement(By.id("cred_userid_inputtext"));
//        WebElementHelper.sendKeys(getWebDriver(), useridWe, "n@ef.com", false);
//        useridWe.sendKeys(Keys.TAB); sleep(5000);
//        WaitTool.waitForElementVisibleAndClickable(By.id("dijit_form_NumberTextBox_0"), getWebDriver(), 25);
//    }
////    // Ruin only on Demand
////    @Test (dataProvider = "orderId", dataProviderClass = OrderIdDataProvider.class)
////    void searchForForOrder_updateGL(int id, String orderId){
////        logger.info("Start updating ... id :"+id+"; OrderId :"+orderId+" ...!");
////        try {
////            searchForForOrder(orderId);
////            sleep(1000);           //.col-price .dijitInputInner        //findElement(By.cssSelector(".col-price .dijitInputInner"));        //waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-price .dijitInputInner")), getWebDriver(), 25);
////            updatePrice();
////            sleep(500);
////            expandOrder();
////            sleep(500);
////            updateGroupLessons();
////            sleep(1000);
////            addSchoolFeature();
////            sleep(1000);
////            updateFeatureDuration(featureDurationValue);
////            sleep(2000);
////            submitChanges();
////            sleep(2000);
////            logger.info("Order id [{}] updated ...!", orderId);
////        }catch (Exception e){
////            e.printStackTrace();
////            //logger.error("Could not update order: id["+orderId+"]"+e.getMessage());
////            failTest("Could not update order: id["+orderId+"]"+e.getMessage());
////        }
////    }
//
//    //@Test
//    void searchForForOrder(String orderId){
//        planPage = new PaymentPlanPage(getWebDriver());
//        sleep(1000);
//        planPage.enterOrderId(getWebDriver(), orderId );
//        planPage.clickSearch();
//        sleep(3000);
//    }
//
//    void updatePrice(){
//        planPage = new PaymentPlanPage(getWebDriver());
//        planPage.updatePhasePrice(getWebDriver(), 1, phasePrice);
//    }
//
//    void addSchoolFeature(){
//        planPage.addFeature(getWebDriver(), featureStr);
//        sleep(1000);
//        planPage.featureWeList.get(1).sendKeys(Keys.TAB);
//        //Actions action = new Actions(getWebDriver());        action.keyDown(Keys.CONTROL).sendKeys(featureDurationValue).perform();
//        //updateFeatureDuration(featureDurationValue);
//        planPage.clickAddFeature();
//        sleep(1000);
//    }
//    //@Test(dependsOnMethods = "searchForForOrder")
//    void expandOrder(){
//        planPage = new PaymentPlanPage(getWebDriver());
//        planPage.clickExpand();
//        sleep(3000);
//    }
//
//    //@Test(dependsOnMethods = "expandOrder")
//    void updateGroupLessons(){
//        planPage = new PaymentPlanPage(getWebDriver());                                                                 //planPage.updateQuantity(getWebDriver(), noOfGLs, 0);
//        WebElement updateMeTxtWe = null;
//
//        List<WebElement> tableRows = getWebDriver().findElements(By.cssSelector(".tr.feature"));
//
//        int size = 0;
//        int weId = -1;
//        if (tableRows != null )
//            size = tableRows.size();
//
//        for(WebElement we : tableRows){
//            weId++;
//            String txt = we.findElement(By.className("td")).getText();
//            if(StringUtils.containsIgnoreCase(txt, "Group discussion" )){
//                logger.info("Found webElement at ID :"+weId);
//                updateMeTxtWe = we.findElement(By.cssSelector(".col-quantity .dijitInputInner"));
//                WebElementHelper.clearAndsendKeys(getWebDriver(), updateMeTxtWe, noOfGLs, false);
//                assertWebElementText(updateMeTxtWe, noOfGLs);
//            }
//        }
//
//        sleep(600);
//        JavaScriptHelper.executeJavaScriptOnWe(getWebDriver(), "arguments[0].focus(); arguments[0].blur(); return true", updateMeTxtWe, 3);
//        //executeJSscript("document.querySelectorAll('.tr.feature .col-quantity .dijitInputInner')["+weId+"].blur()", getWebDriver(), 2);
//        sleep(500);
//    }
//
//    //grid_4 col-duration td   .tr.feature .col-duration input   tr - ".tr.feature"
//    /**
//     *
//     * @param featureTableRowCss    - Get all the rows data
//     * @param featureStr            - get the row that contains string
//     * @param updateCellWeCss       - Cell selector we need to find
//     * @return webElement or null
//     * Note: get the last matched string ...
//     */
//    public WebElement getTableCellWebElement(String featureTableRowCss, String featureStr,
//                                                       String updateCellWeCss) throws NullPointerException{
//        WebElement updateMeTxtWe = null;
//        // get list of rows
//        List<WebElement> tableRows = getWebDriver().findElements(By.cssSelector(featureTableRowCss));
//        int size = 0;
//        int weId = -1;
//        if (tableRows != null )
//            size = tableRows.size();
//
//        // check each row contains matching string ... once found find the cell need updating and return WebElement
//        for(WebElement we : tableRows){
//            weId++;
//            String txt = we.findElement(By.className("td")).getText();
//            if(StringUtils.containsIgnoreCase(txt, featureStr )){
//                updateMeTxtWe = we.findElement(By.cssSelector(updateCellWeCss));
//            }
//        }
//
//        return updateMeTxtWe;
//    }
//
//    //"Business Course"
//    public void updateFeatureDuration(String durationValue){
//        WebElement cellWe = getTableCellWebElement(".tr.feature", "Business Course", "input[id^='dijit_form_NumberTextBox']");
//        WebElementHelper.clearAndsendKeys(getWebDriver(), cellWe, durationValue, false);
//        assertWebElementText(cellWe, durationValue);
//        sleep(1000);
//        JavaScriptHelper.executeJavaScriptOnWe(getWebDriver(), "arguments[0].focus(); arguments[0].blur(); return true", cellWe, 3);
//        sleep(1000);
//    }
//    public void updateFeatureDurationQuantity(){
//        //getTableCellWebElement
//        sleep(1000);
//        JavaScriptHelper.executeJavaScriptOnWe(getWebDriver(), "arguments[0].focus(); arguments[0].blur(); return true", null, 3);
//        sleep(1000);
//    }
//
//    //@Test(dependsOnMethods = "updateGroupLessons")
//    void changePhasePrice(){
//        planPage = new PaymentPlanPage(getWebDriver());
//
//        sleep(1000);
//    }
//
//    //@Test(dependsOnMethods = "changePhasePrice")
//    void submitChanges(){
//        planPage.submitChanges(getWebDriver());
//        sleep(1000);
//    }
//
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
