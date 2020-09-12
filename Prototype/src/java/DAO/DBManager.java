package DAO;

import Model.Location;
import Model.User;
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
    
    public boolean CheckUser(String Email, String UserPassword)throws SQLException {   
        String query = "select * from USERS where EMAIL = '" + Email + "' and PASSWORD = '" + UserPassword + "'";
        ResultSet rs = st.executeQuery(query); //Query Result
            while (rs.next()) {
                String user_password = rs.getString("r_password");
                String email = rs.getString("email");

                if (email.equals(Email) && user_password.equals(UserPassword)) {
                    return true;
                }
            }
         return false;
    }
    
    public User FindUser(String Email, String UserPassword)throws SQLException {   
        String query = "select * from USERS where EMAIL = '" + Email + "' and PASSWORD = '" + UserPassword + "'";
        ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String user_password = rs.getString(3);
                String email = rs.getString(4);

                if (email.equals(Email) && user_password.equals(UserPassword)) {
                    int userid = rs.getInt("userid");
                    int locationId = rs.getInt("locationId");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");

                    return new User(userid, locationId, user_password, email, firstname, lastname);
                }
            }
         return null;
    }
    
    public void CreateAdmin(String Email, String AdminPassword, String Firstname, String Lastname)throws SQLException 
    {   
    int ID = generateAdminID();
    //generate ID
    String query = "INSERT INTO \"ADMIN\" (ADMINID, ADMIN_PASSWORD, EMAIL, FIRSTNAME, LASTNAME) "
            + "VALUES ("+ID+",'"+AdminPassword+"','"+Email+"','"+Firstname+"','"+Lastname+")";
    st.executeUpdate(query);  
    //execute query
    }
    
    public void storeLogin(int userId, String loginDateTime) throws SQLException {
        st.executeUpdate("INSERT INTO ACCESSLOG (accesslogID, userId, loginTime)" + "VALUES (default, " + userId + ", '" + loginDateTime + "')");
    }

    public void storeLogout(int accesslogId, String logoutDateTime) throws SQLException {
        st.executeUpdate("UPDATE ACCESSLOG SET logoutTime = '" + logoutDateTime + "'" + "WHERE accesslogId = " + accesslogId + "");
    }
        
    public int findAccessLogID(int userId) throws SQLException {
        String query = "SELECT accesslogID FROM ACCESSLOG WHERE userid = " + userId + " AND logoutTime IS NULL";
        ResultSet rs = st.executeQuery(query);
        int id;
        while (rs.next()) {
            id = rs.getInt("accesslogID");
                return id;
        }
        return 0;
    }
    
    public int generateAdminID() throws SQLException
    {
    String query;
        query = "SELECT MAX(ADMINID) as ID FROM \"ADMIN\""; 
   ResultSet rs = st.executeQuery(query);
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
