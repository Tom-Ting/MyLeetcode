import org.junit.Test;

public class T152_M {
    /**
     *
     * @param nums 源数组
     * @return 返回最大的子数组元素的乘积
     * 时间复杂度：O(n)，只有一个for循环
     * 空间复杂度：O(n)，只有两个dp数组
     */
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] MaxUtilNow = new int[nums.length];
        int[] MinUtilNow = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            MaxUtilNow[i] = nums[i];
            MinUtilNow[i] = nums[i];
        }
        int Max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            MaxUtilNow[i] = Math.max(MaxUtilNow[i], MaxUtilNow[i-1]*nums[i]);
            MaxUtilNow[i] = Math.max(MaxUtilNow[i], MinUtilNow[i-1]*nums[i]);
            MinUtilNow[i] = Math.min(MinUtilNow[i], MinUtilNow[i-1]*nums[i]);
            MinUtilNow[i] = Math.min(MinUtilNow[i], MaxUtilNow[i-1]*nums[i]);

            Max = Math.max(Max, MaxUtilNow[i]);
        }
        return Max;
    }

    @Test
    public void Test(){
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
    }
}
