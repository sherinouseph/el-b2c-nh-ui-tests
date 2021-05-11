package com.englishtown.tests.core;
/**
 * This is pagetest without the tests *
 * Date: 04/09/14    *  *
 */
import com.englishtown.pages.core.Page;
import com.galenframework.reports.model.PageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BasePageTest<TPage extends Page> extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(PageTest.class);

    private TPage page;

    protected abstract TPage createPage();

    public TPage getPage() {
        if (this.page == null) {
            this.page = this.createPage();
        }
        return this.page;
    }



}