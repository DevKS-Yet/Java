
public class B04_TypeCasting {

	public static void main(String[] args) {

		// Widening Casting
		int i1 = 9;
		double d1 = i1; // Automatic casting: automatically when passing a smaller size type to a larger
						// size type

		System.out.println(i1);
		System.out.println(d1);

		// Narrowing Casting
		double d2 = 9.78;
		int i2 = (int) d2; // Manual casting: must be done manually by placing the type in parentheses in
							// front of the value

	}
}
