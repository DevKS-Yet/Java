
public class Deck {

	final int CARD_NUM = 52;
	Card[] c = new Card[CARD_NUM];

	Deck() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				c[13 * i + j] = new Card(i + 1, j + 1);
			}
		}
	}

	void shuffle() {
		for(int i=0; i<1000; i++) {
			int random_no = (int)(Math.random()*CARD_NUM);
			Card temp = c[0];
			c[0] = c[random_no];
			c[random_no] = temp;
		}
	}
}
