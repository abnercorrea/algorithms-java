package interviews.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ThreeNumbersSumZero {

	public static void main(String[] args) {
		int[][] inputs = { {1,2,3,4,5, -100, -101, -102}, {1, 3, -4, 10}, {1, 3, -100, 10}, {-1, 2}, {0} };
				
		for (int[] input : inputs)
			System.out.println(Arrays.toString(input) +": " + addsToZero(input));
	}

	public static boolean addsToZero(int[] input) {
	    Set<Integer> positives = new HashSet<>(); 
	    Set<Integer> negatives = new HashSet<>();
	    
	    for (int i = 0; i < input.length; i++) {
	        if (input[i] == 0)
	            return true; // EASY... pick zero 3 times and...
	        else if (input[i] > 0)
	            positives.add(input[i]);
	        else
	            negatives.add(-input[i]); // removing signal
	    }
	    
	    if (positives.size() == 0 || negatives.size() == 0)
	        return false; // EASY V2.0... impossible to add to zero if there are no positives or no negatives
	    
	    // Checks if there are 3 numbers (2 negatives and 1 positive or 2 positves and 1 negative) that add up to zero
	    for (int positive : positives) {
	        for (int negative : negatives) {
	            if (positive > negative) {
	            	if (negatives.contains(positive - negative)) // this takes O(1)... constant time
	            		return true; // found 2 negatives and 1 positive that add to zero
	            }
	            else if (negative > positive) {
	            	if (positives.contains(negative - positive)) // this takes O(1)... constant time
	            		return true; // found 2 positives and 1 negative that add to zero
	            }
	        }
	    }
	    
	    return false;      
	}
	
	public static boolean addsToZeroOptmized(int[] input) {
	    Set<Integer> positives = new TreeSet<>(); // using ordered set.
	    Set<Integer> negatives = new TreeSet<>();
	    long sumPositives = 0, sumNegatives = 0;
	    
	    // This takes O(n.log(n)), where n = input.length
	    for (int i = 0; i < input.length; i++)
	        if (input[i] == 0){
	            return true; // EASY... pick zero 3 times and...
	        }
	        else if (input[i] > 0) {
	            positives.add(input[i]);
	            sumPositives += input[i];
	        }
	        else {
	            negatives.add(-input[i]); // removing signal
	            sumNegatives += -input[i];
	        }
	    
	    if (positives.size() == 0 || negatives.size() == 0)
	        return false; // EASY V2.0... impossible to add to zero if there are no positives or no negatives
	    
	    sumNegatives <<= 1; // * 2. Multiplies here to avoid doing it every iteration 
	    sumPositives <<= 1;
	    
	    // Checks if there are 3 numbers (2 negatives and 1 positive or 2 positves and 1 negative) that add up to zero
	    for (int positive : positives) {
	    	// impossible to find 2 negatives that add up to zero
	    	if (positive > sumNegatives) 
	            break;
	        
	        for (int negative : negatives) {
	        	// impossible to find 2 positives that add up to zero
	        	if (negative > sumPositives) 
		            break;
		        
	            if (positive > negative) {
	            	if (negatives.contains(positive - negative)) // this takes O(1)... constant time
	            		return true; // found 2 negatives and 1 positive that add to zero
	            }
	            else if (negative > positive) {
	            	if (positives.contains(negative - positive)) // this takes O(1)... constant time
	            		return true; // found 2 positives and 1 negative that add to zero
	            }
	        }
	    }
	    
	    return false;      
	}
}
