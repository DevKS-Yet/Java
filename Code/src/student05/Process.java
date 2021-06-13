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
		System.out.print("이름(0. 종료) : ");
		String name = scan.next();
		if(name.equals("0")) {
			System.out.println("추가를 종료합니다.");
			return;
		}
		loopfor:for(int i=0; i<s.size();i++) {
			if(s.get(i).getName().equals(name)) {
				System.out.println("동일한 이름이 있습니다. 계속하시겠습니까?(Y/N)");
				String choice = scan.next();
				switch(choice) {
				case "Y":
					System.out.println("계속하겠습니다.");
					break loopfor;
				case "N":
					System.out.println("종료하겠습니다.");
					return;
				default:
					System.out.println("제대로 입력해주셈");
					break;
				}
			}
		}
		ArrayList<Integer> score = new ArrayList<Integer>();
		for (int i = 0; i < sbj_name.size(); i++) {
			System.out.print(sbj_name.get(i) + " : ");
			int tmp = scan.nextInt();
			if (tmp < 0 || tmp > 100) {
				System.out.println("점수는 0~100점 사이만!");
				i--;
			} else {
				score.add(tmp);
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
				printStudentTop(sbj_name);
				printStudentOne(s, i);
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
		boolean check = false;
		System.out.print("이름 : ");
		String name = scan.next();
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getName().equals(name)) {
				printStudentTop(sbj_name);
				printStudentOne(s, i);
				return;
			}
		}
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getName().contains(name)) {
				if(check == false) {
					System.out.print("비슷한 이름 :");
				}
				System.out.print(" "+s.get(i).getName());
				check = true;
			}
		}
		System.out.print("\n이름 : ");
		name = scan.next();
		for(int i=0; i<s.size();i++) {
			if(s.get(i).getName().equals(name)) {
				printStudentTop(sbj_name);
				printStudentOne(s, i);
			}
		}
	}
//----------------------------------------------------------------------
	void printStudentTop(ArrayList<String> sbj_name) {
		System.out.print("학번\t이름");
		for(int i=0; i<sbj_name.size();i++) {
			System.out.print("\t"+sbj_name.get(i));
		}
		System.out.println("\t합계\t평균\t등수");
	}
	
	void printStudentOne(ArrayList<Student> s, int i) {
		System.out.print(s.get(i).getId()+"\t"+s.get(i).getName());
		for(int j=0; j<s.get(i).getScore().size();j++) {
			System.out.print("\t"+s.get(i).getScore().get(j));
		}
		System.out.printf("\t%d\t%.2f\t%d\n", s.get(i).getTotal(), s.get(i).getAvg(), s.get(i).getRank());
	}
	
	void printStudent(ArrayList<Student> s, ArrayList<String> sbj_name) {
		printStudentTop(sbj_name);
		for(int i=0; i<s.size();i++) {
			printStudentOne(s, i);
		}
	}
//----------------------------------------------------------------------
	void rankStudent(ArrayList<Student> s) {
		for(int i=0; i<s.size(); i++) {
			int rank = 1;
			for(int j=0; j<s.size(); j++) {
				if(s.get(i).getTotal()<s.get(j).getTotal()) {
					rank++;
				}
			}
			s.get(i).setRank(rank);
		}
	}

}
