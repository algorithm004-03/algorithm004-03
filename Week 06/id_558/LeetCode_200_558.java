package Week05;

/**
 * @see <a href="200">https://leetcode-cn.com/problems/number-of-islands/</a>
 * 岛屿数量
 */
public class LeetCode_200_558 {

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private int count;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(i, j, row, col, grid, true);
            }
        }
        return count;
    }

    private void dfs(int i, int j, int row, int col, char[][] grid, boolean first) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') return;
        if (first && grid[i][j] == '1') {
            count++;
        }
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            dfs(i + dx[k], j + dy[k], row, col, grid, false);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00101".toCharArray()
        };
        LeetCode_200_558 test = new LeetCode_200_558();
        System.out.println(test.numIslands(grid));
    }
}
