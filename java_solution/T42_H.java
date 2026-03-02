import org.junit.Test;

public class T42_H {
    public int trap(int[] height) {
        int L = height.length;
        int[] leftMax = new int[L];
        int[] rightMax = new int[L];
        leftMax[0] = height[0];
        rightMax[L-1] = height[L-1];
        for (int i = 1; i < L; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
            rightMax[L-1-i] = Math.max(rightMax[L-i], height[L-1-i]);
        }
        int water = 0;
        for (int i = 1; i < L-1; i++) {
            if (height[i] < Math.min(leftMax[i-1], rightMax[i+1])){
                water += Math.min(leftMax[i-1], rightMax[i+1]) - height[i];
            }
        }
        return water;
    }

    @Test
    public void Test(){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }
}
