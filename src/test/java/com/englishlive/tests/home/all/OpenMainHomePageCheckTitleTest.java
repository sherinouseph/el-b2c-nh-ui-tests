package com.englishlive.tests.home.all;

/**
 * https://jira-bos.englishtown.com/browse/SAND-3838
 * Open homepage and check page name/title
 *
 */

import com.englishtown.dataprovider.MainMarketsHomeUrlsDataProvider;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.tests.core.SimpleBaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;


public class OpenMainHomePageCheckTitleTest extends SimpleBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(OpenMainHomePageCheckTitleTest.class);


    @Test(dataProvider = "mainMarketHomePagesAndPageNames", dataProviderClass = MainMarketsHomeUrlsDataProvider.class)//, threadPoolSize = 3, invocationCount = 1, timeOut = 55000)
    public void checkPageTileStateObject(String pageName, String url){
        try {
            createLocalThreadDriver(MyBrowserType.CHROME, 20);

            openUrl(getLocalThreadDriver(), getBASE_URL() + url);
            sleep(1000);

            String stateObjPageName = getStateObjectPageName(getLocalThreadDriver(), 20);

            AssertHelper.assertThat("State object Page name is not the expected one ....!", stateObjPageName, equalToIgnoringWhiteSpace(pageName));
        }finally{
            destroyLocalThreadDriver();
        }
    }

}



/**
 *
 public void checkPageTileStateObject(String pageName, String url){
 String stateObjPageName = "";
 String pageTitle        = "";
 try {
 createLocalThreadDriver(MyBrowserType.CHROME, 20);

 openUrl(getLocalThreadDriver(), getBASE_URL() + url);
 sleep(1000);

 getStateObjectPageName();


 try{
 pageTitle = getLocalThreadDriver().getTitle();
 }catch (WebDriverException e){
 pageTitle = "JS could not get page name";
 logger.error("Could not get browser page title ....!");
 }
 logger.info("WebDriver Page title ["+pageTitle+"]");

 try{
 stateObjPageName = JavaScriptHelper.executeAsyncScript(JavaScriptHelper.STATE_OBJECT_PAGE_NAME, getLocalThreadDriver(), 20);
 logger.info("js stateObject Page Name ["+stateObjPageName+"]");                                                                         //stateObjPageName= getStateObjectKeyValue(getLocalThreadDriver(), STATEOBJECT_PAGENAME_KEY, true); //"SalesPages:Home"
 }catch (Exception e){
 stateObjPageName = "JS could not get page name";
 logger.error("Could not get state object page name ....!");
 }
 logger.info("State object Page Name [\""+stateObjPageName+"\"");
 AssertHelper.assertThat("State object Page name is not the expected one ....!", stateObjPageName, equalToIgnoringWhiteSpace(pageName));
 }finally{
 destroyLocalThreadDriver();
 }
 }
 *
 *
 $ cat homepage.txt | grep "Page title is"
  - Page title is ["Cours d'Anglais avec EF English Live | Englishtown"
  - Page title is ["Corso di Inglese Online | EF English Live | Englishtown"
  - Page title is ["EF English Live Indonesia | Belajar Inggris Online"
  - Page title is ["Englisch lernen online - EF English Live - Englishtown"
  - Page title is ["Learn English Online | EF English Live | Englishtown"
  - Page title is ["Cursos de Inglés en Línea con EF English Live"
  - Page title is ["English Learning Online | EF English Live | Englishtown"
  - Page title is ["EF English Live | Englishtown - Online İngilizce öğrenmek"
  - Page title is ["Учить английский онлайн | EF English Live"
  - Page title is ["Aprender inglés online con EF English Live España"
  - Page title is ["全球線上英文學習家教 | EF English Live | Englishtown"
  - Page title is ["EF English Live | Englishtown | เรียนภาษาอังกฤษออนไลน์"
  - Page title is ["EF English Live Indonesia | Belajar Inggris Online"
  - Page title is ["EF English Live Korea (EF 잉글리시 라이브) | Englishtown"
  - Page title is ["オンライン英会話のEFイングリッシュライブ｜EF English Live"
  - Page title is ["تعلم اللغة الانجليزية مع إنجليش لايف|EF Englishtown|EF English Live"
  - Page title is ["Curso de inglês online é na English Live (antiga Englishtown)"
  - Page title is ["Learn English Online | EF English Live | Englishtown"
  - Page title is ["تعلم اللغة الانجليزية مع إنجليش لايف | EF English Live | Englishtown"
  - Page title is ["Apprendre l'anglais rapidement - EF EnglishLive | Englishtown"
  - Page title is ["Englisch Lernen Online - EF English Live | Englishtown"

   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"
   - State object Page Name is ["SalesPages:Home"

 *
 */

