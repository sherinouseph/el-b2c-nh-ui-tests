package com.englishlive.tests.landing.form.rola.baserolaforms;
/**
 *
 * Open URL and check default home phone value
 *
 */
import com.englishtown.dataprovider.RolaDataProvider;
import com.englishtown.dataprovider.bin.CountryBean;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseOpenUrlCheckDefaulHomePhoneValues extends BaseRolaFormValidation implements IRolaForm {
    private static final Logger logger = LoggerFactory.getLogger(BaseOpenUrlCheckDefaulHomePhoneValues.class);
    protected static String urlContains = "notInit";
    private String currentTestUrl;

    @Test(dataProvider = "rolaTopCountrieBean", dataProviderClass = RolaDataProvider.class)
    protected void openUrlSelectHome_Check_HomePhoneMask(CountryBean countryBean) {
        List<Error> errorList = new ArrayList();

        try {
            setThreadSafeDriver();
            logger.info("Test Country Bean : " + countryBean.toString());
            currentTestUrl = testStartUrl + "?ctr=" + countryBean.getTwoLetterCode();
            openUrl(getWebDriver(), currentTestUrl, -1);
            sleep(1000);

            logger.info("Check Default phone Mobile selected ...!");
            try {
                select(By.cssSelector(PHONE_TYPE_SELECT_CSS), null, "1");
                sleep(1000);
                checkSelectElementValue(PHONE_TYPE_VALUE_HOME, By.cssSelector(PHONE_TYPE_SELECT_CSS));
            } catch (AssertionError ae) {
                errorList.add(ae);
            }
            // Latam Req 7 Input mask for phone No. default values
            logger.info("Check Default Home Phone mask is the expected one [{}]...!", countryBean.getDefaultHomePhoneMask());
            try {
                if (!StringUtils.equals("na", countryBean.getDefaultHomePhoneMask())) {
                    clickOnPhoneTextFieldAndValidateDefaultValue(countryBean.getDefaultHomePhoneMask());
                } else logger.info("default Home phone value is [{}] ", countryBean.getDefaultHomePhoneMask(),
                        " Default phone mask is not checked ...!");
            } catch (AssertionError ae) {
                errorList.add(ae);
            }
        } finally {
            String longline  = "\n------------------------------------------------------------------";
            String shortline = "\n-------------------------------------";
            destroyDriver();
            String errorMessageList = longline ;
            if (errorList.isEmpty()) {
                logger.info("NO errors on error list ...!");
            } else {
                for (Error err : errorList) {
                    errorMessageList = errorMessageList+"\n\n"+err.getMessage()+shortline;         //logger.error(err.getMessage());
                }
                throw new AssertionError("There are errors on this run ; Number of errors >["+errorList.size()+"]\n"+errorMessageList);
            }
        }

    }


}
