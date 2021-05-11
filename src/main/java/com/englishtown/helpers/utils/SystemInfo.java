package com.englishtown.helpers.utils;

/**
 * Created by nikol.marku on 06/04/2016.
 *
 * use getSystemCpuLoad
 * cmd command:
 * > wmic cpu get loadpercentage
     LoadPercentage
     9
 or @for /f "skip=1" %p in ('wmic cpu get loadpercentage') do @echo %p%
 4%

 to get cpu usege for a process ues :
 > wmic path Win32_PerfFormattedData_PerfProc_Process get Name,PercentProcessorTime |  FIND "chrome"
 */

import org.apache.commons.exec.ProcessDestroyer;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.text.NumberFormat;


public class SystemInfo {
    private static final Logger logger = LoggerFactory.getLogger(SystemInfo.class);

    private Runtime runtime = Runtime.getRuntime();
    private String cmdGetProcessChromeCpu = "wmic path Win32_PerfFormattedData_PerfProc_Process get Name,PercentProcessorTime | FIND \"chrome\""; //"wmic path Win32_PerfFormattedData_PerfProc_Process get Name,PercentProcessorTime |  FIND \"chrome\"";     //wmic path Win32_PerfFormattedData_PerfProc_Process get Name,PercentProcessorTime
    private String cmdGetAllCpuLoadPercentage = "wmic cpu get loadpercentage";    // or @for /f "skip=1" %p in ('wmic cpu get loadpercentage') do @echo %p%    // wmic cpu get loadpercentage /format:value      shows it on one line %=5

    private int cpuLoadReading = 0;
    private int totalCpuLoadReading = 0;
    private int noOfCpuReads = 3;
    private int sleepTimeBetweenReadings = 1500; //sec
    private int averageCpuLoad = 0;

//
//    @Test
//    void testCpu() {
//        AutoItHelper.killProcess(AutoItHelper.getAutoitKillChromeScript());
//        //setAverageCpuLoad(getChromeAverageCpuLoad(noOfCpuReads, sleepTimeBetweenReadings));
//        /*try {
//            Process p = Runtime.getRuntime().exec(AutoItHelper.getAutoitKillChromeScript());
//            p.waitFor();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }*/
//    }
        /*
        WebDriver chrome= null;
        try{
            chrome = new ChromeRemoteWebDriver();
        } catch (Exception e){e.printStackTrace();}

        chrome.get("http://google.co.uk/?q=newton third law video");
        WebElement we = chrome.findElement(By.id("sblsbb"));
        we.click();
        we = chrome.findElement(By.cssSelector("#vidthumb2"));
        we.click();

        try {
            logger.info("SystemCpuLoad : " );
            for(int i=0; i < noOfCpuReads; i++) {
                try{ Thread.sleep(sleepTimeBetweenReadings); } catch (InterruptedException ie){}
                cpuLoadReading = getChromeCpuUsage();
                totalCpuLoadReading = totalCpuLoadReading + cpuLoadReading;

            }
            averageCpuLoad = totalCpuLoadReading / noOfCpuReads; // ignoring decimal value
            logger.info("\n\n\taverageCpuLoad is ["+averageCpuLoad+"]; Number of cpu readings performed ["+noOfCpuReads+"]" );
        }catch (Exception e){e.printStackTrace();}

        //chrome.close();
    }
    */


