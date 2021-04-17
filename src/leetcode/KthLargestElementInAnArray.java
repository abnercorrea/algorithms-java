package leetcode;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] a, int k) {
        if (a == null || k < 1 || k > a.length) return 0;

        int start = 0, end = a.length - 1;
        k = a.length - k;

        while (end >= start) {
            int pivotPos = partitionArray(a, start, end);

            if (pivotPos == k)
                break;
            else if (pivotPos > k)
                end = pivotPos - 1;
            else
                start = pivotPos + 1;
        }

        return a[k];
    }

    // time: O(n), space: O(1)
    public static int partitionArray(int[] a, int low, int high) {
        // uses element at the center of partition as pivot
        int pivot = (low + high) >>> 1;
        int pivotValue = a[pivot];

        // swaps pivot with last partition's element (classic quicksort)
        swap(a, pivot, high);

        pivot = low;

        for (int i = low; i < high; i++)
            if (a[i] < pivotValue) {
                swap(a, i, pivot);
                pivot++;
            }

        // puts pivot on it's final position
        swap(a, pivot, high);

        return pivot;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
