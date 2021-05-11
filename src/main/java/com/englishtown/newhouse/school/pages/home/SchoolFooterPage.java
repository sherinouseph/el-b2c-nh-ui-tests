package com.englishtown.newhouse.school.pages.home;
/**
 * Nikol Jan 2018
 *
 * Footer for Home page * Once user logged in and completed enrolment school page is shown
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;


public class SchoolFooterPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(SchoolFooterPage.class);
    public static final String pageUrl = "/campus/mypage/home";
    public static final String changeLanguageListCss = ".ue-language-select li>a";

    public String copyrightTxt = "Copyright";
    /**
     * email us ; All EF programs; helpCenter
     */
    @FindBy(css = ".ue-mbm a")
    public List< WebElement> footerLinksListWe;

    @FindBy(css = ".ue-mbm a[href='/customerservice/contactus/inschool']")
    public WebElement emailUsWe;

    @FindBy(css = ".ue-mbm a[href='http://www.ef.com']")
    public WebElement allEfProgramWe;

    @FindBy(css = ".ue-mbm a[href='/customerservice/helpcenter']")
    public WebElement helpCenterWe;

    @FindBy(className = "ue-back-totop-content")
    public WebElement backToTopWe;

    @FindBy(className = "ue-language-button")
    public WebElement changeLanguageWe;

    @FindBy(css = changeLanguageListCss)
    public List<WebElement> languageListWe;  //[ 0=en 1=pt 2=sp 3=es 4=fr 5=ge 6=it 7=ko 8=ja 9=hk 10=ch 11=cs 12=th 12=ru 14=tr 15=in 16=ar]

    //Copyright ©
    @FindBy(className = "ue-copyright")
    public WebElement copyrightWe;


    public void clickOnEmailUs(){
        click(emailUsWe);
    }

    public void clickOnAllEfPrograms(){
        click(allEfProgramWe);
    }

    public void clickOnHelpCenter(){
        click(helpCenterWe);
    }

    public void clickOnBackToTop(){
        click(backToTopWe);
    }

    /**
     * User must click to expand the language selection window
     * 2 letter language code ISO
     * @param languageCodeToBeSelected
     *
     */
    public void selectLanguage(String languageCodeToBeSelected){
        logger.info("Try to selectLanguage [{}]", languageCodeToBeSelected);

        boolean clickedToSelect = false;
        String langCode = null;

        for(WebElement langWe: languageListWe){
            // get we language code from "data-code"
            langCode = TestUtil.getAttributeValue(getWebDriver(), langWe, "data-code");
            if(StringUtils.equalsIgnoreCase(langCode, languageCodeToBeSelected)){
                logger.info("Found it langCode["+langCode+"] matches languageCodeToBeSelected["+languageCodeToBeSelected+"], will click on it");
                click(langWe);
                clickedToSelect = true;
                logger.info("Clicked to select language ....!");
            }
        }

        if(!clickedToSelect)
            failTest("Could not Find or Select the language requested [{"+languageCodeToBeSelected+"}]");
    }

    public String getSelectedLanguage() {
        String lang = "-1";
        lang = TestUtil.getWebElementText(changeLanguageWe);
        logger.info("changeLanguageWe text is [{}] ", lang);
        return lang;
    }
    /**
     * select it by index try to use the above helper selectLanguage(en)
     * @param index
     */
    public void selectLanguage(int index){
        click(changeLanguageWe);
        sleep(1000);
        WaitTool.waitForListElementsDisplayed(getWebDriver(), By.cssSelector(changeLanguageListCss), WaitTool.MED_WAIT_4_ELEMENT25);
        click(languageListWe.get(index));
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main Navigation and Course element displayed ...!");
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),changeLanguageWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        AssertHelper.assertWebElementDisplayed(changeLanguageWe);
        return true;
    }

    public void assertCopyrightText(){
        logger.info("assertCopyrightText ...!");
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected Copyright text ...! ["+copyrightTxt+"]",
                TestUtil.getWebElementText(copyrightWe), containsIgnoringCase(copyrightTxt), true);
    }
    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents [logo, menus and icons]...!");
        checkAllPageComponentsDisplayed(emailUsWe, allEfProgramWe, helpCenterWe, backToTopWe, changeLanguageWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),changeLanguageWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        return ExpectedConditions.visibilityOf(changeLanguageWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public SchoolFooterPage(WebDriver webDriver){
        super(webDriver);
    }
    public SchoolFooterPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public SchoolFooterPage(WebDriver webDriver, int pageLoadTime) {
        super(webDriver, pageLoadTime);
    }
    public SchoolFooterPage() {
        this(null, null);
    }
}
