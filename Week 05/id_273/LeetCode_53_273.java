//53. 最大子序和

//解法1：暴力解法		执行用时：105ms
//思路：遍历所有元素, 获取当前元素能够与后面的所有元素组成的子序和中的最大值, 然后返回所有元素子序和最大值中的最大值
//时间复杂度：O(n^2)
//空间复杂度：O(1)
public int maxSubArray(int[] nums) {
	int result = Integer.MIN_VALUE;
	for (int i = 0; i < nums.length; i++) {
		int sum = 0;
		for (int j = i; j < nums.length; j++) {
			sum += nums[j];
			result = Math.max(result, sum);
		}
	}
	return result;
}

//解法2：动态规划	执行用时：1ms
//思路：遍历所有元素, 获取当前元素能够与之前的所有元素组成的子序和最大值, 也就是用之前计算过的最大子序和来推导当前最大子序和
//		例如：[-2,1,-3,4,-1,2,1,-5,4]
//		dp[0] = -2, 前面已经没有元素与其组成子序和
//		dp[1] = dp[0] > 0 ? 1 + dp[0] : 1, 如果dp[0]小于等于0, 与dp[0]组成子序和反而让结果变得更小了, 还不如就以自身作为子序和的起始位置
//		dp[2] = dp[1] > 0 ? -3 + dp[1] : - 3, 如果dp[1]大于0, 那么与dp[1]组成的子序和要比自身作为子序和的结果更大
//		dp[3] = 4, 同理..
//		dp[4] = 3
//		dp[5] = 5
//		....
//		每一步都获取当前元素能够组成的最大子序和, 然后下一个元素观察上一个元素的子序和能否对它产生增益或减益的影响, 如果增益的话, 就与之前的元素组成新的子序和; 减益就以自身作为新的子序和
//		由此可见, 状态方程就是：dp[i] = (dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i])
//		不断迭代后, 返回所有子序和中的最大值即可
public int maxSubArray(int[] nums) {
	int[] dp = new int[nums.length];
	dp[0] = nums[0];
	int max = dp[0];
	for (int i = 1; i < nums.length; i++) {
		dp[i] = (dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i]);
		max = Math.max(max, dp[i]);
	}
	return max;
}