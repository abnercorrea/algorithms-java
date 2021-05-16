/*
There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).
*/

// time: O(log(n))
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int total = nums1.length+nums2.length;
    
    if(total % 2 == 0){
        return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
    }else{
        return findKth(total/2+1, nums1, nums2, 0, 0);
    }
}
 
public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
    if(s1>=nums1.length)
        return nums2[s2+k-1];
 
    if(s2>=nums2.length)
        return nums1[s1+k-1];
 
    if(k==1)
        return Math.min(nums1[s1], nums2[s2]);
 
    int m1 = s1+k/2-1;
    int m2 = s2+k/2-1;
 
    int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;    
    int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;
 
    if(mid1<mid2){
        return findKth(k-k/2, nums1, nums2, m1+1, s2);
    }else{
        return findKth(k-k/2, nums1, nums2, s1, m2+1);
    }
}




// time: O(n)
// similar to merge sorted arrays
Double median(int[] a, int[] b) {
    if (a == null && b == null) return null;
    if (a.length == 0 && b.length == 0) return null;
    if (a.length < b.length) return median(b, a);
    
    int na = a.length, nb = b.length, n = na + nb;    
    boolean oddN = n % 2 == 1;
    int medianI = (oddN) ? n / 2 : (n / 2) - 1;
    
    int ia = 0, ib = 0;
    
    while (ia + ib < medianI)
        if (ib == nb || (ia < na && a[ia] <= b[ib])) ia++; else ib++;
    
    double median = (ib == nb) ? a[ia] : (ia == na) ? b[ib] : Math.min(a[ia], b[ib]);
     
    if (!oddN) {
        if (ib == nb || (ia < na && a[ia] <= b[ib])) ia++; else ib++;
    
        median += (ib == nb) ? a[ia] : (ia == na) ? b[ib] : Math.min(a[ia], b[ib]);
        median /= 2;
    }
    
    return median;
}

//
int[] a = {1,2,3,4,5,6,7,8,9,10}
int[] b = {2,4,8,10,12}

median(a, b)


// Algorithm
a: 1,2,3,4,5,6,7,8,9,10
b: 2,4,8,10,12
a+b: 1,2,2,3,4,4,5,*6*,7,8,8,9,10,10,12
na: 10
nb: 5

na >= nb
medianI = (10 + 5) / 2 = 7 
a[medianI] = 8

a: 1,2,3,4,5,6,7,8,9,10
b: 2,4,8,10,12,13,14
a+b: 1,2,2,3,4,4,5,6,*7*,8,8,9,10,10,12,13,14


1,2,3,4,5
6,7,8,9,10
m1 = 3
m2 = 8
