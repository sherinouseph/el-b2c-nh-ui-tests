package com.englishtown.util.db.test;
/**
 * Created by nikol.marku on 10/11/2015.
 *
 * Note: This run on boston PC and sql is installed there as well so:
 *        Sql select date is set to work for this locale...
 *        Java date for Column heading set to work for this locale as well....
 */
import com.englishtown.util.db.core.DbManager;
import com.englishtown.util.db.core.ExcelReportPeriod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UrlMonitorApp{
    private static final Logger logger = LoggerFactory.getLogger(UrlMonitorApp.class);

    public static void main(String[] args){
        //create CSV        // TODO setup sql with period for stats
        CreateEmailMonitoringStats.createCsvFile(ExcelReportPeriod.LAST_WEEK, DbManager.SELECT_MONITSTATS_lAST_FULL_WEEK_SQL);
        CreateEmailMonitoringStats.emailStats();
        DbManager.closeAllDBthreads();
    }


}
