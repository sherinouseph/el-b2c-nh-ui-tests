package com.englishtown.helpers.utils;
/**
 * Date: 08/08/14
 * Test utilities and statics  e.g take screen shot
 *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.MyRemoteWebDriver;
import com.englishtown.helpers.*;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.util.db.testdbbean.PerformanceTimingBean;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.server.SystemClock;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

//import org.openqa.selenium.support.ui.SystemClock;

//import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class TestUtil {
    private static final Logger logger = LoggerFactory.getLogger(TestUtil.class);
    public static final String SCREENSHOT_DIRECTORY = "./target/surefire-reports/screenshot/";
    public static final String SCREENSHOT_DIRECTORY_MAILED_IMAGES = "./target/surefire-reports/screenshot/mail/";
    public static final String FAIL_SCREENSHOT_DIRECTORY = SCREENSHOT_DIRECTORY + "failure/";
    public static final boolean isLogScreen = true;
    public static final boolean isLogScreenOnError = true;
    public static final boolean isLogSourceCode = false;
    public static final boolean isAShot = true; // use AShot to take full screenshot on chrome
    // FILES TO STORE DATA
    public static final String LIVE_USER_LIST = "live_Users.log";
    public static final String QA_USER_LIST = "qa_Users.log";
    public static final String STAGING_USER_LIST = "staging_Users.log";
    public static final String UAT_USER_LIST = "uat_Users.log";
    public static final String RESOURCE_PATH = "testusers\\";
    public static String usersFileLocation;
    public static Path userFilePath;
    public static final String[] INPUT_TYPE = {"text", "email", "password", "textarea"};
    // test
    public static final boolean ENTER_DATA_TEST = true;
    public static float pageLoadTime = -1;
    public static boolean isOpenURLException = true; // used by url MONITOR stats
    public static boolean isMonitorTest = false; // use this to create stats object for page load time
    public static String jsPerformanceTiming;
    public static PerformanceTimingBean performanceTimingBean;

    //
    private static final String CC_NO_LIVE = "4222222222222222";
    private static final String CC_NO_QA   = "4111111111111111";


    public static final String memberSpinnerCss = ".container-fluid .spinner";
    public static final String SPLIT_SELECT_OPTION_ON = "&";
    public static final String EXE_DRIVER_FILE_PATH = "C:\\selenium\\grid\\exe\\";
    /*******************************************************************************************************************
     * Take screen shot
     * usage:  TestUtil.takeScreenshot("testName", this.webDriver, true);
     * RemoteWebDriver does not implement the TakesScreenshot class
     * if the driver does have the Capabilities to take a screenshot
     * then Augmenter will add the TakesScreenshot methods to the instance
     * ***
     *
     * @param isFailure -> if true then store screenshot to the failure folder
     */
    public synchronized void takeScreenshot(String fileName, WebDriver driver, boolean isFailure) {
        logger.info("Taking Screenshot ... filename [{}]", fileName);
        String storeScreenshotDir;

        if (isFailure) {
            if (System.getProperty("baseReportDir") == null) {
                storeScreenshotDir = FAIL_SCREENSHOT_DIRECTORY;
            } else {
                storeScreenshotDir = System.getProperty("baseReportDir") + "screenshot/failure/";   // was screenshot\failure\
            }
        } else {
            storeScreenshotDir = SCREENSHOT_DIRECTORY;
        }
        logger.info("storeScreenshotDir set to [{}]", storeScreenshotDir);
        try {
            createDirectory(storeScreenshotDir);
            if (BaseRemoteWebDriver.isBrowser("chrome") && isAShot) {
                getScreenShotUsingAShot(driver, storeScreenshotDir + generateRandomFilename(fileName) + ".png");
            } else {
                WebDriver augmentedDriver = new Augmenter().augment(driver);
                File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(storeScreenshotDir + generateRandomFilename(fileName) + ".png"));
            }
//            WebDriver augmentedDriver = new Augmenter().augment(driver);
//            File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
//            createDirectory(storeScreenshotDir) ;
//            FileUtils.copyFile(screenshot, new File(storeScreenshotDir +generateRandomFilename(fileName) + ".png"));
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("IOException Failed to take screenshot! " + TestUtil.getException(e));
        } catch (NoSuchSessionException e) {
            logger.error("Exception  createDirectory FAILED ! " + TestUtil.getException(e)); //e.getCause().toString());
        } catch (WebDriverException e) {
            e.printStackTrace();
            logger.error("Exception  createDirectory FAILED .. parallel ..! " , e.getCause()); //+ TestUtil.getExceptionFirstLine(e)); //e.getCause().toString());
        }

    }

    /**
     * taking screenshot and place it on a specific location on *\qa\target\surefire-reports\screenshot\*
     */
    public void takeScreenshot(WebDriver driver, String baseDirectory, String folder, String fileName) {
        logger.info("Taking Screenshot ...!");
        String storeScreenshotDir = baseDirectory + folder + "/";
        logger.info("storeScreenshotDir is :" + storeScreenshotDir);

        createDirectory(storeScreenshotDir);

        try {
            if (BaseRemoteWebDriver.isBrowser("chrome") && isAShot) {
                getScreenShotUsingAShot(driver, storeScreenshotDir + generateRandomFilename(fileName) + ".png");
            } else {
                WebDriver augmentedDriver = new Augmenter().augment(driver);
                File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(storeScreenshotDir + generateRandomFilename(fileName) + ".png"));
            }
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("IOException Failed to take screenshot! " + TestUtil.getException(e));
        } catch (NoSuchSessionException e) {
            logger.error("Exception  createDirectory FAILED ! " + TestUtil.getException(e)); //e.getCause().toString());
        } catch (WebDriverException e) {
            e.printStackTrace();
            logger.error("Exception  createDirectory FAILED ! " +e.getMessage() );//TestUtil.getExceptionFirstLine(e)); //e.getCause().toString());
        }
    }

    /**
     * Take screenshot
     * Return File
     */
    public static File takeScreenshot(WebDriver driver) {
        logger.info("Taking Screenshot ...!");
        File screenshot = null;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);   //OutputType.FILE
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception ...! " + TestUtil.getException(e));
        }
        return screenshot;
    }

    //http://blog.xebia.in/2015/07/05/capture-full-page-screenshot-for-chrome-browser-in-selenium-webdriver/
    public static void getScreenShotUsingAShot(WebDriver driver, String locationAndName) {
        if(null != driver) {
            try {
                String imageUrl = driver.getCurrentUrl();
                logger.info("getScreenShotUsingAShot ....! url [{}]", imageUrl );
                final Screenshot screenshotAshot = new AShot().shootingStrategy(
                        ShootingStrategies.viewportPasting(50)).takeScreenshot(driver);                    //new ViewportPastingStrategy(500)
                BufferedImage image = screenshotAshot.getImage();                                                 //ImageIO.write(image, "PNG", new File("write here path of location to save image" + "AShot_bbc.png")); //storeScreenshotDir +generateRandomFilename("chrome_"+fileName) + ".png"

                image = addTextWatermark(image, imageUrl, Color.RED, 15, 50, 26);
                ImageIO.write(image, "PNG", new File(locationAndName));

            } catch (IOException ioe) {
                ioe.printStackTrace();
                logger.error("Exception ...! " + TestUtil.getException(ioe));
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Exception ...! " + TestUtil.getException(e));
            }
        }else {
            logger.error("Driver is null ... cannot get screen shot ...!");
        }
    }

    /**
     *  Add watermark to an image starting from the bottom
     * @param image
     * @param text
     * @param color
     * @param x
     * @param y
     * @param fontSize
     * @return image
     *  Graphics g = image.getGraphics();
     *  g.setColor(Color.GRAY);
     *  g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
     *  g.drawString(imageUrl, 35, 35);
     */
    public static BufferedImage addTextWatermark(BufferedImage image, String text, Color color, int x, int y, int fontSize){
        Graphics g = image.getGraphics();
        g.setColor(color);                                         //Color.GRAY);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize)); //26));

        int height = image.getHeight() - y; //get to the bottom       //int width = image.getWidth();
        g.drawString(text, x, height );                                  // 35, 35);
        g.dispose();
        return image;
    }

    public static void createDirectory(String dir) {
        boolean isFileCreated = false;
        try {
            File filedir = new File(dir);
            if (!filedir.exists()) {
                isFileCreated = filedir.mkdirs();
                if (isFileCreated) {
                    logger.info(" Directory is created! " + dir);
                } else {
                    logger.info("Failed to create Directory ....! filedir.mkdirs  : " + dir);
                }
            } else {
                logger.info(" Directory not created, it exist ....! " + dir);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error(" createDirectory FAILED ! " + dir);
        }
    }

    /**
     * isNewFolder => create new directory; delete existing one if true
     */
    public static boolean forceCreateDirectory(String dir) {
        boolean isDirCreated = false;
        try {
            File filedir = new File(dir);
            FileUtils.forceMkdir(filedir);
            if (filedir.mkdirs()) {
                isDirCreated = true;
                logger.info(" Directory created ...! " + dir);
            } else {
                logger.info("Failed to create Directory ....! filedir.mkdirs  : " + dir);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            logger.error(" createDirectory FAILED ! " + dir);
        }
        return isDirCreated;
    }

    /**
     * Apache common util
     * @param source
     * @param destination
     */
    public static void copyDir(File source, File destination){
        try{
            FileUtils.copyDirectory(source, destination);
        }catch (IOException e){
            logger.error("Could not copy directory ...!"+e.getMessage());
        }
    }
    /**
     * Files move
     * Move Directory content to from source to destination using Files.move method
     * @param source      - if it does not exist No copy done
     * @param destination - if directory does not exit it will try and create it  "user.dir"+ "/target/surefire-reports/" + (testName_RandomName)
     */
    public static void moveDir(Path source, Path destination ){
        logger.info("Start copy Dir {["+source+"]  ->to-> ["+destination+"]}");
        try{
            //createDirectory(destination.toString());
            if(Files.exists(source, LinkOption.NOFOLLOW_LINKS)){
                Files.move(source, destination);
            }else {
                System.out.println("Sourece Directory Does Not Exist ...!");
            }
        }catch (IOException e){
            e.printStackTrace();
            logger.error("Could not copy directory ...!"+e.getMessage());
        }
    }

    public static String generateRandomFilename(String fName) {
        Calendar c = Calendar.getInstance();
        String filename = fName + "_" + c.get(Calendar.YEAR) +
                "_" + c.get(Calendar.MONTH) +
                "_" + c.get(Calendar.DAY_OF_MONTH) +
                "h" + c.get(Calendar.HOUR_OF_DAY) +
                "_" + c.get(Calendar.MINUTE) +
                "_" + c.get(Calendar.SECOND) +
                "_" + c.get(Calendar.MILLISECOND);
        logger.info("generateRandomFilename is : " + filename);
        return filename;
    }

    public static String generateRandomFilename() {
        Calendar c = Calendar.getInstance();
        String filename = c.get(Calendar.DAY_OF_MONTH) +
                "_" + c.get(Calendar.MONTH) +
                "_" + c.get(Calendar.YEAR) +
                "h" + c.get(Calendar.HOUR_OF_DAY) +
                "_" + c.get(Calendar.MINUTE) +
                "_" + c.get(Calendar.SECOND);
        // "_" + c.get(Calendar.MILLISECOND);
        logger.info("generateRandomFilename is : " + filename);
        return filename;
    }

    public static synchronized String generateRandomFolderName(String fName) {
        Calendar c = Calendar.getInstance();
        String folderName = fName + "_" + c.get(Calendar.YEAR) +
                "_" + c.get(Calendar.MONTH) +
                "d" + c.get(Calendar.DAY_OF_MONTH) +
                "h" + c.get(Calendar.HOUR_OF_DAY) +
                "mi" + c.get(Calendar.MINUTE) +
                "s" + c.get(Calendar.SECOND);
        logger.info("generateRandomFilename is : " + folderName);
        return folderName;
    }

    /**
     * delete directory files and folders
     */
    public static boolean cleanDir(String clearfolder) {
        logger.info("Clean directory : " + clearfolder);
        boolean isClean = false;
        try {
            File folder = new File(clearfolder);
            if (folder.exists()) {
                FileUtils.cleanDirectory(folder);
            }
            isClean = true;
        } catch (IOException e) {
            //logger.error("Failed to clean directory : "+clearfolder);
            BasePage.failTest(e, "Failed to clean directory : " + clearfolder);
        }
        return isClean;
    }

    /**
     * use this for unique token
     *
     * @return
     */
    public static long getSysTime() {
        Long systemLongId = System.currentTimeMillis();
        System.out.println("" + systemLongId);
        systemLongId++;
        logger.info(" getSysTime : " + systemLongId);
        return systemLongId;
    }

    /**
     * Return the current time in "MMM dd,yyyy HH:mm:ss" format.
     */
    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
        return sdf.format(new Date().getTime());
    }

    public static String getYYMMDD() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy, MMM, dd");
        return sdf.format(new Date().getTime());
    }


    public static void logSourceCode(WebDriver webDriver) {
        if (isLogSourceCode) {
            logger.trace("Page source is :\n" + webDriver.getPageSource());
        }
    }

    /**
     *
     * Driver .exe file should be in C:\selenium\grid\exe
     *
     */
    public static String getAbsolutPathToDriverExe(String fileName) {
        String path = EXE_DRIVER_FILE_PATH + fileName;  // = new File("").getAbsolutePath() + fileName;
        logger.info("driverAbsolutPath :" +path);
        return path;
    }

    public static String getDomainFromUrl(String url) {
        //int startIndex = url.indexOf(".englishtown");
        String splitChar = "\\.";
        String[] urlParts = url.split(splitChar);
        String rebuildUrl = ".";

        for (int i = 0; i < urlParts.length; i++) {
            if (i != 0) {
                rebuildUrl = rebuildUrl + urlParts[i] + ".";
            }
        }        //int firstForwardSingSlashIndex = rebuildUrl.length();

        if (rebuildUrl.endsWith("/") || rebuildUrl.endsWith(".")) {
            rebuildUrl = rebuildUrl.substring(0, rebuildUrl.length() - 1);
        }
        if (rebuildUrl.contains("/")) {
            String[] s = rebuildUrl.split("/");
            rebuildUrl = s[0];
        }
        logger.info("getDomainUrl : Domain : " + rebuildUrl);
        return rebuildUrl;
    }

    /*******************************************************************************************************************
     * return user file name based on the environment
     ******************************************************************************************************************/
    public static String getFileName(String environment) {
        switch (environment) {
            case "live":
                return LIVE_USER_LIST;
            case "qa":
                return QA_USER_LIST;
            case "staging":
                return STAGING_USER_LIST;
            case "uat":
                return UAT_USER_LIST;
            //englishlive changes
            case "englishlive":
                return LIVE_USER_LIST;
            case "qa-":
                return QA_USER_LIST;
            case "stg-":
                return STAGING_USER_LIST;
            default:
                logger.error(" Invalid environment : " + environment);
                return null;
        }
    }


    public static boolean isStringInTheList(String cookieName, String[] list) {
        boolean isNameInList = false;
        if (cookieName != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].equals(cookieName)) {
                    isNameInList = true;
                    break;
                }
            }
        }
        return isNameInList;
    }


    ////////////////////////////////

    public static void closeProcessName(String processName) {
        try {
            logger.info("Close Brosers using Autoit .. All browsers window will be cosed : " + processName);
            Runtime.getRuntime().exec("closeIE.exe");  //C:\work\project\qa
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printTime() {
        SystemClock systemClock = new SystemClock();
        Long time = systemClock.now();
        logger.info("System Clock is [{}]", time);
    }

    public static void mySleep(int sleepTimeMiliseconds) {
        SystemClock systemClock = new SystemClock();
        Long startTime = systemClock.now();
        //logger.info("Start sleep for : " + sleepTimeMiliseconds + " milliseconds.   System Clock is :" + startTime);
        try {
            Thread.sleep(sleepTimeMiliseconds);
        } catch (InterruptedException e) {
        }
        Long newTime = systemClock.now();
        Long timeDif = newTime - startTime;
        //logger.info("END sleep, System Clock is :" + newTime + " System clock Difference is :" + timeDif);
        if (timeDif != sleepTimeMiliseconds) {
            //logger.info(" Sleep time difference :" + timeDif + " mls");
        }
    }

    public static void printMethodName(Logger logger) {
        logger.info("\tRun Method : " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    public static void printMethodName(Logger logger, int id) {
        logger.info("\tRunnin Method : " + Thread.currentThread().getStackTrace()[id].getMethodName());
    }
    public static String getRunningMethodName(){
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    /**
     * Exception handling message
     */
    public static String getException(Exception e) {
        return getExceptionFirstLine(e) + "\n" + getEfExceptionLines(e);
    }

    public static String getException(Exception e, WebDriver driver) {
        String currentUrl = "Can't Get URL ...!";
        try {
            currentUrl = getCurrentUrl(driver);
        } catch (WebDriverException we) {
            e.printStackTrace();
            logger.error("Can't Get current URL ...!");
        }
        return "\n\tCurrent URL : " + currentUrl + " \n" + getExceptionFirstLine(e) + "\n" + getEfExceptionLines(e) + "\n";
    }

    /**
     * Return Exception lines     * use 0 as index for first line     * Could return NULL
     */
    public static String getExceptionFirstLine(Exception e) {
        String[] eString = null;
        String myMsg = null;
        if (e != null) {
            eString = e.toString().split("\n");
            if (eString != null) {
                myMsg = eString[0];
            }
        }
        return myMsg;
    }

    public static String getExceptionLines(Exception e, int lineIndex) {
        String myMsg = null;
        StackTraceElement[] ste = e.getStackTrace();

        if (ste != null && lineIndex < ste.length) {
            myMsg = ste[lineIndex].toString();
        }
        return myMsg;
    }

    /**
     * Return lines with matching string e.g com.englishtown
     * NOTE : this will miss fist line of exception stacktrace e.g : java.lang.NullPointerException
     */
    public static String getEfExceptionLines(Exception e) {
        String efMsg = null;
        String searchString = "com.english";    // probably param
        StackTraceElement[] stes = e.getStackTrace();
        StringBuilder efExceptionMsg = new StringBuilder("Customised Exception : \n");
        if (stes != null) {
            for (StackTraceElement ste : stes) {
                if (ste != null && ste.toString().contains(searchString)) {
                    efExceptionMsg.append(ste + "\n");
                }
            }
        }
        if (efExceptionMsg != null) {
            efMsg = efExceptionMsg.toString();
        }
        return efMsg;
    }

    /**
     *
     */
    public static void assertUrlChanged(WebDriver driver, String prevUrl, int waitTimeSec) {
        myAssertThat(driver, " URL has NOT changed; Failed ...!",
                waitForUrlNotEqual(driver, prevUrl, waitTimeSec), true);
    }

    public static boolean waitForUrlNotEqual(WebDriver driver, String prevUrl, int waitSeconds) {
        logger.info("waitForUrlNotEqual ....:" + prevUrl);
        Boolean isContainSting = false;
        String currentUrl = "";
        do {
            waitSeconds--;
            try {
                currentUrl = driver.getCurrentUrl().toLowerCase();
                if (!currentUrl.equals(prevUrl)) {
                    isContainSting = true;
                    break;
                }
            } catch (WebDriverException e) {
                if (waitSeconds < 1) {
                    logger.info("waitForUrlNotEqual ....URL :`" + currentUrl + "` is equal :" + prevUrl);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e1) {
            }
        } while (waitSeconds > 0);

        logger.info("currentUrl is           ....[{}]", currentUrl);
        logger.info("should Not be equal to  ....[{}]", prevUrl);
        return isContainSting;
    }

    /*******************************************************************************************************************
     * get url from browser, return url or " Can't get URL ...!"
     */
    public static String getCurrentUrl(WebDriver driver) {
        String failMsg = "Can't get browser URL ...!";
        String currUrl = failMsg;
        if (driver == null) {
            currUrl = currUrl + " Driver is NULL ...!";
            logger.error(currUrl);
            return currUrl;
        } else {
            try {
                currUrl = driver.getCurrentUrl();
            } catch (Exception e) {
                logger.error(failMsg);
                return currUrl;
            }
        }
        return currUrl;
    }


    public static void openNewBrowserWindowAndFocusOnIt(WebDriver driver, String url) {
        try {
            if (driver != null) {
                String parentWindow = driver.getWindowHandle();

                JavascriptExecutor jscript = (JavascriptExecutor) driver;
                jscript.executeScript("window.open()");

                Set<String> availableWindows = driver.getWindowHandles();
                String newWindow = null;
                driver.manage().deleteAllCookies();

                driver.switchTo().window(parentWindow);
                driver.close();
                try {
                    Thread.sleep(1000);
                } catch (Exception e1) {
                }

                logger.info("Parent Browser closed...!!!!!");


                for (String window : availableWindows) {
                    if (!parentWindow.equals(window)) {
                        newWindow = window;
                        logger.info(" focus on new WINDOWS  ...!" + newWindow);
                        driver.switchTo().window(newWindow);
                        driver.get(url);
                    }
                }

            } else {
                logger.info("browser is null so can not be quited, closed ....!!!!!");
            }
        } catch (WebDriverException wde) {
            logger.error("openNewBrowserWindowAndFocusOnIt  WebDriverException " + TestUtil.getException(wde));
            wde.printStackTrace();
        }

    }

    /**
     * Use type to identify
     *
     * @param driver
     * @param formFields
     */
    public static void enterFormData(WebDriver driver, Map formFields) {
        logger.info("enterFormData ...!");
        if(null == formFields && MapUtils.isEmpty(formFields))
            BaseTest.failTest("Enter form data map is null or empty ...!");
        Iterator it = formFields.entrySet().iterator();
        String curWebKey = null;
        String curWebValue = null;
        WebElement currWebElement = null;
        int inputCount = 0;
        boolean isCheckBoxClick = false;
        boolean isRadioElementClick = false;
        boolean isSelectElementSelect = false;
        String selectOptionValue = "3";
        String selectOptionId = null;                    // use this if select by value does not work, use select by index
        String elementType = null;                    // use this to set the type of element
        int count = 0; // while loop count

        while (it.hasNext()) {
            count++;
            Map.Entry pairs = (Map.Entry) it.next();
            curWebKey = pairs.getKey().toString();
            curWebValue = pairs.getValue().toString();
            logger.info(" curWebKey is : '" + curWebKey + "' Value is '" + curWebValue + "' Count : " + count);
            firstTimeAroundAction(driver, count, curWebKey);
            //secondTimeAroundAction(driver, count, 1);

            currWebElement = WaitTool.findElementDontFailTest(driver, By.name(curWebKey));

            // if element not found restart
            if (currWebElement == null) {
                logger.error("currWebElement is null ...!");
            } else {
                //**************** start new
                elementType = getElementType(currWebElement);
                logger.info("getWebElementType  --> elementType is '" + elementType + "'");

                if (StringUtils.isNotBlank(elementType)) {
                    switch (elementType) {
                        case "text":
                        case "email":
                        case "password":
                        case "tel":
                        case "textarea":
                            logger.info("Is input elementType [text, email, password, textarea].");
                            inputCount++;
                            actionOnInputElement(driver, currWebElement, inputCount, curWebKey, curWebValue);
                            break;
                        case "checkbox":
                            logger.info("Is CHECKBOX elementType.");
                            isCheckBoxClick = isCheckBoxSelected(curWebValue);
                            actionOnCheckbox(driver, isCheckBoxClick, curWebKey);
                            break;
                        case "radio":
                            logger.info("Is RADIOBUTTON elementType.");
                            isRadioElementClick = isRadioWeSelected(curWebValue);
                            actionOnRadioElement(driver, isRadioElementClick, curWebKey);
                            break;
                        case "select":
                        case "select-one":
                            logger.info("Is SELECT elementType.");
                            selectOptionValue = curWebValue.split(SPLIT_SELECT_OPTION_ON)[2]; // "_"
                            logger.info("selectOptionValue is [{}] ", selectOptionValue);
                            selectOptionId = setSelectOptionId(curWebValue);
                            isSelectElementSelect = isSelectElementSelected(curWebValue);
                            actionOnSelectElement(driver, isSelectElementSelect, selectOptionId, selectOptionValue, By.name(curWebKey));
                            logger.info("Element Selected ...!");
                            mySleep(1000);
                            break;
                        case "other":
                            logger.info("Is OTHER elementType.");
                            break;
                        default:
                            logger.warn("WebElement type NOT Specified ...! :" + elementType);
                    }
                } else {
                    logger.error("elementType is null ...! Move to next element/action ...! ");
                }
            }
        }//end while
    }//end method

    // USE CSS form map form fields USE and composite web element to type on form when there are 2 forms same css and not unique form fields
    public static void enterFormDataCss(WebDriver driver,  Map formFields) {
        logger.info("enterFormData ...!");
        Iterator it = formFields.entrySet().iterator();
        String curWebKey = null;
        String curWebValue = null;
        WebElement currWebElement = null;
        int inputCount = 0;
        boolean isCheckBoxClick = false;
        boolean isRadioElementClick = false;
        boolean isSelectElementSelect = false;
        String selectOptionValue = "3";
        String selectOptionId = null;                    // use this if select by value does not work, use select by index
        String elementType = null;                    // use this to set the type of element
        int count = 0; // while loop count

        while (it.hasNext()) {
            count++;
            Map.Entry pairs = (Map.Entry) it.next();
            curWebKey = pairs.getKey().toString();
            curWebValue = pairs.getValue().toString();
            logger.info(" curWebKey is : '" + curWebKey + "' Value is '" + curWebValue + "' Count : " + count);
            //firstTimeAroundAction(driver, count, curWebKey);            //secondTimeAroundAction(driver, count, 1);
            currWebElement = WaitTool.findElement(driver, By.cssSelector(curWebKey) );

            // if element not found restart
            if (currWebElement == null) {
                logger.error("currWebElement is null ...!");
            } else {
                //**************** start new
                elementType = getElementType(currWebElement);
                logger.info("getWebElementType  --> elementType is '" + elementType + "'");

                if (StringUtils.isNotBlank(elementType)) {
                    switch (elementType) {
                        case "text":
                        case "email":
                        case "password":
                        case "tel":
                        case "textarea":
                            logger.info("Is input elementType [text, email, password, textarea].");
                            inputCount++;
                            actionOnInputElement(driver, currWebElement, inputCount, curWebKey, curWebValue);
                            break;
                        case "checkbox":
                            logger.info("Is CHECKBOX elementType.");
                            isCheckBoxClick = isCheckBoxSelected(curWebValue);
                            WebElementHelper.click(currWebElement);   //      actionOnCheckbox(driver, isCheckBoxClick, curWebKey);
                            break;
                        case "radio":
                            logger.info("Is RADIOBUTTON elementType.");
                            isRadioElementClick = isRadioWeSelected(curWebValue);
                            WebElementHelper.click(currWebElement);  //actionOnRadioElement(driver, isRadioElementClick, curWebKey);
                            break;
                        case "select":
                        case "select-one":
                            logger.info("Is SELECT elementType.");
                            selectOptionValue = curWebValue.split(SPLIT_SELECT_OPTION_ON)[2]; // "_"
                            logger.info("selectOptionValue is [{}] ", selectOptionValue);
                            selectOptionId = setSelectOptionId(curWebValue);
                            isSelectElementSelect = isSelectElementSelected(curWebValue);
                            actionOnSelectElement(driver, isSelectElementSelect, selectOptionId, selectOptionValue, By.cssSelector(curWebKey));
                            logger.info("Element Selected ...!");
                            mySleep(1000);
                            break;
                        case "other":
                            logger.info("Is OTHER elementType.");
                            break;
                        default:
                            logger.warn("WebElement type NOT Specified ...! :" + elementType);
                    }
                } else {
                    logger.error("elementType is null ...! Move to next element/action ...! ");
                }
            }
        }//end while
    }//end method

    /******************************************************************************************************************
     * firstTimeAroundAction is executed for the first element of the form ONLY
     */
    public static void firstTimeAroundAction(WebDriver driver, int count, String curWebKey) {
        if (count == 1) {        // first time around
            logger.info("isFistTimeAround ...waitForElementCondition(visibilityOf) " + curWebKey);
            try {
                JavaScriptHelper.javaScriptWindowFocus(driver);
            } catch (WebDriverException e) {
                logger.error("jsWindowFocus throws exception ...! :" + TestUtil.getExceptionFirstLine(e));
            }
            try {
                WaitTool.waitForElementVisible(driver, By.name(curWebKey), WaitTool.MED_WAIT_4_ELEMENT, 1000);
                WaitTool.waitForElementClickable(driver, By.name(curWebKey), WaitTool.SHORT_WAIT_4_ELEMENT, 1000);
                WebElementHelper.scrollToElementLocation(driver, WaitTool.findElement(driver, By.name(curWebKey)), 0, 100);
            } catch (Exception e) {
                logger.error("waitForElementVisible , scrollToElementLocation -> exception ...! :" + TestUtil.getExceptionFirstLine(e));
            }
        }
    }

    public static void secondTimeAroundAction(WebDriver driver, int count, int waitTime) {
        if (count == 2) {
            // removed to make test faster WaitTool.resetImplicitWait(driver, waitTime);
        }
    }

    public static boolean isCheckBoxSelected(String curWebValue) {
        if (curWebValue.endsWith("true")) {
            return true;
        }
        return false;
    }

    public static String setSelectOptionId(String curWebValue) {
        if (curWebValue.split(SPLIT_SELECT_OPTION_ON).length == 4) {
            return curWebValue.split(SPLIT_SELECT_OPTION_ON)[3];
        }
        return null;
    }

    public static boolean isSelectElementSelected(String curWebValue) {
        if (curWebValue.split(SPLIT_SELECT_OPTION_ON)[1].contains("true")) {
            return true;
        }
        return false;
    }

    public static boolean isRadioWeSelected(String curWebValue) {
        if (curWebValue.endsWith("true")) {
            return true;
        }
        return false;
    }

    public static void actionOnCheckbox(WebDriver driver, boolean isCheckBoxClick, String curWebKey) {
        if (isCheckBoxClick) {
            try {
                WebElement we = driver.findElement(By.name(curWebKey));
                if (BaseRemoteWebDriver.currentDeviceName != null && "NexusOne".contains(BaseRemoteWebDriver.currentDeviceName)) {
                    logger.info("Is nexus device -  , move an click then click ...!");
                    JavaScriptHelper.scrollToXY(driver, 0, 50);
                    MyWebDriverAction.actionClick(driver, we);
                } else {
                    we.click();
                }
                ///* fix for mac
                if(we.isSelected())
                    logger.info("Checkbox selected ...!");
                else{
                    logger.info("Checkbox Not selected ; try to click again...!");                    //
                    //recheck
                    //if(StringUtils.containsIgnoreCase(getBrowserName(driver), "safari")) {
                        mySleep(1000);
                        MyWebDriverAction.actionClick(driver, we);//we.click();
                        logger.info("Click again ...!");
                    //}
                }
            } catch (WebDriverException e) {
                logger.error("enterFormData()-actionOnCheckbox Exception : " + TestUtil.getException(e, driver));
            }
        } else
            logger.info("Checkbox not clicked ...!");
    }

    public static void actionOnRadioElement(WebDriver driver, boolean isRadioElementClick, String curWebKey) {
        if (isRadioElementClick) {
            try {
                driver.findElement(By.name(curWebKey)).click();
            } catch (Exception e) {
                logger.error("enterFormData()-actionOnRadioElement Exception : " + TestUtil.getException(e, driver));
            }
        }
    }

    public static void actionOnSelectElement(WebDriver driver, boolean isSelectElementSelect, String selectOptionId,
                                             String selectOptionValue, By by) {
        if (isSelectElementSelect) {
            try {
                WebElement webElement = driver.findElement(by);
                Select select = new Select(webElement);
                if (selectOptionId != null) {
                    select.selectByIndex(Integer.parseInt(selectOptionId));
                } else {
                    // select second option on the list
                    String selectOption = getWebElementText(select.getOptions().get(1));

                    if(!BaseRemoteWebDriver.browserVersion.isEmpty() && "10" == BaseRemoteWebDriver.browserVersion){
                        WebElementHelper.selectOptinUsingDownArrowKey(webElement, BaseTest.PRESS_NO, Keys.ARROW_DOWN);
                        mySleep(100);
                    }
                    else if (BaseRemoteWebDriver.isBrowser("safari")) {                                          //select.selectByVisibleText(selectOption);       //webElement.click();//WebElementHelper.selectOptinUsingDownArrowKey(webElement, BaseTest.PRESS_NO, Keys.ARROW_DOWN);
                        webElement.sendKeys(selectOption);
                        mySleep(100);                                                                 //JavaScriptHelper.highlightElement(webElement, driver);  //JavaScriptHelper.executeBlurOnWebelement(driver, webElement);      //webElement.sendKeys(Keys.TAB);                                                                        //webElement.sendKeys(Keys.ARROW_DOWN);    /*} else if(BaseRemoteWebDriver.isBrowser("safari")){               select.selectByIndex(3); select.selectByVisibleText(selectOption);*/
                    }
                    else {
                        select.selectByValue(selectOptionValue);
                        mySleep(100);
                    }
                }
            } catch (Exception e) {
                logger.error("enterFormData()-actionOnSelectElement Exception : " + TestUtil.getException(e, driver));
            }
        }
    }

    public static void actionOnInputElement(WebDriver driver, WebElement currWebElement, int inputCount,
                                            String curWebKey, String curWebValue) {
        try {  // Is first time so need to focus on element
            if (inputCount == 1) {
                mySleep(500);
                currWebElement.click();
                WebElementHelper.focusOnElementUsingSendKeyOrAction(currWebElement, driver);
            }
            currWebElement.clear();
            logger.info("Cleared text field ...!");
            // IE9 issue - it clears text value after typing it .... logger.info("BaseRemoteWebDriver.getCurrentBrowserName() :" + BaseRemoteWebDriver.getCurrentBrowserName());
            /*if (curWebKey.contains("telephon")) {
                if (BaseRemoteWebDriver.getCurrentBrowserName().contains("explor") || BaseRemoteWebDriver.getCurrentBrowserName().contains("safari")) {
                    logger.info("Browser is safari or IE .. need to clear it .. to handle the issue with text not being populated");
                    currWebElement.clear();
                }
            }*/
            currWebElement.sendKeys(curWebValue);
            logger.info("Typed ... [{}] ", curWebValue);
            currWebElement.sendKeys(Keys.TAB);
            logger.info("Send TAB key ");
        } catch (Exception e) {
            logger.error("enterFormData()-isInputElement- Exception - " + TestUtil.getException(e, driver));
        }
    }

    //******************************************************************************************************************
    //----------------------------------------------------------------------
//    public static  WebElementType getWebElementType(WebDriver driver, WebElement webElement){
//        String elementType = getElementType(webElement); // type of WE or null
//        logger.info(" Element type is : "+elementType);
//
//        if(StringUtils.isNotBlank(elementType)) {
//            switch (elementType) {
//                case "text":
//                    System.out.println("Is input elementType.");
//                    return WebElementType.INPUT;
//                case "checkbox":
//                    System.out.println("Is CHECKBOX elementType.");
//                    return WebElementType.CHECKBOX;
//                case "radio":
//                    System.out.println("Is RADIOBUTTON elementType.");
//                    return WebElementType.RADIOBUTTON;
//                case "select":
//                    System.out.println("Is SELECT elementType.");
//                    return WebElementType.SELECT;
//                case "textarea":
//                    System.out.println("Is TEXTAREA elementType.");
//                    return WebElementType.TEXTAREA;
//                case "other":
//                    System.out.println("Is OTHER elementType.");
//                    return WebElementType.OTHER;
//                default:
//                    System.out.println("Not an WebElement type ...! :"+elementType);
//            }
//        }
//        return null;
//    }

    /**
     * Get element type using getAttribute or getTagName methods
     */
    public static String getElementType(WebElement webElement) {
        String elementType = null;
        try {
            elementType = webElement.getAttribute("type");
            //logger.info("elementType getAttribute is :'"+elementType+"'");
        } catch (Exception e) {
            logger.error("getElementType getAttribute : type : Exception ");
        }
        if (StringUtils.isNotBlank(elementType)) {
            // do nothing as element has attribute type
        } else {   // get element tag to identify it
            //logger.info("elementType getTagName ...!");
            elementType = webElement.getTagName();
            //logger.info("elementType getTagName is :'"+elementType+"'");
        }
        return elementType;
    }

    /*******************************************************************************************************************
     * Return true if full match[isAllMatch=true] or at least one match if [isAllMatch=false]
     ******************************************************************************************************************/
    public static boolean isValueInMap(Map offer, boolean isAllMatch, String... containsValues) {
        boolean isMatch = false;
        int matchCount = 0;
        int failCount = 0;

        for (Object value : containsValues) {
            if (offer.containsValue(value)) {
                isMatch = true;
                matchCount++;
            } else {
                isMatch = false;
                failCount++;
            }
        }
        if (isAllMatch) {
            if (failCount == 0) {
                return true;
            } else return false;
        } else {
            if (matchCount > 0) {
                return true;
            } else return false;
        }
    }

    /*******************************************************************************************************************
     * Open url,
     * if @timeout is less than 1 use default timeout and - NO timeout is changed
     * if timeOut is more than 1 then set pageload timeout to that value and reset it back at the end
     * GET will wait till the whole page gets loaded i.e. the onload event has fired before returning control to our test or script. -
     * NO history back forward
     ******************************************************************************************************************/
    public static void openUrl(WebDriver driver, String url, int timeOut) {
        logger.info("openUrl : " + url);
        long pageLoadDurationMilliSeconds = 0;
        boolean isDefaultPageLoadChanged = false;
        pageLoadTime = -1; // to ensure the value is updated when called on a loop
        isOpenURLException = true;

        if (timeOut < 1) {
            timeOut = WaitTool.DEFAULT_PAGELOAD_TIMEOUT;
        } else {
            isDefaultPageLoadChanged = true;
            WaitTool.setPageLoadTimeOut(driver, timeOut);
        }
        try {
            long startTime = System.currentTimeMillis();
            driver.get(url);
            long endTime = System.currentTimeMillis();
            pageLoadDurationMilliSeconds = (endTime - startTime);
            pageLoadTime = pageLoadDurationMilliSeconds / 1000F;  // TODO add more params performance.timing.domComplete
            logger.info("Loaded page [{}] in {} seconds", url, pageLoadTime);   //(pageLoadDurationMilliSeconds / 1000F));
            //jsPerformanceTiming = BaseTest.executeJSscript("var t = performance.timing; return t", driver, 3);
            //logger.info("...JS performance timing " +jsPerformanceTiming);
            isOpenURLException = false;
        } catch (TimeoutException toe) {
            isOpenURLException = true;
            toe.printStackTrace();
            BasePage.failTest(toe, " _PAGELOAD_TIMEOUT :[" + timeOut + "] "+" URL :"+url);
        } catch (NullPointerException e) {
            isOpenURLException = true;
            BasePage.failTest(e, "  NullPointerException  " + TestUtil.getException(e, driver)+" URL :"+url);
        } catch (WebDriverException e) {
            isOpenURLException = true;
            BasePage.failTest(e, " WebDriverException " + TestUtil.getException(e, driver)+" URL :"+url);
        } finally {
            if (isDefaultPageLoadChanged)
                WaitTool.setPageLoadTimeOut(driver, WaitTool.DEFAULT_PAGELOAD_TIMEOUT);
        }
    }

    public static void openUrl(WebDriver driver, String url) {
       //logger.info("openUrl : " + url);
        long pageLoadDurationMilliSeconds = 0;
        pageLoadTime = -1;
        isOpenURLException = true;

        try {
            long startTime = System.currentTimeMillis();
            driver.get(url);
            long endTime = System.currentTimeMillis();
            pageLoadDurationMilliSeconds = (endTime - startTime);
            pageLoadTime = pageLoadDurationMilliSeconds / 1000F;
            logger.info("Loaded page [{}] in {} seconds", url, (pageLoadDurationMilliSeconds / 1000F));

            if (isMonitorTest) {
                jsPerformanceTiming = BaseTest.executeJSscript("var t = performance.timing; return t", driver, 3);
                logger.info("JS performance timing " + jsPerformanceTiming);
                // int stats object
                performanceTimingBean = PerformanceTimingBean.getTimingBean(jsPerformanceTiming);
            }
            isOpenURLException = false;
        } catch (TimeoutException toe) {
            isOpenURLException = true;
            BasePage.failTest(toe, " _PAGELOAD_TIMEOUT ...! Waited" + WaitTool.DEFAULT_PAGELOAD_TIMEOUT + " seconds");
        } catch (NullPointerException e) {
            isOpenURLException = true;
            BasePage.failTest(e, "  NullPointerException  " + TestUtil.getException(e, driver));
        } catch (WebDriverException e) {
            isOpenURLException = true;
            e.printStackTrace();
            BasePage.failTest(e, " WebDriverException ...trying to open url\n" + e.getMessage());
        }
    }

    /**
     * Use navigate to : NAVIGATE will just redirect to our required page and will not wait
     * @param driver
     * @param url
     */
    public static void getPageLoadTimings(WebDriver driver, String url) {
        logger.info("Page Load Timings ... open Url : " + url);
        long pageLoadDurationMilliSeconds = 0;
        pageLoadTime = -1;
        isOpenURLException = true;

        try {
            long startTime = System.currentTimeMillis();
            //driver.get(url); //
            driver.navigate().to(url);
            //JavaScriptHelper.waitForPageLoaded(driver, 35);         // todo ... in javascript   WaitTool.waitForConditionSpinner( ExpectedConditions.invisibilityOfElementLocated(   By.cssSelector(memberSpinnerCss)),driver ,15);
                                                                    // logger.info("waitForConditionStartTime :" +WaitTool.waitForConditionStartTime);          //  long spinnerWayTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();              // logger.info("spinnerWayTime = ["+spinnerWayTime+"]");        //    long waitForSpinnerTime = spinnerWayTime - WaitTool.waitForConditionStartTime;        //    logger.info("waitForSpinnerTime [spinnerWayTime-waitForConditionStartTime] seconds :" +waitForSpinnerTime/1000);
            pageLoadDurationMilliSeconds = (endTime - startTime);
            pageLoadTime = pageLoadDurationMilliSeconds / 1000F;
            logger.info("Loaded page [{}] in {} seconds", url, (pageLoadDurationMilliSeconds / 1000F));
            mySleep(1000);
            jsPerformanceTiming = BaseTest.executeJSscript("var t = performance.timing; return t", driver, 3);
            logger.info("JS performance timing " + jsPerformanceTiming);
            performanceTimingBean = PerformanceTimingBean.getTimingBean(jsPerformanceTiming);
            performanceTimingBean.setupCalculatedValues();            //performanceTimingBean.setSpinnerGoesWayTime(spinnerWayTime);
            logger.info("DomInteractive : " + performanceTimingBean.getTimeToDomInteractive());
            logger.info("TimeToDomComplete : " + performanceTimingBean.getTimeToDomComplete());
            logger.info(performanceTimingBean.toString());
            isOpenURLException = false;
        } catch (TimeoutException toe) {
            isOpenURLException = true;
            BasePage.failTest(toe, " _PAGELOAD_TIMEOUT ...! Waited" + WaitTool.DEFAULT_PAGELOAD_TIMEOUT + " seconds");
        } catch (NullPointerException e) {
            isOpenURLException = true;
            BasePage.failTest(e, "  NullPointerException  " + TestUtil.getException(e, driver));
        } catch (WebDriverException e) {
            isOpenURLException = true;
            e.printStackTrace();
            BasePage.failTest(e, " WebDriverException Waited" + WaitTool.DEFAULT_PAGELOAD_TIMEOUT + " seconds \n" + TestUtil.getException(e, driver));
        }
    }

    /**
     * NAVIGATE will just redirect to our required page and will not wait.
     * It will guide us through the history like refresh, back,
     * History is kept
     *
     * @param url
     */
    public static void navigateToUrl(WebDriver driver, String url) {
        logger.info("navigateToUrl : " + url);
        long pageLoadDurationMilliSeconds = 0;
        pageLoadTime = -1;

        try {
            long startTime = System.currentTimeMillis();
            driver.navigate().to(url);
            long endTime = System.currentTimeMillis();
            pageLoadDurationMilliSeconds = (endTime - startTime);
            pageLoadTime = pageLoadDurationMilliSeconds / 1000F;
            logger.info("navigateToUrl Loaded page [{}] in {} seconds", url, (pageLoadDurationMilliSeconds / 1000F));
            logger.info("JS performance timing " + BaseTest.executeJSscript("var t = performance.timing; return t", driver, 3));
        } catch (TimeoutException toe) {
            BasePage.failTest(toe, " _PAGELOAD_TIMEOUT ...! Waited" + WaitTool.DEFAULT_PAGELOAD_TIMEOUT + " seconds");
        } catch (NullPointerException e) {
            BasePage.failTest(e, "  NullPointerException  " + TestUtil.getException(e, driver));
        } catch (WebDriverException e) {
            e.printStackTrace();
            BasePage.failTest(e, " WebDriverException Waited" + WaitTool.DEFAULT_PAGELOAD_TIMEOUT + " seconds \n" + TestUtil.getException(e, driver));
        }
    }

    public static void checkImageIsDisplayed(WebDriver driver, WebElement we) throws Exception {
        String script = "";
        if (BaseRemoteWebDriver.getCurrentBrowserName().contains("ie")) {
            script = "return arguments[0].complete";
        } else {
            script = "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0";
        }
        Boolean imagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(script, we);
        if (!imagePresent) {
            logger.error("Image not displayed.");
            BasePage.failTest("Image not displayed ...!");
        } else {
            logger.info("Image displayed.");
        }
    }

    /**
     * Get the tex of web element
     * OR NULL;
     * If web element is empty it returns "";
     */
    public static String getWebElementText(WebElement webElement) {
        String txt = null;
        try {
            txt = webElement.getText();
            if (StringUtils.isNotBlank(txt)) {
                // return it
            } else {
                txt = webElement.getAttribute("value");
            }
            logger.info(" Web Element text is : " + txt);
            return txt;
        } catch (Exception e) {
            String locator = null;
            //if(webElement != null) locator = WebElementHelper.getElementLocator(webElement);
            BasePage.failTest(e, "Get WebElement Text Failed ...! -> WebElement is not found or [null] ...!");
            return null;
        }
    }
    public static String getWebElementText(WebDriver driver, String webElementCss) {
        String txt = null;
        WebElement webElement = null;

        try {
            webElement = WaitTool.findElement(driver, By.cssSelector(webElementCss));
            txt = webElement.getText();
            if (StringUtils.isNotBlank(txt)) {
                // return it
            } else {
                txt = webElement.getAttribute("value");
            }
            logger.info(" Web Element text is : " + txt);
            return txt;
        } catch (Exception e) {
            String locator = webElementCss;
            BasePage.failTest(e, "Get WebElement Text Failed ...! -> WebElement is not found [null] ...! WebElement :"+locator);

            return null;
        }
    }

    //return string int value or zero
    public static int getIntFromString(String value) {
        int stringIntValue = 0;
        try {
            if (StringUtils.isNotBlank(value)) {
                stringIntValue = Integer.parseInt(value);
            } else {
                logger.info(" Value is null, blank ...! Can not turn it to int.");
            }
        } catch (Exception e) {
            logger.error("getIntFromString exception : " + TestUtil.getException(e));
        }
        return stringIntValue;
    }

    /**
     * Check pageSource containing text
     *
     * @param containingText
     * @return
     */
    public static boolean isPageSourceContainsText(WebDriver driver, String containingText) {
        try {
            if (driver.getPageSource().contains(containingText)) {
                logger.info(containingText + " getPageSource text is on this page ...!");
                return true;
            } else {
                //logger.info(containingText + " getPageSource text is NOT on this page ...!");
                return false;
            }
        } catch (WebDriverException we) {
            logger.error("WebDriverException @pageSourceContains() ...! " + TestUtil.getException(we));
        }
        return false;
    }

    /**
     * Check WebElement list containing text; at least once
     */
    public static boolean webElementContainText(List<WebElement> weList, String containText) {
        int count = 0;
        int isTextCount = 0;
        boolean foundText = false;
        if (weList != null) {
            logger.info(" WE list size is : " + weList.size() + " ; WEB element selector : " + WebElementHelper.getElementLocator(weList.get(0))); // null exp
            for (WebElement we : weList) {
                //logger.info("Count : " + count + "\n" + WebElementHelper.getElementLocator(we) + " Tag is : " + we.getTagName());
                if (we.getText().toLowerCase().contains(containText)) {
                    logger.info("*********************************************************************************************");
                    logger.info("\n" + containText + "; -> TEXT Found on this page ...!; \nElement type :" + TestUtil.getElementType(we) +
                            ";\nElement Text     : " + TestUtil.getWebElementText(we) +
                            // ";\nElement Locator : " + WebElementHelper.getElementLocator(we) +
                            ";\nIs this element visible : " + WaitTool.isElementVisible(we));
                    foundText = true;
                    isTextCount++;
                } else {
                    //logger.info(containText + " text is NOT on this page ...!");
                }
                count++;
            }
            logger.info("*********************************************************************************************");
            logger.info(" Found [ " + isTextCount + " ] WebElement that contains [we.getText()] text :'" + containText + "' Note getText() usage ...!");
        } else {
            logger.error(" WebElemetn is null ...!");
        }
        return foundText;
    }

    /**
     * Check WebElement list containing text; at least once
     */
    public static boolean webElementContainText(List<WebElement> weList, String containText, String currentUrl, String currentURLDescription) {
        int count = 0;
        int isTextCount = 0;
        boolean foundText = false;
        if (!weList.isEmpty() && weList != null) {
            logger.info(" WE list size is : " + weList.size() + " ; WEB element selector : " + WebElementHelper.getElementLocator(weList.get(0))); // null exp
            for (WebElement we : weList) {
                //logger.info("Count : " + count + "\n" + WebElementHelper.getElementLocator(we) + " Tag is : " + we.getTagName());
                if (StringUtils.contains(we.getText().toLowerCase(), containText)) {
                    /*logger.info("*********************************************************************************************");*/
                    foundText = true;
                    logger.error("Found Text ....! ["+containText + "] ...!");
                    isTextCount++;
                    logger.info("\nURL Description: [" + currentURLDescription + "]; \nURL :" + currentUrl +
                            "\n\t'" + containText + "'; -> TEXT Found on this page ...!; \nElement type :" + TestUtil.getElementType(we) +
                            ";\nElement Text     : " + getMatchContentExtraChars(getWebElementText(we),containText, 20, 20)+ // TestUtil.getWebElementText(we) +
                            //";\nElement Locator : " + WebElementHelper.getElementLocator(we) +
                            ";\nIs this element visible : " + WaitTool.isElementVisible(we));
                } else {
                    //logger.info(containText + " text is NOT on this page ...!");
                }
                count++;
            }
            //logger.info("*********************************************************************************************");
            //logger.info(" Found [ " + isTextCount + " ] WebElement that contains [we.getText()] text :'" + containText + "' Note getText() usage ...!");
        } else {
            logger.error(" WebElemetn is null ...!");
        }
        return foundText;
    }
    /**
     * get some text around matching Str
     *
     */
    public static String getMatchContentExtraChars(String str, String searchStr, int noOfCharsBeforeMatch, int noOfCharsAfterMatch){
        String matchContent = "-1";
        int strLength = 0;
        if(null != str) {
            strLength = str.length();
        } else {
            logger.error("Can not match NULL String ["+str+"] ...!");
            return matchContent;
        }
        int searchStrLength = searchStr.length();
        str = str.toLowerCase();
        searchStr = searchStr.toLowerCase();

        if(StringUtils.contains(str, searchStr)){
            int foundStartIndex = StringUtils.indexOf(str, searchStr);
            int foundEndIndex = foundStartIndex + searchStrLength;
            int charsLeftAfterFoundEndStrIndex = strLength - foundEndIndex;
            //safe define how many chars before noOfCharsBeforeMatch
            if(noOfCharsBeforeMatch > foundStartIndex ) {
                noOfCharsBeforeMatch = foundStartIndex;
            }
            // safe define how many chars after noOfCharsAfterMatch
            if(noOfCharsAfterMatch > charsLeftAfterFoundEndStrIndex ) {
                noOfCharsAfterMatch = charsLeftAfterFoundEndStrIndex;
            }
            try{
                int startIndex = foundStartIndex - noOfCharsBeforeMatch;
                int endIndex   = foundEndIndex + noOfCharsAfterMatch;
                matchContent = StringUtils.substring(str, startIndex, endIndex );
                matchContent = matchContent.replaceAll("\\s"," "); // replace empty spaces
            }catch (IndexOutOfBoundsException ie){
                logger.error(ie.getMessage());
            }
        }
        logger.info(" Substring matchContent is ["+matchContent+"]");
        return matchContent;
    }

    /**
     * TODO .. need to refactor this method ... no more englishtown ... so use elive
     * get country from url or return null;
     * use ctr= or lang-country e.g en-it
     * Note: will not get country from http://qa.englishtown.it/en-wws/
     **/
   /* public static String getCountryFromUrl(String url) {
        String country = null;
        //String[] regExp = {"ctr=", "-"};
        String patternLangCtr    = ".*///[a-z]{2}-[a-z]{2}/.*";  // NOTE remove 2 of /// ; of lines used to comment only
    /*    String patternCtrEqual   = ".*ctr=[a-z]{2}.*";       // *?ctr=it/
        String patterDotCtr      = ".*englishtown\\.[a-z]{2}/.*";      // *?englishtown.it/
        String patterDotCOdotCtr = ".*englishtown\\.[a-z]{2}\\.[a-z]{2}/.*";  //englishtown.co.jp
        String [] temp= null;

        try {
            if(url.matches(patterDotCtr)){
                temp = url.split("englishtown\\.");
                country = temp[1].trim().substring(0, 2);
            }else if (url.matches(patterDotCOdotCtr)) {
                temp = url.split("englishtown\\.co\\.");
                country = temp[1].trim().substring(0, 2);
            }else if (url.matches(patternLangCtr)) {
                temp = url.split("/[a-z]{2}-");
                country = temp[1].trim().substring(0, 2);
            } else if (url.matches(patternCtrEqual)) {
                // e.g *?ctr=it*
                temp = url.split("ctr=");
                country = temp[1].trim().substring(0, 2);
            } else {
                country = null;
                logger.warn("Can not get country from URL ...! " + url);
            }
            logger.info("get ctr from url is : "+country);
        }catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            logger.error("getCountryFromUrl error ... : " + TestUtil.getException(e));
        }
        return country;
    }*/

    /**
     * Get country by splitting the URL
     * [get it from /de-de/ if that fails try to get it from ?ctr=]
     * ef.com first
     * @param url
     * @return -1 if country not found
     */
    public static String getCountryFromUrl(String url) {
        String country = "-1";
        try{
            country = url.split("ef.com")[1].split("/")[1].split("-")[1];
        }catch (Exception e){
            logger.error("Can not get Country from url ["+url+"] using 'ef.com split', retuning emptyString ...! "+TestUtil.getExceptionFirstLine(e));
        }
        if(country.equals("-1")){
            logger.info("try to get the country from url using ?ctr=*");
            try{
                country = url.split("ctr=")[1];
                //if not last parameter
                if(country.length() > 3){
                    country = country.split("&")[0];
                }
            }catch (Exception e){
                logger.error("Can not get Country from url ["+url+"] using 'ctr=', retuning emptyString ...! "+TestUtil.getExceptionFirstLine(e));
            }
        }
        logger.info("URL :"+ url+ " - getCountryFromUrl ["+country+"]");
        return country;
    }

    /**
     *  get split part based on index and regex
     * @param arrayStr
     * @param regex   e.g = "-"
     * @param getIndex
     * @return str or -1 if not found and log error
     */
    public static String getSplitPart(String arrayStr, String regex, int getIndex)  {
        try{
            return arrayStr.split(regex)[getIndex];
        }catch (Exception e){
            logger.error("Can not get Language ...! "+ TestUtil.getExceptionFirstLine(e) );
        }
        return "-1";
    }


    /**
     * Get the part of interest in a string
     *
     * @param splitMe             -> string to be split
     * @param splitRegex          -> use this to split the string
     * @param splitPartIndex
     * @param subStringStartIndex -> interested on this part
     * @param subStringEndIndex
     * @return
     */
    public static String safeSplit(String splitMe, String splitRegex, int splitPartIndex, int subStringStartIndex, int subStringEndIndex) {
        String content = null;
        try {
            content = splitMe.split(splitRegex)[splitPartIndex].trim().substring(subStringStartIndex, subStringEndIndex);
            logger.info("getCountryFromUrl using ctr= : " + content);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            logger.warn("SafeSplit ... : " + TestUtil.getException(e));
        }
        return content;
    }

    public static String getCountryAllFromUrl(String url) {
        logger.info("getCountryAllFromUrl ...! : " + url);
        String country = "notInit";
        String tmp = "";
        try {
            if (url.contains("-")) {
                country = url.split("-")[1].trim();
                if (country.contains("/")) {
                    country = country.split("/")[0];
                }
            } else {
                tmp = url.split("/")[2];
                String[] str = tmp.split("\\.");
                int dotSplitSize = str.length;
                tmp = str[str.length - 1];//last part of dot split
                country = tmp;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return country;
    }

    /**
     * Get all tags a and the value e.g all the hrefs values; remove not valid and the urls that contain '/#'
     *
     * @param driver
     * @param bySelector
     * @param attributeName
     *
     * @return
     */
    public static Set<String> getAllUrls(WebDriver driver, By bySelector, String attributeName) {
        logger.info("getAllUrls ...!");
        if (bySelector == null) {
            bySelector = By.tagName("a");
        }
        if (attributeName == null) {
            attributeName = "href";
        }

        Set<String> urls = new HashSet<>(); // no dupes

        List<WebElement> weList = driver.findElements(bySelector);

        logger.info("... 2 after find list of we...!");
        for (WebElement we : weList) {
            String tempUrl = we.getAttribute(attributeName);                    //logger.info("temp url is : "+tempUrl);
            if (StringUtils.isNotBlank(tempUrl)) {
                tempUrl = tempUrl.trim();
                try {        // sanitize remove #;  javascript: tel:    ftp:   mailto:   file:
                    URL url = new URL(tempUrl);
                    url.toURI();
                    url = null;

                    if(StringUtils.contains(tempUrl, "#") || StringUtils.contains(tempUrl, "trustpilot.com") ) {
                        logger.info(" URL:[{}]  containing [#] or [trustpilot.com] ...!", tempUrl);
                        // not needed  //           }else if (tempUrl.startsWith("#") || tempUrl.contains("facebook.com") || tempUrl.contains("twitter.com") || tempUrl.contains("youtube.com") ) {                       // remove not needed URLs
                    } else {
                        //if(StringUtils.contains( tempUrl, "englishlive.ef.com"))
                            urls.add(tempUrl);
                        //else
                            //logger.info(" URL:[{}] is not within [englishlive.ef.com] domain ...!", tempUrl);
                    }
                } catch (URISyntaxException | MalformedURLException e) {
                    logger.info("URISyntaxException | MalformedURLException > BAD URL, try next str ...! -url:" + tempUrl);
                }catch (Exception e){e.printStackTrace();}
            }
        }
        logger.info(urls.toString());

        return urls;
    }



    public static void isAttributeValueEqual(WebDriver driver, By selector, String attribute, String attributeValueShouldBe) {
        String attValue = getAttributeValue(driver, selector, attribute);
        AssertHelper.assertThat("Is NOT expected attribute Value ...!", attValue, equalToIgnoringCase(attributeValueShouldBe));
    }

    public static void isAttributeValueEqual(WebDriver driver, WebElement we, String attribute, String attributeValueShouldBe) {
        String attValue = getAttributeValue(driver, we, attribute);
        AssertHelper.assertThat("Is NOT expected attribute Value ...!", attValue, equalToIgnoringCase(attributeValueShouldBe));
    }

    public static void isAttributeValueContains(WebDriver driver, By selector, String attribute, String attributeValueShouldBe) {
        String attValue = getAttributeValue(driver, selector, attribute);
        AssertHelper.assertThat("Is NOT expected attribute Value ...!", attValue, containsString(attributeValueShouldBe));
    }

    public static void isAttributeValueContains(WebDriver driver, WebElement we, String attribute, String attributeValueShouldBe) {
        String attValue = getAttributeValue(driver, we, attribute);
        AssertHelper.assertThat("Is NOT expected attribute Value ...!", attValue, containsString(attributeValueShouldBe));
    }

    /**
     * .getAttribute("title");
     */
    public static String getAttributeValue(WebDriver driver, By selector, String attribute) {
        String attributeValue = null;
        try {
            WebElement we = WebElementHelper.safeFindElement(driver, selector);
            if (we != null)
                attributeValue = we.getAttribute(attribute);
            else
                return null;
        } catch (Exception e) {
            logger.error("Can not get Attribute value for attribute [" + attribute + "] error : " + e.getMessage());
        }
        return attributeValue;
    }

    public static String getAttributeValue(WebDriver driver, WebElement we, String attribute) {
        String attributeValue = null;
        try {
            if (we != null)
                attributeValue = we.getAttribute(attribute);
            else
                return null;
        } catch (Exception e) {
            logger.error("Can not get Attribute value for attribute [" + attribute + "] error : " + e.getMessage());
        }
        return attributeValue;
    }

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public static synchronized String generateRandomStringNumber(){
        String genStr = "";
        int genInt = 135;
        try {
            genStr = genStr + generateRandomString("", 3);
            genInt = getRandomNumberInRange(2, 999);   //999999999
            genStr = genStr + String.valueOf(genInt);
        }catch (Exception e){
            logger.error("Can not generate random string number ...!"+e.getMessage());
        }
        return genStr;
    }

    public static synchronized String generateRandomStringNumber(int strLength, int numberLength){
        String genStr = "";
        int genInt = 135;
        try {
            genStr = genStr + generateRandomString("", strLength);
            genInt = getRandomNumberInRange(2, 999999999);
            genStr = genStr + String.valueOf(genInt).substring(0, numberLength);
        }catch (Exception e){
            logger.error("Can not generate random string number ...!"+e.getMessage());
        }
        return genStr;
    }


    /**
     * Get part of a string based on starting string and end string
     *  and replace part or returning string
     * @param content
     * @param startStringContent
     * @param endStringContent
     * @return   e.g for landing handler
    Success:true
    RedirectUrl:http://www.englishtown.com/online/pt-thankyou.aspx
    LeadId:38514697
     */
    public static String getStringPart(String content, String startStringContent, String endStringContent,
                              String replaceContent, String replaceContentWith, boolean isSplit) throws NullPointerException{
        String subContent = null;
        try {
            int startIndex = content.indexOf(startStringContent);
            int endRedirectIndex = content.indexOf(endStringContent);
            subContent = content.substring(startIndex, endRedirectIndex);
            subContent = subContent.replace(replaceContent, replaceContentWith);
            if(isSplit) {
                subContent = subContent.split(":")[1].trim();// setup values Success:true   get true part
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("subContent : "+subContent);
        return subContent;
    }


    /**
     * @param content
     * @param startString
     * @param splitChar
     * @param noOfChars
     * @return
     * @throws NullPointerException
     *
     *  e.g Response :  {Result:    {CountryCode:de,DataStore:,Email:auto_1487166909691_xdelx@qp1.org,EmailLanguageCode:ge,ETag:ctiveSubscription:false},Success:true}
     */
    public static String getResponseSuccessStatus(String content, String startString, String splitChar, int noOfChars) throws NullPointerException{
        String subContent = null;
        try {
            int startIndex = content.indexOf(startString);
            subContent = content.substring(startIndex); // should get "Name : value"
            subContent = subContent.split(splitChar)[1];   //getValue
            subContent = subContent.substring(0, noOfChars);

        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("getResponseSuccessStatus is : "+subContent);
        return subContent;
    }

    /**
     * Json s = {"Result":14522603,"Success":true}
     * 1. clean up/remove { and "  -> Result:14522603,Success:true
     * 2. split on "," and check to mach key  --> Result:14522603
     * 3. if match found get content value --> 14522603
     * @param content
     * @return
     * @throws NullPointerException
     */
    public static String getJasonKeyValue(String content, String key ) throws NullPointerException{
        String value = null;
        try {
            // clean up [ ] { } "
            content = content.replace("{", "").replace("}", "").replace("[", "").replace("]","").replace("\"", "");
            String[] parts = content.split(",");
            String[] temp = null;

            for(int i=0; i < parts.length; i++) {
                temp = parts[i].split(":");
                if(StringUtils.equals(temp[0].trim(), key) ){
                    value = temp[1].trim();
                    logger.info("Found match key ["+key+"  value is ["+value+"]");
                    return value;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info(key+" value : "+value);
        return value;
    }


    /**
     * Move Galen reports to a new unique folder in surefire-reports
     * @param testName
     */
    void copyGalenReport(String testName){
        try {
            Long startMoveTime = System.currentTimeMillis();
            logger.info("AfterSuite started copping files ......!"+startMoveTime );

            String baseReportDestinationPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\";
            //String testName  = this.getClass().getName().replace("com.englishlive.tests.galen.test.", "");
            Path source      = Paths.get(System.getProperty("user.dir") + "\\target\\galen-html-reports\\");
            Path destination = Paths.get(baseReportDestinationPath + TestUtil.generateRandomFilename(testName));

            logger.info("Report sourceLocation is "+source);
            logger.info("Report targetLocation is "+destination);

            TestUtil.moveDir(source, destination);

            Long endMoveTime = System.currentTimeMillis();
            Long moveTime = endMoveTime-startMoveTime;
            logger.info("Dir/Files Moved ... Time to complete ["+moveTime+"] milliseconds");
        }catch (Exception e){
            logger.error("Failed to copy Galen Reports ...!"+e.getMessage());
        }
    }


    public static String generateRandomString(String startString, int randomStringLength) {
        Random rand=new Random();
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder res=new StringBuilder(startString);
        for (int i = 0; i < randomStringLength; i++) {
            int randIndex=rand.nextInt(candidateChars.length());
            res.append(candidateChars.charAt(randIndex));
        }
        return res.toString();
    }

    /**
     * Decode String
     * @param decodeStr
     * @param enc
     * @return decoded string or "" empty str
     */
    public static String decode(String decodeStr, String enc){
        String decodedStr = "";
        try{
            decodedStr = URLDecoder.decode(decodeStr, enc); //"utf-8"
        }catch (UnsupportedEncodingException uee){
            logger.error("Can not decode ....!"+uee.getMessage());
        }
        return decodedStr;
    }

    /**
     * Get Time object from string
     * @param strTime : <hh:mm:ss></hh-mm-ss> "11:12:13"
     * @return Time object with hh mm ss set
     * @throws NullPointerException
     */
    public static Time getTime(String strTime) throws NullPointerException{
        String [] timeParts = null;
        Time time = null;

        if(StringUtils.isBlank(strTime))
            return null;

        try{
            if(StringUtils.contains(strTime, ":")){
                timeParts = strTime.split(":");
                if(timeParts.length > 3) {
                    logger.error("strTime contains more than 3 parts and Time only representS hh-mm-ss ...!   ["+strTime+"]");
                    throw new NumberFormatException(" More thant 3 parts for Time representation hh-mm-ss ...! ["+strTime+"]");
                }
                else{
                    int timePartLength = timeParts.length;

                    if(timePartLength == 2){
                        int minutes = Integer.parseInt(timeParts[0].trim());
                        int seconds = Integer.parseInt(timeParts[1].trim());
                        time =  new Time(0, minutes, seconds);
                    }
                    if(timePartLength == 3){
                        int hour    = Integer.parseInt(timeParts[0].trim());
                        int minutes = Integer.parseInt(timeParts[1].trim());
                        int seconds = Integer.parseInt(timeParts[2].trim());
                        time = new Time(hour, minutes, seconds);
                    }
                }
            } else {
                int seconds = Integer.parseInt(strTime.trim());
                time = new Time(0, 0, seconds);
            }
        }catch (NumberFormatException e ){
            logger.error("NumberFormatException :"+e.getMessage());
        }
        logger.info("Time is: "+time);
        return time;
    }

    /**
     * Returns date from a string
     * @param strTime  : "12:12:12"
     * @param format   : "mm:ss"
     */
    public static Date getDate(String strTime, String format) throws NullPointerException{
        DateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(strTime);
            logger.info("Date and Time: " + date);
        } catch (Exception e) {
            logger.error(" Un parsable date: "+e.getMessage());
        }
        return date;
    }

    public static String getBrowserName(WebDriver driver){
        String browserName = "";
        try{
            browserName = ((MyRemoteWebDriver) driver).getCapabilities().getBrowserName();
            // TODO
            // IE String uAgent = (String) ((JavascriptExecutor) browserDriver).executeScript("return navigator.userAgent;");
        }catch (Exception e){
            logger.error(e.getMessage());
            browserName = "chrome";
            logger.warn("Could not set browser name so setting it to default name chrome ....!");
        }
        return browserName;
    }    //http://mashtips.com/get-system-os-browser-version-java-selenium-webdriver/ to get browser name from browser or js



    public static boolean isEnvironment(String currentEnvironment, TestEnvironment testEnvironment){
        //"qa".contains(getENVIRONMENT()
        if(StringUtils.containsIgnoreCase(currentEnvironment, testEnvironment.getEnv()) )
            return true;
        else
            return false;
    }


    public static Map setMapKeyValue(Map updateMap, String key, String value){
        updateMap.replace(key, value);
        return updateMap;
    }

    public static String getMapKeyValue(Map map, String key){
        String value = "";
        if (map.containsKey(key)) {
            value = map.get(key).toString();
            logger.info("Key : " + key +" value :"+ value);
        }
        return value;
    }


    /**
     * get credit card number based on the environment
     * @param testEnvironment
     */
    public static String getTestCardNumberPerEnv(String testEnvironment){
        String currentCardNumber = CC_NO_LIVE;
        logger.info("setCardNumberPerEnv ....!");
        switch (testEnvironment){
            case "live": // live and staging card number set by default
            case "staging":
                break;
            case "qa":
                currentCardNumber = CC_NO_QA;
                break;
            default :
                logger.error("Invalid Environment ... Card number set to live card No ... 42{15}");
        }
        logger.info("Test Card Number set to["+currentCardNumber+"]");
        return currentCardNumber;
    }

    /**
     * Get property value from -D args .. if not return empty ""
     * @param key  -D args key
     * @return key
     */
    public static String getProperty(String key) {
        String keyValue = "";
        logger.info("System.getProperty [{}]", key);

        try{
            keyValue = System.getProperty(key);
        }catch (Exception e){
            logger.error("Return Chrome default browser; Can not get -D args for [{}]", key+"\n"+e.getMessage());
        }

        logger.info("System.getProperty key: [{}] - Value: "+keyValue, key);

        return keyValue;
    }


    public static String reverseString(String reverseMe){
        String tmpStr = reverseMe;
        tmpStr = new StringBuffer(reverseMe).reverse().toString();
        logger.info("Reversed [{}] is now ["+tmpStr+"]", reverseMe);
        return tmpStr;
    }

    public static String reverseEmailAddress(String email){
        if(StringUtils.isBlank(email))
            BaseTest.failTest("Can not reverse email as it null or blank ...!");

        String tmpEmail = email.split("\\@")[0];
        tmpEmail = reverseString(tmpEmail);
        tmpEmail = tmpEmail + "@qp1.org";

        return tmpEmail;
    }

    /**
     * e.g str="nikol22" we need to get only the 22 out
     * @param str
     * @return
     *  //  text.replaceAll("[^0-9.]", "")s tr.replaceAll("[^\\d.]", "");
     */
    public static double getNumberOutOfString(String str){
        logger.info("Try to get the number out of a string [{}]", str);
        Double priceD = -0.00;

        if(StringUtils.isNotBlank(str)){
            str = str.replaceAll("[^\\d.]", "");

            if(StringUtils.isNotBlank(str))
                str = str.trim();
            else
                BaseTest.failTest("There are no numbers on String ["+str+"] ...!");
        }else {
            BaseTest.failTest("Cant get price from webPage null or empty ....! ");
        }

        try{
            priceD = Double.parseDouble(str);
            logger.info("Number we get from string is [{}]", priceD);
        }catch (NumberFormatException e){
            BaseTest.failTest("Cant get price to double ....! "+e.getMessage());
        }
        return priceD;
    }


    /**
     * This method will take a url and if it does not contain '.ef.com/1/' will add /1/ to the url
     * to make new house compliance
     * @param url
     * @return
     */
    public static String convertToNewHouseUrl(String url){
        logger.info("convertToNewHouseUrl URL [{}]", url);
        String newUrl = "";
        String replaceMe = "ef.com/";
        String replaceMeWith = "ef.com/1/";
        if(StringUtils.containsIgnoreCase(url, ".com/1/")){
            logger.info("Url is a new house URL ... contains /1/ .. So no need to convert it ...!");
            newUrl = url;
        }else {
            logger.info("Convert url to the new house ...!");
            try{
                newUrl = url.replace(replaceMe, replaceMeWith);
            }catch (Exception e){
                logger.error("Can't replace url ....!");
                BaseTest.failTest("Cant convert url to new house url ...! "+e.getMessage());
            }
        }
        logger.info("URL now is [{}]", newUrl);
        return newUrl;
    }

    public static boolean validateUrl(String url){
        logger.info("validate Url [{}]", url);
        try {
            new URL(url).toURI();
            return true;
        }catch (URISyntaxException exception) {
            return false;
        }catch (MalformedURLException exception) {
            return false;
        }
    }

    public static synchronized String getUserDir(){
        return getProperty("user.dir");
    }


}
