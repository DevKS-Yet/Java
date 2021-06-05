package student04;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {

	static Scanner scan = new Scanner(System.in);

//------------------------------------------------------------------------
	// 메뉴 프린트
	String mainPrint() {
		System.out.println(" [ 성적관리 시스템 ] ");
		System.out.println("1. 학생성적추가");
		System.out.println("2. 학생성적출력");
		System.out.println("3. 학생성적검색");
		System.out.println("4. 학생성적수정");
		System.out.println("5. 등수처리");
		System.out.println("0. 시스템 종료");
		System.out.println("------------------");
		System.out.println("원하는 것을 선택하세요.>>");
		String choice = scan.next();
		return choice;
	}

//------------------------------------------------------------------------
	// 학생 1명만 더하기
	void addStudent1(ArrayList<Student> stu_list, ArrayList<String> sbj_name) {
		System.out.println("이름 : ");
		String name = scan.next();
		ArrayList<Integer> score = new ArrayList<Integer>();
		for (int i = 0; i < sbj_name.size(); i++) {
			System.out.print(sbj_name.get(i) + " : ");
			int input = scan.nextInt();
			if (input < 0 || input > 100) {
				System.out.println("점수는 0~100점 사이!");
				i--; // 점수가 0~100점이 아닐 시 다시 해당 과목 점수 적음
				continue;
			}
			score.add(input);
		}
		stu_list.add(new Student(name, score));
	}

//------------------------------------------------------------------------
	// 학생 점수 출력 상단 부분
	void printStudentTop(ArrayList<String> sbj_name) {
		System.out.print("학번\t이름");
		for (int i = 0; i < sbj_name.size(); i++) {
			System.out.print("\t" + sbj_name.get(i));
		}
		System.out.printf("\t%s\t%s\t%s\n", "합계", "평균", "등수");
	}

	// 학생 1명 성적만 출력
	void printStudent1(ArrayList<Student> stu_list, int i) {
		System.out.printf("%s\t%s", stu_list.get(i).getId(), stu_list.get(i).getName());
		for (int j = 0; j < stu_list.get(i).getScore().size(); j++) {
			System.out.print("\t" + stu_list.get(i).getScore().get(j));
		}
		System.out.printf("\t%d\t%.2f\t%d\n", stu_list.get(i).getTotal(), stu_list.get(i).getAvg(),
				stu_list.get(i).getRank());
	}

	// 학생 전체 성적 출력
	void printStudent(ArrayList<Student> stu_list) {
		for (int i = 0; i < stu_list.size(); i++) {
			printStudent1(stu_list, i);
		}
	}

//------------------------------------------------------------------------
	// 학생 검색 일치했을 경우
	boolean searchStudentEquals(ArrayList<Student> stu_list, ArrayList<String> sbj_name, String name) {
		for (int i = 0; i < stu_list.size(); i++) {
			if (name.equals(stu_list.get(i).getName())) {
				printStudentTop(sbj_name);
				printStudent1(stu_list, i);
				return true;
			}
		}
		return false;
	}

	// 학생 검색
	void searchStudent(ArrayList<Student> stu_list, ArrayList<String> sbj_name) {
		System.out.print("이름(0.상위메뉴) : ");
		String name = scan.next();
		if (name.equals("0")) {
			System.out.println("상위메뉴로 이동하겠습니다.");
			return;
		}
		boolean check = searchStudentEquals(stu_list, sbj_name, name); // 학생 검색 일치 메소드. 일치 시 리턴값 true
		if (check == false) { // 학생 검색 일치하지 않았을 시
			for (int i = 0; i < stu_list.size(); i++) { // 검색 단어 포함된 학생 이름 출력
				if (stu_list.get(i).getName().contains(name)) {
					System.out.print(stu_list.get(i).getName() + "\t");
					check = true; // 검색 단어 포함된 학생이 있을 시 체크값 변경
				}
			}
			if (check == false) { // 검색 단어 포함 학생도 없을 시 종료
				System.out.println("검색 종료");
				return;
			}
			System.out.print("\n검색 이름 : ");
			name = scan.next();
			check = searchStudentEquals(stu_list, sbj_name, name); // 상단 부분과 동일
			if (check == true) {
				System.out.println("검색을 종료합니다.");
				return;
			} else {
				System.out.println("해당 학생이 없습니다.");
				return;
			}
		} else {
			System.out.println("검색을 종료합니다");
		}
	}

//------------------------------------------------------------------------
	void updateStudent(ArrayList<Student> stu_list, ArrayList<String> sbj_name) {
		System.out.print("이름(0.상위메뉴) : ");
		String name = scan.next();
		if (name.equals("0")) {
			System.out.println("상위메뉴로 이동하겠습니다.");
		} else {
			for (int i = 0; i < stu_list.size(); i++) {
				if (stu_list.get(i).getName().equals(name)) { // 동일 이름 찾았을 시 성적 출력
					printStudentTop(sbj_name);
					printStudent1(stu_list, i);

					System.out.print("변경할 과목명(0. 전체) : ");
					String change = scan.next();
					for (int j = 0; j < sbj_name.size(); j++) {
						if (sbj_name.get(j).equals(change)) { // 바꾸고자하는 과목명이 일치할 시
							System.out.print("점수 : ");
							int score = scan.nextInt();
							if (score < 0 || score > 100) {
								System.out.println("점수는 0~100점 사이");
								j--;
								continue;
							} else {
								stu_list.get(i).getScore().set(j, score); // 해당 학생의 해당 스코어 자리에 넣기
								stu_list.get(i).setTotal(0); // 해당 학생의 합계값 초기화
								for (int l = 0; l < sbj_name.size(); l++) { // 합계값 초기화 후 각 과목별로 더하기
									stu_list.get(i)
											.setTotal(stu_list.get(i).getTotal() + stu_list.get(i).getScore().get(l));
								}
								stu_list.get(i).setAvg(stu_list.get(i).getTotal() / sbj_name.size()); // 합계값과 과목 수를 통해 평균값 구하기
								System.out.println("점수 입력 완료");
								return;
							}
						}
					}
				}
			}
			System.out.println("검색 실패");
		}
	}

//------------------------------------------------------------------------
	// 등수 처리
	void rankStudent(ArrayList<Student> stu_list) {
		for (int i = 0; i < stu_list.size(); i++) {
			int rank = 1;
			for (int j = 0; j < stu_list.size(); j++) {
				if (stu_list.get(i).getTotal() < stu_list.get(j).getTotal()) {
					rank++;
				}
			}
			stu_list.get(i).setRank(rank);
		}
	}

//------------------------------------------------------------------------

}// class