    /**
     *
     * @return  cpu usage as int not decimal
     */
    public int getChromeCpuUsage(){
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmdGetProcessChromeCpu);
        builder.redirectErrorStream(true);
        BufferedReader reader = null;
        int totalCpuLoad = 0;
        try {
            Process p = builder.start();
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if(StringUtils.isBlank(line)){ /*logger.info("Blank line ....!");*/}
                else {
                    logger.info("Current line :  " + line);
                    try {
                        String [] lineParts = line.split("\\s+"); // split on white space .. any n
                        String part = lineParts[1].trim(); // get cpu load
                        int tempCpuLoad = Integer.parseInt(part);
                        if( tempCpuLoad > 0) {
                            totalCpuLoad = totalCpuLoad + tempCpuLoad;
                        }
                    }catch (Exception e){ //NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e){
                        logger.error("Can't get cpu load for line :"+line+"\n"+e.getMessage());
                    }
                }
            }
            logger.info("total for this reading % : "+totalCpuLoad);
        }catch (IOException e){ logger.error("Cant get input stream : "+e.getMessage()); }
        return totalCpuLoad;
    }

    public int getChromeAverageCpuLoad(int noOfCpuReads, int sleepTimeBetweenReadings){
        logger.info("SystemCpuLoad : " );
        int averageCpuLoad = 0;
        try {
            for(int i=0; i < noOfCpuReads; i++) {
                try{ Thread.sleep(sleepTimeBetweenReadings); } catch (InterruptedException ie){}
                cpuLoadReading = getChromeCpuUsage();
                totalCpuLoadReading = totalCpuLoadReading + cpuLoadReading;
            }
            averageCpuLoad = totalCpuLoadReading / noOfCpuReads; // ignoring decimal value
            logger.info("\n\n\taverageCpuLoad is ["+averageCpuLoad+"]; \n\n\tNumber of cpu readings performed ["+noOfCpuReads+"]" );
        }catch (Exception e){e.printStackTrace();}
        return averageCpuLoad;
    }

    public int getAverageCpuLoad() {
        return averageCpuLoad;
    }

    public void setAverageCpuLoad(int averageCpuLoad) {
        this.averageCpuLoad = averageCpuLoad;
    }
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.OsInfo());
        sb.append(this.MemInfo());
        sb.append(this.DiskInfo());
        return sb.toString();
    }

    public static double getSystemCpuLoad() throws Exception {
        MBeanServer mbs    = ManagementFactory.getPlatformMBeanServer();
        ObjectName name    = ObjectName.getInstance("java.lang:type=OperatingSystem");
        AttributeList list = mbs.getAttributes(name, new String[]{ "SystemCpuLoad" });

        if (list.isEmpty())     return Double.NaN;

        Attribute att = (Attribute)list.get(0);
        Double value  = (Double)att.getValue();

        // usually takes a couple of seconds before we get real values    t
        if (value == -1.0)      return Double.NaN;
        // returns a percentage value with 1 decimal point precision
        return ((int)(value * 1000) / 10.0);
    }



    public String OSname() {
        return System.getProperty("os.name");
    }

    public String OSversion() {
        return System.getProperty("os.version");
    }

    public String OsArch() {
        return System.getProperty("os.arch");
    }

    public long totalMem() {
        return Runtime.getRuntime().totalMemory();
    }

    public long usedMem() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public String MemInfo() {
        NumberFormat format = NumberFormat.getInstance();
        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        sb.append("Free memory: ");
        sb.append(format.format(freeMemory / 1024));
        sb.append("<br/>");
        sb.append("Allocated memory: ");
        sb.append(format.format(allocatedMemory / 1024));
        sb.append("<br/>");
        sb.append("Max memory: ");
        sb.append(format.format(maxMemory / 1024));
        sb.append("<br/>");
        sb.append("Total free memory: ");
        sb.append(format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024));
        sb.append("<br/>");
        return sb.toString();

    }

    public String OsInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("OS: ");
        sb.append(this.OSname());
        sb.append("<br/>");
        sb.append("Version: ");
        sb.append(this.OSversion());
        sb.append("<br/>");
        sb.append(": ");
        sb.append(this.OsArch());
        sb.append("<br/>");
        sb.append("Available processors (cores): ");
        sb.append(runtime.availableProcessors());
        sb.append("<br/>");
        return sb.toString();
    }

    public String DiskInfo() {
        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();
        StringBuilder sb = new StringBuilder();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            sb.append("File system root: ");
            sb.append(root.getAbsolutePath());
            sb.append("<br/>");
            sb.append("Total space (bytes): ");
            sb.append(root.getTotalSpace());
            sb.append("<br/>");
            sb.append("Free space (bytes): ");
            sb.append(root.getFreeSpace());
            sb.append("<br/>");
            sb.append("Usable space (bytes): ");
            sb.append(root.getUsableSpace());
            sb.append("<br/>");
        }
        return sb.toString();
    }


}

