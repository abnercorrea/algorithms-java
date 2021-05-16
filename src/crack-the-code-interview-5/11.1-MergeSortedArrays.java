// Questions:
// - Does a hold exactly all the elements of a and b or could be extra space?
// the algorithm below assumes a has exactly the space needed to hold the elements of both arrays.

// time: O(a + b), space: O(1)
public static void mergeArrays(int[] a, int[] b) {
    if (a == null || b == null) return;
    
    // logical end of a or buffer start
    int bufferStart = a.length - b.length;
    
    for (int i = a.length - 1, ia = bufferStart - 1, ib = b.length - 1; i >= 0 && ib >= 0; i--) {
        // CAUTION!! if | is used both sides are evaluated
        // use || to evaluate from left to right
        if (ia < 0 || a[ia] < b[ib])
            a[i] = b[ib--];
        else
            a[i] = a[ia--];
    }
}

// test
int[] a = {0,1,2,3,4,5,6,7,0,0,0,0}
int[] b = {8,9,10,11}

mergeArrays(a, b)

int[] a = {4,5,16,17,28,29,31,35,0,0,0,0}
int[] b = {0,10,20,30}

mergeArrays(a, b)

// debug
A = {0,1,2,3,4,5,6,7,0,0,0,0}
B = {8,9,10,11}
bufferStart = 8
i = 11,10,9,8,7
ia = 7
ib = 3,2,1,0,-1
A = {0,1,2,3,4,5,6,7,8,9,10,11}

A = {4,5,6,7,8,9,10,11,0,0,0,0}
B = {0,1,2,3}
bufferStart = 8
i = 11,10,9
ia = 7,6,5,4,3,2,1,0,-1
ib = 3,2,1,0,-1
A = {0,1,2,3,4,5,6,7,8,9,10,11}


/* Algorithm
A = {0,1,2,3,4,5,6,7,0,0,0,0}
B = {8,9,10,11}

- find start of A's buffer
bufferStart = A.length - B.length
- Iterate on sub-arrays 
    - A from bufferStart - 1 to 0 
    - B from B.length - 1 to 0
    - Fill A from A.length -1 to 0 with the max element between sub-arrays above
-

*/