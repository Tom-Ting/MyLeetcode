import org.junit.Test;

import java.util.*;

public class T994_M_Graph {
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> Rotted = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    Rotted.offer(new Integer[]{i, j});
                }
            }
        }
        int Time = 0;
        while (!Rotted.isEmpty()){
            Queue<Integer[]> RotNext = new ArrayDeque<>();

        }

        return Time;
    }

    @Test
    public void Test(){
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        System.out.println(orangesRotting(new int[][]{{0,2}}));
    }
}
