//63. 不同路径II

//解法1：动态规划（二维数组版）	执行用时：1ms
//思路：在62. 不同路径的基础上增加了障碍物, 也就是机器人在向右或者向下走的过程中, 如果碰到了障碍物, 只能选择另一个方向
//		那么如果是终点的横、竖列中某个格子存在障碍物的话, 那么该格子至终点所连的区域都认为不可达
//		可以通过一个二维数组存储每一个格子当前的路径数, 只需要先判断终点的横竖列中所有方块的路径树, 
//		再根据状态方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 计算其余部分即可
//时间复杂度O(m*n)
//空间复杂度O(m*n)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
	int m = obstacleGrid.length;
	int n = obstacleGrid[0].length;
	int[][] dp = new int[m][n];
	for (int i = 0; i < m; i++) {
		if (obstacleGrid[i][0] == 1) break;
		else dp[i][0] = 1;
	}
	for (int i = 0; i < n; i++) {
		if (obstacleGrid[0][i] == 1) break;
		else dp[0][i] = 1;
	}
	for (int i = 1; i < m; i++) {
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
			else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
		}
	}
	return dp[m - 1][n - 1];
}

//解法1.1：动态规划（一维数组版）	执行用时：0ms
//思路：以62题同样的方式, 我们也可以对1.1版本的代码进行降维
//时间复杂度：O(m*n)
//空间复杂度：O(n)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
	int width = obstacleGrid[0].length;
	int[] dp = new int[width];
	dp[0] = 1;
	for (int[] temp : obstacleGrid) {
		for (int i = 0; i < width; i++) {
			if (temp[i] == 1) dp[i] = 0;
			else if (i > 0) dp[i] += dp[i - 1];
		}
	}
	return dp[width - 1];
}