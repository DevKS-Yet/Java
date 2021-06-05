import java.util.ArrayList;
import java.util.function.Consumer;

public class B23_Lambda {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(9);
		numbers.add(8);
		numbers.add(1);
		
		// usually passed as parameters to a function
		numbers.forEach( (n) -> {System.out.println(n); } );
		
		// can be stored in variables
		Consumer<Integer> method = (n) -> { System.out.println(n); };
		numbers.forEach(method);
		
	}
}
