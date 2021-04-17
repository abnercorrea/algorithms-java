package sortsearch;

public class QuickSortAdaptiveTCO<T extends Comparable<? super T>> extends QuickSort<T> {

	/**
	 * Adaptive + TCO (tail call optimization)
	 * @param a
	 * @param low
	 * @param high
	 */
	public void sort(T[] a, int low, int high) {
		if (low >= high) // base cases: 1 - empty partition, 2 - partition with 1 element
			return;

		// Adaptive sort... user insertion sort for small arrays.
		if (high - low < INSERTION_SORT_TRESHOLD) {
			new InsertionSort<T>().sort(a, low, high);
			return;
		}
		
		int pivot = quickSortPartition(a, low, high);
		
		// decides which partition is longer to guarantee first recursion call will be done on the smaller partition.
		// Tail call is made for longer partition to save call stack space.
		if (pivot > ((high + low) >>> 1)) {  
			sort(a, pivot + 1, high);
			sort(a, low, pivot - 1); 
		}
		else {
			sort(a, low, pivot - 1); 
			sort(a, pivot + 1, high);
		}
	}
	
}
