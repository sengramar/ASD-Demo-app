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
    //list all table name 
    MongoCollection<Document> users = db.getCollection("Users");
    MongoCollection<Document> admins = db.getCollection("Administrator");
    MongoCollection<Document> location = db.getCollection("Location");
    MongoCollection<Document> WeatherHistory = db.getCollection("WeatherHistory");
      
    

    public void saveToWeatherHistory(String Date, String Time, int LocationId, String Temperature,String Humidity,String WindSpeed,String WindDegree, String Cloudy,String Description ) 
    {
        int ID = returnID(WeatherHistory, "weatherID");
        PostList.clear();

        PostList.add(new Document
        ("weatherID", ID).append("Date", Date).append("Time", Time).append("location ID",LocationId)
        .append("Temperature",Temperature).append("Humidity",Humidity).append("Wind speed",WindSpeed)
        .append("Wind direction",WindDegree).append("Cloudy",Cloudy).append("danger level",Description)
        );
        
        WeatherHistory.insertMany(PostList);
    }   

    public LinkedList<String> List_Location(String Search) 
    {
    LinkedList<String> list_data = new LinkedList<String>(); 
    Document SearchBSON = new Document("Region",Pattern.compile(Pattern.quote(Search)));//WHERE LIKE 'SEARCH%'
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
    
    public User findUser(String Email, String User_Password) 
    {
        int userId, locationId;
        String user_password, email, firstname,lastname;
        User newUser;
        Document WhereDocs = new Document("email", Email).append("user_password", User_Password);
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
            newUser = new User(userId, locationId, user_password, email, firstname, lastname);
            return newUser;
        }
        return newUser = null;
    }
    
     public Administrator findAdmin(String Email, String AdminPassword) {
        String email, adminpassword, firstname, lastname;
        int adminId;
        Administrator newAdmin;
        Document admin = new Document("email", Email).append("adminpassword", AdminPassword);
         System.out.println(admin.toString());
        for (Document doc : admins.find()) {
            email = (String) doc.get("email");
            adminpassword= (String) doc.get("adminpassword");
            adminId= (int) doc.get("adminId");
            firstname= (String) doc.get("firstname");
            lastname= (String) doc.get("lastname");
            
            newAdmin = new Administrator(adminId, adminpassword, email, firstname, lastname);
            return newAdmin;

            
        }
        return null;
    }
    
    public void storeLogin(int userId, String loginDateTime) {
        int accesslogId = returnID(accesslog, "accesslogId");
        logList.clear();
        logList.add(new Document("accesslogId", accesslogId).append("userId", userId).append("loginTime", loginDateTime).append("logoutTime", null));
        accesslog.insertMany(logList);
    }
    
    public void storeLogout(int accesslogId, String logoutDateTime) {
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
}
