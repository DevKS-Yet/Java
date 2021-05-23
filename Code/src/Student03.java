import java.util.Scanner;

public class Student03 {
	static Scanner scan = new Scanner(System.in);

	static int count;
	String id, name;
	int score[], total, rank;
	double avg;

	{
		id = "S" + String.format("%03d", ++count);
	}

	Student03() {
	}

	Student03(String name, int[] score) {
		this.score = new int[score.length];
		this.name = name;
		for (int i = 0; i < score.length; i++) {
			this.score[i] = score[i];
			this.total += score[i];
		}
		this.avg = (double) this.total / score.length;
	}

//-------------------------------------------------------------------------------
	
	// 맨 처음 입력받는 부분
	static Student03[] stuNum() {
		System.out.print("최대 학생 : ");
		int stuNum = scan.nextInt();
		Student03[] s = new Student03[stuNum];
		return s;
	}

	static int sbjNum() {
		System.out.print("최대 과목 : ");
		int sbjNum = scan.nextInt();
		return sbjNum;
	}

	static String[] sbjName(int sbjNum) {
		String[] sbjName = new String[sbjNum];
		for (int i = 0; i < sbjNum; i++) {
			System.out.print("제 " + (i + 1) + "의 과목명 : ");
			sbjName[i] = scan.next();
		}
		return sbjName;
	}
//-------------------------------------------------------------------------------
	static void mainStudent(Student03[] s, String[] sbjName) {
		loopwhile1: while (true) {
			String choice = Student03.mainMenu();

			switch (choice) {
			case "1":// 추가
				Student03.addStudent(s, sbjName);
				break;
			case "2":// 출력
				Student03.printStudentAll(s, sbjName);
				break;
			case "3":// 수정
				Student03.updateStudent(s, sbjName);
				break;
			case "4":// 검색
				Student03.searchStudent(s, sbjName);
				break;
			case "5":// 등수
				Student03.rankStudent(s, sbjName);
				break;
			case "0":// 프로그램종료
				System.out.println("시스템을 종료하겠습니다.");
				break loopwhile1;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}//switch
		}//while
	}
//-------------------------------------------------------------------------------
	// 메뉴출력
	static String mainMenu() {
		System.out.println("성적관리시스템");
		System.out.println("1.추가\t2.출력\t3.수정\t4.검색\t5.등수\t0.프로그램종료");
		System.out.println("-----------------------------------------------------");
		System.out.println("선택!");
		String choice = scan.next();
		return choice;
	}// 메뉴출력
//-------------------------------------------------------------------------------
	// case1
	
	// 학생 추가
	static void addStudent(Student03[] s, String[] sbjName) {
		if (Student03.count >= s.length) {
			System.out.println("더이상 추가 ㄴㄴ");
		} else {
			System.out.println("이름 : (0.상위메뉴)");
			String name = scan.next();
			if (name.equals("0")) {
				System.out.println("상위메뉴");
			} else {
				int[] score = new int[sbjName.length];
				score = Student03.addScoreAll(sbjName);
				s[Student03.count] = new Student03(name, score);
			}
		}
	}// 학생 추가

	// 성적 입력받기
	static int[] addScoreAll(String[] sbjName) {
		int[] score = new int[sbjName.length];
		for (int i = 0; i < sbjName.length; i++) {
			System.out.print(sbjName[i] + " 점수 : ");
			int intTemp = scan.nextInt();
			if (intTemp < 0 || intTemp > 100) {
				System.out.println("점수는 0~100점 사이로");
				i--;
				continue;
			} else {
				score[i] = intTemp;
			}
		}
		return score;
	}// 성적 입력받기

	// 합계 및 평균 구하기
	public void addTotal(Student03[] s, String[] sbjName) {
		this.total = 0;
		for (int i = 0; i < sbjName.length; i++) {
			this.total += this.score[i];
		}
		this.avg = (double) this.total / sbjName.length;
	}// 합계 및 평균 구하기
//-------------------------------------------------------------------------------
	// case2

	// 전체 출력
	static void printStudentAll(Student03[] s, String[] sbjName) {
		if (Student03.count == 0) {
			System.out.println("등록된 데이터가 없습니다~");
		} else {
			Student03.printUpper(sbjName);
			for (int i = 0; i < Student03.count; i++) {
				s[i].printStudentOne(s, sbjName);
			}
		}
	}// 전체 출력

	// 상단부 출력
	static void printUpper(String[] sbjName) {
		System.out.print("학번\t이름");
		Student03.printSbjAll(sbjName);
		System.out.println("\t합계\t평균\t등수");
	}// 상단부 출력

	// 과목별 출력
	static void printSbjAll(String[] sbjName) {
		for (int i = 0; i < sbjName.length; i++) {
			System.out.print("\t" + sbjName[i]);
		}
	}// 과목별 출력

