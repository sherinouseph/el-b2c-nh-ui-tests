package com.englishlive.tests.smoke.webustest;

import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;

public class FrenchHomePageWebusTest extends HomePageTest {
    @Value("#{applicationPropertiesList['webus.home.fr.fr.url']}")
    public String pageUrl;

    @Override
    protected HomePage createPage() {
        setThreadSafeDriver();
        return new HomePage(getWebDriver(), this.pageUrl);
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }

}
