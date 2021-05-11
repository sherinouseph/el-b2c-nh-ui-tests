package com.englishtown.util.db.core;

import com.englishtown.helpers.utils.EfDateUtils;

import java.sql.Date;
import java.util.Calendar;

/**
 * DB access
 */
interface IDB {

    String DB_PORT     = "3306";
    String DB_PASS     = "password";
    String DB_USER     = "java";
    String DB_HOSTNAME = "10.162.85.203";      //"usb-etbuild5"; //"localhost";                                                                                   //"127.0.0.1"; 127.0.0.1   // C:/Bitnami/TESTLI~1.13-/mysql/url_monitoring
    String DB_NAME     = "url_monitoring";
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL      = "jdbc:mysql://"+DB_HOSTNAME+":"+DB_PORT+"/"+DB_NAME;                                           //jdbc:mysql://hostname:port/databasename

    String SELECT_TESTS_SQL         = "SELECT * FROM TEST";
    String INSERT_INTO_TEST ="INSERT INTO Test (TestName, url, c_id) VALUES(?, ?, (SELECT c_id FROM countries where countryCode=?) )";
    String selectCIdByCCode ="SELECT c_id FROM countries where countryCode=?";
    String INSERT_INTO_RUN_SQL     = "INSERT INTO RUN (date, note) VALUES (?, ?)";                                      //THE TIME STAMP THE TEST IS RUNNIN        // date e.g 2015-10-30 16:02:03
    String INSERT_INTO_TESTRUN_SQL = "INSERT INTO TESTRUN  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; ; //"INSERT INTO TESTRUN  VALUES (?, ?, ?)"; // RunId and Test ID as well as Load time
    String SELECT_MAX_RUNID_SQL    = "SELECT MAX(r_ID) FROM RUN";
    String SELECT_URLS_SQL         = "SELECT url FROM TEST";
    //test only CREATE TABLE t1 (t TIME(3), dt DATETIME(6));
    String INSERT_INTO_T_SQL     = "INSERT INTO t1 (t, dt) VALUES (?, ?)"; //

    String SELECT_MONIT_STATS_DATA_SQL =
            "SELECT r.date, r.r_id, t.t_id, c.countryCode, c.countryName ,t.TestName, t.url, tr.loadtime " +
                    "from countries c, test t, run r, testrun tr " +
                    "where r.r_id=tr.r_id " +
                    "and t.t_id= tr.t_id " +
                    "and t.c_id=c.c_id " ;
                    //"ORDER BY R.R_ID ";
 //select period for the report data
 String SELECT_MONITSTATS_DATE_GTR_THAN_SQL =
         "SELECT r.date, r.r_id, t.t_id, c.countryCode, c.countryName ,t.TestName, t.url, tr.loadtime " +
                 "from countries c, test t, run r, testrun tr " +
                 "where r.date > ? " +
                 "where r.r_id=tr.r_id " +
                 "and t.t_id= tr.t_id " +
                 "and t.c_id=c.c_id " +
                 "ORDER BY R.R_ID ";

 String SELECT_MONITSTATS_lAST_FULL_WEEK_SQL =  // selenium time "SELECT r.r_id, t.t_id, c.countryCode, c.countryName , t.url, ROUND(AVG(tr.loadtime), 3 ) AS loadtime "+
        "SELECT r.r_id, t.t_id, c.countryCode, c.countryName , t.url, ROUND(AVG(tr.ptTimeToDomComplete)/1000, 3 ) AS loadtime "+
                "from countries c, test t, run r, testrun tr "+
                "where r.date >  (SELECT CURDATE()-INTERVAL (WEEKDAY(NOW())+8) DAY) "+
                "AND r.date < (SELECT CURDATE()-INTERVAL WEEKDAY(NOW()) DAY) "+
                "AND r.r_id=tr.r_id "+
                "AND t.t_id= tr.t_id "+
                "AND t.c_id=c.c_id "+
                "group by t.t_id "+
                "order by t.t_id ";
    //
    //         "SELECT r.date, r.r_id, r.date, t.t_id, c.countryCode, c.countryName ,t.TestName, t.url, tr.loadtime " +
    //                 "from countries c, test t, run r, testrun tr " +
    //                 "where r.date >"+ EfDateUtils.getDateStrForSqlQuery(EfDateUtils.getfirstDayOfLastWeekDate(Calendar.getInstance()))+" "+
    //                 "and r.r_id=tr.r_id " +
    //                 "and t.t_id= tr.t_id " +
    //                 "and t.c_id=c.c_id " +
    //                 "ORDER BY R.R_ID ";


}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
use url_monitoring;

