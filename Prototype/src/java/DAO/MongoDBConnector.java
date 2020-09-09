/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.*;
import Controller.*;
import Model.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import java.net.UnknownHostException;

/**
 *
 * @author Nayoon
 */
public class MongoDBConnector {
    private List<Document> users = new ArrayList();
    private String owner;
    private String password;
    
    public MongoDatabase getMongoDB(){
       MongoClientURI uri = new MongoClientURI("mongodb://" + this.owner + ":" +this.password+ "@ds023540.mlab.com:23540/heroku_6s2qwwxw");
       MongoDatabase db;
       try (MongoClient client = new MongoClient(uri)) {
            db = client.getDatabase(uri.getDatabase());
       }
       return db;
    }
    
    public MongoDBConnector(String owner, String password) throws UnknownHostException{
        this.owner = owner;
        this.password = password;
//        connect();
    }
    
//    public void showall (User users) {
//        for (User u : users.getList()) {
//            System.out.print(u.getFirstname());
//            System.out.println(u.getLastname());
//        }
//    }
//
//    private void connect() throws UnknownHostException{
//        uri = new MongoClientURI("mongodb://" + owner + ":" +password+ "@ds023540.mlab.com:23540/heroku_6s2qwwxw");
//        client = new MongoClient(uri);
//        db = client.getDatabase(uri.getDatabase());
//    }
//    
//    public void add(User user) {
//        users.add(new Document("Username", user.getEmail()).append("Password", user.getUser_password()).append("Firstname", user.getFirstname()).append("Lastname", user.getLastname()).append("Location", user.getLocationId()));
//        MongoCollection<Document> userlist = db.getCollection("Users");
//        userlist.insertMany(users);
//    }
}
