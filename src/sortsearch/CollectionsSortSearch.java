package sortsearch;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionsSortSearch {

	public static void main(String[] args) {
		// List
		List<Integer> n = Arrays.asList(13,2,43,24,35,16,67,888,9009);
		Collections.sort(n, (Integer a, Integer b) -> b.compareTo(a));
		
		System.out.println(n);
		int key = 16;
		int pos = Collections.binarySearch(n, key, (Integer a, Integer b) -> b.compareTo(a));
		System.out.println("Position of " + key + ": " + pos);
		
		// Set
		System.out.println();
		System.out.println("Set");
		System.out.println("---------------------------------------------------------------------------------");

		Set<Integer> numberSet = new HashSet<>();

		populateRandomNumbers(numberSet, 20, 100);
		
		System.out.println("Set: " + numberSet);
		System.out.println("Sorting using Collections.sort()... needs to create a list with set's content first.");
		
		List<Integer> numberList = new LinkedList<>(numberSet);
		
		Collections.sort(numberList);
		
		System.out.println("Sorted (from LinkedList): " + numberList);
		
		
		
		// TreeSet		
		System.out.println();
		System.out.println("TreeSet (sorted set)");
		System.out.println("---------------------------------------------------------------------------------");
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		SortedSet<Integer> sortedSet = treeSet;
		
		for (int i = 0; i < 30; i++) {
			int number = Math.round((float)Math.random() * 5000);
			
			sortedSet.add(number);
		}
		
		System.out.println("TreeSet: " + treeSet);
		System.out.println("SortedSet: " + sortedSet);

		System.out.println("First value above 2000: " + treeSet.higher(2000));
		System.out.println("First value below 500: " + treeSet.lower(500));
		
	}

	@SuppressWarnings("unchecked")
	public static <T extends Number> void populateRandomNumbers(Collection<T> numbers, int size, int max) {
		for (int i = 0; i < size; i++) {
			Integer number = Math.round((float)Math.random() * max);
			
			numbers.add((T)number);
		}
	}
}
