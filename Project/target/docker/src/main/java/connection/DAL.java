package connection;

import java.sql.Connection;


import errors.DBException;
import errors.InfoExcepion;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAL {// data access layer
//	   private Map<>
	   private static DAL ourInstance = new DAL();
       public static final String DBURL = "jdbc:h2:tcp://localhost/~/test";
       public static final String USER ="Admin";
       public static final String PASS = "Admin";
       
       public static DAL Instace = ourInstance;
       
       
       
       
     public static Connection createConnection()throws DBException {
    	 try {
    		 Class.forName("org.h2.Driver").newInstance();
    		 return DriverManager.getConnection(DBURL,USER,PASS); 
//a chacks if the connection is good by stating how many tabes there are 
//			 Statement stmt = c.createStatement();
//			 String sql = "SELECT * FROM ITEM";
//			 ResultSet x = stmt.executeQuery(sql);
//			 x.next();
//			 long a = x.getLong(3);
//			 a = a;
			 
    	 }
    	 catch(Exception e){
    		 throw new DBException();
    	 }
     }
     
     
     
     //its execute a query statement 
     public static PreparedStatement CreatSAtatement(String sqlQuery) throws InfoExcepion  {
    	 try {
			return createConnection().prepareStatement(sqlQuery);
		
   
     }catch(Exception e) {
    	 return null;
     }
     }
     
     public static ResultSet ExecuteQuery(String sqlQuery) throws InfoExcepion {
    	 try {
			PreparedStatement preparedStatement = createConnection().prepareStatement(sqlQuery);
			return preparedStatement.executeQuery();
    	 
    	 } catch (Exception e) {
		
			throw new InfoExcepion();
		}
     }
     
     
     //create a connection between the db and the method
     public static void ExecuteConnection(String sqlQuery) throws DBException{
    	 try {
			PreparedStatement preparedStatement = createConnection().prepareStatement(sqlQuery);
			preparedStatement.executeQuery();
		} catch (SQLException | DBException  e) {
			e.printStackTrace();
			throw  new DBException();
		}
    	
     }


}
