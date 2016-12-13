import java.sql.*;  
import java.util.Scanner;   
public class Edit {  

 ///********************************************************************************************
    public static void main(String[] args) {  
	// Database url  
	String DBurl = "jdbc:sqlserver://localhost:1433;" +  
	    "databaseName=HotelK;user=test;password=test";
	String username = "root";
	String password = "root";

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
 //**********************************************************************************************
			      
	        
	    System.out.println("Enter new SSN: ");
	    Scanner scan = new Scanner(System.in);
	    int SSN = scan.nextInt();
	    //Delete old booking
	    stmtUpdate.executeUpdate("update rooms " 
				     + "set ssn = null " 
				     + "where ssn = " + ssn );
	    //Update db with new SSN
	    String SQLUpdate = "UPDATE Table_1 SET SSN ='"+SSN;
	    stmtUpdate = con.createStatement();  
	    stmtUpdate.executeUpdate(SQLUpdate);
	    System.out.println("Edit SSN");

			
	    //Room
	    //Cancel old booking of rooms
	    stmt.executeUpdate("update rooms " 
			       + "set ssn = null " 
			       + "where ssn = " + ssn );

	    //Choose room and check availability FROM BOOKING
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
			System.out.println("Not available");		        	 
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

			 		      

	    // Close  
	    stmt.close();
	    rs.close();
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
		
