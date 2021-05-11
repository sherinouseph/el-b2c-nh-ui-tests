package com.englishtown.helpers.mail;
/**
 * Configure email
 *
 * Created by nikol.marku on 02/06/2015.
 */
import com.englishtown.helpers.utils.TestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class EmailSenderConfig {
    private static   final Logger logger    = LoggerFactory.getLogger(EmailSenderConfig.class);
    protected static final String FROM      = "englishtown.b2c.qa@ef.com" ;   //"qa.et.b2c@ef.com"; //"englishtown.b2c.qa@ef.com";
    protected static final String TO_EMAIL  = "englishtown.b2c.qa@ef.com" ;
    protected static final String SMTP_HOST = "mxrelay-nv1.eflabs.io";   // for locale test run use "ht.ef.com";   //
    protected static final String SMTP_HOST_LOCAL = "ht.ef.com";
    protected static final String SMTP_USERNAME = FROM;
    protected static final String SMTP_PASS = "@Qa.Englishtown"; //qa.et.b2c@ef.com"
    protected static final String SMTP_CONNECTION = "TLS";          // Use 'TLS' or 'SSL' connection
    protected static final String PORT_TLS  = "25";
    protected static final String PORT_SSL  = "25";
    protected static final String SIGNATURE = "\n\nIf you require more information please contact nikol.marku@ef.com\n\n---------------------------\nKind Regards\nEnglishTown QA Team\n\n";
    public static    final String SCREENSHOT_DIRECTORY = TestUtil.SCREENSHOT_DIRECTORY+"email/";
    public static final boolean isEmailUserAuthenticated = false;
    public static final String SMTP_AUTH = "false"; //"true";
    // Send stats to this email grop
    public static final String STATS_GROUP = "urlstats@ef.com";

    protected static Properties getProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", SMTP_AUTH);
        props.put("mail.smtp.host", SMTP_HOST);

//        if (SMTP_CONNECTION.equals("TLS")) {
//            props.put("mail.smtp.starttls.enable", SMTP_AUTH); //true
//            props.put("mail.smtp.port", PORT_TLS);
//        } else{
//            props.put("mail.smtp.socketFactory.port", PORT_SSL);
//            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//            props.put("mail.smtp.port", PORT_SSL);
       // }
        return props;
    }

    public static Session getSession(Properties props){
        Session session = null;
        if(!isEmailUserAuthenticated) {
            session = Session.getInstance(props); // use this for no authentication
        } else {
            session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASS);
                        }
                    });
        }
        return session;
    }

    public static List<String> getFiles(String dirPath){
        List<String> results = new ArrayList();
        File[] files = new File(dirPath).listFiles(); //If this pathname does not denote a directory, then listFiles() returns null.
        for (File file : files) {
            if (file.isFile()) {
                logger.info(" filename : "+file.getName());
                results.add(file.getName());
            }
        }
        return results;
    }

    public static List<String> getFiles(String dirPath, String fileStartWith){
        List<String> results = new ArrayList();
        String tempFilename = null;
        File[] files = new File(dirPath).listFiles(); //If this pathname does not denote a directory, then listFiles() returns null. or List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        for (File file : files) {
            if (file.isFile()) {
                tempFilename = file.getName();
                if(tempFilename.startsWith(fileStartWith)) {
                    logger.info(" filename : "+tempFilename);
                    results.add(file.getName());
                }
            }
        }
        return results;
    }

    public static List<BodyPart> getAttachments( String baseDir, String folder, List<String> filenames ){
        List<BodyPart> attachmentParts=new ArrayList();
        try {
            for(String fileItem : filenames) {
                File file = new File(baseDir + folder + "/" + fileItem);
                DataSource attachment = new FileDataSource(file);
                BodyPart attachmentBodyParts=new MimeBodyPart();
                attachmentBodyParts.setDataHandler(new DataHandler(attachment));
                attachmentBodyParts.setFileName(file.getName());
                attachmentParts.add(attachmentBodyParts);
            }
        } catch (MessagingException e) {
            logger.error("MessagingException : "+e.getMessage());
        }catch (Exception e) {
            logger.error("Exception : "+e.getMessage());
        }
        return attachmentParts;
    }

    /**
     * creates email content message
     */
    public static BodyPart addMessageToEmail(List<String> messageLines){
        BodyPart messagePart=new MimeBodyPart();
        String strMessage = "";
        try{
            for(String line : messageLines) {
                strMessage = strMessage+line;
            }
            strMessage = strMessage +"\nTest executed DateTime : "+TestUtil.getCurrentTime()+"\n\n" + SIGNATURE;
            messagePart.setText(strMessage + "\n");
        }catch (Exception e){
            logger.error("Exception : "+e.getMessage());
            throw new RuntimeException(e);
        }
        return messagePart;
    }


    public static String getToEmail() {
        return TO_EMAIL;
    }

}

