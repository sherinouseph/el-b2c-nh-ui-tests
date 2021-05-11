package com.englishlive.tests.home.fr;
/**
 As a User
 When I open URL : http://www.englishtown.fr/
 Then I see Chat button
 */
import com.englishtown.helpers.UrlMapper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.common.ProactiveChatBaseTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class FrProactiveChatTest extends ProactiveChatBaseTest {
    @Value("#{applicationPropertiesList['home.fr.fr.url']}")
    public String pageUrl;

    @BeforeClass
    protected void setup() {
        setThreadSafeDriver();
        this.openUrl(getWebDriver(),pageUrl, WaitTool.MED_WAIT_4_ELEMENT);
    }


    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }

}
