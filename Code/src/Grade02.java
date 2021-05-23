import java.util.Scanner;

public class Grade02 {

	public static void main(String[] args) {

		// 학생 성적을 이중배열로 배치해보자! [이름][성적들] 개념으로

		Scanner scan = new Scanner(System.in);

		// 학생 수 및 과목 수 정하기
		System.out.print("입력할 학생의 수를 적어주세요 : ");
		int studentNumber = scan.nextInt(); // 학생 수
		System.out.print("입력할 과목 수를 적어주세요 : ");
		int subjectNumber = scan.nextInt(); // 과목 수

		// 과목명 받기
		String[] subjectName = new String[subjectNumber]; // 과목명 받기위한 배열 생성
		for (int i = 0; i < subjectNumber; i++) {
			System.out.print("제 " + (i + 1) + "번 과목 : ");
			subjectName[i] = scan.next();
		}

		// 학생 이름을 넣을 배열과 점수를 넣을 이중배열 만들기
		String[] studentName = new String[studentNumber]; // 학생 이름은 String임으로 따로 배열 생성
		int[][] subjectScore = new int[studentNumber][subjectNumber + 1]; // 학생 수와 과목 수만큼 받기 위함

		for (int i = 0; i < studentNumber; i++) {
			System.out.println(i + "번째 학생 이름 : ");
			studentName[i] = scan.next(); // 학생 이름 배열에 받기
			for (int j = 0; j < subjectNumber; j++) {
				System.out.println(subjectName[j] + "의 점수 : ");
				subjectScore[i][j] = scan.nextInt(); // 점수 이중배열에 받기
				subjectScore[i][subjectNumber] += subjectScore[i][j]; // 점수의 합계
			}
		}

		// 출력 틀 윗부분 만들어주기
		System.out.print("이름");
		for (int i = 0; i < subjectNumber; i++) {
			System.out.print("\t" + subjectName[i]); // 과목 수 만큼 반복하며 출력
		}
		System.out.println("\t합계\t평균");
		for (int i = 0; i < subjectNumber + 3; i++) {
			System.out.print("--------"); // 과목 수와 이름, 합계, 평균 길이 만큼 선 긋기
		}

		// 몸통부분 출력하기
		for (int i = 0; i < studentNumber; i++) {
			System.out.print("\n" + studentName[i]); // 학생 이름 출력
			for (int j = 0; j < subjectNumber + 1; j++) {
				System.out.printf("\t%d", subjectScore[i][j]); // 이름 출력 후 과목 수 만큼 점수 출력 + 합계
			}
			System.out.printf("\t%.2f", (double) subjectScore[i][subjectNumber] / subjectNumber); // 합계에서 과목 수만큼 나누어 평균
		}
		scan.close();
	} // main
} // class
