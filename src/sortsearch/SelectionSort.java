package sortsearch;

public class SelectionSort<T extends Comparable<? super T>> extends AbstractSortingAlgorithm<T> {

	public void sort(T[] a, int low, int high) {
		for (int i=low, j=low, min=low; i<=high; i++) {
            for (j=i+1, min=i; j<=high; j++) 
            	if (a[j].compareTo(a[min]) < 0)
            		min = j;
            
            SortingBenchmark.swap(a, i, min);
		}
	}

	@Override
	public boolean isNSquare() {
		// TODO Auto-generated method stub
		return true;
	}

}
