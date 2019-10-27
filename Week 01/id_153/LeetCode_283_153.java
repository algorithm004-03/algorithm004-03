/**
 * LeetCode_283_153
 * 
 * @desc LeetCode 283 题 https://leetcode-cn.com/problems/move-zeroes/
 */
public class LeetCode_283_153 {

  /**
   * 将不为 0 的元素往前挪，然后后面的元素直接赋值为 0 即可
   * 
   * @param nums
   */
  public void moveZeros(int[] nums) {
    int countZero = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[countZero] = nums[i];
        countZero++;
      }
    }

    for (int i = countZero; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}