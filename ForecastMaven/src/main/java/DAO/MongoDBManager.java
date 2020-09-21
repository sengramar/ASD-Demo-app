package DAO;

import java.util.*;
import com.mongodb.*;
import com.mongodb.client.*;
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
    
    //list all table name 
    MongoCollection<Document> user = db.getCollection("Users");
    MongoCollection<Document> location = db.getCollection("Location");
      
    

    
    public LinkedList<String> List_Location(String Search) 
    {
    LinkedList<String> list_data = new LinkedList<String>(); 
    
     for (Document doc : location.find()) 
     {
        list_data.add((String) doc.get("LocationId"));
        list_data.add((String) doc.get("Country"));
        list_data.add((String) doc.get("State"));
        list_data.add((String) doc.get("Region"));
    }
    return list_data;
    }   
}