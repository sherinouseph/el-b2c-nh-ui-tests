package com.englishtown.helpers.reader;

/**
 * Created by nikol.marku on 16/02/2015.
 */
import com.englishtown.helpers.bean.PageStatistic;
import com.englishtown.helpers.bean.UrlMonitoringStatistics;
import com.englishtown.helpers.bean.User;
import com.englishtown.helpers.reader.tmp.CsvFileWriter;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.util.db.core.DbManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReadWriteToFile {
    private static final Logger log = LoggerFactory.getLogger(ReadWriteToFile.class);
    private static final String lineSeparator = System.getProperty("line.separator");
    public static String statisticsFile;// full path to stats file setup when file is created
    public static String csvFilePath  = "C:/work/pagespeed/stats/";
//test
 //   public static void main(String[] srgs) {
          //createStatsCsvFile();
 //   }

    /**
     * A txt file with URL and load time is the starting point. first line is url and second is load time
     *   e.g
        	http://englishlive.ef.com/es-co/
            Page load time: 8.85s
     * 1. create a text file and place url and load time in one line e.g 	http://www.englishtown.com/en-us/ 	:   5.15s
     * 2. create a list of UrlMonitoringStatistics from the above file
     * 3. Write the list to the file.csv
     */
    public static void createStatsCsvFile(){
        //get this as params
        String mainMailStatsfileTxt  = "C:/work/pagespeed/mailtext/mailstats.txt";
        String statsfile             = "C:/work/pagespeed/temp/urlMonitoringStats.txt";
        String csvFilePath           = "C:/work/pagespeed/stats/";
        String csvFileName           = TestUtil.generateRandomFilename()+"_urlMonitoringStats.csv";
        Path path = Paths.get(mainMailStatsfileTxt);
        Path statsPath = Paths.get(statsfile);
        Path csvPath = Paths.get(csvFilePath+csvFileName);
        writeListToFile(readFile(path), statsPath);
        CsvFileWriter.writeUrlMonitStatsToCsv(readUrlMonitStatsFromFile(statsPath), csvFilePath+csvFileName );

    }
    public static void createStatsCsvFromDB(List<UrlMonitoringStatistics> stats){
        //String csvFileName = TestUtil.generateRandomFilename()+"_db_urlMonitoringStats.csv";
        String csvFileName = "BaseUrlMonitStats97.xls"; // existing file
        Path csvPath = Paths.get(csvFilePath+csvFileName);
        statisticsFile = csvFilePath+csvFileName;
        log.info("Statistics file path : "+csvFilePath+csvFileName);
        if(stats.isEmpty() || stats != null) {
            CsvFileWriter.addWeeklyStatsToCsvFile(stats, statisticsFile);        // CsvFileWriter.writeUrlMonitStatsToCsv(stats, csvFilePath + csvFileName);
        }else {
            log.warn("Could not generate excel file as Stats object is empty or null ...!");
        }
    }

    /************************************************
     * Read from file and return a list of urls stats
     ***********************************************/
    public static List<UrlMonitoringStatistics> readUrlMonitStatsFromFile(Path filePath){
        log.info(" Read from File : "+filePath);
        List<UrlMonitoringStatistics> stats = new ArrayList();
        UrlMonitoringStatistics urlStat = null;
        InputStream in;

        try {
            in = Files.newInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            int lineCount=0;
            int currentLineNo=0;
            while ( (line = reader.readLine()) != null ){
                if(!line.isEmpty()) {
                    try {
                        log.info(" Line No : " + currentLineNo + " - DATA  read- '" + line + "'");
                        String[] lineParts = line.split(" :\t");
                        String url = lineParts[0].trim();
                        String country = TestUtil.getCountryAllFromUrl(url);
                        String loadTime = lineParts[1].trim();
                        urlStat = new UrlMonitoringStatistics(country, url, loadTime);
                    }catch (ArrayIndexOutOfBoundsException e){
                        e.printStackTrace();
                    }
                    log.info("stat created : "+urlStat.toString());
                    stats.add(urlStat);

                    currentLineNo=lineCount+1;
                }
                lineCount++;
            }
            log.info(" Total Line No : "+currentLineNo);
        } catch (IOException e) {
            log.error("readFromFile exception : "+e.getCause());
        }
        return stats;
    }
    /**
     * read from file and put 2 lines in one .. monitoring stats file  one line has url and second has the time out
     * @param filePath
     * @return
     */
    public static List<String> readFile(Path filePath){
        log.info(" Read from File : "+filePath);
        List<String> fileData = new ArrayList();

        InputStream in;

        try {
            in = Files.newInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            //List<String> lines = new ArrayList<>();
            String line = null;
            int lineCount=0;
            int currentLineNo=0;
            String firstLine="";
            String secondLine="";
            while ( (line = reader.readLine()) != null ){
                //ignore first 2 lines lineCount > 1 &&    if ( (x % 2) == 0 ) { even... } else { odd... }
                if(!line.isEmpty()) {
                    if((currentLineNo % 2) ==0){
                        // even  so is URL                        log.info(" even ...! : "+line);
                        firstLine=line;
                    } else {
                        //odd so is load time Time                        log.info(" odd ...! : "+line);
                        secondLine=line.split(":")[1];
                        fileData.add(firstLine+" :\t "+secondLine);
                    }
                    currentLineNo=lineCount+1;

                    //log.info(" Line No : "+currentLineNo+" - DATA  read- '" + line+"'");
                    if(lineCount > 0)
                    log.info(" URL: "+firstLine+" \t" + secondLine+"'");
//                    fileData.add(line);
                }
                lineCount++;
            }
            log.info(" Total Line No : "+currentLineNo);
        } catch (IOException e) {
            log.error("readFromFile exception : "+e.getCause());
        }
        return fileData;
    }


    /*********************************************************************
     * Get user.dir [this is project dir, e.g C:\work\project\qa
     * and Remove project dear from path
     * @return new path e.g C:\work\project\
     ********************************************************************/
    public static String getTestUserFilePath(){
        String newPath = "";
        int count = 0;
        try {
            String path = System.getProperty("user.dir");
            log.info(" user.dir : '" + path + "'");
            String[] pathParts = path.split("\\\\");
            int length = pathParts.length;
            for (String s : pathParts) {
                count++;
                if (count < length)
                    newPath = newPath + s + "\\";
            }
        }catch (Exception e){
            log.error(" getTestUserFilePath  Exception : "+e.getCause());
        }   log.info(" BASE Test users File location : '" + newPath + "'");

        return newPath;
    }
    /************************************************
     * Read from file and return a list of users
     ***********************************************/
    public static List<PageStatistic> readStats(Path filePath){
        log.info(" Read PageStatistic from File : "+filePath);
        List<PageStatistic> pageStatisticList = new ArrayList();
        PageStatistic pageStatistic = null;
        InputStream in;

        try {
            in = Files.newInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            int lineCount=0;
            int currentLineNo=0;
            while ( (line = reader.readLine()) != null ){
                //ignore first line
                if(lineCount > 0 && !line.isEmpty()) {
                    currentLineNo=lineCount+1;
                    //log.info(" Line No : "+currentLineNo+" - DATA  read- '" + line+"'");
                    pageStatistic = new PageStatistic(line.toString());
                    pageStatisticList.add(pageStatistic);
                }
                lineCount++;
            }
            log.info(" Total Line No : "+currentLineNo);
        } catch (IOException e) {
            log.error("readFromFile exception : "+e.getCause());
        }
        return pageStatisticList;
    }
    /************************************************
     * Read from file and return a list of users
     ***********************************************/
    public static List<User> readFromFile(Path filePath){
        log.info(" Read from File : "+filePath);
        List<User> userList = new ArrayList<User>();
        User user = null;
        InputStream in;

        try {
            in = Files.newInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            //List<String> lines = new ArrayList<>();
            String line = null;
            int lineCount=0;
            int currentLineNo=0;
            while ( (line = reader.readLine()) != null ){
                //ignore first 2 lines
                if(lineCount > 1 && !line.isEmpty()) {
                    //lines.add(line);
                    currentLineNo=lineCount+1;
                    log.info(" Line No : "+currentLineNo+" - DATA  read- '" + line+"'");
                    user = new User(line);
                    userList.add(user);
                }
                lineCount++;
            }
            log.info(" Total Line No : "+currentLineNo);
        } catch (IOException e) {
            log.error("readFromFile exception : "+e.getCause());
        }
        return userList;
    }

    /************************************************
     * Read from file and return a user details based
     * on the file line number
     ***********************************************/
    public static User findUser(Path filePath, int lineNo){
        log.info(" findUser lineNO :"+lineNo+"\n File :"+filePath);
        User user = null;
        InputStream in;
        try {
            in = Files.newInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            int lineCount=0;
            int currentLineNo=0;
            while ( (line = reader.readLine()) != null ){
                if(lineCount > 1 && !line.isEmpty()) {
                    if (lineNo == lineCount + 1) {
                        if(validateLineData(line)) {
                            user = new User(line);
                            user.printUser();
                        }
                    }
                }
                lineCount++;
            }
        } catch (IOException e) {
            log.error("readFromFile exception : "+e.getCause());
        }
        return user;
    }

    /************************************************
     * Return user details based on the search result
     * Search term market, return first match
     ***********************************************/
    public static User findUser(Path filePath, String market){
        log.info(" findUser for market :"+market+"\n File :"+filePath);
        User user = null;
        InputStream in;
        try {
            in = Files.newInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            String[] item = null;
            int lineCount=0;
            int currentLineNo=0;
            while ( (line = reader.readLine()) != null ){
                if(lineCount > 1 && !line.isEmpty()) {
                    item = line.split(",");
                    if(item.length > 3){                         // data should be OK
                        if(market.equals(item[3].trim())){       // third index is the market
                            if(validateLineData(line)) {
                                user = new User(line);
                                user.printUser();
                                break;
                            }
                        }
                    }
                }
                lineCount++;
            }
        } catch (IOException e) {
            log.error("readFromFile exception : "+e.getCause());
        }
        if(user == null){log.warn(" Did not find any user for market : "+market);}
        return user;
    }

    public static Path getFileLocation(String projectLocation, String relativePath, String fileName){
        Path filePath = FileSystems.getDefault().getPath(projectLocation, relativePath, fileName);
        return filePath;
    }

    public static synchronized void appendAlineToFile(String line, Path path) {
        log.info(" Try to appendAlineToFile : " + line);
        BufferedWriter writer = null;
        // Validate line
        if(validateLineData(line)) {
            try {
                // this will create a new file if cant find the filename
                writer = new BufferedWriter(new FileWriter(path.toString(), true));
                writer.write(lineSeparator + line);
                log.info(" Appended line To File : " + line);
            } catch (IOException e) {
                log.error(" IOException : " +e.getMessage());
            } finally {
                try {
                    if (writer != null)
                        writer.close();
                } catch (IOException e) {
                    log.error(" IOException : " + e.getCause());
                }
            }
        } else {
            log.error(" Did not write to file : Line data is not valid : "+line);
        }
    }

    /**
     * Validate data is valid for a line;
     *
     * e.g line = userEmail+","+memberId+","+getENVIRONMENT()+","+market;
     */
    protected static boolean validateLineData(String line){
        boolean isValid = true;
        String[] lineItem = line.split(",");

        if(lineItem.length > 3) {
            for(int i=0; i<4; i++){ // check only first 4 elements
                if (!isDataValid(lineItem[i])){
                    log.warn(i+" : Line item is not valid : "+lineItem[i]);
                    return false;
                }
            }
        } else {
            log.warn(" : Line items NOT enough Less that 4: " + lineItem.length);
            return false;
        }
        return isValid;
    }

    /**
     * All should be true
     * Should not be empty/null and not set to 'notinit'
     */
    protected static boolean isDataValid(String dataItem){
        boolean isEmtyOrNull          = false;
        boolean isDataContain_notinit = false;
        dataItem = dataItem.trim();

        if(StringUtils.isBlank(dataItem) && StringUtils.isEmpty(dataItem)){
            isEmtyOrNull=true;
            log.warn(" isDataValid() isEmtyOrNull : " + isEmtyOrNull);
            return false;
        }
        if(dataItem.contains("notinit")){
            isDataContain_notinit=true;
            log.warn(" isDataValid('"+dataItem+"') contains 'notinit'  : " + isDataContain_notinit);
            return false;
        }
        log.info(" isDataValid('"+dataItem+"') - isEmtyOrNull  : "+isEmtyOrNull);
        log.info(" isDataValid() contains(notinit) : "+isDataContain_notinit);

        if(!isEmtyOrNull && !isDataContain_notinit ) {
            return true;
        }else
            return false;
    }



    /**
     * Current content of file is replaced with the new one
     * @param lines
     * @param filePath
     */
    public static void writeListToFile(List<String> lines, Path filePath){
        BufferedWriter writer = null;
        int count = 0;
        try {
            writer = new BufferedWriter(new FileWriter(filePath.toString(), false));
            for(String line : lines){
                writer.write(line+lineSeparator);
            }
        } catch (IOException e) {
            log.error(" IOException : " + e.getCause());
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                log.error(" IOException : " + e.getCause());
            }
        }
    }

    /**
     * Remove a line from file
     * As user subscription has been canceled
     */
    //NOTE currently not handling more than one match
    public static List<String> getFileLines(String searchTerm, Path filePath){
        log.info(" remove_A_LineFromFile : ");
        List<String> lines = null ;
        InputStream in;
        boolean isAddToList = true;

        try {
            in = Files.newInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            lines = new ArrayList<>();
            String line = null;
            int lineCount=0;
            int currentLineNo=0;

            while ( (line = reader.readLine()) != null ){
                //ignore first 2 lines
                if(!line.isEmpty()) {
                    currentLineNo=lineCount+1;
                    log.info(" Line No : "+currentLineNo+" - DATA  read- '" + line+"'");
                    if(line.contains(searchTerm)){
                        log.info(" Found line : "+line+"  : Contains search Term :"+searchTerm);
                        isAddToList = false;
                    } else {
                        isAddToList = true;
                        lines.add(line);
                        log.info(" add line : "+line);
                    }
                }
                lineCount++;
            }
            log.info(" Total Line No : "+currentLineNo);
        } catch (IOException e) {
            log.error("readFromFile exception : "+e.getCause());
        }
        return lines;
    }

    /**
     * Store user information on text file
     * Test cases should set the user data
     * Tear down will write it on the file if isStoreData = true
     */
    /*public static synchronized void storeData(boolean isStoreData, String userEmail, String memberId,
                                                                                String environment, String market ) {
        if(isStoreData){
            log.info("Store Data to location :"+TestUtil.userFilePath);
            String line = userEmail+","+memberId+","+environment+","+market;
            ReadWriteToFile.appendAlineToFile(line, TestUtil.userFilePath);
            log.info("stored User Data ...!");
        } else {
            log.info("No user data is stored to file ");
        }
    }*/

    public static synchronized void storeData(boolean isStoreData, String userEmail, String memberId, String orderId,
                                              String environment, String market ) {
        if(isStoreData){
            log.info("Store Data to location :"+TestUtil.userFilePath);
            String line = userEmail+", memberId:"+memberId+", orderId:"+orderId+", environment:"+environment+", market:"+market;
            ReadWriteToFile.appendAlineToFile(line, TestUtil.userFilePath);
            log.info("stored User Data ...!");
        } else {
            log.info("No user data is stored to file ");
        }
    }

    public static synchronized void storeDataNewHouse(boolean isStoreData, String userEmail, String efId, String orderId,
                                              String environment, String market ) {
        if(isStoreData){
            log.info("Store Data to location :"+TestUtil.userFilePath);
            String line = userEmail+", efId:"+efId+", orderId:"+orderId+", environment:"+environment+", market:"+market;
            ReadWriteToFile.appendAlineToFile(line, TestUtil.userFilePath);
            log.info("stored User Data ...!");
        } else {
            log.info("No user data is stored to file ");
        }
    }

    /**
     * Delete last line in a file
     */
    public static void deleteFileLastLine(String file){
        String lastLine = null;
        try {
            RandomAccessFile f = new RandomAccessFile(file, "rw");
            long length = f.length() - 1;
            log.info("length :"+length);
            byte b;
            do {
                length -= 1;
                f.seek(length);
                b = f.readByte();
            } while (b != 10 && length > 0);
            lastLine = f.readLine().trim();
            log.info("last line :'"+lastLine+"'");
            if("]".equals(lastLine)) {
                if (length == 0) {
                    f.setLength(length);
                } else {
                    f.setLength(length + 1);
                }
                log.info("Deleted last line ...!");
            } else {
                log.warn("Did not delete last line ...!; Last line content is not =']'");
            }
        }catch (Exception e){
            log.error(TestUtil.getException(e));
        }
    }

    /**
     * Create file if does not exist
     * @param file
     */
    public static void createFile(File file){
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        }catch (IOException e){
            log.error(e.getMessage());
        }
    }


    /**
     * Write/overite to file. File will be overridden  every time this is run
     * @param content
     * @param pathAndFileName
     */
    public static void writeSmallTextFile(String content, String pathAndFileName){
        try {
            final File file = new File(pathAndFileName);
            FileUtils.writeStringToFile(file, content, "UTF-8");
            log.info("Write to file :"+content);
        }catch (IOException e){
            log.info("Can not write to file ....!");
            e.printStackTrace();
        }
    }
    public static String readFileFirstLine(String filePath) throws NullPointerException{
        String content = null;
        try{
            Path path = Paths.get(filePath);
            BufferedReader reader = Files.newBufferedReader(path);
            System.out.println(reader.readLine());
        }catch (IOException e){
            log.error("Can't Read from file ....!");
            e.printStackTrace();
        }
        return content;
    }



}