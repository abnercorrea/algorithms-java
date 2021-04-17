package recursion;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		String a = "ABCDEFGHIJ";
		int k = 3, n = a.length();
		long Cnk = factorial(n).divide(factorial(n-k).multiply(factorial(k))).longValue() ;
		
		List<String> combinations = generateCombinations(a, k);
		
		System.out.println("Number combinations obtained: " + combinations.size());
		System.out.println("Number combinations expected: " + Cnk);
		if (Cnk < 150)
			System.out.println("Combinations: " + combinations);
	}

	public static List<String> generateCombinations(String s, int k) {
		List<String> combinations = new LinkedList<>();
		
		generateCombinations(s, k, 0, new char[k], 0, combinations);
		
		return combinations;
	}

	public static void generateCombinations(String s, int k, int start, char[] c, int cIndex, List<String> combinations) {
		if (cIndex == k) {
			combinations.add(new String(c));
			return;
		}
		
		for (int i = start, maxi = s.length() - k + cIndex + 1; i < maxi; i++) {
			c[cIndex] = s.charAt(i);
			
			generateCombinations(s, k, i + 1, c, cIndex + 1, combinations);
		}
 	}
	
	public static BigInteger factorial(int n) {
		BigInteger factorial = BigInteger.valueOf(1);
		
		for (int i = 1; i <= n; i++)
			factorial = factorial.multiply(BigInteger.valueOf(i));
		
		return factorial;
	}
}
