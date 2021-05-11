package com.englishlive.tests.landing.form.rola.baserolaforms;
/**
 * Open form and check there is no department on the form
 *
 */
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCheckDepartmentIsNotShown extends BaseTestHelper  implements IRolaForm{
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckDepartmentIsNotShown.class);

    @Test
    protected void validateDepartmentNotShownOnTheForm() {
        validateWebElementNotShown(By.id(DEPT_SELECT), FAIL_MSG_DEPT_SHOULD_NOT_SHOW, 7);
    }

}
