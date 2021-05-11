package com.englishtown.tests.flow.redemption;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.flow.core.BaseFlow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

/**
 * Created by nikol.marku on 29/10/2015.
 * Redemption flow - 2 types autosubmit=false and true
 *
 */
public abstract class BaseRedemptionFlow extends BaseFlow {
    private static final Logger logger = LoggerFactory.getLogger(BaseRedemptionFlow.class);


    protected String redemptionCodeTxtFieldId = "input[name=redemptionCode]";
    protected String submitRCcss = ".btn.btn-primary";
    protected String submitMemberFormCss =".btn.btn-primary";

    protected String redemptionCode ;
    protected String sessionOrderRcodeKey = "order.redemptionCode";
    protected String thankyouPageUrlContains = "redemption/thankyou";
    protected String redemptionTxtWeId = "RedemptionCode";  // old ui br

    public String getRedemptionCodeFromUrl(String url){
        String rCode = null;
        try{
            rCode = url.split("rcode=")[1].split("\\&")[0];
        }catch (NullPointerException | IndexOutOfBoundsException nie){
            logger.error("ERROR : " + TestUtil.getException(nie)+"\n");
        }
        return rCode;
    }

    public void isRedemptionCodePrepopulatedFromUrlParams(WebDriver driver){
        WaitTool.safeFindDisplayedAndEnabled(driver,By.cssSelector(redemptionCodeTxtFieldId) ,25);
        WebElement currWebElement = WaitTool.findElement(driver, By.cssSelector(redemptionCodeTxtFieldId));
        String currentRcode = TestUtil.getWebElementText(currWebElement);
        logger.info(" Redemption code shown in Text field is : "+currentRcode +" --> should be : "+redemptionCode);
        AssertHelper.assertThat("Redemption code is not the expected one ...! ", currentRcode, equalToIgnoringCase(redemptionCode));
    }


}
