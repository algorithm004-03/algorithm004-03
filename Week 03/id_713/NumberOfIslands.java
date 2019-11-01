package id_713;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 */
public class NumberOfIslands {


    // 使用 dfs
    public int numIslandsDfs(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length; // 行数
        int nc = grid[0].length; // 列数
        int num_islands = 0; // 总计岛屿数

        // 先行后列扫描
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') { // 发现有岛屿, 将自己和周边都赋值0
                    ++num_islands; // 增加毗连的岛屿数量
                    dfs(grid, r, c); // 递归赋值0
                }
            }
        }

        return num_islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length; // 行数
        int nc = grid[0].length; // 列数

        // 行数<0, 列数<0, 行数>最大行数, 列数>最大列数, 当前值==0
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0'; // 填平(染色)

        dfs(grid, r - 1, c); // 左
        dfs(grid, r + 1, c); // 右
        dfs(grid, r, c - 1); // 上
        dfs(grid, r, c + 1); // 下
    }



    // 使用bfs
    public int numIslandsBfs(char[][] grid) {
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

                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }


}
