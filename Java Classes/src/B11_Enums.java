
enum Level {
	LOW,
	MEDIUM,
	HIGH
}

public class B11_Enums {

	public static void main(String[] args) {
		
		Level myVar = Level.MEDIUM;
		
		switch(myVar) {
		case LOW:
			System.out.println("Low level");
			break;
		case MEDIUM:
			System.out.println("Medium level");
			break;
		case HIGH:
			System.out.println("High level");
			break;
		}
		
		for (Level i : Level.values()) {
			System.out.println(i);
		}
		
	}
}

/* Difference between Enums and Classes
 * 
 * An enum can, just like a class, have attributes and methods. The only difference is that enum constants are public, static and final.
 * An enum cannot be used to create objects , and it cannot extend other classes (but it can implement interfaces).
 * 
 * Why and When to use Enums?
 * 
 * Use enums when you have values that you know aren't going to change, like month days, days, colors, deck of cards, etc.
 */