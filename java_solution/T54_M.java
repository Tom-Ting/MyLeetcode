import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T54_M {
    /*
        {0, 1} {1, 0} {0, -1} {-1, 0}
        x = -x + y
        y = -x
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int Num = matrix.length*matrix[0].length;
        int x = 0;
        int y = 0;
        int[][] direction = new int[][]{{0, 1}, {1, 0},{0, -1},{-1, 0}};
        int d = 0;
        List<Integer> spiralOrderMatrix = new ArrayList<>();
        for (int i = 0; i < Num; i++) {
            spiralOrderMatrix.add(matrix[x][y]);
            flag[x][y] = true;
            x += direction[d][0];
            y += direction[d][1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || flag[x][y]){
                x -= direction[d][0];
                y -= direction[d][1];
                d = (d + 1)%4;
                x += direction[d][0];
                y += direction[d][1];
            }
        }
        return spiralOrderMatrix;
    }

    @Test
    public void Test(){
        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
