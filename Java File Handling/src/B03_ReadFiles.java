import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B03_ReadFiles {

	public static void main(String[] args) {
		
		File myObj = new File("C:\\Users\\조규상\\Desktop\\filename.txt");
		try {
			Scanner myReader = new Scanner(myObj);
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		if(myObj.exists()) {
			System.out.println("File name: " + myObj.getName());
			System.out.println("Absolute path: " + myObj.getAbsolutePath());
			System.out.println("Writeable: " + myObj.canWrite());
			System.out.println("Readable: " + myObj.canRead());
			System.out.println("File size in bytes: " + myObj.length());
		} else {
			System.out.println("The file does not exist.");
		}
		
	}
}
