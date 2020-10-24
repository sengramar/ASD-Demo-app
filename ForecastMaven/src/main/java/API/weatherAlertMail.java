/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  
package API;

import Model.User;
import java.util.*;
import java.util.logging.*;
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class weatherAlertMail{
static { System.setProperty("https.protocols", "TLSv1.2"); }

   public static void SendMail(LinkedList<User> receipent, String msg)//Add msg
   {    
       final String email = "utsasdgroup3@yahoo.com"; //Change
       final String password = "lrkglwhjqsmmyhpb"; //Change
       
       System.out.println("Preparing Email");

       Properties prop = new Properties(); 
       prop.put("mail.smtp.auth", "true");
       prop.put("mail.smtp.host", "smtp.mail.yahoo.com"); //Change
       prop.put("mail.smtp.port", "587");
       prop.put("mail.smtp.starttls.enable", "true");

       prop.put("mail.debug", "true");

       String description ="";
       
       Session s = Session.getInstance(prop, new javax.mail.Authenticator()       
       {
           protected PasswordAuthentication getPasswordAuthentication()
           {
               return new PasswordAuthentication(email,password);
           }
       });
//     
        Message passmessage = WeatherMessage(s,email,receipent,msg);
       System.out.println("TEST1");
       try {
           System.out.println("Prepareing");
           Transport.send(passmessage); //Eunseo
           System.out.println("Message sent successfully");
       }catch (Exception ex) {
           Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
   
   
    private static Message WeatherMessage(Session session, String email, LinkedList<User> recepient, String msg)
   {
       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(email));
           
           InternetAddress[] remail = new InternetAddress[recepient.size()];
           for(int i = 0; i<recepient.size (); i++)
           {
                remail[i] = new InternetAddress(recepient.get(i).getEmail());
           }

           message.setRecipients(Message.RecipientType.TO,remail);

           message.setSubject("Weather Notification"); //Set your Subject
           message.setText(msg);
           return message;
       } 
       catch (Exception ex) 
       {
           Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
}
