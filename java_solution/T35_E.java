import org.junit.Test;

public class T35_E {
    /**
     * 我的题解
     * @param nums 升序数组
     * @param target 目标
     * @return 目标在升序数组中的位置
     * 时间复杂度：O(log n)。二分查找。
     * 空间复杂度：O(1)
     *
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid = (l+r)/2;;
        while (l <= r){
            mid = (l+r)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        if (nums[mid] >= target){
            return mid;
        }else {
            return mid+1;
        }
    }

    /**
     * 力扣官方题解
     */
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    @Test
    public void Test(){
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert2(new int[]{1,3,5,6}, 7));
    }
}
