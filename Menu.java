import java.sql.*;  
import java.util.Scanner;   
public class Menu {
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
		 
	}

	System.out.println("Hi and Welcome to the shared resource hotel! 
what would you like to do today?
1. Book a room
2. View rooms 
3. Cancel booking
4. Edit your booking
5. quit");

//skriva om booking, viewroom, cancel -filer så man kan använda funktioner
	class Menu {
	    public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();	 
		if (choice = 1)
		    {
			//booking();
		    }
	 
		elif (choice = 2)
		    {
			//viewrooms();
		    }

		elif (choice = 3)
		    {
			//cancel();
		    }
		elif (choice = 4)
		    {
			//edit();
		    }
	
		else (choice = 5)
			 {
			     return(0);
			 }
	    }
	}
