package lotto01;

import java.util.Scanner;

public class Process {

	static Scanner scan = new Scanner(System.in);
//---------------------------------------------------------
	void main() {
		Ball b = new Ball();
		loopwhile:while(true) {
			printMenu();
			System.out.print("선택해주세요 : ");
			String choice = scan.next();
			
			switch(choice) {
			case "1":
				createBall(b);
				break;
			case "2":
				shuffleBall(b);
				break;
			case "3":
				playerChoose(b);
				break;
			case "4":
				checkBall(b);
				break;
			case "5":
				printResult(b);
				break;
			case "0":
				System.out.println("시스템을 종료합니다.");
				break loopwhile;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
	
//---------------------------------------------------------
	void printMenu() {
		System.out.println("1. 공 생성");
		System.out.println("2. 공 섞기");
		System.out.println("3. 숫자 뽑기");
		System.out.println("4. 공 체크");
		System.out.println("5. 체크 결과 프린트");
		System.out.println("0. 종료");
	}

//---------------------------------------------------------
	void createBall(Ball b) {
		int[] newBall = b.getBall();
		for (int i = 0; i < b.getBall().length; i++) {
			newBall[i] = i + 1;
		}
		b.setBall(newBall);
		System.out.println("생성이 완료되었습니다.");
	}

//---------------------------------------------------------
	void shuffleBall(Ball b) {
		int[] newBall = b.getBall();
		for (int i = 0; i < 100; i++) {
			int random = (int) (Math.random() * 44);
			int temp = newBall[0];
			newBall[0] = newBall[random];
			newBall[random] = temp;
		}
		b.setBall(newBall);
		System.out.println("공을 섞었습니다.");
	}

//---------------------------------------------------------
	void playerChoose(Ball b) {
		int[] newBall = b.getPlayer_ball();
		for (int i = 0; i < b.getPlayer_ball().length; i++) {
			System.out.print("1~45 사이의 숫자를 적어주세요 : ");
			newBall[i] = scan.nextInt();
			if (newBall[i] < 1 || newBall[i] > 45) {
				System.out.println("1~45 사이만!");
				i--;
			} else if(i>0) {
				for(int j=0;j<i;j++) {
					if(newBall[i]==newBall[j]) {
						System.out.println("중복 숫자입니다.");
						i--;
					}
				}
			}
		}
		b.setPlayer_ball(newBall);
		System.out.println("적기가 완료되었습니다.");
	}

//---------------------------------------------------------
	void checkBall(Ball b) {
		int[] playerBall = b.getPlayer_ball();
		int[] prizeBall = b.getBall();
		int[] correctBall = b.getCorrect_ball();
		for (int i = 0; i < b.getPlayer_ball().length; i++) {
			for (int j = 0; j < 6; j++) {
				if (playerBall[i] == prizeBall[j]) {
					b.setCount(b.getCount() + 1);
					correctBall[b.getCount()] = playerBall[i];
				}
			}
		}
		System.out.println("확인 완료!");
	}

//---------------------------------------------------------
	void printResult(Ball b) {
		int[] prizeBall = b.getBall();
		int[] playerBall = b.getPlayer_ball();
		int[] correctBall = b.getCorrect_ball();
		System.out.print("당첨 번호 :");
		for (int i = 0; i < 6; i++) {
			System.out.print(" " + prizeBall[i]);
		}
		System.out.print("\n선택 번호 :");
		for (int i = 0; i < b.getPlayer_ball().length; i++) {
			System.out.print(" " + playerBall[i]);
		}
		System.out.println("\n맞춘 갯수 : " + b.getCount());
		System.out.println("맞춘 번호 :");
		for (int i = 0; i < b.getCount(); i++) {
			System.out.print(" " + correctBall[i]);
		}
	}
//---------------------------------------------------------

}
