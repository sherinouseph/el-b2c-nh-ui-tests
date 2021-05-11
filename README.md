# EnglishLive

## QA automation scripts for B2C site.

###### Author : Nikol Marku   nikol.marku@ef.com


**Testing Framework**:
 
    1. Java       
    2. Webdriver   [ Drives the browser automation ]
    3. TestNG      [ Testing Framework, test runner]
    4. Maven       [ Building framework and running tests, profiles{setup test to run} ] 
    5. Galen       [ UI testing ]
    7. RestAssured [ API testing ]
    


Test run using selenium grid running on default port 4444
Test can run on local grid or Teamcity grid [10.162.85.203:4444/grid/console]
TeamCity run test on teamcity grid without extra configuration in [BaseRemoteWebDriver.setHubUrl();]

Test can run on parallel or single threaded. Default threadCount is 1; to override this -DthreadCount=noOfThreads
  Number of threads depend on grid settings and nodes available for test.

**Test can run on different Browsers** :

     1.  Chrome - default browser
     2.  IE
     3.  Firefox
     4.  Htmlunit,
     5.  Chrome emulators [ios and android]
     6.  PhantomJS
     7.  Safari

     They are configured on WebDriverFactory.getBrowser()


pom.xml selenium version configuration is set using > seleniumhq.version.latest


**To run the test**

1. download source code
2. Setup selenium grid
   a. download Selenium Server [3.x is the current supported version]
       http://selenium-release.storage.googleapis.com/index.html?path=3.x/
   b. download drivers [chrome, IE, edge]  https://sites.google.com/a/chromium.org/chromedriver/
   c. place Selenium server jar in:>  C:\selenium\grid
   d. place Drivers in:>              C:\selenium\grid\exe

       OR copy files from \Englishtown - London\qa\2017\NikolPC-Grid\grid to C:\selenium\grid

3. To upgrade Selenium Server you need to change the version on pom.xml file and download the Selenium Server jar
   to grid folder and update the version file in C:\selenium\grid\version.txt file

4. To run test from local pc to Teamcity Grid set runFromLocalToTC=true in BaseRemoteWebDriver.setHubUrl()

5. To run the test from IDE just click run on test package or Test Class; Default browser is chrome.

6. To run test from command line use :
      > mvn -DbaseReportDir=$ReportDirName test    -> this will run all test on chrome default browser
                                                      and store the reports in $ReportDirName
      OR
      > mvn -DbaseReportDir=testReports -Dtest="**/landinghandler/**" -DthreadCount=5 -Dbrowser=chrome test


**RestAssured Framework**:

Restassured is used for the api testing.
Test should configure the request specification and response specification.
1. Request spec should contain all data needed for the api call
2. Response spec should contain all the tests to verify the response is valid as well as store the data to be used by other tests
