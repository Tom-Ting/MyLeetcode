package org.leetcode;

import org.junit.Test;

public class T70_M {
    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 46; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    @Test
    public void run(){
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(40));
    }
}
