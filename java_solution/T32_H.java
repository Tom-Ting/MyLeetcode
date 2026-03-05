import org.junit.Test;

import java.util.Stack;

public class T32_H {
    /**
     * 我的题解：从0开始的完全的我自己的解法
     * @param s 源字符串
     * @return 字符串中最长有效括号的长度
     * 时间复杂度：O(n)。
     *      仅遍历一次字符串。
     * 空间复杂度：O(n)。
     *      dp数组：长度为n
     *      stack栈：通常不会塞满，最坏情况添加n/2个元素。
     */
    public int longestValidParentheses(String s) {
        if (s.isEmpty()){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[s.length()];
        if(s.charAt(0) == '('){
            stack.add(0);
        }
        dp[0] = 0;
        int Max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                if (dp[i-1] <= 0){
                    stack.push(0);
                    dp[i] = 0;
                }else {
                    stack.push(-dp[i-1]);
                    dp[i] = -dp[i-1];
                }
            }else {
                if (stack.isEmpty()){
                    dp[i] = 0;
                }else {
                    dp[i] = 2 - stack.pop();
                    if (s.charAt(i-1) == ')'){
                        dp[i] += dp[i-1];
                    }
                }
                Max = Math.max(Max, dp[i]);
            }
        }
        return Max;
    }

    @Test
    public void Test(){
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("()(())"));
    }
}
