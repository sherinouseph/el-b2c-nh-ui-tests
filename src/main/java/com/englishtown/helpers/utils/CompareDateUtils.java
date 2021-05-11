package com.englishtown.helpers.utils;

import com.englishtown.pages.core.BasePage;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Compare Date utility
 */
public class CompareDateUtils extends EfDateUtils{
    private static final Logger logger = LoggerFactory.getLogger(CompareDateUtils.class);

    public static int compareDate(Date first, Date second) {
        return first.compareTo(second);
    }

    public static int compareDate(String first, String second) {
        Date firstDate, secondDate;
        firstDate = getDateFromString(first);
        secondDate = getDateFromString(second);

        return firstDate.compareTo(secondDate);
    }


//    public static void main(String[] args ){
//          //logger.info(""+EfDateUtils.getfirstDayOfLastWeekDate(Calendar.getInstance()).toString()  );
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(df.format(getfirstDayOfLastWeekDate(Calendar.getInstance())) );
//
////        for (int i=0; i<9; i++) {
////            Date date = new Date();
////            date = DateUtils.addDays(date, -i);
////            Calendar c1 = Calendar.getInstance();
////            c1.setTime(date);
////            System.out.println(i + ": Current date :" + date.toString() + " \t Last Full week start date :" + firstDayOfLastWeek(c1).getTime());
////        }
//    }

}


//        for (int i=0; i<9; i++) {
//            date = new Date();
//            int noOfDays = i;
//            date = DateUtils.addDays(date, noOfDays);
//            logger.info("........ Date set to : " + date.toString());
//            getLastFullWeek(date);
//        }

//        date = new Date();
//         noOfDays = 1;
//        date = DateUtils.addDays(date, noOfDays);
//        logger.info("........ Date set to : "+date.toString());
//        getWeekStartDate(date);
//        getWeekEndDate(date);
//
//        date = new Date();
//        noOfDays = 2;
//        date = DateUtils.addDays(date, noOfDays);
//        logger.info("........ Date set to : "+date.toString());
//        getWeekStartDate(date);
//        getWeekEndDate(date);
//
//        date = new Date();
//        noOfDays = 3;
//        date = DateUtils.addDays(date, noOfDays);
//        logger.info("........ Date set to : "+date.toString());
//        getWeekStartDate(date);
//        getWeekEndDate(date);
//
//        date = new Date();
//        noOfDays = 4;
//        date = DateUtils.addDays(date, noOfDays);
//        logger.info("........ Date set to : "+date.toString());
//        getWeekStartDate(date);
//        getWeekEndDate(date);
//
//        date = new Date();
//        noOfDays = 5;
//        date = DateUtils.addDays(date, noOfDays);
//        logger.info("........ Date set to : "+date.toString());
//        getWeekStartDate(date);
//        getWeekEndDate(date);