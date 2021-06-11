package student04;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Student> stu_list = new ArrayList<Student>();
		ArrayList<String> sbj_name = new ArrayList<String>();
		Process p = new Process();

		while (true) {
			System.out.print("과목 명을 적어주세요(0.그만) : ");
			String name = scan.next();
			if (name.equals("0")) {
				System.out.println("시스템을 시작하겠습니다.");
				break;
			}
			sbj_name.add(name);
		}

		whileloop: while (true) {

			String choice = p.mainPrint();

			switch (choice) {
			case "1":
				p.addStudent1(stu_list, sbj_name);
				break;
			case "2":
				p.printStudentTop(sbj_name);
				p.printStudent(stu_list);
				break;
			case "3":
				p.searchStudent(stu_list, sbj_name);
				break;
			case "4":
				p.updateStudent(stu_list, sbj_name);
				break;
			case "5":
				p.rankStudent(stu_list);
				break;
			case "9":
				p.changeSubject(sbj_name);
				break;
			case "0":
				System.out.println("시스템을 종료하겠습니다.");
				break whileloop;
			default:
				System.out.println("다시 입력해주세요");
				break;
			}// switch
		} // while
		scan.close();
	}// main
}// class
