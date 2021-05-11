package com.englishtown.newhouse.salesforce.pages;
/**
 * Nikol - 01/16/2018
 *
 * Users receive and email with link to payment details
 * Note: not for taiwan
 * https://jira.eflabs.io/browse/SAND-5184
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;


public class VisualForcePayDetailsPage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(VisualForcePayDetailsPage.class);
    public static final String pageUrl = "https://qa-ef.cs5.force.com/force/WelcomeMailPaymentDetailsSection?act=a00O000000clorTIAQ&lng=ar";
                                         // fr https://qa-ef.cs5.force.com/force/WelcomeMailPaymentDetailsSection?act=a00O000000clorxIAA&lng=fr

    protected String passwordTxt = "password";

    @FindBy(tagName = "h3")
    public List<WebElement> sectionsHeadingList;  // should be 3

    @FindBy(className = "detailList")
    public List<WebElement> sectionsDetailList;  // should be 3

    @FindBy(css = ".data2Col.first")
    public List<WebElement> firstLinesOfDetailsList;  // should be 3  0=email, 1=actual 2=paymentSection


    public VisualForcePayDetailsPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(firstLinesOfDetailsList.get(0));
        return true;
    }

    public boolean extendedTest() {
        logger.info(" extendedTest() ....!");
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), sectionsHeadingList, 3);
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), sectionsDetailList, 3);
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), firstLinesOfDetailsList, 3);
        return true;
    }

    public boolean checkEmail() {
        logger.info(" checkEmail() not empty nor null and contains '@' > 5....!");
        String email = TestUtil.getWebElementText(firstLinesOfDetailsList.get(0));
        int emailLength = 0;
        if(null != email){
            emailLength = email.length();
        }else {
            failTest("Email is null ...or cant get it from the site ....!");
        }
        logger.info(" email: "+email+" - Length: "+emailLength);
        AssertHelper.assertThat("Email is empty or null ...!", email, not(isEmptyOrNullString()));
        AssertHelper.assertThat("Email Does not contains '@' sign ...!", email, containsString("@"));
        AssertHelper.assertThat("Email length should be greater than 4 chars ...!",emailLength, greaterThan(5));

        return true;
    }

    public boolean checkActual() {
        logger.info(" checkActual() not empty nor null and greater than 5 chars ....!");
        String actualId = TestUtil.getWebElementText(firstLinesOfDetailsList.get(1));
        int actualIdLength = 0;
        if(null != actualId){
            actualIdLength = actualId.length();
        }else {
            failTest("Actual ID is null ...or cant get it from the site ....!");
        }
        logger.info(" actualId: "+actualId+" - Length: "+actualIdLength);

        AssertHelper.assertThat("is empty or null ...!", actualId, not(isEmptyOrNullString()));
        AssertHelper.assertThat("Actual Length should be greater than 10 chars ...!", actualIdLength , greaterThan(10));
        AssertHelper.assertThat("Email Does not contains '@' sign ...!", actualId, startsWith("FIN-"));

        return true;
    }

    // TODO add test to check the language [create list for dif langs and check content per market ]

    public String getPageUrl() {
        return pageUrl;
    }


    

}