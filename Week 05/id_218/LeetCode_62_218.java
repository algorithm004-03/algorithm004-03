package leetcode.week5;

/**
 * n 行， m 列
 * https://leetcode-cn.com/problems/unique-paths/
 * @author eason.feng at 2019/11/17/0017 14:35
 **/
public class LeetCode_62_218 {

    public int uniquePaths(int m, int n) {
        if (m == n && m == 1) {
            return 1;
        }
        int[][] result = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if ((i == n - 1) && (j == m - 1)) {
                    result[i][j] = 0;
                    continue;
                }
                if ((i == n - 1) && (j != m - 1)) {
                    result[i][j] = 1;
                    continue;
                }
                if ((j == m - 1) && (i != n - 1)) {
                    result[i][j] = 1;
                    continue;
                }
                result[i][j] = ((i + 1) > n ? 0 : result[i + 1][j]) + ((j + 1) > m ? 0 : result[i][j + 1]);
            }
        }
        return result[0][0];
    }

}
