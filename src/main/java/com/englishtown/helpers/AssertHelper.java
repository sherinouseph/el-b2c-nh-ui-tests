package com.englishtown.helpers;
/**
 * Assert wrapper
 * Add page url to the failure message
 *
 * Created by nikol.marku on 13/04/2015.
 */

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Pattern;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

//import com.jcabi.matchers.RegexMatchers;
//import org.hamcrest.MatcherAssert;

public class AssertHelper extends MatcherAssert{
    private static final Logger logger = LoggerFactory.getLogger(AssertHelper.class);

    protected static Description description;

    /**
     * Update org.hamcrest.MatcherAssert.assertThat with URL on the failed message
     * Add URL to the reason of test failure
     * @param driver  @param reason  @param actual @param matcher   @param <T>
     */
    public static <T> void myAssertThat(WebDriver driver, String reason, T actual, Matcher<? super T> matcher, boolean isGetUrl){
        if(isGetUrl){
            setReasonWithUrl(reason, driver);
        }
        assertThat(reason, actual, matcher);
    }

    public static void myAssertThat(WebDriver driver, String reason, boolean assertion, boolean isGetUrl) {
        if(isGetUrl){
            setReasonWithUrl(reason, driver);
        }
        if (!assertion) {
            throw new AssertionError(reason);
        }
    }

    public static String setReasonWithUrl(String reason, WebDriver driver){
        Object URL = TestUtil.getCurrentUrl(driver);
        reason+= "\n URL is : "+URL;
        return reason;
    }

    public static void assertElementSizeLessThanOrEqual(WebDriver driver, By bySelector, int noOfElements, int waitTimeSec){
        try {
            List<WebElement> webElements = WaitTool.waitForListElementsPresent(driver, bySelector, waitTimeSec);
            assertElementSizeLessThanOrEqual(driver, webElements, noOfElements, waitTimeSec);
        }catch (Exception e){
            BasePage.failTest(e, "assertElementSizeLessThanOrEqual Exception ...! ", true);
        }
    }
    public static void assertElementSizeLessThanOrEqual(WebDriver driver, List<WebElement> webElements, int noOfElements, int waitTimeSec){
        if(webElements == null || webElements.isEmpty()){
            BasePage.failTest("assertElementSizeLessThanOrEqual is null or empty ...! ", true);
        } else {
            logger.info("Elements List size is [{}] , Should be less than or equal to [" + noOfElements + "] ...!", webElements.size());
            myAssertThat(driver,"Failed Elements Size is not equal or less ...! : [" + noOfElements + "] ...!", webElements.size(), lessThanOrEqualTo(noOfElements), true );
        }
    }

    public static void assertElementSizeMoreThanOrEqual(WebDriver driver, By bySelector, int noOfElements, int waitTimeSec){
        try {
            List<WebElement> webElements = WaitTool.waitForListElementsPresent(driver, bySelector, waitTimeSec);
            assertElementSizeMoreThanOrEqual( driver, webElements,  noOfElements);
        }catch (Exception e){
            BasePage.failTest(e, "assertElementSizeMoreThanOrEqual Exception ...! ", true);
        }
    }
    public static void assertElementSizeMoreThanOrEqual(WebDriver driver, List<WebElement> we, int noOfElements){
        if(we == null || we.isEmpty()){
            BasePage.failTest("assertElementSizeMoreThanOrEqual is null or empty ...! ", true);
        } else {
            logger.info("Elements List size is [{}] , Should be More than or equal to [" + noOfElements + "] ...!", we.size());
            myAssertThat(driver,"Failed Elements Size is not equal or More ...! : [" + noOfElements + "] ...!", we.size(), greaterThanOrEqualTo(noOfElements), true );
        }
    }

    public static void assertElementSizeEqual(WebDriver driver, List<WebElement> we, int noOfElements){
        if(we == null || we.isEmpty()){
            BasePage.failTest("assertElementSizeEqual is null or empty ...! ", true);
        } else {
            logger.info("Elements List size is [{}] , Should be equal to [" + noOfElements + "] ...!", we.size());
            myAssertThat(driver,"Failed Elements Size is not equal to [" + noOfElements + "] ...!", we.size(), equalTo(noOfElements), true );
        }
    }

    //
    public static void assertWebElementDisplayed(WebElement element){
        logger.info("assertWebElementDisplayed : "+element);
        if(element != null){
            if(element.isDisplayed()){
                logger.info("Element is displayed ....!");
            }else {
                logger.info("Element is Not displayed ....!");
                BasePage.failTest("WebElement is NOT Displayed ...! ; "+element, true);
            }
        } else {
            BasePage.failTest("WebElement is NOT Displayed ... it is NULL ...! ", true);

        }
    }

    public static boolean assertComponentsDisplayed(WebElement... webElements){
        logger.info("checkAllPageComponents ...!");

        for(WebElement we : webElements) {
            assertWebElementDisplayed(we);
        }

        return true;
    }

    public static void assertWebElementDisplayed(WebDriver driver, By bySelector){
        logger.info("assertWebElementDisplayed : "+bySelector);
        WebElement element = WaitTool.findElement(driver, bySelector);

        if(element != null){
            if(element.isDisplayed()){
                logger.info("Element is displayed ....!");
            }else {
                logger.info("Element is Not displayed ....!");
                BasePage.failTest("WebElement is NOT Displayed ...! ; "+bySelector, true);
            }
        } else {
            BasePage.failTest("FWebElement is NOT Displayed ... it is NULL ...! "+bySelector, true);

        }
    }


