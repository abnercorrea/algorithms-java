package sortsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

public class SortingBenchmark {

	private static final int NUM_ALGORITHMS = 9;
	private static final int MAX_ARRAY_SIZE = 10000000;
	private static final int INITIAL_SIZE = 10;
	private static final int GROWTH_FACTOR = 2;
	
	private static final int N_SQUARE_SORT_MAX = 5000;

	public static void main(String[] args) {
		
		benchmarkSorts();
		
		//stressHeapSort();
		
	}

	private static <T> void benchmarkSorts() {
		int numRuns = (int) ((Math.log10(MAX_ARRAY_SIZE) - Math.log10(INITIAL_SIZE)) / Math.log10(GROWTH_FACTOR)) + 1;
		int maxSize = INITIAL_SIZE * ((int)Math.pow(GROWTH_FACTOR, numRuns - 1));
		
		Integer[][] numbers = new Integer[NUM_ALGORITHMS][maxSize];
		
		long[][] runTime = new long[NUM_ALGORITHMS][numRuns];
				
		System.out.println("numRuns: " + numRuns + " total numbers: " + maxSize);
		System.out.println("Sorting numbers: ");
		
		String[] algorithmNames = { "QuickSort", "QuickSortIterative", "QuickSortAdaptive", "QuickSortAdaptiveTCO", "MergeSort", "HeapSort", "BubbleSort", "SelectionSort", "InsertionSort" };
		
		List<SortingAlgorithm<Integer>> algotithms = new ArrayList<SortingAlgorithm<Integer>>();
		algotithms.add(new QuickSort<Integer>());
		algotithms.add(new QuickSortIterative<Integer>());
		algotithms.add(new QuickSortAdaptive<Integer>());
		algotithms.add(new QuickSortAdaptiveTCO<Integer>());
		algotithms.add(new MergeSort<Integer>(new Integer[maxSize >>> 1]));
		algotithms.add(new HeapSort<Integer>());
		algotithms.add(new BubbleSort<Integer>());
		algotithms.add(new SelectionSort<Integer>());
		algotithms.add(new InsertionSort<Integer>());
		
		for (int n = 0, length = INITIAL_SIZE; length <= MAX_ARRAY_SIZE; n++, length*=GROWTH_FACTOR) {			
			System.out.print(length + ", ");
			
			// Generates random numbers to be sorted
			for (int i = 0; i < length; i++) {
				int num = (int) Math.floor(Math.random() * length * 3);
				
				for (int j = 0; j < NUM_ALGORITHMS; j++)
					numbers[j][i] = num;
			}

			// Invokes sorting algorithms
			for (int j = 0; j < NUM_ALGORITHMS; j++) {
				if (!algotithms.get(j).isNSquare() || length <= N_SQUARE_SORT_MAX) {
					runTime[j][n] = benchmark(algotithms.get(j), numbers[j], length);
				}
			}
		}

		System.out.println();
		System.out.println();
		System.out.println("Results: ");
		
		for (int j = 0; j < NUM_ALGORITHMS; j++) {
			System.out.println(algorithmNames[j]);
			System.out.println(Arrays.toString(runTime[j]));
		}
	}

	private static <T extends Comparable<? super T>> long benchmark(SortingAlgorithm<T> algorithm, T[] a, int length) {
		long start = System.nanoTime();
		
		algorithm.sort(a, 0, length - 1);
		
		long end = System.nanoTime();
		
		if (!isSorted(a, length - 1))
			System.out.println("SORT problem!!! ");
		
		return elepsedTime(start, end);
	}

	private static long elepsedTime(long start, long end) {
		return (end - start) / 1000; // in µs
	}

	public static void stressHeapSort() {
		int[] numbers = new int[MAX_ARRAY_SIZE];
		int length = numbers.length;
		long start, end, runTime;
				
		System.out.println("HEAPSORT stress test.");
		System.out.println("Generating random numbers: " + MAX_ARRAY_SIZE);

		start = System.nanoTime();

		// Generates random numbers to be sorted
		for (int i = 0; i < length; i++) {
			numbers[i] = (int)(Math.random() * length * 3);
		}

		end = System.nanoTime();
		runTime = elepsedTime(start, end);

		System.out.println("Random numbers generated in : " + runTime + " µs");

		System.out.println("Sorting numbers: ");
		
		// HeapSort
		start = System.nanoTime();
		
		HeapSort.sort(numbers);

		end = System.nanoTime();
		runTime = elepsedTime(start, end);

		System.out.println("Total time: " + runTime + " µs");

		if (!isSorted(numbers, length))
			System.out.println("HEAPSORT problem!!!");
	}

	public static <T> void swap(T[] a, int a1, int a2) {
		T temp = a[a1];
		a[a1] = a[a2];
		a[a2] = temp;
	}
	
	public static void swap(int[] a, int a1, int a2) {
		int temp = a[a1];
		a[a1] = a[a2];
		a[a2] = temp;
	}
	
	private static <T extends Comparable<? super T>> boolean isSorted(T[] array, int length) {
		boolean isOrdered = true;
		
		for (int i = 1; i < length && isOrdered; i++) 
			isOrdered = array[i].compareTo(array[i - 1]) >= 0; 
			
		return isOrdered;
	}

	private static boolean isSorted(int[] array, int length) {
		boolean isOrdered = true;
		
		for (int i = 1; i < length && isOrdered; i++) 
			isOrdered = array[i - 1] <= array[i]; 
			
		return isOrdered;
	}

}
