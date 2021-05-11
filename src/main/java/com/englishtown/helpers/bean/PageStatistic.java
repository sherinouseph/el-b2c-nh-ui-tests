package com.englishtown.helpers.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 19/08/2015.
 */
public class PageStatistic {
    private static final Logger log = LoggerFactory.getLogger(PageStatistic.class);
    public Long runId; // unique run id for the set of tests - this is the date same id for test run
    public String testName;  // unique id TestName+TimeStamp
    public String url;
    public float loadTime;
    //public String pageSpeedAnalysis;

    public PageStatistic( String testName, String url, float loadTime){
        //if(this.runId > 1) this.runId = System.currentTimeMillis();//do not set if is already set
        this.testName = testName+System.currentTimeMillis();
        this.url = url;
        this.loadTime = loadTime;
    }

    public PageStatistic(String comaSeparatedLine){
        String[] item = comaSeparatedLine.split(",");
        if(!item.equals(null)) {
            try {
                runId = Long.parseLong(item[0].trim());
                testName = item[1].trim();
                url = item[2].trim();
                loadTime = Float.valueOf(item[3].trim());
            }catch (ArrayIndexOutOfBoundsException e) {
                log.error(" Create PageStatistic from line Exception :" +e.getMessage());
            }
        } else {
            log.error("Can not Create User line; Line Item is null ...!"  );
        }
    }

    public void print(){
        log.info("\n\tRunId \t\t:"+runId+"\n\tTestName \t:"+testName+"\n\tURL \t\t:"+url+"\n\tLoadTime \t:"+loadTime);
    }

}