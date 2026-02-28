import org.junit.Test;

import java.util.Stack;

public class T55_M {
    public boolean canJump(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()){
            int p = stack.pop();
            canReach[p] = true;
            int maxStep = nums[p];
            for (int i = p+1; i <= p+maxStep && i < nums.length ; i++) {
                if (!canReach[i]){
                    stack.push(i);
                }
            }
        }
        return canReach[nums.length-1];
    }

    @Test
    public void Test(){
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{2,3,1,0,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}
