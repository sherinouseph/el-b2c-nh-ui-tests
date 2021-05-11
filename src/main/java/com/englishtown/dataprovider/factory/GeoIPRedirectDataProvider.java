package com.englishtown.dataprovider.factory;

import com.englishtown.dataprovider.bin.UrlHostContryRedirectBean;
import org.testng.annotations.DataProvider;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nikol.marku on 10/25/2016.
 */
public class GeoIPRedirectDataProvider {

    static AtomicInteger id = new AtomicInteger(0);

    @DataProvider(name = "GeoIpHostRedirectUrls", parallel = true)
    public static Object[][] allMarketHomePageUrlsData() {
        return new Object[][] {
                // Note : in this case we are opening the IP address for load balancer QA or Live + the rest of URL
                // The host value is used to send it to the correct path
                //br                                       (id,                  url,                  expectedUrl,                             description,            host,                   market){
                new Object[] {new UrlHostContryRedirectBean(id.get(),             "",                   "englishlive.ef.com/pt-br",                     "",             "www.englishlive.com",  "br")},
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "/lp/os/jun16-ls57",  "englishlive.ef.com/pt-br/lp/os/jun16-ls57",    "",             "www.englishlive.com",  "br")},
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "",                   "englishlive.ef.com/pt-br",                     "",             "englishlive.com",      "br")},
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "/lp/os/jun16-ls57",  "englishlive.ef.com/pt-br/lp/os/jun16-ls57",    "",             "englishlive.com",      "br")},
                //de
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "",                                   "englishlive.ef.com/de-de",                                 "", "www.englishlive.com", "de")},
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "/lp/os/automation-test-01-stwt/",    "englishlive.ef.com/de-de/lp/os/automation-test-01-stwt",   "", "www.englishlive.com", "de")},
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "",                                   "englishlive.ef.com/de-de",                                 "", "englishlive.com",     "de")},
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "/lp/os/automation-test-01-stwt/",    "englishlive.ef.com/de-de/lp/os/automation-test-01-stwt",   "", "englishlive.com",     "de")},
                // xx-wws
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "",      "englishlive.ef.com/de-de",     "", "www.englishlive.com", "ch")},
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "",      "englishlive.ef.com/fr-fr",     "", "www.englishlive.com", "be")},
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "",      "englishlive.ef.com/en-gb",     "", "www.englishlive.com", "ad")},
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "",      "englishlive.ef.com/ar-sa",     "", "www.englishlive.com", "bh")},
                new Object[] {new UrlHostContryRedirectBean(id.incrementAndGet(), "",      "englishlive.ef.com/es-mx",     "", "www.englishlive.com", "ar")},
               
        };
    }


}
