package com.englishtown.helpers.mail;
/**
 * Created by nikol.marku on 06/11/2015.
 */

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTest;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.mail.*;
import javax.mail.search.SearchTerm;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

// USB-MAIL7   "USB-MAIL7.ef.com"  "10.43.41.194"

public class ReadMail extends EmailSenderConfig implements IMail{
    private static final Logger logger = LoggerFactory.getLogger(ReadMail.class);

    private static long classLoadTine = System.currentTimeMillis();
    private static String urlStart = "https://qa-accounts"; // \\.ef\\.com/ui/password"; //https://qa-accounts.ef.com"; //https://";
    private static String urlContains = "https://qa-accounts";//\\.ef\\.com/ui/password"; //https://qa-accounts.ef.com"; //https://";
    private static int findEmailsFromTime = -5 ; /// find emails last 5 minutes
    public static Store store;
    public static Folder folderInbox;

    public static void close(){
        //close the store and folder objects
        logger.info("Close Emails store and inbox ...!");
        try{
            folderInbox.close(false);
            store.close();
        }catch (MessagingException ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
        }
    }

    /**
     * Find the last message from the specified time based on the subject
     * to match subject and return it  -
     * Note :> Gel the last match
     * Support live and QA
     * @param subject
     * @param host
     * @param user
     * @param password
     * @param environment
     * @param waitTimeSec
     * @param findEmailsSentAfter
     * @return
     */
    public static synchronized Message getMail(String subject, String host, String user, String password,
                                               String environment, int waitTimeSec, int findEmailsSentAfter){
        logger.info("Get forgotten pass email message ....!");
        Message[] messages = null;
        Message message = null;

        //if(StringUtils.equals(environment, "qa"))          urlStart = urlStart+"qa-";

        try {
            Session emailSession = Session.getDefaultInstance(createProps());
            //create the POP3 store object and connect with the pop server
            store = emailSession.getStore("imaps");
            store.connect(host, user, password.substring(10, 21));

            //create the folder object and open it
            folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);

            long emailsToFindAfterThisTime =  getTime(findEmailsSentAfter);

            // creates a search criterion
            SearchTerm searchCondition = new SearchTerm() {
                @Override
                public boolean match(Message message) {
                    try {
                        if (message.getSentDate().getTime() > emailsToFindAfterThisTime && message.getSubject().trim().contains(subject)  ){                           //getTime(findEmailsSentAfter) &&
                            logger.info("Found email with subject [{}]", subject);
                            /*if(message.getContent().toString().contains(urlContains)){ //contains(urlContains)) {
                                logger.info("Found url start with [{}]", urlContains);
                            }*/
                            return true;
                        }
                    }catch (MessagingException ex) {
                        ex.printStackTrace();
                        logger.error(ex.getMessage());
                    }catch (NullPointerException ex) {
                        ex.printStackTrace();
                        logger.error(ex.getMessage());
                    }
                    //catch (IOException ex) { ex.printStackTrace();    logger.error(ex.getMessage());   }
                    return false;
                }
            };

            Message[] foundMessages = null; //folderInbox.search(searchCondition);
            for(int i=0; i<waitTimeSec; i++){
                TestUtil.mySleep(2000);
                foundMessages = folderInbox.search(searchCondition);
                if(ArrayUtils.isNotEmpty(foundMessages) ){
                    logger.info("Found emails ...!");
                    break;
                } else {
                    logger.info("try again to find email ...!");
                }
                if(i == waitTimeSec-1)
                    logger.info("Failed to find emails ...!");
            }

            if(ArrayUtils.isEmpty(foundMessages) )
               // BaseTest.failTest("Cant find the email with subject ["+ subject +"]");

            logger.info("Number of emails foundMessages[{}]", foundMessages.length);

            // get last match
            for (int i = 0; i < foundMessages.length; i++) {
                message = foundMessages[i];
                String content = message.getContent().toString();
                logger.info("Found message [...!] #" + i + " content : " + content);
            }
            //close the store and folder objects
            //folderInbox.close(false);
            //store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return message;
    }
    /**
     * Mark Emails for Deletion
     * @param host
     * @param user
     * @param password
     */
    public static synchronized void deleteMails(String host, String user, String password){
        logger.info("Delete all mails in mailbox ....!");
        try {
            Session emailSession = Session.getDefaultInstance(createProps());
            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("imaps");
            store.connect(host, user, password.substring(10, 21));
            //create the folder object and open it
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_WRITE);//READ_ONLY)

            // performs search through the folder
            Message[] messages = folderInbox.getMessages();
            logger.info("Number of emails foundMessages[{}]", messages.length);
            for (Message message : messages){
                // set the DELETE flag to true
                message.setFlag(Flags.Flag.DELETED, true);
            }
            // clear folder
            folderInbox.expunge();
            //close the store and folder objects
            folderInbox.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    public static void print(Message[] messages) {
        for (int i = 0, n = messages.length; i < n; i++) {
            Message message = messages[i];
            logger.info("---------------------------------");
            logger.info("Email Number " + (i + 1));
            print(message);
        }

    }

    public static void print(Message message){
        try {
            logger.info("---------------------------------");
            logger.info("Subject: " + message.getSubject());
            logger.info("From: " + message.getFrom()[0]);
            logger.info("Text: " + message.getContent().toString());
            logger.info("Text: " + message.getFolder().getName());
        }catch (MessagingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    public static String getForgetPassUrlFromMail(Message message){
        logger.info("Get forgotten pass url from email ....!");
        String url = urlContains; //"https://qa-accounts";

        if(null == message || StringUtils.isBlank(message.toString()))
            BaseTest.failTest("Could not get any messages from email or message is empty ...!");

        try{
            String tmp = message.getContent().toString().split(urlContains)[1].split("</div")[0];
            tmp = tmp.split("\n")[0];
            url = url + tmp.trim();
            //message.getContent().toString().split("https:")[1].split(" ")[0].split(" ")[0].trim();
            logger.info(" URL [{}]", url);

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return url;
    }

    public static Properties createProps(){
        //create properties field
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        //Host Address of Your Mail
        properties.put("mail.imaps.host", "imap.gmail.com");
        //Port number of your Mail Host
        properties.put("mail.imaps.port", "993");

        return properties;
    }

    public static long getTime(int minsToAdd){
        long now = System.currentTimeMillis();
        long time = DateUtils.addMinutes(new Date(now), minsToAdd).getTime();
        logger.info(now + " current Time; add [{}] is ["+time+"]", minsToAdd);
        logger.info(" Mins added [{}] "+ ((time - now)/1000)/60);
        return time;
    }

    @Test
    public static void testMail()throws Exception{
        String resetPassUrl = ReadMail.getForgetPassUrlFromMail(ReadMail.getMail(ReadMail.PASS_RESET_EMAIL_SUBJECT,
                ReadMail.G_HOST, ReadMail.G_USERNAME, ReadMail.C, "live", 20,
                -30));
        //getTime(-5);
        //getMail(subject, G_HOST, G_USERNAME, CODE, "qa",5);
        //deleteMails(G_HOST, G_USERNAME, CODE);
    }

}


/**
 *  //if today   get setDate - Tue Dec 11 21:34:38 GMT 2018
 *  //if (message.getSentDate().compareTo(new Date(now)) < 0 &&
 if (date1.compareTo(date2) > 0) {
 System.out.println("Date1 is after Date2");
 } else if (date1.compareTo(date2) < 0) {
 System.out.println("Date1 is before Date2");
 } else if (date1.compareTo(date2) == 0) {
 System.out.println("Date1 is equal to Date2");
 } else {
 System.out.println("How to get here?");
 }

 long now = System.currentTimeMillis();
 Date date1= new Date(now);
 Thread.sleep(60000);
 long afterAMin = System.currentTimeMillis();
 logger.info(" date 1 60000 mls [{}]", System.currentTimeMillis());
 logger.info(" date after 60000 mls [{}]", System.currentTimeMillis());
 logger.info(" Dif [{}]", now - afterAMin);
 Date date2= new Date(now);
 logger.info("date1.compareTo(date2)" + date1.compareTo(date2));
 logger.info("date2.compareTo(date1)" + date1.compareTo(date2));

 DateUtils.addMinutes(date2, 5);
 logger.info("date2.compareTo(date1)" + date1.compareTo(date2));
 */