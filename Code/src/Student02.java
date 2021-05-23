import java.util.Scanner;

public class Student02 {

	static Scanner scan = new Scanner(System.in);

	static int count;
	String id;
	String name;
	int kor, eng, math, total, rank;
	double avg;

	// 인스턴스 블록
	{
		id = "S" + String.format("%03d", ++count);
	}

	// 기본생성자
	Student02() {
	}

	// 변수4개 생성자
	Student02(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.avg = (kor + eng + math) / 3.0;
	}// 생성자
//-------------------------------------------------------------------------------
	// 메뉴출력
	static void mainPrint() {
		System.out.println("학생성적관리시스템");
		System.out.println("1.추가\t2.검색\t3.수정\t4.등수\t5.출력\t0.프로그램 종료");
		System.out.println("선택하세요");
	}// 메뉴출력
//-------------------------------------------------------------------------------
//case1	
	// 국어 점수 추가
	static int addKor() {
		System.out.println("국어 : ");
		int kor = scan.nextInt();
		return kor;
	}// 국어 점수 추가
	// 영어 점수 추가
	static int addEng() {
		System.out.println("영어 : ");
		int eng = scan.nextInt();
		return eng;
	}// 영어 점수 추가
	// 수학 점수 추가
	static int addMath() {
		System.out.println("수학 : ");
		int math = scan.nextInt();
		return math;
	}// 수학 점수 추가
	// 추가
	static void addStudent(Student02[] s) {
		for (int i = count; i < s.length; i++) {
			System.out.println("이름 : (0.상위메뉴)");
			String name = scan.next();
			if (name.equals("0")) {
				System.out.println("상위메뉴로 이동");
				break;
			} else {
				int kor = addKor();
				int eng = addEng();
				int math = addMath();
				s[i] = new Student02(name, kor, eng, math);
				System.out.println(name + "의 성적이 추가되었습니다.");
				System.out.println("계속 추가하시겠습니까?(예/아니요)");
				name = scan.next();
				if (name.equals("예")) {
					System.out.println("추가를 진행합니다.");
					continue;
				} else if (name.equals("아니요")) {
					System.out.println("추가멈춰~");
					break;
				} else {
					System.out.println("적힌대로만 좀 적어주시면 감사하겠음");
					break;
				}
			}
		}
	}// 추가
	//추가 끝
	static void addStudentMain(Student02[] s) {
		if (Student02.count >= 10) {
			System.out.println("더이상 추가가 불가합니다.");
		} else {
		Student02.addStudent(s);
		}
	}
//-------------------------------------------------------------------------
//case2
	// 검색
	static void searchStudent(Student02[] s) {
		System.out.println("검색 이름 : ");
		String name = scan.next();
		for (int i = 0; i < Student02.count; i++) {
			if (s[i].name.contains(name)) {
				Student02.printUpper();
				s[i].printStudentOne(s);
			}
		}
	}// 검색
//-------------------------------------------------------------------------
//case3
	//수정
	static void updateStudent(Student02[] s) {
		System.out.println("수정 이름 : ");
		String name = scan.next();
		for(int i=0; i<Student02.count;i++) {
			if(name.equals(s[i].name)) {
				Student02.printUpper();
				s[i].printStudentOne(s);
				System.out.println("어떤 과목 수정?\n1.국어\t2.영어\t3.수학\n골라");
				int select = scan.nextInt();
				if(select-1==0) {
					s[i].kor = addKor();
				} else if(select-1==1) {
					s[i].eng = addEng();
				} else if(select-1==2) {
					s[i].math = addMath();
				} else {
					System.out.println("수정 기회는 없댜~");
					break;
				}
				s[i].total = s[i].kor+s[i].eng+s[i].math;
				s[i].avg = s[i].total/3.0;
				System.out.println("수정 완료!");
			}
		}
	}// 수정
//-------------------------------------------------------------------------
//case4
	// 등수처리
	static void rankStudent(Student02[] s) {
		for (int i = 0; i < Student02.count; i++) {
			s[i].rank = 1;
			for (int j = 0; j < Student02.count; j++) {
				if (s[i].total < s[j].total) {
					s[i].rank++;
				}
			}
		}
	}// 등수처리
//--------------------------------------------------------------------------
//case5
	// 상단 출력
	static void printUpper() {
		System.out.print("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
	}// 상단 출력
	// 성적 1명분 출력
	public void printStudentOne(Student02[] s) {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", this.id, this.name, this.kor, this.eng, this.math,
				this.total, this.avg, this.rank);
	}// 성적 1명분 출력
	// 성적 전체 출력
	static void printStudentAll(Student02[] s) {
		Student02.printUpper();
		for(int i=0; i<Student02.count; i++) {
			s[i].printStudentOne(s);
		}
	}// 성적 전체 출력
//-------------------------------------------------------------------------
}
