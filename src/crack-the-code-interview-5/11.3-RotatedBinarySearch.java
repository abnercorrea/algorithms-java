// time: O(log(n))
public static int rotatedBinarySearch(int[] a, int x) {
    if (a == null) return -1;
    
    int low = 0;
    int high = a.length - 1;
    
    while (high >= low) {    
        int mid = (low + high) >>> 1;
        
        if (a[mid] == x) return mid;
        
        // regular binary search    
        if (a[low] <= a[high]) {
            if (x < a[mid])
                high = mid - 1;
            else
                low = mid + 1;             
        }
        // rotated binary search
        else {
            if (x > a[high]) 
                high = mid - 1;
            else
                low = mid + 1;
        }
    }    
    
    return -1;
}

// test
int[] a = {6,7,8,9,10,0,1,2,3,4,5}

rotatedBinarySearch(a, 6)
rotatedBinarySearch(a, 2)
rotatedBinarySearch(a, 0)
rotatedBinarySearch(a, 16)


// debug
a= {6,7,8,9,10,0,1,2,3,4,5}
x = 6
low = 0
high = 10,4,1
mid = 5,2,0
return 6


/* Algorithm
- if high >= low -> normal binary search
  else 
    if x > high -> go left
    else go right 
  
  
  
6,7,8,9,10,0,1,2,3,4,5
    

*/