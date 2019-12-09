//300. 最长上升子序列

//解法1：DP		执行用时：17ms
//思路：
public int lengthOfLIS(int[] nums) {
	if (nums.length == 1) return 1;
	int[] dp = new int[nums.length];
	Arrays.fill(dp, 1);
	int res = 0;
	for (int i = 1; i < dp.length; i++) {
		for (int j = 0; j < i; j++) {
			if (nums[i] > nums[j]) {
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		res = Math.max(res, dp[i]);
	}
	return res;
}