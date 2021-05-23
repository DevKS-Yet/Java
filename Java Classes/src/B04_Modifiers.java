
public class B04_Modifiers {// the class is accessible by any other class
//class B04_Modifiers{//the class is only accessible by classes in the same package. This is used when you don't specify a mofidier.
//}
	private String email = "john@doe.com"; //the code is only accessible within the declared class
	
	public static void main(String[] args) {
		
		B04_Modifiers_01 myObj01 = new Student();
		B04_Modifiers myObj02 = new B04_Modifiers();
		System.out.println("Name: "+myObj01.fname+" "+myObj01.lname); // public variable
		System.out.println("Email: "+myObj02.email);
		System.out.println("Age: "+myObj01.age);
		System.out.println("Graduation Year: "+myObj01.graduationYear);
		myObj01.study();// call abstract method
	}//main
}//class