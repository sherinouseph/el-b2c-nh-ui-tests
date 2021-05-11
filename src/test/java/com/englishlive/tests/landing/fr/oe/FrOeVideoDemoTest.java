package com.englishlive.tests.landing.fr.oe;
/**
 * Open URL : http://www.englishtown.fr/lp/oe/anglais-en-ligne/
 * Click Test notre demo
 * validate video shown
 *
 * Created by nikol.marku on 14/07/2015.
 */


import com.englishtown.pages.landing.OELandingPage;
import com.englishtown.tests.core.landingpages.BaseVideoDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class FrOeVideoDemoTest extends BaseVideoDemo {
    private static final Logger logger = LoggerFactory.getLogger(FrOeVideoDemoTest.class);
    @Value("#{applicationPropertiesList['fr.ee1.url']}")
    private String oePageUrl;


    @BeforeClass
    void setup(){
        setThreadSafeDriver();
        getPage().loadPage();
    }

    @Override
    protected OELandingPage createPage() {
        return new OELandingPage(getWebDriver(), this.oePageUrl);
    }


    @AfterClass
    protected void setupAfterClass(){
        destroyDriver();
    }

}
