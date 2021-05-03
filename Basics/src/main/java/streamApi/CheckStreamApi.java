package streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckStreamApi {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "", "i", "", "k", "", "w", "v");
		list.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList()).forEach(System.out::println);
	}

} 
