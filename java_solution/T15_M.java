import org.junit.Test;

import java.util.*;

public class T15_M {
    /**
     * 我的参考题解：第二指针和第三指针从两边缩圈，优化掉一层循环。代码过于丑陋，布丁太多。
     * @param nums 源数组
     * @return 和为目标值的去重结果集合
     * 时间复杂度O(n^2)
     *      二重循环
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int Length = nums.length;
        if (Length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int lastI = nums[0]-1;
        for (int i = 0; i < Length-2; i++) {
            if (nums[i] == lastI){
                continue;
            }
            lastI = nums[i];
            int lastJ = nums[i+1];
            int lastK = nums[Length-1];
            int j = i+1;
            int k = Length-1;
            while (j < k){
                if (lastI+lastJ+lastK == 0){
                    List<Integer> an = new ArrayList<>();
                    an.add(lastI);
                    an.add(lastJ);
                    an.add(lastK);
                    ans.add(an);
                    j++;
                    while (j < Length && nums[j] == lastJ){
                        j++;
                    }
                    if (j == Length){
                        continue;
                    }
                    lastJ = nums[j];
                }else if (lastI+lastJ+lastK > 0){
                    k--;
                    while (k >= 0 && nums[k] == lastK){
                        k--;
                    }
                    if (k < 0){
                        continue;
                    }
                    lastK = nums[k];
                }else {
                    j++;
                    while (j < Length && nums[j] == lastJ){
                        j++;
                    }
                    if (j == Length){
                        continue;
                    }
                    lastJ = nums[j];
                }
            }
        }
        return ans;
    }
    /**
     * 我的题解：常规的三重循环。通过重复元素跳过来避免重复结果
     * @param nums 源数组
     * @return 和为目标值的去重结果集合
     * 时间复杂度O(n^3)
     *      三个数对应三重循环
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        int Length = nums.length;
        if (Length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int lastI = nums[0]-1;
        int lastJ;
        int lastK;
        for (int i = 0; i < Length-2; i++) {
            if (nums[i] == lastI){
                continue;
            }
            lastI = nums[i];
            lastJ = nums[i+1]-1;
            for (int j = i+1; j < Length-1; j++) {
                if (nums[j] == lastJ){
                    continue;
                }
                lastJ = nums[j];
                lastK = nums[j+1]-1;
                for (int k = j+1; k < Length; k++) {
                    if (nums[k] == lastK){
                        continue;
                    }
                    lastK = nums[k];
                    if (lastI + lastJ + lastK == 0){
                        List<Integer> an = new ArrayList<>();
                        an.add(lastI);
                        an.add(lastJ);
                        an.add(lastK);
                        ans.add(an);
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void Test(){
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{0,0,0}));
        System.out.println(threeSum(new int[]{1,-1,-1,0}));
    }
}
