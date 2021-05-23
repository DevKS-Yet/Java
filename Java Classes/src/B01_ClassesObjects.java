
public class B01_ClassesObjects {
	int x = 5;
	int y;
	
	String fname = "John";
	String lname = "Doe";
	int age = 24;
	
	public static void main(String[] args) {
		
		B01_ClassesObjects myObj1 = new B01_ClassesObjects();
		B01_ClassesObjects myObj2 = new B01_ClassesObjects();
		myObj2.y = 25;
		System.out.println(myObj1.x);
		System.out.println(myObj2.y);
		System.out.println(myObj1.y);
		
		
		B01_ClassesObjects myObj3 = new B01_ClassesObjects();
		System.out.println("Name: " + myObj1.fname + " " + myObj2.lname);
		System.out.println("Age: " + myObj3.age);
	}
}
