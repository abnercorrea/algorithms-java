/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

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
