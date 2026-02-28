import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T215_Heap {
    public int findKthLargest(int[] nums, int k) {
        int KthLargest = quicksort(nums, 0, nums.length-1, k);
        return KthLargest;
    }

    public int quicksort(int[] nums, int l, int r, int k){
        // k位于l和r之间，切l==r，说明k找到了
        if (l == r){
            return l;
        }
        int lPoint = l+1;
        int rPoint = r;
        while (lPoint < rPoint){
            while (nums[lPoint] < nums[l]){
                lPoint++;
            }
            while (nums[rPoint] >= nums[l]){
                rPoint--;
            }
            if (lPoint < rPoint){
                int temp = nums[lPoint];
                nums[lPoint] = nums[rPoint];
                nums[rPoint] = temp;
            }
        }

        if (lPoint <= k-1){
            return quicksort(nums, lPoint+1, r, k);
        }else {
            return quicksort(nums, l, lPoint-1, k);
        }
    }

    @Test
    public void Test(){
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
/*
    == 方法一：堆（优先队列），秒了
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < k-1; i++) {
            queue.poll();
        }
        return queue.poll();
    }

 */
