import java.util.Scanner;

public class Student01 {

	static Scanner scan = new Scanner(System.in);

	static int count; // 생성된 학생 수
	static int sbjNum; // 과목 수
	static int stuNum; // 총 학생 수
	static String[] sbjName = new String[100]; // 이거 나중에 인풋받는 걸로 바꿀 수 있도록

	static int intTemp; // 임시 정수 저장소
	static String strTemp; // 임시 문자열 저장소
	static int checkData;
	static String checkName;

	int id = ++count; // 학생 고유번호
	String name; // 학생 이름
	int[] score = new int[sbjNum]; // 과목별 점수
	int total; // 합계
	int rank; // 등수

	// 상단부분
	static void prologue() {
		getStudentNumber();
		getSubjectNumber();
		getSubjectName();
	}// 상단부분
	
	// 최대 학생 수 받기
	static void getStudentNumber() {
		System.out.print("최대 학생의 숫자를 입력하세요 : ");
		stuNum = scan.nextInt();
	}// 최대 학생 수 받기
	
	// 과목 수 받기
	static void getSubjectNumber() {
		System.out.print("과목 수를 입력하세요 : ");
		sbjNum = scan.nextInt();
	}// 과목 수 받기
	
	// 과목 명 받기
	static void getSubjectName() {
		System.out.println("과목별로 이름을 입력해주세요");
		for (int i = 0; i < sbjNum; i++) {
			System.out.print("제 " + (i + 1) + "과목은 : ");
			sbjName[i] = scan.next();
		}
	}// 과목 명 받기

	// 등록확인(검색,수정,삭제,등수,출력)

	// 등록 정보 없을 시
	static void noData() {
		if (checkData == 0) {
			System.out.println("해당 학생의 정보가 존재하지 않습니다.");
		}
	}// 등록 정보 없을 시

	// 메인메뉴
	static void mainPrint() {
		System.out.println("\t\t[ 학생관리시스템 ]");
		System.out.println(
				"1.검색\t2.추가\t3.수정\t4.삭제\t5.등수\t6.출력\t0.프로그램종료\n----------------------------------------------------------\n어떤 것을 선택하시겠습니까?");
	}// 메인메뉴

	// 과목 명 나열한 것 출력
	static void sbjPrint() {
		for (int i = 0; i < sbjNum; i++) {
			System.out.print((i + 1) + ". " + sbjName[i] + "\t");
		}
	}// 과목 명 나열한 것 출력
//case1----------------------------------------------------------
	// 검색
	static void searchStudent(Student01[] s) {
		System.out.println("찾고자하는 학생의 이름을 적어주세요.");
		strTemp = scan.next();
		for (int i = 0; i < Student01.count; i++) {
			if (s[i].name.contains(strTemp)) {
				if (intTemp == 0) {
					Student01.printUpper();
				}
				s[i].printStudentScore();
				intTemp = 1;
			}
		}
	}// 검색
	
	//검색 마무리
	static void searchStudentAll(Student01[] s) {
		while(true) {
			checkData = 0;
			// count가 0 일 경우 상위메뉴로 이동
			if (Student01.count == 0) {
				System.out.println("등록된 학생 성적이 없습니다. 추가해주세요.");
				break;
			}
			// count가 0이 아닐 경우
			Student01.searchStudent(s);
			// 학생 정보가 없을 시
			Student01.noData();
			break;
		}
	}//검색 마무리
//case2----------------------------------------------------------
	// 객체 생성 및 정보 추가
	static void addStudent(Student01[] s, String checkName) {
		s[Student01.count] = new Student01();
		s[Student01.count - 1].addStudentScore(checkName);
	}// 객체 생성 및 정보 추가

	// 추가 이름 및 점수
	public void addStudentScore(String checkName) {
		this.name = checkName;
		this.total = 0;
		for (int i = 0; i < sbjNum; i++) {
			System.out.print(sbjName[i] + "의 점수는 : ");
			this.score[i] = scan.nextInt();
			if(this.score[i]<0 || this.score[i]>100) {
				System.out.println("0~100점 사이로 다시 입력해주세요.");
				i--;
				continue;
			}
			this.total += this.score[i];
		}
		System.out.println(this.name + "의 성적이 추가되었습니다.");
	}// 추가 이름 및 점수
	
	//추가마무리
	static void addStudentAll(Student01[] s) {
		while (true) {
			if (Student01.count > Student01.stuNum) {
				System.out.println("더이상 추가할 수 없습니다.");
				break;
			}
			System.out.println("학생 이름을 입력하세요(0.상위메뉴) : ");
			checkName = scan.next();
			if (checkName.equals("0")) {
				System.out.println("상위 메뉴로 이동하겠습니다.");
				break;
			}
			// 학생 이름이 0이 아닐경우 추가 및 addstudent함
			Student01.addStudent(s, checkName);
			break;
//		while(true) {
//			for(int i=Student01.count; i<Student01.stuNum; i++) {
//				if(null != s[i].name) {
//					Student01.count++;
//				} else {
//					break;
//				}
//			}
//			break;
//		}
		}
	}// 추가마무리
//case3--------------------------------------------------------
	// 수정(동일 이름 찾았을 경우)
	public void insertStudent(String checkName) {
		System.out.println("현재 " + this.name + "의 성적은 이렇습니다. 어떤 것을 수정하시겠습니까?(0.취소)");
		printUpper();
		this.printStudentScore();
		Student01.sbjPrint();
		System.out.print((Student01.sbjNum + 1) + ". 전체");
		intTemp = scan.nextInt();
		if (intTemp == 0) {
			System.out.println("취소하셨습니다.");
			return;
		}
		if (intTemp == (Student01.sbjNum + 1)) {
			this.addStudentScore(checkName);
			System.out.println(this.name + "의 점수가 수정되었습니다.");
		}
		for (int j = 0; j < Student01.sbjNum; j++) {
			if (intTemp == (j + 1)) {
				System.out.print(Student01.sbjName[j] + "의 점수 : ");
				this.total -= this.score[j];
				this.score[j] = scan.nextInt();
				this.total += this.score[j];
			}
		}
	}// 수정

