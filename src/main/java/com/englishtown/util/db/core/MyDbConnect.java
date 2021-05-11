package com.englishtown.util.db.core;
/**
 *
 */
import com.englishtown.commerceclient.Environment;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


public abstract class MyDbConnect implements IDB{
    private static final Logger logger = LoggerFactory.getLogger(MyDbConnect.class);

    Environment environment;
    public static Connection conn ;
    protected static PreparedStatement pstmt ;
    protected static Statement stmt ;
    protected static ResultSet  rs ;
    protected static int maxRunId; //this should be the last run .... init this when you enter data on run table..   one run has many tests on testrun
    protected static int currentRunId;                                      // current test run id - this is equal maxRunId
    protected static boolean isMaxRunInitilised=false;

    /**
     * Initiate DB connection
     */
    public static void connectToDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");                                 // Register JDBC driver
            logger.info("Connecting to database..."+DB_URL+" "+DB_USER+ " "+DB_PASS);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);           // Open a connection

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            logger.error("Error loading JDBC Drivers ...! : "+TestUtil.getEfExceptionLines(se));
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            logger.error("Error connecting to DB ...! : "+TestUtil.getEfExceptionLines(e));
        }
    }

    // execute select queries
    public static ResultSet executeQuery(String sql) throws NullPointerException{
        ResultSet rs = null;
        PreparedStatement stmp = null;
        String sqlStateemnt = sql;

        try {
            pstmt = conn.prepareStatement(sqlStateemnt);
            rs = pstmt.executeQuery(sqlStateemnt);
            closeSqlStatement(stmp);
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("executeQuery Exception ...! : "+TestUtil.getException(e));
        }
        finally {
            return rs;
        }
    }


    public static void closeDBConnection(Connection conn){
        try{
            if(conn!=null)
                conn.close();
            System.out.println(" DB connection closed ...!");
        }catch(SQLException se){
            se.printStackTrace();
            logger.error("Closing Connection Exception ...!   : "+ TestUtil.getException(se));
        }
    }

    public static void closeSqlStatement(Statement stmt){
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException se){
            logger.error("Closing Statement Exception ...!   : "+ TestUtil.getException(se));
        }// nothing we can do .. close
    }

    public static void closeAllDBthreads(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if(rs != null)   rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
            logger.error("closeAllDBthreads SQL exception  ...! : " + TestUtil.getEfExceptionLines(se));
        }
    }
    public static void closeAllDBthreads() {
        try {
            if(rs != null)   rs.close();
            if(stmt != null) stmt.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
            logger.error("closeAllDBthreads SQL exception  ...! : " + TestUtil.getEfExceptionLines(se));
        }
    }

    public static void closeRsAndStmtThreads(ResultSet rs, Statement stmt) {
        try {
            if(rs != null)   rs.close();
            if(stmt != null) stmt.close();
        } catch (SQLException se) {
            se.printStackTrace();
            logger.error("closeAllDBthreads SQL exception  ...! : " + TestUtil.getEfExceptionLines(se));
        }
    }

    public static void printResultSet(ResultSet rs){
        try {
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("t_id");
                String testname = rs.getString("testname");
                String c_id = rs.getString("c_id");
                String url = rs.getString("url");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", testname: " + testname);
                System.out.print(", County id: " + c_id);
                System.out.println(", Url: " + url);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    /**
     *
     */
    public static void createPrepareStatement(String sql){
        try {
            pstmt = conn.prepareStatement(sql);
            logger.info("Created prepareStatement ...!");
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("createPrepareStatement SqlException"+e.getCause());
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public static void setAutoCommit(boolean isAutocommit){
        try {
            conn.setAutoCommit(isAutocommit);
            logger.info("setAutoCommit to : "+isAutocommit);
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("setAutoCommit SqlException"+e.getCause());
        }
    }

    public static int getMaxRunId(){
        return maxRunId;
    }
    public static int getCurrentRunId(){
        return currentRunId;
    }

    public static PreparedStatement getPstmt(){
        return pstmt;
    }

}


/***

 INSERT INTO Test (TestName, url, c_id)
 VALUES("UK_HomePage", "http://www.englishtown.com/en-gb/",(Select c_id from countries where countryCode='GB') );


 //                stmt = conn.prepareStatement(selectCIdByCCode);
 //                stmt.setString(1,countryCode);
 //                rs =  stmt.executeQuery();
 //
 //                int cId = 1000; // default ;// = rs.getInt("c_id");
 //
 //                while (rs.next()) {
 //                    cId = rs.getInt("c_id");
 //                    logger.info(" Country id returned from select : " + cId);
 //                }
 **/

//  public static void connectToDB(){
//     try{
//Register JDBC driver
//           Class.forName("com.mysql.jdbc.Driver");
//Open a connection
///           System.out.println("Connecting to database...");
//           conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
//stmt.addBatch(SQL);   > executeBatch()
//http://www.tutorialspoint.com/jdbc/jdbc-batch-processing.htm
//            String sql = "SELECT * FROM Test";
//            rs = executeQuery(sql);
//            printResultSet(rs);
//            String testName = "testname";
//            String url      = "testUrl";
//            String countryCode = "GB";
//            try {
//                pstmt = conn.prepareStatement(INSERT_INTO_TEST);
//                pstmt.setString(1, testName);
//                pstmt.setString(2, url);
//                pstmt.setString(3, countryCode);            //pstmt.executeUpdate();
//                closeSqlStatement(pstmt);
//            }catch (SQLException e){
//                e.printStackTrace();
//                logger.error("executeQuery Exception ...! : "+TestUtil.getException(e));
//            }

//           closeAllDBthreads(rs, pstmt, conn);
//        }catch(SQLException se){
//            //Handle errors for JDBC
//            se.printStackTrace();
//            logger.error("Error loading Drivers ...! : "+TestUtil.getEfExceptionLines(se));
//        }catch(Exception e){
//            //Handle errors for Class.forName
//            e.printStackTrace();
//            logger.error("Error loading Drivers ...! : "+TestUtil.getEfExceptionLines(e));
//        }
//        finally{
//            //closeSqlStatement(pstmt);
//            //closeDBConnection(conn);
//        }
//        System.out.println("Goodbye ...!");
//    }