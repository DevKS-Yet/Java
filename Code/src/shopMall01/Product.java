package shopMall;

public class Product {

	private String name;
	private int price, bonusPoint;
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
		this.bonusPoint = (int)price/10;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
}
