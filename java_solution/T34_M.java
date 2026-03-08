import org.junit.Test;

import java.util.Arrays;

public class T34_M {
    /**
     * 我的参考解法：参考标准答案后独立完成
     * 查找数组中第一个和最后一个与目标值相等的元素的位置
     * @param nums 待查找数组
     * @param target 目标值
     * @return 目标位置。若未找到，返回[-1, -1]
     * 时间复杂度：O(log n)
     *      两次二分查找
     * 空间复杂度：O(1)
     *      未使用额外空间
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length-1;
        int firstEqual = -1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                firstEqual = mid;
                right = mid-1;
            }else if (nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        left = 0;
        right = nums.length-1;
        int firstAbove = nums.length;

        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] > target){
                firstAbove = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        if (firstEqual == -1){
            return new int[]{-1, -1};
        }else {
            return new int[]{firstEqual, firstAbove-1};
        }
    }

    @Test
    public void Test(){
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
    }
}
