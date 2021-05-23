
public class B05_Operators {

	public static void main(String[] args) {
		
		//Arithmetic Operators
		int x = 5;
		int y = 3;
		System.out.println("+ : "+(x+y)); // Addition
		System.out.println("- : "+(x-y)); // Subtraction
		System.out.println("* : "+(x*y)); // Multiplication
		System.out.println("/ : "+(x/y)); // Division
		System.out.println("% : "+(x%y)); // Modulus
		System.out.println("x++ : "+x++);
		System.out.println("after ++ : "+x);
		System.out.println("++x : "+(++x));
		System.out.println("x-- : "+x--);
		System.out.println("after -- : "+x);
		System.out.println("--x : "+(--x));
		
		
		//Assignment Operators
		x = 5; // x = 5			: equal
		x += 3; // x = x + 3	: add itself
		x -= 3; // x = x - 3	: sub itself
		x *= 3; // x = x * 3	: mul itself
		x /= 3; // x = x / 3	: div itself
		x %= 3; // x = x % 3	: mod itself(reminder)
		x &= 3; // x = x & 3	: bit operator (0101 & 0011 = 0001 = 1) : and
		x |= 3; // x = x | 3	: bit operator (0101 | 0011 = 0111 = 7) : or
		x ^= 3; // x = x ^ 3	: bit operator (0101 ^ 0011 = 0110 = 6) : xor
		x >>= 1; // x = x >> 1	: bit operator (shift to left(1) : 0101 -> 01010)
		x <<= 1; // x = x << 1	: bit operator (shift to right(1): 0101 -> 010)
		x >>>= 1; // x = x >>> 1: bit operator
		
		//Comparison Operators
		boolean b;
		b = x == y; // equal to
		b = x != y; // not equal
		b = x > y; // greater than
		b = x < y; // less than
		b = x >= y; // greater than or equal to
		b = x <= y; // less than or equal to
		
		//Logical Operators
		b = x<5 && y<10; // both true -> true
		b = x<5 || y<10; // one true -> true
		b = !(x<5&&y<10); // reverse the result
		
	}
}
