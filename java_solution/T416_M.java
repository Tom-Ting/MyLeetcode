import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T416_M {
    public boolean canPartition(int[] nums) {
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
