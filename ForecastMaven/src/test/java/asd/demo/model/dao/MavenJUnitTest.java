/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model.dao;

/**
 *
 * @author yujiwon
 
 * 
 */

import API.weatherAPI;
import DAO.MongoDBConnector;
import DAO.MongoDBManager;
import com.mongodb.client.MongoDatabase;

import Model.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MavenJUnitTest 
{
    MongoDBManager mongo= new MongoDBManager();
    Scanner sc = new Scanner (System.in);
    
    public MavenJUnitTest()
    {

    }
    
    @BeforeClass
    public static void setUpClass() throws UnknownHostException
    {
        System.out.println("\n<- Starting test-->");
        
    }
    
    
    
    @Test
    public void testfindAdmin()
    {
        System.out.println("test Find Admin");
        System.out.println("Input Administrator Email:");
        String email = sc.nextLine();
        System.out.println("Input Administrator password:");
        String adminpassword = sc.nextLine();
        System.out.println("Admin Email:"+ email+"Admin Password:" + adminpassword);
        mongo.findAdmin(email, adminpassword);
    
    }
    
    @Test
    public void testFindUser()
    {
        System.out.println("test Find User");
        System.out.println("Input user Email:");
        String email = sc.nextLine();
        System.out.println("Input user password:");
        String userpassword = sc.nextLine();
        System.out.println("Email:"+ email+" Password:" + userpassword);
        mongo.findUser(email, userpassword);
        
    
    }
    
    @Test
    public void testStoreLogin()
    {
        System.out.println("test Store Login");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String datetime = dtf.format(now);
        System.out.println("Input UserID:");
        int userid = sc.nextInt();
        mongo.storeLogin(userid,datetime);
    
    }
    
    @Test
    public void testStoreAdminLogin()
    {
        System.out.println("test Store Admin Login");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String datetime = dtf.format(now);
        System.out.println("Input AdminID:");
        int adminid = sc.nextInt();
        mongo.storeLogin(adminid,datetime);
    
    }
    
    @Test
    public void testStoreLogout()
    {
        System.out.println("test StoreLogout");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String datetime = dtf.format(now);
        System.out.println("Input AccesslogId:");
        int accesslogid = sc.nextInt();
        mongo.storeLogout(accesslogid, datetime);
        
    
    }
    
    @Test
    public void testFindAccessLogID()
    {
        System.out.println("test findAccessLogID");
        System.out.println("Input userId:");
        int userid = sc.nextInt();
        mongo.findAccessLogID(userid);
        
    
    }
    
    @Test
    public void testFindAdminAccessLogID()
    {
        System.out.println("test FindAdminAccessLogID");
        System.out.println("Input adminId:");
        int adminid = sc.nextInt();
        mongo.finAdmindAccessLogID(adminid);
        
    
    }
    
    @Test
        public void testSaveToWeatherHistory()
        {
            System.out.println("testSavetoWeatherHistory");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");   
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = (dateFormat.format(now));
            String time = (timeFormat.format(now));
            
            String Location = "Sydney, AU";
            int locationId= 101;
            
            weatherAPI API = new weatherAPI();
            String APIResult = API.request(Location);
            
            
            String Temperature = Integer.toString(API.getCelcius(APIResult));
            String Humidity= "" + API.getHumidity(APIResult);
            String WindSpeed= API.getWindSpeed(APIResult);
            String WindDegree = API.getWindDeg(APIResult); ;
            String Cloudy = "" + API.getCloudy(APIResult);;
            String Description = "" + API.getDescription(APIResult);
            
            
            mongo.saveToWeatherHistory(date,time,locationId,Temperature,Humidity,WindSpeed,WindDegree,Cloudy,Description);
    
        }
     
    
    @Test
    public void testSaveToUser()
    {
        System.out.println("test SaveToUser");
        
        System.out.println("Input User Email:");
        String Email = sc.nextLine();
        System.out.println("Input User Password:");
        String Password = sc.nextLine();
        System.out.println("Input User FirstName:");
        String Firstname = sc.nextLine();
        System.out.println("Input User Lastname:");
        String Lastname = sc.nextLine();
        System.out.println("Input User LocationId:");
        int locationId = sc.nextInt();
        
        mongo.saveToUser(Password, Email, Firstname, Lastname, locationId);
    
    }
    
    
    @Test
    public void testUpdateUser()
    {
    System.out.println("test Update User");

    System.out.println("Input ID:");
        int ID = sc.nextInt();
        sc.nextLine();
        
    System.out.println("Input password:");
        String password= sc.nextLine();

    System.out.println("Input email :");
        String email = sc.nextLine();

        System.out.println("Input firstName:");
        String FirstName = sc.nextLine();

        System.out.println("Input lastName:");
        String LastName = sc.nextLine();

    System.out.println("Input locationId:");
        int locationId= sc.nextInt();

    mongo.updateUser(ID,password,email,FirstName,LastName,locationId);
    }
    
    
    @Test
    public void testDeleteUser()
    {
        System.out.println("test DeleteUser");
        System.out.println("Input User UserId:");
        int userId = sc.nextInt();
        mongo.deleteUser(userId);
        
    }
    
    @Test
    public void testSaveToAdmin()
    {
        System.out.println("test testSaveToAdmin");
        System.out.println("Input Admin Email:");
        String Email = sc.nextLine();
        System.out.println("Input Admin Password:");
        String Password = sc.nextLine();
        System.out.println("Input Admin FirstName:");
        String Firstname = sc.nextLine();
        System.out.println("Input Admin Lastname:");
        String Lastname = sc.nextLine();
        
        mongo.saveToAdmin(Password, Email, Firstname, Lastname);
    
    
    }
    
    @Test
    public void testUpdateAdmin()
    {
        System.out.println("test Update Admin");

    System.out.println("Input ID:");
        int ID = sc.nextInt();
        sc.nextLine();
        
    System.out.println("Input password:");
        String password= sc.nextLine();

    System.out.println("Input email :");
        String email = sc.nextLine();

        System.out.println("Input firstName:");
        String FirstName = sc.nextLine();

        System.out.println("Input lastName:");
        String LastName = sc.nextLine();


        mongo.updateAdmin(ID,password,email,FirstName,LastName);
   
    
    }
        
    @Test
    public void testdeleteAdmin()
    {
        System.out.println("test deleteAdmin");
        System.out.println("Input AdminId:");
        int userId = sc.nextInt();
        mongo.deleteAdmin(userId);
    
    }
    
    @Test
    public void testList_Location()
    {
        LinkedList<String> list_data = new LinkedList<>();
 
        System.out.println("test Search List Location");
        System.out.println("Input Region:");
        String Search= sc.nextLine();
        list_data = (mongo.List_Location(Search));
        for(int i = 0; i < list_data.size(); i++)
        {
            System.out.println(list_data.get(i));
        }
    }
    
    
    
}
