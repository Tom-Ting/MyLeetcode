import org.junit.Test;

import java.util.*;

public class T239_H {
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] knums = new int[k];
        for (int i = 0; i < k; i++) {
            q.add(nums[i]);
            knums[i] = nums[i];
        }
        Arrays.sort(knums);
        int[] kmax = new int[nums.length-k+1];
        kmax[0] = knums[knums.length-1];
        for (int i = 1; i < kmax.length; i++) {
            int num = q.poll();
            q.add(nums[k+i-1]);
            for (int j = 0; j < knums.length; j++) {
                if (knums[j] == num){
                    knums[j] = nums[k+i-1];
                    break;
                }
            }
            Arrays.sort(knums);
            kmax[i] = knums[knums.length-1];
        }
        return kmax;
    }

    public int[] maxSlidingWindow(int[] nums, int k){
        int N = nums.length;
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            q.offer(new int[]{nums[i], i});
        }
        int[] kmax = new int[N-k+1];
        kmax[0] = q.peek()[0];

        for (int i = 1; i < N - k + 1; i++) {
            q.add(new int[]{nums[i+k-1],i+k-1});
            while (q.peek()[1] < i){
                q.poll();
            }
            kmax[i] = q.peek()[0];
        }
        return kmax;
    }

    @Test
    public void Test(){
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{7,2,4}, 2)));
    }
}
/*
    首先，窗口在滑动期间，要始终能够判断出最大值
    滑口滑动，新进来的数要能够排序，出去的数要知道出去哪一个
    要用一个队列，这样才知道要弹走哪一个
    要用一个k位数的数组，这样才知道排位
    有没有必要，对全部数组排序，还是只需要找到最大值。

    queue q [1,3,-1,-3]
    int[] nums = [2, 1, 3, 4]
    插入排序呢？
    int[] nums = [-1, -3, 1, 3]
 */
