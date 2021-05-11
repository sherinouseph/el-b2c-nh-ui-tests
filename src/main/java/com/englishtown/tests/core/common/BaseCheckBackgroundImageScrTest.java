package com.englishtown.tests.core.common;
/**
 * https://jira.eflabs.io/browse/SAND-4054
 * check image src is the correct one
 ?ctr=sa = two phone numbers at top, guy in background image
 ?ctr=om = one phone number at top, guy in background image
 ?ctr=eg = one phone number at top, female background image

 * for ctr=eg image src=https://et2.ef-cdn.com/dam/englishtown/new-website-2016/meast-consolidation-image.jpg?v=AVx+TGv+
 * for ctr=sa image src=https://et2.ef-cdn.com/dam/englishtown/new-website-2016/meast-hero-1920x450.jpg?v=AVulbqHK
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.text.IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace;

public class BaseCheckBackgroundImageScrTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckBackgroundImageScrTest.class);
    // test set this up if needed
    protected String bgImageCss = ".backgrounds img";
    protected String imageSrc ;
    protected String expectedImageSrc;


    @Test
    void checkBackgroundImageSourceIsTheExpectedOne(){
        WebElement bgImageWe = findElement(By.cssSelector(bgImageCss));

        imageSrc = getAttributeValue(bgImageWe, "src");
        logger.info("Image src is [{}]", imageSrc);

        if(null == imageSrc)
            failTest("Image Source value is null ...! for selector :"+ imageSrc);
         // AssertHelper.assertThat("Image Source file is not the expected one ...!", imageSrc, equalToIgnoringWhiteSpace(expectedImageSrc));
           AssertHelper.assertThat("Image Source file is not the expected one ...!", imageSrc, containsString(expectedImageSrc));
           logger.info(expectedImageSrc+" is present in "+imageSrc);
    }


}
