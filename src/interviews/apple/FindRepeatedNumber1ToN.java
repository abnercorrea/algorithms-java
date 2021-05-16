// time: O(n), space: O(1)
int repeatedNum1ToN(int[] a) {
    if (a == null || a.length == 0) return 0;
    
    int n = a.length, sumA = 0;
    // a[0] = 1, a[n - 1] = n - 1
    int sumP = n * (n - 1) / 2;
    
    for (int i = 0; i < n; i++) sumA += a[i];
    
    return sumA - sumP;
}


// test
repeatedNum1ToN(new int[] {1,2,3,4,4,5,6,7,8,9})
repeatedNum1ToN(new int[] {1,2,3,4,5,6,7,7,8,9})
repeatedNum1ToN(new int[] {1,2,3,4,5,6,7,8,9,9})
repeatedNum1ToN(new int[] {1,1,2,3,4,5,6,7,8,9})

// Algorithm
a = 1,2,3,4,4,5,6,7,8,9
n = 10
sumP = (a[0] + a[n-1]) * (n - 1) / 2 = (1 + n - 1) * (n - 1) / 2 = n * (n - 1) / 2 = (1 + 9) * (10 - 1) / 2 = 10*9/2 = 45
sumA = 49
repeated = sumA - sumP = 4