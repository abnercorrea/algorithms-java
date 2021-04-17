package interviews.facebook;

import java.util.Arrays;

public class ArrayDotProduct {

	public static void main(String[] args) {
		int[][] A = { {1, 7}, {2, 16}, {5, 4}, {20, 3} };
		int[][] B = { {1, 1}, {2, 1}, {7, 9}, {20, 1}, {22, 5} };
		
		System.out.println("A (.) B = "+ dotProduct(A, B));
		
	}

	public static int dotProduct(int[][] A, int[][] B) {
	    int dotProduct = 0;
	    
		int[][] shorter = (A.length > B.length) ? B : A;
		int[][] longer = (A.length > B.length) ? A : B;
		
	    for (int i = 0; i < shorter.length; i++) {
	        int j = Arrays.binarySearch(longer, shorter[i], (int[] a1, int[] a2) -> Integer.compare(a1[0], a2[0]));    
	    	
	        if (j >= 0)
	        	dotProduct += shorter[i][1] * longer[j][1]; 
	    }
	    
	    return dotProduct;
	}
	

}
