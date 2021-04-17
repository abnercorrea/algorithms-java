package sortsearch;

public class HeapSort<T extends Comparable<? super T>> extends AbstractSortingAlgorithm<T> {

	public void sort(T[] a, int low, int high) {
	    heapfyBottomUp(a, high);
	    
	    while (high >= low)
	    	a[high] = heapExtractMax(a, high--);
	}

	public void heapfyBottomUp(T[] a, int high) {
	    int lastParent = (high - 1) >>> 1;
	    
	    for (int i = lastParent; i >= 0; i--)
	        siftDown(a, i, high, false);
	}

	public void siftDown(T[] a, int node, int high, boolean delete) {
	    int leftChild = (node << 1) + 1;
	    
	    if (leftChild > high) // Leaf
	        return;
	        
	    int rightChild = leftChild + 1;
	   
	    int maxNode = (delete) ? leftChild : (a[node].compareTo(a[leftChild]) >= 0) ? node : leftChild;
	    
	    if (rightChild <= high && a[maxNode].compareTo(a[rightChild]) < 0) 
	        maxNode = rightChild;
	    
	    if (maxNode != node) {
	        if (delete) 
	        	a[node] = a[maxNode];
	        else
	        	SortingBenchmark.swap(a, node, maxNode);
	        
	        siftDown(a, maxNode, high, delete);
	    }    
	}

	public T heapExtractMax(T[] a, int high) {
	    T max = a[0];
	    
	    siftDown(a, 0, high, true);
	    
	    return max;
	}
	
	public static void sort(int[] a) {
	    heapfyBottomUp(a);
	    
	    for (int i = a.length; i > 0; i--)
	    	a[i - 1] = heapExtractMax(a, i);
	}

	public static void heapfyBottomUp(int[] a) {
	    int lastParent = (a.length - 2) >>> 1;
	    
	    for (int i = lastParent; i >= 0; i--)
	        siftDown(a, i, a.length, false);
	}

	public static void siftDown(int[] a, int node, int length, boolean delete) {
	    int leftChild = (node << 1) + 1;
	    
	    if (leftChild >= length)
	        return;
	        
	    int rightChild = (node << 1) + 2;
	   
	    int maxNode = (delete) ? leftChild : (a[node] >= a[leftChild]) ? node : leftChild;
	    
	    if (rightChild < length && a[maxNode] < a[rightChild]) 
	        maxNode = rightChild;
	    
	    if (maxNode != node) {
	        if (delete) 
	        	a[node] = a[maxNode];
	        else
	        	SortingBenchmark.swap(a, node, maxNode);
	        
	        siftDown(a, maxNode, length, delete);
	    }    
	}

	public static int heapExtractMax(int[] a, int length) {
	    int max = a[0];
	    
	    siftDown(a, 0, length, true);
	    
	    return max;
	}

	@Override
	public boolean isNSquare() {
		// TODO Auto-generated method stub
		return false;
	}
}
