package com.englishtown.newhouse.school.pages.core;

public interface ISchoolPage {

    /**
     * This test should be used on special test to check all page components
     *  Calls checkAllPageComponentsDisplayed(WebElement... webElements)
     *  and that return AssertHelper.assertComponentsDisplayed(webElements);
     *
     * @return
     */
    boolean checkAllPageComponentsDisplayed() ;

    String getPageUrl();

}
