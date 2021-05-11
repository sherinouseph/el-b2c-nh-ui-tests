package com.englishtown.commerceclient.generated;

import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by nikol.marku on 12/02/2015.
 */
public class NikolTest {

    public static void main(String[] args){
           getDate("", 30);
    }


    public static Date getDate(String userPrevNextPayDate, int numberOfDays) throws NullPointerException{
         userPrevNextPayDate = "2015-11-21";
         Date expectedDate=null;
         try {
              Date date = new SimpleDateFormat("yyyy-MM-dd").parse(userPrevNextPayDate);
              date = DateUtils.addDays(date, numberOfDays);              //Calendar cal = Calendar.getInstance(); cal.setTime(date);  print("cal   : ",cal.getTime().toString());
              print("date : ",date.toString());
         }catch (ParseException pe){
              pe.printStackTrace();
         }
         return expectedDate; // new SimpleDateFormat(dateFormat).format(CompareDateUtils.getCalendar(numberOfDays).getTime()) ;
    }



    // add days to current day
//    static Calendar getdate(int numberOfDays){
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, numberOfDays);  // number of days to add
//        String dt = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
//        System.out.println(dt);
//        Calendar cDate = Calendar.getInstance();     //Calendar.getInstance();  //cDate.setTime(new Date());        //cDate.add(Calendar.DATE, numberOfDays);
//        print("cDate : ", cDate.getTime().toString());
//        cDate.add(Calendar.DATE, numberOfDays);
//        String expectedDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate.getTime());
//        print("After add Days cDate : ",expectedDate);
//        //String expectedDat1  = new SimpleDateFormat("yyyy-mm-dd").format(CompareDateUtils.getCalendar(210).getTime()) ;
//        //print("\nexpectedDat1 : ", expectedDat1);
//        return cDate;
//    }

    static void print(String msg, String str){
        System.out.println(msg+" : "+str );
    }

}












/**
 current cdate time  : Thu Oct 22 15:11:30 BST 2015
 ****************** : *****************
 cdate time after +180 : Tue Apr 19 15:11:30 BST 2016


 Calendar cDate =  Calendar.getInstance();
 print("current cdate time ", cDate.getTime().toString());
 String formatDate = new SimpleDateFormat("yyyy-MM-dd").format( cDate.getTime());
 print(" formatDate  : ", formatDate);
 print("******************",  "*****************" );
 Calendar cDate1 =  Calendar.getInstance();
 cDate1.add(Calendar.DATE, 180);
 print(" +180  : ", cDate1.getTime().toString());
 int compare =  cDate.getTime().compareTo(cDate1.getTime());
 print("compare :"+compare+"    cdate time after +" + numberOfDays, cDate.getTime().toString());
 String formatDate1 = new SimpleDateFormat("yyyy-MM-dd").format( cDate1.getTime());
 print(" formatDate  : ", formatDate1);

 try {
 DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 Date first = sdf.parse(formatDate);
 Date second = sdf.parse(formatDate1);
 print(" first : ", ""+formatDate) ;
 print(" second : ", ""+formatDate1) ;
 int compResult = first.compareTo(second);
 print(" compare : ", ""+compResult) ;

 }catch (ParseException e){
 e.printStackTrace();
 }




 --
 String dt = "2008-01-01";  // Start date
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 Calendar c = Calendar.getInstance();
 c.setTime(sdf.parse(dt));
 c.add(Calendar.DATE, 1);  // number of days to add
 dt = sdf.format(c.getTime());  // dt is now the new date
 --
 */

/**
 package com.tutorialspoint;
 import java.util.Calendar;

 public class CalendarDemo {

 public static void main(String[] args) {

 // create a calendar
 Calendar cal = Calendar.getInstance()

 // print current date
 System.out.println("The current date is : " + cal.getTime());

 // add 20 days to the calendar
 cal.add(Calendar.DATE, 20);
 System.out.println("20 days later: " + cal.getTime());

 // subtract 2 months from the calendar
 cal.add(Calendar.MONTH, -2);
 System.out.println("2 months ago: " + cal.getTime());

 // subtract 5 year from the calendar
 cal.add(Calendar.YEAR, -5);
 System.out.println("5 years ago: " + cal.getTime());
 }
 }



 The current date is : Thu Apr 26 02:13:28 EEST 2012
 20 days later: Wed May 16 02:13:28 EEST 2012
 2 months ago: Fri Mar 16 02:13:28 EET 2012
 5 years ago: Fri Mar 16 02:13:28 EET 2007



 package com.tutorialspoint;

 import java.util.*;

 public class DateDemo {

 public static void main(String[] args) {

 // create two dates
 Date date = new Date(98, 5, 21);
 Date date2 = new Date(99, 1, 9);

 // make 3 comparisons with them
 int comparison = date.compareTo(date2);
 int comparison2 = date2.compareTo(date);
 int comparison3 = date.compareTo(date);

 // print the results
 System.out.println("Comparison Result:" + comparison);
 System.out.println("Comparison2 Result:" + comparison2);
 System.out.println("Comparison3 Result:" + comparison3);

 }
 }

 */