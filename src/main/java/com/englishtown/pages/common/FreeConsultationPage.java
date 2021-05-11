package com.englishtown.pages.common;
/**
 * Created by nikol.marku on 12/29/2016.
 * http://englishlive.ef.com/en-us/free-consultation/
 *
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.MyBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;


public class FreeConsultationPage extends MyBasePage {
    public static final Logger logger = LoggerFactory.getLogger(FreeConsultationPage.class);
    public String relativePageUrl = "free-consultation/";

    public static final String  illustratorConstraint = "section.illustrator > .constraint";

    public Dimension illustratorDimemsion;
    public Dimension formDimemsion;
    /**
     * Main components
     */
    @FindBy(css = ".formset .btn-primary")
    public WebElement submitFormBtn;

    @FindBy(id = "first_name")
    public WebElement firstNameWe;


    @FindBy(css = illustratorConstraint)
    public WebElement illustratorSection;

    @FindBy(css = illustratorConstraint+" .formset")
    public WebElement formSection;


    public FreeConsultationPage(WebDriver webDriver){
        super(webDriver);
    }
    public FreeConsultationPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public FreeConsultationPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(firstNameWe);
        AssertHelper.assertWebElementDisplayed(submitFormBtn);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(submitFormBtn);
    }

    public Dimension getDimension(WebElement getDimWe){
        Dimension weDimension = null;
        try{
            weDimension = getDimWe.getSize();
        }catch (Exception e){
            failTest(e, "\nCan not get WE dimensions ....!");
        }
        return weDimension;
    }

    public void setupDimension(){
        illustratorDimemsion = getDimension(illustratorSection);
        formDimemsion        = getDimension(formSection);
        logger.info("Dimemsion >>> illustratorDimemsion ["+illustratorDimemsion.toString()+"] ; formDimemsion ["+formDimemsion.toString()+"]");
    }

    public void isFormInsideIllustratorSection(){
        //logger.info("illustratorDimemsion ["+illustratorDimemsion.toString()+"] ; formDimemsion ["+formDimemsion.toString()+";");
        if(illustratorDimemsion.getHeight() >= formDimemsion.getHeight() & illustratorDimemsion.getWidth() >= formDimemsion.getWidth()  ){
            logger.info("Form is inside illustrator ...!");
        }else{
            logger.error("Form is NOT Inside illustrator ...!");
        }
        AssertHelper.assertThat("Form Height is not inside illustrator section ....!",illustratorDimemsion.getHeight(), greaterThanOrEqualTo(formDimemsion.getHeight()) );
        AssertHelper.assertThat("Form Width  is not inside illustrator section ....!",illustratorDimemsion.getWidth(), greaterThanOrEqualTo(formDimemsion.getWidth()) );
        logger.info("..................");
    }


}
