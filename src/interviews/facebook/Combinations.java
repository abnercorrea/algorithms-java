package interviews.facebook;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		String[] words = { "A","B","C","D","E","F","G","H","I","J" };
		
		System.out.println(combinations(words, 7));
	}



	public static List<String> combinations(String[] items, int k) {
		List<String> combinations = new ArrayList<>();
		
		combinations(items, k, 0, "", combinations);
		
		return combinations;
	}
	
	
	public static void combinations(String[] items, int k, int start, String combination, List<String> combinations) {
	    if (k == 0) {
		    combinations.add(combination);
	    	
		    return;
	    }
		
	    for (int i = start; i < items.length; i++)
	    	combinations(items, k - 1, i + 1, combination + items[i], combinations);
	}

}
