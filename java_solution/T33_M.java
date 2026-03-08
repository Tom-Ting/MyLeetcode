import org.junit.Test;

import java.util.Arrays;

public class T33_M {
    /**
     * 我的题解：与官方题解思路一致，甚至代码相似度都很高！
     * @param nums 有偏移的严格递增数组
     * @param target 目标值
     * @return 目标值位置。若无则为-1
     * 时间复杂度：O(log n)
     *      仅有一次折半查找
     * 空间复杂度：O(1)
     *      无额外空间
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                if (nums[mid] < nums[left] && target >= nums[left]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if (nums[mid] >= nums[left] && target < nums[left]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    @Test
    public void Test(){
        System.out.println(search(new int[]{5, 7, 7, 8, 9, 10}, 8));
        System.out.println(search(new int[]{5,7,7,8,8,10}, 6));
        System.out.println(search(new int[]{}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{1}, 0));
        System.out.println(search(new int[]{3,1}, 1));
        System.out.println(search(new int[]{1,3}, 3));
    }
}
