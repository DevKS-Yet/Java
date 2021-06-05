import java.util.Scanner;

public class Grade05 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Student02[] s = new Student02[10];

		//치기 귀찮아서 배열 10개 생성용
//		String[] nameData = { "조", "규", "상", "조규", "규상", "조상", "조규상", "규상조", "상조규", "상규" };
//		int[] korData = { 10, 20, 33, 43, 51, 35, 63, 86, 13, 43 };
//		int[] engData = { 100, 50, 40, 44, 34, 62, 64, 71, 39, 39 };
//		int[] mathData = { 70, 57, 73, 14, 53, 65, 87, 14, 56, 23 };

		loopwhile1: while (true) {

			Student02.mainPrint();
			String choice = scan.next();

			switch (choice) {
			case "1":// 추가
				
				//배열 10개 생성용
//				for (int i = 0; i < 10; i++) {
//					s[i] = new Student02(nameData[i], korData[i], engData[i], mathData[i]);
//				}

				Student02.addStudentMain(s);
				break;
			case "2":// 검색
				Student02.searchStudent(s);
				break;
			case "3":// 수정
				Student02.updateStudent(s);
				break;
			case "4":// 등수
				Student02.rankStudent(s);
				break;
			case "5":// 출력
				Student02.printStudentAll(s);
				break;
			case "0":
				System.out.println("종료 시스템");
				break loopwhile1;
			default:
				System.out.println("입력 잘못");
				break;
			}//switch
		} // while
		scan.close();
	}// main
}// class