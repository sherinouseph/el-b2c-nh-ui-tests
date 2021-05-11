package com.englishlive.tests.urlmonitor;
/**
 *
 * Use this to setup different period
 *
 */
import com.englishtown.util.db.core.DbManager;
import com.englishtown.util.db.core.ExcelReportPeriod;
import com.englishtown.util.db.test.BaseUrlMonitorStatsTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;


public class UrlMonitorStats extends BaseUrlMonitorStatsTest {
    private static final Logger logger = LoggerFactory.getLogger(UrlMonitorStats.class);

    /**
     * Init DB connection and update RUN table and setup current runId
     */
    @BeforeClass
    void setupConnectToDBupdateRunTable(){
        setScreenShotOnFailure(false);
        DbManager.connectToDB();
        period = ExcelReportPeriod.LAST_WEEK;
        date = new Date(new java.util.Date().getTime());
        logger.info("Update DB ....! : Table Name : RUN :> "+date ) ;
        DbManager.insert_Run_TestData(DbManager.INSERT_INTO_RUN_SQL,  DbManager.getTimeStamp(), note);
        // used for batch processing
        DbManager.setAutoCommit(false);
        DbManager.createPrepareStatement(DbManager.INSERT_INTO_TESTRUN_SQL);

    }

    /**
     * Execute batch sql insert test run result
     */
    @AfterClass
    void executeBatchStmpt(){
        DbManager.executeBatchPstmtAndCommit(DbManager.getPstmt());
        DbManager.closeAllDBthreads();
    }


}


