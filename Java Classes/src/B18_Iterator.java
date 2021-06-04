import java.util.ArrayList;
import java.util.Iterator;

public class B18_Iterator {

	public static void main(String[] args) {
		
		ArrayList<String> cars = new ArrayList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");
		
		Iterator<String> it = cars.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
			System.out.println(it.hasNext());
			it.remove();
		}
		
		System.out.println(cars);
		
	}
}
