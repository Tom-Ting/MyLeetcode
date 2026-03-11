import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class T22_M {
    // 参考思路：使用递归方法

    /**
     * 我的参考题解：参考官方题解。
     * @param n 需生成的括号对数
     * @return 全部合法括号组合
     * 时间复杂度：O(n × 4ⁿ/√n)
     *      递归调用次数：O(4ⁿ/√n)
     *      每个节点的操作：字符串拼接O(m)。m为当前长度，从0到n。
     * 空间复杂度：O(n × 4ⁿ/√n)
     *      递归调用栈：最大递归深度为2n，递归栈空间为O(n)
     *      结果存储变量ans：O(n × 4ⁿ/√n)
     *      字符串构建开销：当前字符串最长2n，空间为O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recrusive(ans, "", 0, 0, n);

        return ans;
    }
    public void recrusive(List<String> ans, String cur, int leftNum, int rightNum, int Max){
        if (leftNum + rightNum == Max*2){
            ans.add(cur);
        }

        if (leftNum < Max){
            recrusive(ans, cur+"(", leftNum+1, rightNum, Max);
        }
        if (rightNum < leftNum){
            recrusive(ans, cur+")", leftNum, rightNum+1, Max);
        }
    }

    @Test
    public void Test(){
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
    }
}
