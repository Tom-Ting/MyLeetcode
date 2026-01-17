package org.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 二维数组 {
    // ********* 二维整形数组 *********
    // 1 声明
    int[][] matrix1;
    int matrix2[][];    // 不推荐
    int[] matrix3[];    // 不推荐

    // 2 初始化
    int[][] matrix4 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
    public void Example(){
        int[][] matrix5 = new int[3][3];
        // 变量赋值不能放在类中，只能放在方法中
        matrix5[0][0] = 1;
        matrix5[0][1] = 2;
    }

    // 实例初始化块
    int[][] matrix6 = new int[3][3];
    {
        matrix6[0][0] = 1;
        matrix6[0][1] = 2;
        matrix6[0][2] = 3;
    }

    // ********* 二维整形ArrayList *********
    // 1 声明
    List<List<Integer>> matrix20 = new ArrayList<>();

    List<List<Integer>> matrix21 = new ArrayList<>(10);  // 预计有10行

    List<List<String>> table = new ArrayList<>();


}
