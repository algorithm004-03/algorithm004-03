//152. 乘积的最大子序列

//解法1：动态规划（二维数组版）
//思路：因为是两数相乘, 所以会出现负负得正这种情况, 因此在53题的基础上, 还需要保存当前元素的能与之前的元素组成的最小序列
//		在判断乘积最大子序列时, 需要先观察当前元素是否为负数：
//			1. 若是负数, 则交换dp[i - 1][0]与[i - 1][1], 以保证nums[i]能够乘一个最小值从而获得一个正数
//			2. 若是正数, 则与dp[i - 1][0]相乘, 观察结果是否大于result
//时间复杂度：O(n)
//空间复杂度：O(2n)
public int maxProduct(int[] nums) {
	int[][] dp = new int[nums.length][2];
	dp[0][0] = nums[0];
	dp[0][1] = nums[0];
	int result = dp[0][0];
	for (int i = 1; i < nums.length; i++) {
		if (nums[i] < 0) {
			int temp = dp[i - 1][0]; dp[i - 1][0] = dp[i - 1][1]; dp[i - 1][1] = temp;
		}
		dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
		dp[i][1] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
		result = Math.max(result, dp[i][0]);
	}
	return result;
}

//解法1.1：动态规划（变量暂存版）	执行用时：2ms
//思路：发现上一个解法中推导当前元素的最大乘积子序列所用到的变量就只有当前元素和上一个元素的最大最小值
//		因此可以用2个变量imax, imin替代
//时间复杂度：O(n)
//空间复杂度：O(1)
public int maxProduct(int[] nums) {
	int imax = 1;
	int imin = 1;
	int result = Integer.MIN_VALUE;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] < 0) {
			int temp = imax; imax = imin; imin = temp;
		}
		imax = Math.max(nums[i], imax * nums[i]);
		imin = Math.min(nums[i], imin * nums[i]);
		result = Math.max(imax, result);
	}
	return result;
}