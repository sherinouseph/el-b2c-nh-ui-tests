package com.englishlive.tests.checkout.newcheckout.fr;

import com.englishlive.tests.checkout.newcheckout.core.BaseCheckCCTypeCard;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by nikol.marku on 25-May-17.
 */



public class CheckCCTypeMasterCardTest extends BaseCheckCCTypeCard {
    private static final Logger logger = LoggerFactory.getLogger(CheckCCTypeMasterCardTest.class);
    @Value("#{applicationPropertiesList['gen.member.fr.be']}")
    protected String memberPageUrl;



    @BeforeClass
    public void setupOpenMemberPage(){
        setThreadSafeDriver();
        failTestPerEnvironment("qa", "Live only test as payment succeed on QA env");
        formDataMap = EfConstants.ukMembersFormMap_new; //deDdPayFormMap;
        ddPayMap    = EfConstants.deDdPayFormMap;
        testStartUrl = memberPageUrl;
        expectedCcTypeValue = "MasterCard";
        openUrl(getWebDriver(),testStartUrl, -1 ) ;
        waitForElementCondition(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector("input[name=firstname]"), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
