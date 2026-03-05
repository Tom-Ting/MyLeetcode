import org.junit.Test;

public class T64_M {
    /**
     * 我的题解：最笨的解法
     * @param grid 权值数组
     * @return 权值最小的路径的权值
     * 时间复杂度：O(m×n)
     *      grid遍历一次
     * 空间复杂度：O(m×n)
     *      dp数组
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 我的优化解法：可以节省空间。由于dp数组只用一次且单向传播，那没必要维护整个数组。本题中，直接改grid为dp数组。
     * 空间复杂度：O(1)
     * 由于贪心算法无法使用，所以必须遍历完整的grid，所以时间复杂度不会少于O(m×n)。
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    @Test
    public void Test(){
        System.out.println(minPathSum2(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(minPathSum2(new int[][]{{1,2,3},{4,5,6}}));
    }
}
