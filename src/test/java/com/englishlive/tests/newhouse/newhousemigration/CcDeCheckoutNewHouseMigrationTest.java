package com.englishlive.tests.newhouse.newhousemigration;
/**
 * Creates an enrolled old house user and migrate the user to newhouse
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CcDeCheckoutNewHouseMigrationTest extends NewHouseMigrationTest {
    private static final Logger logger = LoggerFactory.getLogger(CcDeCheckoutNewHouseMigrationTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
    protected String currMemberPageUrl;

    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        phase1OfferPrice ="59";
        TestUtil.printMethodName(logger);
        creditCardLinkText="Kreditkarte";
        tabId = 1;
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.deMembersWithPhoneMap;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 );
        setLanguageAndMarket("de", "de");
        //isEnrolStudent=true;

    }

    @Override
    protected String getMemberPageUrl() {
        memberPageUrl = currMemberPageUrl;
        return memberPageUrl;
    }

    @AfterClass
    protected void testAfterClass(){

        destroyDriver();
    }

}