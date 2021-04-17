package datastructures;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		Map<Integer, Integer> f = new TreeMap<>();
		
		// Map represents a polynomial where key = exponent and value = constant.
		f.put(4, 1);
		f.put(3, -10);
		f.put(2, 35);
		f.put(1, -50);
		f.put(0, 24);
		
		System.out.println("Function: " + f);

		
		System.out.println("f(4) = " + evaluate(f, 4));
		System.out.println("f(3) = " + evaluate(f, 3));
		System.out.println("f(2) = " + evaluate(f, 2));
		System.out.println("f(1) = " + evaluate(f, 1));

		System.out.println("f(10) = " + evaluate(f, 10));
		
		Map<Integer, Integer> df;
	
		df = derivative(f);

		System.out.println("Derivative: " + df);

		
	}

	private static Map<Integer, Integer> derivative(Map<Integer, Integer> p) {
		Map<Integer, Integer> d = new TreeMap<>();
		
		for (Entry<Integer, Integer> term : p.entrySet())
			if (term.getKey() > 0)
				d.put(term.getKey() - 1, term.getKey() * term.getValue());

		return d;
	}

	private static int evaluate(Map<Integer, Integer> p, int x) {
		int fx = 0;
		
		for (Entry<Integer, Integer> term : p.entrySet())
			fx += term.getValue() * Math.pow(x, term.getKey());
			
		return fx;
	}
}
