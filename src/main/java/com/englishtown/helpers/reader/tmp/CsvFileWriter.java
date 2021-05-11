package com.englishtown.helpers.reader.tmp;

/**
 * Created by nikol.marku on 05/11/2015.
 */

import com.englishtown.helpers.bean.PageStatistic;
import com.englishtown.helpers.bean.UrlMonitoringStatistics;
import com.englishtown.helpers.utils.EfDateUtils;
import com.englishtown.util.db.test.CreateEmailMonitoringStats;
import jxl.*;
import jxl.biff.DataValiditySettingsRecord;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author ashraf
 *
 */
public class CsvFileWriter {
    private static final Logger log = LoggerFactory.getLogger(CsvFileWriter.class);

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static String LastFullWeekLabel;

    //CSV file header
    private static final String FILE_HEADER = "Country,URL,LoadTime";


    /**
     * Write country, url, load time to a newly created file
     * @param urlMonitStats
     * @param fileName
     */
    public static void writeUrlMonitStatsToCsv(List<UrlMonitoringStatistics> urlMonitStats, String fileName) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);


            //Write a new url stat object list to the CSV file
            for (UrlMonitoringStatistics urlStat : urlMonitStats) {
                fileWriter.append(urlStat.getCountry());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(urlStat.getUrl());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(urlStat.getLoadTime());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            log.info("CSV file was created successfully !!!");
        } catch (Exception e) {
            log.error("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                log.error("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
    /*******************************************************************************************************************
     * For each week now add columns with loadTime to existing file
     * Add heading with week date .. week start date or start to end....
     * full path to file+filename
     * // workbook  http://www.java-tips.org/other-api-tips-100035/93-jexcel/412-how-to-create-an-excel-file.html
     *
     */
    public static void addWeeklyStatsToCsvFile(List<UrlMonitoringStatistics> urlMonitStats, String file) {
        FileWriter fileWriter = null;
        Workbook workbook = null;
        WritableWorkbook writableWorkbook = null;

        try {
            File inputWorkbook = new File(file);
            workbook = Workbook.getWorkbook(inputWorkbook); // get existing excel file
            writableWorkbook = Workbook.createWorkbook(inputWorkbook, workbook);
            WritableSheet writableSheet = writableWorkbook.getSheet(0);

            int columnsNo = writableSheet.getColumns();
            int rowsNo    = writableSheet.getRows();
            log.info("Sheet has ["+columnsNo+"]  Columns and ["+rowsNo+"] Rows ...!");

            // add header
            LastFullWeekLabel = EfDateUtils.getLastFullWeekDateRange(null);
            addCellToSheet( writableSheet , columnsNo, 0, LastFullWeekLabel );
            //Write load times in the new column created above  hopefully
            int count = 1;         // start at row 1 as row 0 has the headings
            for (UrlMonitoringStatistics urlStat : urlMonitStats) {
                try {
                    addCellToSheet( writableSheet , columnsNo, count, urlStat.getLoadTime());                    //test red cells addCellToSheet( writableSheet , 16, 3, "25.325");             addCellToSheet( writableSheet , 16, 4, "30");
                }catch (Exception e){e.printStackTrace();}
                count++;
            }

            log.info("CSV file updated with latest week data ...! Week Range : "+ LastFullWeekLabel);  //EfDateUtils.getLastFullWeekDateRange(null)
        } catch (BiffException e) {
            e.printStackTrace();
        }catch (WriteException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            log.error("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                writableWorkbook.write();
                writableWorkbook.close();
                workbook.close();
            } catch (WriteException | IOException e) {
                log.error("WriteException /IOException while write/closing workbook !!!");
                e.printStackTrace();
            }

        }
    }
//////////////

    /**
     * Write to Sheet
     * @param sheet  column   row  *
     * @throws RowsExceededException
     * @throws WriteException
     */
    private static void addCellToSheet( WritableSheet sheet, int column, int row, String content) throws RowsExceededException, WriteException {
        Label label = new Label(column, row, content);
        //set cell colour
        WritableCellFormat redBg = new WritableCellFormat();
        redBg.setWrap(true);
        redBg.setBackground(Colour.RED);        //lr = new Label(2, 19, "Grey background", greyBackground);        s1.addCell(lr);
        int isAbnormalCell = 6;
        //
        try {
            if (content.matches("[-+]?\\d*\\.?\\d+")) {
                Float value = Float.parseFloat(content);
                // check if content more than 20 and make it red if true
                if (value > isAbnormalCell) {
                    label = new Label(column, row, content, redBg);
                }
            } else {

            }
        }catch (Exception e){
            e.printStackTrace();
            log.info("Exception checking String is > 20 and make it red cell ...!");
            label = new Label(column, row, content);
        }
        sheet.addCell(label);
    }


    //////////////


    /**
     * READ data from DB test_stats table
     *
    +---------------------+------+------+-------------+----------------+--------------+-----------------------------------+----------+
    | date                | r_id | t_id | countryCode | countryName    | TestName     | url                               | loadtime |
    +---------------------+------+------+-------------+----------------+--------------+-----------------------------------+----------+
    | 2015-11-11 00:00:00 |    8 |    2 | AM          | Armenia        | UK_HomePage2 | http://www.englishtown.com/en-gb/ |   10.657 |
     *
     * NOTE what should we use : ResultSet, List etc ...????,
     */
    public static void writeUrlMonitStatsFromDbToCsv(List<UrlMonitoringStatistics> urlMonitStats, String fileName) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new url stat object list to the CSV file
            for (UrlMonitoringStatistics urlStat : urlMonitStats) {
                fileWriter.append(urlStat.getCountry());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(urlStat.getUrl());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(urlStat.getLoadTime());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            log.info("CSV file was created successfully !!!");
        } catch (Exception e) {
            log.error("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                log.error("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

}


/***
 *
 *
 *
 *
 *
 //todo
 // get data for each previous week .. first week(this is last full week ) is done
 // get 2nd and more .... weeks load time and add it to excel column
 // see http://stackoverflow.com/questions/19882205/how-to-append-existing-line-in-text-file  read line and append   .. this is total rubish should be better way
 // see http://howtodoinjava.com/2013/06/19/readingwriting-excel-files-in-java-poi-tutorial/
 //  http://www.java-tips.org/other-api-tips-100035/93-jexcel/412-how-to-create-an-excel-file.html

 File inputWorkbook = new File(file);
 Workbook workbook = Workbook.getWorkbook(inputWorkbook); // get existing excel file
 Sheet sheet = workbook.getSheet(0);                      // get first sheet
 int columnsNo = sheet.getColumns();
 int rowsNo    = sheet.getRows();
 log.info("Sheet has ["+columnsNo+"]  Columns and ["+rowsNo+"] Rows ...!");
 Cell[] headerCell = sheet.getRow(0);
 int count =0;
 log.info("Sheet Header cell ...!");
 for(Cell cell : headerCell) {
 log.info(count +" Content : "+cell.getContents());
 }


 for (int j = 0; j < sheet.getColumns(); j++) {
 for (int i = 0; i < sheet.getRows(); i++) {
 Cell cell = sheet.getCell(j, i);
 CellType type = cell.getType();
 if (type == CellType.LABEL) {
 log.info("I got a label "
 + cell.getContents());
 }
 if (type == CellType.NUMBER) {
 log.info("I got a number "
 + cell.getContents());
 }

 }
 }

 *
 for (int j = 0; j < sheet.getColumns(); j++) {
 for (int i = 0; i < sheet.getRows(); i++) {
 Cell cell = sheet.getCell(j, i);
 CellType type = cell.getType();
 if (type == CellType.LABEL) {
 log.info("I got a label "
 + cell.getContents());
 }
 if (type == CellType.NUMBER) {
 log.info("I got a number "
 + cell.getContents());
 }

 }
 }


 */

/**
 *
 public static void writeCsvFile(String fileName) {

 //Create new students objects
 Student student1 = new Student(1, "Ahmed", "Mohamed", "M", 25);
 Student student2 = new Student(2, "Sara", "Said", "F", 23);
 Student student3 = new Student(3, "Ali", "Hassan", "M", 24);
 Student student4 = new Student(4, "Sama", "Karim", "F", 20);
 Student student5 = new Student(5, "Khaled", "Mohamed", "M", 22);
 Student student6 = new Student(6, "Ghada", "Sarhan", "F", 21);

 //Create a new list of student objects
 List<Student> students = new ArrayList<Student>();
 students.add(student1);
 students.add(student2);
 students.add(student3);
 students.add(student4);
 students.add(student5);
 students.add(student6);

 FileWriter fileWriter = null;

 try {
 fileWriter = new FileWriter(fileName);

 //Write the CSV file header
 fileWriter.append(FILE_HEADER.toString());

 //Add a new line separator after the header
 fileWriter.append(NEW_LINE_SEPARATOR);

 //Write a new student object list to the CSV file
 for (Student student : students) {
 fileWriter.append(String.valueOf(student.getId()));
 fileWriter.append(COMMA_DELIMITER);
 fileWriter.append(student.getFirstName());
 fileWriter.append(COMMA_DELIMITER);
 fileWriter.append(student.getLastName());
 fileWriter.append(COMMA_DELIMITER);
 fileWriter.append(student.getGender());
 fileWriter.append(COMMA_DELIMITER);
 fileWriter.append(String.valueOf(student.getAge()));
 fileWriter.append(NEW_LINE_SEPARATOR);
 }



 System.out.println("CSV file was created successfully !!!");

 } catch (Exception e) {
 System.out.println("Error in CsvFileWriter !!!");
 e.printStackTrace();
 } finally {

 try {
 fileWriter.flush();
 fileWriter.close();
 } catch (IOException e) {
 System.out.println("Error while flushing/closing fileWriter !!!");
 e.printStackTrace();
 }

 }
 }
 **/