//70. 爬楼梯

//通过规律可知该题的结果为斐波那契数列
//假设n = 1 ,只能选择跨一步,F(1) = 1
//	  n = 2 ,则只可能从台阶1跨1步,或者直接跨2步 F(2) = 2 
//	  n = 3 ,则只可能从台阶1跨2步,或者从台阶2跨1步 F(3) = F(2) + F(1)
//	  n = 4 ,则只可能从台阶2跨2步,或者从台阶3跨1步 F(4) = F(3) + F(2)
//	  ....	

//解法1：斐波那契数列递归	提交超时
//思路：...
//时间复杂度O(2^n)
public int climbStairs(int n) {
	if (n <= 2) return n;
	return climbStairs(n-1) + climbStairs(n-2);
}

//解法2：记忆化递归		执行用时：0ms
//思路：创建一个缓存数组用于存储每一次递归的结果, 避免了不必要的重复计算
//时间复杂度O(n)
//空间复杂度O(n)
public int climbStairs(int n) {
	int[] cache = new int[n + 1];
	return recur(cache, n);
}

private int recur(int[] cache, int n) {
	if (cache[n] != 0) return cache[n];
	if (n <= 2) return cache[n] = n;
	return cache[n] = recur(cache, n - 1) + recur(cache, n - 2);
}

//解法3：动态规划（一维数组版）		执行用时：0ms
//思路：可以根据重复子问题能够推导出动态规划的状态方程 dp[n] = dp[n - 1] + dp[n - 2], 有了状态方程, 动态规划就会非常简单
//		只需要将每一级台阶要跨的步数采用数组存储, 下一次计算时从数组中获取即可
//时间复杂度O(n)
//空间复杂度O(n)
public int climbStairs(int n) {
	if (n <= 2) return n;
	int[] dp = new int[n];
	dp[0] = 1;
	dp[1] = 2;
	for (int i = 2; i < n; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}
	return dp[n - 1];
}

//解法2.1 动态规划（变量暂存版）		执行用时：0ms
//思路：由于动态规划方法每次都只需要操作三个变量, 因此将数组赋值操作简化为变量之间的赋值操作
//时间复杂度O(n)
//空间复杂度O(1)
public int climbStairs(int n) {
	if (n <= 2) return n;
	int prev = 1, temp = 2, curr = 0;
	for (int i = 3; i <= n; i++) {
		curr = temp + prev;
		prev = temp;
		temp = curr;    
	}
	return curr;
}


