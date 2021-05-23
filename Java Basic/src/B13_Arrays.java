
public class B13_Arrays {

	public static void main(String[] args) {
		
		// Arrays
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		System.out.println(cars[0]);
		
		// change an array element
		cars[0] = "Opel";
		System.out.println(cars[0]);
		
		
		// multidimensional arrays
		int[][] myNumbers = {{1,2,3,4},{5,6,7}};
		int x = myNumbers[1][2];
		System.out.println(x);
		
	}
}
