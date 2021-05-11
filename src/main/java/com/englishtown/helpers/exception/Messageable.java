package com.englishtown.helpers.exception;

/**
 * All error messages setup in here
 *
 */
public interface Messageable {
    //clarification  WE = WebElement
    String MSG_WE_NOT_VISIBLE         = "WebElement is not Visible ...!" ;
    String MSG_WE_NOT_PRESENT         = "WebElement is not Present ...!" ;
    String MSG_WE_NOT_CLICKABLE       = "WebElement is not Clickable ...!";
    String MSG_WE_NOT_ENABLED         = "WebElement is not Enabled ...! ";
    String MSG_WE_NOT_IN_VIEW         = "WebElement is not In View ...! ";
    String MSG_WE_NULL                = "WebElement is NULL (not initialized) ...! ";

    //failure MSG
    String MSG_TEST_FAILED            = "Test FAILED ...!";
    String MSG_CUSTOM                 = "CUSTOM MESSAGE : ";
    String MSG_EXCEPTION              = "\n\tException ...! :>";

    // condition
    String MSG_WAIT_FOR_CONDITION     = "Wait for Element Condition ...!";





}
