package com.englishtown.helpers.mail;
/**
 * Send email
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class SendMail extends EmailSenderConfig {
    private static final Logger logger = LoggerFactory.getLogger(SendMail.class);

    /**
     * Send email with text and attachments- attachment are read from a folder
     */
    public static void sendMail(String toAddress, String subject, List<String> message, String fileLocation, String imageFolder, List<String> filename) throws Exception{
        Properties props = getProperties();
        Session session =getSession(props);

        try {
            Message msg = new MimeMessage(session);
            Multipart multiPart=new MimeMultipart();
            BodyPart messagePart;//= new MimeBodyPart();
            msg.setFrom(new InternetAddress(FROM, "QA Englishtown"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toAddress, "Mr. Recipient"));
            msg.setSubject(subject);
            // set text
            messagePart = addMessageToEmail(message );
            multiPart.addBodyPart(messagePart);
            // set attachment
            List<BodyPart> attachementParts = getAttachments(fileLocation, imageFolder, filename );
            for(BodyPart part : attachementParts){
                multiPart.addBodyPart(part);
            }
            msg.setContent(multiPart);
            Transport.send(msg);
            logger.info("Email sent successfully...");
        } catch (AddressException e) {
            e.printStackTrace();
            logger.error("AddressException : "+e.toString());            //throw new RuntimeException(e);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("MessagingException : "+e.toString());
        }catch (IOException e) {
            e.printStackTrace();
            logger.error("IOException : "+e.toString());
        }
    }
    // test
    public static void sendMail(String toAddress, String subject, String message, File fileToAttach){
        Properties props = getProperties();
        Session session =getSession(props);

        try {
            Message msg = new MimeMessage(session);
            Multipart multiPart=new MimeMultipart();
            BodyPart messagePart = new MimeBodyPart();
            msg.setFrom(new InternetAddress(FROM, "QA Englishtown"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toAddress, "Mr. Recipient"));
            msg.setSubject(subject);
            // set text
            messagePart.setText(message);
            multiPart.addBodyPart(messagePart);
            // set attachment

            DataSource attachment = new FileDataSource(fileToAttach);
            BodyPart attachmentBodyParts =new MimeBodyPart();
            attachmentBodyParts.setDataHandler(new DataHandler(attachment));
            attachmentBodyParts.setFileName(fileToAttach.getName());

            multiPart.addBodyPart(attachmentBodyParts);

            msg.setContent(multiPart);
            Transport.send(msg);
            logger.info("Email sent successfully...");
        } catch (AddressException e) {
            e.printStackTrace();
            logger.error("AddressException : "+e.toString());            //throw new RuntimeException(e);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("MessagingException : "+e.toString());
        }catch (IOException e) {
            e.printStackTrace();
            logger.error("IOException : "+e.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception : "+e.toString());
        }
    }

    public static void sendMail(String toAddress, String subject, String message){
        Properties props = getProperties();
        Session session =getSession(props);

        try {
            Message msg = new MimeMessage(session);
            Multipart multiPart=new MimeMultipart();
            BodyPart messagePart = new MimeBodyPart();
            msg.setFrom(new InternetAddress(FROM, "QA Englishtown"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toAddress, "Mr. Recipient"));
            msg.setSubject(subject);
            // set text
            messagePart.setText(message);
            multiPart.addBodyPart(messagePart);


            msg.setContent(multiPart);
            Transport.send(msg);
            logger.info("Email sent successfully...");
        } catch (AddressException e) {
            e.printStackTrace();
            logger.error("AddressException : "+e.toString());            //throw new RuntimeException(e);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("MessagingException : "+e.toString());
        }catch (IOException e) {
            e.printStackTrace();
            logger.error("IOException : "+e.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception : "+e.toString());
        }
    }
}