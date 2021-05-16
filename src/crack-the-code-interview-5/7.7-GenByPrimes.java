// Brute force
// time: O(Kˆ2), space: O(K)
public static int genByPrimes(int k, int[] primes) {
    int[] a = new int[k + 1];
    a[0] = 1;
    
    for (int j = 1; j <= k; j++) {
        a[j] = Integer.MAX_VALUE;
        
        for (int i = 0; i < j; i++)
            for (int p = 0; p < primes.length; p++) {
                int n = a[i] * primes[p];
                
                if (n > a[j - 1] && n < a[j])
                    a[j] = n;
            }
    }
    
    return a[k];
}

// test

genByPrimes(9, new int[] {3, 5, 7});
genByPrimes(6, new int[] {3, 5, 7});






// modified
public static int[] genByPrimes(int k, int[] primes) {
    int[] a = new int[k + 1];
    
    a[0] = 1;
    
    for (int j = 1; j <= k; j++) 
        for (int i = 0; i < j; i++)
            for (int p = 0; p < primes.length; p++) {
                int n = a[i] * primes[p];
                
                if (n > a[j - 1] && (a[j] == 0 || n < a[j]))
                    a[j] = n;
            }
  
    return a;
}
