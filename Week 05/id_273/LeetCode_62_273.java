//62. 不同路径

//解法1：暴力递归		执行超时
//思路：自顶向下解决问题, 例如3x3的矩阵中, F(3, 3) = F(2, 3) + F(3, 2)
//		由于只能选择向右或向下, 那么终点的横、竖列都只存在一种走法, 所以在m or n = 1时return 1
//时间复杂度：O(2^n)
//空间复杂度：O(1)
public int uniquePaths1(int m, int n) {
	if (m == 1 || n == 1) return 1;
	return uniquePaths1(m, n - 1) + uniquePaths1(m - 1, n);
}

//解法2：记忆化递归		执行用时：1ms
//思路：添加一个二维数组用于存储每一步递归计算的值
//时间复杂度：O(m*n)
//空间复杂度：O(m*n)
public int uniquePaths(int m, int n) {
	int[][] cache = new int[m][n];
	return recur(m, n, cache);
}

private int recur(int m, int n, int[][] cache) {
	if (cache[m - 1][n - 1] != 0) return cache[m - 1][n - 1];
	if (m == 1 || n == 1) return cache[m - 1][n - 1] = 1;
	return cache[m - 1][n - 1] = recur(m - 1, n, cache) + recur(m, n - 1, cache);
}

//解法3：动态规划（二维数组版）		执行用时：1ms
//思路：我们可以用一个二维数组存储途径终点的所有格子所对应的路径数
//		不难发现, 终点的横、竖方向都只能存在一种走法, 因为它们只能选择向右或向左
//		且对于中间任意一个位子的格子, 它的路径 = 下方格子的路径 + 右方格子的路径
//		由此, 以终点坐标为dp[0][0], 状态方程就推导为：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; 
//时间复杂度：O(m*n)
//空间复杂度：O(m*n)
public int uniquePaths(int m, int n) {
	int[][] dp = new int[m][n];
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (i == 0 || j == 0) dp[i][j] = 1;
			else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
		}
	}
	return dp[m - 1][n - 1];
}

//解法1.1：动态规划（一维数组版）	执行用时：1ms
//思路：基于动态规划二维数组解, 我们每次获取dp[i][j]只需要通过当前格子的右方和下方的格子进行计算, 这代表我们只需要一个一维数组暂存当前列的路径数
//		在移动列时, 也就是i++的时候, 一维数组中暂存的列信息中, 计算dp[j]时所依赖的右方和下方的格子正是数组中的dp[j]和dp[j - 1]
//时间复杂度：O(m*n)
//空间复杂度：O(n)
public int uniquePaths(int m, int n) {
	int[] dp = new int[m];
	Arrays.fill(dp, 1);
	for (int i = 1; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (j > 0) dp[j] += dp[j - 1];
		}
	}
	return dp[m - 1];
}
