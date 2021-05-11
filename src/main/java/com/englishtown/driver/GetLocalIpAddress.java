package com.englishtown.driver;

import com.englishtown.pages.core.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.testng.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: nikol.marku
 * Date: 23/09/14
 * Time: 12:31
 * To change this template use File | Settings | File Templates.
 */
public class GetLocalIpAddress {
    private static final Logger logger = LoggerFactory.getLogger(GetLocalIpAddress.class);
    public static InetAddress IP;
    protected static String hostName = "";

    public static void setLocalIpAddress() {
        try {
            GetLocalIpAddress.IP = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            logger.error(" Error : GetLocalIpAddress " + e.toString());
        }
    }

    //My local pc test   IWebDriverSetting.myNodeURL
    public static boolean isMyPc(String myPcIp) {
        if (GetLocalIpAddress.IP.toString().contains(myPcIp))
            return true;
        else
            return false;
    }

    public static boolean isDevPc() {
        setHostName(getLocalHostName());
        if (hostName.contains(IWebDriverSetting.DEV_HUB_HOSTNAME))                //if (GetLocalIpAddress.IP.toString().contains(IWebDriverSetting.devHubIpAddress))
            return true;
        else
            return false;
    }
    public static boolean isLocalPc() {
        setHostName(getLocalHostName());
        if( hostName.contains(getLocalHostName()) )              // IWebDriverSetting.LOCAL_HUB_HOSTNAME if (GetLocalIpAddress.IP.toString().contains(IWebDriverSetting.devHubIpAddress))
            return true;
        else
            return false;
    }

    public static InetAddress getIP() {
        return IP;
    }

    public static void setIP(InetAddress IP) {
        GetLocalIpAddress.IP = IP;
    }


    public static String getLocalHostName() {
        String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {                                                                             //logger.error("Local Hostname can not be resolved");
            BasePage.failTest("\"Local Hostname can not be resolved, Fatal failure .... can't get HUB host name ...!");                                     //            fail("Fatal failure .... can't get HUB host name ...!") ;
        }
        logger.info("getLocalHostName() localHostName : " + hostName);

        return hostName;
    }

    public static void setHostName(String hostName){
        GetLocalIpAddress.hostName=hostName;
    }
    public static String getHostName(){
        return GetLocalIpAddress.hostName;
    }


}



//    public static void main(String[] args ){
    //USB-ETBUILD5.ef.com
//        try{
//            InetAddress IP=InetAddress.getLocalHost();
//            System.out.println(IP.toString());
//        }catch(UnknownHostException e){e.printStackTrace(); }
//
//    }



