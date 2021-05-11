package com.englishtown.tests.core.common;
//SAND-4675-Sherin - check the main links for any reference to aem.eflabs.io or eflabs.io
//Make sure all the links in homepage,how it works page points to format englishlive.ef.com/xx-xx/
/**
 *
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;



public abstract class BaseBodyLinksTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseBodyLinksTest.class);

        protected String testUrl;
        String learnMoreSelector = ".more p a";
        String homePageSelectors = "div>p>a";
        String topMenuList = "nav .menu a";
        String howItWorkSelectors = ".grid .more p a";
        String eflabshref = "a[href*='aem.eflabs.io']";



        @Test
        void checkLinksInHomePage() {
            logger.info("Checking all the links in Home Page");
            List<WebElement> HowItWorks = findElements(By.cssSelector(homePageSelectors));
            for (int i = 0; i < HowItWorks.size(); i++) {
                clickListWebElement(getWebDriver(), By.cssSelector(homePageSelectors), i);
                AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(), getTestStartUrl(), "url not the expected one");
                getWebDriver().navigate().back();
            }
            logger.info(getWebDriver().getCurrentUrl() + " contains " + testStartUrl);
        }

        @Test(dependsOnMethods = "checkLinksInHomePage")
        void navigateToHowItWorkPage() {
            logger.info("Navigate to How it works page");
            openUrl(getWebDriver(), testStartUrl);
            clickListWebElement(getWebDriver(), By.cssSelector(topMenuList), 1);
        }

        @Test(dependsOnMethods = "navigateToHowItWorkPage")
        void checPriceLinksInHowItWorkPage() {
            logger.info("Checking  Price links in HowItWorks Page");
            List<WebElement> Price = findElements(By.cssSelector(howItWorkSelectors));
            for (int i = 0; i < Price.size(); i++) {
                clickListWebElement(getWebDriver(), By.cssSelector(howItWorkSelectors), i);
                AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(), testStartUrl, "url not the expected one");
                getWebDriver().navigate().back();

            }
            logger.info(getWebDriver().getCurrentUrl() + " contains " + testStartUrl);
        }

        @Test(dependsOnMethods = "navigateToHowItWorkPage")
        void checkLearnMoreAboutLink() {
            List<WebElement> learnMore = findElements(By.cssSelector(learnMoreSelector));
            for (int i = 0; i < learnMore.size(); i++) {
                if (i == 0 || i == 4) {
                    logger.info("Checking 'Learn more and Read More' links in HowItWorks Page");
                    clickListWebElement(getWebDriver(), By.cssSelector(learnMoreSelector), i);
                    AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(), testStartUrl, "url not the expected one");
                    logger.info(getWebDriver().getCurrentUrl() + " contains " + testStartUrl);
                    getWebDriver().navigate().back();
                }
            }
        }

    @Test(dependsOnMethods = "checkLearnMoreAboutLink")
     void checkHrefForEFLabsContent(){
     if(findElements(By.cssSelector(eflabshref)).size()>0){
        List <WebElement> content=findElements(By.cssSelector(eflabshref));
        for (int i=0;i<=content.size();i++){ logger.info(content.get(i).getText());}
        failTest("href content wrong");
        }
        logger.info("Hrefs does not contain any reference to aem.eflabs.io or eflabs.io");
        }
}





