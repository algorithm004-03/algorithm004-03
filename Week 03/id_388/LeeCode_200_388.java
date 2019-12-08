package com.company.leetcode.editor.cn;
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


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            char[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                String tmp = i + "#" + j;
                if (visited.contains(tmp)) {
                    continue;
                }

                if (grid[i][j] == '1') {
                    res++;
                    sink(grid,i,j,visited);
                }
            }
        }

        return res;
    }

    private void sink(char[][] grid, int i, int j, Set<String> visited) {

        if (i < 0 || i >= grid.length) {
            return;
        }

        if (j < 0 || j >= grid[i].length) {
            return;
        }

        if (visited.contains(i + "#" + j)) {
            return;
        }
        visited.add(i + "#" + j);
        if (grid[i][j] == '0') {
            return;
        }

        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }

        //上下左右移动
        int[] x = new int[]{0,0,-1,1};
        int[] y = new int[]{-1,1,0,0};

        for (int k = 0; k < x.length; k++) {
            sink(grid,i + x[k],j + y[k],visited);
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//
//        char[] row0 = new char[]{'1','1','1','1','0'};
//        char[] row1 = new char[]{'1','1','0','1','0'};
//        char[] row2 = new char[]{'1','1','0','0','0'};
//        char[] row3 = new char[]{'0','0','0','0','0'};
//
//        char[][] grid = new char[][]{row0,row1,row2,row3};
//        int res = s.numIslands(grid);
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
