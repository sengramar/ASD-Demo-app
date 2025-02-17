package DAO;
import Model.*;
import java.util.*;
import java.util.regex.Pattern;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
/**
 *
 * @author ASUS
 */
public class MongoDBManager 
{
    //from MongoDBConnector
    MongoDBConnector Mongo = new MongoDBConnector();
    private MongoDatabase db = Mongo.DBConnect();
    private List<Document> PostList = new ArrayList();
    private List<Document> logList = new ArrayList();
    //list all table name 
    MongoCollection<Document> users = db.getCollection("Users");
    MongoCollection<Document> admins = db.getCollection("Administrator");
    MongoCollection<Document> accesslog = db.getCollection("AccessLog");
    MongoCollection<Document> location = db.getCollection("Location");
    //MongoCollection<Document> WeatherHistory = db.getCollection("WeatherHistory");
    MongoCollection<Document> History = db.getCollection("History");
      
    

    public void saveToWeatherHistory(String Date, String Time, int LocationId, String Temperature,String Humidity,String WindSpeed,String WindDegree, String Cloudy,String Description ) 
    {
        int ID = returnID(History, "weatherID");
        PostList.clear();

        PostList.add(new Document
        ("weatherID", ID).append("Date", Date).append("Time", Time).append("location ID",Integer.toString(LocationId))
        .append("Temperature",Temperature).append("Humidity",Humidity).append("Wind speed",WindSpeed)
        .append("Wind direction",WindDegree).append("Cloudy",Cloudy).append("danger level",Description)
        );
        
        History.insertMany(PostList);
    }   

    public LinkedList<String> List_Location(String Search) 
    {
    LinkedList<String> list_data = new LinkedList<String>(); 
    Document SearchBSON = new Document("Region", Pattern.compile(".*"+Search.trim()+".*"));//WHERE LIKE 'SEARCH%'
     for (Document doc : location.find(SearchBSON).sort(new BasicDBObject("LocationId",1)))//from location + In ascending order (Change 1 to -1 for Desc order)
     {
        list_data.add((String) doc.get("LocationId"));
        list_data.add((String) doc.get("Country"));
        list_data.add((String) doc.get("State"));
        list_data.add((String) doc.get("Region"));
        //SELECT ALL 
    }
        return list_data;
    }   
    public Location findLoc(int LocationId) 
    {               
        Document SearchBSON = new Document("LocationId", Integer.toString(LocationId));//WHERE LIKE 'SEARCH%'
        for (Document doc : location.find(SearchBSON))
        {
            String Country =(String) doc.get("Country");
            String Region = (String) doc.get("Region");
            String State = (String) doc.get("State");
            //you need to get all the data
            Location currentLocation = new Location(LocationId, Country, State, Region);
            return currentLocation;
        }
        return null;
    }
    
    public User findUser(String Email, String User_Password) 
    {
        int userId, locationId;
        String user_password, email, firstname,lastname;
        User newUser;
        Document WhereDocs = new Document("email", Email).append("user_password", User_Password);
        for (Document doc : users.find(WhereDocs))
        {
            userId = ((Integer) doc.get("userID"));
            locationId = ((Integer) doc.get("locationID"));
            user_password = ((String) doc.get("user_password"));
            email =((String) doc.get("email"));
            firstname =((String) doc.get("firstName"));
            lastname = ((String) doc.get("lastName"));
            //you need to get all the data
            newUser = new User(userId, locationId, user_password, email, firstname, lastname);
            return newUser;
        }
        return newUser = null;
    }

    public Administrator findAdmin(String Email, String AdminPassword) {
        String email, adminPassword, firstname, lastname;
        int adminId;
        Administrator newAdmin;
        Document admin = new Document("email", Email).append("adminpassword", AdminPassword);
         System.out.println(admin.toString());

        for (Document doc : admins.find(admin)) 
        {

            email = (String) doc.get("email");
            adminPassword= (String) doc.get("adminpassword");
            adminId= (Integer) doc.get("adminId");
            firstname= (String) doc.get("firstname");
            lastname= (String) doc.get("lastname");
            
            newAdmin = new Administrator(adminId, adminPassword, email, firstname, lastname);
            return newAdmin;   
        }
        return newAdmin=null;
    }
     
