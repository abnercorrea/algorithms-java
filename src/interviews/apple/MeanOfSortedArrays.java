/*
Having two distinct very large ordered array of values, 
find the mean value(not median) of the two arrays.

Scan through the array and at each step calculate the mean as 
M(n+1) = M(n) * n/(n+1) + A[n+1]/(n+1)
*/

double iterativeMean(int[] a, double m0, int n0) {
    if (a == null) return m0;

    double mean = m0;

    for (int i = 0, n = n0; i < a.length; i++, n++) mean = (mean * n + a[i]) / (n + 1);

    return mean;
}

double meanOfArrays(int[] a, int[] b) {
    double meanA = iterativeMean(a, 0, 0);

    return iterativeMean(b, meanA, a.length);
}

double meanOfArrays(int[][] a) {
    if (a == null) return 0;

    double mean = 0;

    for (int i = 0, n = 0; i < a.length; i++) {
        mean = iterativeMean(a[i], mean, n);
        n += a[i].length;
    }

    return mean;
}

meanOfArrays(new int[] {4,4,4}, new int[] {2,2,2})
meanOfArrays(new int[][] {new int[] {4,4,4}, new int[] {2,2,2}, new int[] {6,6,6}})
meanOfArrays(new int[][] {new int[] {4,4,4}, new int[] {2,2,2}, new int[] {6,6,6}, new int[] {8,8,8}})
