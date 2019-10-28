/**
 * @see <a href="42">https://leetcode-cn.com/problems/trapping-rain-water/</a>
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class LeetCode_42_558 {
    /**
     * 暴力法：
     * 思路：Math.min(leftMax,rightMax) - height[currentIndex];
     * 步骤：
     * 1、从下标[1,len-1)遍历整个数组（最左侧和最右侧排除）
     * 2、获取当前元素左侧最大值
     * 3、获取当前元素右侧最大值
     * 4、累计求和：total += Math.min(leftMax, rightMax) - height[i];
     */

    public int trap(int[] height) {
        int len = height.length;
        int total = 0;
        for (int i = 1; i < len - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int k = i; k < len; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }
            total = total + Math.min(leftMax, rightMax) - height[i];
        }
        return total;
    }
}
