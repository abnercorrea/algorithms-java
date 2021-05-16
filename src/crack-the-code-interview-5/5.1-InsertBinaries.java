public static int leftMostOnes(int n) {
    return (1 << n) - 1;
}

// time: O(1), space: O(1)
public static int insertBinary(int m, int n, int i, int j) {
    // ~leftMostOnes(j+1) | leftMostOnes(i) = zeroes bits from i to j (inclusive) and 1 for all other bits
    // will be used to clear bits from i to j (inclusive) of m (m & clearMask) 
    int clearMask = ~leftMostOnes(j+1) | leftMostOnes(i);
        
    // CAREFUL!!! it's OR (n << i), otherwise you clear bits you don't want 
    // (n << i) = N shifted left i bits
    return (m & clearMask) | (n << i);
}

// test
public static int bin(String binStr) {
    return Integer.parseInt(binStr, 2);
}

insertBinary(bin("101001010"), bin("1111"), 2, 6) == bin("100111110")
insertBinary(bin("101001010"), bin("1111"), 2, 5) == bin("101111110")
insertBinary(bin("1000"), bin("1"), 2, 2) == bin("1100")
insertBinary(bin("0"), bin("11"), 9, 10) == bin("11000000000")

M=101001010
N=1111
i=2
j=5
result=101111110

// Questions
//- what if j-i+1 > length N ? 
//     pad N with zeroes to the left

M=101001010
N=1111
i=2
j=6 (needs to pad N with 1 zero to the left, so N=01111)
result=100111110

- clear j + 1 left most bits of M
100000000
CAREFUL!!! it is OR and not AND
- or N shifted left i bits
100000000 & (1111 << 2) = 100000000 & 111100 = 100111100
- or i least significant bits of M
100111100 & 10 = 100111110