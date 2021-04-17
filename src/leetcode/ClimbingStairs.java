package leetcode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 3) return n;

        int ways = 0;

        for (int i = 3, w1 = 2, w2 = 1; i <= n; i++) {
            ways = w1 + w2;
            w2 = w1;
            w1 = ways;
        }

        return ways;
    }
}
