package com.englishtown.tests.flow.core;
/**
 * Created by nikol.marku on 29/10/2015.
 * All flows extends this
 * All flow helpers defined in BaseSpecificFlow
 * If helpers are shared betwing flows then add those helpers in here
 *
 */
//ITUpsellTest  test12345et1458665623019@qp1.org
import com.englishtown.tests.core.BaseTestHelper;


public abstract class BaseFlow extends BaseTestHelper {

    public String upsellDirectUrl ;
    public String thankyouMessageWeCss; // once user submit a form a message is shown .. inline or on new page ... use this to get the text
    public String thankYouMsgContains;
    public boolean isInlineTyMsg;       // true if TY msg shown on same page .. new design
}
