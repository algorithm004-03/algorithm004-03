package id_693.practise;

/**
 * @Desc 980. 不同路径 III	https://leetcode-cn.com/problems/unique-paths-iii/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/15
 */
public class LeetCode_980_693 {

    int num = 0;

    // dfs+backtrack
    public int uniquePathsIII2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int x = 0;
        int y = 0;
        int k = 1;//空白地板+起始地板
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    k++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        boolean[][] used = new boolean[grid.length][grid[0].length];
        dfs2(grid, used, x, y, k, 0);
        return num;
    }

    private void dfs2(int[][] grid, boolean[][] used, int x, int y, int k, int len) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1 || used[x][y]) {
            return;
        }
        if (grid[x][y] == 2) {
            if (len == k) {
                num++;
            }
            return;
        }
        used[x][y] = true;
        dfs2(grid, used, x + 1, y, k, len + 1);
        dfs2(grid, used, x - 1, y, k, len + 1);
        dfs2(grid, used, x, y + 1, k, len + 1);
        dfs2(grid, used, x, y - 1, k, len + 1);
        used[x][y] = false;
    }

    //针对第一种空间优化,去掉boolean二维数组
    public int uniquePathsIII3(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int k = 1;//空白地板+起始地板
        int x = 0;
        int y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    k++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        dfs3(grid, x, y, k);
        return num;
    }

    private void dfs3(int[][] grid, int x, int y, int k) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return;
        }
        if (grid[x][y] == 2) {
            if (k == 0) {
                num++;
            }
            return;
        }
        grid[x][y] = -1;
        dfs3(grid, x + 1, y, k - 1);
        dfs3(grid, x - 1, y, k - 1);
        dfs3(grid, x, y - 1, k - 1);
        dfs3(grid, x, y + 1, k - 1);
        grid[x][y] = 0;
    }

    //针对第一种空间优化 去掉boolean二维数组，并取消全局变量
    public int uniquePathsIII(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int k = 1;//空白地板+起始地板
        int x = 0;
        int y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) k++;
                else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        return dfs(grid, x, y, k);
    }

    private int dfs(int[][] grid, int x, int y, int k) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return k == 0 ? 1 : 0;
        }
        int result = 0;
        grid[x][y] = -1;
        result += dfs(grid, x + 1, y, k - 1);
        result += dfs(grid, x - 1, y, k - 1);
        result += dfs(grid, x, y - 1, k - 1);
        result += dfs(grid, x, y + 1, k - 1);
        grid[x][y] = 0;
        return result;
    }
}
