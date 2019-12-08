class Solution {
  public void rotate(int[] nums, int k) {
    int[] tmp = new int[nums.length];
    for (int i = 0; i < nums.length; i++)
      tmp[(i + k) % nums.length] = nums[i];
    for (int i = 0; i < nums.length; i++)
      nums[i] = tmp[i];
  }
  
  public void rotate_brute_force(int[] nums, int k) {
    int previous, tmp;
    for (int i = 0; i < k; i++) {
      previous = nums[nums.length - 1];
      for (int j = 0; j < nums.length; j++) {
        tmp = nums[j];
        nums[j] = previous;
        previous = tmp;
      }
    }
  }
  
  public void rotate_cyclic_replacement(int[] nums, int k) {
    k %= nums.length;
    int count = 0;
    for (int start = 0; count < nums.length; start++) {
      int current = start;
      int previous = nums[start];
      do {
        int next = (start + k) % nums.length;
        int tmp = nums[next];
        nums[next] = previous;
        previous = tmp;
        current = next;
        count++;
      } while (start != current);
    }
  }
  
  public void rotate_reverse(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, nums.length-1);
  }
  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int tmp = nums[start];
      nums[start++] = nums[end];
      nums[end--] = tmp;
    }
  }
}