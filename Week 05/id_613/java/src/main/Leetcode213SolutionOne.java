import java.util.Arrays;

/**
 * 打家劫舍II
 *
 * 时间复杂度O(n)，空间复杂度O(n)
 */
class Leetcode213SolutionOne {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    return Math.max(_rob(Arrays.copyOfRange(nums, 1, nums.length)),
            _rob(Arrays.copyOfRange(nums, 0, nums.length - 1)));
  }

  public int _rob(int[] nums) {
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
    Leetcode213SolutionOne solution = new Leetcode213SolutionOne();
    System.out.println(solution.rob(nums));
  }
}
