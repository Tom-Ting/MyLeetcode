import org.junit.Test;

import java.util.Stack;

public class T45_M {
    public int jump(int[] nums) {
        int position = nums.length-1;
        int step = 0;
        while (position > 0){
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position){
                    position = i;
                    step++;
                }
            }
        }
        return step;
    }

    @Test
    public void Test(){
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }
}
/*
    超出时间限制：不需要用栈。用栈只是判断是否能reach
    如果保证能reach，那就直接一遍遍历数组
 */

/*
    public int jump(int[] nums) {
    int[] steps = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        steps[i] = Integer.MAX_VALUE;
    }
    steps[0] = 0;
    for (int i = 0; i < nums.length; i++) {
        int step = nums[i];
        for (int j = i+1; j <= i+step && j < nums.length; j++) {
            steps[j] = Math.min(steps[j], steps[i]+1);
        }
    }
    return steps[nums.length-1];
    }

 */