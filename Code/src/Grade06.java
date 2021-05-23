import java.util.Scanner;

public class Grade06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Student03[] s = Student03.stuNum();
		int sbjNum = Student03.sbjNum();
		String[] sbjName = Student03.sbjName(sbjNum);
		
		Student03.mainStudent(s, sbjName);
	}// main
}// class
