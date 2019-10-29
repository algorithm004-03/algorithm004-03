/**
 * 思路是计算每个柱子位置上盛雨水的量，然后所有柱子加起来就是总量；
 * 暴力法：从每根柱子出发，向左和向右遍历，分别找到左右两边的最高柱子，两者的较
 * 小者即为雨水能达到的最大高度，再减去柱子本身的高度，即得到，这根柱子位置上
 * 盛雨水的量
 *
 * 时间复杂度O(n^2)，空间复杂度O(1)
 *
 *
 * 先看题解
 *
 *  执行用时 : * 118 ms * , 在所有 java 提交中击败了 * 8.06% * 的用户 *
 *  内存消耗 : * 38 MB * , 在所有 java 提交中击败了 * 80.21% * 的用户
 */
public class Leetcode42SolutionOne {
  public int trap(int[] height) {
    int area = 0;

    for (int i = 1; i < height.length; ++i) {
      int leftMaxHeight = 0;
      int rightMaxHeight = 0;
      for (int j = i; j >= 0; j--) {
        leftMaxHeight = Math.max(height[j], leftMaxHeight);
      }
      for (int j = i; j < height.length; j++) {
        rightMaxHeight = Math.max(height[j], rightMaxHeight);
      }

      area += Math.min(leftMaxHeight, rightMaxHeight) - height[i];
    }

    return area;
  }
}
