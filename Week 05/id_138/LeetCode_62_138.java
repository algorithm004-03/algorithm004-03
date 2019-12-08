import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？
 * @author L
 *
 */
public class LeetCode_62_138 {
	/**
	 * 标准的dp解法，使用二维数组存放结果
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		if(m<=1 || n<=1)
			return 1;
		int[][] dp = new int[m][n];//定义dp状态，数组存放走到dp[i][j]位置的路径总数,0<=i<=m-1;0<=j<=n-1
		for(int i=0;i<m;i++) //初始化dp横坐标对应数组的值
			dp[i][0] = 1;
		for(int j=0;j<n;j++)//初始化dp纵坐标对应数组的值
			dp[0][j] = 1;
		
		//dp 状态方程 dp[i][j] = dp[i-1][j]+dp[i][j-1]
		for(int i=1;i<m;i++) {//此处注意如果是i-1，记得从1开始dp
			for(int j=1;j<n;j++) {//如果是j-1，记得从1开始
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1]; //返回结果值
	}
	
	/**
	 * 针对上述方法优化
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths_solution2(int m, int n) {
		if(m<=1 || n<=1)
			return 1;
		int dp[] = new int[n];//定义一维数组，dp[i]代表从[0][0]到[m,i]的路径数
		Arrays.fill(dp, 1);
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				dp[j] += dp[j-1];
			}
		}
		return dp[n-1];
	}
	
}
