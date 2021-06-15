package shopMall01;

import java.util.ArrayList;
import java.util.Scanner;

public class Buyer {

	static Scanner scan = new Scanner(System.in);
	
	private int money, bonusPoint;
	ArrayList<Product> cart = new ArrayList<Product>();
	
	void buy(Product p) {
		if(money<p.getPrice()) {
			System.out.println("금액 부족!");
			return;
		} else if(bonusPoint>p.getPrice()) {
			System.out.println("적립금으로 구매하시겠습니까?(y/n)");
			String choice = scan.next();
			if(choice.equals("y")) {
				System.out.println("적립금으로 "+p.getName()+"을 구매하겠습니다.");
				bonusPoint-=p.getPrice();
				bonusPoint+=p.getBonusPoint();
				cart.add(p);
				return;
			} 
		}
		money -= p.getPrice();
		bonusPoint += p.getBonusPoint();
		System.out.println(p.getName()+"을 구매하였습니다.");
		cart.add(p);
	}
	
	void showList() {
		int m=0, b=0;
		System.out.print("구매 목록 :");
		for(int i=0; i<cart.size();i++) {
			System.out.print(" "+cart.get(i).getName());
			m+=cart.get(i).getPrice();
			b+=cart.get(i).getBonusPoint();
		}
		System.out.println("\n총 사용 금액 : "+m);
		System.out.println("총 모은 보포 : "+b);
		System.out.println("소지금 : "+money);
		System.out.println("적립금 : "+bonusPoint);
	}
	
	void chargeMoney() {
		System.out.println("금액 : ");
		money+=scan.nextInt();
		System.out.println("총 금액 : "+money);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
}
