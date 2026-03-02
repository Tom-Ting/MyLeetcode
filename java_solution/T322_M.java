import org.junit.Test;

public class T322_M {

    int[] minCoinNum;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        minCoinNum = new int[amount+1];
        minCoinNum[0] = 0;
        for (int i = 1; i <= amount; i++) {
            genMinCoinNum(coins, i);
        }
        if (minCoinNum[amount] == 0){
            return -1;
        }
        return minCoinNum[amount];
    }

    public void genMinCoinNum(int[] coins, int amount){
        for (int coin : coins) {
            if (amount == coin){
                minCoinNum[amount] = 1;
            }else if (amount > coin){
                if (minCoinNum[amount-coin] > 0){
                    if (minCoinNum[amount] == 0){
                        minCoinNum[amount] = minCoinNum[amount-coin]+1;
                    }else {
                        minCoinNum[amount] = Math.min(minCoinNum[amount], minCoinNum[amount-coin]+1);
                    }
                }
            }
        }
    }

    @Test
    public void Test(){
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }
}
