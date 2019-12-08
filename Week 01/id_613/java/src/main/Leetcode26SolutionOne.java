/**
 * 发现重复元素，把后面的元素向前挪动，覆盖重复元素
 * 平均时间复杂度O(n^2)，空间复杂度O(1)
 *
 * 未看题解
 *
 * 执行用时 : * 15 ms * , 在所有 java 提交中击败了 * 11.84% * 的用户 *
 * 内存消耗 : * 40.5 MB * , 在所有 java 提交中击败了 * 94.42% * 的用户 *
 */
class Leetcode26SolutionOne {
  public int removeDuplicates(int[] nums) {

    if (nums.length <= 1) {
      return nums.length;
    }

    int len = nums.length;
    for (int i = 0; i < len - 1; ) {
      if (nums[i + 1] == nums[i]) {
        System.arraycopy(nums, i + 1, nums, i, len - i - 1);
        len--;
      } else {
        i++;
      }
    }

    return len;
  }
}