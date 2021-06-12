package product;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Buyer b = new Buyer();
		
		while(true) {
			System.out.println("1. 오디오");
			System.out.println("2. ???");
			System.out.println("3. ???");
			System.out.println("4. 구매목록 보기");
			System.out.println("5. 현금충전");
			System.out.println("원하는 번호");
			String choice = scan.next();
			
			switch(choice) {
			case "1":
				b.buy(new Audio());
				b.myInfo();
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				b.summary();
				b.myInfo();
				break;
			case "5":
				System.out.println("얼마 충전?");
				int cash = scan.nextInt();
				cash += b.getMoney();
				b.setMoney(cash);
				System.out.println("충전 완료");
			default:
				System.out.println("다시 입력");
				break;
			}
		}
		
	}
}
