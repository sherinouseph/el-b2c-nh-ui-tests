package com.englishtown.dataprovider;

import com.englishtown.dataprovider.bin.CrmMonitOSOEUrlBean;
import com.englishtown.enumpack.CrmTestType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nikol.marku on 10-Jul-17.
 *
 * Read URLs from CQ file
 * set url obj and
 * return a list of objects
 *
 */
public class CrmOSOEMonitorDatatProvider extends BaseDataProvider{

    private static final Logger logger = LoggerFactory.getLogger(CrmOSOEMonitorDatatProvider.class);

    private static String jsonUrl = "http://10.162.82.101:4503/content/englishtown/monitored-pages/jcr:content/main-parsys/page-list.infinity.json";
    //Edit the URL on https://aem.eflabs.io/cf#/content/englishtown/monitored-pages.html

    static AtomicInteger id = new AtomicInteger(0);


    @DataProvider(name = "getCrmMonitOSurls") //, parallel = true)
    public static Object[][] getCrmMonitOSurls() {
        List<CrmMonitOSOEUrlBean> crmMonitUrlList = readCrmMonitOSOEUrlBean( jsonUrl, "lp/os/");
        return getObject2dArrayFromList(crmMonitUrlList);
    }

    @DataProvider(name = "getCrmMonitOEurls")//, parallel = true)
    public static Object[][] getCrmMonitOEurls() {
        List<CrmMonitOSOEUrlBean> crmMonitUrlList = readCrmMonitOSOEUrlBean( jsonUrl, "lp/oe/");
        return getObject2dArrayFromList(crmMonitUrlList);

    }


    @DataProvider(name = "getCrmMonitOSurlsObj")//, parallel = true)
    public static Object[][] getCrmMonitOSurlsObj() {
        return new Object[][]{
                new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/tr-tr/lp/os/crm-acq-boring-grammar/", "tr", CrmTestType.OS)},
                //new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/tr-tr/lp/os/crm-acq-boring-grammar/", "tr", CrmTestType.OS)},
                //new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/de-de/lp/os/crm-acq-boring-grammar/", "de", CrmTestType.OS)},
               /* new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/en-wws/lp/os/crm-acq-30-day-challenge/", "de", CrmTestType.OS)},
                new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/de-wws/lp/os/crm-acq-30-day-challenge/", "de", CrmTestType.OS)},
                new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/de-wws/lp/os/crm-acq-30-day-challenge/", "de", CrmTestType.OS)},
                //new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/en-wws/lp/os/crm-cxs-teacher-elissa/", "en", CrmTestType.OS)},
                //new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/es-mx/lp/os/crm-acq-30-day-challenge/", "mx", CrmTestType.OS)},

                /**
                https://englishlive.ef.com/es-es/lp/os/crm-acq-30-day-challenge/
                https://englishlive.ef.com/tr-tr/lp/os/crm-acq-30-day-challenge/
                https://englishlive.ef.com/es-mx/lp/os/crm-acq-30-day-challenge/?ctr=mx
                */
                //new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/it-it/lp/os/crm-acq-summer-ipad-17/", "it", CrmTestType.OS)},
                //need to be on new template new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/de-de/lp/os/crm-acq-3mnth/", "de", CrmTestType.OS)}
                //new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/en-wws/lp/os/crm-cxs-teacher-elissa/", "en", CrmTestType.OS)}
                //new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/ja-jp/lp/os/crm-cxs-teacher-elissa/", "jp", CrmTestType.OS)}
                //new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/en-gb/lp/os/crm-cxs-teacher-elissa", "gb", CrmTestType.OS)}

                // update to new template
                //new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/ar-sa/lp/os/crm-cxsflow/", "sa", CrmTestType.OS)}
        };
    }

    @DataProvider(name = "getCrmMonitOEurlsObj")//, parallel = true)
    public static Object[][] getCrmMonitOEurlsObj() {
        return new Object[][]{
                //https://englishlive.ef.com/ar-sa/lp/oe/crm-acq-fading-english/
                new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/ar-sa/lp/oe/crm-acq-fading-english/", "sa", CrmTestType.OE)},
                //new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "https://englishlive.ef.com/zh-tw/lp/oe/crm-acq-summer-ipad-17/", "tw", CrmTestType.OE)}
        };
    }


}



