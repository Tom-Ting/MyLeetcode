import org.junit.Test;

import java.util.*;

public class T347_M_Heap {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int[][] unsorted = new int[map.size()][2];
        int i = 0;
        for (Integer key : map.keySet()) {
            unsorted[i][0] = key;
            unsorted[i][1] = map.get(key);
            i++;
        }
        int[] topK = quickSort(unsorted, 0, unsorted.length-1, k);
        return topK;
    }

    public int[] quickSort(int[][] nums, int left, int right, int k){
        int l = left;
        int r = right-1;
        int pivot = nums[right][1];

        while (l <= r){
            while (l <= r && nums[l][1] > pivot) l++;
            while (l <= r && nums[r][1] < pivot) r--;
            if (l <= r){
                int[] temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        if (l == k-1){
            int[] topK = new int[k];
            for (int i = 0; i < k-1; i++) {
                topK[i] = nums[i][0];
            }
            topK[k-1] = nums[right][0];
            return topK;
        }else if (l > k-1){
            return quickSort(nums, left, l-1, k);
        }else {
            int[] temp = nums[l];
            nums[l] = nums[right];
            nums[right] = temp;
            return quickSort(nums, l+1, right, k);
        }
    }

    @Test
    public void Test(){
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2)));
    }
}
/*
    优先队列，秒了
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else {
                map.put(nums[i], 1);
            }
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (Integer key : map.keySet()) {
            queue.offer(key);
        }
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = queue.poll();
        }
        return topK;
    }
 */
