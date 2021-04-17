package java;

public class BinaryDemo {

    public static void main(String[] args) {
        int b = 8;

        System.out.println(b + " in binary: ");
        System.out.println(new String(toBitArray(b)));
        System.out.println(b + " in binary (recursion): ");
        printBits(b);
        System.out.println();

        System.out.println("(3 & 1) = " + (3 & 1));
        System.out.println("(4 | 1) = " + (4 | 1));
        System.out.println("(8 XOR 4) = " + (8 ^ 4));
        System.out.println("(not 0) = " + (~0));
        System.out.println("(7 << 1) = " + (7 << 1));
        System.out.println("(7 >> 1) = " + (7 >> 1));
        System.out.println("(-2 >> 1) = " + (-2 >> 1));
        System.out.println("(-2 >>> 1) = " + (-2 >> 1));
        System.out.println("(0 >> 1) = " + (0 >> 1));


        System.out.println("Swapping values using XOR: ");
        int s[] = new int[]{5, 8};
        System.out.println("s1 = " + s[0] + ", s2 = " + s[1]);

        swap(s, 0, 1);

        System.out.println("s1 = " + s[0] + ", s2 = " + s[1]);

    }

    private static void swap(int[] s, int x, int y) {
        s[x] = s[x] ^ s[y];
        s[y] = s[y] ^ s[x];
        s[x] = s[x] ^ s[y];
    }

    public static char[] toBitArray(int number) {
        int bitCount = (int) Math.floor(log((double) number, 2)) + 1;
        char[] bitArray = new char[bitCount];

        for (int i = 0; i < bitCount; i++)
            bitArray[bitCount - i - 1] = ((number & (1 << i)) == 0) ? '0' : '1';

        return bitArray;
    }

    public static void printBits(int i) {
        if (i == 0)
            return;

        printBits(i >> 1);

        System.out.print(i & 1);
    }

    public static double log(double n, double base) {
        return Math.log10(n) / Math.log10(base);
    }

}
