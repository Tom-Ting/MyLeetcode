import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class T75_M {
    /**
     * 我的解法：先统计各种颜色的数量，再原地修改数组并输出
     * @param nums 源数组
     * 时间复杂度：O(n)
     *      共两次完整的遍历源数组。
     * 空间复杂度：O(1)
     *      只使用了长度为3的counts数组
     */
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) {
            switch (num) {
                case 0:
                    counts[0]++;
                    break;
                case 1:
                    counts[1]++;
                    break;
                case 2:
                    counts[2]++;
                    break;
            }
        }
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[n] = i;
                n++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < nums.length && nums[left] == 0){
            left++;
        }
        while (right >= 0 && nums[right] == 2){
            right--;
        }
        int mid = left;
        while (mid <= right){
            switch (nums[mid]){
                case 0:
                    nums[mid] = nums[left];
                    nums[left] = 0;
                    while (left < nums.length && nums[left] == 0){
                        left++;
                    }
                    break;
                case 2:
                    nums[mid] = nums[right];
                    nums[right] = 2;
                    while (right >= 0 && nums[right] == 2){
                        right--;
                    }
                    break;
                case 1:
                    mid++;
                    break;
            }
        }
    }

    @Test
    public void Test(){
        int[] nums1 = new int[]{2,0,2,1,1,0};
        sortColors2(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[]{2,0,1};
        sortColors2(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = new int[]{1,2,0};
        sortColors2(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}
