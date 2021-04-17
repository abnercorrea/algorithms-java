package sortsearch;

public class QuickSortAdaptive<T extends Comparable<? super T>> extends QuickSort<T> {

	public void sort(T[] a, int low, int high) {
		if (low >= high) // base cases: 1 - empty partition, 2 - partition with 1 element
			return;

		// Adaptive sort... user insertion sort for small arrays.
		if (high - low < INSERTION_SORT_TRESHOLD) {
			new InsertionSort<T>().sort(a, low, high);
			return;
		}
		
		int pivot = quickSortPartition(a, low, high);
		
		sort(a, low, pivot - 1); 
		sort(a, pivot + 1, high);
	}


}
