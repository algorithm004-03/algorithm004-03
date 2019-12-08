/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (49.21%)
 * Likes:    1770
 * Dislikes: 45
 * Total Accepted:    277.9K
 * Total Submissions: 562.1K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */

// @lc code=start

// 方法 ：一维动态规划
// 在上个解法中，我们可以用一个一维数组来代替二维数组，dp 数组的大小和行大小相同。
//这是因为对于某个固定状态，只需要考虑下方和右侧的节点。
//首先初始化 dpdp 数组最后一个元素是右下角的元素值，然后我们向左移更新每个 dp(j)dp(j) 为：

// dp(j)=grid(i,j)+min(dp(j),dp(j+1))

// 我们对于每一行都重复这个过程，然后向上一行移动，计算完成后 dp(0) 就是最后的结果。


class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }
}
// @lc code=end

