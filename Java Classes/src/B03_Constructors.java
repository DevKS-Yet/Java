
public class B03_Constructors {

	int modelYear;
	String modelName;
	
	public B03_Constructors(int year, String name) {
		modelYear = year;
		modelName = name;
	}
	
	public static void main(String[] args) {
		B03_Constructors myCar = new B03_Constructors(1969, "Mustang");
		System.out.println(myCar.modelYear + " " + myCar.modelName);
	}
}
