package DAO;
import com.mongodb.connection.Connection;


public abstract class MongoDB {
        protected String URL = "@ds023540.mlab.com:23540/heroku_6s2qwwxw";//replace this string with your jdbc:derby local host url   
        protected String db = "heroku_6s2qwwxw";//name of the database   
        protected String dbuser  = "admin";
        protected String dbpass = "Asdgroup3!";
        protected Connection conn; //connection null-instance to be initialized in sub-classes
}