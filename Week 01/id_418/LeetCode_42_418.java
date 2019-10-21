package com.ljg.leetcode.a_009.trapping_rain_water;

/**
 * TrappingRainWater
 * 
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 
 * 输出: 6
 * 
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int[] height = new int[] { 5, 4, 1, 2 };
        int rainWater = getRainWater_03(height);
        System.out.println("rainWater=" + rainWater);
    }

    private static int getRainWater_03(int[] height) {
        int rainWater = 0;

        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int leftMax = height[i];
            int rightMax = height[i];

            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i + 1; j < len; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            rainWater += (Math.min(leftMax, rightMax) - height[i]);
        }
        return rainWater;
    }
}