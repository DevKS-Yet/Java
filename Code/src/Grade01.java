import java.util.Scanner;

public class Grade01 {

	public static void main(String[] args) {
		
		// 학생 성적을 배열로 받아보기  담에 이중으로 바꿔보자
		Scanner scan = new Scanner(System.in);
		
		// 입력할 학생 수 받기
		System.out.println("입력할 학생의 수를 적어주세요.");
		int studentNumberInput = scan.nextInt();
		
		String[] name = new String[studentNumberInput];
		int[] kor = new int[studentNumberInput];
		int[] eng = new int[studentNumberInput];
		int[] math = new int[studentNumberInput];
		int[] total = new int[studentNumberInput];
		double[] avg = new double[studentNumberInput];
		
		for(int i=0; i<studentNumberInput; i++) {
			System.out.println("학생 이름을 입력하세요");
			name[i] = scan.next();
			System.out.printf("%s의 국어 점수를 입력하세요\n", name[i]);
			kor[i] = scan.nextInt();
			System.out.printf("%s의 영어 점수를 입력하세요\n", name[i]);
			eng[i] = scan.nextInt();
			System.out.printf("%s의 수학 점수를 입력하세요\n", name[i]);
			math[i] = scan.nextInt();
		}
		
		//  학생들의 합계와 평균 구하기
		for(int i=0; i<studentNumberInput; i++) {
			total[i] = kor[i]+eng[i]+math[i];
			avg[i] = total[i]/3.0;
		}
		
		// 학생 이름과 점수 및 합계, 평균 출력하기
		System.out.println("학생이름\t국어\t영어\t수학\t합계\t평균");
		for(int i=0; i<studentNumberInput; i++) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\n", name[i], kor[i], eng[i], math[i], total[i], avg[i]);
		}
		
		scan.close();
	}
}
