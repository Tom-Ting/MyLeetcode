import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T215_Heap {
    public int findKthLargest(int[] nums, int k) {
        int KthLargest = quicksort(nums, 0, nums.length-1, k);
        return KthLargest;
    }

    public int quicksort(int[] nums, int left, int right, int k){
        int l = left+1;
        int r = right;
        int pivot = nums[left];
        while (l <= r){
            while (l <= r && nums[r] < pivot) r--;
            while (l <= r && nums[l] > pivot) l++;
            if (l <= r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        if (r == k-1){
            nums[left] = nums[r];
            nums[r] = pivot;
            return nums[r];
        }else if (r > k-1){
            nums[left] = nums[r];
            nums[r] = pivot;
            return quicksort(nums,left, r-1, k);
        }else {
            return quicksort(nums,r+1, right, k);
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