    public void storeLogin(int AccessId, int userId, String loginDateTime) {
        int accesslogId = AccessId;
        logList.clear();
        logList.add(new Document("accesslogId", accesslogId).append("userId", userId).append("loginTime", loginDateTime).append("logoutTime", null));
        accesslog.insertMany(logList);
    }
    
    public void storeAdminLogin(int AccessId, int adminId, String loginDateTime) {
        int accesslogId = AccessId;
        logList.clear();
        logList.add(new Document("accesslogId", accesslogId).append("adminId", adminId).append("loginTime", loginDateTime).append("logoutTime", null));
        accesslog.insertMany(logList);
    }
    
      public void storeLogout(int accesslogId, String logoutDateTime) 
      {
	Document loghistory = new Document("accesslogId", accesslogId);
        Document logouthistory = new Document("$set",new Document("logoutTime",logoutDateTime));
        accesslog.updateOne(loghistory,logouthistory);
      }
    
    public int findAccessLogID(int userId) {
        int id;
        String logoutTime;
        Document history =  new Document("userId", userId).append("logoutTime", null);
        for (Document doc : accesslog.find(history)) {
            userId = (int) doc.get("userId");
            logoutTime= (String) doc.get("logoutTime");
            id = (int) doc.get("accesslogId");
            return id;
        }
        return 0;
    }
    
    public int finAdmindAccessLogID(int adminId) {
        int id;
        String logoutTime;
        Document history =  new Document("adminId", adminId).append("logoutTime", null);
        for (Document doc : accesslog.find(history)) {
            adminId = (int) doc.get("adminId");
            logoutTime= (String) doc.get("logoutTime");
            id = (int) doc.get("accesslogId");
            return id;
        }
        return 0;
    }
    
    public int returnID(MongoCollection<Document> CollectionName, String ParameterID)
    {
        List currentId = new ArrayList();
        for (Document doc : CollectionName.find()) 
        {
            currentId.add((int) doc.get(ParameterID));
        }
        if(currentId.isEmpty())
        {
            return 1;
        }
        else
        {
            int ID = (int)Collections.max(currentId) + 1;
            return ID;
        }
        
    }

    public void updateUser(int id, String password, String email, String firstname, String lastname, int location) 
    {

        //int ID = returnID(users, "userID");
        //int ID = user.getId();
        PostList.clear();
       
        Document where = new Document("userID", id);
        
        //Document value = new Document("$set", new Document("user_password", password));
        //Document value = new Document("userID", id).append("user_password", password).append("email", email).append("firstName",firstname)
        //.append("lastName",lastname).append("locationID",location);
        
        Document value = new Document("$set", new Document("user_password", password).append("email", email).append("firstName",firstname)
        .append("lastName",lastname).append("locationID",location));
        users.updateOne(where, value);
    }

    
    public void deleteUser(int id)
    {
        users.deleteOne(Filters.eq("userID",id));
    }
	
	public void saveToUser(String Password, String Email, String Firstname, String Lastname, int LocationId) 
    {
        int ID = returnID(users, "userID");
        PostList.clear();
        PostList.add(new Document
        ("userID", ID).append("user_password", Password).append("email", Email).append("firstName",Firstname)
        .append("lastName",Lastname).append("locationID", LocationId)
        );
        
        users.insertMany(PostList);
    } 
        
        
         public void updateAdmin(int id, String password, String email, String firstname, String lastname) 
    {

        //int ID = returnID(users, "userID");
        //int ID = user.getId();
        PostList.clear();
       
        Document where = new Document("adminId", id);
        
        //Document value = new Document("$set", new Document("user_password", password));
        //Document value = new Document("userID", id).append("user_password", password).append("email", email).append("firstName",firstname)
        //.append("lastName",lastname).append("locationID",location);
        
        Document value = new Document("$set", new Document
        ("adminpassword", password).append("email", email).append("firstname",firstname)
        .append("lastname",lastname));
        admins.updateOne(where, value);
    }
    
