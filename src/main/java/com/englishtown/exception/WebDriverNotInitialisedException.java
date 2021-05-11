package com.englishtown.exception;

import org.openqa.selenium.WebDriverException;

/**
 * Created by nikol.marku on 14-Jun-17.
 */
public class WebDriverNotInitialisedException extends WebDriverException{

    private static final String ERR_MESSAGE = "Web Driver is Not initialized ...! " +
            "Need to call setThreadSafeDriver() before using the driver ....!";

    public WebDriverNotInitialisedException(String message){
        super(message);
    }
    public WebDriverNotInitialisedException(){
        super(ERR_MESSAGE);
    }
}
