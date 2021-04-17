package sortsearch;

public abstract class AbstractSortingAlgorithm<T extends Comparable<? super T>> implements SortingAlgorithm<T> {

	public void sort(T[] a) {
		sort(a, 0, a.length - 1);
	}
		
}
