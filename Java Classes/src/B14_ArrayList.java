import java.util.ArrayList;
import java.util.Collections;

public class B14_ArrayList {

	public static void main(String[] args) {

		ArrayList<String> cars = new ArrayList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");
		System.out.println("cars : " + cars);
		System.out.println("cars.get(0) : " + cars.get(0));

		cars.set(0, "Opel");
		System.out.println("cars.set(0, \"Opel\") : "+cars);
		cars.add(2, "Hyundai");
		System.out.println("cars.add(2, \"Hyundai\") : "+cars);

		// cars.size();
		System.out.println("cars.size() : " + cars.size());

		System.out.println("for loop");
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i));
		}
		System.out.println("\nfor-each loop");
		for (String i : cars) {
			System.out.println(i);
		}
		
		Collections.sort(cars);
		System.out.println("Collections.sort(cars) : "+cars);

		cars.remove(0);
		System.out.println("cars.remove(0) : " + cars);
		cars.remove("BMW");
		System.out.println("cars.remove(\"BMW\") : " + cars);

		cars.clear();
		System.out.println("cars.clear() : " + cars);

	}
}
