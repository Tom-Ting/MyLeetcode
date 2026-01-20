import org.junit.Test;

import java.util.Arrays;

public class T238_M {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] LProduct = new int[N];
        int[] RProduct = new int[N];
        LProduct[0] = nums[0];
        RProduct[N-1] = nums[N-1];
        for (int i = 1; i < N; i++) {
            LProduct[i] = LProduct[i-1]*nums[i];
            RProduct[N-1-i] = RProduct[N-i]*nums[N-1-i];
        }
        int[] ans = new int[N];
        ans[0] = RProduct[1];
        ans[N-1] = LProduct[N-2];
        for (int i = 1; i < N-1; i++) {
            ans[i] = LProduct[i-1]*RProduct[i+1];
        }
        return ans;
    }

    @Test
    public void Test(){
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