    public void deleteAdmin(int id)
    {
        admins.deleteOne(Filters.eq("adminId",id));
    }

   /*
    public LinkedList<String> search_history(int locationID) 
    {
    LinkedList<String> historyList = new LinkedList<String>(); 
    //Document historyDocs = new Document("Location ID", locationID);//WHERE LIKE 'SEARCH%'
     for (Document doc : WeatherHistory.sort(new BasicDBObject("Location ID",1)))
     {
        historyList.add((String) doc.get("Date"));
        historyList.add((String) doc.get("Time"));
        historyList.add((String) doc.get("Temperature"));
        historyList.add((String) doc.get("Humidity"));
        historyList.add((String) doc.get("Wind speed"));
        historyList.add((String) doc.get("Wind direction"));
        historyList.add((String) doc.get("Cloudy"));
        historyList.add((String) doc.get("danger level"));
        //SELECT ALL 
    }
        return historyList;
    }   */
    
    
    
    public LinkedList<String> weather_history(String location) 
    {
        LinkedList<String> historyList = new LinkedList<String>();
        //int locationID = Integer.parseInt(location);
        Document historyDocs = 
                new Document("location ID", Pattern.compile(".*"+location.trim()+".*"));
                
                
        
        System.out.println(historyDocs);
        
        for (Document doc : History.find(historyDocs)) 
        {
            Location current = findLoc(Integer.parseInt((String) doc.get("location ID")));
            historyList.add(current.getRegion());
            historyList.add((String) doc.get("Date"));
            historyList.add((String) doc.get("Time"));
            historyList.add((String) doc.get("Temperature"));
            historyList.add((String) doc.get("Humidity"));
            historyList.add((String) doc.get("Wind speed"));
            historyList.add((String) doc.get("Wind direction"));
            historyList.add((String) doc.get("Cloudy"));
            historyList.add((String) doc.get("danger level"));
        
        }
        return historyList;
    }   
    
  
    public Location findLocationId(String region) 
    {               
        Document SearchBSON = new Document("Region",region);//WHERE LIKE 'SEARCH%'
        //System.out.println(region);
        for (Document doc : location.find(SearchBSON))
        {
            String Country =(String) doc.get("Country");
            int locationId = Integer.parseInt((String) doc.get("LocationId"));
            String State = (String) doc.get("State");
            //you need to get all the data
            Location currentLocation = new Location(locationId, Country, State, region);
            return currentLocation;
        }
        return null;
    }
    
    
    
    public void saveToAdmin(String Password, String Email, String Firstname, String Lastname) 
    {
        int ID = returnID(admins, "adminId");
        PostList.clear();
        PostList.add(new Document
        ("adminId", ID).append("adminpassword", Password).append("email", Email).append("firstname",Firstname)
        .append("lastname",Lastname)
        );
        
        admins.insertMany(PostList);
    } 
    
    public LinkedList<String> List_Admin(String Search) 
    {
    LinkedList<String> list_data = new LinkedList<String>(); 
    
     for (Document doc : admins.find()) 
     {
        list_data.add((String) doc.get("adminId"));
        list_data.add((String) doc.get("adminpassword"));
        list_data.add((String) doc.get("email"));
        list_data.add((String) doc.get("firstname"));
        list_data.add((String) doc.get("lastname"));
    }
    return list_data;
    } 
    
