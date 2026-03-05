import org.junit.Test;

public class T62_M {
    /**
     * 我的题解。非常基础的多维动态规划算法。
     * @param m dp.length
     * @param n dp[0].length
     * @return 不同的路径数
     * 时间复杂度：O(m×n)
     *      遍历矩阵。
     * 空间复杂度：O(m×n)
     *      二维dp数组
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    @Test
    public void run(){
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 3));
    }
}
