/**
 * 63. 不同路径 II
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 * @version 1.0
 */
public class LeetCode_63_593 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid[0].length;
        int[] dp = new int[col + 1];
        dp[0] = 1;
        for (int[] ints : obstacleGrid) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] = dp[i - 1] + dp[i];
                }
            }
        }
        return dp[col - 1];
    }


}