//package com.englishtown.tests.home.all;
///**
//* Run the rest of the test for home page using test data imput
//* User: nikol.marku
//* Date: 14/08/14
//*/
//
//import com.englishtown.pages.common.HomePage;
//import com.englishtown.tests.responsivecore.HomePageTest;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.Assert;
//import org.testng.annotations.SmokeDataProvider;
//import org.testng.annotations.Test;
//
//
//public class HomePageAllMarketTest extends HomePageTest {
//   // @Value("#{applicationPropertiesList['home.en.ru.url']}")
//    private String pageUrl;
//
//    @SmokeDataProvider(name = "urls")
//    public Object[][] createData1() {
//        return new Object[][] {
//                { "http://www.englishtown.com/ar-sa/", "" },
//                { "http://www.englishtown.com/en-sa/",""},
//                { "http://www.englishtown.co.jp/ja-jp/", "" },
//                { "http://www.englishtown.com/en-gb/",""},
//                { "http://www.englishtown.com/es-co/", "" },
//                { "http://www.englishtown.com/en-co/",""},
//
//        };
//    }
//
//    @Override
//    protected HomePage createPage() {
//        return new HomePage(getWebDriver(), this.pageUrl);
//    }
//
//
//    @Test(dataProvider = "urls")
//    public void ensurePageIsValidForTheUrl(String url, String secondParam) throws Exception{
//        this.pageUrl = url;
//        createPage(); //new HomePage(getWebDriver(), this.pageUrl) ;
//        Thread.sleep(3000);
//        Assert.assertTrue(this.getPage().isAtExpectedPage(), "Page is not at expected location.");
//        Thread.sleep(3000);
//    }
//}
