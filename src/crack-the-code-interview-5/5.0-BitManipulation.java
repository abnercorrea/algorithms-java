public static boolean getBit(int n, int i) {
    return (n & (1 << i)) != 0;
}
     
public static int setBit(int n, int i) {
    return n | (1 << i);
}
     
public static int clearBit(int n, int i) {
    return n & ~(1 << i);
}
     
public static int bin(String binStr) {
    return Integer.parseInt(binStr, 2);
}

byte    8 bits
short   16 bits
int     32 bits
long    64 bits 

AND &
OR  |
XOR ^
NOT ~
SL  <<
SR  >>
ASR >>>

x ^ x = 0
x ^ 0 = x
x ^ 1 = ~x

11111111 = 0xAA

// In java, you use Integer.parseInt("1011", 2), to create an int from a binary string
// 2ˆn * x = x << n
0110 + 0110 = 2 * 0110 = 0110 << 1 = 1100
0011 * 0100 = 0011 * 4 = 0011 * 2^2 = 0011 << 2 = 1100
// x & (~0 << n) = clears n right most bits of x
1011 & (~0 << 2) = 1000
 
// HEX notation
0xFF00FF
// Create int from binary string
Integer.parseInt("100000000010000000001000000000", 2)

// Arithmetic shift right
6 >> 1 = "110" >> 1 = "11" = 3 
-2 >> 1 (using 8 bits) = "11111110" >> 1 = "11111111"

// Integer max and min
Math.pow(2, 31) - 1 == Integer.MAX_VALUE
-Math.pow(2, 31) == Integer.MIN_VALUE
