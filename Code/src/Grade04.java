import java.util.Scanner;

public class Grade04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Student01.prologue();
		Student01[] s = new Student01[Student01.stuNum]; // 입력한 최대학생수만큼 배열 만들기

		loopwhile1: while (true) {

			// 상위메뉴
			Student01.mainPrint();

			String choice = scan.next();

			switch (choice) {
			case "1":// 검색
				Student01.searchStudentAll(s);
				break;
			case "2":// 추가
				Student01.addStudentAll(s);
				break;
			case "3":// 수정
				Student01.insertStudentAll(s);
				break;
			case "4":// 삭제
//				checkData = 0;
//				if(Student01.count==0) {
//					System.out.println("등록된 학생 성적이 없습니다. 추가해주세요.");
//					break;
//				}
//				System.out.println("삭제할 학생의 이름을 입력해주세요(0.취소/"+(Student01.count+1)+".전체삭제)");
//				checkName = scan.next();
//				Student01.deleteAll(s, checkName, checkData);
//				Student01.deleteOne(s, checkName, checkData);
//				
//				Student01.noData(checkData);
				System.out.println("미구현입니더~");
				break;
			case "5":// 등수
				Student01.rankStudent(s);
				break;
			case "6":// 출력
				Student01.printUpper(); // 상단부분 출력
				Student01.printAllStudent(s); // 점수부분 출력
				break;
			case "0":// 프로그램종료
				System.out.println("프로그램을 종료합니다.");
				break loopwhile1;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			}// switch
		} // while
		scan.close();
	}// main
}// class
