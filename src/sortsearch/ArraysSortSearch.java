package sortsearch;

import java.util.Arrays;

public class ArraysSortSearch {

	public static void main(String[] args) {
		int[] A = Arrays.copyOf(new int[] {1,3,5,7,9,11,13,15,17,19}, 20); 
		int[] B = {2,4,6,8,10,12,14,16,18,20};
		
		System.out.println("A: " + Arrays.toString(A));
		System.out.println("B: " + Arrays.toString(B));

		mergeSortedArrays(A, 10, B, 10);
		
		System.out.println("Merged: " + Arrays.toString(A));
		
		int key = 9;
		
		System.out.println("Position of " + key + ": " + Arrays.binarySearch(A, key));

		char letter = 'F';
		char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		System.out.println("Letters: " + Arrays.toString(letters));
		System.out.println("Position of " + letter + ": " + Arrays.binarySearch(letters, letter));
		
		int[] C = {3,32,7,5,32,9,8,1345,5,4,29,1,35,6,2,11,342,-1,10,0,12};
		
		System.out.println("C (unsorted): " + Arrays.toString(C));
		
		key = 32;
		// WRONG!!! using binary search on array NOT sorted.
		System.out.println("Position of " + key + ": " + Arrays.binarySearch(C, key));
		
		Arrays.sort(C);
		System.out.println("C (sorted): " + Arrays.toString(C));
		
		key = 32;
		System.out.println("Position of " + key + ": " + Arrays.binarySearch(C, key));
	}
	
	public static void mergeSortedArrays(int[] A, int m, int[] B, int n) {
		int a = m - 1; 
		int b = n - 1; 
		int i = m + n - 1;
		
		while (i >= 0) {
			if (b < 0 || (a >=0 && A[a] > B[b])) {
				A[i--] = A[a--];
			}
			else {
				A[i--] = B[b--];
			}
		}
	}

}
