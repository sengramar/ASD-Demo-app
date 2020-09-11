package DAO;

import Model.Location;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author ASUS
 */
public class DBManager 
{
    private Statement st;
    public DBManager(Connection conn) throws SQLException
    {       
       st = conn.createStatement();   
    }
    
    public void CreateUser(String Email, String UserPassword, String Firstname, String Lastname, int LocationID)throws SQLException 
    {   
    int ID = generateUserID();
    //generate ID
    String query = "INSERT INTO \"USER\" (USERID, USER_PASSWORD, EMAIL, FIRSTNAME, LASTNAME, LOCATIONID) "
            + "VALUES ("+ID+",'"+UserPassword+"','"+Email+"','"+Firstname+"','"+Lastname+"',"+LocationID+")";
    //Insert into USERDB using all the parameters  
    st.executeUpdate(query);  
    //execute query
    }
    
    public LinkedList<String> List_Location(String Search) throws SQLException 
    {
   LinkedList<String> list_data = new LinkedList<String>(); 
   String query = "SELECT * FROM LOCATION WHERE COUNTRY LIKE '%"+Search+"%' OR STATE LIKE '%"+Search+"%'OR REGION LIKE '%"+Search+"%'";
   //show users by a word that is contained in username/userlastname/useremail 
   st.executeQuery(query);  //execute query
   ResultSet rs = st.executeQuery(query);//Query Result
   while(rs.next())//run through all result
    {
   list_data.add(rs.getString("LOCATIONID"));
   list_data.add(rs.getString("COUNTRY"));
   list_data.add(rs.getString("STATE")); 
   list_data.add(rs.getString("REGION"));
    //get the data from query result
   }
   return list_data;
} 
    
    public int generateUserID() throws SQLException
    {
    String query;
        query = "SELECT MAX(USERID) as ID FROM \"USER\"";
   //execute this query using the statement field    
   ResultSet rs = st.executeQuery(query);
   //search the ResultSet for a user using the parameters
   if(rs.next())
   {
    int ID = rs.getInt("ID");
    ID = ID +1;
    return ID;     
   }
   else
   {
       return 1;
   }
    }
}
