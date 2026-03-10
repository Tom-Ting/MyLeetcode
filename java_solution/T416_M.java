import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T416_M {
    /**
     *
     * @param nums 源数组，长度为n，和的一半为target。
     * @return
     * 时间复杂度：O(n * target)
     *      target的长度应该是远远大于n
     * 空间复杂度：O(n * target)
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2){
            return false;
        }
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (sum%2 == 1 || max > sum/2){
            return false;
        }
        int target = sum/2;
        boolean[][]dp = new boolean[n][target+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
            dp[i][nums[i]] = true;
        }
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j <= target ; j++) {
                if (j >= num){
                    dp[i][j] = dp[i-1][j-num] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }
    /**
     * 我的思路：完全错误。留在这里作为警示。
     * @param nums 源数组
     * @return 是否可分割
     */
    public boolean canPartition2(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int num : nums) {
            queue.offer(num);
        }
        int leftNum = 0;
        int rightNum = 0;
        while (!queue.isEmpty()){
            if (leftNum <= rightNum){
                leftNum += queue.poll();
            }else {
                rightNum += queue.poll();
            }
        }
        return rightNum == leftNum;
    }

    @Test
    public void Test(){
        System.out.println(canPartition(new int[]{1,5,11,5}));
        System.out.println(canPartition(new int[]{1,2,3,5}));
        System.out.println(canPartition(new int[]{3,3,3,4,5}));
    }
}
