/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/

// n & (n - 1) always removes the least significant 1 in n
// time: O(n), where n is the number of bits used to represent the number
// space: O(1)
int hammingWeight(int n) {
    int count = 0;
    
    while(n!=0){
        n = n & (n - 1);
        count++;
    }
    
    return count;
}

// Decimal version
int onesInDecimal(int n) {
    if (n < 0) n *= -1;
    
    int ones = 0;
    
    while (n > 0) {
        if (n % 10 == 1) ones++;
        n /= 10;
    }
    
    return ones;
}

// WRONG!! doesn't work for negatives
int onesInBinaryWRONG(int n) {
    int ones = 0;
    
    while (n != 0) { 
        if ((n & 1) == 1) ones++;
        n >>= 1;
    }
    
    return ones;
}

