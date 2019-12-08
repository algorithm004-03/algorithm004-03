/**
 * 左右指针，左指针指向新数组
 * 平均时间复杂度为O(n)，空间复杂度O(1)
 *
 * 未看题解
 *
 * 执行用时 : * 1 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 : * 38.2 MB * , 在所有 java 提交中击败了 * 98.87% * 的用户
 */
class Leetcode26SolutionTwo {
  public int removeDuplicates(int[] nums) {
    int leftIdx = 0;
    int rightIdx = 0;
    for (; rightIdx < nums.length; ) {
      if (nums[leftIdx] == nums[rightIdx]) {
        rightIdx++;
      } else {
        nums[leftIdx + 1] = (leftIdx + 1 == rightIdx ? nums[leftIdx + 1] : nums[rightIdx]);
        rightIdx++;
        leftIdx++;
      }
    }

    return leftIdx + 1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    Leetcode26SolutionTwo sl = new Leetcode26SolutionTwo();
    int len = sl.removeDuplicates(nums);
    for (int i = 0; i < len; i++) {
      System.out.print(nums[i]);
    }
    System.out.println();
  }
}
