import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T207_M_Graph {
    List<List<Integer>> edges;
    int[] visited;
    boolean hasCircle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites){
        edges = new ArrayList<List<Integer>>();
        visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] prerequisite : prerequisites) {
            // 当前课程 --> 前置课程
            edges.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0){
                dfs(i);
                if (hasCircle){
                    return false;
                }
            }
        }
        return !hasCircle;
    }

    public void dfs(int v){
        visited[v] = 1;
        for (Integer u : edges.get(v)) {
            if (visited[u] == 1){
                hasCircle = true;
                return;
            }else if (visited[u] == 0){
                dfs(u);
                if (hasCircle){
                    return;
                }
            }
        }
        visited[v] = 2;
    }


    @Test
    public void Test(){
        System.out.println(canFinish(2, new int[][]{{1,0}}));
        System.out.println(canFinish(2, new int[][]{{1,0}, {0,1}}));
    }
}
