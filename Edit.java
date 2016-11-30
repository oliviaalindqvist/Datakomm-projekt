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

			      
			/* edit booking by canceling the first booking after updating it, 
			save the updated version in the database?*/      
			      
			      		      
			 // SSN
			 System.out.println("Enter new SSN: ");
			 Scanner scan = new Scanner(System.in);
			 int SSN = scan.nextInt();

			 //Update db
			 String SQLUpdate = "UPDATE Table_1 SET SSN ='"+SSN;
			 stmtUpdate = con.createStatement();  
			 stmtUpdate.executeUpdate(SQLUpdate);
			 System.out.println("Edit SSN");

			/*// Room
			 System.out.println("Enter new room: ");
			 Scanner scan = new Scanner(System.in);
			 int room = scan.nextInt();

			 //Update db
			 String SQLUpdate = "UPDATE Table_1 SET SSN ='"+SSN;
			 stmtUpdate = con.createStatement();  
			 stmtUpdate.executeUpdate(SQLUpdate);
			 System.out.println("Edit SSN");*/
			      

		// Close  
		      stmt.close();
		rs.close();
		      stmtUpdate.close();
		      con.close();
