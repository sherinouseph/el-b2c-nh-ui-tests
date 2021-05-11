package com.englishtown.newhouse.school.pages.account;
/**
 * Nikol - 08/10/2018
 * Privacy setting
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PrivacySettingPage extends BaseAccountSettingPage {
    public static final Logger logger = LoggerFactory.getLogger(PrivacySettingPage.class);
    public static final String pageUrl = "/customerservice/privacysetting";

    @FindBy(css = ".toggle")
    public List<WebElement> profileSettingToggleList;  // 0 ->Promote, Find, Display Status .. for the profile


    //My profile viewable by
    @FindBy(css = "select[name='CanProfileViewableByEveryone']")
    public WebElement canProfileViewableByEveryoneSelectWe;
    //My updates viewable by
    @FindBy(css = "select[name='CanEveryoneSeeMyUpdates']")
    public WebElement canEveryoneSeeMyUpdatesSelectWe;
    //My photos viewable by
    @FindBy(css = "select[name='CanPhotoViewableByEveryone']")
    public WebElement canPhotoViewableByEveryoneSelectWe;
    //My live chat accessibility
    @FindBy(css = "select[name='CanReceiveMessageFromEveryone']")
    public WebElement canReceiveMessageFromEveryoneSelectWe;



    public PrivacySettingPage(WebDriver webDriver){
        super(webDriver);
    }

    public PrivacySettingPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public PrivacySettingPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public PrivacySettingPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(profileSettingToggleList.get(0), canProfileViewableByEveryoneSelectWe,
                canEveryoneSeeMyUpdatesSelectWe, canPhotoViewableByEveryoneSelectWe, canReceiveMessageFromEveryoneSelectWe);
        return false;
    }

    public boolean simpleTest() {
        logger.info("check displayProfileStatusSelectWe is present...!");
        AssertHelper.assertWebElementDisplayed(canReceiveMessageFromEveryoneSelectWe);
        return true;
    }

    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(canReceiveMessageFromEveryoneSelectWe);
    }

    public void setToggle(boolean setToggleStatus){
        boolean currentToggleStatus = false;
        for(WebElement toggleWe : profileSettingToggleList) {
            currentToggleStatus = getToggleStatus(toggleWe);
            if(currentToggleStatus != setToggleStatus ) {
                click(toggleWe);
                logger.info("Clicked to change status [{}]", toggleWe);
                sleep(500);
            }
        }
    }

    /************************************************************************
     * Change Setting
     *
     */
    /**
     *
     * @param selectValue    - true = everone  false = my friends
     * @param setThisWebElement
     */
    public void changePrivacySetting(String selectValue, WebElement setThisWebElement){
        logger.info("changePrivacySetting [{}]", selectValue);
        WebElementHelper.selectByValue(getWebDriver(), setThisWebElement, selectValue);
    }

    /*public String getSelectedSetting(String selectValue, WebElement setThisWebElement){
        logger.info("getSelectedSetting [{}]", selectValue);
        return TestUtil.getWebElementText(WebElementHelper.getSelectedOptionWe(setThisWebElement));
    }*/


}
