package com.englishlive.tests.crm.core;
/**
 * Created by nikol.marku on 25-May-17.
 *  https://jira.eflabs.io/browse/SAND-3943
 *
 */

import com.englishtown.enumpack.CrmTestType;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.ISharedConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseCrmMagicForm extends BaseTestHelper implements ISharedConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(BaseCrmMagicForm.class);

    protected String crmMagicFormNewUser = "englishlive.ef.com/en-gb/lp/os/crm-lp-2017/";
    protected String crmMagicFormExistingUser = crmMagicFormNewUser + "?crmmb=1";
    protected String waitForFormElementCss = "input[name=firstname]";
    protected String waitForPayPageCss = "input[name=CreditCardNumber]";
    protected String tyMessage = "Grazie per";
    protected LoginPage loginPage;
    protected String schoolWaitForWeCss = ".ue-avatar";
    protected String crmLoginBtnCss = ".formset--login button"; //"#-rsrc--content--englishtown--gb--en--lp--os--crm-lp-2017--jcr__content--main-parsys--illustrator_522058298--form-panel--panel-login--button";
    protected String thankYouTxtWeCss = ".message b";   // submit form
    protected String tyMessageWeCss = ".message";
    protected String submitWeCss = "input[name=firstname]";
    protected String forgottenPassWeCss  = ".forgotten-your-passowrd p";
    protected String forgottenPass1WeCss = ".forgotten-password"; // it use this
    protected String forgotPassThankYouTxtWe = ".message-panel .message p";
    protected String forgotPassTyMessage = "been sent to the email address"; // "sent you an email";
    protected String giveMyPassBackBtnCss = ".formset--forgot-password .btn-primary"; //"#-rsrc--content--englishtown--gb--en--lp--os--crm-lp-2017--jcr__content--main-parsys--illustrator_522058298--form-panel--panel-forgot-password--button";

    protected String payPageUrlContains     = "payment";        // new user submit form
    protected String welcomeBackUrlContains = "buy/"; //"back/member/";   // when user logs in

    protected String welcomeBackSubmitBtnCss = ".btn.btn-primary";
    protected CrmTestType crmTestType;  // oe or os
    protected String waitForUrlContains = "lp/ty";

    // forgotten pass
    protected String forgottenpassEmailOrUsernameCss = "input[name=EmailOrUserName]";

}