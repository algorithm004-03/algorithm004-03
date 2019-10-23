package practice;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/10/22
 */
public class LeetCode_84_368 {
    /*给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    求在该柱状图中，能够勾勒出来的矩形的最大面积。
    https://leetcode-cn.com/problems/largest-rectangle-in-histogram/*/

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea01Better(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        // 暴力法: 分别遍历每个元素，求出该元素对应的最低高度，之后求出每个元素的最大面积。
        // 时间复杂度: O(n²)
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                max = Math.max(max, (j - i + 1) * minHeight);
            }
        }
        return max;
    }

    public static int largestRectangleArea01Better(int[] heights) {
        // 左右可达指针法：遍历每个元素，求出该元素可达的最左距离（高度小于当前元素）和最右距离（高度小于当前元素），
        // 即为以该元素为高度的最大面积。 height[i] * (right - left - 1)
        // 记录每个元素的最左距离
        // 时间复杂度：O(n)
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] left = new int[heights.length];
        left[0] = -1;
        // 优化：在计算当前元素的最左距离时，可以借助之前已经计算好的元素的最左距离进行跳跃
        for (int i = 1; i < heights.length; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }
        // 记录每个元素的最右距离
        int[] right = new int[heights.length];
        right[heights.length-1] = heights.length;
        for (int i = heights.length - 2; i >= 0 ; i++) {
            int j = i + 1;
            while (j < heights.length && heights[j] >= heights[i]) {
                j = right[j];
            }
            right[i] = j;
        }
        // 计算最大面积
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    public static int largestRectangleArea01(int[] heights) {
        // 左右可达指针法：遍历每个元素，求出该元素可达的最左距离（高度小于当前元素）和最右距离（高度小于当前元素），
        // 即为以该元素为高度的最大面积。 height[i] * (right - left - 1)
        // 记录每个元素的最左距离
        // 时间复杂度：O(n²)
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] left = new int[heights.length];
        left[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j--;
            }
            left[i] = j;
        }
        // 记录每个元素的最右距离
        int[] right = new int[heights.length];
        right[heights.length-1] = heights.length;
        for (int i = 0; i < heights.length - 1; i++) {
            int j = i + 1;
            while (j < heights.length && heights[j] >= heights[i]) {
                j++;
            }
            right[i] = j;
        }
        // 计算最大面积
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    public static int largestRectangleArea02(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int height = i == heights.length ? -1 : heights[i];
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, heights[top] * (i - left - 1));
                i--;
            }
        }
        return max;
    }
}
