package com.englishtown.util.db.core;

import com.englishtown.helpers.bean.UrlMonitoringStatistics;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.util.db.testdbbean.TestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikol.marku on 09/11/2015.
 */
public class DbManager extends MyDbConnect {
    private static final Logger logger = LoggerFactory.getLogger(DbManager.class);
    /**
     * Get tests statistics from test_stats view
     * @return List<UrlMonitoringStatistics>
     *
     * Note: needs open connection and to close the resources after running
     */
    public static List<UrlMonitoringStatistics>  getUrlMonitoringStatistics(String sql){
        List<UrlMonitoringStatistics> monitStats = new ArrayList();
        UrlMonitoringStatistics urlMonitStats = null;

        try {
            stmt = conn.createStatement();
            logger.info("Executing query ["+sql+"]");
            ResultSet resultSet = stmt.executeQuery(sql);
            logger.info("Selected data from DB ...!");

            while(resultSet.next()) {
                try {
                    String country = resultSet.getString("countryName");
                    String testUrl = resultSet.getString("url");
                    String loadTime = resultSet.getString("loadtime");
                    urlMonitStats = new UrlMonitoringStatistics(country, testUrl, loadTime);
                }catch (Exception e){
                    e.printStackTrace();
                    logger.error("ResultSet .next processing Exception ...! : "+ TestUtil.getException(e));
                }
                monitStats.add(urlMonitStats);
                logger.info("UrlMonitoringStatistics Object added to List ...!"+urlMonitStats.toString());
            }
            logger.info("UrlMonitoringStatistics List created ...!");
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("Query Exception ...! : "+ TestUtil.getException(e));
        }catch(Exception e){
            e.printStackTrace();
            logger.error("Query Exception ...! : "+ TestUtil.getException(e));
        }

        return monitStats;
    }

    public static List<TestBean>  getTestBeans(String sql){
        List<TestBean> testBeanList = new ArrayList();
        TestBean testBean = null;

        try {
            stmt = conn.createStatement();
            logger.info("Executing query ["+sql+"]");
            ResultSet resultSet = stmt.executeQuery(sql);
            logger.info("Selected data from DB ...!");

            while(resultSet.next()) {
                try {
                    int id         = resultSet.getInt("t_ID");
                    String testName = resultSet.getString("TestName");
                    String url = resultSet.getString("url");
                    String note = resultSet.getString("note");
                    int countryId = resultSet.getInt("c_id");
                    int groupId = resultSet.getInt("group_id");

                    testBean = new TestBean(id, testName, url, note, countryId, groupId );
                    //logger.info(testBean.toString()) ;
                }catch (Exception e){
                    e.printStackTrace();
                    logger.error("ResultSet .next processing Exception ...! : "+ TestUtil.getException(e));
                }
                testBeanList.add(testBean);
                logger.info("UrlMonitoringStatistics Object added to List ...!"+testBean.toString());
            }
            logger.info("UrlMonitoringStatistics List created ...!");
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("Query Exception ...! : "+ TestUtil.getException(e));
        }catch(Exception e){
            e.printStackTrace();
            logger.error("Query Exception ...! : "+ TestUtil.getException(e));
        }

        return testBeanList;
    }

