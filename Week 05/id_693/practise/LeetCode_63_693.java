package id_693.practise;

import org.junit.Assert;

/**
 * @Desc 63. 不同路径 II	https://leetcode-cn.com/problems/unique-paths-ii/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/11
 */
public class LeetCode_63_693 {
    //dp暴力破解，沿用之前暴力破解思路。直接自低向上思路出发，遇到障碍物直接修改为0，（实际场合不赞同用这样玩）
    //后面看官方题解也是这个思路，还用了3个for。。就不做优化了，后面复刷看国际站吧
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        obstacleGrid[row - 1][column - 1] = 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    int a = i + 1 < row ? obstacleGrid[i + 1][j] : 0;
                    int b = j + 1 < column ? obstacleGrid[i][j + 1] : 0;
                    obstacleGrid[i][j] = a + b;
                } else {
                    if (i == row - 1 && j == column - 1) continue;
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[0][0];
    }

    //dp暴力破解 顺序上升（看了几遍中文官方的，实在写不下去那样的代码。还是自己的看着舒服
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (obstacleGrid[i][j] == 0) {
                    int a = i - 1 >= 0 ? obstacleGrid[i - 1][j] : 0;
                    int b = j - 1 >= 0 ? obstacleGrid[i][j - 1] : 0;
                    obstacleGrid[i][j] = a + b;
                } else {
                    if (i == 0 && j == 0) continue;
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[row - 1][column - 1];
    }

    //饿，这个优化。有点复杂哈。还是上面看着好些哈，
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] != 1) {
                obstacleGrid[i][0] += obstacleGrid[i - 1][0];
            } else {
                obstacleGrid[i][0] = 0;
            }
        }
        for (int i = 1; i < column; i++) {
            if (obstacleGrid[0][i] != 1) {
                obstacleGrid[0][i] += obstacleGrid[0][i - 1];
            } else {
                obstacleGrid[0][i] = 0;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[row - 1][column - 1];
    }

    public static void main(String[] args) {
        Assert.assertEquals(0, new LeetCode_63_693().uniquePathsWithObstacles(new int[][]{{1, 0}}));
        Assert.assertEquals(0, new LeetCode_63_693().uniquePathsWithObstacles(new int[][]{{0, 1}}));
        Assert.assertEquals(2, new LeetCode_63_693().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        Assert.assertEquals(0, new LeetCode_63_693().uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
    }
}
