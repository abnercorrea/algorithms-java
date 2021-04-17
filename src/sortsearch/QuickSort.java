package sortsearch;

public class QuickSort<T extends Comparable<? super T>> extends AbstractSortingAlgorithm<T> {

	protected static final int INSERTION_SORT_TRESHOLD = 8;

	public void sort(T[] a, int low, int high) {
		if (low >= high) // base cases: 1 - empty partition, 2 - partition with 1 element
			return;

		int pivot = quickSortPartition(a, low, high);
		
		sort(a, low, pivot - 1); 
		sort(a, pivot + 1, high);
	}


	public int quickSortPartition(T[] a, int low, int high) {
		int pivot = (low + high) >>> 1; // uses element at the center of partition as pivot
		T pivotValue = a[pivot];
		
		SortingBenchmark.swap(a, pivot, high); // swaps pivot with last partition's element (classic quicksort)
		
		pivot = low; // pivot final position initial value is the beginning of the sub array  
		
		// after the loop, pivot will hold the final position of pivot within the partitioned array
		for (int i = low; i < high; i++) {
			if (a[i].compareTo(pivotValue) < 0) {
				SortingBenchmark.swap(a, i, pivot);
				pivot++; // moves pivot's final position to the right.
			}
		}
		
		SortingBenchmark.swap(a, pivot, high); // puts pivot on it's final position
		
		return pivot;
 	}

	public int quickSortPartition(int[] a, int low, int high) {
		int pivot = (low + high) >>> 1; // uses element at the center of partition as pivot
		int pivotValue = a[pivot];
		
		SortingBenchmark.swap(a, pivot, high); // swaps pivot with last partition's element (classic quicksort)
		
		pivot = low; // pivot final position initial value is the beginning of the sub array  
		
		// after the loop, pivot will hold the final position of pivot within the partitioned array
		for (int i = low; i < high; i++) {
			if (a[i] < pivotValue) {
				SortingBenchmark.swap(a, i, pivot);
				pivot++; // moves pivot's final position to the right.
			}
		}
		
		SortingBenchmark.swap(a, pivot, high); // puts pivot on it's final position
		
		return pivot;
 	}


	@Override
	public boolean isNSquare() {
		// TODO Auto-generated method stub
		return false;
	}

}
