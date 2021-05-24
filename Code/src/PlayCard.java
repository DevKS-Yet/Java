
public class PlayCard {

	public static void main(String[] args) {
		
		Deck d = new Deck();
		
		d.shuffle();
		
		for(int i=0; i<4;i++) {
			for(int j=0;j<13;j++) {
				d.c[13*i+j].card_print(d.c[13*i+j].kind, d.c[13*i+j].number);
			}
		}
	}
}
