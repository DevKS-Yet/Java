import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class B13_DateAndTime {

	public static void main(String[] args) {
		
		LocalDate time1 = LocalDate.now(); // Create a date object
		System.out.println(time1); // yyyy-MM-dd
		
		LocalTime time2 = LocalTime.now(); // Create a time object
		System.out.println(time2); // HH:mm:ss.nano secs
		
		LocalDateTime time3 = LocalDateTime.now();
		System.out.println(time3); // yyyy-MM-dd'T'HH:mm:ss.nano secs
		
		// yyyy-MM-dd & dd/MM/yyyy & dd-MMM-yyyy & E, MMM dd yyyy 
		DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		String time4 = time3.format(timeformat);
		System.out.println(time4);
		
	}
}
