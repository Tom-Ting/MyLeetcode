import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class T128_M {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for(int num:set){
            if (!set.contains(num-1)) {
                int currLength = 0;
                while (set.contains(num)) {
                    currLength++;
                    num++;
                }
                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }

    @Test
    public void Test(){
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{1,0,1,2}));
    }
}
/*
    可以从上次同数组寻找最小没出现的正整数的思路中借鉴一下
    按照位置标记。
    当时怎么排除掉两端值的？我记得规则就制约了这一点，小于0或者大于N的自动排除掉。
    本题要求时间复杂度为O(n)
    从本题开始，每一题都要计算时间、空间复杂度

    官方解题思路
    1、所有元素装集合，去重且便于查找
    2、以是否为头作为判断，仅对顺序头做操作
    3、若为头，判断其最大长度

    这个思路，一般很难想到
 */
