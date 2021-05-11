package com.englishtown.newhouse.school.pages.course.appsandtools;
/**
 * Sherin 21/09/2020
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class AppsAndToolsPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(AppsAndToolsPage.class);
    public static final String pageUrl = "/apps-and-tools/?icid=School.Tools.2015";


    @FindBy(css = "div[class^='title_'] [class^='text_']")
    public WebElement appsAndToolsTitleWe;

    @FindBy(css = "div[class^='section-title'] [class^='inner_']")  ///1/school/test/placementtest/"]
    public List<WebElement> subtitlesWe;

    @FindBy(css = "div[class^='stage_'] [class^='background_']")
    public WebElement backgroundImageWe;

    @FindBy(css = "div[class^='stage_'] [class^='title_']")
    public WebElement imageSectionTitleWe;

    @FindBy(css = "div[class^='stage_'] [class^='desc_']")
    public WebElement imageSectionDescWe;

    @FindBy(css = "div[class^='stage_'] [class^='download-on_'] [class^='inner_']")
    public WebElement imageSectionDownloadTextWe;

    @FindBy(css = "div[class^='stage_'] [class^='download-on_'] a")
    public List<WebElement>  imageSectionDownloadAppLinksWe;

    @FindBy(css = "div[class^='card-category_'] [class^='inner']")
    public List<WebElement>  cardCategoryTextWe;

    @FindBy(css = "div[class^='card-title_'] [class^='inner_']")
    public List<WebElement>  cardTitleWe;

    @FindBy(css = "div[class^='card-description_']")
    public List<WebElement>  cardDescriptionWe;

    @FindBy(css = "[class^='card-holder_'] [class^='download-on'] [class^='text']")
    public List<WebElement>  downloadAppTextWe;

    @FindBy(css = "[class^='card-holder_'] [class^='download-on'] a")
    public List<WebElement>  downloadAppLinksWe;

    @FindBy(css = "[class^='learn-more_'] a")
    public List<WebElement> learnMoreLinksWe;

    @FindBy(css = "[class^='card_'] [class^='thumbnail_'] [class^='image_']")
    public List<WebElement> cardThumbnailImagesWe;



    //--------------------------------------------------------------------------------------

    public AppsAndToolsPage(WebDriver webDriver){
        super(webDriver);
    }


    public AppsAndToolsPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public AppsAndToolsPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public AppsAndToolsPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(imageSectionDescWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),appsAndToolsTitleWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        AssertHelper.assertComponentsDisplayed(appsAndToolsTitleWe );
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed( appsAndToolsTitleWe,backgroundImageWe,imageSectionDescWe,imageSectionTitleWe,imageSectionDownloadTextWe,imageSectionDownloadAppLinksWe.get(0),imageSectionDownloadAppLinksWe.get(1),subtitlesWe.get(0),subtitlesWe.get(1),cardCategoryTextWe.get(0),learnMoreLinksWe.get(0),downloadAppLinksWe.get(0));
        return true;
    }
    public void checkAllAppsDisplayed() {
        logger.info("Check if all the apps are displayed ");
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),cardTitleWe.get(0), WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        AssertHelper.assertElementSizeEqual(getWebDriver(),cardTitleWe,6);
        AssertHelper.assertElementSizeEqual(getWebDriver(),cardCategoryTextWe,6);
        AssertHelper.assertElementSizeEqual(getWebDriver(),cardDescriptionWe,6);
        AssertHelper.assertElementSizeEqual(getWebDriver(),learnMoreLinksWe,4);
        AssertHelper.assertElementSizeEqual(getWebDriver(),downloadAppLinksWe,4);
        AssertHelper.assertElementSizeEqual(getWebDriver(),downloadAppTextWe,2);
        AssertHelper.assertElementSizeEqual(getWebDriver(),cardThumbnailImagesWe,6);


    }
    public void goToFlashCards()
    {
        click(learnMoreLinksWe.get(0));
    }
    public void goToTranslator()
    {
        click(learnMoreLinksWe.get(1));
    }
    public void goToGrammarLab()
    {
        click(learnMoreLinksWe.get(2));
    }
    public void goToAssessmentTest(){
        click(learnMoreLinksWe.get(3));
    }

}