CREATE TABLE  stats_users(
    u_name  varchar(100),
    u_email varchar(100),
    u_pass  varchar(40)
);

insert into stats_users values ("Nikol Marku", "nikol.marku@ef.com","kozare") ;
insert into stats_users values ("Vahid Pourahmary", "Vahid.Pourahmary@EF.com","vahid") ;
insert into stats_users values ("Rene Villegas", "rene.villegas@EF.com","villegas") ;
select * from stats_users;
        */
//// nikol.marku@ef.com
// could use  select NOW() - INTERVAL 6 WEEK .. this works if run on moday...  sunday???
// run on the 7th dec

//mysql --user=java --password url_monitoring
/*
this get week 2
mysql> select (now() -INTERVAL (WEEKDAY(NOW())+7) DAY) - INTERVAL 1 WEEK;
| 2015-11-23 16:30:38
                                  |
                                       |
mysql> select (now() -INTERVAL (WEEKDAY(NOW())+7) DAY) - INTERVAL 2 WEEK;
        +------------------------------------------------------------+
        | (now() -INTERVAL (WEEKDAY(NOW())+7) DAY) - INTERVAL 2 WEEK |
        +------------------------------------------------------------+
        | 2015-11-16 16:27:30                                        |
 */
// last full week
/**  add +7 for each selection
 * e.g currdate is 07-12-2015
 *3 weeks ago
 startDate = (SELECT CURDATE()-INTERVAL (WEEKDAY(NOW())+21) DAY)   // Monday   =
 endDate   = (SELECT CURDATE()-INTERVAL (WEEKDAY(NOW())+15) DAY);  // Sunday   =
 *2 weeks
 startDate = (SELECT CURDATE()-INTERVAL (WEEKDAY(NOW())+14) DAY)   // Monday   =  2015-11-23
 endDate   = (SELECT CURDATE()-INTERVAL (WEEKDAY(NOW()) +8) DAY);  // Sunday   =  2015-11-29
 * 1 week
 startDate = (SELECT CURDATE()-INTERVAL (WEEKDAY(NOW()) +7) DAY)   // Monday   =  2015-11-30
 endDate   = (SELECT CURDATE()-INTERVAL (WEEKDAY(NOW()) +1) DAY);  // Sunday   =  2015-12-06

 */
/**  LAST FULL WEEK  round at 3 decimals
 *
 SELECT r.date, r.r_id, t.t_id, c.countryCode, c.countryName ,t.TestName, t.url, ROUND(AVG(tr.loadtime), 3) AS loadtime
 from countries c, test t, run r, testrun tr
 where r.date >  (SELECT CURDATE()-INTERVAL (WEEKDAY(NOW())+8) DAY)
 AND r.date < (SELECT CURDATE()-INTERVAL WEEKDAY(NOW()) DAY)
 AND r.r_id=tr.r_id
 AND t.t_id= tr.t_id
 AND t.c_id=c.c_id
 group by t.t_id
 order by t.t_id;

//norman
 SELECT r.date, r.r_id, t.t_id, c.countryCode, c.countryName ,t.TestName, t.url, ROUND(AVG(tr.loadtime), 3) AS loadtime
 from countries c, test t, run r, testrun tr
 where t.t_id IN (37, 41,50,38,44,51)
 AND r.r_id=tr.r_id
 AND t.t_id= tr.t_id
 AND t.c_id=c.c_id
 group by t.t_id
 order by t.t_id;

 SELECT r.date, r.r_id, t.t_id, c.countryCode, c.countryName ,t.TestName, t.url, ROUND(AVG(tr.loadtime), 3) AS loadtime
 from countries c, test t, run r, testrun tr
 where t.t_id IN (37, 41,50,38,44,51)
 and r.r_id=26
 AND r.r_id=tr.r_id
 AND t.t_id= tr.t_id
 AND t.c_id=c.c_id
 group by t.t_id
 order by t.t_id;

 */