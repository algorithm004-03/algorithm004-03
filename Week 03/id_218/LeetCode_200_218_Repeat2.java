package leetcode.week3;

/**
 * @author eason.feng at 2019/10/31/0031 16:01
 **/
public class LeetCode_200_218_Repeat2 {

    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    char[][] g;

    public int numIslands(char[][] grid) {
        g = grid;
        int lands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0 ; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                lands += sink(i, j);
            }
        }
        return lands;
    }

    private int sink(int i, int j) {
        if (g[i][j] == 0) {
            return 0;
        }
        g[i][j] = 0;
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x > 0 && x < g.length && y < g[i].length) {
                if (g[x][y] == 0) {
                    continue;
                }
                sink(x, y);
            }
        }

        return 1;
    }
}
