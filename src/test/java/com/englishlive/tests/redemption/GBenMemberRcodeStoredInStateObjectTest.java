package com.englishlive.tests.redemption;
/**
 * Created by nikol.marku on 04/07/2016.
 *
 */
import com.englishtown.tests.core.stateobject.BaseRcodeStoredInStateObjectTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class GBenMemberRcodeStoredInStateObjectTest extends BaseRcodeStoredInStateObjectTest {
    private static final Logger logger = LoggerFactory.getLogger(GBenMemberRcodeStoredInStateObjectTest.class);

    @Value("#{applicationPropertiesList['checkout.member.en.en.url']}")    //['reden.en.gb.member']}")
    protected String testUrl ;


    @BeforeClass
    public void setupOpenUrlWithRcode(){
        setThreadSafeDriver();
        String thisTestUrl = testUrl+"?rcode="+redemptionCode;
        logger.info("Test URL is : "+thisTestUrl);
        openUrl(getWebDriver(), thisTestUrl ) ;
        sleep(1000);        //WaitTool.waitForElementVisibleAndClickable(By.id("telephone"), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }
}