	// 한명 출력
	public void printStudentOne(Student03[] s, String[] sbjName) {
		System.out.printf("%s\t%s", this.id, this.name);
		for (int i = 0; i < sbjName.length; i++) {
			System.out.print("\t" + this.score[i]);
		}
		System.out.printf("\t%d\t%.2f\t%d\n", this.total, this.avg, this.rank);
	}// 한명 출력
//-------------------------------------------------------------------------------
	// case3

	// 학생 수정
	static void updateStudent(Student03[] s, String[] sbjName) {
		int check = 0;
		if (Student03.count == 0) {
			System.out.println("등록부터~");
			return;
		}
		System.out.print("이름 : (0.상위메뉴)");
		String name = scan.next();
		if (name.equals("0")) {
			System.out.println("상위메뉴로~~");
			return;
		}
		if (check == 0) {
			check = Student03.equalsUpdate(s, sbjName, name, check);
		}
		if (check == 0) {
			Student03.containsUpdate(s, sbjName, name, check);
		}
		if (check == 0) {
			System.out.println("그냥 되돌아갈게;;");
		}
	}// 학생 수정

	// 수정 중 이름값 같을 경우
	static int equalsUpdate(Student03[] s, String[] sbjName, String name, int check) {
		for (int i = 0; i < Student03.count; i++) {
			if (s[i].name.equals(name)) {
				check = 1;
				Student03.printUpper(sbjName);
				s[i].printStudentOne(s, sbjName);
				System.out.print("어떤 과목을 바꾸겠음?(" + (sbjName.length + 1) + ". 전체) : ");
				name = scan.next();
				for (int k = 0; k < sbjName.length; k++) {
					if (name.equals(sbjName[k])) {
						System.out.println(name + " 점수 : ");
						int checkScore = scan.nextInt();
						if (checkScore < 0 || checkScore > 100) {
							System.out.println("점수는 0~100점 사이로");
							k--;
							continue;
						} else {
							s[i].score[k] = checkScore;
							s[i].addTotal(s, sbjName);
							System.out.println("수정 완료!");
							return check;
						}
					} else {
						System.out.println("찾는 중.....");
					}
				}
				if (name.equals("" + (sbjName.length + 1))) {
					s[i].score = Student03.addScoreAll(sbjName);
					s[i].addTotal(s, sbjName);
					System.out.println("전체 수정 완료!");
					return check;
				} else {
					System.out.println("잘못 입력한듯? 취소할겡~");
					return check;
				}
			}
		}
		return check;
	}// 수정 중 이름값 같을 경우

	// 수정 중 이름값 포함 경우
	static int containsUpdate(Student03[] s, String[] sbjName, String name, int check) {
		System.out.println("정확한 이름으로 다시 적어달라구");
		for (int i = 0; i < Student03.count; i++) {
			if (s[i].name.contains(name)) {
				System.out.print(s[i].name + "\t");
			}
		}
		name = scan.next();
		Student03.equalsUpdate(s, sbjName, name, check);
		return check;
	}// 수정 중 이름값 포함 경우
//-------------------------------------------------------------------------------
	// case4

	// 학생 검색
	static void searchStudent(Student03[] s, String[] sbjName) {
		int check = 0;
		if (Student03.count == 0) {
			System.out.println("등록부터 해줄랭?");
			return;
		}
		System.out.println("검색 이름 : ");
		String name = scan.next();
		check = Student03.equalsSearch(s, sbjName, name, check);
		check = Student03.containsSearch(s, sbjName, name, check);
		if (check == 0) {
			System.out.println("학생이 없습니다 ㅠ");
		}
	}// 학생 검색

	// 검색 중 동일 이름 나왔을 시
	static int equalsSearch(Student03[] s, String[] sbjName, String name, int check) {
		for (int i = 0; i < Student03.count; i++) {
			if (s[i].name.equals(name)) {
				Student03.printUpper(sbjName);
				s[i].printStudentOne(s, sbjName);
				check = 1;
			}
		}
		return check;
	}// 검색 중 동일 이름 나왔을 시

	// 검색 중 포함 이름 나왔을 시
	static int containsSearch(Student03[] s, String[] sbjName, String name, int check) {
		if (check == 0) {
			for (int i = 0; i < Student03.count; i++) {
				if (s[i].name.contains(name)) {
					System.out.print(s[i].name + "\t");
				}
			}
			System.out.println("이름.... 다시 제대로 적어줄랭?");
			name = scan.next();
			check = Student03.equalsSearch(s, sbjName, name, check);
		}
		return check;
	}// 검색 중 포함 이름 나왔을 시
//-------------------------------------------------------------------------------
	// case5

	// 등수 처리
	static void rankStudent(Student03[] s, String[] sbjName) {
		if(Student03.count==0) {
			System.out.println("등록부터~");
			return;
		}
		System.out.println("등수 처리중~~");
		for (int i = 0; i < Student03.count; i++) {
			s[i].rank = 1;
			for (int j = 0; j < Student03.count; j++) {
				if (s[i].total < s[j].total) {
					s[i].rank++;
				}
			}
		}
		System.out.println("등수 처리 완료!");
	}// 등수 처리
//-------------------------------------------------------------------------------
}// class
