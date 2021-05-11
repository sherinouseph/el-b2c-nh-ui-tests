//package com.englishtown.newhouse.salesforce.pages.testdata;
///**
// *
// */
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//import java.util.Map;
//
//
//public class ApprovalSalesForcePage extends SalesForceBasePage {
//
//    public static final Logger logger = LoggerFactory.getLogger(ApprovalSalesForcePage.class);
//    public static final String pageUrl = "VirtualTerminalPayment?id=";
//    public  Map paymentDataMap;
//
//
//
//    @FindBy(name = "page:form:block:j_id27:j_id28")
//    public WebElement closeBtn;
//
//    @FindBy(name = "commit")
//    public WebElement payBtn;
//
//
//    public ApprovalSalesForcePage(WebDriver webDriver) {
//        super(webDriver);
//    }
//
//
//    public void setWebDriver(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }
//
//    public boolean simpleTest() {
//        logger.info(" simpleTest() ....!");
//        AssertHelper.assertWebElementDisplayed(closeBtn);
//        return true;
//    }
//
//    public ExpectedCondition getPageLoadedCondition() {
//        return ExpectedConditions.visibilityOf(closeBtn);
//
//    }
//
//    public String getPageUrl() {
//        return pageUrl;
//    }
//
//    public void approveProduct(){
//
//
//    }
//
//
//  }