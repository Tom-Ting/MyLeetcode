import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class T547_M_Graph {
    // 深度优先遍历 ===============================================
    /*
    int[] visited;
    int provinceNum = 0;

    public int findCircleNum(int[][] isConnected) {
        visited = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0){
                provinceNum++;
                dfs(i, isConnected);
            }
        }
        return provinceNum;
    }
    public void dfs(int i, int[][] isConnected){
        if (i < 0 || i >= visited.length){
            return;
        }
        if (visited[i] == 1){
            return;
        }
        visited[i] = 1;
        for (int j = 0; j < visited.length; j++) {
            if (isConnected[i][j] == 1){
                dfs(j, isConnected);
            }
        }
    }

     */

    // 广度优先遍历 ===============================================
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        Queue<Integer> queue = new ArrayDeque<>();
        int provinceNum = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0){
                provinceNum++;
                queue.add(i);

                while(!queue.isEmpty()){
                    int visiting = queue.remove();
                    if (visited[visiting] == 1){
                        continue;
                    }
                    visited[visiting] = 1;
                    for (int j = i; j < isConnected.length; j++) {
                        if (isConnected[visiting][j] == 1){
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return provinceNum;
    }

    @Test
    public void Test(){
        System.out.println(findCircleNum(new int[][]{
                {1,1,0},{1,1,0},{0,0,1}
        }));

        System.out.println(findCircleNum(new int[][]{
                {1,0,0},{0,1,0},{0,0,1}
        }));
    }
}
/*
    原思路：构建一个 List<Set<Interger>> provinces。将一个已在已知省的城市放到新增加的省中。
            但是这个思路有一个问题，1和7相邻、1和2不相邻，但是7和2相邻。这种情况在上述方法中就会失效。
    新思路：dfs。其实他这题目给的邻接表是冗余50%的。

    错误思路：遍历邻接表isConnected，其实应该遍历省分表。

    优化思路：visited可用布尔数组
 */
