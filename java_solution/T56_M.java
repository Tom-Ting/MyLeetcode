package org.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56_M {
    public int[][] merge02(int[][] intervals) {
        int N = intervals.length;
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int loc = merging(merged, intervals[i]);
            if (loc >=0){
                merged.add(loc, intervals[i]);
            }
        }
        int[][] ans = merged.toArray(new int[merged.size()][]);
        return ans;
    }

    public int merging(List<int[]> intervals, int[] interval){
        if (intervals.isEmpty()){
            return 0;
        }
        for (int i = 0; i < intervals.size(); i++) {
            if (interval[0] > intervals.get(i)[0]){
                if (i < intervals.size()-1 && interval[0] < intervals.get(i+1)[0] && interval[0] < intervals.get(i)[1]){
                    if (interval[1] >= intervals.get(i)[1]){
                        intervals.get(i)[1] = interval[1];
                    }
                    return -1;
                }
                if (i < intervals.size()-1 && interval[0] < intervals.get(i+1)[0] && interval[0] > intervals.get(i)[1]){
                    return i+1;
                }
                /*
                    i < intervals.size()-1时，interval[0] > intervals.get(i+1)[0]
                    可以直接跳过
                 */
                if (i == intervals.size()-1){
                    if (interval[0] > intervals.get(i)[1]){
                        return i+1;
                    }
                    if (interval[1] > intervals.get(i)[1]){
                        intervals.get(i)[1] = interval[1];
                        return -1;
                    }
                    // 不做操作：interval[1] < intervals.get(i)[1]
                }
            }
            if (interval[0] <= intervals.get(i)[0]){
                if (interval[1] < intervals.get(i)[0]){
                    return 0;
                }
                if (interval[1] <= intervals.get(i)[1]){
                    intervals.get(i)[0] = interval[0];
                }
                if (interval[1] > intervals.get(i)[1]){
                    intervals.get(i)[0] = interval[0];
                    intervals.get(i)[1] = interval[1];
                }
            }
        }
        return -2;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][2];
        }
        if (intervals.length == 1){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (ans.isEmpty()){
                ans.add(intervals[i]);
            }
            int R = intervals[i][1];
            int L = intervals[i][0];
            if (L > ans.get(ans.size()-1)[1]){
                ans.add(intervals[i]);
            }else if (R > ans.get(ans.size()-1)[1]){
                ans.get(ans.size()-1)[1] = intervals[i][1];
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    @Test
    public void Test(){
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15,18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4},
                {4, 5}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {4, 7},
                {1, 4}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4},
                {1, 5}
                })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4},
                {0, 5}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        })));
    }
}
/*
    本题难点：
        1. A B C三个区间，A可以和C区间合并之后反过来和B区间合并
        2. 如何设计合并后的二维数组列表
    设计一个新二位数字，然后把老数组的区间逐个加入新数组

    初次尝试失败了。看了答案才知道，需要数组排序。核心是数组排序。

    本题知识点：
        1. 二维数组和二维List数组的转化问题
        2. 数组排序构造器问题。
 */
