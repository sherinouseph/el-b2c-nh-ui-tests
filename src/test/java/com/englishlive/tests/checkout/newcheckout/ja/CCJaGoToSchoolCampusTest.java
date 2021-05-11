package com.englishlive.tests.checkout.newcheckout.ja;
/**
 *Enrolled JP user with username stored in Grid
 *
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.CheckCampusPageTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CCJaGoToSchoolCampusTest extends CheckCampusPageTest {
    private static final Logger logger = LoggerFactory.getLogger(CCJaGoToSchoolCampusTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.ja.jp.url']}")
    protected String currMemberPageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        TestUtil.printMethodName(logger);
        isEnrolStudent=true;
        isStoreData=true;
        creditCardLinkText="Kreditkarte";
        phase1OfferPrice="8910";
        paymentSubmitBtnCss = ".btn.btn-primary";
        setLanguageAndMarket("ja","jp");
        isNewhouseTyPage = true; // even though not in new house
        isClickTabId= false;
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.ukMembersFormMap_new;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ; //getWebDriver().get(this.memberPageUrl);
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

