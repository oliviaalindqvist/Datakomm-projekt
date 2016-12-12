import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	         System.out.println("Connecting to database...");
	         con = DriverManager.getConnection(DBurl);  
	  
	         // Select available rooms (SSN is null)
	         String SQL = "SELECT Room_ID FROM Rooms WHERE SSN IS NULL"; 
	         stmt = con.createStatement();  
	         rs = stmt.executeQuery(SQL);  
	  
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
}