	// 동일 이름을 찾지 못한 경우 포함 이름 출력
	static void containsPrint(Student01[] s, String checkName) {
		for (int i = 0; i < Student01.count; i++) {
			if (s[i].name.contains(checkName)) {
				System.out.print(s[i].name + "\t");
				Student01.intTemp = 1;
			}
		}
	}// 동일 이름

	// 해당 문자가 있는 이름을 찾았을 경우 다시 입력 및 수정 시키기
	static void reInsertStudent(Student01[] s) {
		if (Student01.intTemp == 1) {
			System.out.println("\n수정할 학생의 이름을 제대로 다시 적어주세요");
			strTemp = scan.next();
			for (int i = 0; i < Student01.count; i++) {
				if (s[i].name.equals(strTemp)) {
					s[i].insertStudent(strTemp);
				}
			}
		}
	}// 해당 문자
	
	//수정마무리
	static void insertStudentAll(Student01[] s) {
		loopwhile1:while(true) {
			checkData = 0;
			System.out.println("수정할 학생의 이름을 입력해주세요.");
			if (Student01.count == 0) {
				System.out.println("등록된 학생 성적이 없습니다. 추가해주세요.");
				break;
			}
			checkName = scan.next();
			// 동일 이름을 찾았을 경우
			for (int i = 0; i < Student01.count; i++) {
				if (s[i].name.equals(checkName)) {
					s[i].insertStudent(checkName);
					break loopwhile1;
				}
			}
			// 동일 이름을 찾지 못한 경우 포함 이름 출력
			Student01.containsPrint(s, checkName);
			// 해당 문자가 있는 이름을 찾았을 경우 다시 입력 및 수정 시키기
			Student01.reInsertStudent(s);
			// 찾는 이름 없을 시
			Student01.noData();
			break;
		}
	}

//case4-----------------------------------------------------------
	// 전체삭제
	static void deleteAll(Student01[] s, String checkName, int checkData) {
		if (checkName.equals(Integer.toString(Student01.count + 1))) { // 전체삭제
			for (int i = 0; i < Student01.count; i++) {
				s[i].id = 0;
				s[i].name = "";
				for (int j = 0; j < Student01.sbjNum; j++) {
					s[i].score[j] = 0;
				}
				s[i].total = 0;
				s[i].rank = 0;
			}
			Student01.count = 0;
			System.out.println("전체 삭제되었습니다.");
			checkData = 1;
		}
	}// 전체삭제

	// 한명삭제
	static void deleteOne(Student01[] s, String checkName, int checkData) {
		for (int i = 0; i < Student01.count; i++) { // 한명만 지우기
			if (checkName.equals(s[i].name)) {
				checkName = s[i].name;
				s[i].id = 0;
				s[i].name = "";
				for (int j = 0; j < Student01.sbjNum; j++) {
					s[i].score[j] = 0;
				}
				s[i].total = 0;
				s[i].rank = 0;
				Student01.count = i;
				System.out.println(checkName + "의 성적이 삭제되었습니다.");
				checkData = 1;
			}
		}
	}// 한명삭제

//case5-----------------------------------------------------------
	// 등수
	static void rankStudent(Student01[] s) {
		for (int i = 0; i < Student01.count; i++) {
			s[i].rank = 1;
			for (int j = 0; j < Student01.count; j++) {
				if (s[i].total < s[j].total) {
					s[i].rank++;
				}
			}
		}
	}// 등수
//case6----------------------------------------------------------
	// 출력(상단부분)

	static void printUpper() {
		System.out.print("ID\t이름");
		for (int i = 0; i < sbjNum; i++) {
			System.out.print("\t" + Student01.sbjName[i]);
		}
		System.out.println("\t합계\t평균\t등수");
	}// 출력(상단부분)

	// 출력(개인 점수)
	public void printStudentScore() {
		System.out.print(this.id + "\t" + this.name);
		for (int i = 0; i < score.length; i++) {
			System.out.print("\t" + this.score[i]);
		}
		System.out.print("\t" + this.total);
		System.out.printf("\t%.2f", (float) this.total / sbjNum);
		System.out.println("\t" + this.rank);
	}// 출력(개인 점수)

	// 출력(전체 점수)
	static void printAllStudent(Student01[] s) {
		for (int i = 0; i < Student01.count; i++) {
			s[i].printStudentScore();
		}
	}// 출력(전체 점수)
//----------------------------------------------------------------
}// class
