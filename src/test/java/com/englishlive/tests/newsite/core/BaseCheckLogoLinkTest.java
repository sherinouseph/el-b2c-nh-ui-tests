package com.englishlive.tests.newsite.core;
/**
 * Created by nikol.marku on 8/5/2016.
 * Check log has a HREF value
 * 1. Open homepage     ->  assert href is domain+ xx-xx
 * 2. go to Price page  ->  assert href value is as above
 * 3. click on logo ... you are at homepage
 *
 * // this has changed as log shows
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.pages.common.core.PriceAndPackagekPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;


public abstract class BaseCheckLogoLinkTest extends BaseNewSite {
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckLogoLinkTest.class);

    @Test
    void checkLogoHrefHomePage(){
        logger.info("checkLogHrefHomePage ...!");  //$('.logo a')[0].getAttribute("href");
        String logoHref = getAttributeValue(newHomePage.logoAtag, "href");
        logger.info("HREF VALUE IS ["+logoHref+"]");
        if (ObjectUtils.nullSafeEquals(logoHref, null)) {
            String error = "Can't get a HREF value for the logo image ...!";
            failTest("Can't get HREF value for the logo image / null ...! "+newHomePage.logoAtag);
        }
        AssertHelper.assertThat("Logo Href URL is not the expected one [should be base + homepage] ....! ", logoHref, equalTo(testStartUrl) );
        //sleep(3000);
    }
    @Test(dependsOnMethods = "checkLogoHrefHomePage")
    void checkLogoHrefPricePaqe(){
        logger.info("go to price page ...!");
        click(newHomePage.topMenuList.get(2));
        sleep(3000);
        priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
        priceAndPackagekPage.simpleTest();
        String logoHref = getAttributeValue(priceAndPackagekPage.logoAtag, "href");
        logger.info("HREF VALUE IS ["+logoHref+"]");
        if (ObjectUtils.nullSafeEquals(logoHref, null)) {
            String error = "Can't get a HREF value for the logo image ...!";
            failTest("Can't get HREF value for the logo image / null ...! "+priceAndPackagekPage.logoAtag);
        }
        AssertHelper.assertThat("Logo Href URL is not the expected one [.. one dir up] ....! ",
                logoHref, equalTo(testStartUrl));  //testStartUrl need to be striped if is is not the market homepage
        //sleep(3000);
    }

    @Test(dependsOnMethods = "checkLogoHrefPricePaqe")
    void clickLogoOnPricePageTakesYouHome(){
        logger.info("clickLogoOnPricePageTakesYouHome ...!");
        click(priceAndPackagekPage.logoList.get(0));
        //sleep(3000);
        newHomePage.simpleTest();

    }

}
