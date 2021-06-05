import java.io.File;

public class B04_DeleteFiles {

	public static void main(String[] args) {
		
		File myObj = new File("C:\\Users\\조규상\\Desktop\\filename.txt");
		if(myObj.delete()) {
			System.out.println("Deleted the file: " + myObj.getName());
		} else {
			System.out.println("Failed to delete the file.");
		}
		
	}
}

// can also delete a folder. However, it must be empty