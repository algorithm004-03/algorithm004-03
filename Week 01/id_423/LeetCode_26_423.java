
class Solution {
  public int removeDuplicates(int[] nums) {
    if (0 == nums.length) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) { nums[++i] = nums[j];
      }
      return i + 1;
    }
  }