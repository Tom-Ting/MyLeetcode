import org.junit.Test;

import java.util.Arrays;

public class T283_E {
    public void moveZeroes(int[] nums) {
        int pointL = 0;
        int pointR = 0;
        while (pointR < nums.length && nums[pointR] != 0 ){
            pointL++;
            pointR++;
        }
        while (pointR < nums.length){
            if (nums[pointR] != 0){
                nums[pointL] = nums[pointR];
                pointL++;
            }
            pointR++;
        }
        while (pointL < nums.length){
            nums[pointL] = 0;
            pointL++;
        }
    }

    @Test
    public void Test(){
        int[] test1 = new int[]{0, 1, 0, 3, 12};
        moveZeroes(test1);
        System.out.println(Arrays.toString(test1));
        int[] test2 = new int[]{0};
        moveZeroes(test2);
        System.out.println(Arrays.toString(test2));
        int[] test3 = new int[]{0, 0, 1};
        moveZeroes(test3);
        System.out.println(Arrays.toString(test3));
        int[] test4 = new int[]{1};
        moveZeroes(test4);
        System.out.println(Arrays.toString(test4));
    }
}
