package API;

import java.util.*;
import java.util.logging.*;
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.*;
import javax.mail.internet.*;

public class Mail {
static { System.setProperty("https.protocols", "TLSv1.2"); }

   public static void SendMail(String receipent, String msg) 
   {    
       final String email = "utsasdgroup3@yahoo.com";
       final String password = "giwigsxrxehkawjb";
       
//       final String email = "utsasdgroup3@gmail.com";//utsasdgroup3@gmail.com
//       final String password = "utsasdgroup3";//utsasdgroup3
       System.out.println("Preparing Email");

       Properties prop = new Properties(); 
       prop.put("mail.smtp.auth", "true");
       prop.put("mail.smtp.host", "smtp.mail.yahoo.com");
//       prop.put("mail.smtp.host", "smtp.gmail.com");
       prop.put("mail.smtp.port", "587");
       prop.put("mail.smtp.starttls.enable", "true");
       
       //prop.put("mail.smtp.tls.trust","*");
       prop.put("mail.debug", "true");
       
//       String email = "utsasdgroup3@yahoo.com";
//       String password = "publicaccount";
       
       String cc = "13340260@student.uts.edu.au";
       String description ="";
       
       Session s = Session.getInstance(prop, new javax.mail.Authenticator()       
       {
           protected PasswordAuthentication getPasswordAuthentication()
           {
               return new PasswordAuthentication(email,password);
           }
       });
//       Message message = prepareMessage(s,email,receipent,cc);
        Message message = PasswordMessage(s,email,receipent,cc,msg);
       System.out.println("TEST1");
       try {
           System.out.println("Prepareing");
           Transport.send(message);
           System.out.println("Message sent successfully");
       }catch (Exception ex) {
           Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
   
   private static Message prepareMessage(Session session, String email, String recepient,String cc)
   {
       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(email));
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           message.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
           message.setSubject("testing email"); //Set your Subject
           message.setText("TESTING INI EMAIL TESTING"); //Set your Text
           return message;
       } catch (Exception ex) {
           Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
   
    private static Message PasswordMessage(Session session, String email, String recepient,String cc, String msg)
   {
       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(email));
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           message.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
           message.setSubject("Get Your Temprary Password"); //Set your Subject
           String description ="";
           description += "<h3>Hello<h3>";
           description += "<h4>Your username is <h4>" + recepient;
           description += msg;
           description += "<p>Please update your password after receiving the temporary password.p>";
//           message.setHtmlMsg(description);
           message.setText("Hello \rYour username is " + recepient + "\r" +msg + "\r\r" + "Please update your password after receiving the temporary password."); //Set your Text
           return message;
       } catch (Exception ex) {
           Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
}