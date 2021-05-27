package student02;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {

	static Scanner scan = new Scanner(System.in);

//-----------------------------------------------------------------------
	
	void main(ArrayList<Student> s) {
		while(true) {
			printMenu();
			String choice = scan.next();
			
			switch(choice) {
			case "1"://추가
				addStudent(s);
				break;
			case "2"://출력
				printStudentTop();
				printStudent(s);
				break;
			case "3"://검색
				searchStudent(s);
				break;
			case "4"://수정
				updateStudent(s);
				break;
			case "5"://등수
				rankStudent(s);
				break;
			case "6"://종료
				System.out.println("시스템 종료하겠음");
				return;
			default:
				System.out.println("다시 입력해라");
				break;
			}
		}
	}
//-----------------------------------------------------------------------
	
	// printMenu
	void printMenu() {
		System.out.println(" [ 학생성적관리 시스템 ] ");
		System.out.println("1. 학생성적추가");
		System.out.println("2. 학생성적출력");
		System.out.println("3. 학생성적검색");
		System.out.println("4. 학생성적수정");
		System.out.println("5. 등수처리");
		System.out.println("6. 시스템 종료");
	}// printMenu
//-----------------------------------------------------------------------

	// 학생 추가
	void addStudent(ArrayList<Student> s) {
		while (true) {
			System.out.print("이름(0. 상위메뉴) : ");
			String name = scan.next();
			if (name.equals("0")) {
				System.out.println("상위메뉴로 이동");
				return;
			}
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			if(kor <0 || kor >100) {
				System.out.println("점수는 0~100점 사이~");
				continue;
			}
			System.out.print("영어 : ");
			int eng = scan.nextInt();
			if(eng <0 || eng >100) {
				System.out.println("점수는 0~100점 사이~");
				continue;
			}
			System.out.print("수학 : ");
			int math = scan.nextInt();
			if(math <0 || math >100) {
				System.out.println("점수는 0~100점 사이~");
				continue;
			}
			s.add(new Student(name, kor, eng, math));
			System.out.println(name + "이 등록되었습니다.");
		}
	}// 학생 추가
//-----------------------------------------------------------------------

	// 학생 출력 상단
	void printStudentTop() {
		System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "ID", "이름", "국어", "영어", "수학", "합계", "평균", "등수");
	}// 학생 출력 상단

	// 학생 출력 1명
	void printStudent1(ArrayList<Student> s, int i) {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", s.get(i).getId(), s.get(i).getName(), s.get(i).getKor(),
				s.get(i).getEng(), s.get(i).getMath(), s.get(i).getTotal(), s.get(i).getAvg(), s.get(i).getRank());
	} // 학생 출력 1명

	// 학생 출력 전체
	void printStudent(ArrayList<Student> s) {
		for (int i = 0; i < s.size(); i++) {
			printStudent1(s, i);
		}
	}// 학생 출력 전체
//-----------------------------------------------------------------------

	// 학생 검색
	void searchStudent(ArrayList<Student> s) {
		boolean check = false;
		System.out.print("검색 이름 : ");
		String search = scan.next();
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getName().contains(search)) {
				if(check == false) { // 출력 상단부분 한번만
					printStudentTop();					
				}
				printStudent1(s, i);
				check = true;
			}
		}
		if (check == false) {
			System.out.println("그런 이름 없음~");
		}
	}// 학생 검색
//-----------------------------------------------------------------------

	// 학생 합계 평균 계산
	void calTotalAvg(ArrayList<Student> s, int i) {
		s.get(i).setTotal(s.get(i).getKor() + s.get(i).getEng() + s.get(i).getMath());
		s.get(i).setAvg(s.get(i).getTotal() / 3.0);
	}// 학생 합계 평균 계산

	// 이름값 동일시 수정 메서드
	int equalsStudent(String search, ArrayList<Student> s, int check) {
		for (int i = 0; i < s.size(); i++) {
			if (search.equals(s.get(i).getName())) {
				check = 1;
				printStudentTop();
				printStudent1(s, i);
				System.out.println("어떤거 수정하실?");
				System.out.println("0. 국어\t1. 영어\t2. 수학\t5. 취소");
				search = scan.next();
				if (search.equals("5")) {
					System.out.println("취소함");
					break;
				}
				switch (search) { // i--있는 것은 되돌리기 위함
				case "0":
					System.out.print("국어 : ");
					int score = scan.nextInt();
					if (score < 0 || score > 100) {
						System.out.println("점수는 0~100점 사이");
						i--;
						break;
					}
					s.get(i).setKor(score);
					calTotalAvg(s, i);
					System.out.println("수정이 완료 되었습니다");
					break;
				case "1":
					System.out.print("영어 : ");
					score = scan.nextInt();
					if (score < 0 || score > 100) {
						System.out.println("점수는 0~100점 사이");
						i--;
						break;
					}
					s.get(i).setEng(score);
					calTotalAvg(s, i);
					System.out.println("수정이 완료 되었습니다");
					break;
				case "2":
					System.out.print("수학 : ");
					score = scan.nextInt();
					if (score < 0 || score > 100) {
						System.out.println("점수는 0~100점 사이");
						i--;
						break;
					}
					s.get(i).setKor(score);
					calTotalAvg(s, i);
					System.out.println("수정이 완료 되었습니다");
					break;
				default:
					System.out.println("잘못 입력한듯?");
					i--;
					break;
				}// switch
			} // if
		} // for
		return check;
	}// 이름값 동일시 수정 메서드

	// 학생 수정
	void updateStudent(ArrayList<Student> s) {
		int check = 0;
		System.out.println("수정 이름 : ");
		String search = scan.next();
		equalsStudent(search, s, check); // 이름값 동일시 수정 메서드

		if (check == 0) { // 동일값 없을시 포함값 출력
			for (int i = 0; i < s.size(); i++) {
				if (s.get(i).getName().contains(search)) {
					System.out.print(s.get(i).getName() + "\t");
					check = 2;
				}
			}
		}
		
		if (check == 2) { // 포함값 있을 시 실행
			System.out.println("\n누구 수정할거? 다시적으삼");
			search = scan.next();
			equalsStudent(search, s, check);
		}
		
		if(check == 0) { // 동일, 포함값 없을 시 실행
			System.out.println("그런 이름 없음");
		}
	}// 학생 수정
//-----------------------------------------------------------------------
	
	// 등수 처리
	void rankStudent(ArrayList<Student> s) {
		for(int i=0; i<s.size();i++) {
			int rank = 1;
			for(int j=0; j<s.size();j++) {
				if(s.get(i).getTotal() < s.get(j).getTotal()) {
					rank++;
				}
			}
			s.get(i).setRank(rank);
		}
	}// 등수 처리
//-----------------------------------------------------------------------

}// class
