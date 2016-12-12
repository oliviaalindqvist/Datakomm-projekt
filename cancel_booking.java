package jdbc_test;
import java.sql.*;
import java.util.Scanner;  

public class cancel_booking {

	public static void main(String[] args) {

		Connection connection = null;
		Statement stmt = null;
		PreparedStatement updateRooms = null;
		
		ResultSet resultRooms = null;
		ResultSet resultPers = null;
		
		Scanner scan = new Scanner(System.in);
		
		String DBurl = "jdbc:mysql://localhost:3306/localhost?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "root";
		
		
		try{
			//Establish connection
			connection = DriverManager.getConnection(DBurl, username, password); 
			stmt = connection.createStatement();
			
			//Scan input
			System.out.println("Please enter your social security number:");
			int ssn = scan.nextInt();
			
			
			//Set ssn = null in rooms
			stmt.executeUpdate("update rooms " 
					+ "set ssn = null " 
					+ "where ssn = " + ssn );
			
			
			//Set all = null in personal_info where user input ssn = ssn	
			/*stmt.executeUpdate("update personal_info "   
					+ "set ssn = null, " 
					+ "first_name = null, "  
					+ "last_name = null, " 
					+ "duration_from = null, " 
					+ "duration_to = null " 
					+ "where ssn = " + ssn );
			*/
			
			
			// If ssn does not exist --> SOLVE
			
			resultRooms = stmt.executeQuery("SELECT ssn "
					+ "FROM rooms " 
					+ "where ssn = " + ssn);
			System.out.println("yo");
			while(resultRooms.next()){
				int resultSSN = resultRooms.getInt("ssn");
				System.out.println(resultRooms.getInt("ssn"));
				
			}
			
			
			
			stmt.executeUpdate("DELETE FROM personal_info " 
					+ "where ssn = " + ssn);
			
			System.out.println("Your booking has been canceled");
			
			connection.close();
			stmt.close();
			// updateRooms.close();      Causes NullPointerException, not recommended to catch
			
			
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
	}

}
