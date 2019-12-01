//213. 打家劫舍II

//解法1：动态规划（一维数组版）		执行用时：0ms
//思路：总体上与198题没太大区别, 二者都是求出每一间屋子偷与不偷获得收益的最大值
//		主要区别在于该题中, 第一间屋子与最后一间屋子相邻, 这就意味着我们需要分别求出：
//			1. 偷第一间屋子, 不偷最后一间屋子获取的最大收益
//			2. 偷最后一间屋子, 不偷第一间屋子获取的最大收益
//		只要取二者中较大值即是答案
//时间复杂度：O(n)
//空间复杂度：O(2n)
public int rob(int[] nums) {
	int length = nums.length;
	if (length == 0) return 0;
	if (length == 1) return nums[0];
	if (length == 2) return Math.max(nums[0], nums[1]);
	int[] dp1 = new int[nums.length - 1];//1 ~ n - 1      
	dp1[0] = nums[0];
	dp1[1] = Math.max(dp1[0], nums[1]);
	for (int i = 2; i < nums.length - 1; i++) {
		dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
	}
	int[] dp2 = new int[nums.length - 1];//2 ~ n
	dp2[0] = nums[1];
	dp2[1] = Math.max(dp2[0], nums[2]);
	for (int i = 3; i < nums.length; i++) {
		dp2[i - 1] = Math.max(dp2[i - 2], nums[i] + dp2[i - 3]);
	}
	return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);
}

//解法1.2：动态规划（变量暂存）		执行用时：0ms
//思路：基于解法1, 申请三个变量分别存储偷n - 2, n - 1, n个房子能获取的最大收益
//时间复杂度：O(n)
//空间复杂度：O(1)
public int rob(int[] nums) {
	if (nums.length == 0 || nums == null) return 0;
	if (nums.length == 1) return nums[0];
	return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), myRob(Arrays.copyOfRange(nums, 1, nums.length)));
}

private int myRob(int[] nums) {
	int prev = 0, temp = 0, curr = 0;
	for (int i : nums) {
		temp = curr;
		curr = Math.max(i + prev, temp);
		prev = temp;
	}
	return curr;
}