/**
 *
 *
 nikol.marku@GBLCM-L0252 ~
 $ cat crmOS.txt
 englishlive.ef.com/it-it/lp/os/crm-acq-summer-ipad-17/
 englishlive.ef.com/en-wws/lp/os/crm-cxs-teacher-elissa/
 englishlive.ef.com/en-gb/lp/os/crm-cxs-teacher-elissa/
 englishlive.ef.com/ja-jp/lp/os/crm-cxs-teacher-elissa/
 englishlive.ef.com/en-gb/lp/os/crm-acq-30-day-challenge/
 englishlive.ef.com/it-it/lp/os/crm-acq-30-day-challenge/
 englishlive.ef.com/de-de/lp/os/crm-acq-30-day-challenge/
 englishlive.ef.com/de-wws/lp/os/crm-acq-30-day-challenge/
 englishlive.ef.com/ar-sa/lp/os/crm-acq-30-day-challenge/
 englishlive.ef.com/ja-jp/lp/os/crm-acq-30-day-challenge/
 englishlive.ef.com/es-es/lp/os/crm-acq-30-day-challenge/
 englishlive.ef.com/en-wws/lp/os/crm-acq-30-day-challenge/
 englishlive.ef.com/tr-tr/lp/os/crm-acq-30-day-challenge/
 englishlive.ef.com/en-us/lp/os/crm-acq-30-day-challenge/
 englishlive.ef.com/es-mx/lp/os/crm-acq-30-day-challenge/

 nikol.marku@GBLCM-L0252 ~
 $ cat crmOE.txt
 englishlive.ef.com/en-gb/lp/oe/crm-halloween/
 englishlive.ef.com/zh-tw/lp/oe/crm-acq-summer-ipad-17/
 englishlive.ef.com/fr-fr/lp/oe/crm-acq-teacher-elissa/
 englishlive.ef.com/ar-sa/lp/oe/crm-acq-smiling-girl-16/
 englishlive.ef.com/it-it/lp/oe/crm-acq-smiling-girl-16/
 englishlive.ef.com/de-de/lp/oe/crm-acq-smiling-girl-16/
 englishlive.ef.com/de-wws/lp/oe/crm-acq-smiling-girl-16/
 englishlive.ef.com/zh-tw/lp/oe/crm-cxs-teacher-elissa/
 englishlive.ef.com/it-it/lp/oe/crm-cxs-teacher-elissa/
 englishlive.ef.com/de-de/lp/oe/crm-cxs-teacher-elissa/
 englishlive.ef.com/tr-tr/lp/oe/crm-cxs-teacher-elissa/
 englishlive.ef.com/ar-sa/lp/oe/crm-cxs-teacher-elissa/
 englishlive.ef.com/fr-fr/lp/oe/crm-cxs-teacher-elissa/
 englishlive.ef.com/es-es/lp/oe/crm-cxs-teacher-elissa/
 englishlive.ef.com/ar-sa/lp/oe/crm-acq-pronunciation/
 englishlive.ef.com/de-wws/lp/oe/crm-acq-pronunciation/
 englishlive.ef.com/tr-tr/lp/oe/crm-acq-pronunciation/
 englishlive.ef.com/zh-tw/lp/oe/crm-acq-pronunciation/
 englishlive.ef.com/it-it/lp/oe/crm-acq-pronunciation/
 englishlive.ef.com/es-es/lp/oe/crm-acq-pronunciation/
 englishlive.ef.com/fr-fr/lp/oe/crm-acq-pronunciation/
 englishlive.ef.com/de-de/lp/oe/crm-acq-pronunciation/
 englishlive.ef.com/de-de/lp/oe/crm-acq-mthcal-teacherjob/
 englishlive.ef.com/ar-sa/lp/oe/crm-acq-30-day-challenge/
 englishlive.ef.com/zh-tw/lp/oe/crm-acq-30-day-challenge/

 nikol.marku@GBLCM-L0252 ~
 $


 //
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/de-de/lp/os/crm-acq-3mnth/, "de", CrmTestType.OS)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/it-it/lp/os/crm-acq-summer-ipad-17/, "it", CrmTestType.OS)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/ar-sa/lp/os/crm-cxsflow/, "sa", CrmTestType.OS)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/en-wws/lp/os/crm-cxs-teacher-elissa/, "en", CrmTestType.OS)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/en-gb/lp/os/crm-cxs-teacher-elissa/, "gb", CrmTestType.OS)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), "englishlive.ef.com/ja-jp/lp/os/crm-cxs-teacher-elissa/, "jp", CrmTestType.OS)},


 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/en-gb/lp/oe/crm-halloween/, "gb", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/zh-tw/lp/oe/crm-acq-summer-ipad-17/, "tw", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/fr-fr/lp/oe/crm-acq-teacher-elissa/, "fr", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/ar-sa/lp/oe/crm-acq-smiling-girl-16/, "sa", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/it-it/lp/oe/crm-acq-smiling-girl-16/, "it", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/de-de/lp/oe/crm-acq-smiling-girl-16/, "de", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/de-wws/lp/oe/crm-acq-smiling-girl-16/, "de", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/zh-tw/lp/oe/crm-cxs-teacher-elissa/, "tw", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/it-it/lp/oe/crm-cxs-teacher-elissa/, "it", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/de-de/lp/oe/crm-cxs-teacher-elissa/, "de", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/tr-tr/lp/oe/crm-cxs-teacher-elissa/, "tr", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/ar-sa/lp/oe/crm-cxs-teacher-elissa/, "sa", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/fr-fr/lp/oe/crm-cxs-teacher-elissa/, "fr", CrmTestType.OE)},
 new Object[]{new CrmMonitOSOEUrlBean(id.getAndIncrement(), englishlive.ef.com/es-es/lp/oe/crm-cxs-teacher-elissa/, "es", CrmTestType.OE)},
 */