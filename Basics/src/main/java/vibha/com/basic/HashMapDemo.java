package vibha.com.basic;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	
	int i;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashMapDemo other = (HashMapDemo) obj;
		if (i != other.i)
			return false;
		return true;
	}

	public static void main(String[] args) {

		Map<String, String> myMap = new HashMap<>();

		myMap.put("a", "aa");
		myMap.put("b", "aa");
		myMap.put("c", "aa");
		myMap.put("d", "aa");
		myMap.put("e", "aa");
		myMap.put("f", "aa");
		myMap.put("g", "aa");
		myMap.put("h", "aa");
		myMap.put("i", "aa");
		myMap.put("j", "aa");
		myMap.put("k", "aa");

		
		
	}
	
	
	

}
