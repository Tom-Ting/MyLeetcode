import org.junit.Test;

public class T287_M {
    /**
     * 我的解法：下标法。使用下标来标记已访问过的数组。由于要求不改变原数组，那么最后再将数组全部还原即可。
     * @param nums 源数组
     * @return 找到的重复的数
     * 时间复杂度：O(n)
     *      第一次循环：目的是找重复数，可以提前结束。
     *      第二次循环：目的是还原数组，全遍历。
     * 空间复杂度：O(1)
     */
    public int findDuplicate(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0){
                nums[Math.abs(nums[i])] = -1 * nums[Math.abs(nums[i])];
                ans = Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i])] = -1 * nums[Math.abs(nums[i])];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                nums[i] = -1 * nums[i];
            }
        }
        return ans;
    }

    @Test
    public void Test(){
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicate(new int[]{3,3,3,3,3}));
    }
}
