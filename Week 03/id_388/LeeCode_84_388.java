package com.company.leetcode.editor.cn;//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
// 示例:
//
// 输入: [2,1,5,6,2,3]
//输出: 10
// Related Topics 栈 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_84 {

    //分治
    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0];
        }

        return helper(heights,0,heights.length - 1);
    }

    private int helper(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }

        //查找最小
        int minIndex = start;
        for (int i = start; i <= end; i++) {

            if (heights[minIndex] > heights[i]) {
                minIndex = i;
            }

        }
        int area = heights[minIndex] * (end - start + 1);
        int leftArea = helper(heights,start,minIndex - 1);
        int right = helper(heights,minIndex + 1,end);

        return Math.max(area,Math.max(leftArea,right));
    }

    //暴力
    public int largestRectangleArea2(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {


            int minHeight = heights[i];

            for (int j = i; j < heights.length; j++) {
                int nextHeight = heights[j];
                if (nextHeight < minHeight) {
                    minHeight = nextHeight;
                }
                int distance = j - i + 1;
                int area = distance * minHeight;

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int res = s.largestRectangleArea(new int[]{9,0});
//        System.out.println(res);
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
