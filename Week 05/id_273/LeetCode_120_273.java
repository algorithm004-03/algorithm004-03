//120. 三角形的最小路径和

//解法1：DFS	超时
//思路：我们要获取最顶层节点的最小路径和, 那么就需要通过比较下层相邻的两个节点的最小路径和, 然后选取一个最小值
//		因此可以通过深度优先递归计算上述重复子问题
//时间复杂度：O(2^N)
//空间复杂度：O(2^N)
public int minimumTotal(List<List<Integer>> triangle) {
	int size = triangle.size();
	return recur(triangle, size, 0, 0);
}

private int recur(List<List<Integer>> triangle, int size, int row, int col) {
	if (row == size - 1) return triangle.get(row).get(col);
	int left = recur(triangle, size, row + 1, col);
	int right = recur(triangle, size, row + 1, col + 1);
	return triangle.get(row).get(col) + Math.min(left, right);
}

//解法2：记忆化递归		执行用时：1ms
//思路：基于DFS递归的基础上, 添加一个缓存用于存放每次计算的结果, 避免了重复的计算
//时间复杂度：O(m*n) m=row, n=col
//空间复杂度：O(m*n)
public int minimumTotal(List<List<Integer>> triangle) {
	int size = triangle.size();
	int[][] cache = new int[size][size];
	return recur(triangle, size, 0, 0, cache);
}

private int recur(List<List<Integer>> triangle, int size, int row, int col, int[][] cache) {
	if (cache[row][col] != 0) return cache[row][col];
	else if (row == size - 1) return cache[row][col] = triangle.get(row).get(col);
	int left = recur(triangle, size, row + 1, col, cache);
	int right = recur(triangle, size, row + 1, col + 1, cache);
	return cache[row][col] = Math.min(left, right) + triangle.get(row).get(col);
}

//解法3：动态规划（二维数组版）	执行时间：3ms
//思路：重复子问题：当前节点的最小路径和 = 下一层中相邻两个节点路径长度较小值 + 当前节点的路径长度
//		那么就可以推导出状态方程dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
//		因此可以通过一个二维数组存储每一个节点的最小路径和, 最后返回最顶层节点的最小路径和
//时间复杂度：O(m*n) m=row, n=col
//空间复杂度：O(m*n)
public int minimumTotal(List<List<Integer>> triangle) {
	int row = triangle.size();
	int col = triangle.get(row - 1).size();
	int[][] dp = new int[row][col];
	for (int i = 0; i < col; i++) {
		dp[row - 1][i] = triangle.get(row - 1).get(i);
	}
	for (int i = row - 2; i >= 0; i--) {
		for (int j = 0; j <= i); j++) {
			dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
		}
	}
	return dp[0][0];
}

//解法3.1 动态规划（一维数组版）	执行用时：3ms
//思路：基于解法3, 可以发现每次获取当前节点的最小路径和, 只需要通过下一层的两个相邻节点的最小路径和进行计算
//		那么我们就可以选择只用一个一维数组存储每一层所有节点的最小路径和, 当计算上一层的节点时再根据当前数组中暂存的值进行计算即可
//时间复杂度：O(m*n)
//空间复杂度：O(n)
public int minimumTotal(List<List<Integer>> triangle) {
	int row = triangle.size();
	int col = triangle.get(row - 1).size();
	int[] dp = new int[col];
	for (int i = 0; i < col; i++) {
		dp[i] = triangle.get(row - 1).get(i);
	}
	for (int i = row - 2; i >= 0; i--) {
		for (int j = 0; j <= i; j++) {
			dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
		}
	}
	return dp[0];
}