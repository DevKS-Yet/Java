import java.util.Scanner;

public class B12_UserInput {

	public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in);
		
		boolean a1 = myObj.nextBoolean();
		
		byte b1 = myObj.nextByte();
		short b2 = myObj.nextShort();
		int b3 = myObj.nextInt();
		long b4 = myObj.nextLong();
		
		float c1 = myObj.nextFloat();
		double c2 = myObj.nextDouble();
		
		String d1 = myObj.next();  // only receive first word
		String d2 = myObj.nextLine();  // receive whole sentence and even enter
		
		System.out.printf("%b\n%d\n%d\n%d\n%d\n%f\n%f\n%s\n%s", a1, b1,b2,b3,b4, c1,c2, d1,d2);
		
		myObj.close();
	}
}
