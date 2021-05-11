package com.englishlive.tests.checkout.newcheckout.memberpage.tracking;
/**
 *
 *
 */
import com.englishtown.tests.checkout.common.core.BaseCheckTrackingServerOnMemberPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DECheckTrackingServerOnMemberPage extends BaseCheckTrackingServerOnMemberPage {
    private static final Logger logger = LoggerFactory.getLogger(DECheckTrackingServerOnMemberPage.class);
    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
    protected String currMemberPageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        this.openUrl(getWebDriver(), this.currMemberPageUrl, -1) ;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}

