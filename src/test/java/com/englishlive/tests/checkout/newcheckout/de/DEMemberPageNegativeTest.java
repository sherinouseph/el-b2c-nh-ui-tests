package com.englishlive.tests.checkout.newcheckout.de;
/**
 * open member page
 * Click submit
 * Check validation page
 *
 */
import com.englishtown.dataprovider.bin.validation.MemberPageValidationMsgBean;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.validation.BaseMemberPageNegativeTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DEMemberPageNegativeTest extends BaseMemberPageNegativeTest {
    private static final Logger logger = LoggerFactory.getLogger(DEMemberPageNegativeTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
    protected String currMemberPageUrl;

    @BeforeClass
    public void setup(){
        isSendKeyBackSpace = true;
        setThreadSafeDriver();
        submitBtnCss=".btn.btn-primary";
        setMemberPageValidationMsgBean();
        TestUtil.printMethodName(logger);
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.deMembersFormMap; //ukMembersFormMap_new;
        logger.info("setup url: "+memberPageUrl);
        openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


    @Override
    public void setMemberPageValidationMsgBean() {
        memberPageValidationMsgBean = new MemberPageValidationMsgBean(
                "Bitte Vornamen eingeben",
                "Bitte Nachnamen eingeben",
                "Geben Sie bitte eine gültige Emailadresse ein",
                "Unter der Email-Adresse |email| wurde ein bestehendes Teilnehmerprofil gefunden.",
                "Bitte geben Sie mindestens 8 Zeichen ein, keine Sonderzeichen/Umlaute",
                "Bitte, stimmen Sie den Datenschutzrichtlinien");
    }
}

