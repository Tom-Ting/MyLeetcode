package org.leetcode;

import org.junit.Test;

public class T73_M {
    public void setZeroes(int[][] matrix) {
        int[][] flags = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                flags[i][j] = 1;
            }

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    for (int k = 0; k < matrix.length; k++) {
                        flags[k][j] = 0;
                    }
                    for (int k = 0; k < matrix[0].length; k++) {
                        flags[i][k] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j]*flags[i][j];
            }
        }
    }

    @Test
    public void Test(){
        setZeroes(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}});
        setZeroes(new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}});
    }
}
/*
    参考答案思路比我好
    只记录应变为0的行列
    修改时直接判断+赋0值，不用搞乘法
 */

