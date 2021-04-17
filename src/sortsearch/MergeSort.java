package sortsearch;

import java.util.LinkedList;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>> extends AbstractSortingAlgorithm<T> {

	T[] aux;

	public MergeSort(T[] aux) {
		this.aux = aux;
	}
	
	public void sort(T[] a, int low, int high) {
		if (low >= high) // 1 or 0 elements sub array... already sorted.
			return;
		
		int mid = (low + high) >>> 1;
			
		sort(a, low, mid);
		sort(a, mid + 1, high);
		
		mergeSubArrays(a, low, mid, high);
	}
	
	public void mergeSubArrays(T[] a, int low, int mid, int high) {
		System.arraycopy(a, mid + 1, aux, 0, high - mid);
		
		for (int i = high, l = mid, h = high - mid - 1; i >= low && h >= 0 ; i--)
			if (l >= low && a[l].compareTo(aux[h]) > 0) 
				a[i] = a[l--];
			else
				a[i] = aux[h--];
	}

	/**
	 * BAD!!! way slower than O(n) aux space version above... (n/2 to be more precise)
	 * 
	 * @param a
	 * @param low
	 * @param high
	 */
	public static <T extends Comparable<? super T>> void sortInPlace(T[] a, int low, int high) {
		if (low >= high) // 1 or 0 elements sub array... already sorted.
			return;
		
		int mid = (low + high) >>> 1;
			
		sortInPlace(a, low, mid);
		sortInPlace(a, mid + 1, high);
		
		mergeSubArraysInPlace(a, low, mid, high);
	}
	
	public static <T extends Comparable<? super T>> void mergeSubArraysInPlace(T[] a, int low, int mid, int high) {
		for (int i = low, j = mid + 1; i < j && j <= high; i++) 
			if (a[j].compareTo(a[i]) < 0) {
				T temp = a[j];
				for (int k = i + 1; k <= j; k++)
					a[k] = a[k - 1];
				a[i] = temp;
				j++;
			}
	}

	/**
	 * NOT actually used...
	 * 
	 * @param lists
	 * @return
	 */
	public static <T extends Comparable<? super T>> List<T> mergeLists(List<T>[] lists) {
		List<T> result = new LinkedList<>();
		T min = null;
		
		int minList = -1, emptyLists = 0, totalLists = lists.length;
				
		for (int i = 0; i < totalLists; i++)
			if (lists[i].isEmpty())
				emptyLists++;
		
		while (emptyLists < totalLists) {
			minList = -1;
			
			for (int i = 0; i < totalLists; i++) 
				if (!lists[i].isEmpty()) {
					if (minList == -1 || lists[i].get(0).compareTo(min) < 0)  {
						min = lists[i].get(0);
						minList = i;
					}
				}
			
			result.add(min);
			lists[minList].remove(0);
			if (lists[minList].isEmpty())
				emptyLists++;
		}
					
		return result;
	}

	@Override
	public boolean isNSquare() {
		// TODO Auto-generated method stub
		return false;
	}

}
