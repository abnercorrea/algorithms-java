package sortsearch;

public class InsertionSort<T extends Comparable<? super T>> extends AbstractSortingAlgorithm<T> {

	public void sort(T[] a, int low, int high) {
		T temp;
		for (int i=low, j=0; i<=high; i++) {
			temp = a[i]; // current element to be inserted
            for (j=i; j>low && a[j-1].compareTo(temp) > 0; j--) // after the loop, j will hold the position to insert temp. 
                a[j] = a[j-1]; // Shifts array to the right
            a[j] = temp;
		}
	}

	@Override
	public boolean isNSquare() {
		// TODO Auto-generated method stub
		return true;
	}

}
