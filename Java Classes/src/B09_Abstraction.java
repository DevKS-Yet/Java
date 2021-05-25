// Abstract class
abstract class Animal1 {
	// Abstract method (does not have a body)
	public abstract void animalSound();
	// Regular method
	public void sleep() {
		System.out.println("Zzz");
	}
}

// Subclass (inherit from Animal)
class Pig1 extends Animal1{
	public void animalSound() {
		// The body of animalSound() is provided here
		System.out.println("The pig says: wee wee");
	}
}

public class B09_Abstraction {
	public static void main(String[] args) {
		Pig1 myPig = new Pig1();
		myPig.animalSound();
		myPig.sleep();
	}
}

/* Why and when to use abstract classes and methods
 * 
 * To achieve security - hide certain details and only show the important details of an object.
 */