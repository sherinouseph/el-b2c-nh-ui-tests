package com.englishtown.util.db.test;
/**
 * Created by nikol.marku on 10/11/2015.
 *
 * Create excel and email it
 *
 * Not a test : use with main method
 *
 */

import com.englishtown.helpers.mail.EmailSenderConfig;
import com.englishtown.helpers.mail.SendMail;
import com.englishtown.helpers.reader.ReadWriteToFile;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.util.db.core.DbManager;
import com.englishtown.util.db.core.ExcelReportPeriod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.sql.Date;


public class CreateEmailMonitoringStats extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(CreateEmailMonitoringStats.class);
    protected static ExcelReportPeriod period;
    public static Date currentDate;

    /**
     * Connect to DB and Create CSV file in the specified location [createStatsCsvFromDB(...)]
     * @param statsPeriod => weekly ... monthly etc
     */
    public static void createCsvFile(ExcelReportPeriod statsPeriod, String selectMonitStatsSql){
        DbManager.connectToDB();
        period = statsPeriod ;
        currentDate = new Date(new java.util.Date().getTime());
        //test only DbManager.getTestBeans(DbManager.SELECT_TESTS_SQL);
        ReadWriteToFile.createStatsCsvFromDB( DbManager.getUrlMonitoringStatistics(selectMonitStatsSql) );              //  DbManager.SELECT_MONIT_STATS_DATA_SQL
    }
    // TODO
    /**
     * New REQ for csv ... all data average for each week added to excel
     * e.g ctr  | url   | week1 | week2   | week3 ...+
     */


    /**
     * Email  statisticsFile created by createCsvFile() above
     * Note : need to close the connection after this method or last run of this method
     * DbManager.closeAllDBthreads();
     */
    public static void emailStats(){
        File csvFile = new File(ReadWriteToFile.statisticsFile);
        Date currDate = new Date(System.currentTimeMillis());
        try{
            SendMail.sendMail(EmailSenderConfig.STATS_GROUP, "[" + currDate + "] Latest Monitoring Stats .", " Dear Subscriber, \n\n " +
                "Find Attached Latest Monitoring Statistics.\n\n" +
                "Kind Regards\nNiko\n\n EnglishLive QA Engineer", csvFile);
        }catch (Exception e){
            logger.error(" File not created ...! NO email is sent...! "+ TestUtil.getException(e));
        }
    }

}





/**
 public static void main(){
 DbManager.connectToDB();
 period = statsPeriod ; //ExcelReportPeriod.LAST_WEEK;
 Date date = new Date(new java.util.Date().getTime());

 if(isGenerateExcel) {
 ReadWriteToFile.createStatsCsvFromDB(DbManager.getUrlMonitoringStatistics(DbManager.SELECT_MONIT_STATS_DATA_SQL));
 }

 try {
 if(isSendMail) {
 File csvFile = new File(ReadWriteToFile.statisticsFile);
 Date currDate = new Date(System.currentTimeMillis());

 SendMail.sendMail("nikol.marku@ef.com", "[" + currDate + "] Latest Monitoring Stats .", " Dear Subscriber, \n\n " +
 "Find Attached Latest Monitoring Statistics.\n\n" +
 "Kind Regards\nNiko\n\n EnglishLive QA Engineer", csvFile);
 }
 }catch (Exception e){
 logger.error(" File not created ...! so no email is sent...!");
 }

 DbManager.closeAllDBthreads();
 }
 */
