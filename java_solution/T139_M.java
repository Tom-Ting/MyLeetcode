import org.junit.Test;

import java.util.*;

public class T139_M {
    // ============ 解法1：我的动态规划 ============
    /**
     * 时间复杂度：O(m*n^2)，n为s长度，m为wordDict中单词个数。
     *      递归树的深度在最坏情况下可达 n（每次匹配1个字符）。每层递归遍历 m 个字典单词，每个单词进行 O(n) 的 substring和 equals操作。
     * 空间复杂度：O(n + m)，n为s长度，m为wordDict中单词个数。
     *      记忆化集合：最坏存储 n 个不同的剩余子串，O(n)
     *      递归栈：最坏深度 n，每个调用存储字符串引用，O(n)
     *      栈数据结构：存储待处理子串，最坏 O(n)
     *      字典集合：存储 m 个单词，O(m)
     */
    /*
    Set<String> set = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.equals("")){
            return true;
        }
        if (wordDict.isEmpty()){
            return false;
        }
        Stack<String> stack = new Stack();
        for (String word : wordDict) {
            if (s.length() < word.length()){
                continue;
            }
            if (word.equals(s.substring(0, word.length()))){
                if (!set.contains(s.substring(word.length()))){
                    set.add(s.substring(word.length()));
                    stack.push(s.substring(word.length()));
                }
            }
        }
        while (!stack.isEmpty()){
            String S = stack.pop();
            if (wordBreak(S, wordDict)){
                return true;
            }
        }
        return false;
    }


     */

    /**
     * 解法2: 参考答案动态规划
     * @param s, 长度为n。
     * @param wordDict, 元素数量为m。
     * @return 是否能成功分割。
     *
     * 时间复杂度：O(n³)
     *      外层循环：i从 1 到 n → O(n)
     *      内层循环：j从 0 到 i-1 → 平均 O(n/2) ≈ O(n)
     *      关键操作：s.substring(j, i)创建子串 → O(i-j) 平均 O(n/2) ≈ O(n)
     *      wordDict.contains(str)是 O(m) 其中 m 是子串长度
     * 空间复杂度：O(n)
     *      dp数组：长度 n+1 → O(n)
     *      临时子串：每次创建新字符串，但会被垃圾回收，不计入额外空间
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 这里的i和j是下标吗？
                // j是下标，从0～i；i是物理序号，需要-1才能成为下标。
                // 但是substring是左闭右开。这个不用记住，写代码的时候可以测试。
                String str = s.substring(j, i);
                if (dp[j] && wordDict.contains(str)){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    @Test
    public void Test(){
        System.out.println(wordBreak("leetcode", new ArrayList<String>() {{
            add("leet");
            add("code");
        }}));

        System.out.println(wordBreak("applepenapple", new ArrayList<String>() {{
            add("apple");
            add("pen");
        }}));

        System.out.println(wordBreak("catsandog", new ArrayList<String>() {{
            add("cats");
            add("dog");
            add("sand");
            add("and");
            add("cat");
        }}));
    }
}