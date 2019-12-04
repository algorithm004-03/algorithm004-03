//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

package com.modds.alltest.leetcode.editor.cn;

public class LeetCode_64_443_MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new LeetCode_64_443_MinimumPathSum().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 状态变量：一维数组  a[n]
         * 重复子结构： a[j] = Min(a[j],a[j+1])+grid[x][j]
         *
         * @param grid
         * @return
         */
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;

            int[] dp = new int[n];
            dp[n - 1] = grid[m - 1][n - 1];

            for (int i = n - 2; i >= 0; i--) {
                dp[i] = dp[i + 1] + grid[m - 1][i];
            }

            for (int i = m - 2; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (j == n - 1) {
                        dp[j] = dp[j] + grid[i][j];
                    } else {
                        dp[j] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
                    }
                }
            }
            return dp[0];
        }

        /**
         * 状态变量：二维数组
         * 重复子结构： sub[i][j] = Min(sub[i+1][j],sub[i][j+1])+a[i][j]
         *
         * @param grid
         * @return
         */
        public int minPathSum1(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            int[][] a = new int[m][n];
            a[m - 1][n - 1] = grid[m - 1][n - 1];

            // 最后一行
            for (int i = grid[0].length - 2; i >= 0; i--) {
                a[m - 1][i] = a[m - 1][i + 1] + grid[m - 1][i];
            }

            // 最后一列
            for (int i = grid.length - 2; i >= 0; i--) {
                a[i][n - 1] = a[i + 1][n - 1] + grid[i][n - 1];
            }

            for (int i = grid.length - 2; i >= 0; i--) {
                for (int j = grid[0].length - 2; j >= 0; j--) {
                    a[i][j] = Math.min(a[i + 1][j], a[i][j + 1]) + grid[i][j];
                }
            }
            return a[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}