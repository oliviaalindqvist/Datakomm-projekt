import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class ViewRooms {

	   public static void main(String[] args) {  
		   
	      // Database url  
	      String DBurl = "jdbc:sqlserver://localhost:1433;" +  
	         "databaseName=HotelK;user=test;password=test";  
	  
	      // Declare JDBC objects.  
	      Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;  
	  
	      try {  
	         // Connect with DB, with MSSQL
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(DBurl);  
	         con.setAutoCommit(false);
	         
	         System.out.println("From when would you like to stay?: ");

	         // Run Calender
	         
	         
	         System.out.println("When do you want to check out?: ");
	         
	         
	         // Run Calender
	         
	         // Select available rooms (SSN is null)
	         String SQL = "SELECT Room_ID FROM Rooms WHERE SSN IS NULL";
	         
	         stmt = con.createStatement();  
	         rs = stmt.executeQuery(SQL);  
	         con.commit();
	         // Display result
	     	System.out.println("Available rooms: ");  
	         while (rs.next()) { 
	        	int room = rs.getInt("Room_ID");
	            System.out.println(room);  
	         	}  
	      // Close connection and handle exceptions
	      rs.close();
	      stmt.close();
	      con.close();
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
	      try{
	         if(con!=null)
	            con.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      	}	
	   	}
	}
	   public void run() {
		   
		   Thread t = Thread.currentThread();
		   System.out.print(t.getName());
		   //checks if this thread is alive
		   System.out.println(", status = " + t.isAlive());
		   }
}
