
class Solution {
  public int removeDuplicates(int[] nums) {
    if (0 == nums.length) return 0;
    int i = 0, j = 1;
    for (; j<nums.length; j++) {
      if (nums[i] != nums[j]) nums[++i] = nums[j];
    }
    return i+1;
  }
  
  public int removeDuplicates_2(int[] nums) {
    int i = 0;
    for (int n : nums)
      if (i==0 || n!=nums[i-1]) nums[i++] = n;
    return i;
  }
}