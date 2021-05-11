package com.englishtown.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * Created by nikol.marku on 9/2/2016.
 */
public class HomePageDataProvider {


    @DataProvider(name = "allMarketHomePageUrls", parallel = true)
    public static Object[][] allMarketHomePageUrlsData() {
        return new Object[][] {
                {   1, "http://englishlive.ef.com/fr-wws/?ctr=pf" } ,
                {   2, "http://englishlive.ef.com/en-wws/?ctr=lc" } ,
                {   3, "http://englishlive.ef.com/ar-wws/?ctr=sa" } ,
                {   4, "https://englishlive.ef.com/de-wws/?ctr=at" } ,
                {   5, "https://englishlive.ef.com/es-us/" } ,
                {   6, "http://englishlive.ef.com/en-us/" } ,
              /*  {   7, "http://englishlive.ef.com/zh-tw/" } ,
                {   8, "http://englishlive.ef.com/tr-tr/" } ,
                {   9, "http://englishlive.ef.com/th-th/" } ,
                {  10, "https://englishlive.ef.com/en-se/" } ,
                {  11, "http://englishlive.ef.com/ar-sa/" } ,
                {  12, "http://englishlive.ef.com/ru-ru/" } ,
                {  13, "http://englishlive.ef.com/es-pe/" } ,
                {  14, "http://englishlive.ef.com/es-mx/" } ,
                {  15, "http://englishlive.ef.com/ko-kr/" } ,
                {  16, "http://englishlive.ef.com/ja-jp/" } ,
                {  17, "http://englishlive.ef.com/it-it/" } ,
                {  18, "http://englishlive.ef.com/id-id/" } ,
                {  19, "http://englishlive.ef.com/en-gb/" } ,
                {  20, "http://englishlive.ef.com/fr-fr/" } ,
                {  21, "http://englishlive.ef.com/es-es/" } ,
                {  22, "http://englishlive.ef.com/de-de/" } ,
                {  23, "http://englishlive.ef.com/es-co/" } ,
                {  25, "http://englishlive.ef.com/es-ar/" },
                {  24, "http://www.englishtown.com.br/" }*/

        };
    }

}
