/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  
package API;

import java.util.*;
import java.util.logging.*;
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.*;
import javax.mail.internet.*;

public class weatherAlertMail {
static { System.setProperty("https.protocols", "TLSv1.2"); }

   public static void SendMail(String receipent, String msg) 
   {    
       final String email = "utsasdgroup3@yahoo.com";
       final String password = "giwigsxrxehkawjb";
       
       System.out.println("Preparing Email");

       Properties prop = new Properties(); 
       prop.put("mail.smtp.auth", "true");
       prop.put("mail.smtp.host", "smtp.mail.yahoo.com");
       prop.put("mail.smtp.port", "587");
       prop.put("mail.smtp.starttls.enable", "true");
       
       prop.put("mail.debug", "true");
       
       String cc = "13340409@student.uts.edu.au";
       
       Session s = Session.getInstance(prop, new javax.mail.Authenticator()       
       {
           protected PasswordAuthentication getPasswordAuthentication()
           {
               return new PasswordAuthentication(email,password);
           }
       });
        Message message = WeatherMessage(s,email,receipent,cc,msg);
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
   
    private static Message WeatherMessage(Session session, String email, String recepient,String cc, String msg)
   {
       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(email));
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           message.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
           message.setSubject("Weather"); //Set your Subject
           message.setText(msg); //Set your Text
           message.setText("It's raining. Take your umbrella");
           System.out.println("TEST2");
           return message;
       } catch (Exception ex) {
           Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
}