    public LinkedList<WeatherHistory> weather_analysis(String locationid) 
    {
        LinkedList<WeatherHistory> wa_list = new LinkedList<WeatherHistory>();
        
        Document docs = new Document("location ID", locationid);
        
        for(Document doc: History.find(docs))
        {
            WeatherHistory wh = new WeatherHistory((String) doc.get("Date"),(String) doc.get("Time"),(String) doc.get("location ID"),
                                                        (String) doc.get("Temperature"),(String) doc.get("Humidity"),
                                                        (String) doc.get("Wind speed"),(String) doc.get("Wind direction"),
                                                         (String) doc.get("Cloudy"),(String) doc.get("danger level"));
            wa_list.add(wh);
            
        }
        
        return wa_list;
    }

    public LinkedList<User> findUserLoc(int locId) 
    {
        int userId, locationId;
        String user_password, email, firstname,lastname;
        LinkedList<User> newUserList = new LinkedList();
        Document WhereDocs = new Document("locationID", locId);
        System.out.println(WhereDocs.toString());
        for (Document doc : users.find(WhereDocs))
        {
            userId = ((Integer) doc.get("userID"));
            locationId = ((Integer) doc.get("locationID"));
            user_password = ((String) doc.get("user_password"));
            email =((String) doc.get("email"));
            firstname =((String) doc.get("firstName"));
            lastname = ((String) doc.get("lastName"));
            //you need to get all the data
            User newUser = new User(userId, locationId, user_password, email, firstname, lastname);
            newUserList.push(newUser);          
        }
        return newUserList;
    }
    
    public User checkUser(String Email) 
    {
        int userId, locationId;
        String user_password, email, firstname,lastname;
        User newUser;
        Document WhereDocs = new Document("email", Email);
        System.out.println(WhereDocs.toString());
        for (Document doc : users.find(WhereDocs))
        {
            userId = ((Integer) doc.get("userID"));
            locationId = ((Integer) doc.get("locationID"));
            user_password = ((String) doc.get("user_password"));
            email =((String) doc.get("email"));
            firstname =((String) doc.get("firstName"));
            lastname = ((String) doc.get("lastName"));

            newUser = new User(userId, locationId, user_password, email, firstname, lastname);
            return newUser;
        }
        return newUser = null;
    }
    
     public Administrator checkAdmin(String Email) 
    {
        int adminId;
        String adminPassword, email, firstname,lastname;
        Administrator newAdmin;
        Document WhereDocs = new Document("email", Email);
        System.out.println(WhereDocs.toString());
        for (Document doc : admins.find(WhereDocs))
        {
            adminId = ((Integer) doc.get("adminId"));
            adminPassword = ((String) doc.get("adminpassword"));
            email =((String) doc.get("email"));
            firstname =((String) doc.get("firstname"));
            lastname = ((String) doc.get("lastname"));

            newAdmin = new Administrator(adminId, adminPassword, email, firstname, lastname);
            return newAdmin;
        }
        return newAdmin = null;
    }
     
    public int finduserID(String Email, String Firstname, String Lastname) {
        int id;
        String email, firstname, lastname;
        Document history =  new Document("email", Email).append("firstName",Firstname).append("lastName",Lastname);
        for (Document doc : users.find(history)) {
            email = (String) doc.get("email");
            firstname = (String) doc.get("firstName");
            lastname = (String) doc.get("lastName");
            id = (int) doc.get("userID");
            return id;
        }
        return 0;
    }
    
    public int findAdminID(String Email, String Firstname, String Lastname) {
        int id;
        String email, firstname, lastname;
        Document history =  new Document("email", Email).append("firstname",Firstname).append("lastname",Lastname);
        for (Document doc : admins.find(history)) {
            email = (String) doc.get("email");
            firstname = (String) doc.get("firstname");
            lastname = (String) doc.get("lastname");
            id = (int) doc.get("adminId");
            return id;
        }
        return 0;
    }
    
    
     public void updatePass(int id, String password) 
    {
        Document where = new Document("userID", id);        
        Document value = new Document("$set", new Document("user_password", password));
        users.updateOne(where, value);
    }
     
     public void updateAdminPass(int id, String password) 
    {
        Document where = new Document("adminId", id);        
        Document value = new Document("$set", new Document("adminpassword", password));
        admins.updateOne(where, value);
    }

}
