/**
 * @author Leesen
 * @date 2019/11/14 16:17
 * 一个机器人位于一个 m x n 网格的左上角
 * 机器人每次只能向下或者向右移动一步,机器人试图达到网格的右下角
 * 中间无障碍,问总共有多少条不同的路径？
 */
public class UniquePaths_62 {
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            dp[i] = 1;
        }
//        Arrays.fill(dp,1);

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[j] += dp[j-1];
                System.out.println(dp[j]);
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        uniquePaths(3, 2);
    }

    //状态方程思路
    //左上角到右下角走法,等同于右下角到左上角走法
    //原始方程dp[i][j] = dp[i-1][j]+dp[i][j-1]
    //可简化为一维方程 dp[j] = dp[j] + dp[j-1];
}
