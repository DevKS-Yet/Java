package product01;

import java.util.ArrayList;

public class Buyer {

	private int money;
	private int bonusPoint;
	
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

	ArrayList<Product> cart = new ArrayList<Product>();
	
	void buy(Product p) {
		if(money < p.getPrice()) {
			System.out.println("잔액이 부족");
			return;
		}
		money -= p.getPrice();
		bonusPoint += p.getBonusPoint();
		
		cart.add(p);
		System.out.println("구매가 완료");
	}
	
	void myInfo() {
		System.out.println(money);
		System.out.println(bonusPoint);
	}
	
	void summary() {
		if(cart.isEmpty()) {
			System.out.println("구매한 물품이 없습니다.");
			return;
		}
		int total = 0;
		String product_list = "";
		for(int i=0; i<cart.size();i++) {
			Product p = cart.get(i);
			product_list = "" + product_list + p.getPro_name();
			total += p.getPrice();
		}
		System.out.println("구매 개수 : "+cart.size());
		System.out.println("구매 금액 : "+total);
		System.out.println("구매 목록 :"+product_list);
	}
	
}
