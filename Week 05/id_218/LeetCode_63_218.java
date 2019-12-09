package leetcode.week5;

/**
 * @author eason.feng at 2019/11/17/0017 15:01
 **/
public class LeetCode_63_218 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }
        if ((m == n && m == 1)) {
            return 1;
        }
        int[][] result = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                    continue;
                }
                if ((i == n - 1) && (j == m - 1)) {
                    result[i][j] = 0;
                    continue;
                }
                if ((i == n - 1) && (j != m - 1)) {
                    if (j + 1 == m - 1) {
                        result[i][j] = 1;
                    }
                    else {
                        result[i][j] = result[i][j + 1];
                    }
                    continue;
                }
                if ((j == m - 1) && (i != n - 1)) {
                    if (i + 1 == n - 1) {
                        result[i][j] = 1;
                    }
                    else {
                        result[i][j] = result[i + 1][j];
                    }
                    continue;
                }
                result[i][j] = ((i + 1) > n ? 0 : result[i + 1][j]) + ((j + 1) > m ? 0 : result[i][j + 1]);
            }
        }
        return result[0][0];
    }

}
