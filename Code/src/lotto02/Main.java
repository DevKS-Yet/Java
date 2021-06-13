package lotto02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Process p = new Process();
		Ball b = new Ball();
		
		loopwhile:while(true) {
			p.printMenu();
			String choice = scan.next();
			
			switch(choice) {
			case "1":
				p.createBall(b);
				break;
			case "2":
				p.shuffleBall(b);
				break;
			case "3":
				p.randomBall(b);
				break;
			case "4":
				p.chooseBall(b);
				break;
			case "5":
				p.resultBall(b);
				break;
			case "6":
				p.printResult(b);
				break;
			case "9":
				break;
			case "0":
				System.out.println("시스템을 종료합니다.");
				break loopwhile;
			default:
				System.out.println("다시 입력해주세요.");
				break;
			}
		}
		scan.close();
	}
}
