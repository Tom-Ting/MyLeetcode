import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class T128_M {
    /**
     * 参考官方题解：在看完官方解答后自主实现。先遍历数组，放入哈希集合中，便于去重和查找。再二次遍历数组，若其前一位值存在，则代表其不是序列起点，跳过。若其前一位值不存在，则向后查找，直到查不到。
     * @param nums 源数组
     * @return 连续的最长序列（不要求元素在源数组中位置连续）
     * 时间复杂度：O(n)
     *      两次遍历数组都是O(n)
     *      哈希集合中查找元素为O(1)
     * 空间复杂度：O(n)
     *      哈希表： O(n)
     */
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

    /**
     * 我的错误思路：先给数组排序，然后遍历寻找连续数组。但因为题目明确要求时间复杂度不超过O(n)，本思路超时，不符合要求。
     * @param nums 源数组
     * @return 连续的最长序列
     * 时间复杂度：O(n log n)
     *      数组排序：O(n log n)
     *      数组遍历：O(n)
     * 空间复杂度：O(1)
     *      不需要额外空间
     */
    public int longestConsecutive2(int[] nums) {
        // 略
        return -1;
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
