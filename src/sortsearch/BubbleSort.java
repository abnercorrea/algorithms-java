package sortsearch;

public class BubbleSort<T extends Comparable<? super T>> extends AbstractSortingAlgorithm<T> {

	public void sort(T[] a, int low, int high) {
		boolean swaped = true;
		
		while (swaped) {
			swaped = false;

			for (int i=low; i<high; i++)
				if (a[i].compareTo(a[i+1]) > 0) {
					SortingBenchmark.swap(a, i, i + 1);
					swaped = true;
				}
		}
	}

	@Override
	public boolean isNSquare() {
		// TODO Auto-generated method stub
		return true;
	}

}
