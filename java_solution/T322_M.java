import org.junit.Test;

public class T322_M {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int Min = i+1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] > 0){
                    if (dp[i-coins[j]] == -1){
                        continue;
                    }
                    Min = Math.min(Min, dp[i-coins[j]] + 1);
                }else if(i - coins[j] == 0){
                    dp[i] = 1;
                }
            }
            if (Min > i){
                return -1;
            }

        }
        return dp[amount];
    }

    @Test
    public void Test(){
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }
}
