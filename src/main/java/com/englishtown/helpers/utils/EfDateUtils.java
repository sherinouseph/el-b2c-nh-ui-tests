package com.englishtown.helpers.utils;
/**
 * Created by nikol.marku on 30/11/2015.
 * Main Date utils see DateUtils from apache
 *
 *
 */
import com.englishtown.pages.core.BasePage;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


//TODO I need a metnod to get last full week start date and on the format of e.g "2015-11-27";

public class EfDateUtils extends DateUtils{
    private static final Logger logger = LoggerFactory.getLogger(EfDateUtils.class);

    public static Calendar getCalendar(int numberOfDays) {
        Calendar cDate = Calendar.getInstance();
        cDate.add(Calendar.DATE, numberOfDays);
        return cDate;
    }


    public static Date getDateFromString(String dateStr) {
        Date date=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException pe) {
            pe.printStackTrace();
            BasePage.failTest(pe, "\n Failed to parse string to date ....!\n");
        }
        return date;
    }

    /**
     * Get current date and add the days to return expected date
     */
    public static String getExpectedDate(String dateFormat, int numberOfDays){
        if(dateFormat == null) dateFormat = "yyyy-MM-dd";
        return new SimpleDateFormat(dateFormat).format(CompareDateUtils.getCalendar(numberOfDays).getTime()) ;
    }

    /**
     * Get user string Date and add number of days to it and return Date Object with the new date
     */
    public static Date getDate(String beforeDate, int numberOfDays) { //throws NullPointerException
        Date expectedDate=getDateFromString(beforeDate);
        expectedDate = DateUtils.addDays(expectedDate, numberOfDays);

        return expectedDate;
    }

    /**
     * get calendar last full week first day
     * date = new Date(); Calendar.getInstance().setTime(date);
     */
    public static Calendar getfirstDayOfLastWeek(Calendar c)   {
        c = (Calendar) c.clone();
        // last week
        c.add(Calendar.WEEK_OF_YEAR, -1);
        // first day
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return c;
    }

    public static Date getfirstDayOfLastWeekDate(Calendar c)   {
        c = (Calendar) c.clone();
        // last week
        c.add(Calendar.WEEK_OF_YEAR, -1);
        // first day
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());

        return c.getTime();
    }

    /**
     * Convert date to string to be used on SQL query
     * @param date
     * @return
     */
    public static String getDateStrForSqlQuery(Date date){
        String sqlSelectDate = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sqlSelectDate = df.format(date);   //getfirstDayOfLastWeekDate(Calendar.getInstance())
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            logger.info("\n\t\tsqlSelectDate : "+sqlSelectDate);
            return  sqlSelectDate;
        }
    }

    /**
     * return last full week labels for excel column heading :
     * e.g Week_30-Nov-to-06-Dec
     */
    public static String getLastFullWeekDateRange(String weekStartLabel){
        String weekLabel = "W_";
        if(StringUtils.isNotBlank(weekStartLabel)) {
            weekLabel = weekStartLabel;
        }
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfweek = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
        c.add(Calendar.DATE, -dayOfweek - 6);
        Date start = c.getTime();
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();
        try {
            weekLabel = weekLabel + start.toString().substring(8, 10) + "-" + start.toString().substring(4, 7) + "-to-" + end.toString().substring(8, 10) + "-" + end.toString().substring(4, 7);
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info(" weekLabel : [" +weekLabel+"]");
        return weekLabel;
    }

    //TODO
    public static Date getStartDateLastMonth(){
       Date date = DateUtils.addMonths(new Date(), 1);
       logger.info("getStartDateLastMonth :"+date.toString());
       return date;
    }
    public static Date getStartDateLastThreeMonth(){
        Date date = DateUtils.addMonths(new Date(), 3);

        return date;
    }

    /**
     * Get future, current, past date as long
     * @param daysBeforeNowOrAfter
     * if 0 then today ... if - minus them get past date if + get future date for the number of days
     */
    public long getDate(int daysBeforeNowOrAfter){
        long dayMills = 24 * 60 * 60 * 1000;
        logger.info("Get Date for [{}]", daysBeforeNowOrAfter);
        Date now = new Date(System.currentTimeMillis());
        Date requestedDate = new Date(now.getTime() + (daysBeforeNowOrAfter * dayMills) );
        logger.info("Date is [{}] mills",requestedDate.getTime());
        Date d = new Date(requestedDate.getTime());
        logger.info("Date dd mm yyyy [{}]", new SimpleDateFormat("dd/MM/yyyy").format(d));

        return requestedDate.getTime();
    }

}




//-----------------------------------------------------------------------------------
/**
 //     * Get date at a point in time before or after ,
 //     * if numberOfDaysBeforeOrAfter is zero then is todays date
 //     * @param numberOfDaysBeforeOrAfter
 //     * @return
 //     */
//    public static Date getDateDays(int numberOfDaysBeforeOrAfter) {
//        Date date = new Date();
//        //logger.info(" Date is : "+date);
//        date = DateUtils.addDays(date, numberOfDaysBeforeOrAfter);
//        logger.info("Date after adding Days : "+numberOfDaysBeforeOrAfter+" : is : > "+date.toString());
//        return date;
//    }
//    public static Date getDateMonths(int numberOfWeeksBeforeOrAfter) {
//        Date date = new Date();
//        logger.info(" Date is : "+date);
//        date = DateUtils.addMonths(date, numberOfWeeksBeforeOrAfter);
//        logger.info("Date after adding Months : "+numberOfWeeksBeforeOrAfter+" : is : > "+date.toString());
//        return date;
//    }
//    public static Date getDateWeeks(int numberOfWeeksBeforeOrAfter) {
//        Date date = new Date();
//        logger.info(" Date is : "+date);
//        date = DateUtils.addWeeks(date, numberOfWeeksBeforeOrAfter);
//        logger.info("Date after adding Weeks : "+numberOfWeeksBeforeOrAfter+" : is : > "+date.toString());
//        return date;
//    }

//

//    public static Date getWeekStartDate(Date date){
//        Date weekStart;
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
//        c.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
//        weekStart = c.getTime();
//        logger.info("current weekStart Date : "+weekStart.toString());
//
//        return weekStart;
//    }

/**
 * Get last full week from the date passed
 * If Sunday then that week is the full week
 * @param date
 * @return
 */
//    public static Date getLastFullWeek(Date date){
//        Date weekStart;
//        Calendar c = Calendar.getInstance();
//        c.setFirstDayOfWeek(Calendar.MONDAY);
//        c.setTime(date);
//
//        logger.info("Day of week : "+Calendar.DAY_OF_WEEK );
//        logger.info("getFirstDayOfWeek() : "+c.getFirstDayOfWeek());
//        logger.info("DAY_OF_MONTH :" +Calendar.DAY_OF_MONTH);
//
//        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
//        c.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
//        weekStart = c.getTime();
//        logger.info("current weekStart Date : "+weekStart.toString());
//
//        return weekStart;
//    }
//
//    public static Date getWeekEndDate(Date date){
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
//        c.add(Calendar.DAY_OF_MONTH, 4);
//        Date weekEnd = c.getTime();
//        logger.info("current weekEnd DAte : "+weekEnd);
//        return weekEnd;
//    }