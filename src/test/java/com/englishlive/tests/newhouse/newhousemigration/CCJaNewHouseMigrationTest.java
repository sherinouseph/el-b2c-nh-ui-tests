package com.englishlive.tests.newhouse.newhousemigration;
/**
 *
 *Creates an enrolled old house user and migrate the user to newhouse
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CCJaNewHouseMigrationTest extends NewHouseMigrationTest {
    private static final Logger logger = LoggerFactory.getLogger(CCJaNewHouseMigrationTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.ja.jp.url']}")
    protected String currMemberPageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
       // isEnrolStudent=true;
        TestUtil.printMethodName(logger);
        creditCardLinkText="Kreditkarte";
        phase1OfferPrice="8532";
        paymentSubmitBtnCss = ".bs3 .btn";
        setLanguageAndMarket("ja","jp");
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

