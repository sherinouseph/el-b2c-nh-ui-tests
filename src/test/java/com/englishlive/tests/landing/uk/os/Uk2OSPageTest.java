package com.englishlive.tests.landing.uk.os;
/**
 *
 */
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.UniqueDataObject;
import com.englishtown.tests.core.landingpages.BaseLPtoPayment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Uk2OSPageTest extends BaseLPtoPayment {
    private static final Logger logger = LoggerFactory.getLogger(Uk2OSPageTest.class);
    @Value("#{applicationPropertiesList['uk.default.form2.os']}")
    private String osPageUrl;
    @Value("#{applicationPropertiesList['test.telephone.uk']}")
    private String localizedTestPhoneNumber;



    @BeforeClass
    protected void setupOpenUrlBeforeClass(){
        //isNewhousePayment = true;
        formLeadTypeValue = "os";
        formDataMap = EfConstants.defaultDataMapNoConfirmPassnewhouse; //defaultDataMapNoConfirmPass;
        formDataMap.replace("email", new UniqueDataObject().getEmail());
        FULL_NAME = formDataMap.get("firstname")+ " " + formDataMap.get("lastname");
        formTypeValue = "member";
        submitBtn = ".formset-button button";
        setThreadSafeDriver();
        openUrl(getWebDriver(), osPageUrl);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }

}


