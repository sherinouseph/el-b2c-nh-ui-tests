package com.englishtown.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * Created by nikol.marku on 12/11/2015.
 */
public class SiteMapDataProvider {

    @DataProvider(name = "siteMapUrlall", parallel = true)
    public static Object[][] siteMapUrlall() {
        return new Object[][] {

                { "it",  "englishlive.ef.com/it-it/mappa-del-sito/" },
               // { "fr",  "englishlive.ef.com/fr-fr/plandusite/" },
                //{ "be",  "englishlive.ef.com/fr-wws/plandusite/?ctr=be" },
                { "de",  "englishlive.ef.com/de-de/seitenuebersicht/" },
                //{ "at",  "englishlive.ef.com/de-wws/seitenuebersicht/?ctr=at" },
                { "es",  "englishlive.ef.com/es-es/sitemap/" },
                { "mx",  "englishlive.ef.com/es-mx/mapa-sitio/" },
                { "gb",  "englishlive.ef.com/en-gb/sitemap/" },
                { "us_es",  "englishlive.ef.com/es-us/mapa-sitio/" },
                { "us_en",  "englishlive.ef.com/en-us/sitemap/" },
               // { "ag ",  "englishlive.ef.com/en-wws/sitemap/?ctr=ag" },
                { "tr",  "englishlive.ef.com/tr-tr/sitemap/" },
                { "sa",  "englishlive.ef.com/ar-sa/sitemap/" },
                //{ "ae",  "englishlive.ef.com/ar-wws/sitemap/?ctr=ae" },
                { "id",  "englishlive.ef.com/id-id/sitemap/" },
                { "tw",  "englishlive.ef.com/zh-tw/sitemap/" },
                { "jp",  "englishlive.ef.com/ja-jp/sitemap/" },
                { "th",  "englishlive.ef.com/th-th/sitemap/" },
                { "kr ",  "englishlive.ef.com/ko-kr/sitemap/" },
                { "ru",  "englishlive.ef.com/ru-ru/%D0%BA%D0%B0%D1%80%D1%82%D0%B0-%D1%81%D0%B0%D0%B9%D1%82%D0%B0/" },
                { "br ",  "englishlive.ef.com/pt-br/sitemap/" },
        };
    }

    @DataProvider(name = "siteMapXmlUrlall", parallel = true)
    public static Object[][] siteMapXmlUrlall() {
        return new Object[][] {
                {"", "englishlive.ef.com/es-mx/sitemap-index.xml" },
                {"", "englishlive.ef.com/it-it/sitemap-index.xml" },
                {"", "englishlive.ef.com/fr-fr/sitemap-index.xml" },
                {"", "englishlive.ef.com/de-de/sitemap-index.xml" },
                {"", "englishlive.ef.com/es-mx/sitemap-index.xml" },
                {"", "englishlive.ef.com/en-gb/sitemap-index.xml" },
                {"", "englishlive.ef.com/en-us/sitemap-index.xml" },
                {"", "englishlive.ef.com/tr-tr/sitemap-index.xml" },
                {"", "englishlive.ef.com/ar-sa/sitemap-index.xml" },
                {"", "englishlive.ef.com/id-id/sitemap-index.xml" },
                {"", "englishlive.ef.com/zh-tw/sitemap-index.xml" },
                {"", "englishlive.ef.com/ja-jp/sitemap-index.xml" },
                {"", "englishlive.ef.com/th-th/sitemap-index.xml" },
                {"", "englishlive.ef.com/ko-kr/sitemap-index.xml" },
                {"", "englishlive.ef.com/sitemap-index.xml" },
                {"", "englishlive.ef.com/pt-br/sitemap-index.xml" },

        };
    }


}
