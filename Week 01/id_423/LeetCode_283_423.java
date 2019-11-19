class Solution {
  
  public void moveZeroes(int[] nums) {
    int count_zero = 0;
    for (int i = 0; i < nums.length; i++)
      if (0 == nums[i]) count_zero++;
    ArrayList<Integer> array = new ArrayList<>(nums.length);
    for (int i = 0; i < nums.length; i++)
      if (0!=nums[i]) array.add(nums[i]);
    while(0 < count_zero--)
      array.add(0);
    for (int i = 0; i < nums.length; i++)
      nums[i] = array.get(i);
  }
  
  public void moveZeroes(int[] nums) {
    int p = 0;
    for (int i = 0; i < nums.length; i++)
      if (0 != nums[i]) nums[p++] = nums[i];
    for (int i = p; i < nums.length; i++)
      nums[i] = 0;
  }
  
  public void moveZeroes(int[] nums) {
    for (int p = 0,i = 0; i < nums.length; i++){
      if (0 != nums[i]) {
        int tmp = nums[p];
        nums[p++] = nums[i];
        nums[i] = tmp;
      }
    }
  }
}