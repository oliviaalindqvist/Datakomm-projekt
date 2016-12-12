		import java.sql.*;  
		import java.util.Scanner;   
		public class Menu {
		    public static void main(String[] args) throws ClassNotFoundException {  
		System.out.printf("Hi and Welcome to the shared resource hotel!\n " +
		"What would you like to do today?\n\n" +
		"1. Book a room\n" +
		"2. View rooms\n" +
		"3. Cancel booking\n" +
		"4. Edit your booking\n" +
		"5. quit\n");	
				Scanner scan = new Scanner(System.in);
				System.out.println("Please make a choice: ");
				int menu = scan.nextInt();
				switch(menu){	 
				case 1:	 
					Booking.main(args);
					break;
				case 2:
					ViewRooms.main(args);
					break;
				case 3:
					cancel_booking.main(args);
					break;
				case 4:
					Edit.main(args);
					break;
				case 5:
					System.out.println("Bye!");
					break;
				default:
					break;
					
				
			}
				scan.close();
		    }
		    
		}