package com.code.week3;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_200_748_numIslands {

    void my_def(char[][] grid, int i, int j){
        int nr = grid.length;
        int nc = grid[0].length;

        // DFS：终止条件
        if (i<0 || j<0 || i>=nr || j >= nc || grid[i][j] =='0') {
            return;
        }

        grid[i][j] = '0';
        my_def(grid, i-1, j); // 左
        my_def(grid, i+1, j); // 右
        my_def(grid, i, j-1); // 上
        my_def(grid, i, j+1); // 下

    }


    /**
     * 遍历每个元素，如果为1则启动DFS搜素
     * DFS搜索的终止条件：1.不能越界，2.搜索到为0的坐标(0代表海)
     * 搜索的过程中，将经过的位置都置为 0
     * 启动DFS的次数就是岛屿的数量
     * @param grid
     * @return
     */
    public int numIslandsDFS(char[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_island = 0;

        for (int i=0; i< nr; ++i){
            for (int j=0; j< nc; ++j){
                if(grid[i][j] == '1'){
                    ++num_island;
                    my_def(grid,i,j);
                }
            }
        }

        return num_island;
    }




    public int numIsLandsBFS(char[][] grid){
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> linju = new LinkedList<>();
                    linju.add(r * nc + c);
                    while (!linju.isEmpty()) {
                        int id = linju.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            linju.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            linju.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            linju.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            linju.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;

    }




}
