
  import junit.framework.*;

  import java.io.FileInputStream;
  import java.io.IOException;
  import java.io.InputStream;


  import Booking.java;

  public class BookingTest {
      //use booking.txt to test 

          @Test //om ssn är 10 digits och om valid input
          public void ssnTest() throws IOException {
          InputStream ip = new FileInputStream("/home/");

          assertEquals();
    }

          @Test //om inputen är ett valid room
          public void roomTest() throws IOException {
          InputStream ip = new FileInputStream("/home/");

          assertEquals();
    }

          @Test //on input är ett valid firstname och lastname
          public void nameTest() throws IOException {
          InputStream ip = new FileInputStream("/home/");

          assertEquals();

    }

  }


  // junit?
  // Flera test till booking?
  // Generell testfil för flera filer, eller separata för varje?
