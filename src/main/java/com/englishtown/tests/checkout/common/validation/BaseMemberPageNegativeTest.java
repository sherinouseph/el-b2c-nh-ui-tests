package com.englishtown.tests.checkout.common.validation;
/**
 * open member page
 * Click submit
 * Check validation message for :
 * No data entered and empty data entered ; first name and second name
 *
 */
import com.englishtown.helpers.WaitTool;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseMemberPageNegativeTest extends BaseCheckoutNegativeTest implements IMemberPageNegativeTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseMemberPageNegativeTest.class);


    @Test
    public void submitEmptyMember(){
        submitMemberPage();
    }

    @Test (dependsOnMethods ={"submitEmptyMember"} )
    public void enterBlankOnAllFieldCheckFirstNameValidationShown(){
        enterBlank_OnAllFieldCheckFirstNameValidationShown();
    }

    @Test (dependsOnMethods ={"enterBlankOnAllFieldCheckFirstNameValidationShown"} )
    public void isFirstNameErrorMessageShown(){
        assert_WebElementVisibleAndTextIsNotEmptyOrNullString(By.cssSelector(invalidErrMsgFirstNameCss),
                WaitTool.DEFAULT_WAIT_4_ELEMENT);
    }

    @Test (dependsOnMethods ={"isFirstNameErrorMessageShown"} )
    public void isSecondNameErrorMessageShown(){
        isSecondName_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isSecondNameErrorMessageShown"} )
    public void isEmailErrorMessageShown(){
        isEmail_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isEmailErrorMessageShown"} )
    public void isPasswordErrorMessageShown(){
        sleep(500);
        isPassword_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isPasswordErrorMessageShown"} )
    public void isTermAndConditionErrorMessageShown(){
        if(StringUtils.equalsIgnoreCase("tr", getMarket())){
            //no TC for TR
        }else
            isTermAndCondition_ErrorMessageShown();
    }

    @Test (dependsOnMethods ={"isTermAndConditionErrorMessageShown"} )
    public void createMember(){
        create_Member();
    }

    @Test (dependsOnMethods ={"createMember"} )
    public void isExistingEmailErrorMsgShown(){
        isExistingUserEmail_ErrorMessageShown(getUserEmail(),isNewhouseCheckout);
    }

    @Test (dependsOnMethods ={"isExistingEmailErrorMsgShown"} )
    public void clickOnLoginLink(){
        if (isNewhouseCheckout){
            click(getWebDriver(),By.cssSelector(loginLinkInErrorMsg));
            sleep(1000);
            assertIsUrlContaining("login");
        }
    }


}

