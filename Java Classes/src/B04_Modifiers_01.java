
abstract class B04_Modifiers_01 {//the class can't be used to create objects (To access an abstract class, it must be inherited from another class)

	public String fname = "John"; // the code is accessible for all classes
	public String lname = "Doe";
//	private String email = "john@doe.com"; // the code is only accessible within the declared class
	int age = 24; // the code is only accessible in the same package. This is used when you don't
					// specify a modifier.
	protected int graduationYear = 2018; // the code is accessible in the same package and subclasses.
	public abstract void study();
}

//subclass (inherit from person)
class Student extends B04_Modifiers_01{
	public void study() {
		System.out.println("Studying all day long");
	}
}