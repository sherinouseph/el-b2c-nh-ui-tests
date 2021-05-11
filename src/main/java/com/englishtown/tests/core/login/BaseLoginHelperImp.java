package com.englishtown.tests.core.login;
/**
 * Login helper methods ONLY
 *
 */
import com.englishtown.pages.landing.OSLandingPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseLoginHelperImp extends BaseLoginHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseLoginHelperImp.class);

    protected String url ;


    @Override
    protected OSLandingPage createPage() {
        return null;
    }


}
