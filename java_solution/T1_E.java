import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class T1_E {
    /**
     * 我的题解：暴力双层嵌套解法
     * @param nums
     * @param target
     * @return
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 官方题解：哈希表解法，优化第二层循环
     * @param nums
     * @param target
     * @return
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> Nums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (Nums.containsKey(target-nums[i])){
                return new int[]{i,Nums.get(target-nums[i])};
            }else {
                if (!Nums.containsKey(nums[i])){
                    Nums.put(nums[i],i);
                }
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void Test(){
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
