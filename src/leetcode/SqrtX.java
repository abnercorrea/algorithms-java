package leetcode;

public class SqrtX {
    public int mySqrt(int n) {
        // Caution!!! since n is int, divide by 2D (not 2) to get a double result.
        // Caution!!! use double instead of float for better precision.
        double x = n / 2D;
        double fx = x * x - n;
        // Caution!! add F to .001F cause 0.001 is actually a double
        double episilon = .0001D;

        // Caution with Math.abs(fx)!!! without it fails every time fx becomes negative
        for (int i = 0; Math.abs(fx) > episilon; i++) {
            x = x - (fx / (2 * x));
            fx = x * x - n;
        }

        // Caution!!! use round to get the closest int
        return (int) x;
    }
}
