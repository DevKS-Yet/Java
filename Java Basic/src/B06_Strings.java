
public class B06_Strings {

	public static void main(String[] args) {
		
		//create String type data
		String abc = new String();
		abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String abc1 = "abcdefghijklmnopqrstuvwxyz";
		
		//String length
		System.out.println(abc.length());
		
		//String methods
		System.out.println(abc.toLowerCase());
		System.out.println(abc1.toUpperCase());
		
		//String index
		System.out.println(abc1.indexOf('k')); // -1 = false
		
		//String concat
		System.out.println(abc.concat(abc1));
		
		//Special characters
		String txt = "We are the so-called \"Vikings\" from the north.";
		txt = "It\'s alright.";
		txt = "The character \\ is called backslash.";
		txt = "\n"; // new line
		txt = "\r"; // carriage return
		txt = "\t"; // tab
		txt = "\b"; // backspace
		txt = "\f"; // form feed
	}
}
