/**
 * 打家劫舍
 *
 * 1、定义子问题：定义f(i)为从0 - i间房屋偷盗能获得的最大金额，并且第i间房屋要偷
 * 2、状态数组：f(i)
 * 3、DP方程：f(i) = max(f(i-1)， f(i-2) + num[i])
 * 初始值：f(-1) == 0，f(0) == nums[0]
 *
 * 时间复杂度O(n)，空间复杂度O(n)
 *
 * 执行用时 : * 0 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 : * 33.9 MB * , 在所有 java 提交中击败了 * 90.50% * 的用户
 */
class Leetcode198SolutionOne {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    int[] dp = nums.clone();
    int maxValue = 0;
    for (int i = 1; i < nums.length; i++) {
      if (i - 2 == -1) {
        dp[i] = Math.max(dp[i - 1], nums[i]); // 0 + nums[i] --> nums[i]
      } else {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      }
      maxValue = Math.max(dp[i], maxValue);
    }

    //System.out.println(Arrays.toString(dp));
    return maxValue;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 1};
    Leetcode198SolutionOne solution = new Leetcode198SolutionOne();
    System.out.println(solution.rob(nums));
  }
}
