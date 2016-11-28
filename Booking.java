import java.sql.*;  
import java.util.Scanner;   
public class Booking {  

	   public static void main(String[] args) {  
	      // Database url  
	      String DBurl = "jdbc:sqlserver://localhost:1433;" +  
	         "databaseName=HotelK;user=test;password=test";  
	  
	      // Declare JDBC objects.  
	      Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;
	      Statement stmtUpdate = null;
	      try {  
	         // Connect with DB, with MSSQL
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         System.out.println("Connecting to database...");
	         con = DriverManager.getConnection(DBurl);  
	  
	         // Enter SSN
	         System.out.println("Enter your SSN: ");
	         Scanner scan = new Scanner(System.in);
	         int SSN = scan.nextInt();	        
	         
	         //Show available rooms 
	         String SQL = "SELECT Room_nr FROM Table_1 WHERE SSN IS NULL;"; 
	         stmt = con.createStatement();  
	         rs = stmt.executeQuery(SQL); 
         
	         // Display result
	     	 System.out.println("Available rooms: ");  
	         while (rs.next()) { 
	        	int room = rs.getInt("Room_nr");
	            System.out.println(room);  
	         	}
	         
	         //Choose room
	         System.out.println("Choose room: ");
	         int ChoosenRoom = scan.nextInt();
	         scan.close();
	         
	         System.out.println("Booking room..");
	         //Update SQL using input
	         String SQLUpdate = "UPDATE Table_1 SET SSN ='"+SSN+
	         "'WHERE Room_nr ='" +ChoosenRoom+"';"; 
	         stmtUpdate = con.createStatement();  
	         stmtUpdate.executeUpdate(SQLUpdate);
	         System.out.println("Booking complete, bye!");
	         
	         // Display result 
	         while (rs.next()) { 
	        	int room = rs.getInt("Room_nr");
	            System.out.println(room);
	         }  
	         
	         
	      // Close connection and handle exceptions   
	      rs.close();
	      stmt.close();
	      stmtUpdate.close();
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
	    }System.out.println("Closed connection");
	  }
}