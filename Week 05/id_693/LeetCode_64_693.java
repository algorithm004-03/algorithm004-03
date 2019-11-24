package id_693;

/**
 * @Desc 64. 最小路径和	https://leetcode-cn.com/problems/minimum-path-sum/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/16
 */
public class LeetCode_64_693 {
    // 解题思路和路径问题、不同路径异曲同工
    /*
    1、分解子问题：f(i,j) = Math.min(f(i - 1,j), f(i,j - 1)) + f(i,j)
    2、状态数组： dp[i][j]
    3、dp方程： dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + a[i][j]
     */
    public int minPathSum(int[][] grid) {
        int[][] elements = grid.clone();
        if (elements.length == 0 || elements[0].length == 0) {
            return 0;
        }
        int m = elements.length;
        int n = elements[0].length;
        for (int i = 1; i < n; i++) {
            elements[0][i] += elements[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            elements[i][0] += elements[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                elements[i][j] += Math.min(elements[i - 1][j], elements[i][j - 1]);
            }
        }
        return elements[m - 1][n - 1];
    }

    public static void main(String[] args) {
        new LeetCode_64_693().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }
}
