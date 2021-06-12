package student05;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {

	static Scanner scan = new Scanner(System.in);

//----------------------------------------------------------------------
	void printMenu() {
		System.out.println("1. 추가");
		System.out.println("2. 수정");
		System.out.println("3. 검색");
		System.out.println("4. 출력");
		System.out.println("5. 등수");
		System.out.println("0. 종료");
		System.out.println("--------");
		System.out.println("원하는거 ㄱ");
	}

//----------------------------------------------------------------------
	void addStudent(ArrayList<Student> s, ArrayList<String> sbj_name) {
		System.out.print("이름 : ");
		String name = scan.next();
		ArrayList<Integer> score = new ArrayList<Integer>();
		for (int i = 0; i < sbj_name.size(); i++) {
			System.out.print(sbj_name.get(i) + " : ");
			score.add(scan.nextInt());
			if (score.get(i) < 0 || score.get(i) > 100) {
				System.out.println("점수는 0~100점 사이만!");
				i--;
			}
		}
		s.add(new Student(name, score));
	}

//----------------------------------------------------------------------
	void updateStudent(ArrayList<Student> s, ArrayList<String> sbj_name) {
		System.out.print("이름 : ");
		String name = scan.next();
		for (int i = 0; i < s.size(); i++) {
			if (name.equals(s.get(i).getName())) {
				// 학생 성적 출력
				System.out.println("어떤 것을 수정?");
				name = scan.next();
				for (int j = 0; j < sbj_name.size(); j++) {
					if (name.equals(sbj_name.get(j))) {
						System.out.print(sbj_name.get(j) + " : ");
						int score = scan.nextInt();
						if (score < 0 || score > 100) {
							System.out.println("점수는 0~100점 사이만!");
							i--;
						} else {
							// i번째 학생 합계(i번째 학생 합계-i번째 학생의 j번째 점수+입력한 점수)
							s.get(i).setTotal(s.get(i).getTotal() - s.get(i).getScore().get(j) + score);
							// i번째 학생 평균(i번째 학생 합계/i번째 학생 점수 길이)
							s.get(i).setAvg(s.get(i).getTotal() / s.get(i).getScore().size());
							// i번째 학생 점수 중(j번째, 입력한 점수)
							s.get(i).getScore().set(j, score);
						}
					}
				}
			}
		}
	}

//----------------------------------------------------------------------
	void searchStudent(ArrayList<Student> s, ArrayList<String> sbj_name) {
		System.out.print("이름 : ");
		String name = scan.next();
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getName().equals(name)) {
				// 출력부분
				return;
			}
		}
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getName().contains(name)) {
				System.out.print(s.get(i).getName());
			}
		}
	}
//----------------------------------------------------------------------

}
