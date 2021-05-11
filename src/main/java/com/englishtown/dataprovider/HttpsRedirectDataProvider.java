package com.englishtown.dataprovider;

/**
 * Created by nikol.marku on 10/25/2016.
 * https://jira-bos.englishtown.com/browse/SAND-3271
 *  Should redirect to same url butwith HTTPs and 301 redirect
 *
 */
import com.englishtown.dataprovider.bin.TestResponseBean;
import org.testng.annotations.DataProvider;

import java.util.concurrent.atomic.AtomicInteger;


public class HttpsRedirectDataProvider {

    static AtomicInteger id = new AtomicInteger(0);

    @DataProvider(name = "httpsRedirect")//, parallel = true)
    public static Object[][] httpsRedirect() {
        return new Object[][] {
                new Object[] {new TestResponseBean(id.getAndIncrement(), "emailenglish.net/es-mx/lp/ee/email_english/", "es-mx",  "emailenglish.net/es-mx/lp/ee/email_english/",   301)},
               // new Object[] {new TestResponseBean(id.getAndIncrement(), "efenglishtown.com/de-de/lp/os/home/", "de-de", "efenglishtown.com/de-de/lp/os/home/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishtown.com.br/lp/oe/sep16-infojobs/", "de-de", "englishtown.com.br/lp/oe/sep16-infojobs/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/online/dp/skill_test_main.aspx", "pt-br",   "https://englishlive.ef.com/pt-br/teste-ingles-online/",   301)},
                //new Object[] {new TestResponseBean(id.getAndIncrement(), "englishtown.com.br/online/dp/cards.aspx_1", "pt-br",   "https://englishlive.ef.com/pt-br/sobre-nos/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/online/change-country.aspx", "pt-br",   "https://englishlive.ef.com/pt-br/",   301)},
                //// HOME pages
                //test  new Object[] {new TestResponseBean(id.get(), "englishlive.ef.com/online/home.aspx", "fr-dz", "https://englishlive.ef.com/fr-wws/",   301)},
                //new Object[] {new TestResponseBean(id.get(), "englishlive.ef.com/online/business-english.aspx",   "https",   301)},
                //
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/th-th/", "th-th", "https://englishlive.ef.com/th-th/",   301)},
                //new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/ru-ru/", "ru-ru", "ef.ru/englishlive/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/tr-tr/", "tr-tr", "https://englishlive.ef.com/tr-tr/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/en-gb/", "en-gb", "https://englishlive.ef.com/en-gb/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/id-id/", "id-id", "https://englishlive.ef.com/id-id/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/ko-kr/", "ko-kr", "https://englishlive.ef.com/ko-kr/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/de-de/", "de-de", "https://englishlive.ef.com/de-de/",   301)},
                //new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-es/", "es-es", "https://englishlive.ef.com/es-es/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/ja-jp/", "ja-jp",    "https://englishlive.ef.com/ja-jp/",   301)},
                //new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/en-wws/", "en-wws",  "https://englishlive.ef.com/en-us/",   301)},//redirect to en-us since the teamcity agent runs in boston.
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/fr-wws/", "fr-wws",  "https://englishlive.ef.com/fr-fr/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/de-wws/", "de-wws",  "https://englishlive.ef.com/de-de/",   301)},

                //new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/ar-wws/", "ar-wws",  "https://englishlive.ef.com/ar-wws/",   301)},

                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/zh-tw/", "zh-tw",  "https://englishlive.ef.com/zh-tw/",     301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/fr-fr/",  "fr-fr",   "https://englishlive.ef.com/fr-fr/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/it-it/", "it-it",    "https://englishlive.ef.com/it-it/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/ar-sa/?ctr=sa", "ar-sa",    "https://englishlive.ef.com/ar-sa/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/pt-br/",  "pt-br",   "https://englishlive.ef.com/pt-br/",   301)},
               // new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/en-wws/","en-us",   "https://englishlive.ef.com/en-us/",   301)}, //?
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-us/", "es-us",   "https://englishlive.ef.com/es-mx/",   301)},
                //new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-wws/","es-wws",  "https://englishlive.ef.com/es-mx/",  301)},
               /* new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-co/", "es-co",   "https://englishlive.ef.com/es-mx/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-cl/", "es-cl",   "https://englishlive.ef.com/es-mx/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-ar/", "es-ar",   "https://englishlive.ef.com/es-mx/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-pe/", "es-pe",   "https://englishlive.ef.com/es-mx/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-ve/", "es-ve",   "https://englishlive.ef.com/es-mx/",   301)},
                */new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-mx/", "es-mx",   "https://englishlive.ef.com/es-mx/",   301)},
                /*new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-co/profesores-y-estudiantes/profesores-de-ingles/",      "es-co",   "https://englishlive.ef.com/es-mx/como-aprender-ingles/profesores-de-ingles/",  301)},//como-aprender-ingles/profesores-de-ingles/
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-pe/cursos-ingles/examen-toeic",                          "es-pe",   "https://englishlive.ef.com/es-mx/como-aprender-ingles/examen-toeic/",          301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-ar/cursos-ingles/cursos-especializados/banca-finanzas",  "es-ar",   "https://englishlive.ef.com/es-mx/como-aprender-ingles/cursos-especializados/", 301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-co/cursos-ingles/cursos-especializados/banca-finanzas",  "es-co",   "https://englishlive.ef.com/es-mx/como-aprender-ingles/cursos-especializados/", 301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-pe/cursos-ingles/cursos-especializados/banca-finanzas",  "es-co",   "https://englishlive.ef.com/es-mx/como-aprender-ingles/cursos-especializados/", 301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-ve/cursos-ingles/cursos-especializados/banca-finanzas",  "es-co",   "https://englishlive.ef.com/es-mx/como-aprender-ingles/cursos-especializados/", 301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-cl/cursos-ingles/cursos-especializados/banca-finanzas",  "es-co",   "https://englishlive.ef.com/es-mx/como-aprender-ingles/cursos-especializados/", 301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-us/cursos-ingles/cursos-especializados/banca-finanzas",  "es-us",   "https://englishlive.ef.com/es-mx/como-aprender-ingles/cursos-especializados/", 301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-wws/cursos-ingles/cursos-especializados/banca-finanzas", "es-wws",  "https://englishlive.ef.com/es-mx/como-aprender-ingles/cursos-especializados/", 301)},
                */
                //new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/es-co/como-aprender-ingles/clases-de-ingles/clases-privadas-en-linea", "es-co", "https://englishlive.ef.com/es-mx/como-aprender-ingles/clases-de-ingles/",      301)},
                //

                //new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/online/home.aspx",  "es-co",  "https://englishlive.ef.com/es-mx/",    301)},
               //new Object[] {new TestResponseBean(id.getAndIncrement(),  "englishlive.ef.com/online/home.aspx",  "fr-dz",  "https://englishlive.ef.com/fr-wws/",   301)},
               // new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/online/home.aspx",  "ar-bh",  "https://englishlive.ef.com/ar-wws/",   301)},
               // new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/online/home.aspx",  "de-at",  "https://englishlive.ef.com/de-de/",   301)},
                //new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/online/home.aspx",  "en-sd",  "https://englishlive.ef.com/en-wws/",   301)},

             /*   new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/online/home.aspx",  "es-co",  "https://englishlive.ef.com/es-mx/",    301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(),  "englishlive.ef.com/online/home.aspx",  "fr-dz",  "https://englishlive.ef.com/ar-sa/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/online/home.aspx",  "ar-bh",  "https://englishlive.ef.com/ar-sa/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/online/home.aspx",  "de-at",  "https://englishlive.ef.com/de-de/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/online/home.aspx",  "en-sd",  "https://englishlive.ef.com/ar-sa/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishlive.ef.com/community/Channels/article.aspx?articleName=117-5mis",  "xx-sd", "https://englishlive.ef.com/blog/top-6-common-business-english-mistakes-avoid",   301)},
                *///EC
               /* new Object[] {new TestResponseBean(id.getAndIncrement(), "englishcenters.ef.com/",            "xx-xx", "https://englishcenters.ef.com/",   301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "englishcenters.ef.com/profesores/", "xx-xx", "https://englishcenters.ef.com/profesores/",   301)},
                */
        };
    }

