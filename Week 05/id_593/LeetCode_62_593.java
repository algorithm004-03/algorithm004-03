/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 * @version 2.0
 */
public class LeetCode_62_593 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[m - 1];
    }

    /**
     * 递归实现
     *
     * @param m    列
     * @param n    行
     * @param temp 备忘录作用
     * @return 当前 位置的走法总和
     */
    private int uniquePathsByRecursion(int m, int n, int[][] temp) {
        if (m < 0 || n > 0) {
            return 0;
        }
        if (m + n == 1 || (m == 0 && n == 0)) {
            return 1;
        }
        if (temp[m][n] == 0) {
            temp[m][n] = uniquePathsByRecursion(m - 1, n, temp) + uniquePathsByRecursion(m, n - 1, temp);
        }
        return temp[m][n];
    }

}
