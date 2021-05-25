
public class B06_Inheritance extends Vehicle{

	private String modelName = "Mustang";  // attribute
	
	public static void main(String[] args) {
		
		// create a inheritance object
		B06_Inheritance inheritance = new B06_Inheritance();
		
		// call the honk() method (from the Vehicle class) on the inheritance object
		inheritance.honk();
		
		System.out.println(inheritance.brand + " " + inheritance.modelName);
	}
}

class Vehicle {
	protected String brand = "Ford";	// Vehicle attribute
	public void honk() {				// Vehicle method
		System.out.println("Tuut, tuut!");
	}
}

/* Why and when to use "Inheritance"
 * 
 * It is useful for code reusability: reuse attributes and methods of an existing class when you create a new class.
 */ 
