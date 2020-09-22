
package DAO;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import com.mongodb.connection.Connection;

public class MongoDBConnector extends MongoDB{
    private MongoClient client;
    private MongoDatabase db;
    
    public MongoDatabase DBConnect() {
       MongoClientURI uri = new MongoClientURI("mongodb://" + dbuser + ":" + dbpass+ URL);
             
       client = new MongoClient(uri);
       db = client.getDatabase(uri.getDatabase());

       return db;
    }

    public Connection openConnection(){
        return this.conn;
    }
}