    public static void assertWebElementEnambled(WebDriver driver, WebElement webElement){
        logger.info("assertWebElementEnambled : "+webElement);

        if(WaitTool.isEnabled(driver, webElement)){
            logger.info("Element is isEnabled ....!");
        } else {
            BasePage.failTest("WebElement is NOT isEnabled ...  ...! "+webElement, true);
        }
    }

    public static void assertWebElementNotEnambled(WebDriver driver, WebElement webElement){
        logger.info("assertWebElementEnambled : "+webElement);

        if(WaitTool.isEnabled(driver, webElement)){
            BasePage.failTest("WebElement is isEnabled ...  ...! "+webElement, true);
        } else {
            logger.info("Element is Not Enabled as expected....!");
        }
    }

    public static void assertWebElementNotDisplayed(WebElement element){
        logger.info("assertWebElementNotDisplayed "+element);

        if(element != null){
            if(element.isDisplayed()){
                logger.info("Element is displayed ....!");
                BasePage.failTest("WebElement is Displayed and should not...! ; "+element, true);
            }else {
                logger.info("Element is Not displayed ....!");

            }
        } else {
            logger.info("WebElement is NOT Displayed ... it is NULL ...! "+element);
            //BasePage.failTest("WebElement is NOT Displayed ... it is NULL ...! "+element);

        }
    }


    public static void assertWebElementNotDisplayed(WebDriver driver, By bySelector){
        logger.info("assertWebElementNotDisplayed : "+bySelector);
        WebElement element = WaitTool.findElementDontFailTest(driver, bySelector);

        if(element != null){
            if(element.isDisplayed()){
                logger.info("Element is displayed ....!");
                BasePage.failTest("WebElement is Displayed and should not...! ; "+bySelector, true);
            }else {
                logger.info("Element is Not displayed ....!");

            }
        } else {
            logger.info("WebElement is NOT Displayed ... it is NULL ...! "+bySelector);
            //BasePage.failTest("WebElement is NOT Displayed ... it is NULL ...! "+bySelector, true);

        }
    }

    public static void assertHasNoJavaScriptErrors(WebDriver driver, int waitTimeSeconds){
        List<JavaScriptError> jsErrorList = JavaScriptHelper.getJavaScriptErrors(driver, waitTimeSeconds);
        if(CollectionUtils.isEmpty(jsErrorList)){
           logger.info("No JS errors found so far ...! waited :"+waitTimeSeconds);
        } else {
            BasePage.failTest("Found Java Script errors ...! Number of Errors ["+jsErrorList.size()+"]", false);
        }
    }


    public static void assertUrlContains( String currentUrl, String urlContains, String failMsg){
        AssertHelper.assertThat(failMsg, currentUrl, containsString(urlContains));
    }
    public static void assertStringContains( String content, String contains, String failMsg){
       assertThat(failMsg, content, containsString(contains));
    }

    /**
     * import java.util.regex.Pattern;
     * import java.util.regex.Matcher;
     * @param s
     * @return
     */

    public static boolean stringContainsRegEx( String s, String pattern )  {
        Pattern p = Pattern.compile( pattern );  //"[0-9]"
        java.util.regex.Matcher m = p.matcher( s );

        return m.find();
    }

    public static void assertStringContainsPattern(String checkMeStr, String pattern) {
        assertThat("Does not match your pattern ...!", stringContainsRegEx(checkMeStr, pattern), is(true));
    }


    public static boolean assertWebElementTextContains(int matchNumber, WebElement webElement){
        logger.info("assertStringContainsNumber [{}]", matchNumber);
        String currentWeText = TestUtil.getWebElementText(webElement);
        if(StringUtil.isBlank(currentWeText))
            BasePage.failTest("Can't get Number of topics / lessons...!");

        AssertHelper.assertThat("Not the expected number of topics / lesson ...!",
                StringUtils.contains( currentWeText, String.valueOf(matchNumber)));
        return true;
    }

    public static boolean assertWebElementTextContains(String containString, WebElement webElement){
        logger.info("assertWebElementTextContains [{}]", containString);
        assertThat("Is not the expected text ...!",
                TestUtil.getWebElementText(webElement), containsIgnoringCase(containString));
        return true;
    }

}

     // REF
    /**********************************************************************************
     * USE THIS IF YOU NEED A CUSTOM IMPLEMENTATION OF ASSERTION ERROR SHOWN BY DEFAULT
     *
     * Need to manipulate the reason of failure stack trace not to print all
     * but first 5 lines and then only EF classes
     */
//    public static <T> void assertThat(String reason, T actual, Matcher<? super T> matcher) {
//        if (!matcher.matches(actual)) {
//            description = new StringDescription();
//            description.appendText(reason)
//                    .appendText("\nExpected: ")
//                    .appendDescriptionOf(matcher)
//                    .appendText("\n     but: ");
//            matcher.describeMismatch(actual, description);
//            throw new AssertionError(description.toString());
//        }
//    }
    //Matcher regexMatcher = Matchers.is(pattern);
//assertThat("Does not match your pattern ...!", checkMeStr, regexMatcher);
//MatcherAssert.assertThat( "foobar456", RegexMatchers.containsPattern("ar45") );
// assertThat("Expected result matches regular expression",    expected.matches(regularExpression),is(true));