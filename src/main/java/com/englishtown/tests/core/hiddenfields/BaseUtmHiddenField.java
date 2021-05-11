package com.englishtown.tests.core.hiddenfields;
/**
 * Open URL and check hidden fields  see $oldHiddenFieldIds
 1. Open url e.g http://qa.englishtown.de/lp/os/automation-test-01-stwt/?utm_source=nikolGoogletest&utm_medium=topRightBanner&utm_campaign=NM007&utm_term=seo_service&utm_content=A&adgroup=nikolTestGrouptOS
 2. check hidden fiels:   $('input[name="utm_term"]').val() or $('input[name*="utm_"]')     or $('input[name="adgroup"]')
     id="adgroup" v    alue="nikolTestGrouptOS">
     id="utm_campaign" value="NM007">
     id="utm_content"  value=?"A">?,
     id="utm_medium"   value=?"topRightBanner">?,
     id="utm_source"   value=?"nikolGoogletest">?,
     id="utm_term"     value=?"seo_service">?]
 *
 */
import com.englishtown.tests.core.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseUtmHiddenField extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseUtmHiddenField.class);

    private int valueId = 0;
    protected String[] oldHiddenFieldIds = {"adgroup", "utm_campaign", "utm_content", "utm_medium", "utm_source", "utm_term"};
    protected String[] hiddenFieldValues = {"nikoltestgroupt", "NM007", "A", "topRightBanner", "nikolGoogletest", "seo_service"};

    @Test
    public void is_Expected_AddGroup_ValueTest(){
        valueId=0;
        assertHiddenField(oldHiddenFieldIds[valueId], hiddenFieldValues[valueId].toLowerCase(), 20);
    }
    @Test(dependsOnMethods = "is_Expected_AddGroup_ValueTest")
    public void is_Expected_utmCampaign_ValueTest(){
        valueId=1;
        assertHiddenField(oldHiddenFieldIds[valueId], hiddenFieldValues[valueId].toLowerCase(), 5);
    }
    @Test(dependsOnMethods = "is_Expected_AddGroup_ValueTest")
    public void is_Expected_utmContent_ValueTest(){
        valueId=2;
        assertHiddenField(oldHiddenFieldIds[valueId], hiddenFieldValues[valueId].toLowerCase(), 3);
    }
    @Test(dependsOnMethods = "is_Expected_AddGroup_ValueTest")
    public void is_Expected_utmMedium_ValueTest(){
        valueId=3;
        assertHiddenField(oldHiddenFieldIds[valueId], hiddenFieldValues[valueId].toLowerCase(), 2);
    }
    @Test(dependsOnMethods = "is_Expected_AddGroup_ValueTest")
    public void is_Expected_utmSource_ValueTest(){
        valueId=4;
        assertHiddenField(oldHiddenFieldIds[valueId], hiddenFieldValues[valueId].toLowerCase(), 2);
    }
    @Test(dependsOnMethods = "is_Expected_AddGroup_ValueTest")
    public void is_Expected_utmTerm_ValueTest(){
        valueId=5;
        assertHiddenField(oldHiddenFieldIds[valueId], hiddenFieldValues[valueId], 2);
    }


}




