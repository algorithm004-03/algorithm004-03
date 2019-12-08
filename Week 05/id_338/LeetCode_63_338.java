/**
 * @author Leesen
 * @date 2019/11/14 16:17
 * 一个机器人位于一个 m x n 网格的左上角
 * 机器人每次只能向下或者向右移动一步,机器人试图达到网格的右下角
 * 中间有障碍,问总共有多少条不同的路径？
 */
public class UniquePaths_ii_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //自己写的是按照传统的思路:终止条件, 初始化, 重复子问题层处理, 代码冗余度高
        //该题步骤1、2可合并到3中去, 3中就处理了1和2
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        //1. 特殊情况终止判断
        if (m == 1) {
            for (int num : obstacleGrid[0]) {
                if (num == 1) {
                    return 0;
                }
            }
            return 1;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] == 1) {
                    return 0;
                }
            }
            return 1;
        }

        //2. 初始状态设置
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                while (j < n) {
                    dp[j++] = 0;
                }
            } else {
                dp[j] = 1;
            }
        }

        //3. 重复子问题层处理
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {  //此处写的啰嗦
                dp[0] = 0;
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }

    //牛逼写法,要好好总结记忆
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)  //j>0之前没想到
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }


    public static void main(String[] args) {
        int[][] obstacleGrid = new int[2][2];
        obstacleGrid[0][0] = 0;
        obstacleGrid[0][1] = 1;
        obstacleGrid[1][0] = 0;
        obstacleGrid[1][1] = 0;
        uniquePathsWithObstacles(obstacleGrid);
    }


    //状态方程思路
    //左上角到右下角走法,等同于右下角到左上角走法
    //需要在初始化以及每层递归过程中剔除障碍物
}
