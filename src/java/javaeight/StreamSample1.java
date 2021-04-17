package java.javaeight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSample1 {
	
	public static void main(String[] args) {
		String s1 = "java is becoming a functional language";
		List<String> l1 = Arrays.asList(s1.split(" "));
		
		// function used to transform strings to camel case
		Function<String, String> camelize = (str) -> str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
		
		// ************************
		// MAP and FOREACH
		// ************************
		
		System.out.println("# Sequential stream of camelized words...");

		// sequential stream
		Stream<String> stream1 = l1.stream();
		stream1.map(camelize).forEach(System.out::println);

		System.out.println("# If you try to operate upon the same stream twice...");
		
		try {
			System.out.println(stream1.count());			
		}
		catch (RuntimeException e) {
			System.out.printf("Exception !!! - %s - %s\n", e.getClass().getName(), e.getMessage());
		}

		System.out.println();
		System.out.println("# In parallel, elements might be processed out of order...");
		
		// parallel. suggestion for execution strategy
		l1.parallelStream().map(camelize).forEach(System.out::println);
		
		// ************************
		// Filter and Search
		// ************************
		
		System.out.println("# Only words with length > 2:");
		l1.parallelStream().filter((str) -> str.length() > 2).forEach(System.out::println);
		
		System.out.println("# All strings != \"\" ? - " + l1.parallelStream().allMatch((str) -> str != ""));		
		System.out.println("# Any string = \"java\" - " + l1.parallelStream().anyMatch((str) -> "java".equals(str)));
		System.out.println("# Any string = \"scala\" - " + l1.parallelStream().anyMatch((str) -> "scala".equals(str)));
		System.out.println("# No strings are null ? - " + l1.parallelStream().noneMatch((str) -> str == null));		
		
		// ************************
		// reduce, max, min, average, distinct 
		// ************************
		
		IntStream.range(10,	25).forEach(i -> System.out.print(i + ", "));
		System.out.println();
		System.out.println("# Max - " + IntStream.range(10,	25).max());		
		System.out.println("# Min - " + IntStream.range(10,	25).min());		
		System.out.println("# Avg - " + IntStream.range(10,	25).average());		
		
		int sum0 = IntStream.range(10, 25).reduce((a, b) -> a + b).getAsInt();
		int sum100 = IntStream.range(10, 25).reduce(100, (a, b) -> a + b);
		
		System.out.println("# Reduce (sum) - " + sum0);		
		System.out.println("# Reduce (sum) zero = 100 - " + sum100);		

		System.out.println("Distinct: ");
		IntStream.concat(IntStream.range(10, 25), IntStream.range(20, 35)).distinct().forEach(i -> System.out.print(i + ", "));
		System.out.println();
		
		// ************************
		// Flat map, sorting 
		// ************************
		
		System.out.println("Flat map...");
		
		Integer[][] matrix = { {4,56,25}, {1,2,3}, {4,5,6}, {-1,0,87}, {7,8,9}, {23,4,56} };
		
		Arrays.stream(matrix).flatMap((line) -> Arrays.stream(line)).sorted().forEach(System.out::println);
	}

}
