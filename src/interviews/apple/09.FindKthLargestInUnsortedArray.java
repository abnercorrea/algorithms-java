/* 
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

Algorithm
- uses quicksort idea... partitions array into sub-arrays 
- when pivot positon is equal to k, the pivot will be the kth element in the array
- if pivot > k, go left, otherwise, go right
- used partioning algorithm from "classic" quicksort. (move pivot to the end, find its real place, then move back)
*/

// time: O(n.log(n)), space: O(1)
public static int kthLargest(int[] a, int k) {
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

// test
kthLargest(new int[] {3,7,0,1,5,6,2,8,4,9}, 1)
kthLargest(new int[] {3,7,0,1,5,6,2,8,4,9}, 8)
kthLargest(new int[] {3,7,0,1,5,6,2,8,4,9}, 7)


