import org.junit.Test;

public class T72_M {
    /**
     * 我的参考题解
     * @param word1 长度为m
     * @param word2 长度为n
     * @return 编辑距离
     * 时间复杂度：O(m × n)
     *      遍历dp数组
     * 空间复杂度：O(m × n)
     *      dp数组
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m*n == 0){
            return m+n;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i][j-1] + 1;
                int up = dp[i-1][j] + 1;
                int left_up;
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    left_up = dp[i-1][j-1];
                }else {
                    left_up = dp[i-1][j-1]+1;
                }
                int min = Math.min(left, up);
                min = Math.min(min,left_up);
                dp[i][j] = min;
            }
        }
        return dp[m][n];
    }


    /**
     * 我的解法：基于字符串的递归。输出结果正确，但是超时
     * @param word1 长度为n
     * @param word2 长度为m
     * @return 编辑距离
     * 时间复杂度上界：O(3^(min(m,n)))
     *      这是一个无记忆化的递归，由于没有记忆化，相同的子问题会被重复计算多次。递归树是一个三叉树，深度最大为 m+n。
     * 空间复杂度：O((m+n)²)
     *      递归栈空间：O(m+n)
     *      每次递归创建 3 个子字符串，每个子字符串长度约 O(m) 或 O(n)。最坏情况下，递归深度 d 时，创建的子字符串总长度可达 O((m+n)²)
     */
    public int minDistance2(String word1, String word2) {
        if (word1.equals(word2)){
            return 0;
        }
        int i = 0;
        while (i < word1.length() && i < word2.length() && word1.charAt(i)==word2.charAt(i)){
            i++;
        }
        if (i >= word1.length()){
            return word2.length()-word1.length();
        }else if (i >= word2.length()){
            return word1.length()-word2.length();
        }else {
            String s1 = word1.substring(i);
            int n1 = minDistance2(s1, word2.substring(i+1));

            String s2 = word1.substring(i+1);
            int n2 = minDistance2(s2, word2.substring(i));

            String s3 = word1.substring(i+1);
            int n3 = minDistance2(s3, word2.substring(i+1));

            int n0 = word1.length()+word2.length();
            n0 = Math.min(n0, n1+1);
            n0 = Math.min(n0, n2+1);
            n0 = Math.min(n0, n3+1);
            return n0;
        }
    }

    @Test
    public void Test(){
//        String s = "0123456789";
//        System.out.println(s.substring(1,4));
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("sea", "ate"));
    }
}
