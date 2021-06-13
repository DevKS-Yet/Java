package lotto02;

import java.util.Scanner;

public class Process {

	static Scanner scan = new Scanner(System.in);

	void printMenu() {
		System.out.println("1. 생성");
		System.out.println("2. 섞기");
		System.out.println("3. 자동추첨");
		System.out.println("4. 수동추첨");
		System.out.println("5. 결과작업");
		System.out.println("6. 결과출력");
		System.out.println("9. 추첨될때까지");
		System.out.println("0. 종료");
	}

	void createBall(Ball b) {
		int[] ball = b.getBall();
		for (int i = 0; i < b.getBall().length; i++) {
			ball[i] = i + 1;
		}
		b.setBall(ball);
		System.out.println("생성 완료");
	}

	void shuffleBall(Ball b) {
		int[] ball = b.getBall();
		System.out.println("몇번 섞으시겠습니꽈?");
		int input = scan.nextInt();
		for (int i = 0; i < input; i++) {
			int rdm = (int) (Math.random() * 44);
			int tmp = ball[0];
			ball[0] = ball[rdm];
			ball[rdm] = tmp;
		}
		b.setBall(ball);
	}

	void randomBall(Ball b) {
		int[] ball = b.getRandom();
		for (int i = 0; i < b.getRandom().length; i++) {
			ball[i] = (int) (Math.random() * 44);
			for (int j = 0; j < i; j++) {
				if (ball[i] == ball[j]) {
					i--;
				}
			}
		}
		b.setRandom(ball);
	}

	void chooseBall(Ball b) {
		int[] ball = b.getPlayer();
		for (int i = 0; i < 6; i++) {
			ball[i] = scan.nextInt();
			if (ball[i] < 1 || ball[i] > 45) {
				System.out.println("숫자는 1~45까지만");
				i--;
			} else {
				for (int j = 0; j < i; j++) {
					if (ball[i] == ball[j]) {
						System.out.println("아까 입력한 숫자임");
						i--;
					}
				}
			}
		}
		b.setPlayer(ball);
	}

	void resultBall(Ball b) {
		int[] player = b.getPlayer();
		int[] random = b.getRandom();
		int[] ball = b.getBall();
		int[] correct = b.getCorrect();
		int[] correctrdm = b.getCorrectrdm();
		for (int i = 0; i < b.getPlayer().length; i++) {
			for (int j = 0; j < b.getPlayer().length; j++) {
				if (player[i] == ball[j]) {
					correct[b.getCount()] = player[i];
					b.setCount(b.getCount() + 1);
				} else if (random[i] == ball[j]) {
					correctrdm[b.getCountrdm()] = random[i];
					b.setCountrdm(b.getCountrdm() + 1);
				}
			}
		}
		b.setCorrect(correct);
		b.setCorrectrdm(correctrdm);
		System.out.print("\n자동추첨 :");
		for (int i = 0; i < b.getRandom().length; i++) {
			System.out.print(" " + random[i]);
		}
		System.out.print("\n수동추첨 :");
		for (int i = 0; i < b.getPlayer().length; i++) {
			System.out.print(" " + player[i]);
		}
		System.out.println();
	}

	void printResult(Ball b) {
		int[] player = b.getPlayer();
		int[] random = b.getRandom();
		int[] ball = b.getBall();
		int[] correct = b.getCorrect();
		int[] correctrdm = b.getCorrectrdm();
		System.out.print("당첨 번호 :");
		for (int i = 0; i < b.getPlayer().length; i++) {
			System.out.print(" " + ball[i]);
		}
		System.out.print("\n자동 당첨 번호 :");
		for (int i = 0; i < b.getCountrdm(); i++) {
			System.out.print(" " + correctrdm[i]);
		}
		System.out.println("\n당첨된 개수 : " + b.getCountrdm());

		System.out.print("수동 당첨 번호 :");
		for (int i = 0; i < b.getCount(); i++) {
			System.out.print(" " + correct[i]);
		}
		System.out.println("\n당첨된 개수 : " + b.getCount());
	}

}
