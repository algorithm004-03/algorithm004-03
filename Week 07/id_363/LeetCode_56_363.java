package com.test.leetcode.week07;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class SolutionMergeIntervals56 {


    @Test
    public void test1() {
        int[][] intervals = {
                {8,10},
                {2,6},
                {15,18},
                {1,3}
        };
        printIntArr(merge(intervals));
    }


    // 获取第一个元素 排序
    // a=[1, 4] b = [2, 3]
    // 区间重叠的条件：a[1] >= b[0] 左边值:a[0] 右边值=Math.max(a[1], b[1])
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // 排序
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparing((a) -> a[0]));
        // 循环
        int len = intervals.length, i = 0;
        while (i < len) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < len - 1 && intervals[i + 1][0] <= right) {
                right = Math.max(right, intervals[i + 1][1]);
                i ++;
            }
            res.add(new int[]{left, right});
            i ++;
        }
        return res.toArray(new int[0][]);
    }


    public void printIntArr(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }


}
