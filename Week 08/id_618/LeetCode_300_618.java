class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int[] dp = new int[nums.length];
		int max = 0;

		for (int i = 0; i < dp.length; i++) {
			int target = nums[i];
			int maxForTarget = 0;

			for (int j = 0; j < i; j++) {
				int current = nums[j];

				if (target > current) {
					maxForTarget = Math.max(maxForTarget, dp[j]);
				}
			}

			dp[i] = maxForTarget + 1;
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}