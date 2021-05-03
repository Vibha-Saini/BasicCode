package hashmapQuestion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortHashmapBasisOfValue {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("Vibha", 90);
		map.put("jiya", 78);
		map.put("Anu", 66);
		sortByValue(map);
	}

	public static Map<String, Integer> sortByValue(Map<String, Integer> map) {

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		return map;

	}

}
