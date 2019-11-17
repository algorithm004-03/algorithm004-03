/**
 * 跳跃游戏
 *
 * 两重循环，建立一个boolean数组，每一个位置根据能跳的步数把响应的能到达的位置标记为true，
 * 最后查看最后一个位置是否为true
 *
 * 时间复杂度O(n^2)，空间复杂度O(n)
 *
 * 执行用时 : * 414 ms * , 在所有 java 提交中击败了 * 10.43% * 的用户
 * 内存消耗 : * 41.5 MB * , 在所有 java 提交中击败了 * 72.10% * 的用户
 */
class Leetcode55SolutionTwo {
  public boolean canJump(int[] nums) {
    if (nums.length <= 1) {
      return true;
    }

    boolean[] res = new boolean[nums.length];
    res[0] = true;
    for (int i = 0; i < nums.length; i++) {
      if (!res[i]) {
        continue;
      }

      for (int j = 0; j <= nums[i]; j++) {
        if (i + j < nums.length) {
          res[i + j] = true;
        }
      }
    }

    return res[res.length - 1];
  }

  public static void main(String[] args) {
//    int nums[] = new int[]{2, 3, 1, 1, 4};
    int nums[] = new int[]{2, 0, 0};
    Leetcode55SolutionTwo solution = new Leetcode55SolutionTwo();
    System.out.println(solution.canJump(nums));
  }
}
