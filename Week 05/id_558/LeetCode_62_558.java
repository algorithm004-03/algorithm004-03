package Week04;

import java.util.Arrays;

/**
 * @see <a href="62">https://leetcode-cn.com/problems/unique-paths/</a>
 * 不同路径
 */
public class LeetCode_62_558 {
    public static int uniquePaths1(int m, int n) {
        return getTotalPaths1(m, n, 0, 0);
    }

    private static int getTotalPaths1(int m, int n, int row, int col) {
        if (m <= 1 || n <= 1) return Math.min(m, n);
        if (row >= n || col >= m) return 0; //越界
        if (col == m - 2 && row == n - 1) return 1; //最后一行，倒数第一列
        if (col == m - 1 && row == n - 2) return 1;//最后一列，倒数第一行
        return getTotalPaths1(m, n, row, col + 1) + getTotalPaths1(m, n, row + 1, col);
    }

    public static int uniquePaths2(int col, int row) {
        int[][] paths = new int[row][col];
        for (int i = 0; i < row; i++) {
            paths[i][col - 1] = 1;
        }
        for (int i = 0; i < col; i++) {
            paths[row - 1][i] = 1;
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
            }
        }
        return paths[0][0];
    }

    /**
     * 杨辉三角形，每个位置的路径 = 该位置左边的路径 + 该位置上边的路径
     */
    public static int uniquePaths3(int col, int row) {
        int[] cur = new int[row];
        Arrays.fill(cur, 1);
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[row - 1];
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths2(36, 7));
    }
}
