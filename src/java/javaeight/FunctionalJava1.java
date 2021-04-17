package java.javaeight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class FunctionalJava1 {

	public static void main(String[] args) {
		// Foreach with inline function		
		IntStream.range(0, 10).forEach(
	        n -> {
	            System.out.println(n);
	        }
		);
		
		String s1 = "java is becoming functional";
		List<String> l1 = Arrays.asList(s1.split(" "));
		
		// Defines function used to transform strings to camel case
		Function<String, String> camelize = (str) -> str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
		
		// uses custom function for map (camelize) and predefined to print System.out::print
		l1.stream().map(camelize).forEach(System.out::println);
	
		// Defining  functions
		BiFunction<Long, Integer, Long> add = (l, i) -> l + i;
		Function<Long, Double> square = (l) -> l * l * 1D;
		// Composing functions
		BiFunction<Long, Integer, Double> squaredSum = add.andThen(square);
		
		System.out.printf("5 + 3 = %d\n", add.apply(5L, 3));
		System.out.printf("8 ^ 2 = %f\n", square.apply(8L));
		System.out.printf("(5 + 3) ^ 2 = %f\n", squaredSum.apply(5L, 3));
		
		// Higher order functions
		
		compute(s1, String::hashCode);
		compute("123", (String s) -> Integer.valueOf(s));
		compute(new Double(56.7), (Double d) -> d.intValue());

		testSuplier(s1::length);
		
		// Comparator as a functional interface
		
		Integer[][] numbers = new Integer[][] { {5, -1}, {2, 10}, {51, 314}, {23, -2} };
		
		Comparator<Integer[]> sparseArrayC = (a, b) -> a[0].compareTo(b[0]);
		
		Arrays.sort(numbers, sparseArrayC);
		
		int index = Arrays.binarySearch(numbers, new Integer[] { 5 }, sparseArrayC);
		
		System.out.println(index);
	}
	
    public static <T> void testSuplier(Supplier<T> f) {
		System.out.println(f.get());
	}
	
	public static <T, U> void compute(T input, Function<T, U> f) {
		System.out.println(f.apply(input));
	}
}
