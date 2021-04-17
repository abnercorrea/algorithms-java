package java;

public class MathDemo {

    public static void main(String[] args) {
        int low = 1, high = 8;
        int mid1 = (low + high) >> 1;
        int mid2 = (low + high) >>> 1;

        System.out.println("low: " + low + " high: " + high);
        System.out.println("(low + high) >> 1 = " + mid1);
        System.out.println("(low + high) >>> 1 = " + mid2);
        System.out.println("2 << high = " + (2 << high));
        System.out.println("high << 2 = " + (high << 2));
        System.out.println("-5 mod 2 = " + (-5 % 2));


        System.out.println("Math.pow(Math.PI, 2) = " + Math.pow(Math.PI, 2));
        System.out.println("Math.floor(Math.pow(Math.PI, 2)) = " + Math.floor(Math.pow(Math.PI, 2)));
        System.out.println("Math.ceil(Math.pow(Math.PI, 2)) = " + Math.ceil(Math.pow(Math.PI, 2)));
        System.out.println("Math.E = " + Math.E);
        System.out.println("Math.log(Math.E) = " + Math.log(Math.E));
        System.out.println("Math.log10(1000) = " + Math.log10(1000));
        System.out.println("log(64, 2) = " + log(64, 2));
        System.out.println("Math.sqrt(225) = " + Math.sqrt(225));
        System.out.println("Math.cbrt(64) = " + Math.cbrt(64));
        System.out.println("Math.abs(-123) = " + Math.abs(-123));
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.sin(Math.PI / 2) = " + Math.sin(Math.PI / 2));
        System.out.println("Math.cos(Math.PI) = " + Math.cos(Math.PI));

        int maxDig = 7;
        double total = 0;
        for (int i = 1, numCount = 9; i <= maxDig; i++, numCount *= 10)
            total += i * numCount;
        double avgDig = total / (Math.pow(10, maxDig) - 1);

        System.out.println("Numero medio de digitos dos numeros com ate " + maxDig + " digitos: " + avgDig);

    }

    public static double log(double n, double base) {
        return Math.log10(n) / Math.log10(base);
    }
}
