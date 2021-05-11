package com.englishtown.helpers;
/**
 * All configuration for WaitTool
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class WaitToolConfig {
    private static final Logger log = LoggerFactory.getLogger(WaitToolConfig.class);
    /** Default wait time for an element. seconds. */
    public static final int DEFAULT_WAIT_4_ELEMENT = 15;
    public static final int SHORT_WAIT_4_ELEMENT   = 10;
    public static final int WAIT_5s                = 5;
    public static final int MED_WAIT_4_ELEMENT25   = 25;
    public static final int MED_WAIT_4_ELEMENT     = 35;
    public static final int LONG_WAIT_4_ELEMENT    = 65;
    /** Default wait time for a page to be displayed.  12 seconds. The average webpage load time is 6 seconds in 2012.
     *  "0" will nullify implicitlyWait and speed up a test.   **/
    public static final int DEFAULT_IMPLICIT_WAIT = 15;
    /** webdriver Default poll is 500 mils, this is the time command wait before is reExecuted again on wait/find methods
     *  I would like this to be 1 second   */
    public static final int DEFAULT_POLL_SLEEP = 1000;
    /** JavaScript default timeout     */
    public static final int JS_SCRIPT_DEFAULT_TIMEOUT = 30;
    public static final int JS_SCRIPT_TIMEOUT_45 = 45;
    /** DEFAULT_PAGELOAD_TIMEOUT; Setting this very high as the website is not that responsive    */
    public static final int DEFAULT_PAGELOAD_TIMEOUT = 40;
    public static final int PAGELOAD_TIMEOUT_45 = 45;
    public static final int WAIT_VERYLONG_200SEC = 200;
    public static final int WAIT_VERYLONG_160SEC = 160;



}
