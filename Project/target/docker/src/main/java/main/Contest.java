//package main;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import Bean.Item;
//import connection.DAL;
//import errors.DBException;
//
//public class Contest {
//	   private static DAL ourInstance = new DAL();
//       public static final String DBURL = "jdbc:h2:tcp://localhost/~/test";
//       public static final String USER ="Admin";
//       public static final String PASS = "Admin";
//       
//       public static DAL Instace = ourInstance;
//       
//	public static void main(String[] args) throws DBException
//	{
//    	 try {
////    		 Class.forName("org.h2.Driver").newInstance();
////    		 Connection c = DriverManager.getConnection(DBURL,USER,PASS); 
//////a chacks if the connection is good by stating how many tabes there are 
////			 Statement stmt = c.createStatement();
////			 String sql = "SELECT * FROM ITEM";
////			 ResultSet x = stmt.executeQuery(sql);
////			 x.next();
////     		 long a = x.getLong(3);
////     		 System.out.println(Long.toString(a));
////			 a = a;
//    		 
//    		 Item item = Item.ItemDetail(1L);
//			 System.out.println(item.getAmount());			 
//    	 }
//    	 catch(Exception e){
//    		 throw new DBException();
//    	 }
//     }
//}
