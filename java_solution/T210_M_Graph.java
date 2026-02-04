import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T210_M_Graph {
    List<List<Integer>> edges;
    int[] visited;
    boolean hasCircle = false;
    int[] learning;
    int nowlearn = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites){
        edges = new ArrayList<List<Integer>>();
        visited = new int[numCourses];
        learning = new int[numCourses];

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
                    return new int[0];
                }
            }
        }
        return learning;
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
        learning[nowlearn] = v;
        nowlearn++;
    }


    @Test
    public void Test(){
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}, {0, 1}})));
    }
}
