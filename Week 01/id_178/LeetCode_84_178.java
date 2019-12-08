package org.geektime.weak01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LeetCode_84_178 {
    public static void main(String[] args) {

    }

    public int largestRectangleArea1(int[] heights) {
        int largestRectangleArea =  0;
        for (int i = 0 ;i < heights.length;i++){
            int minHeight  = Integer.MAX_VALUE;
            for(int j = i;j < heights.length;j++){
                minHeight = Math.min(minHeight,heights[j]);
                largestRectangleArea = Math.max(largestRectangleArea,minHeight*(j - i + 1));
            }
        }
        return largestRectangleArea;
    }

    public int largestRectangleArea2(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    private int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));

    }


}
