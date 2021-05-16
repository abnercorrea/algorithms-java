// time: O(1), space: O(1)
public static int swapOddEvenBits(int n) {
    // /uses 5 instructions (2 Ands, 2 Shifts, 1 Or)
    // CAREFUL!! shift odd bits right and even bits left
    return ((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1);
}

// test
public static int bin(String binStr) {
    return Integer.parseInt(binStr, 2);
}

swapOddEvenBits(bin("10")) == bin("01")
swapOddEvenBits(bin("11")) == bin("11")
swapOddEvenBits(bin("10011001")) == bin("01100110")

// in hex, every digit translates into 4 bits
// odd bits mask (for 1 byte)
10101010 = 0xAA 
// even bits mask (for 1 byte)
01010101 = 0x55

/* Steps:
1- Extract odd bits using mask
2- Shift odd bits right 1 position
3- Extract even bits using mak
4- Shift even bits left 1 position
5- Combine (OR) the results of 2 and 4
*/

