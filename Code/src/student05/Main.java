package student05;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Student> s = new ArrayList<Student>();
		ArrayList<String> sbj_name = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
		Process p = new Process();
		
		while(true) {
			System.out.print("과목 명(0.중지) : ");
			String name = scan.next();
			if(name.equals("0")) {
				break;
			} else {
				sbj_name.add(name);
			}
		}
		
		whileloop:while(true) {
			p.printMenu();
			String choice = scan.next();
			switch(choice) {
			case "1":
				p.addStudent(s, sbj_name);
				break;
			case "2":
				p.updateStudent(s, sbj_name);
				break;
			case "3":
				p.searchStudent(s, sbj_name);
				break;
			case "4":
				p.printStudent(s, sbj_name);
				break;
			case "5":
				p.rankStudent(s);
				break;
			case "0":
				break whileloop;
			default:
				break;
			}
		}
		scan.close();
	}
}
