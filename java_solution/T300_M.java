import org.junit.Test;

public class T300_M {
    /**
     * 看过参考答案后写出
     * @param nums 源数组
     * @return 递增的子数组的元素个数
     * 时间复杂度：O(n²)
     *      外层i循环：O(n)
     *      内层j循环：O(n)
     * 空间复杂度：O(n)
     *      dp数组：存储n个整数值 → O(n)
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        // 动态规划一般取物理序数。但是本题由于需要在遍历的时候直接操作dp，所以设置为下标。
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int MaxStep = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            MaxStep = Math.max(MaxStep, dp[i]);
        }
        return MaxStep;
    }

    @Test
    public void Test(){
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
