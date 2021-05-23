import java.util.ArrayList;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {

		// 로또 자동뽑기 & 1등 당첨될때까지 돌리기
		Scanner scan = new Scanner(System.in);

		// 1등 될때까지 루프 돌리기
		int prize = 0;
		int buylotto = 0;
		while (prize < 5) {

			// 로또 번호 적기
//		System.out.println("번호를 적어주세요.");
//		int[] input = new int[6];
//		for(int i=0;i<input.length;i++) {
//			input[i] = scan.nextInt();
//		}

			// 자동뽑기 생성
			int[] autoBall = new int[45];
			for (int i = 0; i < 45; i++) {
				autoBall[i] = i + 1;
			}
			int autoBallTemp = 0;
			for (int i = 0; i < 200; i++) {
				int autoBallRandom = (int) (Math.random() * 45);
				autoBallTemp = autoBall[0];
				autoBall[0] = autoBall[autoBallRandom];
				autoBall[autoBallRandom] = autoBallTemp;
			}
			System.out.print("뽑힌 번호는");
			for (int i = 0; i < 6; i++) {
				System.out.printf(" %d", autoBall[i]);
			}

			// 공 생성
			int[] ball = new int[45];
			for (int i = 0; i < 45; i++) {
				ball[i] = i + 1;
			}

			// 공 랜덤으로 섞기
			int ballTemp = 0;
			for (int i = 0; i < 200; i++) {
				int ballRandom = (int) (Math.random() * 45);
				ballTemp = ball[0];
				ball[0] = ball[ballRandom];
				ball[ballRandom] = ballTemp;
			}

			// 번호 맞는지 확인
			int count = 0;
			ArrayList<Integer> correctNumber = new ArrayList<Integer>();
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (autoBall[i] == ball[j]) { // manual일 경우 input, auto일 경우 autoBall
						correctNumber.add(autoBall[i]); // 위 내용 동일
						count++;
					}
				}
			}

			// 공 앞에 6자릿수 출력
			System.out.print("\n당첨 번호는");
			for (int i = 0; i < 6; i++) {
				System.out.printf(" %d", ball[i]);
			}

			// 확인된 번호 출력 및 몇개 맞추었는지 출력
			System.out.printf("\n맞춘 갯수는 %d개 입니다.", count);
			System.out.print("\n맞춘 번호는 " + correctNumber);
			System.out.println("입니다.");
			
			prize = correctNumber.size();
			buylotto++;
		}
		System.out.print("님이 산 로또 갯수는 " + buylotto);

		scan.close();
	} // main

} // class
