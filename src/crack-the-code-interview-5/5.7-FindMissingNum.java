// time: O(n), space: O(n)
public static Integer findMissingNum(int[] A) {
    if (A == null) return null;
    
    boolean b = false;
    
    for (int n = 0; n < A.length; n++) {
        // if first bit is not the expected (first bit will start as 0 and alternate between 0 and 1, even and odd)
        if (getBit(A[n], 0) != b) return n; 
        
        b = !b;
    }
    
    // Edge case array is empty or actually complete.
    return null;
}

public static boolean getBit(int n, int i) {
    return ((1 << i) & n) != 0;
}

//test
int[][] a = {
    {0,1,2,3,4,5,7,8,9},
    {1,2,3,4},
    {},
    null
}

Arrays.stream(a).map(ai -> findMissingNum(ai)).forEach(System.out::println)

// debug
A = 0,1,2,3,4,5,7,8,9
A = 0,1,10,11,100,101,111,1000,1001
b = f,t,f,t,f,t,f
n = 0,1,2,3,4,5,6
return 6 OK

// algorithm
6 is missing
0,1,2,3,4,5,7,8,9
0,1,10,11,100,101,111,1000,1001
for a sequence of integers, 0 and 1 alternates in the bit 0