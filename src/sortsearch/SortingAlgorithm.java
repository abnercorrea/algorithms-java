package sortsearch;

public interface SortingAlgorithm<T extends Comparable<? super T>> {

	public void sort(T[] a);

	public void sort(T[] a, int low, int high);

	public boolean isNSquare();
}
