
public class B19_WrapperClasses {

	public static void main(String[] args) {

		Integer myInt = 5;

		System.out.println("sysout : " + myInt);
		System.out.println("intValue : " + myInt.intValue());
		
		String myString = myInt.toString();
		System.out.println("toString : "+myString.getClass());
		System.out.println("length : " + myString.length());
		
	}
}

/* pri		wrap
 * 
 * byte		Byte
 * short	Short
 * int		Integer
 * long		Long
 * float	Float
 * double	Double
 * boolean	Boolean
 * char		Character
 */
