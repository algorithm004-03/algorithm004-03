/**
 * 跳跃游戏
 *
 * 用分治法求解
 *
 * 时间复杂度O(m^n)，m跟数组中数值有关，空间复杂度O(1)
 *
 * leetcode上运行超出时间限制
 */
class Leetcode55SolutionOne {
  public boolean canJump(int[] nums) {
    if (nums.length <= 1) {
      return true;
    }

    return helper(nums, 0, nums.length - 1);
  }

  private boolean helper(int[] nums, int idx, int size) {
    if (size <= 0) {
      return true;
    }

    if (nums[idx] == 0) {
      return false;
    }

    boolean re;
    for (int i = 1; i <= nums[idx]; i++) {
      re = helper(nums, idx + i, size - i);
      if (re) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int nums[] = new int[]{2, 3, 1, 1, 4};
//    int nums[] = new int[]{2, 0, 0};
    Leetcode55SolutionOne solution = new Leetcode55SolutionOne();
    System.out.println(solution.canJump(nums));
  }
}
