// Fails for negatives base 2, using complement of 2.
.public int numDigits(int i, int b) { 
    return new Double(Math.log(i) / Math.log(b)).intValue() + 1; 
}

public int bitCount(int i) {
    int n = Integer.BYTES * 8;
    int count = () 0;
    
    for (; i != 0; i >>= 1) 
        if ((i & 1) == 1) count++;
        
    return count;
}

public int countChangeBits(int a, int b) {
    System.out.println(Integer.toBinaryString(a));
    System.out.println(Integer.toBinaryString(b));

    return bitCount(a ^ b);
}

/*
DEBUG bitCount
i = 6
bin = 110
n = 3
count = 0
*p = 0
6 & (1 << 0) = 110 & 1 = 0
*p = 1
6 & (1 << 1) = 110 & 10 = 10
count = 1
*p = 2
110 & 100 = 100 
count = 2
return 2
*/

// From stackoverflow.com
public int bitCountOptimized(int i) {
     i = i - ((i >>> 1) & 0x55555555);
     i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
     return (((i + (i >>> 4)) & 0x0F0F0F0F) * 0x01010101) >>> 24;
}