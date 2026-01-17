package org.leetcode;

import org.junit.Test;

public class T121_M {
    public int maxProfit(int[] prices) {
        // 第i位表示自第i天后（含）该股票最高价位
        int[] dp = new int[prices.length];
        int maxP = 0;
        dp[prices.length-1] = prices[prices.length-1];
        for (int i = prices.length-2; i >= 0 ; i--) {
            dp[i] = Math.max(prices[i], dp[i + 1]);
            if (dp[i]-prices[i] > maxP){
                maxP = dp[i]-prices[i];
            }
        }
        return maxP;
    }

    @Test
    public void Test(){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
