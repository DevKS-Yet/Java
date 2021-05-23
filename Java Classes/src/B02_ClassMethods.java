
public class B02_ClassMethods {
	// Static method
	static void myStaticMethod() {
		System.out.println("Static methods can be called without creating objects");
	}
	
	// Public method
	public void myPublicMethod() {
		System.out.println("Public methods must be called by creating objects");
	}
	
	public static void main(String[] args) {
		myStaticMethod();  // Call the static method
		// myPublicMethod(); this would compile an error
		
		B02_ClassMethods myObj = new B02_ClassMethods(); // create an object of Main
		myObj.myPublicMethod();  // call the public method on the object
	}

}
