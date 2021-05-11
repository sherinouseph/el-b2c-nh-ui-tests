package com.englishtown.newhouse.school.pages.core;
/**
 * sherin - 30-01-2018
 * school maps should come here
 *
 */

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class SchoolConstants {

    public  static AtomicLong alCurrTime;
    public static Long currTime;
    //public static String randomStrInt;
    public static final String TEST_MAIL_START_TOKEN = "auto_"; //TEST_MAIL_START_TOKEN+currTime+TEST_MAIL_endTOCKEN+"@qp1.org"
    public static final String TEST_MAIL_END_TOKEN = "_xdelx";



    public Long getCurrTime() {
        return currTime;
    }


    public static void dumpMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(pairs.getKey() + "\t = " + pairs.getValue());
        }
    }


    public static final Map<String, String> EMAIL_US = new LinkedHashMap<>();
    static {
        EMAIL_US.put(" input[name='email']", "sherin.ouseph@qp1.org");
        EMAIL_US.put("input[name='category']", "selectMeSelectOpt&true&169");//not so sure if this works because this dropdown doesn't have selec tag
        EMAIL_US.put("textarea[name='message']", "this is a automation test for email us functionaity");



    }


}
