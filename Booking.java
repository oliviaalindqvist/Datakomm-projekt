import java.sql.*;  
import java.util.Scanner;   
public class Booking {  

	   public static void main(String[] args) throws ClassNotFoundException {  
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
	         con.setAutoCommit(false);
	         // Enter SSN
	         System.out.println("Enter your SSN: ");
	         Scanner scan = new Scanner(System.in);
	         int SSN = scan.nextInt();	        
	         
	         //Show available rooms 
	         String SQL = "SELECT Room_ID FROM Rooms WHERE SSN IS NULL;"; 
	         stmt = con.createStatement();
	         rs = stmt.executeQuery(SQL); 
         
	         // Display result
	     	 System.out.println("Available rooms: ");  
	         while (rs.next()) { 
	        	int room = rs.getInt("Room_ID");
	            System.out.println(room);  
	         	}
	         
	         
	         //Choose room and check availability
	         boolean check = true;
	         int ChoosenRoom = 0;
	         while(check){
	         //Choose room
	         System.out.println("Choose room: ");
	         ChoosenRoom = scan.nextInt();
	         
	         //Check if available
	         String CheckRoom = "Select count(*) from Rooms WHERE Room_ID = ? "
	        		    + "and SSN is NULL";
	         PreparedStatement st = con.prepareStatement(CheckRoom);	        		    
	         st.setInt(1, ChoosenRoom);
	         ResultSet rs1 = st.executeQuery();
	         int count = 0;
	         while(rs1.next()) {
	        	 count = rs1.getInt(1);
	        	 if (count == 0){
		        	 System.out.println("Room taken");		        	 
	        	 }
	        	 else{
	        		 check = false;
	        	 }
	         	}
	         }
	         System.out.println("Booking room..");
	         
			//Update SQL using input
	         String SQLUpdate = "UPDATE Rooms SET SSN = ? "
	        + "WHERE Room_ID = ? ";         
	         PreparedStatement stmtUpdate = con.prepareStatement(SQLUpdate);  
	         stmtUpdate.setInt(1,SSN);
	         stmtUpdate.setInt(2,ChoosenRoom);	
	         stmtUpdate.executeUpdate();
	         con.commit();
	         System.out.println("Booking complete, bye!");
	         
	         
	      // Close connection and handle exceptions   
	      scan.close();
	      rs.close();
	      stmt.close();
	      stmtUpdate.close();
	      con.close();
	   }catch (SQLException ex) {
		      ex.printStackTrace();
		      try {
		         System.out.println("Transaction failed.");
		         con.rollback();
		      }
		      catch (SQLException se) {
		         se.printStackTrace();
		      }
		   }
		}
}