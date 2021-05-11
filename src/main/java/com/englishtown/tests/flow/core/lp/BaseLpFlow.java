package com.englishtown.tests.flow.core.lp;
/**
 * Created by nikol.marku on 29/10/2015.
 * All flows of this type [lp] extends this
 * All flow helpers defined in BaseSpecificFlow
 *
 *
 */

import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.flow.core.BaseFlow;

import java.util.Map;


public abstract class BaseLpFlow extends BaseFlow {

    protected Map lpFormData ;
    protected String submitBtnCss ;
    protected String creditCardLinkText_DE = "Kreditkarte";
    protected String stoEtagKey   = "session.etag";
    protected String stoPtnKey    = "session.partner_code";
    protected String stoEtagValue = "goes";
    protected String stoPtnValue  = "Mkge";
    protected String urlContains  = "thankyou";

}
