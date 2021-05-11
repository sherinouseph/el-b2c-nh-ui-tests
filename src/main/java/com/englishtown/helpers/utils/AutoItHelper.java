package com.englishtown.helpers.utils;
/**
 * Created by nikol.marku on 18/04/2016.
 * Kill all chrome pressess running
 * Using AutoIt script .exe file : ProcessClose ( "chrome.exe" )
 *
 */


public class AutoItHelper {
    private static String autoItKillChromeScript = System.getProperty("user.dir")+"\\tools\\autoit\\closeChrome.exe";


    public static void killProcess(String scriptFile){
        try {
            Process process  = Runtime.getRuntime().exec(scriptFile);
            process.waitFor();
            try{ Thread.sleep(1000);}catch (InterruptedException ie){};
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getAutoitKillChromeScript() {
        return autoItKillChromeScript;
    }

    public static void setAutoitKillChromeScript(String autoitKillChromeScript) {
        AutoItHelper.autoItKillChromeScript = autoitKillChromeScript;
    }

}