    @DataProvider(name = "httpsMxNewDomainRedirect")
    public static Object[][] httpsMXNewDomainRedirect() {
        return new Object[][] {
                new Object[] {new TestResponseBean(id.getAndIncrement(), "openemailenglish.com",      "es-mx", "www.openemailenglish.com",  301)},
                new Object[] {new TestResponseBean(id.getAndIncrement(), "www.openemailenglish.com",  "es-mx", "www.openemailenglish.com",  301)},
                // no content yet new Object[] {new TestResponseBean(id.getAndIncrement(), "cursoinglesgratis.net",     "es-mx", "www.cursoinglesgratis.net",     301)},
                // no content yetnew Object[] {new TestResponseBean(id.getAndIncrement(), "www.cursoinglesgratis.net", "es-mx", "www.cursoinglesgratis.net", 301)}
        };
    }

    @DataProvider(name = "mxNewDomain")//, parallel = true)
    public static Object[][] mxNewDomain() {
        return new Object[][] {
                // no content yetnew Object[] {"OPENEMAILENGLISH:LandingPages:ee:email_english1", "www.openemailenglish.com/lp/ee/email_english1.html"},
                new Object[] {"OPENEMAILENGLISH:SalesPages:Home", "www.openemailenglish.com/"},
                // no content yet new Object[] {"OPENEMAILENGLISH:SalesPages:xxx", "www.openemailenglish.com/xxx.html"}
        };
    }


}



  /*new Object[] {"SalesPages:learn-english-online", "englishlive.ef.com/es-mx/como-aprender-ingles/"},
                new Object[] {"SalesPages:learn-english-online", "englishlive.ef.com/it-it/"},
                new Object[] {"SalesPages:learn-english-online", "englishlive.ef.com/de-de/"},
                new Object[] {"SalesPages:learn-english-online", "englishlive.ef.com/fr-fr/"},*/