    /**
     * Insert test date and initialise maxRunId to be used when enter data on TestRun table
     * @param sql
     * @param runDate   java sql data
     */
    public static void insert_Run_TestData(String sql, Object runDate, String note ){
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, runDate);    //pstmt.setDate(1, runDate); //new java.sql.Date(runDate.getTime()) MySQL displays DATETIME values in 'YYYY-MM-DD HH:MM:SS[.fraction]' format, but permits assignment of values to DATETIME columns using either strings or numbers.
            pstmt.setString(2, note);
            pstmt.executeUpdate();
            logger.info("DB table Run updated ....! ["+runDate+" ; "+note+"]");
            logger.info("Init Max Run ID ....!");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_MAX_RUNID_SQL);
            while(rs.next()) {
                maxRunId = rs.getInt(1);//getInt("r_ID");
                currentRunId = maxRunId;
            }
            logger.info("Max Run ID is : "+maxRunId);
            if(maxRunId > 0){
                isMaxRunInitilised= true;
            } else {
                logger.info("Max Run ID not initialized ....!");
                throw new SQLException(" Max Run ID not initialized ....! ");
            }
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("executeQuery Exception ...! : "+ TestUtil.getException(e));
        }
    }
    // test
    public static void insert_t_TestData(String sql, Time time, Object dataTime ){
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setTime(1, time);
            pstmt.setObject(2, dataTime);
            pstmt.executeUpdate();
            logger.info("DB table TestRun updated ....!");
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("executeQuery Exception ...! : "+ TestUtil.getException(e));
        }
    }

    public static Object getTimeStamp() {
        java.util.Date date = new Date(System.currentTimeMillis());
        Object timeStamp = new java.sql.Timestamp(date.getTime());
        return timeStamp;
    }


    /**
     * Get the int max value of the column id
     * @param id
     * @param tableName
     */
    public static void getIntMaxId(String id, String tableName){
        String SELECT_MAX_TABLE_ID_SQL = "SELECT MAX("+id+") FROM "+tableName;
        int maxId = -1;// not init
        try {
            logger.info("Get Max ID ["+id+"], for table ["+tableName+"]");
            maxId = rs.getInt("r_ID");
            logger.info("Max Run ID is : "+maxId);

            if(maxId == -1){
                logger.info("Max ID not initialized ....!");
                throw new SQLException(" Max ID not initialized ....! ");
            }
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("executeQuery Exception ...! : "+ TestUtil.getException(e));
        }
    }

    public static void insert_TestRun_TestData(String sql, int runId, int testId, float loadTime ){
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, runId);
            pstmt.setInt(2, testId);
            pstmt.setFloat(3, loadTime);
            pstmt.executeUpdate();
            logger.info("DB table TestRun updated ....!");
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("executeQuery Exception ...! : "+ TestUtil.getException(e));
        }
    }

    //TODO how to create batch statement here
    /**
     * use with batch processing
     * Before use do this
     *      conn.setAutoCommit(false);
     *      pstmt = conn.prepareStatement(sql);
     */
    public static void setSqlTestRunAndAdditToBatchPstmt(PreparedStatement pstmt, int runId, int testId, float loadTime,
                                                         long ptNavigationStart, long ptConnectStart, long ptRequestStart,
                                                         long ptResponseStart, long ptDomLoading, long ptDomInteractive,
                                                         long ptDomComplete, long ptLoadEventEnd, long ptNetworkLatency,
                                                         long ptPageLoadOnceReceivedFromServer, long ptTimeToDomInteractive,
                                                         long ptTimeToDomComplete, long ptDomCompleteProcessingTime ){
        try {
            pstmt.setInt(1, runId);
            pstmt.setInt(2, testId);
            pstmt.setFloat(3, loadTime);
            pstmt.setLong(4, ptNavigationStart  );
            pstmt.setLong(5, ptConnectStart  );
            pstmt.setLong(6, ptRequestStart  );
            pstmt.setLong(7, ptResponseStart  );
            pstmt.setLong(8, ptDomLoading  );
            pstmt.setLong(9, ptDomInteractive  );
            pstmt.setLong(10, ptDomComplete  );
            pstmt.setLong(11, ptLoadEventEnd  );
            pstmt.setLong(12, ptNetworkLatency  );
            pstmt.setLong(13, ptPageLoadOnceReceivedFromServer  );
            pstmt.setLong(14, ptTimeToDomInteractive  );
            pstmt.setLong(15, ptTimeToDomComplete  );
            pstmt.setLong(16, ptDomCompleteProcessingTime );

            pstmt.addBatch();
            logger.info("pstmt setup and added to batch ....! : "+pstmt.toString());
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("setSqlTestRunAndAdditToBatchPstmt Exception ...! : "+ TestUtil.getException(e));
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    /**
     * Execute batch, commit and clear it
     * @param statement
     */
    public static void executeBatchPstmtAndCommit(PreparedStatement statement) {
        int [] updateCounts;
        int successCount = 0;
        int failCount = 0;
        int notAavailable = 0;

        try {
            try {
                int[] count = statement.executeBatch();             // Create an int[] to hold returned values  throws BatchUpdateException  subclasse of SqlException
                logger.info("executeBatchPstmtAndCommit .....!");
            }catch (BatchUpdateException buex){
                buex.printStackTrace();
                logger.error("Batch exe error ...! : "+buex.getMessage());
                updateCounts = buex.getUpdateCounts();
                logger.info("update count is : " + updateCounts);
                for (int i = 0; i < updateCounts.length; i++) {
                    if (updateCounts[i] >= 0) {
                        successCount++;
                    } else if (updateCounts[i] == Statement.SUCCESS_NO_INFO) {
                        notAavailable++;
                    } else if (updateCounts[i] == Statement.EXECUTE_FAILED) {
                        failCount++;
                    }
                }
            } finally {
                logger.info("Number of affected rows before Batch Error :: " + successCount);
                logger.info("Number of affected rows not available:" + notAavailable);
                logger.info("Failed Count in Batch because of Error:" + failCount);
            }
            conn.commit();                                      // Explicitly commit statements to apply changes
            statement.clearBatch();
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("executeBatchPstmtAndCommit SQLException ...! : "+ TestUtil.getException(e) );
        }
    }


}


/**
 PreparedStatement updateemp = con.prepareStatement
 ("insert into emp values(?,?,?)");
 updateemp.setInt(1,23);
 updateemp.setString(2,"Roshan");
 updateemp.setString(3, "CEO");
 updateemp.executeUpdate();

 */

/***   http://www.coderanch.com/t/627237/JDBC/databases/track-failed-record-batch-excution
 ps.executeBatch(); // insert remaining records
 } catch (BatchUpdateException buex) {
 buex.printStackTrace();
 LogUtil.error(buex);
 int[] updateCounts = buex.getUpdateCounts();
 for (int i = 0; i < updateCounts.length; i++) {
 if (updateCounts[i] >= 0) {
 successCount++;

 } else if (updateCounts[i] == Statement.SUCCESS_NO_INFO) {
 notAavailable++;

 } else if (updateCounts[i] == Statement.EXECUTE_FAILED) {
 failCount++;

 }
 }
 } finally {
 LogUtil.info("Number of affected rows before Batch Error :: " + successCount);
 LogUtil.info("Number of affected rows not available:" + notAavailable);
 LogUtil.info("Failed Count in Batch because of Error:" + failCount);
 ps.close();
 connection.close();
 }
 **/