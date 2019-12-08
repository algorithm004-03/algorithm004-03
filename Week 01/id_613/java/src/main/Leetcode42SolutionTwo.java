/**
 * 暴力法加速，思路是减少暴力法中找leftMax和rightMax中不必要的重复遍历，把中间结果记录下来
 * 用两次遍历得到每个柱子的leftMaxHeight和rightMaxHeight
 * 然后用一次遍历得到结果
 *
 * 先看题解
 *
 * 执行用时 : * 1 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 : * 37.5 MB * , 在所有 java 提交中击败了 * 83.52% * 的用户
 */
public class Leetcode42SolutionTwo {
  public int trap(int[] height) {
    int area = 0;

    if (height.length == 0) {
      return area;
    }

    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];

    // 填充leftMax
    leftMax[0] = height[0];
    for (int i = 1; i < leftMax.length; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    }

    // 填充rightMax
    rightMax[rightMax.length - 1] = height[height.length - 1];
    for (int i = rightMax.length - 2; i >= 0; i--) {
      rightMax[i] = Math.max(height[i], rightMax[i + 1]);
    }

    for (int i = 1; i < height.length - 1; i++) {
      area += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return area;
  }
}
