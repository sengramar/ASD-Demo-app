package DAO;
import java.sql.Connection;


public abstract class DB {
        protected String URL = "jdbc:derby://localhost:1527/Prototype";//replace this string with your jdbc:derby local host url   
        protected String db = "ASD";//name of the database   
        protected String dbuser = "ASD";//db root user   
        protected String dbpass = "ASD"; //db root password   
        protected String driver = "org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans   
        protected Connection conn; //connection null-instance to be initialized in sub-classes
}