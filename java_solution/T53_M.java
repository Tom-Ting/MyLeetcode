import org.junit.Test;

public class T53_M {
    /**
     *
     * @param nums 源数组
     * @return 和最大的子数组的和
     * 时间复杂度：O(n)。一次for循环。
     * 空间复杂度：O(n)。一个dp数组。
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int Max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
            Max = Math.max(Max, dp[i]);
        }
        return Max;
    }

    /**
     * 基本原理同上。由于dp数组只遍历一次，且dp[i]仅和dp[i-1]有关，故可以删去数组，仅用变量。空间复杂度由O(n)降至O(1)。
     */
    public int maxSubArray2(int[] nums) {
        int dp = nums[0];
        int Max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(nums[i], dp+nums[i]);
            Max = Math.max(Max, dp);
        }
        return Max;
    }

    @Test
    public void Test(){
        System.out.println(maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray2(new int[]{1}));
        System.out.println(maxSubArray2(new int[]{5,4,-1,7,8}));
    }
}
