package com.englishlive.tests.cq.component.core;
/**
 *
 *
 * https://jira-bos.englishtown.com/browse/SAND-3256
 *
 */
import com.englishtown.tests.core.BaseTestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseComponent extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseComponent.class);

    //pp IT page selectors
    // FAQs
    public static final String FAQS_QUESTION_LIST    = ".faq ul li .caption p";        // can not get the arrow
    public static final String FAQS_DESCRIPTION_LIST = ".faq ul li .desc";
    public static final int FAQS_TEST_ID = 2 ;                                // this is the component being tested .... the third in the list

    // PP Board grid component   $('.boards .board').size()   . quote  .BY
    public static final String BOARDS_LIST       = ".boards .board";
    public static final String BOARDS_ARROW_LIST = ".board-pane .arrow";

    // how it works
    //// tabs
    public static final String TAB       = ".tabs";
    public static final String TAB_ITEMS = TAB+" .tab-item";
    public static final String ACTIVE_TAB_ITEM = TAB_ITEMS+".active";


}
