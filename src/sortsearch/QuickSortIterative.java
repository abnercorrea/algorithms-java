package sortsearch;

import java.util.Stack;

public class QuickSortIterative<T extends Comparable<? super T>> extends QuickSort<T> {

	public void sort(T[] a, int low, int high) {
		if (high - low < 1) // base cases: 1 - empty partition, 2 - partition with 1 element
			return;

		Stack<Integer> stack = new Stack<>();
		
		int pivot = 0;
		stack.push(high);
		stack.push(low);
		
		while (!stack.isEmpty()) {
			low = stack.pop();
			high = stack.pop();
			
			if (high - low < 1) // no need for anything if partition size < 2
				continue;
			
			pivot = quickSortPartition(a, low, high);

			// right partition 
			stack.push(high);			
			stack.push(pivot + 1); 
			
			// left partition
			stack.push(pivot - 1);
			stack.push(low);
		}
	}

}
