import java.util.LinkedList;

public class B15_LinkedList {

	public static void main(String[] args) {

		LinkedList<String> cars = new LinkedList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");
		System.out.println("LinkedList : "+cars);
		
		cars.addFirst("First");
		cars.addLast("Last");
		System.out.println("addFirst & addLast : "+cars);
		cars.removeFirst();
		cars.removeLast();
		System.out.println("removeFirst & removeLast : "+cars);
		System.out.println("getFirst : "+cars.getFirst());
		System.out.println("getLast : "+cars.getLast());

	}
}

/*
 * When To Use
 * 
 * 
 * It is best to use an ArrayList when:
 * 
 * 1. You want to access random items frequently 2. You only need to add or
 * remove elements at the end of the list
 * 
 * It is best to use a LinkedList when:
 * 
 * 1. You only use the list by looping through it instead of accessing random
 * items 2. You frequently need to add and remove items from the beginning,
 * middle or end of the list
 */