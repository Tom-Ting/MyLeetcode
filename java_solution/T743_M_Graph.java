import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class T743_M_Graph {
    Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();
    int[] visited;
    int time = 0;
    public int networkDelayTime(int[][] times, int n, int k) {
        k = k-1;
        visited = new int[n];
        for (int i = 0; i < times.length; i++) {
            if (!edges.containsKey(times[i][0])){
                edges.put(times[i][0], new HashMap<>());
            }
            edges.get(times[i][0]).put(times[i][1], times[i][2]);
        }

        time = dfs(k, time);
        for (int i = 0; i < k; i++) {
            if (visited[i] == 0){
                return -1;
            }
        }
        return time;
    }

    public int dfs(int k, int time){
        if (visited[k] == 1){
            return time;
        }
        visited[k] = 1;
        int kTime = 0;
        for (Integer v : edges.get(k).keySet()) {
            kTime = Math.max(kTime, dfs(v, time+edges.get(k).get(v)));
        }
        return kTime+time;
    }

    @Test
    public void Test(){
        System.out.println(networkDelayTime(new int[][]{
                {2,1,1},{2,3,1},{3,4,1}
        }, 4, 2));

        System.out.println(networkDelayTime(new int[][]{
                {1,2,1}}, 2, 1));

        System.out.println(networkDelayTime(new int[][]{
                {1,2,1}}, 2, 2));
    }
}
