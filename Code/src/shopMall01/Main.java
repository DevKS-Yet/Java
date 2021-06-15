package shopMall01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Buyer b = new Buyer();
		
		loopwhile:while(true) {
			System.out.println("1. 아이폰");
			System.out.println("2. OLEDTV");
			System.out.println("3. 에일리언웨어");
			System.out.println("4. 구매 목록");
			System.out.println("5. 금액 충전");
			System.out.println("0. 종료");
			String choice = scan.next();
			
			switch(choice) {
			case "1":
				b.buy(new HP());
				break;
			case "2":
				b.buy(new Tv());
				break;
			case "3":
				b.buy(new Laptop());
				break;
			case "4":
				b.showList();
				break;
			case "5":
				b.chargeMoney();
				break;
			case "0":
				break loopwhile;
			default:
				break;
			}
		}
		
	}
}
