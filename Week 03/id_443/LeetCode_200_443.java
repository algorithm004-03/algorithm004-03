//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.modds.alltest.leetcode.editor.cn;

public class LeetCode_200_443_NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new LeetCode_200_443_NumberOfIslands().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid.length == 0) return 0;

            int islands = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int t = grid[i][j];
                    if (t == '1') {
                        islands++;
                        wrap(grid, i, j);
                    }
                }
            }
            return islands;
        }

        private void wrap(char[][] grid, int m, int n) {
            if (m >= grid.length || m < 0) return;
            if (n >= grid[0].length || n < 0) return;
            if (grid[m][n] == '1') {
                grid[m][n] = '0';
                wrap(grid, m - 1, n);
                wrap(grid, m + 1, n);
                wrap(grid, m, n - 1);
                wrap(grid, m, n + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}