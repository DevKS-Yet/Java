
public class B05_Encapsulation {

	public static void main(String[] args) {
		Person myObj = new Person();
//		myObj.name = "John"; // error
		myObj.setName("John");
		System.out.println(myObj.getName());
	}//main
}//class




class Person {
	
	private String name; // private = restricted access

//Getter
	public String getName() {
		return name;
	}

//Setter
	public void setName(String newName) {
		this.name = newName;
	}
}//class

/* Why Encapsulation
 * 
 * Better control of class attributes and methods
 * Class attributes can be made read-only or write-only
 * Flexible: the programmer can change one part of the code without affecting other parts
 * Increased security of data
 */
