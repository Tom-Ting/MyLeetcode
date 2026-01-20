import org.junit.Test;

import java.util.Arrays;

public class T189_M {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2){
            return;
        }
        k = k % nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length-k+i];
        }
        for (int i = nums.length-k-1; i >= 0; i--) {
            nums[i+k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    @Test
    public void Test(){
        int[] nums1 = new int[]{1,2,3,4,5,6,7};
        rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[]{-1,-100,3,99};
        rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));
    }
}
