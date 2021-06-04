import java.util.HashMap;

public class B16_HashMap {

	public static void main(String[] args) {
		
		HashMap<String, String> capitalCities = new HashMap<String, String>();
		
		capitalCities.put("England", "London");
		capitalCities.put("Korea", "Seoul");
		capitalCities.put("USA", "Washington DC");
		System.out.println(capitalCities);
		
		System.out.println("size : "+capitalCities.size());
		
		System.out.println("\nfor-each loop");
		System.out.println("Print keys");
		for(String i : capitalCities.keySet()) {
			System.out.println(i);
		}
		System.out.println("\nPrint values");
		for(String i : capitalCities.values()) {
			System.out.println(i);
		}
		System.out.println("\nPrint keys and values");
		for(String i : capitalCities.keySet()) {
			System.out.println("key: "+i+" value: "+capitalCities.get(i));
		}
		
		System.out.println("get : " + capitalCities.get("England"));
		
		capitalCities.remove("England");
		System.out.println("remove : "+capitalCities);
		
		capitalCities.clear();
		System.out.println("clear : "+capitalCities);
		
	}
}
